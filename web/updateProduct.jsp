<%-- 
    Document   : updateProduct
    Created on : Mar 4, 2022, 11:03:11 AM
    Author     : Luan Tuong Vy
--%>

<%@page import="mart.products.ProductError"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mart.products.ProductDTO"%>
<%@page import="mart.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Product</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="practice.js"></script>
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
        <h1>Update Products</h1>
        <p>
            <a href="MainController?action=AutoUpdate&search=${param.search}">Auto update product status</a>
        </p>
        <form action="MainController">
            <input type="hidden" name="search" value="">
            View all product <input type="submit" value="View">
            <input type="hidden" name="action" value="Search">
        </form>
        <br/>
        <form action="MainController">
            <div>Search <input type="text" name="search" required="" value="${param.search}"><input type="submit" name="action" value="Search"></div>

        </form>
        <br>
        <%
            List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("LIST_PRODUCTS");
            if (list != null) {
                if (list.size() > 0) {
        %>
        <table class="table" border="1">
            <thead class="thead">
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Product ID</th>
                    <th scope="col">Batch Number</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Image</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Category</th>
                    <th scope="col">Import Date</th>
                    <th scope="col">Using Date</th>
                    <th scope="col">Status</th>
                    <th scope="col">Update</th>
                    <th scope="col">Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductDTO product : list) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <th scope="row">
                        <%= count++%>
                    </th>
                    <td>
                        <%= product.getProductID()%>
                        <input type="hidden" name="productID" value="<%= product.getProductID()%>" readonly>
                    </td>
                    <td>
                        <%= product.getBatchNumber()%>
                        <input type="hidden" name="batchNumber" value="<%= product.getBatchNumber()%>">
                    </td>
                    <td class="input">
                        <input type="text" name="productName" required="" value="<%= product.getProductName()%>" >
                    </td>
                    <td class="input">
                        <input type="text" name="image" required="" value="<%= product.getImage()%>" >
                    </td>
                    <td class="input">
                        <input type="number" step="0.01" required="" min="0" name="price" value="<%= product.getPrice()%>" >
                    </td>
                    <td class="input">
                        <input type="number" name="quantity" required="" min="0" value="<%= product.getQuantity()%>" >
                    </td>
                    <td class="input">
                        <select name="categoryID">
                            <%
                                if ("VE".equals(product.getCategoryID())) {
                            %>
                            <option value="VE" selected="VE">Vegetable</option>
                            <%
                            } else {
                            %>
                            <option value="VE">Vegetable</option>
                            <%
                                }
                            %>
                            <%
                                if ("FR".equals(product.getCategoryID())) {
                            %>
                            <option value="FR" selected="FR">Fruits</option>
                            <%
                            } else {
                            %>
                            <option value="FR">Fruits</option>
                            <%
                                }
                            %>
                            <%
                                if ("GR".equals(product.getCategoryID())) {
                            %>
                            <option value="GR" selected="GR">Grain</option>
                            <%
                            } else {
                            %>
                            <option value="GR">Grain</option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td class="input">
                        <input type="date" required="" name="importDate" value="<%= product.getImportDate()%>" >
                    </td>
                    <td class="input">
                        <input type="date" required="" name="usingDate" value="<%= product.getUsingDate()%>" >
                    </td>
                    <td>
                        <%= product.getStatus()%>
                        <input type="hidden" name="status" value="<%= product.getStatus()%>" >
                    </td>
                <input type="hidden" name="search" value="${param.search}">
                <td><input type="submit" name="action" value="Update"></td>
                <td><input type="submit" name="action" value="Delete"></td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        }
    } else {
    %>
    <p>This product does not exist.</p>
    <%
        }
    %>
    <%
        ProductError pErr = (ProductError) request.getAttribute("PRODUCT_ERROR");
        String reportError = "";
        String productID = "";
        int batchNumber = 0;
        if (pErr != null) {
            productID = request.getParameter("productID");
            batchNumber = Integer.parseInt(request.getParameter("batchNumber"));
            List<String> errorList = pErr.getAllErrors();
            for (String error : errorList) {
                reportError += error + ". ";
            }
            reportError += "Update product " + productID + ", batch number "
                    + batchNumber + " failed.";
    %>
    <script>
        window.alert("<%= reportError%>");
    </script>
    <%
        }
    %>

</body>
</html>
