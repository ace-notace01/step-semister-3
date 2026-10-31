import java.util.ArrayList;

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment initiated via Credit Card.");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment initiated via PayPal.");
        return false;
    }
}

class BankTransferPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment initiated via Bank Transfer.");
        return true;
    }
}

class Order {
    Customer customer;
    ArrayList<Product> products = new ArrayList<>();
    private String status = "Pending";

    Order(Customer customer) {
        this.customer = customer;
        System.out.println("Order created for " + customer.name + ".");
    }

    void addProduct(Product product) {
        products.add(product);
    }

    double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.price;
        }

        return total;
    }

    String getStatus() {
        return status;
    }

    void makePayment(PaymentMethod method) {
        if (products.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        boolean success = method.processPayment(calculateTotal());

        if (success) {
            status = "Paid";
            System.out.println("Payment successful.");
        } else {
            System.out.println("Payment failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Customer x = new Customer("Customer X");
        Customer y = new Customer("Customer Y");
        Customer z = new Customer("Customer Z");

        Order orderX = new Order(x);

        orderX.addProduct(new Product("Product A", 500));
        orderX.addProduct(new Product("Product B", 300));

        orderX.makePayment(new CreditCardPayment());

        Order orderY = new Order(y);

        orderY.makePayment(new CreditCardPayment());

        Order orderZ = new Order(z);

        orderZ.addProduct(new Product("Product C", 200));

        orderZ.makePayment(new PayPalPayment());
    }
}