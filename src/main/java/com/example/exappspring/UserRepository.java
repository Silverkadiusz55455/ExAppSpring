package com.example.exappspring;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();

    public UserRepository(List<User> userList) {
        this.userList = userList;
    }

    public List<User>printUser() {
        return userList;
    }

    public void add(User user){
        userList.add(user);
    }


    public List<User>getAll() {
        return userList;
    }


}
