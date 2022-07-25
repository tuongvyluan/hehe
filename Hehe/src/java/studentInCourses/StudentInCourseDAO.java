/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentInCourses;

import courses.CourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentInCourseDAO {

    private StudentInCourseDTO studentInCourseDTO;
    private StudentInCourseModel studentInCourseModel;

    //Fields
    private final String STUDENT_IN_COURSE_MODEL_FIELDS = "Id, StudentId, CourseId, "
            + "Certificate";
    private final String COURSE_INTRO_FIELDS = "Id, Name, AuthorId, Duration";

    //Sql queries
    private final String GET_STUDENT_COURSE = "SELECT " + STUDENT_IN_COURSE_MODEL_FIELDS
            + " FROM StudentInCourse WHERE StudentId=? AND CourseId=?";
    
    private final String GET_STUDENT_COURSE_BY_ID = "SELECT " + STUDENT_IN_COURSE_MODEL_FIELDS
            + " FROM StudentInCourse WHERE Id=?";

    private final String ENROLL = "INSERT INTO StudentInCourse "
            + "(StudentId, CourseId, StartDate, Certificate, Status) "
            + "VALUES (?,?,?,?,?)";

    private final String GET_STUDYING_COURSES = "SELECT c." + COURSE_INTRO_FIELDS
            + " FROM Course c JOIN StudentInCourse s ON c.Id=s.CourseId "
            + " WHERE StudentId=? AND c.Status='ACTIVE'";

    public StudentInCourseModel getModel(int studentId, int courseId) throws SQLException {
        studentInCourseModel = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_COURSE);
                ptm.setInt(1, studentId);
                ptm.setInt(2, courseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInCourseModel = new StudentInCourseModel();
                    studentInCourseModel.setCourseId(courseId);
                    studentInCourseModel.setStudentId(studentId);
                    studentInCourseModel.setStudentInCourseId(rs.getInt("Id"));
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
    
    public StudentInCourseModel getModel(int studentCourseId) throws SQLException {
        studentInCourseModel = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_COURSE_BY_ID);
                ptm.setInt(1, studentCourseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInCourseModel = new StudentInCourseModel();
                    studentInCourseModel.setCourseId(rs.getInt("CourseId"));
                    studentInCourseModel.setStudentId(rs.getInt("StudentId"));
                    studentInCourseModel.setStudentInCourseId(studentCourseId);
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
    
    public StudentInCourseDTO getDTO(int studentCourseId) throws SQLException {
        studentInCourseDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_COURSE_BY_ID);
                ptm.setInt(1, studentCourseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInCourseDTO = new StudentInCourseDTO();
                    studentInCourseDTO.setCourseId(rs.getInt("CourseId"));
                    studentInCourseDTO.setStudentId(rs.getInt("StudentId"));
                    studentInCourseDTO.setStudentInCourseId(studentCourseId);
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

    public StudentInCourseDTO getDTO(int studentId, int courseId) throws SQLException {
        studentInCourseDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_COURSE);
                ptm.setInt(1, studentId);
                ptm.setInt(2, courseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    studentInCourseDTO = new StudentInCourseDTO();
                    studentInCourseModel.setCourseId(courseId);
                    studentInCourseModel.setStudentId(studentId);
                    studentInCourseDTO.setStudentInCourseId(rs.getInt("Id"));
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
    
    public ArrayList<CourseDTO> getStudyingCourses(int studentId) throws SQLException {
        ArrayList<CourseDTO> list = new ArrayList<>();
        CourseDTO courseDTO;

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDYING_COURSES);
                ptm.setInt(1, studentId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    courseDTO = new CourseDTO();
                    courseDTO.setCourseId(rs.getInt("Id"));
                    courseDTO.setAuthorId(rs.getInt("AuthorId"));
                    courseDTO.setCourseName(rs.getString("Name"));
                    courseDTO.setDuration(rs.getDouble("Duration"));
                    list.add(courseDTO);
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
