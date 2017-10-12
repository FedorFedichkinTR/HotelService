function orderApproved(order_id) {
    var e = document.getElementById(order_id + "selected-room");
    var room_id = e.value;
    $.post("approve_order", {
            order_id: order_id,
            room_id: room_id
        },
        function (response) {
            if (response == room_id) {
                $('#' + order_id).html("<p>Order approved. Room № " + response + ".</p>");
            }
            else {
                alert("Error happened");
            }
        });
}

