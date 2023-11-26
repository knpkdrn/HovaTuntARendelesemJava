package com.example.hovatuntarendelesemjava.model;

import com.example.hovatuntarendelesemjava.model.base.HTARJModelBase;

import java.lang.reflect.*;
import java.util.Objects;

public class User implements HTARJModelBase {

    private String email;
    private String username;
    private String password;
    private Boolean isAdmin;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public User(String[] paramsList){
        Field[] fieldList = this.getClass().getDeclaredFields();
        if (paramsList.length == fieldList.length){
            for (int i = 0; i < paramsList.length; ++i){
                try {
                    if (fieldList[i].getType() == String.class){
                        fieldList[i].set(this, paramsList[i]);
                    }
                    if (fieldList[i].getType() == Boolean.class){
                        if ((Objects.equals(paramsList[i], "true"))) {
                            fieldList[i].set(this, true);
                        } else {
                            fieldList[i].set(this, false);
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else System.out.println("paramsList.length != fieldList.length");
    }
    @Override
    public void setAllFields(String[] paramsList) {
        Field[] fieldList = this.getClass().getDeclaredFields();
        if (paramsList.length == fieldList.length){
            for (int i = 0; i < paramsList.length; ++i){
                try {
                    if (fieldList[i].getType() == String.class){
                        fieldList[i].set(this, paramsList[i]);
                    }
                    if (fieldList[i].getType() == Boolean.class){
                        if ((Objects.equals(paramsList[i], "true"))) {
                            fieldList[i].set(this, true);
                        } else {
                            fieldList[i].set(this, false);
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else System.out.println("paramsList.length != fieldList.length");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
