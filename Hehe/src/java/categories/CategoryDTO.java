/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package categories;

/**
 *

 * @author Luan Tuong Vy
 */
public class CategoryDTO {

    int categoryId;
    String categoryName;
    String status;

    public CategoryDTO() {
    }

    public CategoryDTO(int categoryId, String categoryName, String status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" + "categoryId=" + categoryId + ", categoryName="
                + categoryName + ", status=" + status + '}';
    }
    
}
