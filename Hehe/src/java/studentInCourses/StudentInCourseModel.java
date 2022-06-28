/**
 *
 */
package studentInCourses;

import courses.CourseModel;
import students.StudentModel;

/**
 * @author Tuong Vy Luan
 *
 */
public class StudentInCourseModel {

    private int studentInCourseId;
    private StudentModel student;
    private CourseModel course;
    private int displayIndex;
    private String certificate;
    private double startDate;
    private double deadlineDate;
    private String status;

    public StudentInCourseModel() {
    }

    public StudentInCourseModel(int studentInCourseId, StudentModel student, CourseModel course, int displayIndex, String certificate, double startDate, double deadlineDate, String status) {
        this.studentInCourseId = studentInCourseId;
        this.student = student;
        this.course = course;
        this.displayIndex = displayIndex;
        this.certificate = certificate;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.status = status;
    }

    public int getStudentInCourseId() {
        return studentInCourseId;
    }

    public void setStudentInCourseId(int studentInCourseId) {
        this.studentInCourseId = studentInCourseId;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public double getStartDate() {
        return startDate;
    }

    public void setStartDate(double startDate) {
        this.startDate = startDate;
    }

    public double getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(double deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentInCourseModel{" + "studentInCourseId=" + studentInCourseId + ", student=" + student + ", course=" + course + ", displayIndex=" + displayIndex + ", certificate=" + certificate + ", startDate=" + startDate + ", deadlineDate=" + deadlineDate + ", status=" + status + '}';
    }
}