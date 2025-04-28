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

    private ApplicationData() {
        accounts.put(0, new Account(0, "User1", "User1234"));
        plants.put(0, new Pair<>(accounts.get(0), new AfricanViolet(0, "Violenta")));
    }

    public static ApplicationData getInstance() {
        if (instance == null) {
            instance = new ApplicationData();
        }
        return instance;
    }

    private HashMap<Integer, Account> accounts = new HashMap<>();
    private HashMap<Integer, Pair<Account, Plant>> plants = new HashMap<>();

    public Account tryAuthenticate(String username, String password) {
        for (Map.Entry<Integer, Account> pair : accounts.entrySet()) {
            if (pair.getValue().tryAuthenticate(username, password)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public Plant getPlant(int id, Account account) {
        Pair<Account, Plant> pair = plants.get(id);
        if (pair.left == account) {
            return pair.right;
        } else {
            return null;
        }
    }

}
