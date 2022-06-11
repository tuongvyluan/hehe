package DTO;

public class Admin {
	int adminId;
	String name;
	String password;
	String email;
	String roleId;
	String createdAt;
    String updatedAt;
    
    //cons
	public Admin(int adminId, String name, String password, String email, String roleId, String createdAt,
			String updatedAt) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.roleId = roleId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	//getter setter
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
