class LibraryMember {
    String memberId;
    int borrowLimit;
    int booksBorrowed;

    LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    void displayInfo() {
        System.out.println("General Member | Books Borrowed: " + booksBorrowed);
    }
}

class StudentMember extends LibraryMember {
    String course;

    StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    void displayInfo() {
        System.out.println("Student Member | Course: " + course + " | Books Borrowed: " + booksBorrowed);
    }
}

class HonorsStudentMember extends StudentMember {
    int bonusLimit;

    HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    void displayInfo() {
        System.out.println("Honors Student Member | Course: " + course +
                " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + booksBorrowed);
    }
}

class FacultyMember extends LibraryMember {
    String department;

    FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    void displayInfo() {
        System.out.println("Faculty Member | Department: " + department +
                " | Books Borrowed: " + booksBorrowed);
    }
}

public class P2 {
    static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof StudentMember) {
            return "Direct subclass (2 generations deep)";
        } else {
            return "Base class";
        }
    }

    static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;

        for (LibraryMember member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }

    public static void main(String[] args) {
        LibraryMember l = new LibraryMember("STU1", 3);
        StudentMember s = new StudentMember("STU2", 3, "CSE");
        HonorsStudentMember h = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember f = new FacultyMember("STU4", 5, "Physics");

        l.displayInfo();
        s.displayInfo();
        h.displayInfo();
        f.displayInfo();

        System.out.println(classifyGeneration(h));
        System.out.println(classifyGeneration(f));

        s.borrowBook();
        s.borrowBook();

        h.borrowBook();

        f.borrowBook();
        f.borrowBook();
        f.borrowBook();

        LibraryMember[] members = {s, h, f};

        System.out.println(getTotalBooksBorrowed(members));
    }
}