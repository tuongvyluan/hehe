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
 * @author admin
 */
public class TopicDAO {

    private TopicDTO topicDTO;

    //sql queries
    private final String GET_TOPICS_BY_COURSE = "SELECT Id, Name, Description, DisplayIndex FROM Topic WHERE SectionId=? ORDER BY DisplayIndex";

    public ArrayList<TopicDTO> get(int sectionId) throws SQLException {
        ArrayList<TopicDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_TOPICS_BY_COURSE);
                ptm.setInt(1, sectionId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    topicDTO =new TopicDTO();
                    topicDTO.setSectionId(sectionId);
                    topicDTO.setTopicId(rs.getInt("Id"));
                    topicDTO.setTopicName(rs.getString("Name"));
                    topicDTO.setDisplayIndex(rs.getInt("DisplayIndex"));
                    list.add(topicDTO);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
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
