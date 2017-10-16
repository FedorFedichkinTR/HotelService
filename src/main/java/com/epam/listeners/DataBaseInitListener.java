package com.epam.listeners;

import com.epam.constants.Constants;
import com.epam.dao.h2.H2DaoFactory;
import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.services.*;
import lombok.extern.log4j.Log4j;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Log4j
@WebListener
public class DataBaseInitListener implements ServletContextListener {

    @Resource(name = "jdbc/HotelService")
    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Path sqlPath = Paths.get(servletContext.getRealPath("/WEB-INF/classes/sql"));
        Pattern pattern = Pattern.compile(".*\\.sql");
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

        AbstractDaoFactory abstractDaoFactory = new H2DaoFactory(dataSource);

        AuthorisationService authorisation = new AuthorisationService(abstractDaoFactory);
        RegistrationService registration = new RegistrationService(abstractDaoFactory);
        BookingService booking = new BookingService(abstractDaoFactory);
        UserOrdersService viewUserOrders = new UserOrdersService(abstractDaoFactory);
        ViewAllOrdersService viewAllOrders = new ViewAllOrdersService(abstractDaoFactory);
        AdminService adminService = new AdminService(abstractDaoFactory);
        ChangeUserOrderService changeUserOrderService = new ChangeUserOrderService(abstractDaoFactory);

        servletContext.setAttribute(Constants.AUTHORISATION_SERVICE, authorisation);
        servletContext.setAttribute(Constants.REGISTRATION_SERVICE, registration);
        servletContext.setAttribute(Constants.BOOKING_SERVICE, booking);
        servletContext.setAttribute(Constants.USER_ORDERS_SERVICE, viewUserOrders);
        servletContext.setAttribute(Constants.VIEW_ALL_ORDERS_SERVICE, viewAllOrders);
        servletContext.setAttribute(Constants.ADMIN_SERVICE, adminService);
        servletContext.setAttribute(Constants.CHANGE_USER_ORDER_SERVICE, changeUserOrderService);
    }
}
