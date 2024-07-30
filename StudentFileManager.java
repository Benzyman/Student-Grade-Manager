import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentFileManager {

    public void writeStudentDataToFile(String filename, List<StudentForm> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (StudentForm student : students) {
                writer.write("Name: " + student.getName());
                writer.newLine();
                writer.write("StudentForm ID: " + student.getStudentId());
                writer.newLine();
                writer.write("Grades:");
                writer.newLine();
                for (StudentForm.CourseGrade grade : student.getCourseGrades()) {
                    writer.write("  Subject: " + grade.getSubject() + ", Score: " + grade.getScore());
                    writer.newLine();
                }
                writer.write("Average: " + student.calculateAverage());
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String subject = "Math, Science, English";
        double grade = 0;
        StudentForm student1 = new StudentForm("John Doe", "12345", subject, grade);
        student1.addGrade("Math", 90);
        student1.addGrade("Science", 85);
        student1.addGrade("English", 88);

        StudentForm student2 = new StudentForm("Jane Smith", "67890", subject, grade);
        student2.addGrade("Math", 92);
        student2.addGrade("Science", 87);
        student2.addGrade("English", 90);

        List<StudentForm> students = List.of(student1, student2);

        StudentFileManager manager = new StudentFileManager();
        manager.writeStudentDataToFile("student_grades.txt", students);
    }
}
