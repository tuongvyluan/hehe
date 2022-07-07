/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizzes;

import java.sql.SQLException;

/**
 *
 * @author Luan Tuong Vy
 */
public class QuizBUS {
    
    QuizModel quiz;
    QuizDAO dao;
    
    public QuizModel getContent(int topicId) throws SQLException {
        dao = new QuizDAO();
        quiz = dao.getContent(topicId);
        return quiz;
    }
}
