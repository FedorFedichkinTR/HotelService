package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;
import com.epam.model.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.List;

public class H2OrderDao implements OrderDao {
    private final ConnectionPool connectionPool;

    private static final String CREATE_ORDER_SQL =
            "INSERT INTO Orders (user_id, room_id, capacity, type, status, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_ORDER_BY_ID =
            "SELECT user_id, room_id, capacity, type, status, start_date, end_date FROM Orders WHERE order_id= ?";
    private static final String UPDATE_ORDER_SQL =
            "UPDATE Orders SET user_id = ?, room_id = ?, capacity = ?, type = ?, status = ?, start_date = ?, end_date = ? WHERE order_id = ?";
    private static final String DELETE_ORDER_SQL =
            "DELETE FROM Orders WHERE order_id = ?";

    public H2OrderDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Long create(Order order) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_ORDER_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, order.getUserID());
            statement.setLong(2, order.getOrderID());
            statement.setInt(3, order.getRoomCapacity());
            statement.setString(4, order.getRoomType().toString());
            statement.setString(5, order.getStatus());
            statement.setString(6, order.getStartDate().toString());
            statement.setString(7, order.getEndDate().toString());
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
    public Order read(Long orderId) {
        Order order = new Order();

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ORDER_BY_ID)) {
            statement.setLong(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                order.setUserID(resultSet.getLong("user_id"));
                order.setRoomID(resultSet.getLong("room_id"));
                order.setRoomCapacity(resultSet.getInt("capacity"));
                order.setRoomType(RoomType.valueOf(resultSet.getString("type")));
                order.setStatus(resultSet.getString("status"));
                //TODO How to do it right??
                //order.setStartDate(OffsetDateTime.of(resultSet.getDate("start_date"),);
                //order.setEndDate(resultSet.getDate("end_date"));
                order.setOrderID(orderId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Long update(Order order) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL)) {
            statement.setLong(1, order.getUserID());
            statement.setLong(2, order.getRoomID());
            statement.setInt(3, order.getRoomCapacity());
            statement.setString(4, order.getRoomType().toString());
            statement.setString(5, order.getStatus());
            //TODO what to do??
//            statement.setDate(6,order.getStartDate());
//            statement.setDate(7,order.getEndDate());
            statement.setLong(8, order.getOrderID());
            statement.executeUpdate();
            return order.getOrderID();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Long deleteById(Long id) {
        return delete(id, connectionPool, DELETE_ORDER_SQL);
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Order> getAllOrdersByUserID(long userID) {
        return null;
    }
}
