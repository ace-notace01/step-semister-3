import java.util.ArrayList;

abstract class Question {
    int questionNumber;
    int marks;

    Question(int questionNumber, int marks) {
        this.questionNumber = questionNumber;
        this.marks = marks;
    }

    abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    String correctAnswer;

    MultipleChoiceQuestion(int number, String answer, int marks) {
        super(number, marks);
        correctAnswer = answer;
    }

    @Override
    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    String correctAnswer;

    TrueFalseQuestion(int number, String answer, int marks) {
        super(number, marks);
        correctAnswer = answer;
    }

    @Override
    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class ShortAnswerQuestion extends Question {
    String correctAnswer;

    ShortAnswerQuestion(int number, String answer, int marks) {
        super(number, marks);
        correctAnswer = answer;
    }

    @Override
    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Examination {
    String examName;
    ArrayList<Question> questions = new ArrayList<>();

    Examination(String examName) {
        this.examName = examName;
    }

    void addQuestion(Question question) {
        questions.add(question);
    }
}

class Attempt {
    Student student;
    Examination examination;
    ArrayList<String> answers = new ArrayList<>();
    boolean submitted = false;

    Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
    }

    void recordAnswer(String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }

        answers.add(answer);

        System.out.println("Answer recorded for Question " + answers.size());
    }

    void submit() {
        if (submitted) {
            return;
        }

        submitted = true;

        System.out.println(examination.examName
                + " submitted by " + student.name + ".");

        int total = 0;
        int maximum = 0;

        for (int i = 0; i < examination.questions.size(); i++) {
            Question q = examination.questions.get(i);
            maximum += q.marks;

            if (i < answers.size() && q.evaluate(answers.get(i))) {
                total += q.marks;

                System.out.println("Question " + q.questionNumber
                        + ": Correct (" + q.marks + " points)");
            } else {
                System.out.println("Question " + q.questionNumber
                        + ": Incorrect (0 points)");
            }
        }

        System.out.println("Total score: " + total + "/" + maximum);
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Student student = new Student("Student 1");

        Examination exam = new Examination("Exam A");

        exam.addQuestion(new MultipleChoiceQuestion(1, "B", 5));
        exam.addQuestion(new TrueFalseQuestion(2, "False", 5));

        Attempt attempt = new Attempt(student, exam);

        System.out.println("Exam A started by Student 1.");

        attempt.recordAnswer("B");
        attempt.recordAnswer("True");

        attempt.submit();

        attempt.recordAnswer("A");
    }
}