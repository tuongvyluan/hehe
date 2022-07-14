package answers;

public class AnswerModel {

    private int answerId;
    private int quizId;
    private String content;
    private boolean isCorrect;
    private String createdAt;
    private String updatedAt;

    public AnswerModel(int answerId, int quizId, String content, boolean isCorrect, String createdAt, String updatedAt) {
        this.answerId = answerId;
        this.quizId = quizId;
        this.content = content;
        this.isCorrect = isCorrect;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public AnswerModel() {
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

    public AnswerDTO toDTO() {
        return new AnswerDTO(answerId, quizId, isCorrect);
    }

    @Override
    public String toString() {
        return "AnswerModel{" + "answerId=" + answerId + ", quizId=" + quizId + ", content=" + content + ", isCorrect=" + isCorrect + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
