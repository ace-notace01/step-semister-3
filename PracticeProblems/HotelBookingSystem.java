import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

abstract class Room {
    int roomNumber;

    Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    abstract double calculatePrice(int days);

    abstract String getCategory();
}

class StandardRoom extends Room {
    StandardRoom(int number) {
        super(number);
    }

    @Override
    double calculatePrice(int days) {
        return days * 100;
    }

    @Override
    String getCategory() {
        return "Standard Room";
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int number) {
        super(number);
    }

    @Override
    double calculatePrice(int days) {
        return days * 200;
    }

    @Override
    String getCategory() {
        return "Deluxe Room";
    }
}

class Suite extends Room {
    Suite(int number) {
        super(number);
    }

    @Override
    double calculatePrice(int days) {
        return days * 350;
    }

    @Override
    String getCategory() {
        return "Suite";
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Customer customer;
    Room room;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate cancellationDeadline;
    boolean active = true;

    Reservation(Customer customer, Room room,
                LocalDate start, LocalDate end) {
        this.customer = customer;
        this.room = room;
        startDate = start;
        endDate = end;
        cancellationDeadline = start.minusDays(1);
    }

    double getPrice() {
        int days = (int) ChronoUnit.DAYS.between(startDate, endDate);
        return room.calculatePrice(days);
    }
}

class Hotel {
    ArrayList<Reservation> reservations = new ArrayList<>();

    boolean isAvailable(Room room, LocalDate start, LocalDate end) {
        for (Reservation r : reservations) {
            if (r.room == room && r.active &&
                start.isBefore(r.endDate) &&
                end.isAfter(r.startDate)) {
                return false;
            }
        }

        return true;
    }

    void bookRoom(Customer customer, Room room,
                  LocalDate start, LocalDate end) {

        if (!start.isBefore(end)) {
            System.out.println("Invalid reservation dates.");
            return;
        }

        if (!isAvailable(room, start, end)) {
            System.out.println(room.getCategory() + " "
                    + room.roomNumber + " is not available.");
            return;
        }

        Reservation r = new Reservation(customer, room, start, end);
        reservations.add(r);

        System.out.println("Reservation confirmed for "
                + customer.name + ", " + room.getCategory()
                + " " + room.roomNumber + ".");

        System.out.println("Price: $" + r.getPrice());
    }

    void cancelReservation(Reservation r, LocalDate today) {
        if (!r.active) {
            System.out.println("Reservation already cancelled.");
            return;
        }

        if (!today.isBefore(r.cancellationDeadline)) {
            System.out.println("Cancellation deadline has passed.");
            return;
        }

        r.active = false;

        System.out.println("Reservation for " + r.customer.name
                + " cancelled successfully.");
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Customer a = new Customer("Customer A");
        Customer b = new Customer("Customer B");
        Customer c = new Customer("Customer C");

        Room standard = new StandardRoom(101);
        Room deluxe = new DeluxeRoom(201);

        LocalDate start1 = LocalDate.of(2026, 1, 1);
        LocalDate end1 = LocalDate.of(2026, 1, 5);

        System.out.println(hotel.isAvailable(
                standard, start1, end1)
                ? "Standard Room 101 is available."
                : "Room unavailable.");

        hotel.bookRoom(a, standard, start1, end1);

        hotel.bookRoom(b, standard,
                LocalDate.of(2026, 1, 3),
                LocalDate.of(2026, 1, 7));

        Reservation reservation = hotel.reservations.get(0);

        hotel.cancelReservation(reservation,
                LocalDate.of(2025, 12, 20));

        hotel.bookRoom(c, deluxe,
                LocalDate.of(2026, 2, 10),
                LocalDate.of(2026, 2, 12));
    }
}