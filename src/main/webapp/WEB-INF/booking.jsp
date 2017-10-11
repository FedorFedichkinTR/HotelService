<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.constants.Constants" %>
<%@ page import="com.epam.model.User" %>
<%@ page import="com.epam.model.Roles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Booking</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>

    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navbar-top-fixed.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/booking.css">

    <script>
        $(function () {
            $(".datePicker").datepicker();
        });
    </script>
</head>
<body>

<c:choose>
    <c:when test="${(sessionScope.get(Constants.USER_SESSION)).role == Roles.ADMINISTRATOR}">
        <jsp:include page="../static/common/adminNavbar.jsp"/>
    </c:when>

    <c:otherwise>
        <jsp:include page="../static/common/navbar.jsp"/>
    </c:otherwise>
</c:choose>

<div>
    <h2>Hello, <%out.print(((User) session.getAttribute("user")).getFirstName());%>.
        <p> Please make your order:</p>
    </h2>
</div>


<div class="jumbotron">
    <form method="post" action="${pageContext.request.contextPath}/order">
        <div class="input-group">
            <select class="form-control" id="sel1" title="roomType" name="roomType">
                <option>Choose room type...</option>
                <option>Suite</option>
                <option>Junior</option>
                <option>Standard</option>
            </select>
            <input type="number" name="numberOfPeople" min="1" max="3" id="numberOfPeople"
                   placeholder="Number of people" oninvalid="this.setCustomValidity('')"
                   oninput="setCustomValidity('')">
            <input type="text" class="datePicker" placeholder="Arrival" name="arrival">
            <input type="text" class="datePicker" placeholder="Departure" name="departure">
            <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
        </div>
    </form>
</div>

</body>
</html>
