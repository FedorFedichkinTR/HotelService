package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Room;

import java.sql.*;
import java.util.List;

public class H2RoomDao implements RoomDao {
    private final ConnectionPool connectionPool;

    public H2RoomDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    private static final String CREATE_ROOM_SQL =
            "INSERT INTO Rooms (capacity,type,price) VALUES (?, ?, ?)";

    @Override
    public Long create(Room room) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_ROOM_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, room.getRoomCapacity());
            statement.setString(2, room.getRoomType().toString());
            statement.setInt(3, room.getPrice());
            statement.executeUpdate();

            try(ResultSet resultSet = statement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
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
