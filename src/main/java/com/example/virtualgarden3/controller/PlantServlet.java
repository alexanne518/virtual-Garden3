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

@WebServlet("/home") //ima just call it home for now
public class PlantServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        Integer userId = null;
        try {
            Object userIdObj = session.getAttribute("userId");
            if (userIdObj != null) {
                if (userIdObj instanceof Integer) {
                    userId = (Integer) userIdObj;
                } else {
                    // If it's stored as String, parse it
                    userId = Integer.parseInt(userIdObj.toString());
                }
            }
        } catch (NumberFormatException e) {
            session.setAttribute("message", "Invalid user ID format");
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }

        if (userId == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
            return;
        }

        if("plantSelection".equals(action)){
            String plantType = request.getParameter("selectedPlant");

            Plant plant;
            if (plantType.equals("african-violet")) {
                plant = new AfricanViolet(0, "African Violet", SoilType.LIGHT_SOIL); // ID=1 for demo
                try {
                    int plantId = PlantDAO.addPlant(plant, userId);

                    plant.setId(plantId); // Update the plant with the database ID

                    // Store the plant in the session
                    session.setAttribute("currentPlant", plant);
                    session.setAttribute("message", "African Violet planted successfully!");

                }catch(SQLException e){
                    session.setAttribute("message", "Error cearintg plant: "+e.getMessage());
                    e.printStackTrace();
                }
            }
        }else if("waterPlant".equals(action)){
            Plant plant = (Plant) session.getAttribute("currentPlant");
            if(plant != null){
                plant.waterPlant(30); // This will call the specific implementation
                try {
                    PlantDAO.updatePlant(plant);

                    session.setAttribute("message", plant.getName() + " watered! Current level: " + plant.getWaterLevel() + "%");
                    session.setAttribute("currentPlant", plant); // Update in session
                }catch(SQLException e){
                    session.setAttribute("message", "Error updating plant: "+e.getMessage());
                    e.printStackTrace();
                }

                if(plant.getWaterLevel() > 100){ //give them a pop up to warn them that it would be too much, idk how to do it in front

                }
            }

        }else if("showStats".equals(action)){
            try {
                List<Plant> plants = PlantDAO.getPlantsByUserId(userId);
                request.setAttribute("plants", plants);
                request.getRequestDispatcher("/PlantStatus.jsp").forward(request, response);
                return;
            } catch (SQLException e) {
                session.setAttribute("message", "Error loading plants: " + e.getMessage());
                e.printStackTrace();
            }
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

        request.getRequestDispatcher("/Main.jsp").forward(request, response);
    }
}

