<%-- 
  Document   : shopping
  Created on : Mar 2, 2022, 4:34:19 PM
  Author     : Luan Tuong Vy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="mart.products.ProductDTO"%>
<%@page import="mart.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/shoppingPageStylesheet.css">
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <c:set var="search" value="${param.search}"/>
        <p><a href="MainController?action=Logout">Log out</a></p>
        <h1>Welcome to FPT Vegetable Mart</h1>
        <c:if test="${param.pageNum != null}">
            <c:set var="pageNum" value="${param.pageNum}" scope="request"/>
        </c:if>
        <c:if test="${param.pageNum == null}">
            <c:set var="pageNum" value="${1}" scope="request"/>
        </c:if>
        <%
            int pageNum = Integer.parseInt(request.getAttribute("pageNum").toString());
        %>
        <form action="MainController" method="POST">
            <p><input type="submit" value="View cart"></p>
            <input type="hidden" name="action" value="View">
            <input type="hidden" name="search" value="${param.search}">
            <input type="hidden" name="pageNum" value="${requestScope.pageNum}">
        </form>
        <form action="MainController" method="POST">
            <p>
                <input type="hidden" name="search" value="">
                <input type="hidden" name="action" value="Search">
                <input type="submit" value="View all products">
            </p>
        </form>
        <form action="MainController" method="POST">
            <p>
                Search <input type="text" name="search" value="${param.search}">
                <input type="submit" name="action" value="Search">
            </p>
        </form>
        <p>${requestScope.MESSAGE}</p>
        <div class="product-list container">
            <%
                List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("LIST_PRODUCTS");
                if (list == null) {
                    return;
                }
                int size = list.size();
                int min = (pageNum - 1) * 12;
                int max = pageNum * 12;
                if (max > size) {
                    max = size;
                }
                int count;
                ProductDTO product = new ProductDTO();
                for (count = min; count < max; count++) {
                    product = list.get(count);
            %>
            <div class="col-xs-6 col-sm-4 col-lg-3">
                <div class="product">
                    <img src="<%= product.getImage()%>" alt="productImage"/>
                    <h3><%= product.getProductName()%></h3>
                    <p>Price: <%= product.getPrice()%> VND</p>
                    <p>Expired date: <%= product.getUsingDate()%></p>
                    <form action="MainController" method="POST">
                        <input type="submit" value="Add to cart">
                        <select name="quantity">
                            <%
                                int maxQuantity = product.getQuantity();
                                int quantity;
                                for (quantity = 1; quantity <= maxQuantity; quantity++) {
                            %>
                            <option value="<%= quantity%>"><%= quantity%></option>
                            <%
                                }
                            %>
                        </select>
                        <input type="hidden" name="search" value="${param.search}">
                        <input type="hidden" name="pageNum" value="${requestScope.pageNum}">
                        <input type="hidden" name="action" value="Add">
                        <input type="hidden" name="productID" value="<%= product.getProductID()%>">
                        <input type="hidden" name="batchNumber" value="<%= product.getBatchNumber()%>">
                    </form>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <div class="pages">
            <%
                int totalPages;
                if (size % 12 == 0) {
                    totalPages = size / 12;
                } else {
                    totalPages = size / 12 + 1;
                }
            %>
            <form action="MainController">
                Pages: 
                <select name="pageNum">
                    <%
                        for (count = 1; count <= totalPages; count++) {
                            if (count == pageNum) {
                    %>
                    <option value="<%= count%>" selected="<%= count%>"><%= count%></option>
                    <%
                    } else {
                    %>
                    <option value="<%= count%>"><%= count%></option>
                    <%
                            }
                        }
                    %>
                </select>
                <input type="hidden" name="search" value="${search}">
                <input type="hidden" name="action" value="Search">
                <input type="submit" value="Go">
            </form>
        </div>
        <%
            if (session.getAttribute("ERROR") != null) {
        %>
        <script>
            window.alert("${sessionScope.ERROR}");
        </script>
        <%
            }
        %>
    </body>
</html>