abstract class Staff {
    String name;
    String type;

    Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract int calculatePay();

    void displayPayslip() {
        System.out.println("Payslip[name=" + name +
            ", type=" + type +
            ", pay=" + calculatePay() + "]");
    }
}

class FullTime extends Staff {
    int salary;

    FullTime(String name, int salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    int calculatePay() {
        return salary;
    }
}

class PartTime extends Staff {
    int hours;
    int rate;

    PartTime(String name, int hours, int rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    int calculatePay() {
        return hours * rate;
    }
}

class Intern extends Staff {
    int stipend;

    Intern(String name, int stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    int calculatePay() {
        return stipend;
    }
}

public class PayrollRegisterSystem {

    public static void main(String[] args) {
        Staff[] staff = {
            new FullTime("Asha", 50000),
            new PartTime("Ravi", 80, 300),
            new Intern("Neha", 15000)
        };

        int total = 0;
        int maxPay = 0;
        String topEarner = "";

        for (Staff s : staff) {
            s.displayPayslip();

            int pay = s.calculatePay();
            total += pay;

            if (pay > maxPay) {
                maxPay = pay;
                topEarner = s.name;
            }
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + topEarner);
    }
}
