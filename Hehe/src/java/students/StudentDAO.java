package students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import utils.DAO;
import utils.DBUtils;
import utils.MyUtils;

public class StudentDAO implements DAO<StudentModel> {

    //All fields of a Student
    private final String STUDENT_MODEL_FIELDS = "id, firstName, lastName, dob, email, password, "
            + "phoneNumber, status, role, createdAt, updatedAt";

    //SQL query
    private final String PAGINATION = "DECLARE @PageNumber as INT " + "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
            + "SET @RowsOfPage = ? ";

    private final String GET_STUDENTS = "SELECT " + STUDENT_MODEL_FIELDS + " FROM Student ORDER BY createdAt "
            + "OFFSET (@PageNumber - 1) * @RowsOfPage ROWS FETCH NEXT @RowsOfPage ROWS ONLY";

    private final String GET_STUDENT_BY_EMAIL = "SELECT firstName FROM Student WHERE email=?";

    private final String CHECK_NORMAL_LOGIN = "SELECT " + STUDENT_MODEL_FIELDS
            + " FROM Student WHERE email=? AND password=?";

    @Override
    public List<StudentModel> get(int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<StudentModel> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(PAGINATION + GET_STUDENTS);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                rs = ptm.executeQuery();
                int id;
                String firstName;
                String lastName;
                LocalDate dob;
                String email;
                String password;
                String phoneNumber;
                String status;
                String role;
                LocalDate createdAt;
                LocalDate updatedAt;
                StudentModel student;
                while (rs.next()) {
                    id = rs.getInt("id");
                    firstName = rs.getString("firstName");
                    lastName = rs.getString("lastName");
                    dob = MyUtils.convertDateToLocalDate(rs.getDate("dob"));
                    email = rs.getString("email");
                    password = rs.getString("password");
                    phoneNumber = rs.getString("phoneNumber");
                    status = rs.getString("status");
                    role = rs.getString("roleId");
                    createdAt = MyUtils.convertDateToLocalDate(rs.getDate("createdAt"));
                    updatedAt = MyUtils.convertDateToLocalDate(rs.getDate("updatedAt"));
                    student = new StudentModel(id, firstName, lastName, dob, email, password, phoneNumber, status,
                            role, createdAt, updatedAt);
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
        return null;
    }

    @Override
    public Optional<StudentModel> get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(StudentModel t) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean update(StudentModel t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public StudentModel delete(StudentModel t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StudentModel delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public StudentModel get(String email) throws SQLException {
        StudentModel student = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_STUDENT_BY_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                System.out.println(ptm.toString());
                System.out.println(rs.toString());
                System.out.println("Start query");
                if (rs.next()) {
                    String firstName = rs.getString("firstName");
                    System.out.print("check in DAO");
                    student = new StudentModel();
                    student.setFirstName(firstName);
                    student.setEmail(email);
                }
            }
        } catch (Exception e) {
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
        StudentModel student = null;
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
                    String role = rs.getString("role");
                    LocalDate createdAt = MyUtils.convertDateToLocalDate(rs.getDate("createdAt"));
                    LocalDate updatedAt = MyUtils.convertDateToLocalDate(rs.getDate("updatedAt"));
                    student = new StudentModel(id, firstName, lastName, dob,
                            email, password, phoneNumber, status, role,
                            createdAt, updatedAt);
                }
            }
        } catch (Exception e) {
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
