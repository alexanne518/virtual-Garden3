package com.example.virtualgarden3.model;

public class UserRegistration {
    private int id;
    private String name;
    private String password;


    public UserRegistration(int id, String name, String password ) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {return id;}
    public String getName() {return new String(name);} //copy so we cant change the original value accidentaly
    public String getPassword() {return new String(password);}

    /**
     * @return the user id and name not pass becuase that kinda sentitive and bad practice
     */
    @Override
    public String toString() {
        return "user id=" + id + ", name=" + name ;
    }
}
