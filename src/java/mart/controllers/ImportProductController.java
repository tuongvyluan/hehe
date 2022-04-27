/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mart.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mart.products.ProductDAO;
import mart.products.ProductDTO;
import mart.products.ProductError;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "ImportProductController", urlPatterns = {"/ImportProductController"})
public class ImportProductController extends HttpServlet {

    private static final String ERROR = "importProduct.jsp";
    private static final String SUCCESS = "importProduct.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ProductError pErr = new ProductError();
        String importResult = "Import new product fail";
        boolean check = true;
        try {
            String productID = request.getParameter("productID").toUpperCase();
            int batchNumber = 0;
            String productName = request.getParameter("productName");
            String image = request.getParameter("image");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String categoryID = request.getParameter("categoryID");
            LocalDate importDate = LocalDate.parse(request.getParameter("importDate"));
            LocalDate usingDate = LocalDate.parse(request.getParameter("usingDate"));
            if (ProductDAO.checkProductDuplicate(productID)) {
                batchNumber = ProductDAO.getLatestBatch(productID) + 1;
            } else {
                batchNumber = 1;
            }
            if (price < 0) {
                pErr.setPrice("Price cannot be smaller than 0");
                check = false;
            }
            if (quantity <= 0) {
                pErr.setPrice("Quantity must be greater than 0");
                check = false;
            }
            if (importDate.isAfter(usingDate)) {
                pErr.setImportDate("Import date cannot be after using date");
                check = false;
            }
            if (image.isBlank()) {
                if (batchNumber == 1) {
                    pErr.setImage("First batch of product must contain image");
                    check = false;
                } else {
                    ProductDTO latestProduct = ProductDAO.getProduct(productID, batchNumber - 1);
                    image = latestProduct.getImage();
                }
            }
            if (productName.isBlank()) {
                if (batchNumber == 1) {
                    pErr.setProductName("First batch of product must contain "
                            + "product name");
                    check = false;
                } else {
                    ProductDTO latestProduct = ProductDAO.getProduct(productID, batchNumber - 1);
                    productName = latestProduct.getProductName();
                }
            }
            if (check) {
                ProductDTO product = new ProductDTO(productID, batchNumber, productName,
                        image, price, quantity, categoryID, importDate, usingDate, true);
                if (ProductDAO.importProduct(product)) {
                    url = SUCCESS;
                    importResult = "Import new product successfully";
                    request.setAttribute("RESULT", importResult);
                }
            } else {
                request.setAttribute("PRODUCT_ERROR", pErr);
                request.setAttribute("RESULT", importResult);
            }
        } catch (Exception e) {
            log("Error at ImportPrductController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
