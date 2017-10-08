package com.epam.dao.interfaces;

import com.epam.model.Room;

import java.util.List;

interface RoomDao extends CrudDao<Room,Long> {
    public List<Room> getAllRooms();
}
