package students;

import java.sql.SQLException;

public class StudentBUS implements IStudentBUS {

    @Override
    public StudentModel checkLogin(String email, String password) throws SQLException {
	StudentDAO dao = new StudentDAO();
	StudentModel student = dao.get(email, password);
        System.out.println(student.toString());
	return student;
    }

    @Override
    public StudentModel checkLogin(String email) throws SQLException {
	StudentDAO dao = new StudentDAO();
	StudentModel student = dao.get(email);
	return student;
    }

    public StudentDTO getStudent(String email) {
	StudentDTO student = null;
	// TODO Auto-generated method stub
	return student;
    }
    
    public StudentDTO getStudent(int id) {
	StudentDTO student = null;
	// TODO Auto-generated method stub
	return student;
    }
}
