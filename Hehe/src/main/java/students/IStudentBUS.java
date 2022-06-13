package students;

public interface IStudentBUS {
    
    public boolean checkPassword(String email, String password);
    
    public StudentDTO getStudent(String email);
    
    public StudentDTO getStudent(int id);
    
    
}
