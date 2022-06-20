package sections;

public class SectionDTO {
	int sectionId;
	int courseId;
	String sectionName;
	String description;
	int displayIndex;
	String createdAt;
	String updatedAt;
	public SectionDTO(int sectionId, int courseId, String sectionName, String description, int displayIndex,
			String createdAt, String updatedAt) {
		super();
		this.sectionId = sectionId;
		this.courseId = courseId;
		this.sectionName = sectionName;
		this.description = description;
		this.displayIndex = displayIndex;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
