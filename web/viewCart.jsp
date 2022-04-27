<%-- 
    Document   : viewCart
    Created on : Mar 10, 2022, 11:37:07 AM
    Author     : Luan Tuong Vy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>View Cart</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/adminPageStylesheet.css">
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <p><a href="MainController?action=Logout">Log out</a></p>
        <c:if test="${sessionScope.CART != null && sessionScope.CART_DETAILS != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Batch number</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Update</th>
                        <th>Remove</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="orderDetail" items="${sessionScope.CART_DETAILS.values()}" varStatus="counter">
                    <form action="MainController" method="POST">
                        <tr>
                        <input type="hidden" name="detailID" value="${orderDetail.detailID}"/>
                        <td>${counter.count}</td>
                        <td>${orderDetail.productID}</td>
                        <td>${orderDetail.batchNumber}</td>
                        <td>${orderDetail.price} VND</td>
                        <td>
                            <input type="number" name="quantity" value="${orderDetail.quantity}" min="1"/>
                        </td>
                        <td>
                            ${orderDetail.price * orderDetail.quantity} VND
                        <td>
                            <input type="submit" name="action" value="Edit"/>
                        </td>
                        <td>
                            <input type="submit" name="action" value="Remove"/>
                        </td>
                        <input type="hidden" name="search" value="${param.search}"/>
                        <input type="hidden" name="pageNum" value="${param.pageNum}"/>
                        <c:if test="${requestScope.CHECK_OUT_MESSAGE != null}">
                            <p><c:out value="${requestScope.CHECK_OUT_MESSAGE.get(orderDetail.detailID)}" /></p>
                        </c:if>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
        <h1>Total: ${sessionScope.CART.total} VND</h1>
    </c:if>
    <c:if test="${requestScope.ERROR != null}">
        <c:out value="${requestScope.ERROR}"/>
    </c:if>
    <div>
        <form action="MainController" method="POST">
            <input type="submit" value="Add more">
            <input type="hidden" name="search" value="${param.search}">
            <input type="hidden" name="pageNum" value="${param.pageNum}">
            <input type="hidden" name="action" value="Search">
        </form>
    </div>
    </br>
    <div>
        <form action="MainController" method="POST">
            <input type="submit" value="Check out">
            <input type="hidden" name="search" value="${param.search}">
            <input type="hidden" name="pageNum" value="${param.pageNum}">
            <input type="hidden" name="action" value="CheckOut">
        </form>
    </div>

</body>
</html>
