<%-- 
    Document   : home
    Created on : Jun 21, 2022, 10:24:40 PM
    Author     : Luan Tuong Vy
--%>

<%@page import="students.StudentDTO"%>
<%@page import="authors.AuthorBUS"%>
<%@page import="courses.CourseBUS"%>
<%@page import="courses.CourseDTO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="categories.CategoryModel"%>
<%@page import="categories.CategoryBUS"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous"
        />
    <!-- Swiper CSS -->
    <link rel="stylesheet" href="css/swiper-bundle.min.css" />

    <!-- CSS -->
    <link rel="stylesheet" href="css/card.css" />
    <link rel="stylesheet" href="css/home.css" />
    <style>
      .pagination {
          display: flex;
          position: relative;
          font-family: "Poppins", sans-serif;
          font-weight: 600;
          align-items: center;
          justify-content: center;
      }

      .pagination a {
          color: black;
          float: left;
          padding: 8px 16px;
          text-decoration: none;
          transition: background-color 0.3s;
          border: none;
          border-radius: 20%;
          background-color: #e9efff;
          margin: 0 4px;
      }

      .pagination a.active {
          background-color: #1877f2;
          color: white;
          border: 1px solid #1877f2;
      }

      .pagination a:hover:not(.active) {
          background-color: #c3efff;
      }
      .pagination a {
          text-align: center;
      }


    </style>
    <title>Hehe Code</title>
  </head>
  <body onload="addColor()">
    <header>
      <%@ include file="header.jsp" %>
    </header>
    <section class="home" id="home">
      <div class="home__content">
        <h1>Welcome to Hehe code</h1>
        <p>Learn how to code easy with Hehe code. From now, code is not a pain, code is fun like "HE HE"</p>
        <div class="button">
          <button class="home__btn">explore now !</button>
        </div>
      </div>
    </section>
    <section class="search__courses" id="search__courses">
      <div class="row card-container">
        <div class="col-sm-10 col-md-10">
          <div
              class="card"
              style="
              border: none;
              border-radius: 0px;
              height: fit-content;
              width: 80vw;
              "
              >
          </div>
        </div>
      </div>
      <div class="row card-container search__button" style="font-size: 20px">
        <div class="" style="float: right">
          <form action="MainController" id="search" method="POST">
            <input type="hidden" name="action" value="SearchCourse">
            <input type="hidden" name="controller" value="Course">
            <input class="search__input" type="text" placeholder="Search" name="search" value="${requestScope.SEARCH}" />
            <button class="btn__search__submit" type="submit" onclick="submit_form('search')">
              <i class="fa fa-search"></i>
            </button>
          </form>
          <div class="">
            <a href="home.jsp">
              <button>All course</button>
            </a>
          </div>
          <div class="">
            <button>Enrolled</button>
          </div>
        </div>
      </div>
    </section>

    <%
        CourseBUS courseBUS = new CourseBUS();
    %>
    <section class="categoryName">

      <div class="row card-container">
        <%
            ArrayList<CourseDTO> courseList = (ArrayList<CourseDTO>) request.getAttribute("SEARCH_RESULT");
            AuthorBUS authorBUS = new AuthorBUS();
            for (CourseDTO course : courseList) {
        %>

        <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
          <div class="card">
            <div class="image-content">
              <span class="overlay"></span>
            </div>
            <div class="card-content">
              <form name="ViewCourse" method="POST" action="MainController" >
                <h2 class="name"><%= course.getCourseName()%></h2>
                <div class="description">
                  <p>Author: <%= authorBUS.get(course.getAuthorId()).getFullName()%> </p>
                  <p>Time to complete: <%= course.getDuration()%> hours</p>
                </div>
                <input hidden="" name="controller" value="ViewCourse">
                <input hidden="" name="action" value="ViewCourse">
                <input hidden name="courseId" value="<%= course.getCourseId()%>">
                <div class="card-content-detail">
                  <button class="buttonCourse">View More</button>
                  <p class="price">FREE</p>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <% }%>
    </section>
    <footer>
      <%@ include file="footerHehe.jsp" %>
    </footer>
  </body>
  <!-- Swiper JS -->
  <script src="js/swiper-bundle.min.js"></script>

  <!-- JavaScript -->
  <script src="js/script.js"></script>
  <script>
                const colorRandom = document.querySelectorAll(".overlay");
                const backgroundPink =
                        "linear-gradient(to top left, #1877f2 0%, #FF6CB0 80%)";
                const backgroundBlue =
                        "linear-gradient(to top left, #1877f2 0%, #66ffff  80%)";
                const backgroundYellow =
                        "linear-gradient(to top left, #1877f2 0%, #F9F871  80%)";
                const backgroundGreen =
                        "linear-gradient(to top left, #1877f2 0%, #6EFACC 80%)";
                const backgroundViolet =
                        "linear-gradient(to top left, #1877f2 0%, #CB6BDF 80%)";
                const backgroundRed =
                        "linear-gradient(to top left, #1877f2 0%, #FF907E 80%)";
                const backColor = [
                    backgroundPink,
                    backgroundBlue,
                    backgroundRed,
                    backgroundYellow,
                    backgroundGreen,
                    backgroundViolet,
                ];

                function addColor() {
                    let x = 0;
                    colorRandom.forEach((e) => {
                        e.style.background = backColor[x % 6];
                        x = x + 1;
                    });
                }
  </script>
</html>