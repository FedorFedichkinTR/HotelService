package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.model.Order;
import com.epam.model.User;

import java.util.List;

public class ViewUserOrdersService {
    private AbstractDaoFactory daoFactory;

    public ViewUserOrdersService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Order> getOrdersOfUser(User user){
        //return daoFactory.createOrderDAO().getAllOrdersByUserID(user.getUserID());
        return daoFactory.createOrderDAO().getAllOrders();
    }
}
