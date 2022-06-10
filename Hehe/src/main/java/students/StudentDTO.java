package students;

import java.sql.Date;

public class StudentDTO {
    int studentId;
    String firstName;
    String lastName;
    Date dob;
    String email;
    String password;
    String phoneNumber;
    int status;
    String roleId;
    String createdAt;
    String updatedAt;

    public StudentDTO(int studentId, String firstName, String lastName, Date dob, String email, String password,
	    String phoneNumber, int status, String roleId, String createdAt, String updatedAt) {
	super();
	this.studentId = studentId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.email = email;
	this.password = password;
	this.phoneNumber = phoneNumber;
	this.status = status;
	this.roleId = roleId;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
    }

    public int getStudentId() {
	return studentId;
    }

    public void setStudentId(int studentId) {
	this.studentId = studentId;
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

    public Date getDob() {
	return dob;
    }

    public void setDob(Date dob) {
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

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public String getRoleId() {
	return roleId;
    }

    public void setRoleId(String roleId) {
	this.roleId = roleId;
    }

    public String getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
	return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
    }
//method

}
