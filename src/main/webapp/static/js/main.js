function calendar() {
    $(".datePicker").datepicker();
}

function orderApproved(order_id) {
    var room_id = document.getElementById(order_id + "selected-room").value;
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

function submitChanges(order_id) {
    const arrival = document.getElementById(order_id + " arrival").value;
    const departure = (document.getElementById(order_id + " departure")).value;
    const room_type = (document.getElementById(order_id + " room-type")).value;
    const capacity = (document.getElementById(order_id + " number-of-people")).value;
    $.post("/change_user_orders", {
            order_id: order_id,
            arrival: arrival,
            departure: departure,
            room_type: room_type,
            capacity: capacity
        },
        function (response) {
            if (response === 'true') {
                const currentRow = '#' + order_id + 'row';
                ($(currentRow).find("td:eq(0)")).html(`${arrival}`);
                ($(currentRow).find("td:eq(1)")).html(`${departure}`);
                ($(currentRow).find("td:eq(2)")).html(`${room_type}`);
                ($(currentRow).find("td:eq(3)")).html(`${capacity}`);
                ($(currentRow).find("td:eq(9)")).html(`<button name="edit" class="btn btn-primary edit" onclick="editOrder(` + order_id + `)">
                         Edit order</button>`)
            }
        });
}

function editOrder(order_id) {
    const currentRow = '#' + order_id + 'row';
    const arrival = $(currentRow).find("td:eq(0)").text();
    const departure = $(currentRow).find("td:eq(1)").text();
    const type_of_room = $(currentRow).find("td:eq(2)").text();
    const capacity = $(currentRow).find("td:eq(3)").text();
    var type_index = 0;

    if (type_of_room.toUpperCase() === "JUNIOR") {
        type_index = 1;
    } else if (type_of_room.toUpperCase() === "STANDARD") {
        type_index = 2;
    }

    ($(currentRow).find("td:eq(0)")).html(`<form method="post"><input type="text" class="datePicker"
                        placeholder="Arrival" id="${order_id} arrival" value = ${arrival} required>`);
    ($(currentRow).find("td:eq(1)")).html(`<input type=\"text\" class=\"datePicker\" placeholder=\"Departure\" id="${order_id} departure" value=${departure} required>`);
    calendar();
    ($(currentRow).find("td:eq(2)")).html(`<select class=\"form-control validate[required]\" title="room-type" id="${order_id} room-type" required>\n" +
        "                <option value="Suite">Suite</option>\\n" +
        "                <option value="Junior">Junior</option>\n" +
        "                <option value="Standard">Standard</option>\n" +
        "            </select>`);
    document.getElementById(order_id + " room-type").selectedIndex = type_index;
    ($(currentRow).find("td:eq(3)")).html(` <select class=\"form-control validate[required]\"  title=\"number-of-people\" id="${order_id} number-of-people"\n" +
        "                    required style=\"opacity: 1\">\n" +
        "                <option value="1">1</option>\n" +
        "                <option value="2">2</option>\n" +-->
        "                <option value="3">3</option>\n" +
        "            </select>`);
    document.getElementById(order_id + " number-of-people").selectedIndex = capacity - 1;
    ($(currentRow).find("td:eq(9)")).html(` <button name="submitChanges" class="btn btn-primary submit" onclick="submitChanges(${order_id})">
                            Submit
                        </button> </form>`);

}