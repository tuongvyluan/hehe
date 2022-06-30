/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topics;

<<<<<<< HEAD
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
=======
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
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
<<<<<<< HEAD
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
=======
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
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
<<<<<<< HEAD
        return "TopicDTO{" + "topicId=" + topicId + ", sectionId=" + sectionId + ", courseId=" + courseId + ", topicName=" + topicName + ", description=" + description + ", status=" + status + ", displayIndex=" + displayIndex + "}";
=======
        return "TopicDTO{" + "topicId=" + topicId + ", section=" + section +
                ", course=" + course + ", topicName=" + topicName + ", status=" +
                status + ", displayIndex=" + displayIndex + '}';
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
    }
}
