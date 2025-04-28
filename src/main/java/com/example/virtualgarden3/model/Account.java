package com.example.virtualgarden3.model;

public class Account {

    public final int id;
    private String username;
    private String password;

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * to check login and authenticate the username and password
     * @param username used to check
     * @param password used to check
     * @return if the username and password input my the user are equal to our username and password
     */
    public boolean tryAuthenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }
}
