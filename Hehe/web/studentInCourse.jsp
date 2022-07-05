<%-- 
    Document   : studentInCourse
    Created on : Jun 24, 2022, 10:00:57 AM
    Author     : Luan Tuong Vy
--%>

<%@page import="courses.CourseModel"%>
<%@page import="sections.SectionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="studentInCourses.StudentInCourseModel"%>
<%@page import="authors.AuthorBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${requestScope.STUDENT_COURSE.course.courseName}</title>
  </head>
  <body>
    <%
        //Prevent everyone else except the login student go to this page
        AuthorBUS authorBUS = new AuthorBUS();
        StudentInCourseModel studentCourse = (StudentInCourseModel) request.getAttribute("STUDENT_COURSE");
        CourseModel course = studentCourse.getCourse();
        ArrayList<SectionDTO> sections = (ArrayList) request.getAttribute("SECTION_LIST");
        if (studentCourse == null || course == null || sections == null) {
            response.sendRedirect("home.jsp");
            return;
        }
    %>
    <h1><%= course.getCourseName()%></h1>
    <p>Author: <%= authorBUS.get(course.getAuthorId()).getFirstName()%></p>
    <p><%= course.getDescription()%></p>
    <p><%= course.getDuration()%></p>
    <p><%= course.getPrice()%></p>

    <h2>Section</h2>
    <%
        for (SectionDTO section : sections) {
    %>
    <h3><%= section.getDisplayIndex() + ". " + section.getSectionName()%></h3>

    <%
        }
    %>
  </body>
</html>
