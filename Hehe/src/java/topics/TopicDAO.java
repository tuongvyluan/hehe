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
    private final String COUNT_TOPICS_BY_COURSE = "SELECT Count(Id) AS [Count] FROM Topic WHERE CourseId=? AND Status='ACTIVE'";
    
    private final String GET_TOPICS_BY_SECTION = "SELECT " + TOPIC_DTO_FIELDS
            + " FROM Topic WHERE SectionId=? AND Status='ACTIVE' ORDER BY DisplayIndex";

    private final String GET_TOPIC_CONTENT = "SELECT " + TOPIC_CONTENT
            + " FROM Topic WHERE Id=? AND Status='ACTIVE'";

    private final String GET_NEXT_TOPIC_ID = "SELECT TOP(1) Id"
            + " FROM Topic WHERE CourseId=? AND DisplayIndex>? AND Status='ACTIVE' ORDER BY DisplayIndex ASC";
    
    private final String GET_PREV_TOPIC_ID = "SELECT TOP(1) Id"
            + " FROM Topic WHERE CourseId=? AND DisplayIndex<? AND Status='ACTIVE' ORDER BY DisplayIndex DESC";

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

    public int getNextTopicId(int courseId, int displayIndex) throws SQLException {
        int topicId = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_NEXT_TOPIC_ID);
                ptm.setInt(1, courseId);
                ptm.setInt(2, displayIndex);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    topicId = rs.getInt("Id");
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
        return topicId;
    }
    
    public int getPrevTopicId(int courseId, int displayIndex) throws SQLException {
        int topicId = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PREV_TOPIC_ID);
                ptm.setInt(1, courseId);
                ptm.setInt(2, displayIndex);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    topicId = rs.getInt("Id");
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
        return topicId;
    }
    
    public int countTopicsByCourse(int courseId) throws SQLException {
        int count = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(COUNT_TOPICS_BY_COURSE);
                ptm.setInt(1, courseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("Count");
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
        return count;
    }
}
