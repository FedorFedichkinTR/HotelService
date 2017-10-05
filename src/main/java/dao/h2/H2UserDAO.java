package dao.h2;

import connection_pool.ConnectionPool;
import dao.interfaces.UserDAO;
import model.User;

import java.util.List;

public class H2UserDAO implements UserDAO{
    private final ConnectionPool connectionPool;

    public H2UserDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public User read(long reaUserID) {
        return null;
    }

    @Override
    public User read(String eMail) {
        return null;
    }

    @Override
    public User update(User updatedUser) {
        return null;
    }

    @Override
    public void delete(User deletedUser) {

    }

    @Override
    public void insert(User insertedUser) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
