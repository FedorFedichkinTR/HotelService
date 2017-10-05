package dao.h2;

import connection_pool.ConnectionPool;
import dao.interfaces.UserDAO;
import model.User;

import java.util.List;

public class H2UserDAO implements UserDAO{
    private final ConnectionPool connectionPool;

    private static final String SELECT_USER_BY_EMAIL_SQL =
            "SELECT user_id, password, first_name, last_name, role from USERS WHERE email = ?";
    private static final String CREATE_USER_SQL =
            "INSERT INTO USERS VALUES(email, password, first_name, last_name, role) WHERE (?,?,?,?,?)";

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
