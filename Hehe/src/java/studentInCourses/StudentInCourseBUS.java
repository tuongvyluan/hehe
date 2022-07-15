/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInCourses;

import courses.CourseDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInCourseBUS {
    
    private StudentInCourseDAO dao;
    
    public StudentInCourseModel enrollCourse(int studentId, int courseId) {
        StudentInCourseModel enrollment = null;
        try {
            dao = new StudentInCourseDAO();
            enrollment = dao.insert(studentId, courseId);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return enrollment;
    }

    public ArrayList<CourseDTO> getStudyingCourses(int studentId) throws SQLException {
        dao = new StudentInCourseDAO();
        ArrayList<CourseDTO> list = dao.getStudyingCourses(studentId);
        return list;
    }

    public ArrayList<CourseDTO> getCompletedCourses(int studentId) throws SQLException {
        dao = new StudentInCourseDAO();
        ArrayList<CourseDTO> list = dao.getCompletedCourses(studentId);
        return list;
    }
}
