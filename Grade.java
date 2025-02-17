public class Grade {
    public void assignGrade(Student student, Course course, double grade) {
        student.addGrade(course.getCourseName(), grade);
    } 
}
