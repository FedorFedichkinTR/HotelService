<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <%--<!-- Bootstrap core CSS -->--%>
    <%--<link href="../../static/css/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- Custom styles for this template -->--%>
    <%--<link href="../../static/css/navbar-top-fixed.css" rel="stylesheet">--%>

   <%-- <script src="../js/jquery-3.2.1.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>--%>
    <%--<script src = "../js/jquery-3.2.1.js"></script>--%>
    <%--<script src="../../static/js/popper.min.js"></script>--%>
    <%--<script src="../../static/js/bootstrap/bootstrap.min.js"></script>--%>
</head>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <%--<a class="navbar-brand" href="#">Fixed navbar</a>--%>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse mt-2 mt-md-0" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#"> Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/temp/myorders.jsp">
                    Orders
                </a>
            </li>
        </ul>
        <ul class="navbar-nav navbar-right">
            <li class="nav-item" id="language">
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
            <li class="nav-item active">
                <a class="nav-link" href="#"> Sign out </a>
            </li>
        </ul>
    </div>
</nav>