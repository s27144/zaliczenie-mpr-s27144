package com.s27144.Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {
    private List<User> users = new ArrayList<>();

    public List<User> getListaUser() {
        return users;
    }
    public void addUser(User user) { //add do listy
        users.add(user);
    }
    public void purgeList() { //clean listy
        users.clear();
    }
}