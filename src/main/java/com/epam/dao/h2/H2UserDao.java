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
            "SELECT user_id, password, first_name, last_name, role FROM Users WHERE email = ?";
    private static final String CREATE_USER_SQL =
            "INSERT INTO USERS (email, password, first_name, last_name, role) VALUES (?,?,?,?,?)";
    private static final String READ_USER_BY_ID =
            "SELECT email, password, first_name, last_name, role FROM Users WHERE user_id = ?";

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
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setRole(Roles.valueOf(resultSet.getString("role")));
                user.seteMail(eMail);
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
        User user = new User();

        try(Connection connection = connectionPool.takeConnection();
        PreparedStatement statement = connection.prepareStatement(READ_USER_BY_ID)) {
            statement.setLong(1,id);
           try (ResultSet resultSet = statement.executeQuery()) {
               resultSet.next();
               user.setPassword(resultSet.getString("password"));
               user.seteMail(resultSet.getString("email"));
               user.setFirstName(resultSet.getString("first_name"));
               user.setLastName(resultSet.getString("last_name"));
               user.setRole(Roles.valueOf(resultSet.getString("role")));
               user.setUserID(id);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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
