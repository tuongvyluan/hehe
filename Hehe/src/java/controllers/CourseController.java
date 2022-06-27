/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import courses.CourseBUS;
import courses.CourseModel;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import students.StudentDTO;
import students.StudentModel;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "CourseController", urlPatterns = {"/CourseController"})
public class CourseController extends HttpServlet {

    //Action String
    private final String VIEW_COURSE = "ViewCourse";

    //Destination String
    private final String ERROR = "error.jsp";
    private final String HOME = "home.jsp";
    private final String COURSE = "course.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME;
        HttpSession session;
        CourseModel course;
        StudentDTO student;
        CourseBUS courseBUS = new CourseBUS();
        try {
            String action = request.getParameter("action");
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            switch (action) {
                case VIEW_COURSE: {
                    session = request.getSession();
                    student = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
                    if (student == null) {
                        course = courseBUS.get(courseId);
                        request.setAttribute("CURRENT_COURSE", course);
                    }
                    course = courseBUS.get(courseId);
                        request.setAttribute("CURRENT_COURSE", course);
                    url = COURSE;
                    break;
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
