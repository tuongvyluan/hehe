package categories;

import java.time.LocalDate;

public class CategoryModel {

    int categoryId;
    String categoryName;
    String description;
    String status;
    LocalDate createdAt;
    LocalDate updatedAt;

    public CategoryModel() {
    }

    public CategoryModel(int categoryId, String categoryName, String description,
            String status) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryNameName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "CategoryModel{" + "categoryId=" + categoryId + ", categoryName="
                + categoryName + ", description=" + description + ", status="
                + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
}
