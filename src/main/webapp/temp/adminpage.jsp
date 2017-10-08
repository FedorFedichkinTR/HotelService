<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin page</title>
</head>
<body>

<jsp:include page="../static/common/navbar.jsp"/>

<h2>All orders</h2>
<table>
    <tr>
        <th>User</th>
        <th>Arrival</th>
        <th>Departure</th>
        <th>Type of room</th>
        <th>Room capacity</th>
        <th>Status</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="status">
        <c:forEach items="${orders}" var="order" varStatus="status">
            <tr>
                <td>${user.firstName} + " " + ${user.lastName}</td>
                <td>${order.startDate}</td>
                <td>${order.endDate}</td>
                <td>${order.roomType}</td>
                <td>${order.roomCapacity}</td>
                <td>${order.status}</td>
                <td>${order.price}</td>
            </tr>
        </c:forEach>
    </c:forEach>
</table>
</body>
</html>
