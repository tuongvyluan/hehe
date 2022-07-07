/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package answers;

/**
 *
 * @author ADMIN
 */
public class AnswerDTO {
    
    private int answerId;
    private int quizId;
    private boolean isCorrect;

    public AnswerDTO(int answerId, int quizId, boolean isCorrect) {
        this.answerId = answerId;
        this.quizId = quizId;
        this.isCorrect = isCorrect;
    }

    public AnswerDTO() {
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

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" + "answerId=" + answerId + ", quizId=" + quizId + ", isCorrect=" + isCorrect + '}';
    }
}
