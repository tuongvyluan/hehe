<%-- 
    Document   : course
    Created on : Jun 24, 2022, 5:37:30 AM
    Author     : Luan Tuong Vy
--%>

<%@page import="courses.CourseModel"%>
<%@page import="students.StudentDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${requestScope.CURRENT_COURSE.courseName}</title>
  </head>
  <body>
    <%
        //Prevent everyone else except the login student go to this page
        StudentDTO student;
        CourseModel course = new CourseModel();
        if (session.getAttribute("LOGIN_STUDENT") != null) {
            student = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
    %>
    <h1>Hello <%= student.getFirstName()%></h1>
    <%
        } else {
            course = (CourseModel) request.getAttribute("CURRENT_COURSE");
            if (course == null) {
                response.sendRedirect("home.jsp");
                return;
            }
        }
    %>
    <h1>Hello World!</h1>
    <h2><%= course.getCourseName()%></h2>
    <p><%= course.getDescription()%></p>
    <p><%= course.getDuration()%></p>
    <p><%= course.getPrice()%></p>
  </body>
</html>
