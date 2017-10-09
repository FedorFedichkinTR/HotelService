package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.UserDao;
import com.epam.mappers.UserMapper;
import com.epam.model.User;
import com.epam.model.Roles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2UserDao implements UserDao {
    private final ConnectionPool connectionPool;

    private static final String CREATE_USER_SQL =
            "INSERT INTO Users (email, password, first_name, last_name, role) VALUES (?,?,?,?,?)";
    private static final String SELECT_USER_BY_EMAIL_SQL =
            "SELECT user_id, password, first_name, last_name, role FROM Users WHERE email = ?";
    private static final String SELECT_USER_BY_ID_SQL =
            "SELECT email, password, first_name, last_name, role FROM Users WHERE user_id = ?";
    private static final String UPDATE_USER_SQL =
            "UPDATE Users SET email = ?, password = ?, first_name = ?, last_name = ?, role = ? WHERE user_id = ?";
    private static final String DELETE_USER_SQL =
            "DELETE FROM Users WHERE user_id = ?";
    private static final String GET_ALL_USERS_SQL =
            "SELECT user_id, first_name, last_name FROM Users";

    private final UserMapper userMapper = new UserMapper();

    public H2UserDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Long create(User insertedUser) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, insertedUser.getEmail());
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
        return null;
    }

    @Override
    public User readByEmail(String eMail) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_EMAIL_SQL)) {
            statement.setString(1, eMail);

            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                return userMapper.map(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User read(Long id) {
        User user = new User();

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID_SQL)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setRole(Roles.valueOf(resultSet.getString("role")));
                user.setUserID(id);
                //todo
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Boolean update(User user) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getRole().toString());
            statement.setLong(6, user.getUserID());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Long deleteById(Long id) {
        return delete(id, connectionPool, DELETE_USER_SQL);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS_SQL)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final User user = new User();
                    user.setUserID(resultSet.getLong("user_id"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setLastName(resultSet.getString("last_name"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
