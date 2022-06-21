package students;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public StudentDTO getStudent(String email) {
        StudentDTO student = null;
        // TODO Auto-generated method stub
        return student;
    }

    @Override
    public StudentDTO getStudent(int id) {
        StudentDTO student = null;
        // TODO Auto-generated method stub
        return student;
    }

    @Override
    public StudentError register(StudentModel student) {
        StudentError error = null;
        if (student != null) {
            StudentDAO dao = new StudentDAO();
            try {
                if (dao.checkEmail(student.getEmail())) {
                    error = new StudentError();
                    error.setEmail("This email is already used.");
                } else {
                    if (!dao.add(student)) {
                        error = new StudentError();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentBUS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return error;
    }
}
