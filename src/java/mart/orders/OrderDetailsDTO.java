/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.orders;

/**
 *
 * @author Luan Tuong Vy
 */
public class OrderDetailsDTO {

    private int detailID;
    private double price;
    private int quantity;
    private String orderID;
    private String productID;
    private int batchNumber;

    public OrderDetailsDTO() {
        this.detailID = 0;
        this.price = 0;
        this.quantity = 0;
        this.orderID = "";
        this.productID = "";
        this.batchNumber = 0;
    }

    public OrderDetailsDTO(int detailID, double price, int quantity, String orderID, String productID, int batchNumber) {
        this.detailID = detailID;
        this.price = price;
        this.quantity = quantity;
        this.orderID = orderID;
        this.productID = productID;
        this.batchNumber = batchNumber;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" + "detailID=" + detailID + ", price=" + price
                + ", quantity=" + quantity + ", orderID=" + orderID
                + ", productID=" + productID + ", batchNumber=" + batchNumber + '}';
    }
}
