package listeners;

import connection_pool.ConnectionPool;
import connection_pool.ConnectionPoolException;
import dao.AbstractDaoFactory;
import dao.RelationDao;
import dao.UserDao;
import dao.h2.H2DaoFactory;
import dao.h2.RelationDaoImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import javax.servlet.annotation.WebListener;

import static constants.Constants.*;

@WebListener
public class DataBaseInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String pathToDbConfig = servletContext.getRealPath("/") + "WEB-INF/classes";
        ConnectionPool.create(pathToDbConfig + "db.properties");
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
        connectionPool.initPoolData();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }

//        connectionPool.executeScript(pathToDbConfig + "H2Init.sql");
//        connectionPool.executeScript(pathToDbConfig + "usersH2Init.sql");

        AbstractDaoFactory abstractDaoFactory = new H2DaoFactory();

        UserDao userDao = abstractDaoFactory.createUserDao(connectionPool);
        RelationDao relationDao = new RelationDaoImpl();
        servletContext.setAttribute(USER_DAO, userDao);
        servletContext.setAttribute(RELATION_DAO, userDao);
        servletContext.setAttribute(USER_SERVICE, userDao);
    }
}
