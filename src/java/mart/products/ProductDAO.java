/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mart.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mart.utils.DBUtils;
import mart.utils.MyUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class ProductDAO {

    private static final String CHECK = "SELECT productID from tblProducts WHERE "
            + "productID=?";
    private static final String INSERT = "INSERT INTO tblProducts (productID, "
            + "batchNumber, productName, image, price, quantity, categoryID, "
            + "importDate, usingDate, status) VALUES (?,?,?,?,?,?,?,?,?,'TRUE')";
    private static final String GET_PRODUCT_ID = "SELECT DISTINCT productID FROM "
            + "tblProducts";
    private static final String GET_LATEST_BATCH = "SELECT MAX(batchNumber) FROM "
            + "tblProducts WHERE productID=?";
    private static final String GET_ALL_PRODUCTS = "SELECT productID, batchNumber, "
            + "productName, image, price, quantity, categoryID, importDate, usingDate, "
            + "status FROM tblProducts";
    private static final String GET_AVAILABLE_PRODUCTS = "SELECT productID, batchNumber, "
            + "productName, image, price, quantity, categoryID, importDate, usingDate, "
            + "status FROM tblProducts WHERE status=1 AND usingDate > GETDATE() "
            + "AND quantity > 0";
    private static final String SEARCH_PRODUCTS = "SELECT productID, batchNumber, "
            + "productName, image, price, quantity, categoryID, importDate, usingDate, status "
            + "FROM tblProducts WHERE productName like ?";
    private static final String SEARCH_AVAILABLE_PRODUCTS = "SELECT productID, batchNumber, "
            + "productName, image, price, quantity, categoryID, importDate, usingDate, "
            + "status FROM tblProducts WHERE productName like ? AND status=1 "
            + "AND usingDate > GETDATE() AND quantity > 0";
    private static final String GET_PRODUCT = "SELECT productID, batchNumber, "
            + "productName, image, price, quantity, categoryID, importDate, usingDate, "
            + "status FROM tblProducts WHERE productID=? AND batchNumber=?";
    private static final String PREPARE_PRODUCT = "SELECT productID, batchNumber, "
            + "productName, image, price, categoryID, importDate, usingDate, "
            + "status FROM tblProducts WHERE productID=? AND batchNumber=? AND "
            + "quantity >= ? AND status=1";
    private static final String UPDATE_PRODUCT = "UPDATE tblProducts SET productName=?, "
            + "image=?, price=?, quantity=?, categoryID=?, importDate=?, usingDate=? "
            + "WHERE productID=? AND batchNumber=?";
    private static final String DELETE_PRODUCT = "UPDATE tblProducts SET status=0 "
            + "WHERE productID=? AND batchNumber=?";
    private static final String UPDATE_INVALID_PRODUCTS = "UPDATE tblProducts "
            + "SET status=0 WHERE usingDate < GETDATE() OR quantity = 0";

    // Check duplicate without checking status
    public static boolean checkProductDuplicate(String productID) throws SQLException {
        boolean check = true;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK);
                ptm.setString(1, productID);
                rs = ptm.executeQuery();
                if (!rs.next()) {
                    check = false;
                }
            }
        } catch (Exception e) {
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
        return check;
    }

    // Import product with default status is true
    public static boolean importProduct(ProductDTO product) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, product.getProductID());
                ptm.setInt(2, product.getBatchNumber());
                ptm.setString(3, product.getProductName());
                ptm.setString(4, product.getImage());
                ptm.setDouble(5, product.getPrice());
                ptm.setInt(6, product.getQuantity());
                ptm.setString(7, product.getCategoryID());
                ptm.setString(8, product.getImportDate().toString());
                ptm.setString(9, product.getUsingDate().toString());
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    // Get product even its status is false
    public static List<String> getListProductID() throws SQLException {
        ArrayList<String> list = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRODUCT_ID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(rs.getString("productID"));
                }
            }
        } catch (Exception e) {
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

    // Get product even its status is false
    public static int getLatestBatch(String productID) throws SQLException {
        int batchNum = 0;
        if (checkProductDuplicate(productID)) {
            Connection conn = null;
            PreparedStatement ptm = null;
            ResultSet rs = null;
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    ptm = conn.prepareStatement(GET_LATEST_BATCH);
                    ptm.setString(1, productID);
                    rs = ptm.executeQuery();
                    if (rs.next()) {
                        batchNum = rs.getInt(1);
                    }
                }
            } catch (Exception e) {
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
        }
        return batchNum;
    }

    // Get product even its status is false
    public static List<ProductDTO> getAllProducts() throws SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_PRODUCTS);
                rs = ptm.executeQuery();
                while (rs.next()) {;
                    String productID = rs.getString("productID");
                    int batchNumber = rs.getInt("batchNumber");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    boolean status = rs.getBoolean("status");
                    LocalDate importDate = MyUtils.convertDateToLocalDate(rs.getDate("importDate"));
                    LocalDate usingDate = MyUtils.convertDateToLocalDate(rs.getDate("usingDate"));
                    list.add(new ProductDTO(productID, batchNumber, productName,
                            image, price, quantity, categoryID, importDate, usingDate, status));
                }
            }
        } catch (Exception e) {
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

    // Get product only if its status is true
    public static List<ProductDTO> getAllAvailableProducts() throws SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_AVAILABLE_PRODUCTS);
                rs = ptm.executeQuery();
                String productID;
                int batchNumber;
                String productName;
                String image;
                double price;
                int quantity;
                String categoryID;
                LocalDate importDate;
                LocalDate usingDate;
                while (rs.next()) {
                    productID = rs.getString("productID");
                    batchNumber = rs.getInt("batchNumber");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    categoryID = rs.getString("categoryID");
                    importDate = MyUtils.convertDateToLocalDate(rs.getDate("importDate"));
                    usingDate = MyUtils.convertDateToLocalDate(rs.getDate("usingDate"));
                    list.add(new ProductDTO(productID, batchNumber, productName,
                            image, price, quantity, categoryID, importDate, usingDate, true));
                }
            }
        } catch (Exception e) {
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

    // Get product even its status is false
    public static List<ProductDTO> searchListProducts(String search) throws SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_AVAILABLE_PRODUCTS);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                String productID;
                int batchNumber;
                String productName;
                String image;
                double price;
                int quantity;
                String categoryID;
                LocalDate importDate;
                LocalDate usingDate;
                while (rs.next()) {
                    productID = rs.getString("productID");
                    batchNumber = rs.getInt("batchNumber");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    categoryID = rs.getString("categoryID");
                    importDate = MyUtils.convertDateToLocalDate(rs.getDate("importDate"));
                    usingDate = MyUtils.convertDateToLocalDate(rs.getDate("usingDate"));
                    list.add(new ProductDTO(productID, batchNumber, productName,
                            image, price, quantity, categoryID, importDate, usingDate, true));
                }
            }
        } catch (Exception e) {
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

    // Get product only if its status is true
    public static List<ProductDTO> searchAvailableProducts(String search) throws SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_AVAILABLE_PRODUCTS);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                String productID;
                int batchNumber;
                String productName;
                String image;
                double price;
                int quantity;
                String categoryID;
                LocalDate importDate;
                LocalDate usingDate;
                while (rs.next()) {
                    productID = rs.getString("productID");
                    batchNumber = rs.getInt("batchNumber");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    categoryID = rs.getString("categoryID");
                    importDate = MyUtils.convertDateToLocalDate(rs.getDate("importDate"));
                    usingDate = MyUtils.convertDateToLocalDate(rs.getDate("usingDate"));
                    list.add(new ProductDTO(productID, batchNumber, productName,
                            image, price, quantity, categoryID, importDate, usingDate, true));
                }
            }
        } catch (Exception e) {
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

    // Get product even its status is false
    public static List<ProductDTO> searchProduct(String search) throws SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_PRODUCTS);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                String productID;
                int batchNumber;
                String productName;
                String image;
                double price;
                int quantity;
                String categoryID;
                LocalDate importDate;
                LocalDate usingDate;
                while (rs.next()) {
                    productID = rs.getString("productID");
                    batchNumber = rs.getInt("batchNumber");
                    productName = rs.getString("productName");
                    image = rs.getString("image");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    categoryID = rs.getString("categoryID");
                    importDate = MyUtils.convertDateToLocalDate(rs.getDate("importDate"));
                    usingDate = MyUtils.convertDateToLocalDate(rs.getDate("usingDate"));
                    list.add(new ProductDTO(productID, batchNumber, productName,
                            image, price, quantity, categoryID, importDate, usingDate, true));
                }
            }
        } catch (Exception e) {
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

    // Get product even its status is false
    public static ProductDTO getProduct(String productID, int batchNumber) throws SQLException {
        ProductDTO product = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRODUCT);
                ptm.setString(1, productID);
                ptm.setInt(2, batchNumber);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    LocalDate importDate = MyUtils.convertDateToLocalDate(rs.getDate("importDate"));
                    LocalDate usingDate = MyUtils.convertDateToLocalDate(rs.getDate("usingDate"));
                    boolean status = Boolean.parseBoolean(rs.getString("status"));
                    product = new ProductDTO(productID, batchNumber, productName,
                            image, price, quantity, categoryID, importDate, usingDate, status);
                }
            }
        } catch (Exception e) {
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
        return product;
    }

    public static boolean deleteProduct(String productID, int batchNumber) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_PRODUCT);
                ptm.setString(1, productID);
                ptm.setInt(2, batchNumber);
                check = ptm.executeUpdate() == 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public static boolean updateProduct(ProductDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_PRODUCT);
                ptm.setString(1, product.getProductName());
                ptm.setString(2, product.getImage());
                ptm.setDouble(3, product.getPrice());
                ptm.setInt(4, product.getQuantity());
                ptm.setString(5, product.getCategoryID());
                ptm.setString(6, product.getImportDate().toString());
                ptm.setString(7, product.getUsingDate().toString());
                ptm.setString(8, product.getProductID());
                ptm.setInt(9, product.getBatchNumber());
                check = ptm.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public static boolean updateStatus() throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_INVALID_PRODUCTS);
                check = ptm.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public static ProductDTO prepareProduct(String productID, int batchNumber, int quantity) throws SQLException {
        ProductDTO product = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(PREPARE_PRODUCT);
                ptm.setString(1, productID);
                ptm.setInt(2, batchNumber);
                ptm.setInt(3, quantity);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    String categoryID = rs.getString("categoryID");
                    LocalDate importDate = MyUtils.convertDateToLocalDate(rs.getDate("importDate"));
                    LocalDate usingDate = MyUtils.convertDateToLocalDate(rs.getDate("usingDate"));
                    product = new ProductDTO(productID, batchNumber, productName,
                            image, price, quantity, categoryID, importDate, usingDate, true);
                }
            }
        } catch (Exception e) {
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
        return product;
    }
}
