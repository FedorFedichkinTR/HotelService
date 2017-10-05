package dao.h2;

import connection_pool.ConnectionPool;
import dao.AbstractDaoFactory;
import dao.UserDao;

public class H2DaoFactory implements AbstractDaoFactory {
    public H2DaoFactory() {

    }

    @Override
    public UserDao createUserDao(ConnectionPool connectionPool) {
        return null;
    }
}
