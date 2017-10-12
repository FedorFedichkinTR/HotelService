package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;

public class ChangeUserOrderService {
    private AbstractDaoFactory daoFactory;

    public ChangeUserOrderService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public boolean deleteOrder(Long orderId) {
        OrderDao orderDao = daoFactory.createOrderDAO();
        return orderDao.deleteById(orderId).equals(orderId);
    }
}
