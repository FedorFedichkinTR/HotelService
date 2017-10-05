package model;

import model.enums.RoomType;

import java.util.Date;

/**
 *
 */
public final class Order {
    private Long orderID;
    private Long userID;
    private Integer roomCapacity;
    private RoomType roomType;
    private Date startDate;
    private Date endDate;

    /**
     *
     */
    public Order() {
    }

    public Order(Long orderID, Long userID, Integer roomCapacity, RoomType roomType, Date startDate, Date endDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.roomCapacity = roomCapacity;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}
