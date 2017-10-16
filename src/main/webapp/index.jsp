<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <%--<fmt:setLocale value="${sessionScope.locale}"/>--%>
    <%--<fmt:setBundle basename="text" var="localization"/>--%>
    <%--<fmt:message bundle="${localization}" key="profile" var="profile"/>--%>
    <%--<fmt:message bundle="${localization}" key="logout" var="logout"/>--%>
    <%--<fmt:message bundle="${localization}" key="english" var="english"/>--%>
    <%--<fmt:message bundle="${localization}" key="russian" var="russian"/>--%>
    <%--<fmt:message bundle="${localization}" key="instruments" var="instruments"/>--%>
    <%--<fmt:message bundle="${localization}" key="like" var="like"/>--%>
    <%--<fmt:message bundle="${localization}" key="newTweetPlaceholder" var="newTweetPlaceholder"/>--%>
    <%--<fmt:message bundle="${localization}" key="myTweets" var="myTweets"/>--%>
    <%--<fmt:message bundle="${localization}" key="country" var="country"/>--%>
    <%--<fmt:message bundle="${localization}" key="post" var="post"/>--%>
    <%--<fmt:message bundle="${localization}" key="cancel" var="cancel"/>--%>
    <%--<fmt:message bundle="${localization}" key="subscribe" var="subscribe"/>--%>
    <%--<fmt:message bundle="${localization}" key="subscriptions" var="subscriptions"/>--%>
    <%--<fmt:message bundle="${localization}" key="profileSettings" var="editProfile"/>--%>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Sign in</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/signin.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <span style="color: red;">
            <c:if test="${requestScope.get(\"error\") != null}">
                <p>${requestScope.get("error")}</p>
            </c:if>
        </span>
        <label for="input-email" class="sr-only">Email address</label>
        <input type="email" id="input-email" class="form-control" placeholder="Email address" name="input-email"
               required
               autofocus>
        <label for="input-password" class="sr-only">Password</label>
        <input type="password" id="input-password" class="form-control" placeholder="Password" name="input-password"
               required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
    </form>
    <form class="form-signin" action="${pageContext.request.contextPath}/register.jsp">
        <button class="btn btn-lg btn-primary btn-block" type="submit"> Sign up</button>
    </form>

</div> <!-- /container -->

</body>
</html>
