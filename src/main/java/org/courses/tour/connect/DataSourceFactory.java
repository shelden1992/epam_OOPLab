package org.courses.tour.connect;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static java.util.Objects.nonNull;
import static org.courses.tour.constant.AppConstants.*;

public class DataSourceFactory {
    private static final Logger LOG = Logger.getLogger(DataSourceFactory.class);
    private static final DataSourceFactory INSTANCE = new DataSourceFactory();

    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DataSourceFactory.class.getResourceAsStream(DB_PROPERTIES));
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setPassword(properties.getProperty(DB_PASSWORD));
            mysqlDataSource.setUser(properties.getProperty(DB_USERNAME));
            mysqlDataSource.setUrl(properties.getProperty(DB_URL));
            mysqlDataSource.setCharacterEncoding(properties.getProperty(DB_CHARACTER_ENCODING));
            dataSource = mysqlDataSource;

        } catch (IOException e) {
            LOG.error("Properties not load ", e);
        } catch (SQLException e) {
            LOG.error("Exception while set charset enconding", e);
        }
    }

    private DataSourceFactory() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            if (nonNull(dataSource)) {
                connection = dataSource.getConnection();
            } else
                throw new IOException("DataSource null");
        } catch (SQLException | IOException e) {
            LOG.error("Exception connection create ", e);
        }
        return connection;

    }

    public static PreparedStatement getPreparedStatement(String query) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(query);
        } catch (SQLException e) {
            LOG.error("Exception while created PreparedStatement", e);
        }
        return preparedStatement;

    }


}
