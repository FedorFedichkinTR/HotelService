package com.epam.dao;

import com.epam.connection_pool.ConnectionPool;

public interface AbstractDaoFactory {
    UserDao createUserDao(ConnectionPool connectionPool);
}
