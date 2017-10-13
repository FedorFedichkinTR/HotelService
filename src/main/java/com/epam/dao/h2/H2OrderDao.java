package com.epam.dao.h2;

import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;
import com.epam.model.RoomType;
import lombok.extern.log4j.Log4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class H2OrderDao implements OrderDao {

    private static final String CREATE_ORDER_SQL =
            "INSERT INTO Orders (user_id, capacity, type,start_date, end_date) VALUES (?, ?, ?, ?, ?)";
    private static final String READ_ORDER_BY_ID =
            "SELECT user_id, room_id, capacity, type, status, start_date, end_date, admin_id, price FROM Orders WHERE order_id= ?";
    private static final String UPDATE_ORDER_SQL =
            "UPDATE Orders SET user_id = ?, room_id = ?, capacity = ?, type = ?, status = ?, start_date = ?, end_date = ?, admin_id = ?, price = ? WHERE order_id = ?";
    private static final String DELETE_ORDER_SQL =
            "DELETE FROM Orders WHERE order_id = ?";
    private static final String GET_ALL_ORDERS_SQL =
            "SELECT order_id, user_id, room_id, capacity, type, status, start_date, end_date, admin_id, price FROM Orders";
    private static final String GET_ALL_ORDERS_BY_USER_ID_SQL =
            "SELECT order_id, room_id, capacity, type, status, start_date, end_date, admin_id, price FROM Orders WHERE user_id = ?";
    private final DataSource dataSource;

    public H2OrderDao(DataSource dataSource) {
        log.info("DataSource from H2OrderDao Constructor: " + dataSource);
        this.dataSource = dataSource;
    }

    @Override
    //todo following refactoring (future)
    public Long create(Order order) {
        log.info("DataSource from H2OrderDao create method: " + dataSource);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_ORDER_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, order.getUserID());
            statement.setInt(2, order.getRoomCapacity());
            statement.setString(3, order.getRoomType().toString());
            statement.setObject(4, order.getStartDate());
            statement.setObject(5, order.getEndDate());
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
    //todo following refactoring (future)
    public Order read(Long orderId) {
        Order order = new Order();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ORDER_BY_ID)) {
            statement.setLong(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                order.setUserID(resultSet.getLong("user_id"));
                order.setRoomID(resultSet.getLong("room_id"));
                order.setRoomCapacity(resultSet.getInt("capacity"));
                order.setRoomType(RoomType.valueOf(resultSet.getString("type")));
                order.setStatus(resultSet.getBoolean("status"));
                order.setStartDate(resultSet.getDate("start_date").toLocalDate());
                order.setEndDate(resultSet.getDate("end_date").toLocalDate());
                order.setOrderID(orderId);
                order.setAdminID(resultSet.getLong("admin_id"));
                order.setPrice(resultSet.getInt("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    //todo following refactoring (future)
    public Boolean update(Order order) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL)) {
            statement.setLong(1, order.getUserID());
            statement.setLong(2, order.getRoomID());
            statement.setInt(3, order.getRoomCapacity());
            statement.setString(4, order.getRoomType().toString());
            statement.setBoolean(5, order.getStatus());
            statement.setDate(6, java.sql.Date.valueOf(order.getStartDate()));
            statement.setDate(7, java.sql.Date.valueOf(order.getEndDate()));
            statement.setLong(8, order.getAdminID());
            statement.setInt(9, order.getPrice());
            statement.setLong(10, order.getOrderID());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Long deleteById(Long id) {
        return delete(id, dataSource, DELETE_ORDER_SQL);
    }

    @Override
    //todo following refactoring (future)
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_ORDERS_SQL)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final Order order = new Order();

                    order.setUserID(resultSet.getLong("user_id"));
                    order.setRoomID(resultSet.getLong("room_id"));
                    order.setOrderID(resultSet.getLong("order_id"));
                    order.setAdminID(resultSet.getLong("admin_id"));
                    order.setRoomCapacity(resultSet.getInt("capacity"));
                    order.setRoomType(RoomType.valueOf(resultSet.getString("type")));
                    order.setStatus(resultSet.getBoolean("status"));
                    order.setStartDate(resultSet.getDate("start_date").toLocalDate());
                    order.setEndDate(resultSet.getDate("end_date").toLocalDate());
                    order.setPrice(resultSet.getInt("price"));

                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    //todo following refactoring (future)
    public List<Order> getAllOrdersByUserID(Long userID) {
        List<Order> ordersById = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_ORDERS_BY_USER_ID_SQL)) {
            statement.setLong(1, userID);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final Order order = new Order();

                    order.setUserID(userID);
                    Long roomID = resultSet.getLong("room_id") == 0 ? null : resultSet.getLong("room_id");
                    order.setRoomID(roomID);
                    order.setOrderID(resultSet.getLong("order_id"));
                    order.setAdminID(resultSet.getLong("admin_id"));
                    order.setRoomCapacity(resultSet.getInt("capacity"));
                    order.setRoomType(RoomType.valueOf(resultSet.getString("type")));
                    order.setStatus(resultSet.getBoolean("status"));
                    order.setStartDate(resultSet.getDate("start_date").toLocalDate());
                    order.setEndDate(resultSet.getDate("end_date").toLocalDate());
                    order.setPrice(resultSet.getInt("price"));

                    ordersById.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordersById;
    }
}
