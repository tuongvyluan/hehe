package students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import utils.DBUtils;
import utils.MyUtils;

public class StudentDAO {

    private StudentModel student;

    //All fields of a Student
    private final String STUDENT_MODEL_FIELDS = "id, firstName, lastName, dob, email, password, "
            + "phoneNumber, status, createdAt, updatedAt";

    //SQL query
    private final String DECLARE_PAGINATION = "DECLARE @PageNumber as INT " + "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
            + "SET @RowsOfPage = ? ";

    private final String PAGINATION = "OFFSET (@PageNumber - 1) * @RowsOfPage "
            + "ROWS FETCH NEXT @RowsOfPage ROWS ONLY";

    private final String GET_STUDENTS = "SELECT " + STUDENT_MODEL_FIELDS + " FROM Student ORDER BY createdAt "
            + PAGINATION;

    private final String GET_STUDENT_BY_EMAIL = "SELECT " + STUDENT_MODEL_FIELDS + " FROM Student WHERE email=?";

    private final String GET_STUDENT_BY_ID = "SELECT " + STUDENT_MODEL_FIELDS + " FROM Student WHERE Id=?";

    private final String CHECK_NORMAL_LOGIN = "SELECT " + STUDENT_MODEL_FIELDS
            + " FROM Student WHERE email=? AND password=?";

    private final String CREATE_STUDENT = "INSERT INTO Student "
            + "(status, email, password, firstName, lastName, dob, phoneNumber) VALUES "
            + "('ACTIVE', ?, ?, ?, ?, ?, ?)";

    public List<StudentModel> get(int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<StudentModel> list = new ArrayList<>();
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
                ptm = conn.prepareStatement(DECLARE_PAGINATION + GET_STUDENTS);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    student = new StudentModel();
                    student.setId(rs.getInt("id"));
                    student.setFirstName(rs.getString("firstName"));
                    student.setLastName(rs.getString("lastName"));
                    student.setDob(MyUtils.convertDateToLocalDate(rs.getDate("dob")));
                    student.setEmail(rs.getString("email"));
                    student.setPassword(rs.getString("password"));
                    student.setPhoneNumber(rs.getString("phoneNumber"));
                    student.setStatus(rs.getString("status"));
                    student.setCreatedAt(MyUtils.convertDateToLocalDate(rs.getDate("createdAt")));
                    student.setUpdatedAt(MyUtils.convertDateToLocalDate(rs.getDate("updatedAt")));
                    list.add(student);
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

    public StudentModel get(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        student = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_BY_ID);
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    student = new StudentModel();
                    student.setId(id);
                    student.setFirstName(rs.getString("firstName"));
                    student.setLastName(rs.getString("lastName"));
                    student.setDob(MyUtils.convertDateToLocalDate(rs.getDate("dob")));
                    student.setEmail(rs.getString("email"));
                    student.setPassword(rs.getString("password"));
                    student.setPhoneNumber(rs.getString("phoneNumber"));
                    student.setStatus(rs.getString("status"));
                    student.setCreatedAt(MyUtils.convertDateToLocalDate(rs.getDate("createdAt")));
                    student.setUpdatedAt(MyUtils.convertDateToLocalDate(rs.getDate("updatedAt")));
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
        return student;
    }

    public boolean add(StudentModel student) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null && student != null) {
                ptm = conn.prepareStatement(CREATE_STUDENT);
                ptm.setString(1, student.getEmail());
                ptm.setString(2, student.getPassword());
                ptm.setString(3, student.getFirstName() == null ? "" : student.getFirstName());
                ptm.setString(4, student.getLastName() == null ? "" : student.getLastName());
                ptm.setString(5, student.getLastName() == null ? LocalDate.now().toString() : student.getDob().toString());
                ptm.setString(6, student.getPhoneNumber() == null ? "" : student.getPhoneNumber());
                check = ptm.executeUpdate() == 1;
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
        return check;
    }

    public StudentModel delete(StudentModel t) {
        // TODO Auto-generated method stub
        return null;
    }

    public StudentModel delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Check whether there is any student using the email in parameter.
     *
     * @param email
     * @return {@code true} if the email already exists.
     * @throws SQLException
     */
    public boolean checkEmail(String email) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_BY_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public StudentModel get(String email) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        student = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_BY_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    student = new StudentModel();
                    student.setId(rs.getInt("id"));
                    student.setFirstName(rs.getString("firstName"));
                    student.setLastName(rs.getString("lastName"));
                    student.setDob(MyUtils.convertDateToLocalDate(rs.getDate("dob")));
                    student.setEmail(rs.getString("email"));
                    student.setPassword(rs.getString("password"));
                    student.setPhoneNumber(rs.getString("phoneNumber"));
                    student.setStatus(rs.getString("status"));
                    student.setCreatedAt(MyUtils.convertDateToLocalDate(rs.getDate("createdAt")));
                    student.setUpdatedAt(MyUtils.convertDateToLocalDate(rs.getDate("updatedAt")));
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
        return student;
    }

    public StudentModel get(String email, String password) throws SQLException {
        student = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_NORMAL_LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    System.out.println("Found");
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    LocalDate dob = MyUtils.convertDateToLocalDate(rs.getDate("dob"));
                    String phoneNumber = rs.getString("phoneNumber");
                    String status = rs.getString("status");
                    LocalDate createdAt = MyUtils.convertDateToLocalDate(rs.getDate("createdAt"));
                    LocalDate updatedAt = MyUtils.convertDateToLocalDate(rs.getDate("updatedAt"));
                    student = new StudentModel(id, firstName, lastName, dob,
                            email, password, phoneNumber, status, createdAt, updatedAt);
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
        return student;
    }
}
