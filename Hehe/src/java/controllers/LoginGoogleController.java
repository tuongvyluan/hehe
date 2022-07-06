/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import accessGoogle.GooglePojo;
import accessGoogle.GoogleUtils;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpSession;
import students.StudentBUS;
import students.StudentError;
import students.StudentModel;

@WebServlet("/login-google")
public class LoginGoogleController extends HttpServlet {

    private final String HOME = "home.jsp";
    private final String LOGIN = "login.jsp";

    private static final long serialVersionUID = 1L;

    public LoginGoogleController() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        StudentError studentError = null;
        try {
            String code = request.getParameter("code");
            System.out.println(code);
            if (code == null || code.isEmpty()) {
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                dis.forward(request, response);
            } else {
                String accessToken = GoogleUtils.getToken(code);
                GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
                String email = googlePojo.getEmail();
                System.out.println(googlePojo.toString());
                StudentBUS studentBUS = new StudentBUS();
                StudentModel studentUser = studentBUS.checkLogin(email);
                if (studentUser == null) {
                    studentUser = new StudentModel();
                    studentUser.setEmail(email);
                    studentUser.setFirstName(email.split("@")[0]);
                    studentUser.setPassword(email);
                    studentUser.setDob(LocalDate.now());
                    studentError = studentBUS.register(studentUser);
                    if (studentError == null) {
                        url = HOME;
                        HttpSession session = request.getSession();
                        session.setAttribute("LOGIN_STUDENT", studentUser.toDTO());
                    }
                } else {
                    url = HOME;
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_STUDENT", studentUser.toDTO());
                }

            }
        } catch (IOException | SQLException | ServletException e) {
            System.out.println("Error at LoginGoogleController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
