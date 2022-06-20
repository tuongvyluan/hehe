/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import students.IStudentBUS;
import students.StudentBUS;
import students.StudentModel;

/**
 *
 * @author Luan Tuong Vy
 */
public class StudentController extends HttpServlet {

    // Action String
    private final String LOGIN_STUDENT = "LoginStudent";

    // Destination String
    private final String ERROR = "error.jsp";
    private final String LOGIN = "login.jsp";
    private final String STUDENT_PROFILE = "profile.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        try {
            String action = request.getParameter("action");
            if (LOGIN_STUDENT.equals(action)) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                IStudentBUS studentBUS = new StudentBUS();
                HttpSession session = request.getSession();
                StudentModel student = studentBUS.checkLogin(email, password);
                if (student != null) {
                    session.setAttribute("LOGIN_STUDENT", student.toDTO());
                    url = STUDENT_PROFILE;
                } else {
                    url = LOGIN;
                }
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
