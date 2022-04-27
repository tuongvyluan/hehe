/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mart.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mart.orders.OrderDAO;
import mart.orders.OrderDTO;
import mart.orders.OrderDetailsDTO;
import mart.products.ProductDAO;
import mart.products.ProductDTO;
import mart.users.UserDTO;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String CART_ERROR = "SearchProductController";
    private static final String SUCCESS = "SearchProductController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            if (session != null) {
                UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if (loginUser != null) {
                    url = CART_ERROR;
                    String userID = loginUser.getUserID();
                    String productID = request.getParameter("productID");
                    int batchNumber = Integer.parseInt(request.getParameter("batchNumber"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ProductDTO product = ProductDAO.prepareProduct(productID, batchNumber, quantity);
                    if (product != null) {
                        OrderDTO order = OrderDAO.prepareCart(userID);
                        if (order != null) {
                            int orderID = order.getOrderID();
                            OrderDetailsDTO detail = OrderDAO.getDetailID(orderID, productID, batchNumber);
                            int detailID;
                            if (detail == null) {
                                detailID = OrderDAO.createOrderDetails(orderID, product);
                                if (detailID != 0) {
                                    url = SUCCESS;
                                    order = OrderDAO.getOrder(orderID);
                                    session.setAttribute("CART", order);
                                }
                            } else {
                                int newQuantity = quantity + detail.getQuantity();
                                detailID = detail.getDetailID();
                                if (OrderDAO.updateOrderDetails(detailID, newQuantity)) {
                                    url = SUCCESS;
                                    order = OrderDAO.getOrder(orderID);
                                    session.setAttribute("CART", order);
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            log("Error at AddToCartController: " + e.toString());
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
