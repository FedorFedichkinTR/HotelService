package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;

public class BookingService {
    private AbstractDaoFactory daoFactory;

    public BookingService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Long bookRoom(Order newOrder){
        OrderDao orderDao = daoFactory.createOrderDAO();
        Long newOrderId = orderDao.create(newOrder);
        return newOrderId;
    }
}
