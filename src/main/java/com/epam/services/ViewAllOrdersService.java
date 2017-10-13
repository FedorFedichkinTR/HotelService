package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Order;
import com.epam.model.Room;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Long> listOfFreeRooms = roomDao.getFreeRooms(order).stream().map(Room::getRoomId).collect(Collectors.toList());
        return listOfFreeRooms;
    }
}
