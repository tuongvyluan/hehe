/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import answers.AnswerBUS;
import answers.AnswerModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quizzes.QuizBUS;
import quizzes.QuizModel;
import students.StudentDTO;
import topics.TopicBUS;
import topics.TopicModel;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "TopicController", urlPatterns = {"/TopicController"})
public class TopicController extends HttpServlet {

    // Controller param
    private final String VIEW_TOPIC = "ViewTopic";

    // Controller, Destination String
    private final String HOME = "home.jsp";
    private final String TOPIC = "topic.jsp";
    private final String LOGIN = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME;
        TopicModel topic;
        QuizModel quiz;
        ArrayList<AnswerModel> answerList;

        TopicBUS topicBUS = new TopicBUS();
        QuizBUS quizBUS = new QuizBUS();
        AnswerBUS answerBUS = new AnswerBUS();
        HttpSession session = request.getSession();
        StudentDTO student = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
        try {
            String action = request.getParameter("action");
            int topicId = Integer.parseInt(request.getParameter("topicId"));
            switch (action) {
                case VIEW_TOPIC: {
                    if (student != null) {
                        topic = topicBUS.getContent(topicId);
                        quiz = quizBUS.getContent(topicId);
                        answerList = answerBUS.getAnswers(topicId);
                        if (topic != null) {
                            request.setAttribute("TOPIC", topic);
                            url = TOPIC;
                        }
                        if (quiz != null && answerList != null && !answerList.isEmpty()) {
                            request.setAttribute("QUIZ", quiz);
                            request.setAttribute("ANSWERS", answerList);
                        }
                    } else {
                        url = LOGIN;
                    }
                    break;
                }
            }
        } catch (Exception e) {
            log("Error at TopicController: " + e.toString());
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