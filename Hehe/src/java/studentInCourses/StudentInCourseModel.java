/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInCourses;

import java.time.LocalDate;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInCourseModel {
    
    private int studentInCourseId;
    private int studentId;
    private int courseId;
    private String certificate;
    private LocalDate startDate;
    private String status;

    public StudentInCourseModel(int studentInCourseId, int studentId, int courseId, String certificate, LocalDate startDate, String status) {
        this.studentInCourseId = studentInCourseId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.certificate = certificate;
        this.startDate = startDate;
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

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public StudentInCourseDTO toDTO() {
        return new StudentInCourseDTO(studentInCourseId, studentId, courseId, status);
    }

    @Override
    public String toString() {
        return "StudentInCourseModel{" + "studentInCourseId=" + studentInCourseId + ", studentId=" + studentId + ", courseId=" + courseId + ", certificate=" + certificate + ", startDate=" + startDate + ", status=" + status + '}';
    }
    
    
}
