package com.example.virtualgarden3.model;

public class Plant {

    private String name;
    private int growingRatio;
    private Soil soil;

    public Plant(String name, int growingRatio, Soil soil) {
        this.name = name;
        this.growingRatio = growingRatio;
        this.soil = soil;
    }

}