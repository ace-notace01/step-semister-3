import java.util.Arrays;

class LibraryMember {
    private int[] fineHistory = new int[10];
    private int fineCount = 0;
    private int totalFine = 0;

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
            totalFine += amount;
        }
    }

    int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    int getTotalFine() {
        return totalFine;
    }
}

class StudentMember extends LibraryMember {
    String course;

    StudentMember(String memberId, int borrowLimit, String course) {
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class P3 {
    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");

        s.chargeFine(100);

        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();

        history[0] = 999;

        System.out.println(Arrays.toString(s.getFineHistory()));
    }
}