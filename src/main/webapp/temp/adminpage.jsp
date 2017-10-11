<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.epam.constants.Constants" %>
<html>
<head>
    <title>Admin page</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/navbar-top-fixed.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tables.css">
    <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="../static/common/adminNavbar.jsp"/>

<h2>All orders</h2>

<table>
    <tr>
        <th>User ID</th>
        <th>Arrival</th>
        <th>Departure</th>
        <th>Type of room</th>
        <th>Room capacity</th>
        <th>Suitable rooms</th>
        <th>Status</th>
        <th>Price</th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope.get(Constants.LIST_OF_ALL_ORDERS)}" var="order" varStatus="status">
    <tr>
        <td><c:out value="${order.userID}"/></td>
        <td><c:out value="${order.startDate}"/></td>
        <td><c:out value="${order.endDate}"/></td>
        <td><c:out value="${order.roomType}"/></td>
        <td><c:out value="${order.roomCapacity}"/></td>
        <td>
            <div class="dropdown show">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Choose a room
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="#">Room #1</a>
                    <a class="dropdown-item" href="#">Room #2</a>
                </div>
            </div>
        </td>
        <td>
            <form method="post">
                <button name="Pay" class="btn btn-primary pay" type="button"
                        onclick="this.style.visibility='hidden';">Approve
                </button>
            </form>
            <p class="hiddenBlock">Approved</p></td>
        <td>150$</td>
        </c:forEach>
</table>
</body>
</html>
