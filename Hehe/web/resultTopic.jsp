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
    <title>RESULT</title>
  </head>

  <body data-home-page="Home.html" data-home-page-title="Home" class="u-body u-xl-mode">

    <%
        boolean submissionResult = (Boolean) request.getAttribute("SUBMISSION_RESULT");
        if (submissionResult) {
    %>
    CORRECT
    <%
    } else {
    %>INCORRECT<%
    }
    %>

  </body>

</html>