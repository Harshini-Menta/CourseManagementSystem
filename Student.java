import java.util.*;

public class Student {
    private String studentId;
    private String name;
    private Map<String, Integer> attendance;
    private Map<String, Double> grades;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.attendance = new HashMap<>();
        this.grades = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void addAttendance(String course, int days) {
        attendance.put(course, days);
    }

    public int getAttendance(String course) {
        return attendance.getOrDefault(course, 0);
    }

    public void addGrade(String course, double grade) {
        grades.put(course, grade);
    }

    public double getGrade(String course) {
        return grades.getOrDefault(course, 0.0);
    }
}
