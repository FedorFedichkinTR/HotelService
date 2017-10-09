package com.epam.dao.interfaces;

import com.epam.model.Room;
import com.epam.model.RoomType;

import java.util.List;

public interface RoomDao extends CrudDao<Room,Long> {
    public List<Room> getAllRooms();

    public List<Room> getRoomsWithProperties(Integer roomCapacity, RoomType roomType);
}
