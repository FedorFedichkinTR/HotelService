package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Room;
import com.epam.model.RoomType;

import java.sql.*;
import java.util.List;

public class H2RoomDao implements RoomDao {
    private final ConnectionPool connectionPool;

    public H2RoomDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    private static final String CREATE_ROOM_SQL =
            "INSERT INTO Rooms (capacity, type, price) VALUES (?, ?, ?)";
    private static final String READ_ROOM_BY_ID =
            "SELECT capacity, type, price FROM Rooms WHERE room_id = ?";
    private static final String UPDATE_ROOM_SQL =
            "UPDATE Rooms SET capacity = ?, type = ?, price = ? WHERE room_id = ?";

    @Override
    public Long create(Room room) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_ROOM_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, room.getRoomCapacity());
            statement.setString(2, room.getRoomType().toString());
            statement.setInt(3, room.getPrice());
            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
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
        Room room = new Room();

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ROOM_BY_ID)) {
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                room.setRoomCapacity(resultSet.getInt("capacity"));
                room.setRoomType(RoomType.valueOf(resultSet.getString("type")));
                room.setRoomId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public Long update(Room room) {
        try (Connection connection =  connectionPool.takeConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_SQL)) {
            statement.setInt(1,room.getRoomCapacity());
            statement.setString(2,room.getRoomType().toString());
            statement.setInt(3,room.getPrice());
            statement.setLong(4,room.getRoomId());
            statement.executeUpdate();
            return room.getRoomId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
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
