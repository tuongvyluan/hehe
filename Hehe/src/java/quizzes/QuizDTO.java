/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizzes;

/**
 *
 * @author Luan Tuong Vy
 */
public class QuizDTO {

    private int quizId;
    private int topicId;

    public QuizDTO(int quizId, int topicId) {
        this.quizId = quizId;
        this.topicId = topicId;
    }

    public QuizDTO() {
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

    @Override
    public String toString() {
        return "QuizDTO{" + "quizId=" + quizId + ", topicId=" + topicId + '}';
    }
}
