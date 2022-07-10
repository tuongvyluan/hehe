/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInQuizzes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;
import utils.MyUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInQuizDAO {
    
    private StudentInQuizModel studentInQuizModel;
    
    //Fields
    private final String STUDENT_IN_QUIZ_DTO_FIELDS = "Id, StudentTopicId, "
            + "QuizId, CreatedAt";
    
    //SQL queries
    private final String GET_QUIZ = "SELECT TOP(1) " + STUDENT_IN_QUIZ_DTO_FIELDS
            + " FROM StudentInQuiz WHERE StudentTopicId=? ORDER BY Id DESC";

    private final String GET_QUIZZES = "SELECT TOP(10) " + STUDENT_IN_QUIZ_DTO_FIELDS
            + " FROM StudentInQuiz WHERE StudentTopicId=? ORDER BY Id DESC";

    private final String INSERT = "INSERT INTO StudentInQuiz "
            + "(StudentTopicId, QuizId) VALUES (?,?)";
    
    public StudentInQuizModel getStudentQuiz(int studentTopicId) throws SQLException {
        studentInQuizModel = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_QUIZ);
                ptm.setInt(1, studentTopicId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInQuizModel = new StudentInQuizModel();
                    studentInQuizModel.setStudentInQuizId(rs.getInt("Id"));
                    studentInQuizModel.setStudentTopicId(studentTopicId);
                    studentInQuizModel.setQuizId(rs.getInt("QuizId"));
                    studentInQuizModel.setCreatedAt(MyUtils.convertDateToLocalDate(rs.getDate("CreatedAt")));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return studentInQuizModel;
    }
    
    public ArrayList<StudentInQuizModel> getStudentQuizzes(int studentTopicId) throws SQLException {
        ArrayList<StudentInQuizModel> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_QUIZZES);
                ptm.setInt(1, studentTopicId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    studentInQuizModel = new StudentInQuizModel();
                    studentInQuizModel.setStudentInQuizId(rs.getInt("Id"));
                    studentInQuizModel.setStudentTopicId(studentTopicId);
                    studentInQuizModel.setQuizId(rs.getInt("QuizId"));
                    studentInQuizModel.setCreatedAt(MyUtils.convertDateToLocalDate(rs.getDate("CreatedAt")));
                    list.add(studentInQuizModel);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public StudentInQuizModel insert(int studentTopicId, int quizId) throws SQLException {
        studentInQuizModel = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setInt(1, studentTopicId);
                ptm.setInt(2, quizId);
                if (ptm.executeUpdate() == 1) {
                    studentInQuizModel = getStudentQuiz(studentTopicId);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return studentInQuizModel;
    }
}
