package io.swagger.api.driver;

import io.swagger.api.ConnectionManager;
import io.swagger.model.Driver;
import io.swagger.model.Drivers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Driver_PE {
    private static final String SELECT_ALL_DRIVERS = "SELECT * FROM TARIF_ENT.DRIVER";
    private static String SELECT_DRIVER_BY_ID = "SELECT * FROM TARIF_ENT.DRIVER WHERE driverID = %d";

    public static Driver getDriverByID(Integer driverID) {
        Driver result = null;
        String query = String.format(SELECT_DRIVER_BY_ID, driverID);
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = ConnectionManager.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                result = new Driver();
                result.setDriverID(rs.getInt(1));
                result.setFirstName(rs.getString(2));
                result.setLastName(rs.getString(3));
                result.setMiddleName(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Drivers getAllDrivers() {
        Drivers result = null;
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = ConnectionManager.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_DRIVERS);
            result = new Drivers();
            while (rs.next()) {
                Driver driver = new Driver();
                driver.setDriverID(rs.getInt(1));
                driver.setFirstName(rs.getString(2));
                driver.setLastName(rs.getString(3));
                driver.setMiddleName(rs.getString(4));
                result.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
