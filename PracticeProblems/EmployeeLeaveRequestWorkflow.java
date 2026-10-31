abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract boolean canApplyLeave(int days);
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }

    @Override
    boolean canApplyLeave(int days) {
        return days <= 30;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }

    @Override
    boolean canApplyLeave(int days) {
        return days <= 15;
    }
}

class LeaveRequest {
    private String startDate;
    private String endDate;
    private String status;
    private Employee employee;
    private int days;

    LeaveRequest(Employee employee, String startDate,
                 String endDate, int days) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        status = "Pending";
    }

    String getStatus() {
        return status;
    }

    void review(String decision) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from "
                    + status + " to " + decision);
            return;
        }

        if (decision.equals("Approved") || decision.equals("Rejected")) {
            status = decision;

            System.out.println(employee.name + "'s leave request ("
                    + startDate + "-" + endDate + ") "
                    + decision.toLowerCase() + ".");

            System.out.println("Status: " + status);
        }
    }
}

class LeaveManager {
    void submitRequest(Employee employee, String start,
                       String end, int days) {

        if (!employee.canApplyLeave(days)) {
            System.out.println("Leave request rejected: Policy limit exceeded.");
            return;
        }

        LeaveRequest request = new LeaveRequest(employee, start, end, days);

        System.out.println("Leave request submitted for " + employee.name
                + " (" + start + "-" + end + ").");

        System.out.println("Status: " + request.getStatus());

        requests.add(request);
    }

    java.util.ArrayList<LeaveRequest> requests = new java.util.ArrayList<>();
}

public class EmployeeLeaveRequestWorkflow {
    public static void main(String[] args) {
        LeaveManager manager = new LeaveManager();

        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        manager.submitRequest(john, "Jan 1", "Jan 5", 5);
        manager.requests.get(0).review("Approved");

        manager.submitRequest(jane, "Feb 10", "Feb 11", 2);
        manager.requests.get(1).review("Rejected");

        manager.requests.get(0).review("Pending");
    }
}
