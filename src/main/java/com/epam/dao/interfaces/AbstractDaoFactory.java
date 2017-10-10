package com.epam.dao.interfaces;

public interface AbstractDaoFactory extends AutoCloseable {
    UserDao createUserDAO();

    OrderDao createOrderDAO();

    RoomDao createRoomDAO();
}
