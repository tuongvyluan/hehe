/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInQuizzes;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInQuizBUS {
    
    private StudentInQuizDAO dao;
    private StudentInQuizModel model;
    
    public StudentInQuizModel getStudentQuiz(int studentTopicId) throws SQLException {
        dao = new StudentInQuizDAO();
        model = dao.getStudentQuiz(studentTopicId);
        return model;
    }
    
    public ArrayList<StudentInQuizModel> getStudentQuizzes(int studentTopicId) throws SQLException {
        dao = new StudentInQuizDAO();
        ArrayList<StudentInQuizModel> list = dao.getStudentQuizzes(studentTopicId);
        return list;
    }
    
    public StudentInQuizModel insert(int studentTopicId, int quizId) throws SQLException {
        dao = new StudentInQuizDAO();
        model = dao.insert(studentTopicId, quizId);
        return model;
    }
}
