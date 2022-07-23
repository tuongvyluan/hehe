/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import answers.AnswerBUS;
import answers.AnswerModel;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quizzes.QuizBUS;
import quizzes.QuizModel;
import studentInQuizzes.StudentInQuizBUS;
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
                        topic = topicBUS.getContent(topicId);
                        int courseId = topic.getCourseId();
                        url = "MainController?action=ViewCourse&controller=ViewCourse&courseId=" + courseId;
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
                        if (studentTopic != null && studentTopic.getStatus().equals("Completed")) {
                            url = COMPLETED_TOPIC;
                        }
                        request.setAttribute("STUDENT_TOPIC", studentTopic);

                        //Get next and prev topicId
                        int displayIndex = topic.getDisplayIndex();
                        int nextTopicId = topicBUS.getNextTopicId(courseId, displayIndex);
                        request.setAttribute("NEXT_TOPIC_ID", nextTopicId);
                        int prevTopicId = topicBUS.getPrevTopicId(courseId, displayIndex);
                        request.setAttribute("PREV_TOPIC_ID", prevTopicId);

                        // Show history of quiz attempts
                        if (studentTopic != null) {
                            StudentInQuizBUS studentInQuizBUS = new StudentInQuizBUS();
                            ArrayList<LocalDate> quizRecord = studentInQuizBUS.getQuizRecord(studentTopic.getId());
                            request.setAttribute("QUIZ_RECORD", quizRecord);
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
