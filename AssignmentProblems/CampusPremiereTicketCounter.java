import java.util.ArrayList;

abstract class Seat {
    String seatId;

    Seat(String seatId) {
        this.seatId = seatId;
    }

    abstract double getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String id) {
        super(id);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {
    PremiumSeat(String id) {
        super(id);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String id) {
        super(id);
    }

    double getPrice() {
        return 400;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Show {
    String showName;
    boolean started = false;
    ArrayList<Seat> bookedSeats = new ArrayList<>();

    Show(String showName) {
        this.showName = showName;
    }

    boolean isAvailable(Seat seat) {
        for (Seat s : bookedSeats) {
            if (s.seatId.equals(seat.seatId)) {
                return false;
            }
        }

        return true;
    }

    boolean bookSeats(ArrayList<Seat> seats) {
        if (seats.isEmpty() || seats.size() > 6) {
            System.out.println("Booking must contain 1 to 6 seats.");
            return false;
        }

        for (int i = 0; i < seats.size(); i++) {
            if (!isAvailable(seats.get(i))) {
                System.out.println("Seat " + seats.get(i).seatId
                        + " is already booked for this show.");
                return false;
            }

            for (int j = i + 1; j < seats.size(); j++) {
                if (seats.get(i).seatId.equals(seats.get(j).seatId)) {
                    System.out.println("Duplicate seat selected.");
                    return false;
                }
            }
        }

        bookedSeats.addAll(seats);
        return true;
    }

    void releaseSeats(ArrayList<Seat> seats) {
        bookedSeats.removeAll(seats);
    }
}

class Booking {
    Customer customer;
    Show show;
    ArrayList<Seat> seats;
    boolean active = true;

    Booking(Customer customer, Show show, ArrayList<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
    }

    double getTotal() {
        double total = 0;

        for (Seat seat : seats) {
            total += seat.getPrice();
        }

        return total;
    }

    void cancel() {
        if (!active) {
            System.out.println("Booking already cancelled.");
            return;
        }

        if (show.started) {
            System.out.println("Cannot cancel after the show starts.");
            return;
        }

        show.releaseSeats(seats);
        active = false;

        System.out.println(customer.name + "'s booking cancelled.");
    }
}

class TicketCounter {
    Booking book(Customer customer, Show show, ArrayList<Seat> seats) {
        if (show.started) {
            System.out.println("Booking closed: Show already started.");
            return null;
        }

        if (!show.bookSeats(seats)) {
            return null;
        }

        Booking booking = new Booking(customer, show, seats);

        System.out.print("Booking confirmed for " + customer.name + ": ");

        for (Seat seat : seats) {
            System.out.print(seat.seatId + " ");
        }

        System.out.printf("%nTotal: ₹%.2f%n", booking.getTotal());

        return booking;
    }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        Show show = new Show("7 PM Show");

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        ArrayList<Seat> seatsA = new ArrayList<>();

        seatsA.add(new RegularSeat("A1"));
        seatsA.add(new RegularSeat("A2"));
        seatsA.add(new PremiumSeat("F5"));

        Booking bookingA = counter.book(asha, show, seatsA);

        ArrayList<Seat> seatsB = new ArrayList<>();
        seatsB.add(new RegularSeat("A2"));

        counter.book(ravi, show, seatsB);

        ArrayList<Seat> seatsC = new ArrayList<>();
        seatsC.add(new ReclinerSeat("R1"));

        counter.book(ravi, show, seatsC);

        bookingA.cancel();

        ArrayList<Seat> seatsD = new ArrayList<>();
        seatsD.add(new RegularSeat("A2"));

        counter.book(neha, show, seatsD);
    }
}