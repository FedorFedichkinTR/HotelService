package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;
import com.epam.model.User;

public class ChangeUserOrderService {
    private OrderDao orderDao;

    public ChangeUserOrderService(AbstractDaoFactory daoFactory) {
        orderDao = daoFactory.createOrderDAO();
    }

    public boolean deleteOrder(Long orderId) {
        return orderDao.deleteById(orderId).equals(orderId);
    }

    public boolean isBelongToUser(User user, Long orderId) {
        return orderDao.read(orderId).getUserID().equals(user.getUserID());
    }

    public boolean payOrder(Long orderId) {
        Order order = orderDao.read(orderId);
        if (order.getRoomID() != 0) {
            order.setStatus(true);
        }
        return orderDao.update(order);
    }

    public Long changeOrder(Order order){
        Order oldOrder = orderDao.read(order.getOrderID());
        oldOrder.setStartDate(order.getStartDate());
        oldOrder.setEndDate(order.getEndDate());
        oldOrder.setRoomCapacity(order.getRoomCapacity());
        oldOrder.setRoomType(order.getRoomType());
        orderDao.deleteById(order.getOrderID());
        return orderDao.create(oldOrder);
        //return orderDao.update(oldOrder);
    }
}
