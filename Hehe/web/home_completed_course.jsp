<%-- 
    Document   : home
    Created on : Jun 21, 2022, 10:24:40 PM
    Author     : Luan Tuong Vy
--%>

<%@page import="studentInCourses.StudentInCourseBUS"%>
<%@page import="students.StudentDTO"%>
<%@page import="authors.AuthorBUS"%>
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
  </head>
  <body>

    <%
        StudentDTO student = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
        if (student != null) {
            AuthorBUS authorBUS1 = new AuthorBUS();
            ArrayList<CourseDTO> courseList = null;
            StudentInCourseBUS studentCourseBUS1 = new StudentInCourseBUS();

            //Show studying courses
            courseList = studentCourseBUS1.getStudyingCourses(student.getId());
            if (courseList.size() > 0) {
                int i = 1;
    %>


    <!-- Show studying courses -->
    <section class="categoryName">
      <h1>Studying</h1>
      <div class="slide-container swiper">
        <div class="slide-content " id="<%= "swiper" + i%>">
          <div class="card-wrapper swiper-wrapper">

            <%
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
                    <p>Author: <%= authorBUS1.get(course.getAuthorId()).getFullName()%> </p>
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
            <%
                    i++;
                }
            %>
          </div>
        </div>

        <div class="swiper-button-next <%= "swiper-button-next-" + i%> swiper-navBtn"></div>
        <div class="swiper-button-prev <%= "swiper-button-prev-" + i%> swiper-navBtn"></div>
        <div class="swiper-pagination <%= "swiper-pagination-" + i%>"></div>
      </div>
    </section>
    <%
            }
        }
    %>
  </body>

  <!-- JavaScript -->
  <script src="js/script.js"></script>
</html>
