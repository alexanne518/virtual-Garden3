package com.example.virtualgarden3.model;

public class Main {
    public static void main(String[] args)
    {
        UserRegistration newUser = new UserRegistration(1, "alex", "123");

        System.out.println(newUser.toString());

        Plant newplant = new AfricanViolet (1, "AfricanViolet", SoilType.LIGHT_SOIL.getDisplayName());
        System.out.println(newplant.toString());
    }
}