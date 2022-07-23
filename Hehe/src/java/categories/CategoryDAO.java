/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class CategoryDAO {
    
    private CategoryModel categoryModel;
    
    //CategoryModel fields
    private final String FIELDS = "Id, Name, Description";
    private final String DTO_FIELDS = "Id, Name";
    
    //Pagination
    private final String DECLARE_PAGINATION = "DECLARE @PageNumber as INT " +
            "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
            + "SET @RowsOfPage = ? ";

    private final String PAGINATION = "OFFSET (@PageNumber - 1) * @RowsOfPage "
            + "ROWS FETCH NEXT @RowsOfPage ROWS ONLY";

    //SQL query
    private final String GET_CATEGORIES = DECLARE_PAGINATION + "SELECT " + FIELDS
            + " FROM Category WHERE Status='ACTIVE' ORDER BY Id DESC " + PAGINATION;
    
    private final String GET_CATEGORY_DTO = "SELECT " + DTO_FIELDS
            + " FROM Course WHERE Id=?";
    
    private final String COUNT = "SELECT COUNT(*) AS [count] FROM Category";
    
    public ArrayList<CategoryModel> get(int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<CategoryModel> list = new ArrayList<>();
        if (pageNumber <= 0) {
            pageNumber = 1;
        }
        
        if (rowsOfPage <= 0) {
            rowsOfPage = 1;
        }
        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CATEGORIES);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    categoryModel = new CategoryModel();
                    categoryModel.setCategoryId(rs.getInt("Id"));
                    categoryModel.setCategoryName(rs.getString("Name"));
                    categoryModel.setDescription(rs.getString("Description"));
                    list.add(categoryModel);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public CategoryDTO get(int categoryId) throws SQLException {
        CategoryDTO category = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CATEGORY_DTO);
                ptm.setInt(1, categoryId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    category = new CategoryDTO();
                    category.setCategoryId(categoryId);
                    category.setCategoryName(rs.getString("Name"));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return category;
    }
    
    public int count() throws SQLException {
        int count = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(COUNT);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("count");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return count;
    }
}
