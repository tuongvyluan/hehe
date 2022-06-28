/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInCourses;

import courses.CourseModel;
import students.StudentModel;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInCourseDTO {
    
    private int studentInCourseId;
    private StudentModel student;
    private CourseModel course;
    private int displayIndex;
    private String status;

    public StudentInCourseDTO() {
    }

    public StudentInCourseDTO(int studentInCourseId, StudentModel student, CourseModel course, int displayIndex, String status) {
        this.studentInCourseId = studentInCourseId;
        this.student = student;
        this.course = course;
        this.displayIndex = displayIndex;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentInCourseDTO{" + "studentInCourseId=" + studentInCourseId + ", student=" + student + ", course=" + course + ", displayIndex=" + displayIndex + ", status=" + status + '}';
    }
}