package com.example.virtualgarden3.controller;

import com.example.virtualgarden3.db.ApplicationData;
import com.example.virtualgarden3.model.Account;
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

    /**
     * gets the user and password from the login form checks if the user is null to begin with becuase if thats true theres no need
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = ApplicationData.getInstance().tryAuthenticate(username, password);
        if (account != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", account);
            request.getRequestDispatcher("/menu.jsp").forward(request, response);

        }
        else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }
}
