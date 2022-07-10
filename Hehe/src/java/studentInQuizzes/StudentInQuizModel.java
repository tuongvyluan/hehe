package studentInQuizzes;

import java.time.LocalDate;

public class StudentInQuizModel {

    private int studentInQuizId;
    private int studentTopicId;
    private int quizId;
    private LocalDate createdAt;

    public StudentInQuizModel(int studentInQuizId, int studentTopicId, int quizId, LocalDate createdAt) {
        super();
        this.studentInQuizId = studentInQuizId;
        this.studentTopicId = studentTopicId;
        this.quizId = quizId;
        this.createdAt = createdAt;
    }

    public StudentInQuizModel() {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "StudentInQuizModel{" + "studentInQuizId=" + studentInQuizId + ", studentTopicId=" + studentTopicId + ", quizId=" + quizId + ", createdAt=" + createdAt + '}';
    }

}
