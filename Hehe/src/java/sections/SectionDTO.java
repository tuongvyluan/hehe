/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sections;

/**
 *
 * @author Luan Tuong Vy
 */
public class SectionDTO {
    
    private int sectionId;
    private int courseId;
    private String sectionName;
    private int displayIndex;

    public SectionDTO(int sectionId, int courseId, String sectionName, int displayIndex) {
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.sectionName = sectionName;
        this.displayIndex = displayIndex;
    }

    public SectionDTO() {
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

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    @Override
    public String toString() {
        return "SectionDTO{" + "sectionId=" + sectionId + ", courseId=" + courseId + ", sectionName=" + sectionName + ", displayIndex=" + displayIndex + '}';
    }
}