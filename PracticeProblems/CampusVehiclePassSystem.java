import java.util.HashMap;

abstract class Vehicle {
    String passNumber;
    String owner;
    String type;
    int fee;

    Vehicle(String passNumber, String owner, String type, int fee) {
        this.passNumber = passNumber;
        this.owner = owner;
        this.type = type;
        this.fee = fee;
    }

    void displayPass() {
        System.out.println(passNumber + " (" + type + ") pass fee " + fee);
    }
}

interface Chargeable {
    void bookChargingBay();
}

class Bike extends Vehicle {

    Bike(String passNumber, String owner) {
        super(passNumber, owner, "Bike", 300);
    }
}

class Car extends Vehicle {

    Car(String passNumber, String owner) {
        super(passNumber, owner, "Car", 1000);
    }
}

class EBike extends Vehicle implements Chargeable {

    EBike(String passNumber, String owner) {
        super(passNumber, owner, "EBike", 300);
    }

    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

class ECar extends Vehicle implements Chargeable {

    ECar(String passNumber, String owner) {
        super(passNumber, owner, "ECar", 1000);
    }

    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class CampusVehiclePassSystem {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicles = new HashMap<>();

        Vehicle v1 = new Bike("KA01", "Asha");
        Vehicle v2 = new ECar("KA02", "Ravi");

        vehicles.put(v1.passNumber, v1);
        vehicles.put(v2.passNumber, v2);

        v1.displayPass();
        v2.displayPass();

        chargeVehicle(vehicles, "KA02");
        chargeVehicle(vehicles, "KA01");
    }

    static void chargeVehicle(HashMap<String, Vehicle> vehicles, String passNumber) {
        Vehicle vehicle = vehicles.get(passNumber);

        if (vehicle == null) {
            System.out.println("Vehicle not found");
        } else if (vehicle instanceof Chargeable) {
            ((Chargeable) vehicle).bookChargingBay();
        } else {
            System.out.println(passNumber + " rejected: charging unsupported");
        }
    }
}