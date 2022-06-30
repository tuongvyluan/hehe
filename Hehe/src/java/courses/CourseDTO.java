/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courses;

/**
 *
 * @author Luan Tuong Vy
 */
public class CourseDTO {
    
    private int courseId;
    private int categoryId;
    private int authorId;
    private String courseName;
    private double duration;

    public CourseDTO() {
    }
    
    public CourseDTO(int courseId, int categoryId, int authorId, String courseName, double duration) {
        this.courseId = courseId;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.courseName = courseName;
        this.duration = duration;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "CourseDTO{" + "courseId=" + courseId + ", categoryId=" + categoryId + ", authorId=" + authorId + ", courseName=" + courseName + ", duration=" + duration + '}';
    }
    
}