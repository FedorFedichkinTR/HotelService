package com.epam.dao.h2;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.OrderDao;
import com.epam.model.Order;
import com.epam.model.RoomType;
import lombok.extern.log4j.Log4j;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@Log4j
public class H2OrderDaoTest {
    private static OrderDao orderDAO;

    @Resource(name = "jdbc/HotelService")
    private static DataSource dataSource;

    @BeforeClass
    //todo refactoring
    public static void setup() throws IOException, SQLException, NamingException {
        dataSource = JdbcConnectionPool.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "", "");

        Path sqlPath = Paths.get("D:\\Tomcat\\apache-tomcat-9.0.0.M4\\webapps\\ROOT\\WEB-INF\\classes\\sql");
        Pattern pattern = Pattern.compile(".*\\.sql");
        log.info(sqlPath);
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            DirectoryStream<Path> paths = Files.newDirectoryStream(sqlPath);
            for (Path filePath : paths) {
                if (pattern.matcher(filePath.toFile().getName()).find()) {
                    statement.addBatch(
                            Files.lines(filePath)
                                    .collect(Collectors.joining())
                    );
                }
            }
            statement.executeBatch();
        } catch (SQLException e) {
            log.error("SQLException during database initialisation: " + e);
            e.printStackTrace();
        } catch (IOException e) {
            log.error("IOException during accessing sql script file: " + e);
            e.printStackTrace();
        }

        log.info("DataSource from H2OrderDaoTest setup method: " + dataSource);
        AbstractDaoFactory daoFactory = new H2DaoFactory(dataSource);
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
