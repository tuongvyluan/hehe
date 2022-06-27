/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courses;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luan Tuong Vy
 */
public class CourseBUS {
    private CourseDAO dao;
    private CourseDTO courseDTO;
    private CourseModel courseModel;

    public ArrayList<CourseDTO> getCourses(int pageNumber, int rowsOfPage) throws SQLException {
        dao = new CourseDAO();
        ArrayList<CourseDTO> list = dao.get(pageNumber, rowsOfPage);
        return list;
    }
    
    public ArrayList<CourseDTO> getCoursesByCategory(int categoryId, int pageNumber, int rowsOfPage) throws SQLException {
        dao = new CourseDAO();
        ArrayList<CourseDTO> list = dao.getByCategory(categoryId, pageNumber, rowsOfPage);
        return list;
    }
    
    public CourseModel get(int courseId) throws SQLException {
        dao = new CourseDAO();
        courseModel = dao.get(courseId);
        return courseModel;
    }
}
