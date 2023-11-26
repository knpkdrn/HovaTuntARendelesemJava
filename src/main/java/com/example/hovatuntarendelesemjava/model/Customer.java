package com.example.hovatuntarendelesemjava.model;

import com.example.hovatuntarendelesemjava.model.base.HTARJModelBase;

public class Customer implements HTARJModelBase {
    private int customerId;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Customer(String[] paramsList){
        this.customerId = Integer.parseInt(paramsList[0]);
        this.fullName = paramsList[1];
        this.address = paramsList[2];
        this.phoneNumber = paramsList[3];
        this.emailAddress = paramsList[4];
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getFullName() {
        return fullName;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void setAllFields(String[] paramsList) {
        this.customerId = Integer.parseInt(paramsList[0]);
        this.fullName = paramsList[1];
        this.address = paramsList[2];
        this.phoneNumber = paramsList[3];
        this.emailAddress = paramsList[4];
    }
}
