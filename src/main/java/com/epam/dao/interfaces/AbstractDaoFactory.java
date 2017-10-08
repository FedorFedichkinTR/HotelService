package com.epam.dao.interfaces;

interface AbstractDaoFactory extends AutoCloseable {
    UserDao createUserDAO();

    OrderDao createOrderDAO();

    RoomDao createRoomDAO();

    BillDao createBillDAO();
}
