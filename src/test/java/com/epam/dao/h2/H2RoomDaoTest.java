package com.epam.dao.h2;


import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Order;
import com.epam.model.Room;
import com.epam.model.RoomType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class H2RoomDaoTest {
    private static RoomDao roomDao;

    @BeforeClass
    //todo refactoring
    public static void setup() throws IOException, SQLException {
        ConnectionPool.create("src/test/resources/dbTest.properties");
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.initPoolData();
        pool.executeScript("src/test/resources/sql/testTables.sql");
        AbstractDaoFactory daoFactory = new H2DaoFactory(pool);
        roomDao = daoFactory.createRoomDAO();
    }

    @Test
    public void getRoomsWithProperties() throws Exception {
        Order currentOrder = Order.builder().startDate(LocalDate.of(2004,10,27))
                .endDate(LocalDate.of(2004,10,30))
                .roomCapacity(3)
                .roomType(RoomType.STANDARD)
                .userID(1L)
                .build();

        List<Room> roomList = roomDao.getRoomsWithProperties(currentOrder);

        assertEquals(5,roomList.size());
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
    //todo
    public void update() throws Exception {
    }

    @Test
    //todo
    public void deleteById() throws Exception {
    }

    @Test
    public void getAllRooms() throws Exception {
        List<Room> rooms = roomDao.getAllRooms();

        assertEquals(5,rooms.size());
    }

    @Test
    public void getFreeRooms() throws Exception {
      //todo
        Order order = Order.builder()
                .startDate(LocalDate.of(2004,10,27))
                .endDate(LocalDate.of(2004,10,30))
                .roomCapacity(3)
                .roomType(RoomType.STANDARD)
                .build();

        List<Room> freeRooms = roomDao.getFreeRooms(order);

        assertEquals(4,freeRooms.size());
    }

}
