/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInTopics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInTopicDAO {
    
    private StudentInTopicDTO studentInTopicDTO;
    
    //Fields
    private final String STUDENT_IN_TOPIC_DTO_FIELDS = "Id, StudentCourseId, "
            + "TopicId, Status";
    
    //SQL queries
    private final String GET_TOPIC = "SELECT " + STUDENT_IN_TOPIC_DTO_FIELDS
            + " FROM StudentInTopic WHERE StudentCourseId=? AND TopicId=?";
    
    private final String GET_TOPIC_BY_ID = "SELECT " + STUDENT_IN_TOPIC_DTO_FIELDS
            + " FROM StudentInTopic WHERE Id=?";

    private final String INSERT = "INSERT INTO StudentInTopic "
            + "(StudentCourseId, TopicId, Status) "
            + "VALUES (?,?,?)";

    private final String UPDATE = "UPDATE StudentInTopic SET Status=? WHERE Id=?";
    
    public StudentInTopicDTO getDTO(int studentCourseId, int topicId) throws SQLException {
        studentInTopicDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_TOPIC);
                ptm.setInt(1, studentCourseId);
                ptm.setInt(2, topicId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInTopicDTO = new StudentInTopicDTO();
                    studentInTopicDTO.setId(rs.getInt("Id"));
                    studentInTopicDTO.setStudentInCourseId(studentCourseId);
                    studentInTopicDTO.setTopicId(topicId);
                    studentInTopicDTO.setStatus(rs.getString("Status"));
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
        return studentInTopicDTO;
    }
    
    public StudentInTopicDTO getDTO(int studentTopicId) throws SQLException {
        studentInTopicDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_TOPIC_BY_ID);
                ptm.setInt(1, studentTopicId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInTopicDTO = new StudentInTopicDTO();
                    studentInTopicDTO.setId(studentTopicId);
                    studentInTopicDTO.setStudentInCourseId(rs.getInt("StudentCourseId"));
                    studentInTopicDTO.setTopicId(rs.getInt("TopicId"));
                    studentInTopicDTO.setStatus(rs.getString("Status"));
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
        return studentInTopicDTO;
    }
    
    public StudentInTopicDTO insert(int studentCourseId, int topicId, String status) throws SQLException {
        studentInTopicDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setInt(1, studentCourseId);
                ptm.setInt(2, topicId);
                ptm.setString(3, status);
                if (ptm.executeUpdate() == 1) {
                    studentInTopicDTO = getDTO(studentCourseId, topicId);
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
        return studentInTopicDTO;
    }
    
    public StudentInTopicDTO updateStatus(int studentTopicId, String status) throws SQLException {
        studentInTopicDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setInt(2, studentTopicId);
                ptm.setString(1, status);
                if (ptm.executeUpdate() == 1) {
                    studentInTopicDTO = getDTO(studentTopicId);
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
        return studentInTopicDTO;
    }
}
