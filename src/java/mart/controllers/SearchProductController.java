/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mart.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mart.products.ProductDAO;
import mart.products.ProductDTO;
import mart.users.UserDTO;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "SearchProductController", urlPatterns = {"/SearchProductController"})
public class SearchProductController extends HttpServlet {

    private static final String ERROR_AD = "updateProduct.jsp";
    private static final String SUCCESS_AD = "updateProduct.jsp";
    private static final String ERROR_US = "shopping.jsp";
    private static final String SUCCESS_US = "shopping.jsp";
    private static final String ERROR = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("LOGIN_USER");
        String roleID = "";
        if (currentUser != null) {
            roleID = currentUser.getRoleID();
        }
        String search = request.getParameter("search");
        try {
            if ("AD".equals(roleID)) {
                url = ERROR_AD;
                List<ProductDTO> list;
                if (search.isEmpty()) {
                    list = ProductDAO.getAllProducts();
                } else {
                    list = ProductDAO.searchListProducts(search);
                }
                if (!list.isEmpty()) {
                    request.setAttribute("LIST_PRODUCTS", list);
                    url = SUCCESS_AD;
                }
            } else if ("US".equals(roleID)) {
                url = ERROR_US;
                List<ProductDTO> list;
                if (search == null) {
                    search = "";
                }
                if (search.isEmpty()) {
                    list = ProductDAO.getAllAvailableProducts();
                } else {
                    list = ProductDAO.searchAvailableProducts(search);
                }
                if (!list.isEmpty()) {
                    request.setAttribute("LIST_PRODUCTS", list);
                    url = SUCCESS_US;
                } else {
                    url = SUCCESS_US;
                    request.setAttribute("MESSAGE", "Searched product does not exist.");
                }
            }
        } catch (Exception e) {
            log("Error at SearchProductController: " + e.toString());
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
