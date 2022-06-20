package studentInTopics;

public class StudentInTopicDTO {
    int studentInTopicId;
    int studentCourseId;
    int topicId;
    double startDate;
    double deadlineDate;

    public StudentInTopicDTO(int studentInTopicId, int studentCourseId, int topicId, double startDate,
	    double deadlineDate) {
	super();
	this.studentInTopicId = studentInTopicId;
	this.studentCourseId = studentCourseId;
	this.topicId = topicId;
	this.startDate = startDate;
	this.deadlineDate = deadlineDate;
    }

    public int getStudentInTopicId() {
	return studentInTopicId;
    }

    public void setStudentInTopicId(int studentInTopicId) {
	this.studentInTopicId = studentInTopicId;
    }

    public int getStudentCourseId() {
	return studentCourseId;
    }

    public void setStudentCourseId(int studentCourseId) {
	this.studentCourseId = studentCourseId;
    }

    public int getTopicId() {
	return topicId;
    }

    public void setTopicId(int topicId) {
	this.topicId = topicId;
    }

    public double getStartDate() {
	return startDate;
    }

    public void setStartDate(double startDate) {
	this.startDate = startDate;
    }

    public double getDeadlineDate() {
	return deadlineDate;
    }

    public void setDeadlineDate(double deadlineDate) {
	this.deadlineDate = deadlineDate;
    }

}
