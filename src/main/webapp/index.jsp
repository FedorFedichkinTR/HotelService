<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="language" var="localization"/>
    <fmt:message bundle="${localization}" key="login.title" var="title"/>
    <fmt:message bundle="${localization}" key="login.button.login" var="login_button"/>
    <fmt:message bundle="${localization}" key="login.button.signup" var="signup_button"/>
    <fmt:message bundle="${localization}" key="login.bookmark" var="bookmark"/>
    <fmt:message bundle="${localization}" key="login.email" var="email"/>
    <fmt:message bundle="${localization}" key="login.password" var="password"/>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>${bookmark}</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/signin.css" rel="stylesheet">
</head>
<%--${}--%>
<body>
<div class="container">
    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h2 class="form-signin-heading">${title}</h2>
        <span style="color: red;">
            <c:if test="${requestScope.get(\"error\") != null}">
                <p>${requestScope.get("error")}</p>
            </c:if>
        </span>
        <label for="input-email" class="sr-only">${email}</label>
        <input type="email" id="input-email" class="form-control" placeholder="Email address" name="input-email"
               required
               autofocus>
        <label for="input-password" class="sr-only">${password}</label>
        <input type="password" id="input-password" class="form-control" placeholder="Password" name="input-password"
               required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">${login_button}</button>
    </form>
    <form class="form-signin" action="${pageContext.request.contextPath}/register.jsp">
        <button class="btn btn-lg btn-primary btn-block" type="submit">${signup_button}</button>
    </form>

</div> <!-- /container -->

</body>
</html>
