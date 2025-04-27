package com.example.virtualgarden3.controller;

import com.example.virtualgarden3.dao.PlantDAO;
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if("selectPlant".equals(action)) {
            System.out.println("plant button clicked");

            if (session.getAttribute("user") == null) { //need to be logged in to choose a plant
                request.setAttribute("error", "Please login first");
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
                return;
            }

            response.sendRedirect("PlantSelection.jsp");
        }
        else if ("play".equals(action)) {
            System.out.println("play button clicked");

            if (session.getAttribute("user") == null) { //need to be logged in to play
                request.setAttribute("error", "Please login first");
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
                return;
            }

            int userId = Integer.parseInt(session.getAttribute("userId").toString());

            try{
                List<Plant> userPlant = PlantDAO.getPlantsByUserId(userId);

                if(userPlant.isEmpty()) {
                    request.setAttribute("error", "No plant found");
                    System.out.println("Error, no plant going to plantselection");
                    response.sendRedirect("PlantSelection.jsp");
                }
                else {
                    System.out.println("plant found going to main");

                    session.setAttribute("currentPlant", userPlant.get(0));
                    response.sendRedirect("Main.jsp"); //TODO:for now its main but i need to chnage it to the actually game later
                }
            }catch(SQLException e){
                e.printStackTrace();
                request.setAttribute("error", "SQL Error");
                System.out.println("SQL Error, going to menu");
                request.getRequestDispatcher("/menu.jsp").forward(request, response);
            }
        }
        else if("login".equals(action)) {

            System.out.println("play button clicked");

            if (session.getAttribute("user") == null) {
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
                return;
            }
            else{ //if they are logged in
                response.sendRedirect("Main.jsp"); //TODO:for now its main but i need to chnage it to the actually game later
            }
        }


        //request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }





    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("menu initialized");
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }



}
