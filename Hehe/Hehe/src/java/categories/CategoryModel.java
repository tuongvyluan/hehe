package categories;

public class CategoryModel {
    int categoryId;
    String categoryName;
    String description;
    int status;
    String createdAt;
    String updatedAt;

    public CategoryModel(int categoryId, String categoryName, String description, int status, String createdAt,
	    String updatedAt) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
	this.description = description;
	this.status = status;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
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

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public String getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
	return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
    }

}
