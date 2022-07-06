/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import courses.CourseBUS;
import courses.CourseModel;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sections.SectionBUS;
import sections.SectionDTO;
import studentInCourses.StudentInCourseBUS;
import studentInCourses.StudentInCourseModel;
import students.StudentDTO;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "StudentInCourseController", urlPatterns = {"/StudentInCourseController"})
public class StudentInCourseController extends HttpServlet {

    //Action String
    private final String VIEW_COURSE = "ViewCourse";
    private final String ENROLL_COURSE = "EnrollCourse";

    //Destination String
    private final String ERROR = "error.jsp";
    private final String LOGIN = "login.jsp";
    private final String HOME = "home.jsp";
    private final String COURSE = "course.jsp";
    private final String STUDENT_COURSE = "studentInCourse.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME;
        StudentInCourseModel studentCourse;
        SectionBUS sectionBUS = new SectionBUS();
        StudentInCourseBUS studentInCourseBUS = new StudentInCourseBUS();
        HttpSession session = request.getSession();
        CourseBUS courseBUS = new CourseBUS();
        StudentDTO currentStudent = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
        try {
            String action = request.getParameter("action");
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            switch (action) {
                case VIEW_COURSE: {
                    studentCourse = (StudentInCourseModel) request.getAttribute("CURRENT_STUDENT_COURSE");
                    courseId = studentCourse.getCourseId();
                    CourseModel course = courseBUS.get(courseId);
                    ArrayList<SectionDTO> sections = sectionBUS.get(courseId);
                    request.setAttribute("SECTION_LIST", sections);
                    request.setAttribute("COURSE", course);
                    url = STUDENT_COURSE;
                    break;
                }
                case ENROLL_COURSE: {
                    if (currentStudent != null) {
                        int studentId = currentStudent.getId();
                        studentCourse = studentInCourseBUS.enrollCourse(studentId, courseId);
                        if (studentCourse != null) {
                            ArrayList<SectionDTO> sections = sectionBUS.get(courseId);
                            request.setAttribute("CURRENT_STUDENT_COURSE", studentCourse);
                            request.setAttribute("SECTION_LIST", sections);
                            CourseModel course = courseBUS.get(courseId);
                            request.setAttribute("COURSE", course);
                            url = STUDENT_COURSE;
                            break;
                        }
                    } else {
                        url = LOGIN;
                        break;
                    }
                    url = COURSE;
                    break;
                }
            }
        } catch (Exception e) {
            log("Error at StudentInCourseController: " + e.toString());
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
