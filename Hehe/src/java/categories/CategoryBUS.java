/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package categories;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luan Tuong Vy
 */
public class CategoryBUS {

    private CategoryDAO dao;

    public ArrayList<CategoryModel> getCategories(int pageNumber, int rowsOfPage) throws SQLException {
        dao = new CategoryDAO();
        ArrayList<CategoryModel> list = dao.get(pageNumber, rowsOfPage);
        return list;
    }
    
    public CategoryDTO get(int categoryId) throws SQLException {
        dao = new CategoryDAO();
        CategoryDTO category = dao.get(categoryId);
        return category;
    }
}
