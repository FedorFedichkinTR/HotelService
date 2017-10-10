<%@ page import="com.epam.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>My orders</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/navbar-top-fixed.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tables.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css">
</head>
<body>

<jsp:include page="../static/common/navbar.jsp"/>

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
    </tr>
    <c:forEach items="${requestScope.get(Constants.LIST_OF_USER_ORDERS)}" var="order">
    <tr>
        <td><c:out value="${order.startDate}"/></td>
        <td><c:out value="${order.endDate}"/></td>
        <td><c:out value="${order.roomType}"/></td>
        <td><c:out value="${order.roomCapacity}"/></td>
        <td></td>
        <td></td>
        <td>
            <form method="post">
                <button name="Pay" class="btn btn-primary pay " type="button"
                        onclick="this.style.visibility='hidden';"><i class="fa fa-credit-card" aria-hidden="true"></i>
                    Pay up
                </button>
            </form>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
