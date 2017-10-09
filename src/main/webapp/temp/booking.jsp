<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Booking</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../static/css/jquery-ui.css">
    <link rel="stylesheet" href="../static/css/booking.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $(".datepicker").datepicker();
        });
    </script>
</head>
<body>

<jsp:include page="../static/common/navbar.jsp"/>
<div class="alert alert-warning" role="alert"><strong>WAWDAWDFEIOHWEF!!!!@1111!!!!</strong></div>
<div class="jumbotron">
    <form method="post">
        <div class="input-group">
            <input type="text" name="typeOfRoom" id="typeOfRoom" placeholder="Type of room">
            <input type="number" name="numberOfPeople" min="1" max="3" id="numberOfPeople"
                   placeholder="Number of people" title="DANGER!!11!!1!">
            <input type="text" class="datepicker" placeholder="Arrival" name="arrival">
            <input type="text" class="datepicker" placeholder="Departure" name = "departure">
            <button class="btn btn-default" type="submit">
                <i class="glyphicon glyphicon-search"></i>
            </button>
        </div>
    </form>
</div>

</body>
</html>
