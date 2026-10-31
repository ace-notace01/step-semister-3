interface MembershipPlan {
    double calculateFee();
    int getDuration();
    String getPlanName();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 1000;
    }

    public int getDuration() {
        return 1;
    }

    public String getPlanName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 3000 * 0.90;
    }

    public int getDuration() {
        return 3;
    }

    public String getPlanName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() {
        return 12000 * 0.75;
    }

    public int getDuration() {
        return 12;
    }

    public String getPlanName() {
        return "Annual";
    }
}

class Member {
    String name;

    Member(String name) {
        this.name = name;
    }
}

class Membership {
    Member member;
    MembershipPlan plan;
    private String status = "Active";

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;

        System.out.println(plan.getPlanName()
                + " membership created for " + member.name + ".");

        System.out.printf("Fee: ₹%.2f%n", plan.calculateFee());
        System.out.println("Status: " + status);
    }

    String getStatus() {
        return status;
    }

    void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member.name + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member.name
                    + "'s membership is " + status + ".");
        }
    }

    void freeze() {
        if (status.equals("Expired")) {
            System.out.println("Cannot freeze an Expired membership.");
            return;
        }

        if (status.equals("Frozen")) {
            System.out.println("Membership is already Frozen.");
            return;
        }

        status = "Frozen";

        System.out.println(member.name + "'s membership frozen.");
        System.out.println("Status: " + status);
    }

    void unfreeze() {
        if (status.equals("Expired")) {
            System.out.println("Cannot unfreeze an Expired membership.");
            return;
        }

        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member.name + "'s membership unfrozen.");
        }
    }

    void expire() {
        status = "Expired";

        System.out.println(member.name + "'s membership expired.");
        System.out.println("Status: " + status);
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership m1 = new Membership(asha, new QuarterlyPlan());
        Membership m2 = new Membership(ravi, new MonthlyPlan());

        m1.checkIn();

        m1.freeze();

        m1.checkIn();

        m2.expire();

        m2.freeze();
    }
}