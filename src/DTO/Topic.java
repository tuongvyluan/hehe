package DTO;

public class Topic {
	int topicId;
	int sectionId;
	int courseId;
	String topicName;
	String description;
	int status;
	int displayIndex;
	String createdAt;
	String updatedAt;
	public Topic(int topicId, int sectionId, int courseId, String topicName, String description, int status,
			int displayIndex, String createdAt, String updatedAt) {
		super();
		this.topicId = topicId;
		this.sectionId = sectionId;
		this.courseId = courseId;
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
