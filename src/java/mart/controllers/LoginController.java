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
import mart.users.UserDAO;
import mart.users.UserDTO;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private final String ERROR = "login.jsp";
    private final String AD = "AD";
    private final String ADMIN_PAGE = "admin.jsp";
    private final String US = "US";
    private final String USER_PAGE = "SearchProductController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            UserDTO user = UserDAO.checkLogin(userID, password);
            if (user != null) {
                if (user.getStatus()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", user);
                    if (AD.equals(user.getRoleID())) {
                        url = ADMIN_PAGE;
                    } else if (US.equals(user.getRoleID())) {
                        OrderDTO cart = OrderDAO.prepareCart(userID);
                        if (cart != null) {
                            session.setAttribute("CART", cart);
                        }
                        url = USER_PAGE;
                    } else {
                        request.setAttribute("ERROR", "Your role is not supported");
                    }
                } else {
                    request.setAttribute("ERROR", "This user no longer exists");
                }
            } else {
                request.setAttribute("ERROR", "Incorrect user ID or password!");
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
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
