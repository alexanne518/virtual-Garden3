package com.example.virtualgarden3.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.err;
import static java.lang.System.out;

public class SchemaInitializer {
    public static void main(String[] args) {
        initializeSchema();
    }

    public static void initializeSchema() {
        Connection conn = null;

        try{
            conn = DbUtil.getConnection();

            // Create tables
            Statement stmt = conn.createStatement();

            // Create users table
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS users (" +
                            "  userId INT AUTO_INCREMENT PRIMARY KEY, " +  // trying auto incrementation
                            "  name VARCHAR(50) NOT NULL, " +
                            "  password VARCHAR(50) NOT NULL " +
                            //"  plantType VARCHAR(50) NOT NULL" +  // Stores the plant type the user chose, idkwe should just store the plant type or eveyrthing like wahat water level it is at
                            ")"
            );
            out.println("Users table created.");

            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS plant (" +
                            "  plantId int PRIMARY KEY, " +
                            "  userId INT NOT NULL, " + //idk what to do about the FK
                            "  type VARCHAR(100) NOT NULL, " +
                            "  water VARCHAR(100) NOT NULL, " + //how much water it had the last time they were logged in? idk if we were ogin with % number or high low
                            "   CONSTRAINT fk_user FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE" +
                            ")"
            );
            System.out.println("Plant table created.");

            System.out.println("Database schema setup complete!");

        }catch(SQLException e){
            err.println("Error setting up database: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            DbUtil.closeQuietly(conn);
        }
    }
}

