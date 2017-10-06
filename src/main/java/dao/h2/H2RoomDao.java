package dao.h2;

import connection_pool.ConnectionPool;
import dao.interfaces.RoomDao;
import model.Room;

import java.util.List;

public class H2RoomDao implements RoomDao {
    private final ConnectionPool connectionPool;

    public H2RoomDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Long create(Room entity) {
        return null;
    }

    @Override
    public Room read(Long id) {
        return null;
    }

    @Override
    public Long update(Room entity) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }
}
