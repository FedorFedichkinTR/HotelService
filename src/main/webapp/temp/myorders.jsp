<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>My orders</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../static/css/tables.css">
</head>
<body>

<jsp:include page="../static/common/navbar.jsp"/>

<h2> List of all orders from you </h2>

${requestScope.get("orders")}

<%--
<table>
    <tr>
        <th>Arrival</th>
        <th>Departure</th>
        <th>Type of room</th>
        <th>Room capacity</th>
        <th>Status</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${orders}" var="order" varStatus="status">
        <tr>
            <td>${order.startDate}</td>
            <td>${order.endDate}</td>
            <td>${order.roomType}</td>
            <td>${order.roomCapacity}</td>
            <td>${order.status}</td>
            <td>${order.price}</td>
        </tr>
    </c:forEach>
</table>
--%>

<table>
    <tr>
        <th>Arrival</th>
        <th>Departure</th>
        <th>Type of room</th>
        <th>Room capacity</th>
        <th>Status</th>
        <th>Price</th>
        <th> </th>
    </tr>
    <%--<c:forEach items="${orders}" var="order" varStatus="status">--%>
    <tr>
        <td>10/10/2017</td>
        <td>02/11/2017</td>
        <td>Suit</td>
        <td>2</td>
        <td>Accepted</td>
        <td>150$</td>
        <td><form method="post"><button name="Pay" class="btn btn-primary pay" type = "button"
                                        onclick="this.style.visibility='hidden';">Pay up</button></form>
            <p class="hiddenBlock">Bill was paid</p></td>
    </tr>
    <tr>
        <td>05/12/2017</td>
        <td>25/12/2017</td>
        <td>Economic</td>
        <td>1</td>
        <td>Accepted</td>
        <td>200$</td>
        <td><form method="post"><button name = "Pay" class="btn btn-primary pay " type="button"
                                        onclick="this.style.visibility='hidden';">Pay up</button></form></td>
    </tr>

    <%--</c:forEach>--%>
</table>
</body>
</html>
