public class StudentClass {
    private static double grade;

    public static void main(String[] args) {
        String subject = "";
        StudentForm student = new StudentForm("John Doe", "12345", subject, grade);
        student.addGrade("Math", 90.5);
        student.addGrade("Science", 85.3);
        student.addGrade("English", 88.0);

        System.out.println("Student Name: " + student.getName());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Average Grade: " + student.calculateAverage());

        for (StudentForm.CourseGrade grade : student.getCourseGrades()) {
            System.out.println("Subject: " + grade.getSubject() + ", Score: " + grade.getScore());
        }
    }
}
