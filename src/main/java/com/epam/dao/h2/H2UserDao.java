package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.UserDao;
import com.epam.model.User;
import com.epam.model.Roles;

import java.sql.*;
import java.util.List;

public class H2UserDao implements UserDao {
    private final ConnectionPool connectionPool;

    private static final String SELECT_USER_BY_EMAIL_SQL =
            "SELECT user_id, password, first_name, last_name, role from USERS WHERE email = ?";
    private static final String CREATE_USER_SQL =
            "INSERT INTO USERS (email, password, first_name, last_name, role) VALUES (?,?,?,?,?)";

    public H2UserDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
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
    public Long create(User insertedUser) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, insertedUser.geteMail());
            statement.setString(2, insertedUser.getPassword());
            statement.setString(3, insertedUser.getFirstName());
            statement.setString(4, insertedUser.getLastName());
            statement.setString(5, insertedUser.getRole().toString());
            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public Long update(User entity) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
