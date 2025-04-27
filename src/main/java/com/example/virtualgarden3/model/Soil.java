package com.example.virtualgarden3.model;

import java.util.ArrayList;
import java.util.List;

public class Soil {
    //this class refers to the pot and all of that

    private int weight; //how many kg of soil there is
    private int dryPer; //how dry is the soil
    private List<String> vitamins;

    public Soil(int weight, int dryPer, List<String> vitamins){
        this.weight = weight;
        this.dryPer = dryPer;
        this.vitamins = vitamins;
    }

    public int getWeight() {
        return weight;
    }
    public int getDryPer() {
        return dryPer;
    }
    public List<String> getVitamins() {
        return vitamins;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setDryPer(int dryPer) {
        this.dryPer = dryPer;
    }
    public void setVitamins(List<String> vitamins) {
        this.vitamins = vitamins;
    }

    //public int WaterSoil(int ml){
    //
    //}

}
