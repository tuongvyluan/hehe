package authors;

public class AuthorModel {
    int authorId;
    String roleId;
    String firstName;
    String lastName;
    String phoneName;
    String email;
    String password;
    String createdAt;
    String updatedAt;

    public AuthorModel(int authorId, String roleId, String firstName, String lastName, String phoneName, String email,
	    String password, String createdAt, String updatedAt) {
	super();
	this.authorId = authorId;
	this.roleId = roleId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneName = phoneName;
	this.email = email;
	this.password = password;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
    }

    public int getAuthorId() {
	return authorId;
    }

    public void setAuthorId(int authorId) {
	this.authorId = authorId;
    }

    public String getRoleId() {
	return roleId;
    }

    public void setRoleId(String roleId) {
	this.roleId = roleId;
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

    public String getPhoneName() {
	return phoneName;
    }

    public void setPhoneName(String phoneName) {
	this.phoneName = phoneName;
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

}
