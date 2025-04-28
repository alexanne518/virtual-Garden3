package com.example.virtualgarden3.model;

import java.awt.*;
import java.util.Date;

public class AfricanViolet extends Plant{
    private SoilType soilType;


    public AfricanViolet(int plantId, String name) {
        super(plantId, name); //using the parent class
    }

    @Override
    public void waterPlant(int waterAmount) {
        if (waterLevel + waterAmount < 100) {
            waterLevel += waterAmount; // Ferns require a lot of water  -- AFRICAN VIOLET IS NOT A FERN!!!!
            System.out.println(name + " Watered. Current water level: " + waterLevel + "%.");
        }
        else{
            waterLevel = 100;
        }
        this.lastWatered = new Date(); //updating to now
    }
    @Override
    public void feedPlant(int amount) {
        setVitaminsLevel(amount + vitaminsLevel);
    }
    @Override
    public void fertilizePlant(int amount) {
        setFertilizerLevel(amount + fertilizerLevel);
    }

    @Override
    public String toString() {
        return "Plant [id=" + id + ", name= " + name + ", getWaterLevel= " + getWaterLevel() + ", soil type= "+ soilType + "]";
    }
}
