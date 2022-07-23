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
import studentAnswers.StudentAnswerBUS;
import studentInCourses.StudentInCourseBUS;
import studentInQuizzes.StudentInQuizBUS;
import studentInQuizzes.StudentInQuizModel;
import studentInTopics.StudentInTopicBUS;
import studentInTopics.StudentInTopicDTO;
import students.StudentDTO;
import topics.TopicBUS;
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
                StudentInCourseBUS studentInCourseBUS = new StudentInCourseBUS();
                int studentCourseId = Integer.parseInt(request.getParameter("studentCourseId"));
                System.out.println("Student Course ID: " + studentCourseId);
                int topicId = Integer.parseInt(request.getParameter("topicId"));
                System.out.println("Topic ID: " + topicId);

                switch (action) {
                    case SUBMIT_QUIZ: {
                        request.setAttribute("STUDENT_COURSE_ID", studentCourseId);
                        StudentInTopicDTO studentTopic;
                        StudentInQuizModel studentQuiz;

                        //Check whether student answers are correct or not
                        AnswerBUS answerBUS = new AnswerBUS();
                        boolean submissionResult;
                        int quizId = Integer.parseInt(request.getParameter("quizId"));
                        int correctAns = Integer.parseInt(request.getParameter("correctAns"));

                        ArrayList<Integer> studentAnswers;
                        if (correctAns > 1) {
                            String[] answers = request.getParameterValues("studentAnswers");
                            int size = answers.length;
                            studentAnswers = new ArrayList<>(size);
                            for (int i = 0; i < size; i++) {
                                studentAnswers.add(Integer.parseInt(answers[i]));
                            }
                            submissionResult = answerBUS.checkMultipleAnswerQuiz(studentAnswers, quizId);
                        } else {
                            Integer answerId = Integer.parseInt(request.getParameter("studentAnswers"));
                            submissionResult = answerBUS.checkSingleAnswerQuiz(answerId, quizId);
                            studentAnswers = new ArrayList<>(1);
                            studentAnswers.add(answerId);
                        }
                        request.setAttribute("STUDENT_ANSWERS", studentAnswers);

                        request.setAttribute("SUBMISSION_RESULT", submissionResult);

                        //Check whether this is student first attempt
                        //If first: Create student in topic with proper status
                        //Else: Update status to completed if this attempt is successful
                        studentTopic = studentInTopicBUS.getDTO(studentCourseId, topicId);
                        if (studentTopic == null) {
                            if (submissionResult) {
                                studentTopic = studentInTopicBUS.insert(studentCourseId, topicId, STUDENT_TOPIC_STATUS_COMPLETED);
                                if (studentInCourseBUS.checkStatus(studentCourseId)) {
                                    studentInCourseBUS.completeCourse(studentCourseId);
                                }
                            } else {
                                studentTopic = studentInTopicBUS.insert(studentCourseId, topicId, STUDENT_TOPIC_STATUS_STUDYING);
                            }
                        } else {
                            if (submissionResult) {
                                studentTopic = studentInTopicBUS.updateStatus(studentTopic.getId(), STUDENT_TOPIC_STATUS_COMPLETED);
                                if (studentInCourseBUS.checkStatus(studentCourseId)) {
                                    studentInCourseBUS.completeCourse(studentCourseId);
                                }
                            }
                        }
                        request.setAttribute("STUDENT_TOPIC", studentTopic);

                        //Create StudentInQuiz using current studentTopic's Id
                        StudentInQuizBUS studentInQuizBUS = new StudentInQuizBUS();
                        studentQuiz = studentInQuizBUS.insert(studentTopic.getId(), quizId);

                        //Insert StudentAnswer
                        StudentAnswerBUS studentAnswerBUS = new StudentAnswerBUS();
                        if (correctAns > 1) {
                            for (Integer currentAnswerId : studentAnswers) {
                                studentAnswerBUS.insert(studentQuiz.getStudentInQuizId(), currentAnswerId);
                            }
                        } else {
                            studentAnswerBUS.insert(studentQuiz.getStudentInQuizId(), studentAnswers.get(0));
                        }

                        // Get topic content again
                        TopicBUS topicBUS = new TopicBUS();
                        QuizBUS quizBUS = new QuizBUS();
                        TopicModel topic = topicBUS.getContent(topicId);
                        QuizModel quiz = quizBUS.getContent(topic.getTopicId());
                        request.setAttribute("TOPIC", topic);
                        request.setAttribute("QUIZ", quiz);

                        String[] answerContents = request.getParameterValues("answerContents");
                        String[] answerIds = request.getParameterValues("answerIds");
                        String[] answerCorrects = request.getParameterValues("answerCorrects");

                        int size = answerContents.length;
                        AnswerModel ans;
                        ArrayList<AnswerModel> ansList = new ArrayList();
                        for (int i = 0; i < size; i++) {
                            ans = new AnswerModel();
                            ans.setAnswerId(Integer.parseInt(answerIds[i]));
                            ans.setContent(answerContents[i]);
                            ans.setCorrect(Boolean.parseBoolean(answerCorrects[i]));
                            ansList.add(ans);
                        }
                        request.setAttribute("ANSWERS", ansList);
                        url = RESULT;

                        //Get next and prev topicId
                        int displayIndex = topic.getDisplayIndex();
                        int courseId = topic.getCourseId();
                        int nextTopicId = topicBUS.getNextTopicId(courseId, displayIndex);
                        request.setAttribute("NEXT_TOPIC_ID", nextTopicId);
                        int prevTopicId = topicBUS.getPrevTopicId(courseId, displayIndex);
                        request.setAttribute("PREV_TOPIC_ID", prevTopicId);

                        //Show quiz history
                        ArrayList<LocalDate> quizRecord = studentInQuizBUS.getQuizRecord(studentTopic.getId());
                        request.setAttribute("QUIZ_RECORD", quizRecord);
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
