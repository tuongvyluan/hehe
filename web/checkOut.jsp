<%-- 
    Document   : checkOut
    Created on : Mar 11, 2022, 9:44:41 AM
    Author     : Luan Tuong Vy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check out</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <p><a href="MainController?action=Logout">Log out</a></p>
        <h1>Check out successfully</h1>
        <form action="MainController" method="POST">
            <input type="submit" value="Continue shopping">
            <input type="hidden" name="search" value="${param.search}">
            <input type="hidden" name="pageNum" value="${param.pageNum}">
            <input type="hidden" name="action" value="Search">
        </form>
    </body>
</html>
