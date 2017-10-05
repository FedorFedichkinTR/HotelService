package dao.interfaces;

import model.Room;

public interface RoomDAO {
    public Room create();

    public Room read(long readRoomID);

    public Room update(Room updateRoom);

    public void delete(Room deletedRoom);

    public void insert(Room insertedRoom);
}
