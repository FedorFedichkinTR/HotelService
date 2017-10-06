package com.epam.dao.interfaces;

import com.epam.model.Room;

import java.util.List;

public interface RoomDao extends CrudDao<Room,Long> {
    public List<Room> getAllRooms();
}
