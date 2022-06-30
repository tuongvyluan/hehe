<%-- 
    Document   : home
    Created on : Jun 21, 2022, 10:24:40 PM
    Author     : Luan Tuong Vy
--%>

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
    <title>Hehe Code</title>
  </head>
  <body>
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
        if (request.getParameter("page") != null) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        CategoryBUS categoryBUS = new CategoryBUS();
        AuthorBUS authorBUS = new AuthorBUS();
        ArrayList<CategoryModel> categories = categoryBUS.getCategories(pageNumber, rowsOfPage);
    %>

    <%
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

  </body>
  <!-- Swiper JS -->
  <script src="js/swiper-bundle.min.js"></script>

  <!-- JavaScript -->
  <script src="js/script.js"></script>
</html>
