package com.epam.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AbstractMapper<T> {
    T map(final ResultSet rs) throws SQLException;
}
