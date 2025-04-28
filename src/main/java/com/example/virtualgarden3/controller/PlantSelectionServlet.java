package com.example.virtualgarden3.controller;

import com.example.virtualgarden3.db.ApplicationData;
import com.example.virtualgarden3.model.Account;
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

    /**
     * first needs to check if user is null form the session attribute if true goes back to login page
     * then haldels adding the new plant, if no error goes to vritual garden page
     * if any errors stays on plant selection
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("user");

        if (user == null) {
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
            return;
        }

        try {
            int plantId = Integer.parseInt(request.getParameter("plantId"));
            Plant plant = ApplicationData.getInstance().getPlant(plantId, user);
            if (plant != null) {
                session.setAttribute("plant", plant);
                request.setAttribute("plant", plant);
                request.getRequestDispatcher("/VirtualGarden.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
    }

    /**
     * handles th plant selcetion get
     * gets the user forn session checks if its null if so goes back to login if not can u=open the plant selection page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("username") == null) {
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
        }
    }
}