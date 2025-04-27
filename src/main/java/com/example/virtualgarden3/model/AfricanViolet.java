package com.example.virtualgarden3.model;

import java.awt.*;
import java.util.Date;

public class AfricanViolet extends Plant{
    private SoilType soilType; //idk if this is gonna be a class eathereee


    public AfricanViolet(int plantId, String name, SoilType soilType) {
        super(plantId, name); //using the parent class
        this.soilType = SoilType.LIGHT_SOIL;  // Set to the specific soil type
    }

    @Override
    public void waterPlant(int waterAmount) {
        String answer;
        if (waterLevel + waterAmount < 100) {
            waterLevel += waterAmount; // Ferns require a lot of water  -- AFRICAN VIOLET IS NOT A FERN!!!!

            System.out.println(name + " Watered. Current water level: " + waterLevel + "%.");
        }
        else{
            waterLevel = 100;
        }
        this.lastWatered = new Date(); //updating to now
        System.out.println("the plant is already at 100% do you want to continue?");
    }

    @Override
    public String toString() {
        return "Plant [id=" + id + ", name= " + name + ", getWaterLevel= " + getWaterLevel() + ", soil type= "+ soilType + "]";
    }
}
