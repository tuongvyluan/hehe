package sections;

import java.time.LocalDate;

public class SectionModel {

    private int sectionId;
    private int courseId;
    private String sectionName;
    private String description;
    private int displayIndex;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public SectionModel(int sectionId, int courseId, String sectionName, String description, int displayIndex) {
        super();
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.sectionName = sectionName;
        this.description = description;
        this.displayIndex = displayIndex;
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
    
    public SectionDTO toDTO() {
        return new SectionDTO(sectionId, courseId, sectionName, displayIndex);
    }

    @Override
    public String toString() {
        return "SectionModel{" + "sectionId=" + sectionId + ", courseId=" + courseId + ", sectionName=" + sectionName + ", description=" + description + ", displayIndex=" + displayIndex + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
