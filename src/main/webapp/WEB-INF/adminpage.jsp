<%@ page import="com.epam.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language" var="localization"/>
<fmt:message bundle="${localization}" key="adminpage.title" var="title"/>
<fmt:message bundle="${localization}" key="adminpage.bookmark" var="bookmark"/>
<fmt:message bundle="${localization}" key="adminpage.userid" var="userid"/>
<fmt:message bundle="${localization}" key="adminpage.arrival" var="arrival"/>
<fmt:message bundle="${localization}" key="adminpage.departure" var="departure"/>
<fmt:message bundle="${localization}" key="adminpage.roomType" var="room_type"/>
<fmt:message bundle="${localization}" key="adminpage.roomCapacity" var="room_capacity"/>
<fmt:message bundle="${localization}" key="adminpage.suitableRooms" var="suitable_rooms"/>
<fmt:message bundle="${localization}" key="adminpage.status" var="status"/>
<fmt:message bundle="${localization}" key="adminpage.price" var="price"/>
<fmt:message bundle="${localization}" key="adminpage.button.approve" var="approve"/>
<fmt:message bundle="${localization}" key="adminpage.status.option" var="status_option"/>

<%--${}--%>
<html>
<head>
    <title>${bookmark}</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/navbar-top-fixed.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tables.css">
    <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/main.js"></script>
</head>
<body>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/common/adminNavbar.jsp"/>

<h2>${title}</h2>

<table>
    <tr>
        <th>${userid}</th>
        <th>${arrival}</th>
        <th>${departure}</th>
        <th>${room_type}</th>
        <th>${room_capacity}</th>
        <th>${suitable_rooms}</th>
        <th>${status}</th>
        <th>${price}</th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope.get(Constants.LIST_OF_ALL_ORDERS)}" var="order" varStatus="status" >
    <tr>
        <td><c:out value="${order.userID}"/></td>
        <td><c:out value="${order.startDate}"/></td>
        <td><c:out value="${order.endDate}"/></td>
        <td><c:out value="${order.roomType}"/></td>
        <td><c:out value="${order.roomCapacity}"/></td>
        <td>
            <c:if test="${order.roomID == 0}">
            <select id="${order.orderID}selected-room" class="form-control" title="room-type" name="room-type">
                <c:forEach items="${order.freeRooms}" var="free_rooms">
                    <option><c:out value="${free_rooms}"/></option>
                </c:forEach>
            </select>
            </c:if>
            <c:if test="${order.roomID != 0}">
                <select id="${order.orderID}selected-room" class="form-control" title="room-type" name="room-type" disabled>
                    <option><c:out value="${order.roomID}"/></option>
                </select>
            </c:if>
        </td>
        <td>
            <c:choose>
                <c:when test="${order.roomID == 0}">
                    <div id="${order.orderID}">
                        <form method="post">
                            <button name="pay" class="btn btn-primary pay" type="button"
                                    onclick="orderApproved(${order.orderID})"> ${approve}
                            </button>
                        </form>
                    </div>
                </c:when>
                <c:otherwise>
                    <p>${status_option}${order.roomID}.</p>
                </c:otherwise>
            </c:choose>
        </td>
        <td>
            <c:if test="${order.roomID != 0}">
                <div id="price">
                    <c:out value="${order.price}"/>
                </div>
            </c:if>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
