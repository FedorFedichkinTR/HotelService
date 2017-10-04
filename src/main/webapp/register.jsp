<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sign up</title>
</head>

<body>
<h2>Greetings, traveler!</h2>
<div>
    <form method="post" action="${pageContext.request.contextPath}/register">
        <p>
            <label>
                Mail
                <input type="text" name="mail">
            </label>
        </p>
        <p>
            <label>
                Password
                <input type="text" name="password">
            </label>
        <p>
            <label>
                First name
                <input type="text" name="firstName">
            </label>
        <p>
            <label>
                Last name
                <input type="text" name="lastName">
            </label>
        <p>
            <button type="submit"> Sign up </button>
    </form>
</div>
</body>
</html>