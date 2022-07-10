/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInTopics;

import java.sql.SQLException;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInTopicBUS {

    StudentInTopicDAO dao;
    StudentInTopicDTO dto;

    public StudentInTopicDTO getDTO(int studentCourseId, int topicId) throws SQLException {
        dao = new StudentInTopicDAO();
        dto = dao.getDTO(studentCourseId, topicId);
        return dto;
    }

    public StudentInTopicDTO insert(int studentCourseId, int topicId, String status) throws SQLException {
        dao = new StudentInTopicDAO();
        dto = dao.insert(studentCourseId, topicId, status);
        return dto;
    }

    public StudentInTopicDTO updateStatus(int studentTopicId, String status) throws SQLException {
        dao = new StudentInTopicDAO();
        dto = dao.updateStatus(studentTopicId, status);
        return dto;
    }
}
