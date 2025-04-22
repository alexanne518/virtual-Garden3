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

@WebServlet("/home") //ima just call it home for now
public class PlantServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //Plant plant = (Plant) session.getAttribute("plant"); //create a new flower, or get it its one was already there in the session
        //idk why this is here

        String action = request.getParameter("action");

        if("plantSelection".equals(action)){
            String plantType = request.getParameter("selectedPlant");

            // Create the appropriate plant object
            Plant plant;
            if (plantType.equals("african-violet")) {
                plant = new AfricanViolet(1, "African Violet", "light"); // ID=1 for demo
            } else {
                plant = null; // Handle unknown types
            }

            // Store the plant in the session
            if (plant != null) {
                request.getSession().setAttribute("currentPlant", plant);
            }

        }
        else if("waterPlant".equals(action)){
            Plant plant = (Plant) session.getAttribute("currentPlant");
            if(plant != null){
                plant.waterPlant(); // This will call the specific implementation
                session.setAttribute("message", plant.getName() + " watered! Current level: " + plant.getWaterLevel() + "%");
                session.setAttribute("currentPlant", plant); // Update in session
            }
            //response.sendRedirect(request.getContextPath() + "/home");
        }
        else if("showStats".equals(action)){
            System.out.println("DEBUG - Forwarding to PlantStatus.jsp");
            request.getRequestDispatcher("/WEB-INF/PlantStatus.jsp").forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/home");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("userId") == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/Main.jsp").forward(request, response);
    }
}

