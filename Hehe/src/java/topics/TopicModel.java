package topics;

import courses.CourseModel;
import java.time.LocalDate;
import sections.SectionModel;

public class TopicModel {

    private int topicId;
    private SectionModel section;
    private CourseModel course;
    private String topicName;
    private String description;
    private int status;
    private int displayIndex;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public TopicModel() {

    }

    public TopicModel(int topicId, SectionModel section, CourseModel course,
            String topicName, String description, int status, int displayIndex,
            LocalDate createdAt, LocalDate updatedAt) {
        this.topicId = topicId;
        this.section = section;
        this.course = course;
        this.topicName = topicName;
        this.description = description;
        this.status = status;
        this.displayIndex = displayIndex;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public SectionModel getSection() {
        return section;
    }

    public void setSection(SectionModel section) {
        this.section = section;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TopicDTO toDTO() {
        return new TopicDTO(topicId, section.toDTO(), course.toDTO(), topicName, status, displayIndex);
    }

    @Override
    public String toString() {
        return "TopicModel{" + "topicId=" + topicId + ", section=" + section
                + ", course=" + course + ", topicName=" + topicName + ", description="
                + description + ", status=" + status + ", displayIndex=" + displayIndex
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
