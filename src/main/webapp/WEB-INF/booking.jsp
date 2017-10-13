<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.epam.model.User" %>
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

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/common/navbar.jsp"/>


<div>
    <h2>Hello, <%out.print(((User) session.getAttribute("user")).getFirstName());%>
        <p> Please, make your order.</p>
    </h2>
</div>



<div class="jumbotron">
    <form method="post" action="${pageContext.request.contextPath}/order">
        <div class="input-group">
            <select class="form-control validate[required]" id="room-type" title="room-type" name="room-type" required>
                <option disabled="disabled" selected=selected value="">Choose room type...</option>
                <option>Suite</option>
                <option>Junior</option>
                <option>Standard</option>
            </select>
            <select class="form-control validate[required]" id="number-of-people" title="number-of-people"
                    name="number-of-people"
                    required style="opacity: 1">
                <option disabled="disabled" selected=selected value=""> Choose number of people...</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
            <%--TODO Validate calendars--%>
            <input type="text" class="datePicker" placeholder="Arrival" name="arrival" required>
            <input type="text" class="datePicker" placeholder="Departure" name="departure" required>
            <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
        </div>
    </form>
</div>

</body>
</html>
