/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sections;

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
public class SectionDAO {
    
    private SectionDTO sectionDTO;
    
    //Fields
    private final String SECTION_DTO_FIELDS = "Id, Name, DisplayIndex";
    
    //Sql queries
    private final String GET_SECTIONS_BY_COURSE = "SELECT " + SECTION_DTO_FIELDS
            + " FROM Section WHERE CourseId=? ORDER BY DisplayIndex";
    
    public ArrayList<SectionDTO> get(int courseId) throws SQLException {
        ArrayList<SectionDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SECTIONS_BY_COURSE);
                ptm.setInt(1, courseId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    sectionDTO = new SectionDTO();
                    sectionDTO.setCourseId(courseId);
                    sectionDTO.setSectionId(rs.getInt("Id"));
                    sectionDTO.setSectionName(rs.getString("Name"));
                    sectionDTO.setDisplayIndex(rs.getInt("DisplayIndex"));
                    list.add(sectionDTO);
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
