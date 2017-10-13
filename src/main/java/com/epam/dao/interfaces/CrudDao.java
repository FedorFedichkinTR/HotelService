package com.epam.dao.interfaces;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

interface CrudDao<E, K> {
    Long create(E entity);

    E read(K id);

    Boolean update(E entity);

    Long deleteById(K id);

    default Long delete(Long id, DataSource dataSource, String sqlDeleteQuery) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlDeleteQuery)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
