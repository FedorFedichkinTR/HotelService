package dao.interfaces;

import model.Room;

import java.util.List;

public interface RoomDAO extends DAOCRUD<Room,Long> {
    public List<Room> getAllRooms();
}
