abstract class Account {
    String id;
    double balance;

    Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    abstract void withdraw(double amount);
}

class Savings extends Account {

    Savings(String id, double balance) {
        super(id, balance);
    }

    void withdraw(double amount) {
        if (balance - amount < 1000) {
            System.out.println(id + " rejected: minimum balance 1000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + (int) balance);
        }
    }
}

class Current extends Account {

    Current(String id, double balance) {
        super(id, balance);
    }

    void withdraw(double amount) {
        if (balance - amount < -5000) {
            System.out.println(id + " rejected: overdraft limit 5000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + (int) balance);
        }
    }
}

public class BankAccountWithdrawalSystem {

    public static void main(String[] args) {
        Account[] accounts = {
            new Savings("S1", 5000),
            new Current("C1", 2000)
        };

        accounts[0].withdraw(4500);
        accounts[1].withdraw(6000);
        accounts[0].withdraw(3000);
        accounts[1].withdraw(2000);
    }
}