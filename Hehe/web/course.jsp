<%-- 
    Document   : course
    Created on : Jun 24, 2022, 5:37:30 AM
    Author     : Luan Tuong Vy
--%>

<%@page import="topics.TopicDTO"%>
<%@page import="topics.TopicBUS"%>
<%@page import="categories.CategoryBUS"%>
<%@page import="sections.SectionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="authors.AuthorBUS"%>
<%@page import="courses.CourseModel"%>
<%@page import="students.StudentDTO"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/studyPage.css" />
    <link
        rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
        />
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous"
        />
    <title>${requestScope.CURRENT_COURSE.courseName}</title>
  </head>
  <body>
    <%
        AuthorBUS authorBUS = new AuthorBUS();
        TopicBUS topicBUS = new TopicBUS();
        CourseModel course = (CourseModel) request.getAttribute("CURRENT_COURSE");
        ArrayList<SectionDTO> sections = (ArrayList) request.getAttribute("SECTION_LIST");
        CategoryBUS categoryBUS = new CategoryBUS();
        StudentDTO student = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
        if (course == null || sections == null) {
            response.sendRedirect("home.jsp");
            return;
        }
    %>

    <section class="banner">

      <div class="banner__content">
        <!-- <h3>Name of the course</h3> -->
        <div class="banner__content__category">
          <p><%= categoryBUS.get(course.getCategoryId()).getCategoryName()%></p>
        </div>
        <h3><%= course.getCourseName()%></h3>
        <div class="banner__content__detail">
          <span>Created by <%= authorBUS.get(course.getAuthorId()).getFullName()%> </span>
        </div>
        <form name="EnrollCourse" method="POST" action="MainController" id="course">
          <input hidden="" name="controller" value="StudentInCourse">
          <input hidden="" name="action" value="EnrollCourse">
          <input hidden="" name="courseId" value="<%= course.getCourseId()%>">

          <div>
            <button class="enrollBtn">Enroll now</button>
          </div>

          <% if (student == null) {
          %>
          <div>
            <a style="color: #8E57B7; font-size: 70%; text-decoration: none; font-weight: 600;" href="login.jsp">Please login to continue</a>
          </div>
          <%
          } else {
          %>
          <div>
            <a href="#" onclick="submit_form()" style="color: #8E57B7; font-size: 70%; text-decoration: none; font-weight: 600;">Please enroll course to study.</a>
          </div>
          <%
              }
          %>
        </form>

      </div>
    </section>

    <section class="description">
      <h1>Description</h1>
      <p><%= course.getDescription()%></p>
    </section>


    <section class="lessonConntent">
      <h1>Course Curriculum</h1>
      <%
          SectionDTO section;
          for (int i = 0; i < sections.size(); i++) {
              section = sections.get(i);
      %>
      <div class="accordion" id="accordionPanelsStayOpenExample">
        <div class="accordion-item">
          <h2 class="accordion-header" id="<%= "panelsStayOpen-heading" + i%>">
            <button
                class="accordion-button"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="<%= "#panelsStayOpen-collapse" + i%>"
                aria-expanded="true"
                aria-controls="<%= "panelsStayOpen-collapse" + i%>"
                >
              <h2><%= section.getDisplayIndex() + ". " + section.getSectionName()%></h2>
            </button>
          </h2>
          <div
              id="<%= "panelsStayOpen-collapse" + i%>"
              class="accordion-collapse collapse show"
              aria-labelledby="<%= "panelsStayOpen-heading" + i%>"
              >
            <div class="accordion-body">
              <ol>
                <%

                    ArrayList<TopicDTO> topicList;
                    topicList = topicBUS.get(section.getSectionId());
                    if (topicList != null && topicList.isEmpty() == false) {
                        for (TopicDTO topicDTO : topicList) {
                %>
                <li>
                  <p><%= topicDTO.getTopicName()%></p>
                </li>
                <%
                        }
                    }
                %>

              </ol>
            </div>
          </div>
        </div>
        <%
            }
        %>
    </section>
    <script>
        function submit_form() {
            var form = document.getElementById('course');
            form.submit();
        }
    </script>
    <script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"
    ></script>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"
    ></script>
  </body>
</html>
