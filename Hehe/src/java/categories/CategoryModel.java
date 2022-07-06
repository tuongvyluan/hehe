package categories;

import java.time.LocalDate;

public class CategoryModel {

    private int categoryId;
    private String categoryName;
    private String description;
    private String status;
    private LocalDate updatedAt;

    public CategoryModel() {
    }

    public CategoryModel(int categoryId, String categoryName, String description) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDTO toDTO() {
        return new CategoryDTO(categoryId, categoryName);
    }

    @Override
    public String toString() {
        return "CategoryModel{" + "categoryId=" + categoryId + ", categoryName="
                + categoryName + ", description=" + description + ", status="
                + status + ", updatedAt=" + updatedAt + '}';
    }
    
}
