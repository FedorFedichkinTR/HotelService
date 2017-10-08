package com.epam.dao.interfaces;

import com.epam.connection_pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

interface CrudDao<E,K> {
    Long create(E entity);

    E read(K id);

    Long update(E entity);

    Long deleteById(K id);

   //TODO understand if this allowed to do?
    default Long delete(Long id, ConnectionPool connectionPool, String command) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(command)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
