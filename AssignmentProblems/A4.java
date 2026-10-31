class GymMember {
    int sessionsAttended;

    GymMember(String memberId, int monthlyFee) {
        sessionsAttended = 0;
    }

    String displayInfo() {
        return "Standard | Sessions: " + sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    String displayInfo() {
        return "Premium | Trainer: " + trainerName +
                " | Sessions: " + sessionsAttended;
    }
}

public class A4 {
    static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();

        for (GymMember member : members) {
            sb.append(member.displayInfo());

            if (member instanceof PremiumMember) {
                PremiumMember p = (PremiumMember) member;

                sb.append(" [Trainer via downcast: ")
                  .append(p.trainerName)
                  .append("]");
            }

            sb.append(" | ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}