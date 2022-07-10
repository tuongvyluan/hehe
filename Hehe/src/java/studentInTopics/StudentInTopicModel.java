package studentInTopics;

import java.time.LocalDate;

public class StudentInTopicModel {

    private int id;
    private int studentInCourseId;
    private int topicId;
    private LocalDate startDate;
    private String status;

    public StudentInTopicModel(int id, int studentInCourseId, int topicId,
            LocalDate startDate, String status) {
        this.id = id;
        this.studentInCourseId = studentInCourseId;
        this.topicId = topicId;
        this.startDate = startDate;
        this.status = status;
    }

    public StudentInTopicModel() {
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

    public StudentInTopicDTO toDTO() {
        return new StudentInTopicDTO(id, studentInCourseId, topicId, status);
    }

    @Override
    public String toString() {
        return "StudentInTopicModel{" + "id=" + id
                + ", studentInCourseId=" + studentInCourseId
                + ", topicId=" + topicId + ", startDate=" + startDate
                + ", status=" + status + '}';
    }
}
