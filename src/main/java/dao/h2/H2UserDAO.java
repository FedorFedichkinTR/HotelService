package dao.h2;

import connection_pool.ConnectionPool;
import dao.interfaces.UserDAO;
import model.User;
import model.enums.Roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class H2UserDAO implements UserDAO {
    private final ConnectionPool connectionPool;

    private static final String SELECT_USER_BY_EMAIL_SQL =
            "SELECT user_id, password, first_name, last_name, role from USERS WHERE email = ?";
    private static final String CREATE_USER_SQL =
            "INSERT INTO USERS VALUES(email, password, first_name, last_name, role) WHERE (?,?,?,?,?)";

    public H2UserDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public User readByID(long reaUserID) {
        return null;
    }

    @Override
    public User readByEmail(String eMail) {
        User user = new User();

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_EMAIL_SQL)) {
            statement.setString(1, eMail);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                user.setUserID(resultSet.getLong("user_id"));
                user.setPassword("password");
                user.setFirstName("first_name");
                user.setLastName("last_name");
                user.setRole(Roles.valueOf(resultSet.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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
