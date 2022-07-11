/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import answers.AnswerBUS;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import studentAnswers.StudentAnswerBUS;
import studentInQuizzes.StudentInQuizBUS;
import studentInQuizzes.StudentInQuizModel;
import studentInTopics.StudentInTopicBUS;
import studentInTopics.StudentInTopicDTO;
import students.StudentDTO;
import topics.TopicModel;

/**
 *
 * @author Luan Tuong Vy
 */
@WebServlet(name = "StudentInTopicController", urlPatterns = {"/StudentInTopicController"})
public class StudentInTopicController extends HttpServlet {

    //Action String
    private final String SUBMIT_QUIZ = "SubmitQuiz";

    //Destination String
    private final String LOGIN = "login.jsp";
    private final String HOME = "home.jsp";
    private final String RESULT = "resultTopic.jsp";

    //Status
    private final String STUDENT_TOPIC_STATUS_STUDYING = "Studying";
    private final String STUDENT_TOPIC_STATUS_COMPLETED = "Completed";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME;

        try {
            HttpSession session = request.getSession();
            StudentDTO student = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
            if (student == null) {
                url = LOGIN;
            } else {
                String action = request.getParameter("action");
                StudentInTopicBUS studentInTopicBUS = new StudentInTopicBUS();
                int studentCourseId = Integer.parseInt(request.getParameter("studentCourseId"));
                System.out.println("Student Course ID: " + studentCourseId);
                int topicId = Integer.parseInt(request.getParameter("topicId"));
                System.out.println("Topic ID: " + topicId);

                switch (action) {
                    case SUBMIT_QUIZ: {
                        StudentInTopicDTO studentTopic;
                        StudentInQuizModel studentQuiz;

                        //Check whether student answers are correct or not
                        AnswerBUS answerBUS = new AnswerBUS();
                        ArrayList<Integer> wrongAnswers;
                        int quizId = Integer.parseInt(request.getParameter("quizId"));
                        int correctAns = Integer.parseInt(request.getParameter("correctAns"));
                        request.setAttribute("CORRECT_ANS", correctAns);

                        Integer answerId = null;
                        ArrayList<Integer> answerIds = null;
                        if (correctAns > 1) {
                            String[] answers = request.getParameterValues("answers");
                            int size = answers.length;
                            answerIds = new ArrayList<>(size);
                            for (int i = 0; i < size; i++) {
                                answerIds.add(Integer.parseInt(answers[i]));
                            }
                            wrongAnswers = answerBUS.checkMultipleAnswerQuiz(answerIds, quizId);
                            request.setAttribute("STUDENT_ANSWERS", answerIds);
                        } else {
                            answerId = Integer.parseInt(request.getParameter("answers"));
                            wrongAnswers = answerBUS.checkSingleAnswerQuiz(answerId, quizId);
                            request.setAttribute("STUDENT_ANSWER", answerId);
                        }

                        request.setAttribute("WRONG_ANSWERS", wrongAnswers);

                        //Check whether this is student first attempt
                        //If first: Create student in topic with proper status
                        //Else: Update status to completed if this attempt is successful
                        studentTopic = studentInTopicBUS.getDTO(studentCourseId, topicId);
                        if (studentTopic == null) {
                            if (!wrongAnswers.isEmpty()) {
                                studentTopic = studentInTopicBUS.insert(studentCourseId, topicId, STUDENT_TOPIC_STATUS_STUDYING);
                            } else {
                                studentTopic = studentInTopicBUS.insert(studentCourseId, topicId, STUDENT_TOPIC_STATUS_COMPLETED);
                            }
                        } else {
                            if (wrongAnswers.isEmpty()) {
                                studentTopic = studentInTopicBUS.updateStatus(studentTopic.getId(), STUDENT_TOPIC_STATUS_COMPLETED);
                            }
                        }

                        //Create StudentInQuiz using current studentTopic's Id
                        StudentInQuizBUS studentInQuizBUS = new StudentInQuizBUS();
                        studentQuiz = studentInQuizBUS.insert(studentTopic.getId(), quizId);

                        //Insert StudentAnswer
                        StudentAnswerBUS studentAnswerBUS = new StudentAnswerBUS();
                        if (correctAns > 1) {
                            if (answerIds != null) {
                                for (Integer currentAnswerId : answerIds) {
                                    studentAnswerBUS.insert(studentQuiz.getStudentInQuizId(), currentAnswerId);
                                }
                            }

                        } else {
                            if (answerId != null) {
                                studentAnswerBUS.insert(studentQuiz.getStudentInQuizId(), answerId);
                            }
                        }
                        url = RESULT;

                        //Not completed: Show history
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error at StudentInTopicController: " + e.toString());
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
