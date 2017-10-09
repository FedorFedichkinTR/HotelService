<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>My orders</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap core CSS -->
    <script src="../static/js/jquery-3.2.1.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../static/css/navbar-top-fixed.css" rel="stylesheet">
    <script src="../static/js/popper.min.js"></script>
    <script src="../static/js/bootstrap/bootstrap.min.js"></script>

    <link rel="stylesheet" href="../static/css/tables.css">
    <link rel="stylesheet" href="../static/css/font-awesome.min.css">
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
        <th></th>
    </tr>
    <%--<c:forEach items="${orders}" var="order" varStatus="status">--%>
    <tr>
        <td>10/10/2017</td>
        <td>02/11/2017</td>
        <td>Suit</td>
        <td>2</td>
        <td>Accepted</td>
        <td>150$</td>
        <td>
            <form method="post">
                <button name="Pay" class="btn btn-primary pay " type="button"
                        onclick="this.style.visibility='hidden';"><i class="fa fa-credit-card" aria-hidden="true"></i>
                    Pay up
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>05/12/2017</td>
        <td>25/12/2017</td>
        <td>Economic</td>
        <td>1</td>
        <td>Accepted</td>
        <td>200$</td>
        <td>
            <form method="post">
                <button name="Pay" class="btn btn-primary pay " type="button"
                        onclick="this.style.visibility='hidden';"><i class="fa fa-credit-card" aria-hidden="true"></i>
                    Pay up
                </button>
            </form>
        </td>
    </tr>

    <%--</c:forEach>--%>
</table>
</body>
</html>
