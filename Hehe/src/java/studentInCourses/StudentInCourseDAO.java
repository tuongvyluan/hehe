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
import java.time.LocalDate;
import students.StudentDAO;
import utils.DBUtils;
import utils.MyUtils;

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
            + "Status";
    private final String STUDENT_IN_COURSE_MODEL_FIELDS = "Id, StudentId, CourseId, "
            + "Certificate, Status";

    //Sql queries
    private final String GET_ENROLLMENT = "SELECT " + STUDENT_IN_COURSE_MODEL_FIELDS
            + " FROM StudentInCourse WHERE StudentId=? AND CourseId=?";

    private final String ENROLL = "INSERT INTO StudentInCourse "
            + "(StudentId, CourseId, StartDate, Certificate, Status) "
            + "VALUES (?,?,?,?,?)";

    // Not completed?
    public StudentInCourseModel getModel(int studentId, int courseId) throws SQLException {
        studentInCourseModel = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ENROLLMENT);
                ptm.setInt(1, studentId);
                ptm.setInt(2, courseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInCourseModel = new StudentInCourseModel();
                    studentInCourseModel.setCourseId(courseId);
                    studentInCourseModel.setStudentId(studentId);
                    studentInCourseModel.setStudentInCourseId(rs.getInt("Id"));
                    studentInCourseModel.setStatus(rs.getString("Status"));
                    studentInCourseModel.setCertificate(rs.getString("Certificate"));
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
                ptm = conn.prepareStatement(GET_ENROLLMENT);
                ptm.setInt(1, studentId);
                ptm.setInt(2, courseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInCourseDTO = new StudentInCourseDTO();
                    studentInCourseModel.setCourseId(courseId);
                    studentInCourseModel.setStudentId(studentId);
                    studentInCourseDTO.setStudentInCourseId(rs.getInt("Id"));
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

    public StudentInCourseModel insert(int studentId, int courseId) throws SQLException {
        studentInCourseModel = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ENROLL);
                ptm.setInt(1, studentId);
                ptm.setInt(2, courseId);
                ptm.setString(3, LocalDate.now().toString());
                ptm.setString(4, "null");
                ptm.setString(5, "Studying");
                if (ptm.executeUpdate() == 1) {
                    studentInCourseModel = getModel(studentId, courseId);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return studentInCourseModel;
    }
}
