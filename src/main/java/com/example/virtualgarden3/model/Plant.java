package com.example.virtualgarden3.model;

import java.util.Date;

public abstract class Plant {
    //using protected so its accessible to only subclasses
    protected int id; //I changed this for final so it can not be changed once set, i dont think its fiinal since its many dif plant idk
    protected String name;
    protected Date lastWatered; //is fine, from here we push it to the db
    protected int waterLevel;
    //was thinking well start it of at 0 and the max will be 100 so its easy to give a %

    public Plant(int id, String name) {
        this.id = id;
        this.name = name;
        this.waterLevel = 0; //start at no water
        this.lastWatered = new Date();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName(){return new String(name);}
    public int getWaterLevel() {return waterLevel;}
    public void setWaterLevel(int waterLevel) {
        this.waterLevel = Math.min(100, Math.max(0, waterLevel)); // has to be between 0 to 100
    }

    public abstract void waterPlant(int waterAmount);

    @Override
    public String toString() {
        return "Plant [id=" + id + ", name=" + name + ", getWaterLevel= " + getWaterLevel() + "]";
    }
}

