package com.example.virtualgarden3.controller;

import com.example.virtualgarden3.model.UserRegistration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        UserRegistration newUser = new UserRegistration(0, name, password);
        System.out.println(newUser);
        boolean success = false;

        if (success) {
            response.sendRedirect("Login"); // After sign up, redirecting to login so the user can conti
        } else {
            request.setAttribute("error", "sign up failed");
            request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
        }
    }
}