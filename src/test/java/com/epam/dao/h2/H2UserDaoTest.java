package com.epam.dao.h2;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.UserDao;
import lombok.extern.log4j.Log4j;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.BeforeClass;
import org.junit.Test;

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
public class H2UserDaoTest {
    private static UserDao userDAO;

    private static DataSource dataSource;

    @BeforeClass
    //todo refactoring
    public static void setup() throws IOException, SQLException {
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
