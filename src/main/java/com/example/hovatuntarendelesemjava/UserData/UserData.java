package com.example.hovatuntarendelesemjava.UserData;

import com.example.hovatuntarendelesemjava.model.User;

public class UserData{

    private Boolean isAdmin;
    private Boolean wasLoggedIn;
    private String username;
    private String email;


    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public Boolean getWasLoggedIn() {
        return wasLoggedIn;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }

    private static UserData instance;

    public static void newInstance() {
        instance = new UserData();
    }

    public static UserData getInstance() {
        return instance;
    }

    public static void setInstance(User user) {
        instance.email = user.getEmail();
        instance.isAdmin = user.getAdmin();
        instance.username = user.getUsername();
        instance.wasLoggedIn = user.getWasLoggedIn();
    }

    public User toUser(){
        User user = new User();
        user.setWasLoggedIn(wasLoggedIn);
        user.setAdmin(isAdmin);
        user.setEmail(email);
        user.setUsername(username);

        return user;
    }

}
