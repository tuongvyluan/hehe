/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInCourses;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInCourseDTO {
    
    private int studentInCourseId;
    private int studentId;
    private int courseId;

    public StudentInCourseDTO(int studentInCourseId, int studentId, int courseId) {
        this.studentInCourseId = studentInCourseId;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public StudentInCourseDTO() {
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

    @Override
    public String toString() {
        return "StudentInCourseDTO{" + "studentInCourseId=" + studentInCourseId + ", studentId=" + studentId + ", courseId=" + courseId + '}';
    }
}