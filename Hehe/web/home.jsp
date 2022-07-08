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
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/HomeTran.css" />
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
  <body>
    <header>
      <%@ include file="header.jsp" %>
    </header>
    <section class="home" id="home">
      <div class="home__content">
        <h1>Welcome to Hehe code</h1>
        <p>Learn how to code easy with Hehe code.From now, code is not a pain, code is fun like "HE HE"</p>
        <div class="button">
          <button class="home__btn">explore now !</button>
        </div>
      </div>
    </section>

    <%
        int pageNumber = 1;
        int rowsOfPage = 3;
        CategoryBUS categoryBUS = new CategoryBUS();
        int count = categoryBUS.count();
        int totalPage = count / 3;
        if (totalPage * 3 < count) {
            totalPage++;
        }
        if (request.getParameter("page") != null) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        if (pageNumber > totalPage) {
            pageNumber = totalPage;
        }
        AuthorBUS authorBUS = new AuthorBUS();
        ArrayList<CategoryModel> categories = categoryBUS.getCategories(pageNumber, rowsOfPage);

    %>

    <%        if (rowsOfPage > categories.size()) {
            rowsOfPage = categories.size();
        }
        ArrayList<CourseDTO> courseList;
        CourseBUS courseBUS = new CourseBUS();
        for (int i = 1; i <= rowsOfPage; i++) {
            CategoryModel category = categories.get(i - 1);
    %>
    <section class="categoryName">
      <h1><%= category.getCategoryName()%></h1>
      <div class="slide-container swiper">
        <div class="slide-content " id="<%= "swiper" + i%>">
          <div class="card-wrapper swiper-wrapper">

            <%
                courseList = courseBUS.getCoursesByCategory(category.getCategoryId(), 1, 5);
                for (CourseDTO course : courseList) {
            %>

            <div class="card swiper-slide">
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
            <% }%>

          </div>
        </div>

        <div class="swiper-button-next <%= "swiper-button-next-" + i%> swiper-navBtn"></div>
        <div class="swiper-button-prev <%= "swiper-button-prev-" + i%> swiper-navBtn"></div>
        <div class="swiper-pagination <%= "swiper-pagination-" + i%>"></div>
      </div>
    </section>
    <%
        }
    %>
    <div class="pagination">
      <a href="#">&laquo;</a>
      
      <%
          for (int i = 1; i < pageNumber; i++) {
      %>
      <a href="./home.jsp?page=<%= i %>"><%= i%></a>
      <%
          }
      %>
      
      <a href="" class="active"><%= pageNumber%></a>
      
      <%
          for (int i = pageNumber + 1; i <= totalPage; i++) {
      %>
      <a href="./home.jsp?page=<%= i %>"><%= i%></a>
      <%
          }
      %>
      
      <a href="#">&raquo;</a>
    </div>
      <footer>
        <%@ include file="footerHehe.jsp" %>
      </footer>
  </body>
  <!-- Swiper JS -->
  <script src="js/swiper-bundle.min.js"></script>

  <!-- JavaScript -->
  <script src="js/script.js"></script>
</html>
