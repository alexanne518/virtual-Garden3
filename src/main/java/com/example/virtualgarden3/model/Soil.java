package com.example.virtualgarden3.model;

import java.util.ArrayList;
import java.util.List;

public class Soil {
    //this class refers to the pot and all of that

    private int weight; //how many kg of soil there is
    private int dryPer; //how dry is the soil
    private List<String> vitamins;

    public Soil(){
        this.weight = 0;
        this.dryPer = 0;
        this.vitamins = new ArrayList<>();
    }

    

}
