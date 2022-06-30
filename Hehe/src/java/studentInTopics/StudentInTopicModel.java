package studentInTopics;

import studentInCourses.StudentInCourseModel;
import topics.TopicModel;

public class StudentInTopicModel {

    private int id;
    private StudentInCourseModel studentCourse;
    private TopicModel topic;
    private double startDate;
    private double deadlineDate;

    public StudentInTopicModel(int id, StudentInCourseModel studentCourse,
            TopicModel topic, double startDate, double deadlineDate) {
        this.id = id;
        this.studentCourse = studentCourse;
        this.topic = topic;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
    }

    public StudentInTopicModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentInCourseModel getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(StudentInCourseModel studentCourse) {
        this.studentCourse = studentCourse;
    }

    public TopicModel getTopic() {
        return topic;
    }

    public void setTopic(TopicModel topic) {
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
        return "StudentInTopicModel{" + "id=" + id + ", studentCourse=" + studentCourse + ", topic=" + topic + ", startDate=" + startDate + ", deadlineDate=" + deadlineDate + '}';
    }
}