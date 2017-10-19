<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language" var="localization"/>
<fmt:message bundle="${localization}" key="navbar.button.booking" var="button_booking"/>
<fmt:message bundle="${localization}" key="navbar.button.orders" var="button_orders"/>
<fmt:message bundle="${localization}" key="navbar.button.language" var="button_language"/>
<fmt:message bundle="${localization}" key="navbar.button.signout" var="button_signout"/>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse mt-2 mt-md-0" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/booking">${button_booking}</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/user_orders">${button_orders}</a>
            </li>
        </ul>
        <ul class="navbar-nav navbar-right">
            <li class="nav-item" id="language">
                <div class="dropdown show">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdown-menu-link"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                       style="background-color: #343a40; border: none">
                        ${button_language}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdown-menu-link">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/?locale=en">English</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/?locale=ru">Русский</a>
                    </div>
                </div>
            </li>
            <li class="nav-item active">
                <form method="post" action="${pageContext.request.contextPath}/logout">
                    <button class="btn" style="background-color: #343a40; color: white; border: transparent">
                    ${button_signout}
                    </button>
                </form>
            </li>
        </ul>
    </div>
</nav>