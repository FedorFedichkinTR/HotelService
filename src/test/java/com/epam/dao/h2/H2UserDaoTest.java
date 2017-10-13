package com.epam.dao.h2;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.UserDao;
import lombok.extern.log4j.Log4j;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.regex.Pattern;

import static com.epam.dao.h2.SetupSQL.initConnection;

@Log4j
public class H2UserDaoTest {
    private static UserDao userDAO;
    private static AbstractDaoFactory daoFactory = new H2DaoFactory(SetupSQL.getDataSource());

    @BeforeClass
    //todo refactoring
    public static void setup() throws IOException, SQLException, NamingException {
        initConnection();
        userDAO = daoFactory.createUserDAO();
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void readByEmail() throws Exception {
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
    public void getAllUsers() throws Exception {
    }
}
