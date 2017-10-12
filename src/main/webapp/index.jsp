<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
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
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me" name="remember"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
    </form>
    <form class="form-signin" action="${pageContext.request.contextPath}/register.jsp">
        <button class="btn btn-lg btn-primary btn-block" type="submit"> Sign up</button>
    </form>

</div> <!-- /container -->

</body>
</html>
