/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.users;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Luan Tuong Vy
 */
public class UserError {
    
    private String userID;
    private String fullName;
    private String password;
    private String roleID;
    private String address;
    private String birthday;
    private String phone;
    private String email;
    private String status;

    public UserError() {
        this.userID = "";
        this.fullName = "";
        this.password = "";
        this.roleID = "";
        this.address = "";
        this.birthday = "";
        this.phone = "";
        this.email = "";
        this.status = "";
    }

    public UserError(String userID, String fullName, String password,
            String roleID, String address, String birthday, String phone,
            String email, String status) {
        this.userID = userID;
        this.fullName = fullName;
        this.password = password;
        this.roleID = roleID;
        this.address = address;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public UserError(String fullName, String roleID, String status) {
        this.fullName = fullName;
        this.roleID = roleID;
        this.userID = "";
        this.password = "";
        this.address = "";
        this.birthday = null;
        this.phone = "";
        this.email = "";
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<String> getAllErrors() {
        ArrayList<String> error = new ArrayList();
        if (!userID.isEmpty()) {
            error.add(userID);
        }
        if (!fullName.isEmpty()) {
            error.add(fullName);
        }
        if (!password.isEmpty()) {
            error.add(password);
        }
        if (!roleID.isEmpty()) {
            error.add(roleID);
        }
        if (!address.isEmpty()) {
            error.add(address);
        }
        if (!birthday.isEmpty()) {
            error.add(birthday);
        }
        if (!phone.isEmpty()) {
            error.add(phone);
        }
        if (!email.isEmpty()) {
            error.add(email);
        }
        if (!status.isEmpty()) {
            error.add(status);
        }
        return error;
    }

    @Override
    public String toString() {
        return "UserError{" + "userID=" + userID + ", fullName=" + fullName
                + ", password=" + password + ", roleID=" + roleID + ", address="
                + address + ", birthday=" + birthday + ", phone=" + phone
                + ", email=" + email + ", status=" + status + '}';
    }
}
