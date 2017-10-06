package dao.interfaces;

import model.Room;

import java.util.List;

public interface RoomDao extends CrudDao<Room,Long> {
    public List<Room> getAllRooms();
}
