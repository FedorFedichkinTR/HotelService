package dao;


import connection_pool.ConnectionPool;

public interface AbstractDaoFactory {
    UserDao createUserDao(ConnectionPool connectionPool);
}
