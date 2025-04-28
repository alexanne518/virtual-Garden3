package com.example.virtualgarden3.model;

import java.awt.*;
import java.util.Date;

public class AfricanViolet extends Plant{
    private SoilType soilType;


    public AfricanViolet(int plantId, String name) {
        super(plantId, name); //using the parent class
    }

    /**
     * will increase the water level of the plant but will not water it above 100
     * also prints the water level in console
     * last watered would be to implement later so we can desrease the water amount based on when it was last watered
     * @param waterAmount the amount of water that will be added
     */
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

    /**
     * addeds food to plant and increases the vitamin level using the setVitaminsLevel in class plant to keep it between 0-5
     * @param amount amount of plant food that will be feed to the plant
     */
    @Override
    public void feedPlant(int amount) {
        setVitaminsLevel(amount + vitaminsLevel);
    }

    /**
     * uses the setFertilizerLevel function is class plant to added more fertilizer while keeping it between 0-20
     * @param amount of fertilizer that will be added to the plant
     */
    @Override
    public void fertilizePlant(int amount) {
        setFertilizerLevel(amount + fertilizerLevel);
    }

    /**
     *
     * @return string plant id, name, water level, and soil type
     */
    @Override
    public String toString() {
        return "Plant [id=" + id + ", name= " + name + ", getWaterLevel= " + getWaterLevel() + ", soil type= "+ soilType + "]";
    }
}
