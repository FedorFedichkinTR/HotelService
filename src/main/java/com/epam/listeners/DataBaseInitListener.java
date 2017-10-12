package com.epam.listeners;

import com.epam.connection_pool.ConnectionPool;
import com.epam.connection_pool.ConnectionPoolException;
import com.epam.constants.Constants;
import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.h2.H2DaoFactory;
import com.epam.services.*;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.sql.SQLException;

@Log4j
@WebListener
public class DataBaseInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) throws ConnectionPoolException {
        ServletContext servletContext = servletContextEvent.getServletContext();

        String pathToDbConfig = servletContext.getRealPath("/") + "WEB-INF\\classes\\";
        ConnectionPool.create(pathToDbConfig + "db.properties");
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.initPoolData();

        try {
            connectionPool.executeScript(pathToDbConfig + "/sql/tablecreation.sql");
            log.info("DataBase tables were created successfully!");
        } catch (SQLException e) {
            log.error("SQL creation exception: " + e);
        } catch (IOException e) {
            log.error("Input/Output exception: " + e);
        }

        AbstractDaoFactory abstractDaoFactory = new H2DaoFactory(connectionPool);

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
