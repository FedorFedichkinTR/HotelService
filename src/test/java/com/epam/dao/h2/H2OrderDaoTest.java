package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;
import com.epam.model.RoomType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class H2OrderDaoTest {
    private static OrderDao orderDAO;

    @BeforeClass
    //todo refactoring
    public static void setup() throws IOException, SQLException {
        ConnectionPool.create("src/test/resources/db.properties");
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.initPoolData();
        pool.executeScript("src/test/resources/sql/tablecreation.sql");
        AbstractDaoFactory daoFactory = new H2DaoFactory(pool);
        orderDAO = daoFactory.createOrderDAO();
    }

    @Test
    public void create() throws Exception {
        Order order = Order.builder()
                .endDate(LocalDate.now().plusDays(1))
                .roomCapacity(2)
                .roomType(RoomType.STANDARD)
                .startDate(LocalDate.now())
                .userID(3L)
                .roomID(0L)
                .adminID(0L)
                .price(0)
                .status(false)
                .build();

        Long aLong = orderDAO.create(order);
        Order orderFromDB = orderDAO.read(aLong);
        order.setOrderID(aLong);

        assertEquals(order, orderFromDB);
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
    public void getAllOrders() throws Exception {

    }

    @Test
    public void getAllOrdersByUserID() throws Exception {

        List<Order> orders = orderDAO.getAllOrdersByUserID(3L);

        assertEquals(2, orders.size());
    }
}
