import java.util.*;

class CourseManagementSystem {
    private Map<String, Student> students;
    private Map<String, Course> courses;
    private Attendance attendanceTracker;
    private Grade gradeTracker;

    public CourseManagementSystem() {
        students = new HashMap<>();
        courses = new HashMap<>();
        attendanceTracker = new Attendance();
        gradeTracker = new Grade();
    }

    public void addStudent(String studentId, String name) {
        students.put(studentId, new Student(studentId, name));
    }

    public void addCourse(String courseId, String courseName) {
        courses.put(courseId, new Course(courseId, courseName));
    }

    public void enrollStudentInCourse(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student != null && course != null) {
            course.enrollStudent(student);
            System.out.println("Student enrolled successfully!");
        } else {
            System.out.println("Student or course not found!");
        }
    }

    public void trackAttendance(String studentId, String courseId, int days) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student != null && course != null) {
            attendanceTracker.trackAttendance(student, course, days);
            System.out.println("Attendance updated successfully!");
        } else {
            System.out.println("Student or course not found!");
        }
    }

    public void assignGrade(String studentId, String courseId, double grade) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student != null && course != null) {
            gradeTracker.assignGrade(student, course, grade);
            System.out.println("Grade assigned successfully!");
        } else {
            System.out.println("Student or course not found!");
        }
    }

    public void displayStudentDetails(String studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            for (String course : courses.keySet()) {
                System.out.println("Course: " + course);
                System.out.println("Attendance: " + student.getAttendance(course));
                System.out.println("Grade: " + student.getGrade(course));
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Course Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Track Attendance");
            System.out.println("5. Assign Grade");
            System.out.println("6. Display Student Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    cms.addStudent(studentId, studentName);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    cms.addCourse(courseId, courseName);
                    System.out.println("Course added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String enrollStudentId = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    String enrollCourseId = scanner.nextLine();
                    cms.enrollStudentInCourse(enrollStudentId, enrollCourseId);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    String attStudentId = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    String attCourseId = scanner.nextLine();
                    System.out.print("Enter Number of Attendance Days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    cms.trackAttendance(attStudentId, attCourseId, days);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    String gradeStudentId = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    String gradeCourseId = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    cms.assignGrade(gradeStudentId, gradeCourseId, grade);
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    String detailsStudentId = scanner.nextLine();
                    cms.displayStudentDetails(detailsStudentId);
                    break;

                case 7:
                    System.out.println("Exiting Course Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
