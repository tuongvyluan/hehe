package topics;

public class TopicDTO {

    int topicId;
    int sectionId;
    int courseId;
    String topicName;
    String description;
    int status;
    int displayIndex;

    public TopicDTO(int topicId, int sectionId, int courseId, String topicName, String description, int status,
            int displayIndex, String createdAt, String updatedAt) {
        super();
        this.topicId = topicId;
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.topicName = topicName;
        this.description = description;
        this.status = status;
        this.displayIndex = displayIndex;
    }

    public TopicDTO() {
        super();
        this.topicId = 0;
        this.sectionId = 0;
        this.courseId = 0;
        this.topicName = null;
        this.description = null;
        this.status = 0;
        this.displayIndex = 0;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    @Override
    public String toString() {
        return "TopicDTO{" + "topicId=" + topicId + ", sectionId=" + sectionId + ", courseId=" + courseId + ", topicName=" + topicName + ", description=" + description + ", status=" + status + ", displayIndex=" + displayIndex + "}";
    }
}
