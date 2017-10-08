package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;

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
    public Long create(Order entity) {
        return null;
    }

    @Override
    public Order read(Long id) {
        return null;
    }

    @Override
    public Long update(Order entity) {
        return null;
    }

    @Override
    public Long deleteById(Long id) {
        return delete(id,connectionPool,DELETE_ORDER_SQL);
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
