package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Order;

import java.util.List;

public class ViewAllOrdersService {
    private AbstractDaoFactory daoFactory;

    public ViewAllOrdersService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Order> getAllOrders() {
        return daoFactory.createOrderDAO().getAllOrders();
    }

    public List<Long> getFreeRooms(Order order) {
        RoomDao roomDao = daoFactory.createRoomDAO();
        List<Long> listOfFreeRooms = roomDao.getFreeRooms(order);
        return listOfFreeRooms;
    }
}
