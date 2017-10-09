package com.epam.listeners;

import com.epam.connection_pool.ConnectionPool;
import com.epam.connection_pool.ConnectionPoolException;
import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.h2.H2DaoFactory;
import com.epam.model.User;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

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

        List<User> users = abstractDaoFactory.createUserDAO().getAllUsers();

//        UserService userService = new UserService (abstractDaoFactory)

//        put every service to ServletContext:
//        servletContext.setAttribute("keyForUserService", userService);
    }
}
