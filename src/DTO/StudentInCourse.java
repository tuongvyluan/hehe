package DTO;

public class StudentInCourse {
	int studentInCourseId;
	int studentId;
	int courseId;
	int displayIndex;
	String certificate;
	double startDate;
	double deadlineDate;
	int status;
	public StudentInCourse(int studentInCourseId, int studentId, int courseId, int displayIndex, String certificate,
			double startDate, double deadlineDate, int status) {
		super();
		this.studentInCourseId = studentInCourseId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.displayIndex = displayIndex;
		this.certificate = certificate;
		this.startDate = startDate;
		this.deadlineDate = deadlineDate;
		this.status = status;
	}
	public int getStudentInCourseId() {
		return studentInCourseId;
	}
	public void setStudentInCourseId(int studentInCourseId) {
		this.studentInCourseId = studentInCourseId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getDisplayIndex() {
		return displayIndex;
	}
	public void setDisplayIndex(int displayIndex) {
		this.displayIndex = displayIndex;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	//method
}
