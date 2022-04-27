/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mart.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mart.recaptcha.VerifyUtils;
import mart.users.UserDAO;
import mart.users.UserDTO;
import mart.users.UserError;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "CreateUserController", urlPatterns = {"/CreateUserController"})
public class CreateUserController extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserDTO user = null;
        UserError userError = new UserError();
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String address = request.getParameter("address");
            LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            boolean checkInput = true;
            boolean checkRecaptcha = false;
            if (!UserDAO.checkUserID(userID)) {
                userError.setUserID("This user ID has already existed");
                checkInput = false;
            }
            if (userID.length() < 3 || userID.length() > 50) {
                userError.setUserID("User ID must be between [3, 50]");
                checkInput = false;
            }
            if (fullName.length() < 5 || userID.length() > 20) {
                userError.setFullName("Full Name must be between [5, 20]");
                checkInput = false;
            }
            if (!password.equals(confirm)) {
                userError.setPassword("Confirm password must be similar to password");
                checkInput = false;
            }
            if (LocalDate.now().isBefore(birthday)) {
                userError.setBirthday("Birthday must be before current day");
                checkInput = false;
            }
            if (fullName.isBlank()) {
                userError.setFullName("Full name must be included");
                checkInput = false;
            }
            if (address.isBlank()) {
                userError.setAddress("Address must be included");
                checkInput = false;
            }
            if (phone.isBlank()) {
                userError.setPhone("Phone must be included");
                checkInput = false;
            }
            String regexPhone = "^0{1}[1-9]{1}[0-9]{8}$";
            if (!phone.matches(regexPhone)) {
                userError.setPhone("Phone is 10 numbers and not started with 00 ");
                checkInput = false;
            }
            if (email.isBlank()) {
                userError.setPhone("Email must be included");
                checkInput = false;
            }
            if (checkInput) {
                String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
                checkRecaptcha = VerifyUtils.verify(gRecaptchaResponse);
                if (checkRecaptcha) {
                    user = new UserDTO(userID, fullName, password, "US", address, birthday, phone, email, true);
                    if (UserDAO.createUser(user)) {
                        url = SUCCESS;
                    }
                } else {
                    request.setAttribute("CAPTCHA_ERROR", "Invalid recaptcha!");
                }
            } else {
                request.setAttribute("ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at CreateUserController: " + e.toString());
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
