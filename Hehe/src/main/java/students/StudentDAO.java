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

    private String PAGINATION = "DECLARE @PageNumber as INT " + "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
	    + "SET @RowsOfPage = ? ";
    private String GET_STUDENTS = "SELECT id, firstName, lastName, dob, email, password, "
	    + "phoneNumber, status, role, createdAt, updatedAt " + "FROM Student ORDER BY createdAt "
	    + "OFFSET (@PageNumber - 1) * @RowsOfPage ROWS FETCH NEXT @RowsOfPage ROWS ONLY";

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
		int status;
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
		    status = rs.getInt("status");
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

}
