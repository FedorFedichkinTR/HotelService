<%@ page import="com.epam.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language" var="localization"/>
<fmt:message bundle="${localization}" key="myorders.title" var="title"/>
<fmt:message bundle="${localization}" key="myorders.bookmark" var="bookmark"/>
<fmt:message bundle="${localization}" key="myorders.arrival" var="arrival"/>
<fmt:message bundle="${localization}" key="myorders.departure" var="departure"/>
<fmt:message bundle="${localization}" key="myorders.roomType" var="room_type"/>
<fmt:message bundle="${localization}" key="myorders.roomCapacity" var="room_capacity"/>
<fmt:message bundle="${localization}" key="myorders.status" var="status"/>
<fmt:message bundle="${localization}" key="myorders.price" var="price"/>
<fmt:message bundle="${localization}" key="myorders.button.pay" var="pay_button"/>
<fmt:message bundle="${localization}" key="myorders.button.delete" var="delete_button"/>
<fmt:message bundle="${localization}" key="myorders.button.edit" var="edit_button"/>
<fmt:message bundle="${localization}" key="myorders.status1" var="status1"/>
<fmt:message bundle="${localization}" key="myorders.status2" var="status2"/>
<fmt:message bundle="${localization}" key="myorders.status3" var="status3"/>

<html>
<head>
    <title>${bookmark}</title>
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

<h2>${title}</h2>

<table>
    <tr>
        <th>${arrival}</th>
        <th>${departure}</th>
        <th>${room_type}</th>
        <th>${room_capacity}</th>
        <th>${status}</th>
        <th>${price}</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope.get(Constants.LIST_OF_USER_ORDERS)}" var="order">
    <tr id="${order.orderID}row">
        <td><c:out value="${order.startDate}"/></td>
        <td><c:out value="${order.endDate}"/></td>
        <td><c:out value="${order.roomType}"/></td>
        <td><c:out value="${order.roomCapacity}"/></td>
        <td>
            <c:choose>
                <c:when test="${order.roomID==null}">
                    <c:out value="${status1}"/>
                </c:when>
                <c:when test="${order.status == false && order.roomID!=null}">
                    <c:out value="${status2} ${order.roomID}"/>
                </c:when>
                <c:when test="${order.status == true}">
                    <c:out value="${status3} ${order.roomID}"/>
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
                    <form method="post">
                        <button name="pay_up_order" class="btn btn-primary pay " type="submit"
                                onclick="orderPaid(${order.orderID})">
                            <i class="fa fa-credit-card" aria-hidden="true"></i> ${pay_button}
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
                            <i class="fa fa-trash" aria-hidden="true"></i> ${delete_button}
                        </button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${order.status == false}">
                    <button name="edit" class="btn btn-primary edit" onclick="editOrder(${order.orderID})">
                            ${edit_button}
                    </button>
                </c:when>
            </c:choose>
        </td>
    </tr>
    </c:forEach>
    </body>
</html>
