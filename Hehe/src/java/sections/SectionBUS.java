/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sections;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luan Tuong Vy
 */
public class SectionBUS {
    
    private SectionDAO dao;
    private SectionDTO sectionDTO;
    private SectionModel sectionModel;
    
    public ArrayList<SectionDTO> get(int courseId) throws SQLException {
        dao = new SectionDAO();
        ArrayList<SectionDTO> list = dao.get(courseId);
        return list;
    }
}
