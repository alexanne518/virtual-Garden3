package com.example.virtualgarden3.model;

import java.util.Date;

public class AfricanViolet extends Plant{
    private String soilType; //idk if this is gonna be a class eathereee
    private int waterAmount;

    public AfricanViolet(int plantId, String name, int waterLevel, String soilType, int waterAmount) {
        super(plantId, name, waterLevel); //using the parent class
        this.soilType = SoilType.LIGHT_SOIL.getDisplayName();  // Set to the specific soil type
        this.waterAmount = waterAmount;
    }

    @Override
    public void waterPlant() {
        waterLevel += waterAmount; // Ferns require a lot of water
        if (waterLevel > 100) {
             System.out.println("the plant is already at 100% do you want to continue?");
             //if answer is yes water if no dont
             //gonna get the answer form a form so...
             this.lastWatered = new Date(); //updating to now
        }
        System.out.println(name + " watered. Current water level: " + waterLevel + "%.");
    }
}
