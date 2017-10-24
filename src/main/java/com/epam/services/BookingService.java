package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;

public class BookingService {
    private AbstractDaoFactory daoFactory;

    public BookingService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * Creates new order
     *
     * @param newOrder - order from servlet
     * @return orderId
     */
    public Long bookRoom(Order newOrder) {
        OrderDao orderDao = daoFactory.createOrderDAO();
        newOrder.setStatus(false);
        return orderDao.create(newOrder);
    }
}
