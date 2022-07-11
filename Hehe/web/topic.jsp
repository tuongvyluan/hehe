<%@page import="answers.AnswerModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="quizzes.QuizModel"%>
<%@page import="topics.TopicModel"%>
<%@page import="topics.TopicBUS"%>
<%@page import="students.StudentDTO"%>
<%@page import="sections.SectionDTO"%>
<%@page import="topics.TopicDTO"%>
<%@page import="answers.AnswerDTO"%>
<%--<%@page import="quizzes.QuizDTO"%>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="images/icons/read_book_study_icon.ico"/>
    <link rel="stylesheet" href="css/studyStyle.css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <link rel="stylesheet" href="css/nicepage.css" media="screen">
    <link rel="stylesheet" href="css/About.css" media="screen">
    <link id="u-theme-google-font" rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link id="u-page-google-font" rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Advent+Pro:100,200,300,400,500,600,700|Cambay:400,400i,700,700i">
    <script src="js/studyScript.js" defer></script>
    <script src="js/studyAnswerScript.js" defer></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script src="https://kit.fontawesome.com/709397a81f.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="http://www.pureexample.com/js/lib/jquery.ui.touch-punch.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script class="u-script" type="text/javascript" src="js/jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="js/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.12.5, nicepage.com">
    <title>${requestScope.TOPIC.topicName}</title>
  </head>

  <body data-home-page="Home.html" data-home-page-title="Home" class="u-body u-xl-mode">
    <header>
      <%@ include file="header.jsp" %>
    </header>
    <%
        StudentDTO student = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
        TopicModel topic = (TopicModel) request.getAttribute("TOPIC");
        QuizModel quiz = (QuizModel) request.getAttribute("QUIZ");
        Integer studentCourseId = (Integer) request.getAttribute("STUDENT_COURSE_ID");
        ArrayList<AnswerModel> answerList = (ArrayList<AnswerModel>) request.getAttribute("ANSWERS");
        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        if (topic == null || studentCourseId == null) {
            response.sendRedirect("home.jsp");
            return;
        }
    %>
    <main>
      <div class="container">
        <div class="container__left">
          <div class="lesson">
            <div class="lesson_content">
              <%
                  if (!topic.getDescription().isBlank()) {
              %>
              <h3 style="text-align: justify;">
                <strong>
                  Lý Thuyết
                </strong>
              </h3>
              <p style="text-align: justify;">
                <%= topic.getDescription()%>
              </p>
              <br>
              <%
                  }
              %>

              <%
                  if (quiz != null && answerList != null && !answerList.isEmpty()) {
              %>
              <h3><strong></strong>Bài tập</strong></h3>
              <ul>
                <li class="lesson_question" id="question">
                  <%= quiz.getContent()%>
                </li>
              </ul>
              <%
                  }
              %>

            </div>
          </div>
        </div>
        <div class="resizer" id="dragMe" style="z-index:50;" init="1">
          <button class="button-resize">
            <i class="fas fa-right-left arrow-resize"></i>
          </button>
        </div>
        <div class="container__right">

          <div class="right-header">
            <div class="reset-header">
              <div class="reset-menu">
                <a class="reset-button" id="reset">
                  <i class="fa-solid fa-rotate"></i>
                  <span>Reset</span>
                </a>
              </div>
            </div>
          </div>

          <form method="post" action="MainController" name="answerForm" id="answerForm">
            <input type="hidden" name="controller" value="StudentInTopic">
            <input type="hidden" name="action" value="SubmitQuiz">
            <input type="hidden" name="quizId" value="<%= quiz.getQuizId()%>">
            <input type="hidden" name="topicId" value="<%= topic.getTopicId()%>">
            <input type="hidden" name="studentCourseId" value="<%= studentCourseId%>">

            <div class="answer">
              <div class="answer-input">
                <div class="answer-list">
                  <ul>
                    <%
                        int totalAnswers = answerList.size();
                        int countCorrect = 0;
                        AnswerModel currentAns;
                        for (int i = 0; i < totalAnswers; i++) {
                            currentAns = answerList.get(i);
                            if (currentAns.isCorrect()) {
                                countCorrect++;
                            }
                    %>
                    <li class="answer-select" id="answer-select">
                      <div class="select">
                        <input type="checkbox" id="answer<%= i + 1%>" class="answer" name="answers" value="<%= currentAns.getAnswerId()%>"
                               form="answerForm">
                        <span class="checkmark"></span>
                      </div>
                      <div class="answer-content">
                        <p><%= ((char) ('A' + i)) + ". " + currentAns.getContent()%></p>
                      </div>
                    </li>
                    <%
                        }
                    %>
                  </ul>
                </div>
              </div>
            </div>
            <input type="hidden" name="correctAns" value="<%= countCorrect%>">
          </form>
          <div class="right-footer">
            <div class="submit-footer">
              <div class="submit-menu">

                <form name="ViewNextTopic" method="POST" action="MainController" id="next">
                  <input type="hidden" name="controller" value="Topic">
                  <input type="hidden" name="action" value="ViewNextTopic">
                  <input type="hidden" name="displayIndex" value="<%= topic.getDisplayIndex()%>">
                  <input type="hidden" name="courseId" value="<%= topic.getCourseId()%>">
                  <input type="hidden" name="studentCourseId" value="<%= studentCourseId%>">
                </form>

                <form name="ViewPrevTopic" method="POST" action="MainController" id="prev">
                  <input type="hidden" name="controller" value="Topic">
                  <input type="hidden" name="action" value="ViewPrevTopic">
                  <input type="hidden" name="displayIndex" value="<%= topic.getDisplayIndex()%>">
                  <input type="hidden" name="courseId" value="<%= topic.getCourseId()%>">
                  <input type="hidden" name="studentCourseId" value="<%= studentCourseId%>">
                </form>

                <%
                    if (topic.getDisplayIndex() > 1) {
                %>
                <a class="previous-button" id="prevbtn" href="#" onclick="submit_form('prev')">
                  <!--dung jsp redirect den trang hien tai-->
                  <i class="fa-solid fa-arrow-left"></i>
                  <span>Previous</span>
                </a>
                <%
                    }
                %>

                <a class="next-button" id="nextbtn" href="#" onclick="submit_form('next')">
                  <span>Next</span>
                  <i class="fa-solid fa-arrow-right"></i>
                </a>
                <a class="submit-button" id="submitbtn" input type="submit" value="Submit" onclick="submit_form('answerForm');">
                  <i class="fa-solid fa-floppy-disk"></i>
                  <span>Submit</span>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
    <script>
        $(document).ready(function () {
            var ans = 1;
      <%
          if (countCorrect > 1) {
      %>
            ans = 2;
      <%
          }
      %>
            switch (ans) {
                case 1:     // single select
                    $('li.answer-select').click(function (e) {
                        $(this).toggleClass('selected').siblings().removeClass('selected');
                        if (!$(e.target).is('input[type="checkbox"]')) {
                            var $checkbox = $(this).find('input[type="checkbox"]');
                            $checkbox.prop('checked', !$checkbox.prop('checked'));
                            selectOnlyThis($checkbox.prop('id'));
                        }
                    })
                    break;
                case 2: // multiple select
                    $('li.answer-select').click(function (e) {
                        $(this).toggleClass('selected');
                        if (!$(e.target).is('input[type="checkbox"]')) {
                            var $checkbox = $(this).find('input[type="checkbox"]');
                            $checkbox.prop('checked', !$checkbox.prop('checked'));
                        }
                    })
                    break;
            }
        })

        function selectOnlyThis(id) {
            if (document.getElementById(id).checked) {
                for (var i = 1; i <= <%= answerList.size()%>; i++) {
                    document.getElementById('answer' + i).checked = false;
                }
                document.getElementById(id).checked = true;
            }
        }

//        function check() {
//            for (var i = 1; i <= <%= answerList.size()%>; i++) {
//                if (document.getElementById('answer' + i).checked == true) {
//                    console.log('checked' + i)
//                } else {
//                    console.log('not checked' + i)
//                }
//            }
//            
//        }

        function submit_form(form_id) {
            var form = document.getElementById(form_id);
            form.submit();
        }
    </script>
  </body>

</html>