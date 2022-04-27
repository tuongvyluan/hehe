<%-- 
    Document   : createUser
    Created on : Mar 5, 2022, 10:45:46 PM
    Author     : Luan Tuong Vy
--%>

<%@page import="java.util.List"%>
<%@page import="mart.users.UserError"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new user</title>
        <style>
            th {
                text-align: left;
            }

            input[type=text], input[type=password], input[type=tel], input[type=email] {
                width: 300px;
            }
        </style>
        <script src='https://www.google.com/recaptcha/api.js?hl=en'></script>
    </head>
    <body>
        <%
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
            String today = LocalDate.now().format(formatter);
        %>
        <h1>Create new user</h1>
        <form action="MainController" method="POST" style="border: 1px solid black; padding: 20px; width: max-content;">
            <table>
                <tr>
                    <th>User ID</th>
                    <td><input type="text" name="userID" value="${param.userID}" required="" autofocus=""
                               placeholder="User ID must be between 5-50 characters" required="" minlength="5" maxlength="50"></td>
                </tr>
                <tr>
                    <th>Full name</th>
                    <td><input type="text" name="fullName" value="${param.fullName}"
                               placeholder="Full name must be between 3-50 characters" required="" minlength="3" maxlength="50"></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><input type="password" name="password" value="${param.password}"
                               placeholder="Enter your password" required="" maxlength="50"></td>
                </tr>
                <tr>
                    <th>Confirm password</th>
                    <td><input type="password" name="confirm" value="${param.confirm}"
                               placeholder="Confirm your password" required="" maxlength="50"></td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td><input type="text" name="address" value="${param.address}"
                               placeholder="Enter your address" required="" minlength="5" maxlength="200"></td>
                </tr>
                <tr>
                    <th>Birthday</th>
                    <td><input type="date" name="birthday" value="${param.birthday}" max="<%= today%>"></td>
                </tr>
                <tr>
                    <th>Phone number</th>
                    <td><input type="tel" name="phone" value="${param.phone}"
                               placeholder="Enter your phone number" required=""></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td><input type="email" name="email" value="${param.email}"
                               placeholder="Enter your email" required=""></td>
                </tr>
            </table>
            <div class="g-recaptcha" data-sitekey="6LdEp-IeAAAAAP1VLeARUF0xNCed2zlbocSRNZqe"></div>
            <p>
                <input type="submit" name="action" value="Create">
                <input type="reset" value="Reset">
            </p>
        </form>
        <%
            UserError userError = (UserError) request.getAttribute("ERROR");
            if (userError != null) {
                List<String> errorList = userError.getAllErrors();
                for (String error : errorList) {
        %>
        <p><%= error%></p>
        <%
            }
        %>
        <p>Create user failed</p>
        <%
            }
        %>
        <%
            String captchaError = (String) request.getAttribute("CAPTCHA_ERROR");
            if (captchaError != null) {
        %>
        <p><%= captchaError %></p>
        <p>Create user failed</p>
        <%
            }
        %>
    </body>
</html>
