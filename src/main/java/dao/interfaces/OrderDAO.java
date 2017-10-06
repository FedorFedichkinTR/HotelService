package dao.interfaces;

import model.Order;

import java.util.List;

public interface OrderDAO extends DAOCRUD<Order,Long> {
    public List<Order> getAllOrders();

    public List<Order> getAllOrdersByUserID(long userID);
}
