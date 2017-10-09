package com.epam.model;


import java.time.LocalDate;

public final class Order {
    private Long orderID;
    private Long userID;
    private Integer roomCapacity;
    private RoomType roomType;
    private LocalDate startDate;
    private LocalDate endDate;
    //TODO Approve!
    private Long roomID;
    private String status;
    
    public Order() {
    }

    public Order(Long orderID, Long userID, Integer roomCapacity, RoomType roomType, LocalDate startDate, LocalDate endDate, Long roomID, String status) {
        this.orderID = orderID;
        this.userID = userID;
        this.roomCapacity = roomCapacity;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomID = roomID;
        this.status = status;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "orderID: " + orderID + "\n" +
                "userID: " + userID + "\n" +
                "roomCapacity: " + roomCapacity + "\n" +
                "roomType: " + roomType + "\n" +
                "startDate: " + startDate + "\n" +
                "endDate:" + endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!orderID.equals(order.orderID)) return false;
        if (!userID.equals(order.userID)) return false;
        if (!roomCapacity.equals(order.roomCapacity)) return false;
        if (roomType != order.roomType) return false;
        if (!startDate.equals(order.startDate)) return false;
        return endDate.equals(order.endDate);
    }

    @Override
    public int hashCode() {
        int result = orderID.hashCode();
        result = 31 * result + userID.hashCode();
        result = 31 * result + roomCapacity.hashCode();
        result = 31 * result + roomType.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }

}
