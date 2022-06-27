/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInCourses;

import courses.CourseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import students.StudentDAO;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInCourseDAO {

    private StudentInCourseDTO studentInCourseDTO;
    private StudentInCourseModel studentInCourseModel;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;

    //Fields
    private final String STUDENT_IN_COURSE_DTO_FIELDS = "Id, StudentId, CourseId, "
            + "DisplayIndex, Status";

    //Sql queries
    private final String CHECK_ENROLLMENT = "SELECT " + STUDENT_IN_COURSE_DTO_FIELDS
            + " FROM StudentInCourse WHERE StudentId=? AND CourseId=?";

    
    // Not completed
    public StudentInCourseModel getModel(int studentId, int courseId) throws SQLException {
        studentInCourseModel = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_ENROLLMENT);
                ptm.setInt(1, studentId);
                ptm.setInt(2, courseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInCourseModel = new StudentInCourseModel();
                    studentInCourseModel.setCourse(courseDAO.get(courseId));
                    studentInCourseModel.setStudent(studentDAO.get(studentId));
                    studentInCourseModel.setStudentInCourseId(rs.getInt("Id"));
                    studentInCourseModel.setDisplayIndex(rs.getInt("DisplayIndex"));
                    studentInCourseModel.setStatus(rs.getString("Status"));
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
        return studentInCourseModel;
    }
    
    public StudentInCourseDTO getDTO(int studentId, int courseId) throws SQLException {
        studentInCourseDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_ENROLLMENT);
                ptm.setInt(1, studentId);
                ptm.setInt(2, courseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInCourseDTO = new StudentInCourseDTO();
                    studentInCourseDTO.setCourse(courseDAO.get(courseId));
                    studentInCourseDTO.setStudent(studentDAO.get(studentId));
                    studentInCourseDTO.setStudentInCourseId(rs.getInt("Id"));
                    studentInCourseDTO.setDisplayIndex(rs.getInt("DisplayIndex"));
                    studentInCourseDTO.setStatus(rs.getString("Status"));
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
        return studentInCourseDTO;
    }
}
