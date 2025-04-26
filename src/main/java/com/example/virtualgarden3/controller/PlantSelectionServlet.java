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

@WebServlet("/PlantSelection")
public class PlantSelectionServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PlantSelection initialized");
        request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
    }
}
