package model;

import java.util.Date;

public final class Order {
    private Long orderID;
    private Long userID;
    private Integer roomCapacity;
    private RoomType roomType;
    private Date startDate;
    private Date endDate;
    
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
