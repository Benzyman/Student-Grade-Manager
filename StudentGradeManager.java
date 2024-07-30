import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentGradeManager extends JFrame {
    private JTextField nameField, StudentIDField, subjectField, gradeField;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private List<StudentForm> students;

    public StudentGradeManager() {
        students = new ArrayList<>();

        setTitle("Student Grade Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("StudentForm Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("StudentForm ID:"));
        StudentIDField = new JTextField();
        panel.add(StudentIDField);

        panel.add(new JLabel("Subject:"));
        subjectField = new JTextField();
        panel.add(subjectField);

        panel.add(new JLabel("courseGrade:"));
        gradeField = new JTextField();
        panel.add(gradeField);

        JButton addButton = new JButton("Add courseGrade");
        addButton.addActionListener(new AddGradeListener());
        panel.add(addButton);

        JButton calcAverageButton = new JButton("Calculate Average");
        calcAverageButton.addActionListener(new CalcAverageListener());
        panel.add(calcAverageButton);

        add(panel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Name", "StudentForm ID", "Subject", "courseGrade"}, 0);
        studentTable = new JTable(tableModel);
        add(new JScrollPane(studentTable), BorderLayout.CENTER);
    }

    private class AddGradeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String StudentID = StudentIDField.getText();
            String subject = subjectField.getText();
            double grade;
            grade = Double.parseDouble(gradeField.getText());

            StudentForm student = new StudentForm(name, StudentID, subject, grade);
            students.add(student);

            tableModel.addRow(new Object[]{name, StudentID, subject, grade});
        }
    }

    private class CalcAverageListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double total = 0;
            for (StudentForm student : students) {
                total += student.getGrade();
            }
            double average = total / students.size();
            JOptionPane.showMessageDialog(StudentGradeManager.this, "Average courseGrade: " + average);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentGradeManager().setVisible(true);
            }
        });
    }
}
