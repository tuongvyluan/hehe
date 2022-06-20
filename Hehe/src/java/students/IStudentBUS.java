package students;

import java.sql.SQLException;

public interface IStudentBUS {
    
    public StudentModel checkLogin(String email, String password) throws SQLException;
    
    public StudentModel checkLogin(String email) throws SQLException ;
    
    public StudentDTO getStudent(String email);
    
    public StudentDTO getStudent(int id);
    
}
