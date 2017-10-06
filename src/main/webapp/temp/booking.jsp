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

<div class="jumbotron">
    <form method="post">
        <input type="text" name="typeOfRoom" id="typeOfRoom" placeholder="Type of room">
        <input type="number" name="numberOfPeople" min="1" max="3" id="numberOfPeople" placeholder="Number of people">
        <input type="text" class="datepicker" placeholder="Arrival">
        <input type="text" class="datepicker" placeholder="Departure">
        <button class="btn btn-primary " type="submit">Submit</button>
    </form>
</div>

</body>
</html>
