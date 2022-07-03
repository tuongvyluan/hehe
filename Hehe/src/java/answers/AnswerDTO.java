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

    int answerId;
    int quizId;
    String content;
    boolean isCorrect;

    public AnswerDTO() {
        super();
        this.answerId = 0;
        this.quizId = 0;
        this.content = null;
        this.isCorrect = false;
    }

    public AnswerDTO(int answerId, int quizId, String content, boolean isCorrect) {
        super();
        this.answerId = answerId;
        this.quizId = quizId;
        this.content = content;
        this.isCorrect = isCorrect;
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

}
