package io.swagger.api.company;

import io.swagger.api.ConnectionManager;
import io.swagger.model.Companies;
import io.swagger.model.Company;
import io.swagger.model.Driver;
import io.swagger.model.Drivers;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Company_PE {
    private static final String SELECT_ALL_DRIVERS = "SELECT * FROM TARIF_ENT.COMPANY";
    private static String SELECT_DRIVER_BY_ID = "SELECT * FROM TARIF_ENT.COMPANY WHERE companyID = %d";
    public static Company getCompanyByID(Integer driverID) {
        Company result = null;
        String query = String.format(SELECT_DRIVER_BY_ID, driverID);
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = ConnectionManager.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                result = new Company();
                result.setCompanyID(rs.getInt(1));
                result.setCompanyName(rs.getString(2));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Companies getAllCompanies() {
        Companies result = null;
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = ConnectionManager.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_DRIVERS);
            result = new Companies();
            while (rs.next()) {
                Company company = new Company();
                company.setCompanyID(rs.getInt(1));
                company.setCompanyName(rs.getString(2));
                result.add(company);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
