/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.users;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Luan Tuong Vy
 */
public class UserDTO {

    private String userID;
    private String fullName;
    private String password;
    private String roleID;
    private String address;
    private LocalDate birthday;
    private String phone;
    private String email;
    private boolean status;

    public UserDTO() {
        this.userID = "";
        this.fullName = "";
        this.password = "";
        this.roleID = "";
        this.address = "";
        this.birthday = null;
        this.phone = "";
        this.email = "";
        this.status = false;
    }

    public UserDTO(String userID, String fullName, String password,
            String roleID, String address, LocalDate birthday, String phone,
            String email, boolean status) {
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

    public UserDTO(String fullName, String roleID, boolean status) {
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
    
    public UserDTO(String userID, String fullName, String roleID, boolean status) {
        this.fullName = fullName;
        this.roleID = roleID;
        this.userID = userID;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getFormattedBirthday() {
        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd-mm-YYYY");
        String strBirthday = "";
        if (birthday != null) {
            strBirthday = birthday.format(myDateFormat);
        }
        return strBirthday;
    }

    public void setBirthday(LocalDate birthday) {
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", fullName=" + fullName
                + ", password=" + password + ", roleID=" + roleID + ", address="
                + address + ", birthday=" + birthday + ", phone=" + phone
                + ", email=" + email + ", status=" + status + '}';
    }
}
