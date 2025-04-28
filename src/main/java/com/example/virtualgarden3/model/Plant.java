package com.example.virtualgarden3.model;

import java.util.Date;

public abstract class Plant {
    //using protected so its accessible to only subclasses
    protected int id; //I changed this for final so it can not be changed once set, i dont think its fiinal since its many dif plant idk
    protected String name;
    protected Date lastWatered; //is fine, from here we push it to the db
    protected int waterLevel;
    protected int vitaminsLevel;
    protected int fertilizerLevel;
    //was thinking well start it of at 0 and the max will be 100 so its easy to give a %

    public Plant(int id, String name) {
        this.id = id;
        this.name = name;
        this.waterLevel = 5; //start at no water
        fertilizerLevel = 10;
        vitaminsLevel = 1;
        this.lastWatered = new Date();
    }

    public int getHealth() {
        float waterComponent = waterLevel / 100f;
        waterComponent = 1 - 2 * Math.abs(waterComponent - 0.5f);

        float vitaminComponent = vitaminsLevel / 5f;
        return Math.round(100 * waterComponent * vitaminComponent) ;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName(){return new String(name);}
    public int getWaterLevel() {return waterLevel;}
    public int getVitaminsLevel() {return vitaminsLevel;}
    public int getFertilizerLevel() {return fertilizerLevel;}
    public void setWaterLevel(int waterLevel) {
        this.waterLevel = Math.min(100, Math.max(0, waterLevel)); // has to be between 0 to 100
    }

    public void setVitaminsLevel(int vitaminsLevel) {
        this.vitaminsLevel = Math.max(0, Math.min(5, vitaminsLevel));
    }

    public void setFertilizerLevel(int amount) {
        this.fertilizerLevel = Math.max(0, Math.min(20, amount));
    }

    public abstract void waterPlant(int waterAmount);

    public abstract void feedPlant(int amount);
    public abstract void fertilizePlant(int amount);


    @Override
    public String toString() {
        return "Plant [id=" + id + ", name=" + name + ", getWaterLevel= " + getWaterLevel() + "]";
    }
}

