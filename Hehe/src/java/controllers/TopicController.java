/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import answers.AnswerBUS;
import answers.AnswerModel;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quizzes.QuizBUS;
import quizzes.QuizModel;
import studentInTopics.StudentInTopicBUS;
import studentInTopics.StudentInTopicDTO;
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
    private final String VIEW_COMPLETED_TOPIC = "ViewCompletedTopic";
    private final String VIEW_NEXT_TOPIC = "ViewNextTopic";
    private final String VIEW_PREV_TOPIC = "ViewPrevTopic";

    // Controller, Destination String
    private final String HOME = "home.jsp";
    private final String TOPIC = "topic.jsp";
    private final String COMPLETED_TOPIC = "completedTopic.jsp";
    private final String LOGIN = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME;
        TopicModel topic;
        QuizModel quiz;
        ArrayList<AnswerModel> answerList;
        StudentInTopicDTO studentTopic;
        StudentInTopicBUS studentInTopicBUS = new StudentInTopicBUS();

        TopicBUS topicBUS = new TopicBUS();
        QuizBUS quizBUS = new QuizBUS();
        AnswerBUS answerBUS = new AnswerBUS();
        try {
            HttpSession session = request.getSession();
            StudentDTO student = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
            if (student == null) {
                url = LOGIN;
            } else {
                String action = request.getParameter("action");
                int topicId;
                int studentCourseId = Integer.parseInt(request.getParameter("studentCourseId"));
                request.setAttribute("STUDENT_COURSE_ID", studentCourseId);

                switch (action) {
                    
                    case VIEW_TOPIC: {
                        topicId = Integer.parseInt(request.getParameter("topicId"));
                        studentTopic = studentInTopicBUS.getDTO(studentCourseId, topicId);
                        // Not completed: Show history of quiz attempts if
                        // studentTopic is not null and having status "Studying"
                        //....
                        
                        topic = topicBUS.getContent(topicId);
                        quiz = quizBUS.getContent(topic.getTopicId());
                        answerList = null;
                        request.setAttribute("TOPIC", topic);
                        System.out.println(topic.toString());
                        if (quiz != null) {
                            request.setAttribute("QUIZ", quiz);
                            answerList = answerBUS.getAnswers(quiz.getQuizId());
                        }
                        if (answerList != null && !answerList.isEmpty()) {
                            request.setAttribute("ANSWERS", answerList);
                            url = TOPIC;
                        }
                        break;
                    }

                    case VIEW_COMPLETED_TOPIC: {
                        topicId = Integer.parseInt(request.getParameter("topicId"));
                        studentTopic = studentInTopicBUS.getDTO(studentCourseId, topicId);
                        // Not completed: Show history of quiz attempts
                        //....
                        
                        topic = topicBUS.getContent(topicId);
                        quiz = quizBUS.getContent(topic.getTopicId());
                        answerList = null;
                        request.setAttribute("TOPIC", topic);
                        System.out.println(topic.toString());
                        if (quiz != null) {
                            request.setAttribute("QUIZ", quiz);
                            answerList = answerBUS.getAnswers(quiz.getQuizId());
                        }
                        if (answerList != null && !answerList.isEmpty()) {
                            request.setAttribute("ANSWERS", answerList);
                            url = COMPLETED_TOPIC;
                        }
                        break;
                    }

                    case VIEW_NEXT_TOPIC: {

                        int displayIndex = Integer.parseInt(request.getParameter("displayIndex"));
                        int courseId = Integer.parseInt(request.getParameter("courseId"));
                        topic = topicBUS.getNextContent(courseId, displayIndex);
                        quiz = quizBUS.getContent(topic.getTopicId());
                        answerList = null;
                        request.setAttribute("TOPIC", topic);
                        if (quiz != null) {
                            request.setAttribute("QUIZ", quiz);
                            answerList = answerBUS.getAnswers(quiz.getQuizId());
                        }
                        if (answerList != null && !answerList.isEmpty()) {
                            request.setAttribute("ANSWERS", answerList);
                            url = TOPIC;
                        }

                        break;
                    }

                    case VIEW_PREV_TOPIC: {

                        int displayIndex = Integer.parseInt(request.getParameter("displayIndex"));
                        int courseId = Integer.parseInt(request.getParameter("courseId"));
                        topic = topicBUS.getPrevContent(courseId, displayIndex);
                        quiz = quizBUS.getContent(topic.getTopicId());
                        answerList = null;
                        request.setAttribute("TOPIC", topic);
                        if (quiz != null) {
                            request.setAttribute("QUIZ", quiz);
                            answerList = answerBUS.getAnswers(quiz.getQuizId());
                        }
                        if (answerList != null && !answerList.isEmpty()) {
                            request.setAttribute("ANSWERS", answerList);
                            url = TOPIC;
                        }

                        break;
                    }
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
