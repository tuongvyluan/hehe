package DTO;

import java.sql.Date;

public class Quiz {
	int quizId;
	int topicId;
	String content;
	Date date;
	int numberAnswers;
	String createdAt;
	String updatedAt;
	public Quiz(int quizId, int topicId, String content, Date date, int numberAnswers, String createdAt,
			String updatedAt) {
		super();
		this.quizId = quizId;
		this.topicId = topicId;
		this.content = content;
		this.date = date;
		this.numberAnswers = numberAnswers;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
