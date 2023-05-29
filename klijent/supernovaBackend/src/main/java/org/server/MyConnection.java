package org.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/LatinoAmerika";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "VesnaMima1!2@";


    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Use the connection for database operations

}
