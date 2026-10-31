import java.util.ArrayList;

abstract class Vehicle {
    String vehicleId;
    boolean available = true;

    Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    abstract double calculateCharge(int days);

    boolean isAvailable() {
        return available;
    }

    void setAvailable(boolean available) {
        this.available = available;
    }
}

class Sedan extends Vehicle {
    Sedan(String id) {
        super(id);
    }

    @Override
    double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    SUV(String id) {
        super(id);
    }

    @Override
    double calculateCharge(int days) {
        return days * 80;
    }
}

class Truck extends Vehicle {
    Truck(String id) {
        super(id);
    }

    @Override
    double calculateCharge(int days) {
        return days * 100;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Customer customer;
    Vehicle vehicle;
    int days;

    Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    double getTotalCharge() {
        return vehicle.calculateCharge(days);
    }
}

class RentalSystem {
    ArrayList<Rental> rentals = new ArrayList<>();

    void rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.vehicleId + " is currently unavailable.");
            return;
        }

        Rental rental = new Rental(customer, vehicle, days);
        rentals.add(rental);
        vehicle.setAvailable(false);

        System.out.println(vehicle.vehicleId + " rented successfully by " + customer.name);
        System.out.println("Rental charge: $" + rental.getTotalCharge());
    }

    void returnVehicle(Customer customer, Vehicle vehicle) {
        for (Rental rental : rentals) {
            if (rental.customer == customer &&
                rental.vehicle == vehicle) {

                rentals.remove(rental);
                vehicle.setAvailable(true);

                System.out.println(vehicle.vehicleId + " returned by " + customer.name);
                return;
            }
        }
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");

        system.rentVehicle(c1, sedan, 3);
        system.rentVehicle(c2, sedan, 2);

        system.returnVehicle(c1, sedan);

        system.rentVehicle(c3, suv, 5);
    }
}