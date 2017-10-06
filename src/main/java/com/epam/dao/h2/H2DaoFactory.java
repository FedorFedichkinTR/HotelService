package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.AbstractDaoFactory;
import com.epam.dao.UserDao;

public class H2DaoFactory implements AbstractDaoFactory {
    public H2DaoFactory() {

    }

    @Override
    public UserDao createUserDao(ConnectionPool connectionPool) {
        return null;
    }
}
