package model;

import model.enums.RoomType;

/**
 *
 */
public class Room {
    private Long roomId;
    private Integer roomCapacity;
    private RoomType roomType;
    private Integer price;

    /**
     *
     */
    public Room() {
    }

    public Room(Long roomId, Integer roomCapacity, RoomType roomType, Integer price) {
        this.roomId = roomId;
        this.roomCapacity = roomCapacity;
        this.roomType = roomType;
        this.price = price;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return roomId + "\n"+
                "roomCapacity: " + roomCapacity + "\n"+
                "roomType: " + roomType + "\n"+
                "price: " + price;
    }
}
