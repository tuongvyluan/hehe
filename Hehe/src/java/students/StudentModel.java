package students;

import java.time.LocalDate;

public class StudentModel {
    
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;
    private String password;
    private String phoneNumber;
    private String status;
    private String role;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public StudentModel(int id, String firstName, String lastName, LocalDate dob, String email, String password,
	    String phoneNumber, String status, String role, LocalDate createdAt, LocalDate updatedAt) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.email = email;
	this.password = password;
	this.phoneNumber = phoneNumber;
	this.status = status;
	this.role = role;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
    }
    
    public StudentModel() {
	
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public LocalDate getDob() {
	return dob;
    }

    public void setDob(LocalDate dob) {
	this.dob = dob;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public LocalDate getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
	this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
	return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
	this.updatedAt = updatedAt;
    }
    
    public StudentDTO toDTO() {
        return new StudentDTO(id, firstName, lastName, dob, email, phoneNumber);
    }
//method

    @Override
    public String toString() {
	return "StudentModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
		+ ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", status=" + status
		+ ", role=" + role + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    

}
