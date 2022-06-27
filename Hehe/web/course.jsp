<%-- 
    Document   : course
    Created on : Jun 24, 2022, 5:37:30 AM
    Author     : Luan Tuong Vy
--%>

<%@page import="sections.SectionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="authors.AuthorBUS"%>
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
        AuthorBUS authorBUS = new AuthorBUS();
        CourseModel course = (CourseModel) request.getAttribute("CURRENT_COURSE");
        ArrayList<SectionDTO> sections = (ArrayList) request.getAttribute("SECTION_LIST");
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
    <h3><%= section.getSectionName()%></h3>

    <%
        }
    %>
  </body>
</html>
