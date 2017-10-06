package com.epam.model;


public class Bill {
    private Long billID;
    private Long userID;
    private Long adminID;
    private Long orderID;
    private Integer price;
    private Boolean status;
    private Long roomID;

    public Bill() {
    }

    public Bill(Long billID, Long userID, Long adminID, Long orderID, Integer price, Boolean status, Long roomID) {
        this.billID = billID;
        this.userID = userID;
        this.adminID = adminID;
        this.orderID = orderID;
        this.price = price;
        this.status = status;
        this.roomID = roomID;
    }

    public Long getBillID() {
        return billID;
    }

    public void setBillID(Long billID) {
        this.billID = billID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    @Override
    public String toString() {
        return "bill ID: " + billID + "\n" +
                "user ID: " + userID + "\n" +
                "admin ID: " + adminID + "\n" +
                "order ID:" + orderID + "\n" +
                "room price: " + price + "\n" +
                "room status: " + status + "\n" +
                "room ID : " + roomID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (!billID.equals(bill.billID)) return false;
        if (!userID.equals(bill.userID)) return false;
        if (!adminID.equals(bill.adminID)) return false;
        if (!orderID.equals(bill.orderID)) return false;
        if (!price.equals(bill.price)) return false;
        if (!status.equals(bill.status)) return false;
        return roomID.equals(bill.roomID);
    }

    @Override
    public int hashCode() {
        int result = billID.hashCode();
        result = 31 * result + userID.hashCode();
        result = 31 * result + adminID.hashCode();
        result = 31 * result + orderID.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + roomID.hashCode();
        return result;
    }
}
