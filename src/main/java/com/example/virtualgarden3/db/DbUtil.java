package com.example.virtualgarden3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    // JDBC URL for H2 database - creates/uses a file in user home directory
    private static final String JDBC_URL = "jdbc:h2:~/plantsDB14;DB_CLOSE_DELAY=-1"; //plantDB is the name of the data base
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    // Static block to load the JDBC driver
    static { //put static to avoid creating a new object and creating a constructor with this inside
        try {
            Class.forName("org.h2.Driver");
            System.out.println("H2 JDBC driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("H2 JDBC Driver not found!");
            e.printStackTrace();
        }
    }

    /**
     * Get a database connection
     *
     * @return a new database connection
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException { //when using thids function u need to use a try catch because of the throw exception
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    /**
     * Close a connection quietly (without throwing exceptions)
     *
     * @param connection the connection to close
     */
    public static void closeQuietly(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}