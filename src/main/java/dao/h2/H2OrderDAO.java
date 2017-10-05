package dao.h2;

import connection_pool.ConnectionPool;
import dao.interfaces.OrderDAO;
import model.Order;

import java.util.List;

public class H2OrderDAO implements OrderDAO{
    private final ConnectionPool connectionPool;

    public H2OrderDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Order read(long readOrderID) {
        return null;
    }

    @Override
    public Order update(Order updatedOrder) {
        return null;
    }

    @Override
    public void delete(Order deletedOrder) {

    }

    @Override
    public void insert(Order insertedOrder) {

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
