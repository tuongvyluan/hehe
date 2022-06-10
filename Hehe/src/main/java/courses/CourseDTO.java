package courses;

public class CourseDTO {
    int courseId;
    int authorId;
    int categoryId;
    String courseName;
    String description;
    int status;
    double price;
    String createdAt;
    String updatedAt;
    double duration;

    public CourseDTO(int courseId, int authorId, int categoryId, String courseName, String description, int status,
	    double price, String createdAt, String updatedAt, double duration) {
	super();
	this.courseId = courseId;
	this.authorId = authorId;
	this.categoryId = categoryId;
	this.courseName = courseName;
	this.description = description;
	this.status = status;
	this.price = price;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.duration = duration;
    }

    public int getCourseId() {
	return courseId;
    }

    public void setCourseId(int courseId) {
	this.courseId = courseId;
    }

    public int getAuthorId() {
	return authorId;
    }

    public void setAuthorId(int authorId) {
	this.authorId = authorId;
    }

    public int getCategoryId() {
	return categoryId;
    }

    public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
    }

    public String getCourseName() {
	return courseName;
    }

    public void setCourseName(String courseName) {
	this.courseName = courseName;
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

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
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

    public double getDuration() {
	return duration;
    }

    public void setDuration(double duration) {
	this.duration = duration;
    }

}
