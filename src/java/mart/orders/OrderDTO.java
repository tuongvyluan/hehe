/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.orders;

import java.time.LocalDate;

/**
 *
 * @author Luan Tuong Vy
 */
public class OrderDTO {
    
    private int orderID;
    private LocalDate orderDate;
    private double total;
    private String userID;
    private boolean status;

    public OrderDTO() {
        this.orderID = 0;
        this.orderDate = null;
        this.total = 0;
        this.userID = "";
        this.status = false;
    }

    public OrderDTO(int orderID, LocalDate orderDate, double total, String userID, boolean status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.total = total;
        this.userID = userID;
        this.status = status;
    }

    public OrderDTO(int orderID, double total, String userID, boolean status) {
        this.orderID = orderID;
        orderDate = null;
        this.total = total;
        this.userID = userID;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderID=" + orderID + ", orderDate=" + orderDate
                + ", total=" + total + ", userID=" + userID + ", status=" + status + '}';
    }
    
    
}
