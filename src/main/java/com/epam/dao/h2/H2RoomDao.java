package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Room;
import com.epam.model.RoomType;
import com.epam.model.User;
import lombok.Builder;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Builder
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
    private static final String DELETE_ROOM_SQL =
            "DELETE FROM Rooms WHERE room_id = ?";
    private static final String GET_ALL_ROOMS_SQL =
            "SELECT room_id, capacity, type, price FROM Rooms";
    private static final String GET_ROOMS_WITH_PROPERTIES =
            "SELECT room_id, price FROM Rooms WHERE capacity = ? AND type = ?";
    private static final String GET_ROOM_DATE_INTERSECTION =
            "SELECT * FROM Orders where start_date <= ? and end_date >= ? AND room_id = ?";

    @Override
    //todo refactoring
    public Long create(Room room) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_ROOM_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, room.getRoomCapacity());
            statement.setString(2, room.getRoomType().toString());
            statement.setInt(3, room.getPrice());
            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next())
                {
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0L;
    }

    @Override
    //todo refactoring
    public Room read(Long id) {
        Room room = new Room();

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ROOM_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                room.setRoomCapacity(resultSet.getInt("capacity"));
                room.setRoomType(RoomType.valueOf(resultSet.getString("type")));
                room.setPrice(resultSet.getInt("price"));
                room.setRoomId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return room;
    }

    @Override
    //todo refactoring
    public Boolean update(Room room) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_SQL)) {
            statement.setInt(1, room.getRoomCapacity());
            statement.setString(2, room.getRoomType().toString());
            statement.setInt(3, room.getPrice());
            statement.setLong(4, room.getRoomId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Long deleteById(Long id) {
        return delete(id,connectionPool,DELETE_ROOM_SQL);
    }

    @Override
    //todo refactoring
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ROOMS_SQL)) {
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    final Room room = new Room();

                    room.setRoomId(resultSet.getLong("room_id"));
                    room.setRoomCapacity(resultSet.getInt("capacity"));
                    room.setRoomType(RoomType.valueOf(resultSet.getString("type")));
                    room.setPrice(resultSet.getInt("price"));
                    rooms.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    @Override
    //todo refactoring
    public List<Room> getRoomsWithProperties(Integer roomCapacity, RoomType roomType) {
        List<Room> rooms = new ArrayList<>();

        try(Connection connection = connectionPool.takeConnection();
        PreparedStatement statement = connection.prepareStatement(GET_ROOMS_WITH_PROPERTIES)) {
            statement.setInt(1,roomCapacity);
            statement.setString(2,roomType.toString());

            try(ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()) {
                  final Room room = new Room();

                    room.setRoomId(resultSet.getLong("room_id"));
                    room.setRoomCapacity(roomCapacity);
                    room.setRoomType(roomType);
                    room.setPrice(resultSet.getInt("price"));

                    rooms.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    //todo test
    public List<Room> getFreeRooms(LocalDate startDate, LocalDate endDate, Integer roomCapacity, RoomType roomType) {
        List<Room> freeRooms = new ArrayList<>();
        List<Long> ordersId = new ArrayList<>();
        List<Room> possibleRooms = getRoomsWithProperties(roomCapacity,roomType);

        for (Room current: possibleRooms) {
            try(Connection connection = connectionPool.takeConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ROOM_DATE_INTERSECTION)) {
                statement.setDate(1,Date.valueOf(startDate));
                statement.setDate(2,Date.valueOf(endDate));
                statement.setLong(3,current.getRoomId());

                try(ResultSet resultSet = statement.executeQuery()) {
                    while(resultSet.next()) {
                        ordersId.add(resultSet.getLong("order_id"));
                    }
                }
                if (ordersId.isEmpty()) {
                    freeRooms.add(current);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return freeRooms;
    }
}
