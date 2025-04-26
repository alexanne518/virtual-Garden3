package com.example.virtualgarden3.model;

import java.util.Date;

public class AfricanViolet extends Plant{
    private String soilType; //idk if this is gonna be a class eathereee


    public AfricanViolet(int plantId, String name, String soilType) {
        super(plantId, name); //using the parent class
        this.soilType = SoilType.LIGHT_SOIL.getDisplayName();  // Set to the specific soil type
    }

    @Override
    public void waterPlant(int waterAmount) {
        waterLevel += waterAmount; // Ferns require a lot of water  -- AFRICAN VIOLET IS NOT A FERN!!!!
        String answer;
        if (waterLevel > 100) {
             System.out.println("the plant is already at 100% do you want to continue?");
             // if ()
             //if answer is yes water if no dont
             //gonna get the answer form a form so...
             this.lastWatered = new Date(); //updating to now
        }
        System.out.println(name + " Watered. Current water level: " + waterLevel + "%.");
    }

    @Override
    public String toString() {
        return "Plant [id=" + id + ", name= " + name + ", getWaterLevel= " + getWaterLevel() + ", soil type= "+ soilType + "]";
    }
}
