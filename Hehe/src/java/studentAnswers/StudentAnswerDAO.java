/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentAnswers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import studentInQuizzes.StudentInQuizModel;
import utils.DBUtils;
import utils.MyUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentAnswerDAO {
    
    private StudentAnswerDTO studentAnswerDTO;
    
    //Fields
    private final String STUDENT_ANSWER_DTO_FIELDS = "Id, StudentQuizId, AnswerId";
    
    //SQL queries
    private final String GET_ANSWER_BY_ID = "SELECT " + STUDENT_ANSWER_DTO_FIELDS
            + " FROM StudentAnswer WHERE Id=?";
    
    private final String GET_ANSWER = "SELECT " + STUDENT_ANSWER_DTO_FIELDS
            + " FROM StudentAnswer WHERE StudentQuizId=? AND AnswerId=?";

    private final String GET_ANSWERS = "SELECT TOP(10) " + STUDENT_ANSWER_DTO_FIELDS
            + " FROM StudentAnswer WHERE StudentQuizId=? ORDER BY Id";

    private final String INSERT = "INSERT INTO StudentAnswer "
            + "(StudentQuizId, AnswerId) VALUES (?,?)";
    
    public StudentAnswerDTO getStudentAnswer(int studentAnswerId) throws SQLException {
        studentAnswerDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ANSWER_BY_ID);
                ptm.setInt(1, studentAnswerId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentAnswerDTO = new StudentAnswerDTO();
                    studentAnswerDTO.setStudentAnswerId(studentAnswerId);
                    studentAnswerDTO.setStudentQuizId(rs.getInt("StudentQuizId"));
                    studentAnswerDTO.setAnswerId(rs.getInt("AnswerId"));
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
        return studentAnswerDTO;
    }
    
    public StudentAnswerDTO getStudentAnswer(int studentQuizId, int answerId) throws SQLException {
        studentAnswerDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ANSWER);
                ptm.setInt(1, studentQuizId);
                ptm.setInt(2, answerId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentAnswerDTO = new StudentAnswerDTO();
                    studentAnswerDTO.setStudentAnswerId(rs.getInt("Id"));
                    studentAnswerDTO.setStudentQuizId(studentQuizId);
                    studentAnswerDTO.setAnswerId(answerId);
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
        return studentAnswerDTO;
    }
    
    public ArrayList<StudentAnswerDTO> getStudentAnswers(int studentQuizId) throws SQLException {
        ArrayList<StudentAnswerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ANSWERS);
                ptm.setInt(1, studentQuizId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    studentAnswerDTO = new StudentAnswerDTO();
                    studentAnswerDTO.setStudentAnswerId(rs.getInt("Id"));
                    studentAnswerDTO.setStudentQuizId(studentQuizId);
                    studentAnswerDTO.setAnswerId(rs.getInt("AnswerId"));
                    list.add(studentAnswerDTO);
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
    
    public StudentAnswerDTO insert(int studentQuizId, int answerId) throws SQLException {
        studentAnswerDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setInt(1, studentQuizId);
                ptm.setInt(2, answerId);
                if (ptm.executeUpdate() == 1) {
                    studentAnswerDTO = getStudentAnswer(studentQuizId, answerId);
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
        return studentAnswerDTO;
    }
}
