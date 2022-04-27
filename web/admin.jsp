<%-- 
    Document   : admin
    Created on : Mar 2, 2022, 4:34:57 PM
    Author     : Luan Tuong Vy
--%>

<%@page import="java.util.List"%>
<%@page import="mart.products.ProductError"%>
<%@page import="mart.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/adminPageStylesheet.css"/>
    </head>
    <body>
        <%
            //Prevent everyone else except Admin go to this page
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <h1>Welcome: <%= loginUser.getFullName()%></h1>
        <p><a href="MainController?action=Logout">Log out</a></p>
        <h2>Product management</h2>
        <p><a href="importProduct.jsp">Import products</a></p>
        <p><a href="MainController?action=Search&search=">View/Update products</a></p>
        
    </body>
</html>
