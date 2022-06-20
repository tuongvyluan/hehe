package answers;

public class AnswerDTO {
    int answerId;
    int quizId;
    String content;
    boolean isCorrect;
    String createdAt;
    String updatedAt;

    public AnswerDTO(int answerId, int quizId, String content, boolean isCorrect, String createdAt, String updatedAt) {
	super();
	this.answerId = answerId;
	this.quizId = quizId;
	this.content = content;
	this.isCorrect = isCorrect;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
    }

    public int getAnswerId() {
	return answerId;
    }

    public void setAnswerId(int answerId) {
	this.answerId = answerId;
    }

    public int getQuizId() {
	return quizId;
    }

    public void setQuizId(int quizId) {
	this.quizId = quizId;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public boolean isCorrect() {
	return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
	this.isCorrect = isCorrect;
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
