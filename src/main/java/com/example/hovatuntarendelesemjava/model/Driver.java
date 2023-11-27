package com.example.hovatuntarendelesemjava.model;

import com.example.hovatuntarendelesemjava.model.base.HTARJModelBase;

public class Driver implements HTARJModelBase {

    private int driverId;
    private String firstName;
    private String lastName;
    private String licenseNumber;
    private String phoneNumber;
    private String emailAddress;
    private String assignedVehicleLicense;

    public Driver(String[] paramsList) {
        this.driverId = Integer.parseInt(paramsList[0]);
        this.firstName = paramsList[1];
        this.lastName = paramsList[2];
        this.licenseNumber = paramsList[3];
        this.phoneNumber = paramsList[4];
        this.emailAddress = paramsList[5];
        this.assignedVehicleLicense = paramsList[6];
    }

    public int getDriverId() {
        return driverId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getAssignedVehicleLicense() {
        return assignedVehicleLicense;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public void setAssignedVehicleLicense(String assignedVehicleLicense) {
        this.assignedVehicleLicense = assignedVehicleLicense;
    }

    @Override
    public void setAllFields(String[] paramsList) {
        this.driverId = Integer.parseInt(paramsList[0]);
        this.firstName = paramsList[1];
        this.lastName = paramsList[2];
        this.licenseNumber = paramsList[3];
        this.phoneNumber = paramsList[4];
        this.emailAddress = paramsList[5];
        this.assignedVehicleLicense = paramsList[6];
    }
}
