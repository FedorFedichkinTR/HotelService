<%@ page import="com.epam.model.User" %>
<%@ page import="com.epam.constants.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language" var="localization"/>
<fmt:message bundle="${localization}" key="booking.title" var="title"/>
<fmt:message bundle="${localization}" key="booking.bookmark" var="bookmark"/>
<fmt:message bundle="${localization}" key="booking.greeting" var="greeting"/>
<fmt:message bundle="${localization}" key="booking.choose.rt" var="rt_choice"/>
<fmt:message bundle="${localization}" key="booking.rt.option1" var="rt_option1"/>
<fmt:message bundle="${localization}" key="booking.rt.option2" var="rt_option2"/>
<fmt:message bundle="${localization}" key="booking.rt.option3" var="rt_option3"/>
<fmt:message bundle="${localization}" key="booking.choose.number" var="number_choice"/>
<fmt:message bundle="${localization}" key="booking.choose.arrival" var="arrival"/>
<fmt:message bundle="${localization}" key="booking.choose.departure" var="departure"/>
<%--${}--%>
<!doctype html>
<html>
<head>
    <title>${bookmark}</title>
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
    <h2>${greeting} ${(sessionScope.get(Constants.USER_SESSION)).getFirstName()}!
        <p>${title}</p>
    </h2>
</div>


<div class="jumbotron">
    <form method="post" action="${pageContext.request.contextPath}/order">
        <div class="input-group">
            <select class="form-control validate[required]" id="room-type" title="room-type" name="room-type" required>
                <option disabled="disabled" selected=selected value="">${rt_choice}</option>
                <%--<option>${rt_option1}</option>--%>
                <%--<option>${rt_option2}</option>--%>
                <%--<option>${rt_option3}</option>--%>
                <option>Suite</option>
                <option>Junior</option>
                <option>Standard</option>
            </select>
            <select class="form-control validate[required]" id="number-of-people" title="number-of-people"
                    name="number-of-people"
                    required style="opacity: 1">
                <option disabled="disabled" selected=selected value="">${number_choice}</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
            <%--TODO Validate calendars--%>
            <input type="text" class="datePicker" placeholder="${arrival}" name="arrival" required>
            <input type="text" class="datePicker" placeholder="${departure}" name="departure" required>
            <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
        </div>
    </form>
</div>

</body>
</html>
