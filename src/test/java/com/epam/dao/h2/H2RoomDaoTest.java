package com.epam.dao.h2;


import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.RoomDao;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class H2RoomDaoTest {
    private static RoomDao roomDao;

    public static void setup() throws IOException, SQLException {
        ConnectionPool.create("src/main/resources/db.properties");
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.initPoolData();
        pool.executeScript("src/main/resources/sql/tablecreation.sql");
        AbstractDaoFactory daoFactory = new H2DaoFactory(pool);
        roomDao = daoFactory.createRoomDAO();
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void read() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void getAllRooms() throws Exception {
    }

    @Test
    public void builder() throws Exception {
    }
}
