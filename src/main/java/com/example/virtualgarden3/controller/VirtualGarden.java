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


        if("waterCan".equals(action)) {
            System.out.println("watering");
            plant.waterPlant(30); // Increase water by 30
            session.setAttribute("message", "Watered! Water level: " + plant.getWaterLevel() + "%");

        }
        else if("fertilizer".equals(action)) {
            System.out.println("fertilizing");
            plant.fertilizePlant(20); // Increase fertilizer level by 20
            session.setAttribute("message", "Fertilized! Fertilizer level: " + plant.getFertilizerLevel() + "%");

        }
        else if ("plantFood".equals(action)) {
            System.out.println("feeding");
            plant.feedPlant(15); // Increase vitamins level by 15
            session.setAttribute("message", "Fed! Vitamins level: " + plant.getVitaminsLevel() + "%");

        }


        request.getRequestDispatcher("VirtualGarden.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("game initialized");
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
