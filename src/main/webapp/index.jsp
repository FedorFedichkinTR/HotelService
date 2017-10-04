<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<div>
    <h2> Greetings, traveler! </h2>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <label>
            Mail
            <input type="text" name="mail">
        </label>
        <label>
            Password
            <input type="text" name="password">
        </label>
        <button type="submit"> Log in</button>
    </form>
</div>
or
<div>
    <p>
    <form method="post" action="${pageContext.request.contextPath}/register.jsp">
        <button>Register</button>
    </form>
    </p>
</div>
</body>
</html>
