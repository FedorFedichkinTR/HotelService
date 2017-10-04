package model;

/**
 *
 */
public class Room {
    private long roomId;
    private int roomCapacity;
    private RoomType roomType;
    private int price;

    /**
     *
     */
    public Room() {
    }

    /**
     *
     * @param roomId
     * @param roomCapacity
     * @param roomType
     * @param price
     */
    public Room(long roomId, int roomCapacity, RoomType roomType, int price) {
        this.roomId = roomId;
        this.roomCapacity = roomCapacity;
        this.roomType = roomType;
        this.price = price;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
