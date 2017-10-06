package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;

import java.util.List;

public class H2OrderDao implements OrderDao {
    private final ConnectionPool connectionPool;

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
    public Long delete(Long id) {
        return null;
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
