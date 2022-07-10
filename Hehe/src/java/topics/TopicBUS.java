/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topics;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Luan Tuong Vy
 */
public class TopicBUS {
    private TopicDAO dao;
    private TopicDTO topicDTO;
    private TopicModel topicModel;
    
    public ArrayList<TopicDTO> get(int sectionId) throws SQLException {
        dao = new TopicDAO();
        ArrayList<TopicDTO> list = dao.get(sectionId);
        return list;
    }
    
    public TopicModel getContent(int topicId) throws SQLException {
        dao = new TopicDAO();
        topicModel = dao.getContent(topicId);
        return topicModel;
    }
    
    public TopicModel getNextContent(int courseId, int displayIndex) throws SQLException {
        dao = new TopicDAO();
        topicModel = dao.getNextContent(courseId, displayIndex);
        return topicModel;
    }
    
    public TopicModel getPrevContent(int courseId, int displayIndex) throws SQLException {
        dao = new TopicDAO();
        topicModel = dao.getPrevContent(courseId, displayIndex);
        return topicModel;
    }
}
