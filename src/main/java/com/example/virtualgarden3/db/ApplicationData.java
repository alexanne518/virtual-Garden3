package com.example.virtualgarden3.db;

import com.example.virtualgarden3.model.Account;
import com.example.virtualgarden3.model.AfricanViolet;
import com.example.virtualgarden3.model.Plant;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Pair<L, R> {
    public final L left;
    public final R right;
    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }
}

public class ApplicationData {

    private static ApplicationData instance;

    /**
     * set the username (sa for now) and password (sa for now) to keep simplicity
     * and the new plant for the user
     */
    private ApplicationData() {
        accounts.put(0, new Account(0, "sa", "sa"));
        plants.put(0, new Pair<>(accounts.get(0), new AfricanViolet(0, "Violenta")));
    }

    /**
     * checks if instance exists if not it creates the new instance of aplication data
     * @return the instance of aplication data
     */
    public static ApplicationData getInstance() {
        if (instance == null) {
            instance = new ApplicationData();
        }
        return instance;
    }

    private HashMap<Integer, Account> accounts = new HashMap<>();
    private HashMap<Integer, Pair<Account, Plant>> plants = new HashMap<>();

    /**
     * tries to authenicate the username and password given by the user
     * @param username to check
     * @param password to check
     * @return the pair vlaues from the map if they are equal if not null
     */
    public Account tryAuthenticate(String username, String password) {
        for (Map.Entry<Integer, Account> pair : accounts.entrySet()) {
            if (pair.getValue().tryAuthenticate(username, password)) {
                return pair.getValue();
            }
        }
        return null;
    }

    /**
     * gets the plant for the user by id and account
     * @param id user id
     * @param account user account
     * @return if owned by user the plant and null if the plant doesn't have that account
     */
    public Plant getPlant(int id, Account account) {
        Pair<Account, Plant> pair = plants.get(id);
        if (pair.left == account) {
            return pair.right;
        } else {
            return null;
        }
    }

}
