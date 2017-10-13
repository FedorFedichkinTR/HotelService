package com.epam.dao.interfaces;

import com.epam.model.Order;
import com.epam.model.Room;

import java.util.List;

public interface RoomDao extends CrudDao<Room, Long> {
    public List<Room> getAllRooms();

    public List<Room> getRoomsWithProperties(Order order);

    public List<Room> getFreeRooms(Order order);
}
