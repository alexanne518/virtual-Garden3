package com.example.virtualgarden3.controller;

import com.example.virtualgarden3.dao.PlantDAO;
import com.example.virtualgarden3.model.AfricanViolet;
import com.example.virtualgarden3.model.Plant;
import com.example.virtualgarden3.model.SoilType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/PlantSelection")
public class PlantSelectionServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Check if user is logged in
        if (session.getAttribute("userId") == null) {
            response.sendRedirect("Login");
            return;
        }

        try {
            int userId = Integer.parseInt(session.getAttribute("userId").toString());
            String plantType = request.getParameter("plantType"); // Changed from "selectedPlant"

            // Currently only handling African Violet
            if ("african-violet".equals(plantType)) {
                System.out.println("ciclked african violet");
                // Check if user already has a plant
                List<Plant> userPlants = PlantDAO.getPlantsByUserId(userId);
                if (!userPlants.isEmpty()) {
                    session.setAttribute("error", "You already have a plant!");
                    response.sendRedirect("Main.jsp");
                    return;
                }
                Plant plant = new AfricanViolet(0, "African Violet", SoilType.LIGHT_SOIL);
                int plantId = PlantDAO.addPlant(plant, userId);
                plant.setId(plantId);

                // Store in session
                session.setAttribute("currentPlant", plant);
                session.setAttribute("message", "African Violet planted successfully!");

                // Redirect to main page
                response.sendRedirect("Main.jsp");
                return;
            }
        } catch (NumberFormatException e) {
            session.setAttribute("error", "Invalid user ID");
        } catch (SQLException e) {
            session.setAttribute("error", "Database error: " + e.getMessage());
            e.printStackTrace();
        }

        // If anything fails, return to selection page
        response.sendRedirect("PlantSelection.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Clear any previous messages
        request.getSession().removeAttribute("message");
        request.getSession().removeAttribute("error");

        request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
    }
}