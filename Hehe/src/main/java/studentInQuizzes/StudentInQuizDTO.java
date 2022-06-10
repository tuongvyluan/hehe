package studentInQuizzes;

public class StudentInQuizDTO {
    int studentInQuizId;
    int studentTopicId;
    int quizId;
    String createdAt;

    public StudentInQuizDTO(int studentInQuizId, int studentTopicId, int quizId, String createdAt) {
	super();
	this.studentInQuizId = studentInQuizId;
	this.studentTopicId = studentTopicId;
	this.quizId = quizId;
	this.createdAt = createdAt;
    }

    public int getStudentInQuizId() {
	return studentInQuizId;
    }

    public void setStudentInQuizId(int studentInQuizId) {
	this.studentInQuizId = studentInQuizId;
    }

    public int getStudentTopicId() {
	return studentTopicId;
    }

    public void setStudentTopicId(int studentTopicId) {
	this.studentTopicId = studentTopicId;
    }

    public int getQuizId() {
	return quizId;
    }

    public void setQuizId(int quizId) {
	this.quizId = quizId;
    }

    public String getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
    }

}
