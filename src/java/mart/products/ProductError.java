/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.products;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luan Tuong Vy
 */
public class ProductError {
    
    private String productID;
    private String batchNumber;
    private String productName;
    private String image;
    private String price;
    private String quantity;
    private String categoryID;
    private String importDate;
    private String usingDate;
    private String status;

    public ProductError() {
        this.productID = "";
        this.batchNumber = "";
        this.productName = "";
        this.image = "";
        this.price = "";
        this.quantity = "";
        this.categoryID = "";
        this.importDate = "";
        this.usingDate = "";
        this.status = "";
    }

    public ProductError(String productID, String batchNumber, String productName,
            String image, String price, String quantity, String categoryID,
            String importDate, String usingDate, String status) {
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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
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

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(String usingDate) {
        this.usingDate = usingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<String> getAllErrors() {
        List<String> errors = new ArrayList();
        if (!"".equals(productID)) {
            errors.add(productID);
        }
        if (!"".equals(batchNumber)) {
            errors.add(batchNumber);
        }
        if (!"".equals(productName)) {
            errors.add(productName);
        }
        if (!"".equals(image)) {
            errors.add(image);
        }
        if (!"".equals(price)) {
            errors.add(price);
        }
        if (!"".equals(quantity)) {
            errors.add(quantity);
        }
        if (!"".equals(categoryID)) {
            errors.add(categoryID);
        }
        if (!"".equals(importDate)) {
            errors.add(importDate);
        }
        if (!"".equals(usingDate)) {
            errors.add(usingDate);
        }
        if (!"".equals(status)) {
            errors.add(status);
        }
        return errors;
    }

    @Override
    public String toString() {
        return "ProductError{" + "productID=" + productID + ", batchNumber=" + batchNumber + ", productName=" + productName + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", categoryID=" + categoryID + ", importDate=" + importDate + ", usingDate=" + usingDate + ", status=" + status + '}';
    }
    
    
}
