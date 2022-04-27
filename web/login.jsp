<%-- 
    Document   : login
    Created on : Mar 1, 2022, 6:38:36 PM
    Author     : Luan Tuong Vy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <div>
            <form name="Login" action="MainController" method="POST">
                <p>User ID: <input type="text" name="userID" placeholder="Enter your username" required=""></p>
                <p>Password: <input type="password" name="password" placeholder="Enter your password" required=""></p>
                <p><input type="submit" name="action" value="Login"> <input type="reset" value="Reset"></p>
            </form>
        </div>
        <a href="createUser.jsp">Create new user</a>
        <div>
            <%
                String error = (String) request.getAttribute("ERROR");
                if (error == null) {
                    error = "";
                }
            %>
            <%= error%></br>
        </div>
    </body>
</html>
