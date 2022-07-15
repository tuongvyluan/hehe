/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courses;

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
public class CourseDAO {

    private CourseDTO courseDTO;

    //Fields
    private final String COURSE_DTO_FIELDS = "Id, Name, CategoryId";
    private final String COURSE_MODEL_FIELDS = "Id, Name, CategoryId, AuthorId,"
            + "Description, Price, Duration";
    private final String COURSE_INTRO_FIELDS = "Id, Name, AuthorId, Duration";

    //Pagination
    private final String DECLARE_PAGINATION = "DECLARE @PageNumber as INT "
            + "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
            + "SET @RowsOfPage = ? ";

    private final String PAGINATION = "OFFSET (@PageNumber - 1) * @RowsOfPage "
            + "ROWS FETCH NEXT @RowsOfPage ROWS ONLY";

    //SQL query
    private final String GET_COURSES = DECLARE_PAGINATION + "SELECT " + COURSE_DTO_FIELDS
            + " FROM Course ORDER BY UpdatedAt " + PAGINATION;

    private final String GET_COURSES_BY_CATEGORY = DECLARE_PAGINATION + "SELECT "
            + COURSE_INTRO_FIELDS
            + " FROM Course WHERE Status='Active' AND CategoryId = ? ORDER BY UpdatedAt " + PAGINATION;

    private final String GET_COURSE = "SELECT " + COURSE_MODEL_FIELDS
            + " FROM Course WHERE Id=?";

    public ArrayList<CourseDTO> get(int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<CourseDTO> list = new ArrayList<>();
        if (pageNumber <= 0) {
            pageNumber = 1;
        }

        if (rowsOfPage <= 0) {
            rowsOfPage = 1;
        }

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_COURSES);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    courseDTO = new CourseDTO();
                    courseDTO.setCourseId(rs.getInt("Id"));
                    courseDTO.setCourseName(rs.getString("Name"));
                    courseDTO.setCategoryId(rs.getInt("CategoryId"));
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

    public ArrayList<CourseDTO> getByCategory(int categoryId, int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<CourseDTO> list = new ArrayList<>();
        if (pageNumber <= 0) {
            pageNumber = 1;
        }

        if (rowsOfPage <= 0) {
            rowsOfPage = 1;
        }

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_COURSES_BY_CATEGORY);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                ptm.setInt(3, categoryId);
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

    public CourseModel get(int courseId) throws SQLException {
        CourseModel course = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_COURSE);
                ptm.setInt(1, courseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    course = new CourseModel();
                    course.setCourseId(rs.getInt("Id"));
                    course.setCourseName(rs.getString("Name"));
                    course.setCategoryId(rs.getInt("CategoryId"));
                    course.setAuthorId(rs.getInt("AuthorId"));
                    course.setDescription(rs.getString("Description"));
                    course.setPrice(rs.getDouble("Price"));
                    course.setDuration(rs.getDouble("Duration"));
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
        return course;
    }
}
