package quizzes;

import java.sql.Date;

public class QuizModel {

    private int quizId;
    private int topicId;
    private String content;
    private String createdAt;
    private String updatedAt;

    public QuizModel(int quizId, int topicId, String content, String createdAt, String updatedAt) {
        this.quizId = quizId;
        this.topicId = topicId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public QuizModel() {
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public QuizDTO toDTO() {
        return new QuizDTO(quizId, topicId);
    }

    @Override
    public String toString() {
        return "QuizModel{" + "quizId=" + quizId + ", topicId=" + topicId + ", content=" + content + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
