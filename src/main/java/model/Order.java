package model;

import java.util.Date;

/**
 *
 */
public final class Order {
    private long orderID;
    private long userID;
    private int roomCapacity;
    private RoomType roomType;
    private Date startDate;
    private Date endDate;

    /**
     *
     */
    public Order() {
    }

    /**
     *
     * @param orderID
     * @param userID
     * @param roomCapacity
     * @param roomType
     * @param startDate
     * @param endDate
     */
    public Order(long orderID, long userID, int roomCapacity, RoomType roomType, Date startDate, Date endDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.roomCapacity = roomCapacity;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
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
}
