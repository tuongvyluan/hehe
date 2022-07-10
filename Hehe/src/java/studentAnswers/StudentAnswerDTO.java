/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentAnswers;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentAnswerDTO {
    
    private int studentAnswerId;
    private int studentQuizId;
    private int answerId;

    public StudentAnswerDTO() {
    }

    public StudentAnswerDTO(int studentAnswerId, int studentQuizId, int answerId) {
        this.studentAnswerId = studentAnswerId;
        this.studentQuizId = studentQuizId;
        this.answerId = answerId;
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

    @Override
    public String toString() {
        return "StudentAnswerDTO{" + "studentAnswerId=" + studentAnswerId + ", studentQuizId=" + studentQuizId + ", answerId=" + answerId + '}';
    }
}
