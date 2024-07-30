import java.util.ArrayList;
import java.util.List;

class CourseGrade {
    private String subject;
    private int score;

    public CourseGrade(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }
}

class Student {
    private String name;
    private String studentId;
    private List<courseGrade> grades;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    public void addGrade(String subject, int score) {
        courseGrade newGrade = new courseGrade(subject, score);
        grades.add(newGrade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        int totalScore = 0;
        for (courseGrade grade : grades) {
            totalScore += grade.getScore();
        }
        return (double) totalScore / grades.size();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGrade() {
        return getGrade();
    }

    public CourseGrade[] CourseGrade() {
        CourseGrade[] array = grades.toArray(new CourseGrade[grades.size()]);
        return array;
    }

    public CourseGrade[] getCourseGrades() {
        return grades.toArray(new CourseGrade[grades.size()]);
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        String subject = "Math, Science, English";
        double grade = 0;
        StudentForm student = new StudentForm("John Doe", "12345", subject, grade);
        student.addGrade("Math", 90);
        student.addGrade("Science", 85);
        student.addGrade("English", 88);

        System.out.println("Average grade for " + student.getName() + " is: " + student.calculateAverage());
    }
}
