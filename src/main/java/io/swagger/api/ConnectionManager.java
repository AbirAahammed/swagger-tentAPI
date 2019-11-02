package io.swagger.api;

import io.swagger.propertyLoader.LoadProperties;
import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static BasicDataSource ds = new BasicDataSource();
    private static final String DB_PROPERTY_FILENAME = "db";
    private static final Properties dbProperties = LoadProperties.loadProperties(DB_PROPERTY_FILENAME);
    static {
//        ds.setUrl("jdbc:mysql://50.71.81.231:3306/TARIF_ENT");
        ds.setUrl(dbProperties.getProperty("db.url"));
//        ds.setUsername("abir-ext");
        ds.setUsername(dbProperties.getProperty("db.user"));
//        ds.setPassword("1U1M675}DlB2@yf");
        ds.setPassword(dbProperties.getProperty("db.password"));
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
