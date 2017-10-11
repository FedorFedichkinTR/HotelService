package com.epam.dao.h2;


import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Room;
import com.epam.model.RoomType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class H2RoomDaoTest {
    private static RoomDao roomDao;

    @BeforeClass
    public static void setup() throws IOException, SQLException {
        ConnectionPool.create("src/main/resources/db.properties");
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.initPoolData();
        pool.executeScript("src/main/resources/sql/tablecreation.sql");
        AbstractDaoFactory daoFactory = new H2DaoFactory(pool);
        roomDao = daoFactory.createRoomDAO();
    }

    @Test
    public void getRoomsWithProperties() throws Exception {
    }

    @Test
    public void create() throws Exception {
        Room room = Room.builder().roomCapacity(1).roomType(RoomType.STANDARD).price(200).build();

        Long roomID = roomDao.create(room);
        Room roomFromDB = roomDao.read(roomID);

        assertEquals(roomID,roomFromDB.getRoomId());
    }

    @Test
    public void read() throws Exception {
        Room room = Room.builder().roomCapacity(1).roomType(RoomType.STANDARD).price(200).build();
        Long roomId = roomDao.create(room);

        Room room1 = roomDao.read(roomId);

        assertEquals(room.getRoomType().toString(), room1.getRoomType().toString());
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
}
