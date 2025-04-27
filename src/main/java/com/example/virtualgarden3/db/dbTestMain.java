package com.example.virtualgarden3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.out;

public class dbTestMain {
    public static void main(String[] args) {

        //inserting a test user
        Connection conn = null;

        try{
            conn = DbUtil.getConnection();

            PreparedStatement checksStmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE userId = 1");
            ResultSet rs = checksStmt.executeQuery();
            rs.next();

            int count = rs.getInt(1);

            if(count == 0){
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, password) VALUES (?, ?)");

                stmt.setString(1, "sa");
                stmt.setString(2, "sa");
                stmt.executeUpdate();

                out.println("test user inserted");
            }
            else{
                out.println("test user already exists");
            }
        }catch(SQLException e){
            out.println("Error inserting test user: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            DbUtil.closeQuietly(conn);
        }

        try{
            conn = DbUtil.getConnection();

            PreparedStatement checksStmt = conn.prepareStatement("SELECT * FROM users WHERE name = 'sa' ");
            ResultSet rs = checksStmt.executeQuery();

            if (rs.next()){
                String name = rs.getString("name");
                String password = rs.getString("password");

                out.println("user found: "+name+", "+password);
            }
            else{
                out.println("user not found");
            }

        }catch(SQLException e){
            out.println("Error verifying test user: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            DbUtil.closeQuietly(conn);
        }
    }
}
