package model;


public class Room {
    private Long roomId;
    private Integer roomCapacity;
    private RoomType roomType;
    private Integer price;
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (!roomId.equals(room.roomId)) return false;
        if (!roomCapacity.equals(room.roomCapacity)) return false;
        if (roomType != room.roomType) return false;
        return price.equals(room.price);
    }

    @Override
    public int hashCode() {
        int result = roomId.hashCode();
        result = 31 * result + roomCapacity.hashCode();
        result = 31 * result + roomType.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
