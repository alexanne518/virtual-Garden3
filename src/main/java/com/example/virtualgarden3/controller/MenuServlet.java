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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/menu")
public class MenuServlet  extends HttpServlet {

    /**
     * checs if the user is null if so goes back login
     * handels if the user wants to login, select a plant or start playing
     * checks the conditions and requierments for these functions
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (session.getAttribute("user") == null) { //kinda repalces the login button
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        } else {
            if (action.equals("selectPlant")) {
                request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
            } else if (action.equals("play")) {
                Plant plant = (Plant) session.getAttribute("plant");
                if (plant == null) {
                    request.getRequestDispatcher("/PlantSelection.jsp").forward(request, response);
                } else {
                    request.setAttribute("plant", plant);
                    request.getRequestDispatcher("/VirtualGarden.jsp").forward(request, response);
                }
            }
            else {
                request.getRequestDispatcher("/menu.jsp").forward(request, response);
            }
        }
    }

    /**
     * opens the menu page dosnt check anything becuase thers no need
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("menu initialized");
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }
}
