import java.util.ArrayList;
import java.util.List;

public class StudentForm {
    private String name;
    private String studentId;
    private List<CourseGrade> courseGrades;

    public StudentForm(String name, String studentId, String subject, double grade) {
        this.name = name;
        this.studentId = studentId;
        this.courseGrades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<CourseGrade> getCourseGrades() {
        return courseGrades;
    }

    public void addGrade(String subject, double score) {
        courseGrades.add(new CourseGrade(subject, score));
    }

    public double calculateAverage() {
        if (courseGrades.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (CourseGrade grade : courseGrades) {
            total += grade.getScore();
        }
        return total / courseGrades.size();
    }

    public double getGrade() {
        return 0;
    }

    public static class CourseGrade {
        private String subject;
        private double score;

        public CourseGrade(String subject, double score) {
            this.subject = subject;
            this.score = score;
        }

        public String getSubject() {
            return subject;
        }

        public double getScore() {
            return score;
        }
    }
}
