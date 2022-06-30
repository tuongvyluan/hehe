/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInCourses;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInCourseModel {
    
    private int studentInCourseId;
    private int studentId;
    private int courseId;
    private int displayIndex;
    private String certificate;
    private double startDate;
    private double deadlineDate;
    private String status;

    public StudentInCourseModel(int studentInCourseId, int studentId, int courseId, int displayIndex, String certificate, double startDate, double deadlineDate, String status) {
        this.studentInCourseId = studentInCourseId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.displayIndex = displayIndex;
        this.certificate = certificate;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.status = status;
    }

    public StudentInCourseModel() {
    }

    public int getStudentInCourseId() {
        return studentInCourseId;
    }

    public void setStudentInCourseId(int studentInCourseId) {
        this.studentInCourseId = studentInCourseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
    
    public StudentInCourseDTO toDTO() {
        return new StudentInCourseDTO(studentInCourseId, studentId, courseId, displayIndex, status);
    }

    @Override
    public String toString() {
        return "StudentInCourseModel{" + "studentInCourseId=" + studentInCourseId + ", studentId=" + studentId + ", courseId=" + courseId + ", displayIndex=" + displayIndex + ", certificate=" + certificate + ", startDate=" + startDate + ", deadlineDate=" + deadlineDate + ", status=" + status + '}';
    }
    
    
}
