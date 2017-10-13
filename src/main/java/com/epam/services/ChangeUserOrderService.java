package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.User;

public class ChangeUserOrderService {
    private AbstractDaoFactory daoFactory;

    public ChangeUserOrderService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public boolean deleteOrder(Long orderId) {
        OrderDao orderDao = daoFactory.createOrderDAO();
        return orderDao.deleteById(orderId).equals(orderId);
    }

    public boolean isBelongToUser(User user, Long orderId) {
        OrderDao orderDao = daoFactory.createOrderDAO();
        return orderDao.read(orderId).getUserID().equals(user.getUserID());
    }
}
