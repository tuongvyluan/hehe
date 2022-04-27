/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import mart.products.ProductDTO;
import mart.utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class OrderDAO {

    private static final String CHECK_CART = "SELECT orderID, total FROM tblOrders WHERE "
            + "userID=? AND status=0";
    private static final String CREATE_CART = "INSERT INTO tblOrders (total, userID, status) "
            + "VALUES (0,?,0)";
    private static final String GET_ORDER = "SELECT orderDate, total, userID, status "
            + "FROM tblOrders WHERE orderID=?";
    private static final String GET_ORDER_DETAILS = "SELECT detailID, price, quantity, "
            + "productID, batchNumber FROM tblOrderDetails WHERE orderID=?";
    private static final String GET_DETAIL_FROM_CART = "SELECT price, detailID, quantity FROM "
            + "tblOrderDetails WHERE orderID=? AND productID=? AND batchNumber=?";
    private static final String GET_DETAIL_ID_FROM_CART = "SELECT detailID FROM "
            + "tblOrderDetails WHERE orderID=? AND productID=? AND batchNumber=?";
    private static final String CREATE_ORDER_DETAILS = "INSERT INTO tblOrderDetails "
            + "(price, quantity, orderID, productID, batchNumber) VALUES "
            + "(?,?,?,?,?)";
    private static final String UPDATE_ORDER_DETAILS = "UPDATE tblOrderDetails "
            + "SET quantity=? WHERE detailID=?";
    private static final String REMOVE_ORDER_DETAILS = "DELETE FROM tblOrderDetails "
            + "WHERE detailID=?";
    private static final String CHECK_DETAIL_QUANTITY
            = "SELECT od.detailID, od.productID, od.batchNumber, "
            + "pr.quantity AS [availableQuantity], od.quantity AS [orderQuantity], "
            + "status, usingDate "
            + "FROM tblOrderDetails od "
            + "JOIN tblProducts pr "
            + "ON od.productID = pr.productID AND od.batchNumber = pr.batchNumber "
            + "WHERE (od.quantity > pr.quantity OR pr.status=0 OR pr.usingDate < GETDATE()) "
            + "AND od.orderID=?";
    private static final String UPDATE_PRODUCT = "UPDATE tblProducts "
            + "SET quantity=(quantity - ?) WHERE productID=? AND batchNumber=?";
    private static final String COMPLETE_ORDER = "UPDATE tblOrders "
            + "SET status='TRUE', orderDate=GETDATE() WHERE orderID=?";

    public static OrderDTO prepareCart(String userID) throws SQLException {
        OrderDTO order = null;
        int orderID = 0;
        double total = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_CART);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    orderID = rs.getInt("orderID");
                    total = rs.getDouble("total");
                    order = new OrderDTO(orderID, total, userID, false);
                } else {
                    ptm = conn.prepareStatement(CREATE_CART);
                    ptm.setString(1, userID);
                    check = ptm.executeUpdate() > 0;
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
            if (check) {
                order = prepareCart(userID);
            }
        }
        return order;
    }

    public static OrderDTO getOrder(int orderID) throws SQLException {
        OrderDTO order = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ORDER);
                ptm.setInt(1, orderID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    LocalDate orderDate = null;
                    if (rs.getString("orderDate") != null) {
                        orderDate = LocalDate.parse(rs.getString("orderDate"));
                    }
                    double total = rs.getDouble("total");
                    String userID = rs.getString("userID");
                    boolean status = rs.getBoolean("status");
                    order = new OrderDTO(orderID, orderDate, total, userID, status);
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
        return order;
    }

    /**
     * Get a HashMap with key is {@code productID} and value is the
     * {@code OrderDetails}, whose {@code orderID} equals to the parameter.
     *
     * @param orderID
     * @return HashMap with key is {@code productID} and value is the
     * {@code OrderDetails}
     * @throws SQLException
     */
    public static Map<Integer, OrderDetailsDTO> getAllOrderDetails(int orderID) throws SQLException {
        HashMap<Integer, OrderDetailsDTO> map = new HashMap<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ORDER_DETAILS);
                ptm.setInt(1, orderID);
                rs = ptm.executeQuery();
                OrderDetailsDTO orderDetails;
                int detailID;
                double price;
                int quantity;
                String productID;
                int batchNumber;
                while (rs.next()) {
                    detailID = rs.getInt("detailID");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    productID = rs.getString("productID");
                    batchNumber = rs.getInt("batchNumber");
                    orderDetails = new OrderDetailsDTO(detailID, price, quantity,
                            productID, productID, batchNumber);
                    map.put(detailID, orderDetails);
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
        return map;
    }

    public static OrderDetailsDTO getDetailID(int orderID, String productID,
            int batchNumber) throws SQLException {
        OrderDetailsDTO detail = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_DETAIL_FROM_CART);
                ptm.setInt(1, orderID);
                ptm.setString(2, productID);
                ptm.setInt(3, batchNumber);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    double price = rs.getDouble("price");
                    int detailID = rs.getInt("detailID");
                    int quantity = rs.getInt("quantity");
                    detail = new OrderDetailsDTO(detailID, price, quantity,
                            productID, productID, batchNumber);
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
        return detail;
    }

    public static int createOrderDetails(int orderID, ProductDTO product) throws SQLException {
        int detailID = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null && product != null) {
                ptm = conn.prepareStatement(CREATE_ORDER_DETAILS);
                double price = product.getPrice();
                int quantity = product.getQuantity();
                String productID = product.getProductID();
                int batchNumber = product.getBatchNumber();
                ptm.setDouble(1, price);
                ptm.setInt(2, quantity);
                ptm.setInt(3, orderID);
                ptm.setString(4, productID);
                ptm.setInt(5, batchNumber);
                if (ptm.executeUpdate() > 0) {
                    ptm = conn.prepareStatement(GET_DETAIL_ID_FROM_CART);
                    ptm.setInt(1, orderID);
                    ptm.setString(2, productID);
                    ptm.setInt(3, batchNumber);
                    rs = ptm.executeQuery();
                    if (rs.next()) {
                        detailID = rs.getInt("detailID");
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
        return detailID;
    }

    public static boolean updateOrderDetails(int detailID, int newQuantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null && newQuantity > 0) {
                ptm = conn.prepareStatement(UPDATE_ORDER_DETAILS);
                ptm.setInt(1, newQuantity);
                ptm.setInt(2, detailID);
                if (ptm.executeUpdate() > 0) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public static boolean removeOrderDetails(int detailID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(REMOVE_ORDER_DETAILS);
                ptm.setInt(1, detailID);
                if (ptm.executeUpdate() > 0) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public static Map<Integer, String> checkOut(int orderID) throws SQLException {
        HashMap<Integer, String> errors = new HashMap<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DETAIL_QUANTITY);
                ptm.setInt(1, orderID);
                rs = ptm.executeQuery();
                int detailID;
                int availableQuantity;
                int orderQuantity;
                String productID;
                int batchNumber;
                boolean status;
                String message;
                LocalDate usingDate;
                while (rs.next()) {
                    detailID = rs.getInt("detailID");
                    batchNumber = rs.getInt("batchNumber");
                    productID = rs.getString("productID");
                    availableQuantity = rs.getInt("availableQuantity");
                    orderQuantity = rs.getInt("orderQuantity");
                    status = rs.getBoolean("status");
                    usingDate = LocalDate.parse(rs.getString("usingDate"));
                    if (availableQuantity == 0) {
                        message = "Product " + productID + ", batch number "
                                + batchNumber
                                + " is out of stock. Please remove "
                                + "it to check out.";
                        errors.put(detailID, message);
                    } else if (availableQuantity < orderQuantity) {
                        message = "Available quantity of " + productID
                                + ", batch number " + batchNumber + " is not enough. "
                                + "Please decrease order quantity down to "
                                + availableQuantity + " or below.";
                        errors.put(detailID, message);
                    }
                    if (status == false) {
                        message = "Product " + productID + ", batch number "
                                + batchNumber + " is out of stock. Please remove "
                                + "it to check out.";
                        errors.put(detailID, message);
                    }
                    if (LocalDate.now().isAfter(usingDate)) {
                        message = "Product " + productID
                                + ", batch number " + batchNumber
                                + " is out of date. Please remove "
                                + "it to check out.";
                        errors.put(detailID, message);
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
        return errors;
    }

    public static boolean completeOrder(int orderID) throws SQLException {
        boolean checkProduct = false;
        boolean checkOrder = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ORDER_DETAILS);
                ptm.setInt(1, orderID);
                rs = ptm.executeQuery();
                int quantity;
                String productID;
                int batchNumber;
                while (rs.next()) {
                    quantity = rs.getInt("quantity");
                    productID = rs.getString("productID");
                    batchNumber = rs.getInt("batchNumber");
                    ptm = conn.prepareStatement(UPDATE_PRODUCT);
                    ptm.setInt(1, quantity);
                    ptm.setString(2, productID);
                    ptm.setInt(3, batchNumber);
                    checkProduct = ptm.executeUpdate() > 0;
                    if (!checkProduct) {
                        break;
                    }
                }
                if (checkProduct) {
                    ptm = conn.prepareStatement(COMPLETE_ORDER);
                    ptm.setInt(1, orderID);
                    if (ptm.executeUpdate() > 0) {
                        checkOrder = true;
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
        return checkProduct && checkOrder;
    }
}
