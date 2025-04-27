package com.example.virtualgarden3.controller;

import com.example.virtualgarden3.db.DbUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = DbUtil.getConnection();

            String query = "SELECT * FROM users WHERE name = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if(rs.next()){
                HttpSession session = request.getSession();
                session.setAttribute("userId", rs.getString("userId"));
                session.setAttribute("username", rs.getString("name"));

                session.setAttribute("user", "authenticated"); //to be able to chekc that thers a user logged in

                //response.sendRedirect(request.getContextPath() + "/home"); //TODO:redirect to plant selection
                response.sendRedirect("PlantSelection.jsp");

            }
            else{
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
        finally {
            DbUtil.closeQuietly(conn);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("doGet testttttt");

        request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }
}
