import java.time.LocalDate;

abstract class Assignment {
    String title;
    int maxMarks;
    LocalDate dueDate;

    Assignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    abstract double applyPenalty(int marks, long lateDays);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    @Override
    double applyPenalty(int marks, long lateDays) {
        return marks * Math.max(0, 1 - 0.10 * lateDays);
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    @Override
    double applyPenalty(int marks, long lateDays) {
        return marks * Math.max(0, 1 - 0.20 * lateDays);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Submission {
    Student student;
    Assignment assignment;
    LocalDate submissionDate;
    private String status = "Submitted";

    Submission(Student student, Assignment assignment,
               LocalDate submissionDate) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
    }

    String getStatus() {
        return status;
    }

    void grade(int awardedMarks) {
        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade this submission again.");
            return;
        }

        if (awardedMarks < 0 || awardedMarks > assignment.maxMarks) {
            System.out.println("Invalid marks.");
            return;
        }

        long lateDays = Math.max(0,
                java.time.temporal.ChronoUnit.DAYS.between(
                        assignment.dueDate, submissionDate));

        double finalMarks = assignment.applyPenalty(awardedMarks, lateDays);

        status = "Graded";

        System.out.println(student.name + " graded: "
                + (int) finalMarks + "/" + assignment.maxMarks);

        if (lateDays > 0) {
            double penalty = lateDays * (assignment instanceof CodingAssignment
                    ? 10 : 20);

            System.out.println("After " + (int) penalty + "% late penalty.");
        }

        System.out.println("Status: " + status);
    }

    void resubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" + assignment.title
                    + "' has already been graded.");
        }
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding = new CodingAssignment(
                "Linked List Lab", 50,
                LocalDate.of(2026, 3, 10));

        Assignment written = new WrittenAssignment(
                "Design Essay", 50,
                LocalDate.of(2026, 3, 12));

        Submission s1 = new Submission(
                asha, coding, LocalDate.of(2026, 3, 10));

        Submission s2 = new Submission(
                ravi, written, LocalDate.of(2026, 3, 14));

        System.out.println("Asha's submission for 'Linked List Lab' received (on time).");
        System.out.println("Status: " + s1.getStatus());

        System.out.println("Ravi's submission for 'Design Essay' received (2 days late).");
        System.out.println("Status: " + s2.getStatus());

        s1.grade(45);
        s2.grade(40);

        s1.resubmit();
    }
}