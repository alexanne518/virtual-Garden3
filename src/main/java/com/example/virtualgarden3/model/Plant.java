package com.example.virtualgarden3.model;

import java.util.Date;

public abstract class Plant {
    //using protected so its accessible to only subclasses
    protected final int id; //I changed this for final so it can not be changed once set
    protected String name;
    protected Date lastWatered; //is fine, from here we push it to the db
    protected int waterLevel; //idk if its gonna be a string or a number
    //was thinking well start it of at 0 and the max will be 100 so its easy to give a %

    public Plant(int id, String name) {
        this.id = id;
        this.name = name;
        //idk if we will just set he last watered here or in the water method
        this.waterLevel = 0; //start at no water
    }

    public String getName(){return new String(name);}
    public int getWaterLevel() {return waterLevel;}

    public abstract void waterPlant(int waterAmount);

    @Override
    public String toString() {
        return "Plant [id=" + id + ", name=" + name + ", getWaterLevel= " + getWaterLevel() + "]";
    }
}

