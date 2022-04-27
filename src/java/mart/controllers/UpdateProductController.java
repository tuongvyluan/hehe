/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mart.controllers;

import java.io.IOException;
import java.time.LocalDate;
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
@WebServlet(name = "UpdateProductController", urlPatterns = {"/UpdateProductController"})
public class UpdateProductController extends HttpServlet {

    private static final String ERROR = "SearchProductController";
    private static final String SUCCESS = "SearchProductController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            if ("AutoUpdate".equals(request.getParameter("action"))) {
                ProductDAO.updateStatus();
                url = SUCCESS;
            } else {
                String productID = request.getParameter("productID");
                int batchNumber = Integer.parseInt(request.getParameter("batchNumber"));
                String productName = request.getParameter("productName");
                String image = request.getParameter("image");
                double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                String categoryID = request.getParameter("categoryID");
                LocalDate importDate = LocalDate.parse(request.getParameter("importDate"));
                LocalDate usingDate = LocalDate.parse(request.getParameter("usingDate"));
                ProductError pErr = new ProductError();
                boolean check = true;
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
                    pErr.setImage("Product must contain an image");
                    check = false;
                }
                if (productName.isBlank()) {
                    pErr.setProductName("Product must contain product name");
                    check = false;
                }
                if (check) {
                    ProductDTO product = new ProductDTO(productID, batchNumber, productName,
                            image, price, quantity, categoryID, importDate, usingDate, true);
                    if (ProductDAO.updateProduct(product)) {
                        url = SUCCESS;
                    }
                } else {
                    request.setAttribute("PRODUCT_ERROR", pErr);
                }
            }
        } catch (Exception e) {
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
