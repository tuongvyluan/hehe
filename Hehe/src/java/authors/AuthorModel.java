package authors;

public class AuthorModel {

    private int authorId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String createdAt;
    private String updatedAt;

    public AuthorModel(int authorId, String firstName, String lastName, String phoneName, String email,
            String password, String createdAt, String updatedAt) {
        super();
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "AuthorModel{" + "authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneName=" + phoneNumber + ", email=" + email + ", password=" + password + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
