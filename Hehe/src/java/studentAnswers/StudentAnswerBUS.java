/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentAnswers;

import java.sql.SQLException;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentAnswerBUS {
    
    StudentAnswerDAO dao;
    StudentAnswerDTO dto;
    
    public StudentAnswerDTO insert(int studentQuizId, int answerId) throws SQLException {
        dao = new StudentAnswerDAO();
        dto = dao.insert(studentQuizId, answerId);
        return dto;
    }
}
