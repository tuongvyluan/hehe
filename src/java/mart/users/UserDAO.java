/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import mart.utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class UserDAO {

    private static final String LOGIN = "SELECT fullname, roleID, status FROM tblUsers WHERE userID=? AND password=?";
    private static final String CHECK_USER_ID = "SELECT userID FROM tblUsers WHERE userID=?";
    private static final String CREATE_USER = "INSERT INTO tblUsers "
            + "(userID, fullName, password, roleID, address, birthday, phone, email, status) "
            + "VALUES (?,?,?,?,?,?,?,?,'TRUE')";

    public static UserDTO checkLogin(String userID, String password) throws ClassNotFoundException, SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullname");
                    String roleID = rs.getString("roleID");
                    String status = rs.getString("status");
                    System.out.println(status);
                    if ("1".equals(status)) {
                        user = new UserDTO(userID, fullname, roleID, true);
                    } else {
                        user = new UserDTO(userID, fullname, roleID, false);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    /**
     * Check whether {@code userID} is valid: not duplicate, not be blank.
     *
     * @param userID
     * @return {@code true} if valid.
     */
    public static boolean checkUserID(String userID) throws SQLException {
        boolean check = false;
        if (!userID.isBlank()) {
            Connection conn = null;
            PreparedStatement ptm = null;
            ResultSet rs = null;
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    ptm = conn.prepareStatement(CHECK_USER_ID);
                    ptm.setString(1, userID);
                    rs = ptm.executeQuery();
                    if (!rs.next()) {
                        check = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ptm != null) {
                    ptm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        }
        return check;
    }

    public static boolean createUser(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_USER);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getPassword());
                ptm.setString(4, user.getRoleID());
                ptm.setString(5, user.getAddress());
                ptm.setString(6, user.getBirthday().toString());
                ptm.setString(7, user.getPhone());
                ptm.setString(8, user.getEmail());
                check = ptm.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
