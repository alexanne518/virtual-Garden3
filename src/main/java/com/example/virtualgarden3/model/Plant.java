package com.example.virtualgarden3.model;

import java.util.Date;

public abstract class Plant {
    //using protected so its accessible to only subclasses
    protected int id; //for data base? idk if we need it
    protected String name;
    protected Date lastWatered; //idk if we should get it here or in the database
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

    public abstract void waterPlant();

    @Override
    public String toString() {
        return "Plant [id=" + id + ", name=" + name + ", getWaterLevel= " + getWaterLevel() + "]";
    }
}

