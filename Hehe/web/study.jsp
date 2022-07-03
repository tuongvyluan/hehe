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
        <title>${requestScope.CURRENT_COURSE.courseName}</title>
    </head>

    <body data-home-page="Home.html" data-home-page-title="Home" class="u-body u-xl-mode">
        <%@include file="header.jsp" %>
        <main>
            <%
                TopicBUS topicBUS=new TopicBUS();
           %>
            <div class="container">
                <form method="post" action="https://www.google.com.vn/?hl=vi" name="answerForm" id="answerForm"></form>
                <div class="container__left">
                    <div class="lesson">
                        <div class="lesson_content">
                            <h3 style="text-align: justify;">
                                <strong>
                                    Lý Thuyết
                                </strong>
                            </h3>
                            <ul style="text-align: justify;">
                                <li>
                                    <h4>
                                        <strong>Khái niệm</strong>
                                    </h4>
                                </li>
                            </ul>
                            <p style="text-align: justify;">
                                Truyền thông dữ liệu là quá trình chia sẻ và truyền dữ liệu thông tin bằng cách thực hiện
                                các hành động cử chỉ hoặc thông qua việc sử dụng công nghệ được thiết kế giữa các cá nhân và
                                tổ chức để truyền dữ liệu từ nơi này đến nơi khác hoặc từ cá nhân này sang cá nhân khác.
                            </p>
                            <p style="padding-left: 30px;">
                                <img src="https://tuyensinh.uit.edu.vn/sites/default/files/uploads/images/201803/iot_lay_nen_tang_la_mang_may_tinh_de_ket_noi_moi_thu_lai_voi_nhau.jpg"
                                     alt="truyền thông dữ liệu">
                            </p>
                            <br>
                            <h3>Bài tập</h3>
                            <ul>
                                <li class="lesson_question" id="question">
                                    Truyền thông dữ liệu là gì?
                                </li>
                            </ul>
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
                        <div class="reset-menu">
                            <a class="reset-button" id="reset">
                                <i class="fa-solid fa-rotate"></i>
                                <span>Reset</span>
                            </a>
                        </div>
                    </div>
                    <div class="answer">
                        <div class="answer-input">
                            <div class="answer-list">
                                <ul>
                                    <li class="answer-select" id="answer-select">
                                        <div class="select">
                                            <input type="checkbox" id="answer1" class="answer" name="answer" value="A"
                                                   form="answerForm">
                                            <span class="checkmark"></span>
                                        </div>
                                        <div class="answer-content">
                                            <p>A</p>
                                        </div>
                                    </li>
                                    <li class="answer-select" id="answer-select">
                                        <div class="select">
                                            <input type="checkbox" id="answer2" class="answer" name="answer" value="B"
                                                   form="answerForm">
                                            <span class="checkmark"></span>
                                        </div>
                                        <div class="answer-content">
                                            <p>B</p>
                                        </div>
                                    </li>
                                    <li class="answer-select" id="answer-select">
                                        <div class="select">
                                            <input type="checkbox" id="answer3" class="answer" name="answer" value="C"
                                                   form="answerForm">
                                            <span class="checkmark"></span>
                                        </div>
                                        <div class="answer-content">
                                            <p>C</p>
                                        </div>
                                    </li>
                                    <li class="answer-select" id="answer-select">
                                        <div class="select">
                                            <input type="checkbox" id="answer4" class="answer" name="answer" value="D"
                                                   form="answerForm">
                                            <span class="checkmark"></span>
                                        </div>
                                        <div class="answer-content">
                                            <p>D</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="right-footer">
                        <div class="submit-menu">
                            <a class="previous-button" id="prevbtn">
                                <!--dung jsp redirect den trang hien tai-->
                                <i class="fa-solid fa-arrow-left"></i>
                                <span>Previous</span>
                            </a>
                            <a class="next-button" id="nextbtn">
                                <span>Next</span>
                                <i class="fa-solid fa-arrow-right"></i>
                            </a>
                            <a class="submit-button" id="submitbtn" input type="submit" value="Submit" onclick="check();">
                                <i class="fa-solid fa-floppy-disk"></i>
                                <span>Submit</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>

</html>