/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mart.controllers;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mart.orders.OrderDAO;
import mart.orders.OrderDTO;
import mart.orders.OrderDetailsDTO;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "UpdateCartController", urlPatterns = {"/UpdateCartController"})
public class UpdateCartController extends HttpServlet {

    private static final String CART_ERROR = "ViewCartController";
    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "ViewCartController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            if (session != null) {
                url = CART_ERROR;
                OrderDTO order = (OrderDTO) session.getAttribute("CART");
                if (order != null && !order.getStatus()) {
                    Map<Integer, OrderDetailsDTO> cart = OrderDAO.getAllOrderDetails(order.getOrderID());
                    if (!cart.isEmpty()) {
                        int detailID = Integer.parseInt(request.getParameter("detailID"));
                        int newQuantity = Integer.parseInt(request.getParameter("quantity"));
                        boolean check = cart.containsKey(detailID);
                        if (check) {
                            check = OrderDAO.updateOrderDetails(detailID, newQuantity);
                            if (check) {
                                url = SUCCESS;
                                cart = OrderDAO.getAllOrderDetails(order.getOrderID());
                                session.setAttribute("CART_DETAILS", cart);
                                order = OrderDAO.getOrder(order.getOrderID());
                                session.setAttribute("CART", order);
                            } else {
                                String message = "Update order detail failed.";
                                request.setAttribute("ERROR", message);
                            }
                        } else {
                            String message = "This order detail no longer existed.";
                            request.setAttribute("ERROR", message);
                        }
                    }
                } else {
                    String message = "The cart is empty. Please add new product.";
                    request.setAttribute("ERROR", message);
                }
            }
        } catch (Exception e) {
            log("Error at UpdateCartController: " + e.toString());
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
