<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="language" var="localization"/>
    <fmt:message bundle="${localization}" key="regform.bookmark" var="bookmark"/>
    <fmt:message bundle="${localization}" key="regform.title" var="title"/>
    <fmt:message bundle="${localization}" key="regform.firstName" var="first_name"/>
    <fmt:message bundle="${localization}" key="regform.lastName" var="last_name"/>
    <fmt:message bundle="${localization}" key="regform.email" var="email"/>
    <fmt:message bundle="${localization}" key="regform.password" var="password"/>
    <fmt:message bundle="${localization}" key="regform.button.signup" var="signup_button"/>
    <fmt:message bundle="${localization}" key="regform.button.login" var="login_button"/>

    <title>${bookmark}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/signin.css" rel="stylesheet">
</head>
<%--${}--%>
<body>

<div class="container">

    <form method="post" class="form-signin" action="${pageContext.request.contextPath}/register">
        <h2 class="form-signin-heading">${title}</h2>

        <label for="input-first-name" class="sr-only">${first_name}</label>
        <input type="text" id="input-first-name" class="form-control" placeholder="First name" name="input-first-name"
               required autofocus>

        <label for="input-last-name" class="sr-only">${last_name}</label>
        <input type="text" id="input-last-name" class="form-control" placeholder="Last name" name="input-last-name"
               required>

        <label for="input-email" class="sr-only">${email}</label>
        <input type="email" id="input-email" class="form-control" placeholder="Email address" name="input-email"
               required>

        <label for="input-password" class="sr-only">${password}</label>
        <input type="password" id="input-password" class="form-control" placeholder="Password" name="input-password"
               required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">${signup_button}</button>
    </form>
    <form class="form-signin" action="${pageContext.request.contextPath}/index.jsp">
        <button class="btn btn-lg btn-primary btn-block" type="submit">${login_button}</button>
    </form>

</div> <!-- /container -->

</body>
</html>