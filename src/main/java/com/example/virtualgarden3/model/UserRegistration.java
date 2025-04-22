package com.example.virtualgarden3.model;

public class UserRegistration {
    private int id;
    private String name;
    private String password; //dont think we need the password
    //private Plant plant;//think we would also need whta type of plant they chose

    public UserRegistration(int id, String name, String password /*, Plant plant*/) {
        this.id = id;
        this.name = name;
        this.password = password;
        //this.plant = plant; //no idea if this is the right way
    }

    public int getId() {return id;}
    public String getName() {return new String(name);} //copy so it cant et changed
    //dont think we need a get password because u dont wanna show it

    @Override
    public String toString() {
        return "user id=" + id + ", name=" + name ;
    }
}
