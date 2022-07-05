/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import students.IStudentBUS;
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

    // Destination String
    private final String ERROR = "error.jsp";
    private final String LOGIN = "login.jsp";
    private final String REGISTER = "register.jsp";
    private final String STUDENT_PROFILE = "profile.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        HttpSession session;
        IStudentBUS studentBUS = new StudentBUS();
        String message = "";
        StudentError error = new StudentError();
        StudentModel student;
        try {
            String action = request.getParameter("action");
            if (LOGIN_STUDENT.equals(action)) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                session = request.getSession();
                student = studentBUS.checkLogin(email, password);
                if (student != null) {
                    session.setAttribute("LOGIN_STUDENT", student.toDTO());
                    url = STUDENT_PROFILE;
                } else {
                    url = LOGIN;
                }
            } else if (REGISTER_STUDENT.equals(action)) {
                url = REGISTER;
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String confirm = request.getParameter("confirm");
                String firstName;
                String lastName;
                LocalDate dob;
                String phoneNumber;
                if (password.equals(confirm)) {
                    firstName = request.getParameter("firstName");
                    lastName = request.getParameter("lastName");
                    dob = LocalDate.parse(request.getParameter("dob"));
                    phoneNumber = request.getParameter("phoneNumber");
                    student = new StudentModel(firstName, lastName, dob, email, password, phoneNumber);
                    error = studentBUS.register(student);
                    if (error == null) {
                        url = LOGIN;
                    }
                } else {
                    message = "Password and confirmed password must be the same.";
                    error.setPassword(message);
                }
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
