<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap core CSS -->
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../static/css/navbar-top-fixed.css" rel="stylesheet">

    <link href="../static/css/booking.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <%--<a class="navbar-brand" href="#">Fixed navbar</a>--%>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse mt-2 mt-md-0" id="navbarCollapse" >
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/temp/myorders.jsp">My orders</a>
            </li>
            <li class="nav-item">
                <div class="dropdown show">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Language
                    </a>

                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="#">English</a>
                        <a class="dropdown-item" href="#">Русский</a>
                    </div>
                </div>
            </li>
        </ul>
        <%--<form class="form-inline mt-2 mt-md-0">--%>
            <%--<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">--%>
            <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
        <%--</form>--%>
    </div>
</nav>

<div>
    <form method="post" action="${pageContext.request.contextPath}/temp/myorders.jsp">
        <p>
            <button>My orders</button>
        </p>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="../static/js/popper.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
</body>
</html>
