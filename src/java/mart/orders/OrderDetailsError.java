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
public class OrderDetailsError {

    private String detailID;
    private String price;
    private String quantity;
    private String orderID;
    private String productID;
    private String batchNumber;

    public OrderDetailsError() {
        this.detailID = "";
        this.price = "";
        this.quantity = "";
        this.orderID = "";
        this.productID = "";
        this.batchNumber = "";
    }

    public OrderDetailsError(String detailID, String price, String quantity,
            String orderID, String productID, String batchNumber) {
        this.detailID = detailID;
        this.price = price;
        this.quantity = quantity;
        this.orderID = orderID;
        this.productID = productID;
        this.batchNumber = batchNumber;
    }

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }
    
    public List<String> getAllErrors() {
        ArrayList<String> errorList = new ArrayList();
        if (!detailID.isBlank()) {
            errorList.add(detailID);
        }
        if (!price.isBlank()) {
            errorList.add(price);
        }
        if (!quantity.isBlank()) {
            errorList.add(quantity);
        }
        if (!orderID.isBlank()) {
            errorList.add(orderID);
        }
        if (!productID.isBlank()) {
            errorList.add(productID);
        }
        if (!batchNumber.isBlank()) {
            errorList.add(batchNumber);
        }
        return errorList;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" + "detailID=" + detailID + ", price="
                + price + ", quantity=" + quantity + ", orderID=" + orderID
                + ", productID=" + productID + ", batchNumber=" + batchNumber + '}';
    }
}
