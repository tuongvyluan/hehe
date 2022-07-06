/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInTopics;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInTopicDTO {

    private int id;
    private int studentInCourseId;
    private int topicId;
    private String status;

    public StudentInTopicDTO() {
    }

    public StudentInTopicDTO(int id, int studentInCourseId, int topicId, String status) {
        this.id = id;
        this.studentInCourseId = studentInCourseId;
        this.topicId = topicId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentInCourseId() {
        return studentInCourseId;
    }

    public void setStudentInCourseId(int studentInCourseId) {
        this.studentInCourseId = studentInCourseId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentInTopicDTO{" + "id=" + id + ", studentInCourseId=" + studentInCourseId + ", topicId=" + topicId + ", status=" + status + '}';
    }
}
