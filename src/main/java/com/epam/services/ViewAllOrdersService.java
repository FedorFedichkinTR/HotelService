package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.model.Order;

import java.util.List;

public class ViewAllOrdersService {
    private AbstractDaoFactory daoFactory;

    public ViewAllOrdersService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Order> getAllOrders(){
        return daoFactory.createOrderDAO().getAllOrders();
    }
}
