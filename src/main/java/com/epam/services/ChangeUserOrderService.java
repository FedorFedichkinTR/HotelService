package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;
import com.epam.model.User;

/**
 * Handles user options for orders - pay, delete, edit.
 */
public class ChangeUserOrderService {
    private OrderDao orderDao;

    public ChangeUserOrderService(AbstractDaoFactory daoFactory) {
        orderDao = daoFactory.createOrderDAO();
    }

    /**
     * Deletes order from database by orderId
     *
     * @param orderId
     * @return true, if order was deleted successfully, false otherwise
     */
    public boolean deleteOrder(Long orderId) {
        return orderDao.deleteById(orderId).equals(orderId);
    }

    public boolean isBelongToUser(User user, Long orderId) {
        return orderDao.read(orderId).getUserID().equals(user.getUserID());
    }

    /**
     * Changes status of order.
     *
     * @param orderId
     * @return true, if update was successful and false otherwise.
     */
    public boolean payOrder(Long orderId) {
        Order order = orderDao.read(orderId);
        if (order.getRoomID() != 0) {
            order.setStatus(true);
        }
        return orderDao.update(order);
    }

    /**
     * Changes order - sets new dates, count of guests or room type.
     *
     * @param order - changing order
     * @return orderId
     */
    public Long changeOrder(Order order) {
        Order oldOrder = orderDao.read(order.getOrderID());
        oldOrder.setStartDate(order.getStartDate());
        oldOrder.setEndDate(order.getEndDate());
        oldOrder.setRoomCapacity(order.getRoomCapacity());
        oldOrder.setRoomType(order.getRoomType());
        orderDao.deleteById(order.getOrderID());
        return orderDao.create(oldOrder);
    }
}
