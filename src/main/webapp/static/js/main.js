function orderApproved(orderID) {
    $.post("orderApproved", {
        orderID: orderID
    }, function () {

    })
}