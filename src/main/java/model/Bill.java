package model;

/**
 *
 */
public class Bill {
    private long billID;
    private long userID;
    private long adminID;
    private long orderID;
    private int price;
    private Boolean status;
    private long roomID;

    /**
     *
     */
    public Bill() {
    }

    /**
     *
     * @param billID
     * @param userID
     * @param adminID
     * @param orderID
     * @param price
     * @param status
     * @param roomID
     */
    public Bill(long billID, long userID, long adminID, long orderID, int price, Boolean status, long roomID) {
        this.billID = billID;
        this.userID = userID;
        this.adminID = adminID;
        this.orderID = orderID;
        this.price = price;
        this.status = status;
        this.roomID = roomID;
    }

    public long getBillID() {
        return billID;
    }

    public void setBillID(long billID) {
        this.billID = billID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }
}
