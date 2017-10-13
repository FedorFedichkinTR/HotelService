package com.epam.dao.h2;


import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.RoomDao;
import com.epam.model.Order;
import com.epam.model.Room;
import com.epam.model.RoomType;
import lombok.extern.log4j.Log4j;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import static com.epam.dao.h2.SetupSQL.initConnection;
import static org.junit.Assert.*;

@Log4j
public class H2RoomDaoTest {
    private static RoomDao roomDao;
    private static DataSource dataSource;

    @BeforeClass
    //todo refactoring
    public static void setup() throws IOException, SQLException {
        dataSource = JdbcConnectionPool.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "", "");
        initConnection(dataSource);

        log.info("DataSource from H2OrderDaoTest setup method: " + dataSource);
        AbstractDaoFactory daoFactory = new H2DaoFactory(dataSource);
        roomDao = daoFactory.createRoomDAO();
    }

    @Test
    public void getRoomsWithProperties() throws Exception {
        Order order = Order.builder()
                .endDate(LocalDate.of(2004,10,27))
                .startDate(LocalDate.of(2004,10,30))
                .roomCapacity(3)
                .roomType(RoomType.STANDARD)
                .userID(1L)
                .roomID(3L)
                .price(200)
                .build();

        List<Room> roomList = roomDao.getRoomsWithProperties(order);

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

        assertEquals(9,rooms.size());
    }

    @Test
    public void getFreeRooms() throws Exception {
      //todo
    }

}
