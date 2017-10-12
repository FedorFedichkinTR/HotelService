package com.epam.dao.h2;

import javax.sql.DataSource;
import com.epam.dao.interfaces.*;
import lombok.extern.log4j.Log4j;

@Log4j
public class H2DaoFactory implements AbstractDaoFactory {
    private final UserDao userDao;
    private final OrderDao orderDao;
    private final RoomDao roomDao;

    public H2DaoFactory(DataSource dataSource) {
        log.info("DataSource from H2DaoFactory: " + dataSource);
        this.userDao = new H2UserDao(dataSource);
        this.orderDao = new H2OrderDao(dataSource);
        this.roomDao = new H2RoomDao(dataSource);
    }

    @Override
    public UserDao createUserDAO() {
        return userDao;
    }

    @Override
    public OrderDao createOrderDAO() {
        return orderDao;
    }

    @Override
    public RoomDao createRoomDAO() {
        return roomDao;
    }

    @Override
    //TODO implementation??
    public void close() throws Exception {

    }
}
