<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Search Glyph</h2>
    <p>Search icon: <span class="glyphicon glyphicon-search"></span></p>
    <p>Search icon as a link:
        <a href="#">
            <span class="glyphicon glyphicon-search"></span>
        </a>
    </p>
    <p>Search icon on a button:
        <button type="button" class="btn btn-default btn-sm">
            <span class="glyphicon glyphicon-search"></span> Search
        </button>
    </p>
    <p>Search icon on a styled link button:
        <a href="#" class="btn btn-info btn-lg">
            <span class="glyphicon glyphicon-search"></span> Search
        </a>
    </p>
</div>
</body>
</html>
