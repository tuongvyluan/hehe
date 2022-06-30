/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInTopics;

import studentInCourses.StudentInCourseDTO;
import topics.TopicDTO;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInTopicDTO {
    
    private int id;
    private StudentInCourseDTO studentCourse;
    private TopicDTO topic;
    private double startDate;
    private double deadlineDate;

    public StudentInTopicDTO() {
    }

    public StudentInTopicDTO(int id, StudentInCourseDTO studentCourse, TopicDTO topic, double startDate, double deadlineDate) {
        this.id = id;
        this.studentCourse = studentCourse;
        this.topic = topic;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentInCourseDTO getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(StudentInCourseDTO studentCourse) {
        this.studentCourse = studentCourse;
    }

    public TopicDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicDTO topic) {
        this.topic = topic;
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

    @Override
    public String toString() {
        return "StudentInTopicDTO{" + "id=" + id + ", studentCourse=" + studentCourse + ", topic=" + topic + ", startDate=" + startDate + ", deadlineDate=" + deadlineDate + '}';
    }
}
