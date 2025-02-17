public class Attendance {
    public void trackAttendance(Student student, Course course, int days) {
        student.addAttendance(course.getCourseName(), days);
    }
}
