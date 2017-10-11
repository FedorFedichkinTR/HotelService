package com.epam.mappers;

import com.epam.model.Role;
import com.epam.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements AbstractMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        final User user = new User();

        user.setUserID(resultSet.getLong("user_id"));
        user.setPassword(resultSet.getString("password"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setRole(Role.valueOf(resultSet.getString("role")));
        user.setEmail(resultSet.getString("email"));

        return user;
    }
}
