/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class TopicDAO {

    private TopicDTO topicDTO;

    //Fields
    private final String TOPIC_DTO_FIELDS = "Id, SectionId, CourseId, Name, DisplayIndex";
    private final String TOPIC_CONTENT = "Id, CourseId, Name, DisplayIndex, Description";

    //Sql queries
    private final String GET_TOPICS_BY_SECTION = "SELECT " + TOPIC_DTO_FIELDS
            + " FROM Topic WHERE SectionId=? ORDER BY DisplayIndex";

    private final String GET_TOPIC_CONTENT = "SELECT " + TOPIC_CONTENT
            + " FROM Topic WHERE Id=?";

    private final String GET_NEXT_TOPIC_CONTENT = "SELECT TOP(1) " + TOPIC_CONTENT
            + " FROM Topic WHERE CourseId=? AND DisplayIndex>?";
    
    private final String GET_PREV_TOPIC_CONTENT = "SELECT TOP(1) " + TOPIC_CONTENT
            + " FROM Topic WHERE CourseId=? AND DisplayIndex<?";

    public ArrayList<TopicDTO> get(int sectionId) throws SQLException {
        ArrayList<TopicDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_TOPICS_BY_SECTION);
                ptm.setInt(1, sectionId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    topicDTO = new TopicDTO();
                    topicDTO.setTopicId(rs.getInt("Id"));
                    topicDTO.setCourseId(rs.getInt("CourseId"));
                    topicDTO.setSectionId(sectionId);
                    topicDTO.setTopicName(rs.getString("Name"));
                    topicDTO.setDisplayIndex(rs.getInt("DisplayIndex"));
                    list.add(topicDTO);
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

    public TopicModel getContent(int topicId) throws SQLException {
        TopicModel topic = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_TOPIC_CONTENT);
                ptm.setInt(1, topicId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    topic = new TopicModel();
                    topic.setTopicId(topicId);
                    topic.setCourseId(rs.getInt("CourseId"));
                    topic.setTopicName(rs.getString("Name"));
                    topic.setDescription(rs.getString("Description"));
                    topic.setDisplayIndex(rs.getInt("DisplayIndex"));
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
        return topic;
    }

    public TopicModel getNextContent(int courseId, int displayIndex) throws SQLException {
        TopicModel topic = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_NEXT_TOPIC_CONTENT);
                ptm.setInt(1, courseId);
                ptm.setInt(2, displayIndex);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    topic = new TopicModel();
                    topic.setTopicId(rs.getInt("Id"));
                    topic.setCourseId(rs.getInt("CourseId"));
                    topic.setTopicName(rs.getString("Name"));
                    topic.setDescription(rs.getString("Description"));
                    topic.setDisplayIndex(rs.getInt("DisplayIndex"));
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
        return topic;
    }
    
    public TopicModel getPrevContent(int courseId, int displayIndex) throws SQLException {
        TopicModel topic = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PREV_TOPIC_CONTENT);
                ptm.setInt(1, courseId);
                ptm.setInt(2, displayIndex);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    topic = new TopicModel();
                    topic.setTopicId(rs.getInt("Id"));
                    topic.setCourseId(rs.getInt("CourseId"));
                    topic.setTopicName(rs.getString("Name"));
                    topic.setDescription(rs.getString("Description"));
                    topic.setDisplayIndex(rs.getInt("DisplayIndex"));
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
        return topic;
    }
}
