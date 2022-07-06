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

    //Sql queries
    private final String GET_TOPICS_BY_SECTION = "SELECT " + TOPIC_DTO_FIELDS
            + " FROM Topic WHERE SectionId=? ORDER BY DisplayIndex";

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
}
