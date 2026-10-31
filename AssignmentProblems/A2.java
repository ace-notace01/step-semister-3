class GymMember {
    String memberId;
    int monthlyFee;
    int sessionsAttended;

    GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        sessionsAttended = 0;
    }

    void attendSession() {
        sessionsAttended++;
    }

    int getSessionsAttended() {
        return sessionsAttended;
    }

    void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessionsAttended);
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    void displayInfo() {
        System.out.println("Premium Member | Trainer: " + trainerName +
                " | Sessions: " + sessionsAttended);
    }
}

class EliteMember extends PremiumMember {
    String lockerNumber;

    EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    void displayInfo() {
        System.out.println("Elite Member | Trainer: " + trainerName +
                " | Locker: " + lockerNumber +
                " | Sessions: " + sessionsAttended);
    }
}

class GroupClassMember extends GymMember {
    String className;

    GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    void displayInfo() {
        System.out.println("Group Class Member | Class: " + className +
                " | Sessions: " + sessionsAttended);
    }
}

public class A2 {
    static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof PremiumMember) {
            return "Direct subclass (2 generations deep)";
        } else {
            return "Base class";
        }
    }

    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;

        for (GymMember member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }

    public static void main(String[] args) {
        GymMember g = new GymMember("MEM1", 1000);
        PremiumMember p = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember e = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember c = new GroupClassMember("MEM4", 1500, "Zumba");

        g.displayInfo();
        p.displayInfo();
        e.displayInfo();
        c.displayInfo();

        System.out.println(classifyGeneration(e));
        System.out.println(classifyGeneration(c));

        p.attendSession();
        p.attendSession();
        p.attendSession();

        e.attendSession();
        e.attendSession();

        c.attendSession();
        c.attendSession();
        c.attendSession();
        c.attendSession();

        GymMember[] members = {p, e, c};

        System.out.println(getTotalSessionsAttended(members));
    }
}