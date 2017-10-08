package com.epam.dao.interfaces;

import com.epam.model.Order;

import java.util.List;

public interface OrderDao extends CrudDao<Order,Long> {
    public List<Order> getAllOrders();

    public List<Order> getAllOrdersByUserID(long userID);
}
