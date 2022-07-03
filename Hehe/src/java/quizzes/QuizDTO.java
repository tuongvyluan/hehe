/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizzes;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class QuizDTO {
    int quizId;
    int topicId;
    String content;
    Date date;
    int numberAnswers;
    
    public QuizDTO() {
	this.quizId = 0;
	this.topicId = 0;
	this.content = null;
	this.date = null;
	this.numberAnswers = 0;
    }

    public QuizDTO(int quizId, int topicId, String content, Date date, int numberAnswers, String createdAt,
	    String updatedAt) {
	super();
	this.quizId = quizId;
	this.topicId = topicId;
	this.content = content;
	this.date = date;
	this.numberAnswers = numberAnswers;
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

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public int getNumberAnswers() {
	return numberAnswers;
    }

    public void setNumberAnswers(int numberAnswers) {
	this.numberAnswers = numberAnswers;
    }
}
