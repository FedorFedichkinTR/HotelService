package dao.h2;

import connection_pool.ConnectionPool;
import dao.interfaces.RoomDAO;
import model.Room;

import java.util.List;

public class H2RoomDAO implements RoomDAO{
    private final ConnectionPool connectionPool;

    public H2RoomDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Room read(long readRoomID) {
        return null;
    }

    @Override
    public Room update(Room updateRoom) {
        return null;
    }

    @Override
    public void delete(Room deletedRoom) {

    }

    @Override
    public void insert(Room insertedRoom) {

    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }
}
