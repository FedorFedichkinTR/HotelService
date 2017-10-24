package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;
import com.epam.model.User;

import java.util.List;

public class UserOrdersService {
    private OrderDao orderDao;

    public UserOrdersService(AbstractDaoFactory daoFactory) {
        orderDao = daoFactory.createOrderDAO();
    }

    /**
     * Gets all orders of user from database
     *
     * @param user - logged in user from session
     * @return list of all user orders
     */
    public List<Order> getOrdersOfUser(User user) {
        return orderDao.getAllOrdersByUserID(user.getUserID());
    }
}
