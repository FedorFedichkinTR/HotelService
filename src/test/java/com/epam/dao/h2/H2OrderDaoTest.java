package com.epam.dao.h2;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;
import com.epam.model.RoomType;
import lombok.extern.log4j.Log4j;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static com.epam.dao.h2.SetupSQL.initConnection;
import static org.junit.Assert.assertEquals;

@Log4j
public class H2OrderDaoTest {
    private static OrderDao orderDAO;
    private static AbstractDaoFactory daoFactory = new H2DaoFactory(SetupSQL.getDataSource());

    @BeforeClass
    //todo refactoring
    public static void setup() throws IOException, SQLException, NamingException {
        initConnection();
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
        List<Order> orders = orderDAO.getAllOrdersByUserID(1L);

        assertEquals(3, orders.size());
    }
}
