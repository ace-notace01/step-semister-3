import java.util.ArrayList;

interface NotificationChannel {
    void send(String studentName, String message);
}

class EmailChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[Email → " + studentName + "] " + message);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[SMS → " + studentName + "] " + message);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[App → " + studentName + "] " + message);
    }
}

class Student {
    String name;
    String department;

    ArrayList<NotificationChannel> channels = new ArrayList<>();

    Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}

class Notice {
    String title;
    ArrayList<String> departments = new ArrayList<>();

    Notice(String title, ArrayList<String> departments) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Notice title is required.");
        }

        if (departments == null || departments.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one target department is required.");
        }

        this.title = title;
        this.departments.addAll(departments);
    }

    boolean targetsDepartment(String department) {
        return departments.contains(department);
    }
}

class NoticeBoard {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    void postNotice(Notice notice) {
        System.out.println("Notice '" + notice.title
                + "' posted to " + String.join(", ", notice.departments) + ".");

        for (Student student : students) {
            if (notice.targetsDepartment(student.department)) {
                for (NotificationChannel channel : student.channels) {
                    channel.send(student.name, notice.title);
                }
            }
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student asha = new Student("Asha", "CSE");
        Student ravi = new Student("Ravi", "ECE");

        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        ravi.addChannel(new SmsChannel());

        board.addStudent(asha);
        board.addStudent(ravi);

        ArrayList<String> cse = new ArrayList<>();
        cse.add("CSE");

        ArrayList<String> both = new ArrayList<>();
        both.add("CSE");
        both.add("ECE");

        Notice n1 = new Notice("Lab Closed Tomorrow", cse);
        Notice n2 = new Notice("Fee Deadline Extended", both);

        board.postNotice(n1);
        board.postNotice(n2);

        try {
            Notice n3 = new Notice("Sports Day", new ArrayList<>());
            board.postNotice(n3);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot post notice: "
                    + e.getMessage());
        }
    }
}