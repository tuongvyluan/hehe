/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import students.StudentBUS;
import students.StudentError;
import students.StudentModel;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentController extends HttpServlet {

    // Action String
    private final String LOGIN_STUDENT = "LoginStudent";
    private final String REGISTER_STUDENT = "RegisterStudent";
    private final String EDIT_PROFILE = "EditProfile";
    private final String CANCEL_EDIT_PROFILE = "CancelEditProfile";

    // Destination String
    private final String ERROR = "error.jsp";
    private final String LOGIN = "login.jsp";
    private final String REGISTER = "register.jsp";
    private final String HOME = "home.jsp";
    private final String STUDENT_PROFILE = "profile.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        HttpSession session;
        StudentBUS studentBUS = new StudentBUS();
        String message;
        StudentError error = new StudentError();
        StudentModel student;
        try {
            String action = request.getParameter("action");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phoneNumber = request.getParameter("phoneNumber");
            switch (action) {
                case LOGIN_STUDENT: {
                    session = request.getSession();
                    student = studentBUS.checkLogin(email, password);
                    if (student != null) {
                        session.setAttribute("LOGIN_STUDENT", student.toDTO());
                        url = HOME;
                    } else {
                        url = LOGIN;
                    }
                    break;
                }

                case REGISTER_STUDENT: {
                    url = REGISTER;
                    String confirm = request.getParameter("confirm");
                    if (password.equals(confirm)) {
                        student = new StudentModel(firstName, lastName, LocalDate.now(), email, password, phoneNumber);
                        error = studentBUS.register(student);
                        if (error == null) {
                            url = LOGIN;
                        }
                    } else {
                        message = "Password and confirmed password must be the same.";
                        error.setPassword(message);
                    }
                    break;
                }

                case CANCEL_EDIT_PROFILE: {
                    url = STUDENT_PROFILE;
                    break;
                }

                case EDIT_PROFILE: {
//                    String newPass = request.getParameter("newPass");
//                    String confirm = request.getParameter("confirm");
//                    if (password != null) {
//                        
//                    }
                    url = STUDENT_PROFILE;
                    break;
                }
            }
        } catch (SQLException e) {
            log("Error at StudentController: " + e.toString());
        } finally {
            request.setAttribute("ERROR", error);
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
