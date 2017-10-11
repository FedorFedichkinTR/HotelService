package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Order;
import com.epam.model.Room;

import java.util.List;

public class AdminService {
    private AbstractDaoFactory daoFactory;

    public AdminService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Long getARoom(Long roomId, Long orderId){
        OrderDao orderDao = daoFactory.createOrderDAO();
        orderDao.read(orderId);
        return roomId;
    }
/*     public Long findEmptyRoom(Order order) {
       RoomDao roomDao = daoFactory.createRoomDAO();
        OrderDao orderDao = daoFactory.createOrderDAO();
        List<Room> listOfSuitableRooms = roomDao.getAllRoomsByParameters();

        for (Room room : listOfSuitableRooms) {
            boolean isAvailable=false;
             List<BusyRoom> roomDates = orderDao.getAllBusyDatesByRoomId(room.getRoomId());
            for (BusyRoom busyRoom: roomDates) {
                if(order.getStartDate().isAfter(busyRoom.getEndDate()) || order.getEndDate().isBefore(busyRoom.getStartDate())){
                    isAvailable = true;
                } else {
                    isAvailable = false;
                }
            }
            if(isAvailable){
                return room.getRoomId();
            }
        }
        return null;
    }*/

}
