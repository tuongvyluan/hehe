<%-- 
    Document   : home
    Created on : Jun 21, 2022, 10:24:40 PM
    Author     : Luan Tuong Vy
--%>

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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hehe Code</title>
  </head>
  <body>
    <h1>Category</h1>
    <%
        int pageNumber = 1;
        int rowsOfPage = 5;
        if (request.getParameter("page") != null) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        CategoryBUS categoryBUS = new CategoryBUS();
        ArrayList<CategoryModel> categories = categoryBUS.getCategories(pageNumber, rowsOfPage);
    %>

    <%
        ArrayList<CourseDTO> courseList;
        CourseBUS courseBUS = new CourseBUS();
        for (CategoryModel category : categories) {
    %>
    <h2><%= category.getCategoryName()%></h2>
    <%
        courseList = courseBUS.getCoursesByCategory(category.getCategoryId(), 1, 5);
        for (CourseDTO course : courseList) {
    %>
    <p><%= course.getCourseName()%></p>
    <form name="ViewCourse" method="POST" action="MainController" >
      <input hidden="" name="controller" value="Course">
      <input hidden="" name="action" value="ViewCourse">
      <input hidden name="courseId" value="<%= course.getCourseId() %>">
      <button>Enroll now</button>
    </form>
    <%
            }
        }
    %>
  </body>
</html>
