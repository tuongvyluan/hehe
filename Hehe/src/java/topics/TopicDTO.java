/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topics;

import courses.CourseDTO;
import sections.SectionDTO;

/**
 *
 * @author Luan Tuong Vy
 */
public class TopicDTO {
    
    private int topicId;
    private SectionDTO section;
    private CourseDTO course;
    private String topicName;
    private int status;
    private int displayIndex;

    public TopicDTO() {
    }

    public TopicDTO(int topicId, SectionDTO section, CourseDTO course,
            String topicName, int status, int displayIndex) {
        this.topicId = topicId;
        this.section = section;
        this.course = course;
        this.topicName = topicName;
        this.status = status;
        this.displayIndex = displayIndex;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public SectionDTO getSection() {
        return section;
    }

    public void setSection(SectionDTO section) {
        this.section = section;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
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
        return "TopicDTO{" + "topicId=" + topicId + ", section=" + section +
                ", course=" + course + ", topicName=" + topicName + ", status=" +
                status + ", displayIndex=" + displayIndex + '}';
    }
}
