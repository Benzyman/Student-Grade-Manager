public class MainEvent {
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
