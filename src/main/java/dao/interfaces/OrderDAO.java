package dao.interfaces;

import model.Order;

import java.util.List;

public interface OrderDAO {
    public Order create();

    public Order read(long readOrderID);

    public Order update(Order updatedOrder);

    public void delete(Order deletedOrder);

    public void insert(Order insertedOrder);

    public List<Order> getAllOrders();
}
