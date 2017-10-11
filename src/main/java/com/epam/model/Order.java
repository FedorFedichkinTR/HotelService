package com.epam.model;


import lombok.Builder;

import java.time.LocalDate;

@Builder
public final class Order {
    private Long orderID;
    private Long userID;
    private Long adminID;
    private Long roomID;
    private Integer roomCapacity;
    private Integer price;
    private RoomType roomType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean status;

    public Order() {
    }

    public Order(Long orderID, Long userID, Long adminID, Long roomID, Integer roomCapacity, Integer price,
                 RoomType roomType, LocalDate startDate, LocalDate endDate, Boolean status) {
        this.orderID = orderID;
        this.userID = userID;
        this.adminID = adminID;
        this.roomID = roomID;
        this.roomCapacity = roomCapacity;
        this.price = price;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderID != null ? !orderID.equals(order.orderID) : order.orderID != null) return false;
        if (userID != null ? !userID.equals(order.userID) : order.userID != null) return false;
        if (adminID != null ? !adminID.equals(order.adminID) : order.adminID != null) return false;
        if (roomID != null ? !roomID.equals(order.roomID) : order.roomID != null) return false;
        if (roomCapacity != null ? !roomCapacity.equals(order.roomCapacity) : order.roomCapacity != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        if (roomType != order.roomType) return false;
        if (startDate != null ? !startDate.equals(order.startDate) : order.startDate != null) return false;
        if (endDate != null ? !endDate.equals(order.endDate) : order.endDate != null) return false;
        return status != null ? status.equals(order.status) : order.status == null;
    }

    @Override
    public int hashCode() {
        int result = orderID != null ? orderID.hashCode() : 0;
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        result = 31 * result + (adminID != null ? adminID.hashCode() : 0);
        result = 31 * result + (roomID != null ? roomID.hashCode() : 0);
        result = 31 * result + (roomCapacity != null ? roomCapacity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", adminID=" + adminID +
                ", roomID=" + roomID +
                ", roomCapacity=" + roomCapacity +
                ", price=" + price +
                ", roomType=" + roomType +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }

//    @Override
//    public String toString() {
//        return "orderID: " + orderID + "\n" +
//                "userID: " + userID + "\n" +
//                "roomCapacity: " + roomCapacity + "\n" +
//                "roomType: " + roomType + "\n" +
//                "startDate: " + startDate + "\n" +
//                "endDate:" + endDate;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Order order = (Order) o;
//
//        if (!orderID.equals(order.orderID)) return false;
//        if (!userID.equals(order.userID)) return false;
//        if (!roomCapacity.equals(order.roomCapacity)) return false;
//        if (roomType != order.roomType) return false;
//        if (!startDate.equals(order.startDate)) return false;
//        return endDate.equals(order.endDate);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = orderID.hashCode();
//        result = 31 * result + userID.hashCode();
//        result = 31 * result + roomCapacity.hashCode();
//        result = 31 * result + roomType.hashCode();
//        result = 31 * result + startDate.hashCode();
//        result = 31 * result + endDate.hashCode();
//        return result;
//    }

}
