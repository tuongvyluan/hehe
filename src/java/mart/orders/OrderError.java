/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.orders;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luan Tuong Vy
 */
public class OrderError {

    private String orderID;
    private String orderDate;
    private String total;
    private String userID;
    private String status;

    public OrderError() {
        this.orderID = "";
        this.orderDate = "";
        this.total = "";
        this.userID = "";
        this.status = "";
    }

    public OrderError(String orderID, String orderDate, String total,
            String userID, String status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.total = total;
        this.userID = userID;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getAllErrors() {
        ArrayList<String> errorList = new ArrayList();
        if (!orderID.isBlank()) {
            errorList.add(orderID);
        }
        if (!orderDate.isBlank()) {
            errorList.add(orderDate);
        }
        if (!total.isBlank()) {
            errorList.add(total);
        }
        if (!userID.isBlank()) {
            errorList.add(userID);
        }
        if (!status.isBlank()) {
            errorList.add(status);
        }
        return errorList;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderID=" + orderID + ", orderDate="
                + orderDate + ", total=" + total + ", userID=" + userID
                + ", status=" + status + '}';
    }
}
