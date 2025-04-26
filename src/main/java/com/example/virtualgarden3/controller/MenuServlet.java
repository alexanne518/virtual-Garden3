package com.example.virtualgarden3.controller;

import com.example.virtualgarden3.model.AfricanViolet;
import com.example.virtualgarden3.model.Plant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/menu")
public class MenuServlet  extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("menu initialized");
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }



}
