/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authors;

/**
 *
 * @author Luan Tuong Vy
 */
public class AuthorDTO {

    private int authorId;
    private String firstName;
    private String lastName;
    private String email;

    public AuthorDTO(int authorId, String firstName, String lastName, String email) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public AuthorDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" + "authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }

}
