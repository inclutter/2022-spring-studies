package com.inclutter.springquickstart.core.configuration;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class JDBCConnectionManager {
    private String driverClass;
    private String url;
    private String username;
    private String password;

    public Connection getConnection() {
        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
