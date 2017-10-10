<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <%--<a class="navbar-brand" href="#">Fixed navbar</a>--%>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse mt-2 mt-md-0" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/temp/booking.jsp"> Booking </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/userOrders">
                    Orders
                </a>
            </li>
        </ul>
        <ul class="navbar-nav navbar-right">
            <li class="nav-item" id="language">
                <div class="dropdown show">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                       style="background-color: #343a40; border: none">
                        Language
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="#">English</a>
                        <a class="dropdown-item" href="#">Русский</a>
                    </div>
                </div>
            </li>
            <li class="nav-item active">
                <form method="post" action="${pageContext.request.contextPath}/logout">
                    <button class="btn" style="background-color: #343a40; color: white; border: transparent">Sign out
                    </button>
                </form>
            </li>
        </ul>
    </div>
</nav>