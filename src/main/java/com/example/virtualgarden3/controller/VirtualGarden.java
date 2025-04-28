package com.example.virtualgarden3.controller;

import com.example.virtualgarden3.model.Account;
import com.example.virtualgarden3.model.Plant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/virtualgarden")
public class VirtualGarden extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        Account user = (Account) session.getAttribute("user");
        Plant plant = (Plant) session.getAttribute("plant");


        if (user == null) {
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
            return;
        }
        if (plant == null) {
            request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
            return;
        }

        request.setAttribute("plant", plant);

        if (action.equals("water")) {
            plant.waterPlant(10);
            request.getRequestDispatcher("/VirtualGarden.jsp").forward(request, response);
        }
        else if (action.equals("fertilizante")) {
            plant.fertilizePlant(1);
            request.getRequestDispatcher("/VirtualGarden.jsp").forward(request, response);
        }
        else if (action.equals("feed")) {
            plant.feedPlant(1);
            request.getRequestDispatcher("/VirtualGarden.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/VirtualGarden.jsp").forward(request, response);
        }



    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Plant plant = (Plant) session.getAttribute("plant");
        if (plant == null) {
            request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
            return;
        }
        request.setAttribute("plant", plant );
        request.getRequestDispatcher("/VirtualGarden.jsp").forward(request, response);
    }

}
