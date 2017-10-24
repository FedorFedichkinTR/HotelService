package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Order;
import com.epam.model.Room;

import java.util.List;

/**
 * Contains handlers of admin functions: set an empty room to new order.
 */
public class AdminService {
    private AbstractDaoFactory daoFactory;

    public AdminService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * Finds a list of free rooms, if assigning room is in this list, evaluetes price for this order,
     * updates order to set roomId, price and adminId.
     *
     * @param roomId
     * @param orderId
     * @param adminId
     * @return id of assigned room
     */
    public Long getARoom(Long roomId, Long orderId, Long adminId) {
        OrderDao orderDao = daoFactory.createOrderDAO();
        RoomDao roomDao = daoFactory.createRoomDAO();
        Order orderToConfirm = orderDao.read(orderId);
        List<Room> freeRooms = roomDao.getFreeRooms(orderToConfirm);
        if (freeRooms.contains(roomDao.read(roomId))) {
            Long duration = orderToConfirm.getEndDate().toEpochDay() - orderToConfirm.getStartDate().toEpochDay();
            Integer roomPrice = roomDao.read(roomId).getPrice() * duration.intValue();
            orderToConfirm.setPrice(roomPrice);
            orderToConfirm.setRoomID(roomId);
            orderToConfirm.setAdminID(adminId);
            if (orderDao.update(orderToConfirm)) {
                return roomId;
            }
        }
        return null;
    }
}
