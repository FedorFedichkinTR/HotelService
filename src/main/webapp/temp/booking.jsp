<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Booking</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="../static/js/jquery-3.2.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="../static/js/popper.min.js"></script>
    <script src="../static/js/bootstrap/bootstrap.min.js"></script>

    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/css/navbar-top-fixed.css">
    <link rel="stylesheet" href="../static/css/jquery-ui.css">
    <link rel="stylesheet" href="../static/css/booking.css">
    <link rel="stylesheet" href="../static/css/font-awesome.min.css">

    <script>
        $(function () {
            $(".datePicker").datepicker();
        });
    </script>
</head>
<body>

<jsp:include page="../static/common/navbar.jsp"/>

<div class="jumbotron">
    <form method="post">
        <div class="input-group">
            <input type="text" name="typeOfRoom" id="typeOfRoom" placeholder="Type of room">
            <input type="number" name="numberOfPeople" min="1" max="3" id="numberOfPeople"
                   placeholder="Number of people" oninvalid="this.setCustomValidity('')"
                   oninput="setCustomValidity('')">
            <input type="text" class="datePicker" placeholder="Arrival" name="arrival">
            <input type="text" class="datePicker" placeholder="Departure" name="departure">
            <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
        </div>
    </form>
</div>

</body>
</html>
