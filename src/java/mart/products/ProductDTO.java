/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.products;

import java.time.LocalDate;

/**
 *
 * @author Luan Tuong Vy
 */
public class ProductDTO {
    
    private String productID;
    private int batchNumber;
    private String productName;
    private String image;
    private double price;
    private int quantity;
    private String categoryID;
    private LocalDate importDate;
    private LocalDate usingDate;
    private boolean status;

    public ProductDTO() {
        this.productID = "";
        this.batchNumber = 0;
        this.productName = "";
        this.image = "";
        this.price = 0;
        this.quantity = 0;
        this.categoryID = "";
        this.importDate = null;
        this.usingDate = null;
        this.status = true;
    }

    //With status
    public ProductDTO(String productID, int batchNumber, String productName,
            String image, double price, int quantity, String categoryID,
            LocalDate importDate, LocalDate usingDate, boolean status) {
        this.productID = productID;
        this.batchNumber = batchNumber;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.importDate = importDate;
        this.usingDate = usingDate;
        this.status = status;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public LocalDate getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(LocalDate usingDate) {
        this.usingDate = usingDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", batchNumber=" +
                batchNumber + ", productName=" + productName + ", image=" +
                image + ", price=" + price + ", quantity=" + quantity +
                ", categoryID=" + categoryID + ", importDate=" + importDate +
                ", usingDate=" + usingDate + ", status=" + status + '}';
    }
    
    
    
}
