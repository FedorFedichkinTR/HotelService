<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sign up</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/signin.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <form method="post" class="form-signin" action="${pageContext.request.contextPath}/register">
        <h2 class="form-signin-heading">Register</h2>

        <label for="input-first-name" class="sr-only">First name</label>
        <input type="text" id="input-first-name" class="form-control" placeholder="First name" name="input-first-name"
               required autofocus>

        <label for="input-last-name" class="sr-only">Last name</label>
        <input type="text" id="input-last-name" class="form-control" placeholder="Last name" name="input-last-name"
               required>

        <label for="input-email" class="sr-only">Email address</label>
        <input type="email" id="input-email" class="form-control" placeholder="Email address" name="input-email"
               required>

        <label for="input-password" class="sr-only">Password</label>
        <input type="password" id="input-password" class="form-control" placeholder="Password" name="input-password"
               required>

        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me" name="remember"> Remember me
            </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form>
    <form class="form-signin" action="${pageContext.request.contextPath}/index.jsp">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
    </form>

</div> <!-- /container -->

</body>
</html>