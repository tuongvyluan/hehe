package studentAnswers;

public class StudentAnswerDTO {
    int studentAnswerId;
    int studentQuizId;
    int answerId;
    String createdAt;

    public StudentAnswerDTO(int studentAnswerId, int studentQuizId, int answerId, String createdAt) {
	super();
	this.studentAnswerId = studentAnswerId;
	this.studentQuizId = studentQuizId;
	this.answerId = answerId;
	this.createdAt = createdAt;
    }

    public int getStudentAnswerId() {
	return studentAnswerId;
    }

    public void setStudentAnswerId(int studentAnswerId) {
	this.studentAnswerId = studentAnswerId;
    }

    public int getStudentQuizId() {
	return studentQuizId;
    }

    public void setStudentQuizId(int studentQuizId) {
	this.studentQuizId = studentQuizId;
    }

    public int getAnswerId() {
	return answerId;
    }

    public void setAnswerId(int answerId) {
	this.answerId = answerId;
    }

    public String getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
    }

}
