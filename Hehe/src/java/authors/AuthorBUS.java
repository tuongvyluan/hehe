/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authors;

import java.sql.SQLException;

/**
 *
 * @author Luan Tuong Vy
 */
public class AuthorBUS {
    
    private AuthorDTO authorDTO;
    private AuthorDAO dao;

    public AuthorBUS() {
    }
    
    public AuthorDTO get(int authorId) throws SQLException {
        dao = new AuthorDAO();
        authorDTO = dao.get(authorId);
        return authorDTO;
    }
}
