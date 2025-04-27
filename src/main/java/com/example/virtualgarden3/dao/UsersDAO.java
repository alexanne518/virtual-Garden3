package com.example.virtualgarden3.dao;

import com.example.virtualgarden3.db.DbUtil;
import com.example.virtualgarden3.model.UserRegistration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsersDAO {

    public UserRegistration findUserByID(int userId) {
        Connection conn = null;

        try {
            conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE userId = ?");
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                return new UserRegistration(userId, name, password);
            }
            return null;
        } catch (SQLException e) {
            System.err.println("Error finding user: " + e.getMessage());
            return null;
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }

    public List<UserRegistration> findAllUsers() {
        List<UserRegistration> users = new ArrayList<>();
        Connection conn = null;

        try {
            conn = DbUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                int id = rs.getInt("userId");
                String name = rs.getString("name");
                String password = rs.getString("password");
                users.add(new UserRegistration(id, name, password));
            }
        } catch (SQLException e) {
            System.err.println("Error finding all users: " + e.getMessage());
        } finally {
            DbUtil.closeQuietly(conn);
        }
        return users;
    }


    public boolean saveUser(UserRegistration user) {
        Connection conn = null;
        try {
            conn = DbUtil.getConnection();

            //Check if user exists
            PreparedStatement checkStmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE userId = ?");
            checkStmt.setInt(1, user.getId());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            PreparedStatement stmt;
            if (count == 0) {
                stmt = conn.prepareStatement("INSERT INTO users (name, password) VALUES (?, ?)");
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getPassword());
            } else {
                // Update existing user
                stmt = conn.prepareStatement("UPDATE users SET name = ?, password = ? WHERE userId = ?");
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getPassword());
                stmt.setInt(3, user.getId());
            }
            int result = stmt.executeUpdate();
            return result > 0; // Return true if the operation was successful
        } catch (SQLException e) {
            System.err.println("Error saving user: " + e.getMessage());
            return false;
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }


    public UserRegistration checkUser(String name, String password) {
        Connection conn = null;
        try {
            conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM users WHERE name = ? AND password = ?"
            );
            stmt.setString(1, name);
            stmt.setString(2, password); // For production, use hashed password comparison

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("userId");
                String fullName = rs.getString("name");

                return new UserRegistration(userId, name, password);
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error fining user: " + e.getMessage());
            return null;
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }
}