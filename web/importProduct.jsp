<%-- 
    Document   : importProduct
    Created on : Mar 4, 2022, 10:13:39 AM
    Author     : Luan Tuong Vy
--%>

<%@page import="mart.products.ProductError"%>
<%@page import="mart.users.UserDTO"%>
<%@page import="mart.products.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Import Product</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/adminPageStylesheet.css">
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
        <div>
            <div>
                <a href="admin.jsp">Return to admin page</a>
            </div>
            <div>
                <a class="" href="MainController?action=Logout">Log out</a>
            </div>
        </div>
        <h1>Import Products</h1>
        <div id="importProduct">
            <form action="MainController">
                <table class="table" border="1" cellpadding="1">
                    <thead class="thead">
                        <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Category</th>
                            <th>Import Date</th>
                            <th>Using Date</th>
                            <th>Insert</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="text" name="productID" required="" value="${param.productID}" maxlength="10"></td>
                            <td><input type="text" name="productName" value="${param.productName}" maxlength="50"></td>
                            <td><input type="text" name="image" value="${param.image}"  maxlength="500"></td>
                            <td><input type="number" name="price" required="" min="0" step="0.01" value="${param.price}"></td>
                            <td><input type="number" name="quantity" required="" min="0" step="1" value="${param.quantity}"></td>
                            <td>
                                <select name="categoryID">
                                    <option value="VE">Vegetable</option>
                                    <option value="FR">Fruits</option>
                                    <option value="GR">Grain</option>
                                </select>
                            </td>
                            <td><input type="date" name="importDate" required="" value="${param.importDate}"></td>
                            <td><input type="date" name="usingDate" required="" value="${param.usingDate}"></td>
                            <td><input type="submit" name="action" value="Import"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <%
                // Report error in user input
                ProductError pErr = (ProductError) request.getAttribute("PRODUCT_ERROR");
                if (pErr != null) {
                    List<String> errors = pErr.getAllErrors();
                    if (errors.size() > 0) {
                        for (String error : errors) {
            %>
            <p><%= error%></p>
            <%
                        }
                    }
                }
            %> 
            <p>${RESULT}</p>
        </div>
    </body>
</html>
