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

@WebServlet("/game") //ima just call it home for now
public class GameServlet  extends HttpServlet {


    //init to initilize the game state object

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //then we can accesss it here
        // returns  aresponse pay load to the used , jaa script that updated the ui
        //fetch("url/game", {method:"post"}, can put the data u want to senf) , cans end data
        //.then((res)=> res.json then u want to use like a hash map sp key:like plantWater  value is 50

        //response.sendRedirect(request.getContextPath() + "/game/");

        HttpSession session = request.getSession();

        Plant plant = (Plant) session.getAttribute("plant"); //create a new flower, or get it its one was already there in the session


        request.getRequestDispatcher("/WEB-INF/Main.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Main.jsp").forward(request, response);
    }



}
