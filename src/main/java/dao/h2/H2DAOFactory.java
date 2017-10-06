package dao.h2;

import connection_pool.ConnectionPool;
import dao.AbstractDaoFactory;
import dao.UserDao;

public class H2DAOFactory implements AbstractDaoFactory {
    public H2DAOFactory() {

    }

    @Override
    public UserDao createUserDao(ConnectionPool connectionPool) {
        return null;
    }
}
