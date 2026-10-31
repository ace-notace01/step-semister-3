class LibraryMember {
    int booksBorrowed;

    LibraryMember(String memberId, int borrowLimit) {
        booksBorrowed = 0;
    }

    String displayInfo() {
        return "General | Books: " + booksBorrowed;
    }
}

class StudentMember extends LibraryMember {
    String course;

    StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    String displayInfo() {
        return "Student | Course: " + course + " | Books: " + booksBorrowed;
    }
}

public class P4 {
    static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();

        for (LibraryMember member : members) {
            sb.append(member.displayInfo());

            if (member instanceof StudentMember) {
                StudentMember s = (StudentMember) member;

                sb.append(" [Course via downcast: ")
                  .append(s.course)
                  .append("]");
            }

            sb.append(" | ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}