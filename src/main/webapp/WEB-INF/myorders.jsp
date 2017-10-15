<%@ page import="com.epam.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>My orders</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/static/js/main.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navbar-top-fixed.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tables.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css">
</head>
<body>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/common/navbar.jsp"/>

<h2> List of all orders from you </h2>


<table>
    <tr>
        <th>Arrival</th>
        <th>Departure</th>
        <th>Type of room</th>
        <th>Room capacity</th>
        <th>Status</th>
        <th>Price</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope.get(Constants.LIST_OF_USER_ORDERS)}" var="order">
    <tr id = "${order.orderID}row">
        <td><c:out value="${order.startDate}"/></td>
        <td><c:out value="${order.endDate}"/></td>
        <td><c:out value="${order.roomType}"/></td>
        <td><c:out value="${order.roomCapacity}"/></td>
        <td>
            <c:choose>
                <c:when test="${order.roomID==null}">
                    <c:out value="Waiting for approve"/>
                </c:when>
                <c:when test="${order.status == false && order.roomID!=null}">
                    <c:out value="Approved. Room № ${order.roomID}"/>
                </c:when>
                <c:when test="${order.status == true}">
                    <c:out value="Payed. Room № ${order.roomID}"/>
                </c:when>
            </c:choose>
        </td>
        <td><c:if test="${order.roomID != null}">
            <c:out value="${order.price}"/>
        </c:if></td>
        <td></td>
        <td>
            <c:choose>
                <c:when test="${order.roomID != null && order.status == false}">
                    <form method="post" action="${pageContext.request.contextPath}/change_user_orders">
                        <button name="pay_up_order" class="btn btn-primary pay " type="submit">
                            <i class="fa fa-credit-card" aria-hidden="true"></i> Pay up
                        </button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${order.status == false}">
                    <form method="post" action="${pageContext.request.contextPath}/change_user_orders">
                        <input type="hidden" name="order_to_delete" value="${order.orderID}">
                        <button name="delete" class="btn btn-primary pay " type="submit">
                            <i class="fa fa-trash" aria-hidden="true"></i> Delete order
                        </button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${order.status == false}">
                        <button name="edit" class="btn btn-primary edit" onclick="editOrder(${order.orderID})">
                            Edit order
                        </button>
                </c:when>
            </c:choose>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
