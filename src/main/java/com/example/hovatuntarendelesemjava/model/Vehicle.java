package com.example.hovatuntarendelesemjava.model;

import com.example.hovatuntarendelesemjava.model.base.HTARJModelBase;

public class Vehicle implements HTARJModelBase {

    private String licensePlate;
    private String make;
    private String model;
    private int prodYear;
    private Double cost;
    private int maxFuelInLiter;
    private String lastRefuelling;
    private Integer lastRefuellingCost;
    private int capacity;
    private int maintenanceInterval;
    private String lastMaintenance;
    private String nextMaintenance;
    private Double doneDistance;
    private Double avgConsumption;
    private Integer driverId; // This can be null, so use the Integer class
    private Integer shipmentId; // This can be null, so use the Integer class
    private String vehicleStatus;

    public Vehicle(String[] paramsList) {
        this.licensePlate = paramsList[0];
        this.make = paramsList[1];
        this.model = paramsList[2];
        this.prodYear = Integer.parseInt(paramsList[3]);
        this.cost = Double.parseDouble(paramsList[4]);
        this.maxFuelInLiter = Integer.parseInt(paramsList[5]);
        this.lastRefuelling = paramsList[6];
        this.lastRefuellingCost = Integer.parseInt(paramsList[7]);
        this.capacity = Integer.parseInt(paramsList[8]);
        this.maintenanceInterval = Integer.parseInt(paramsList[9]);
        this.lastMaintenance = paramsList[10];
        this.nextMaintenance = paramsList[11];
        this.doneDistance = Double.parseDouble(paramsList[12]);
        this.avgConsumption = Double.parseDouble(paramsList[13]);
        this.driverId = Integer.parseInt(paramsList[14]);
        this.shipmentId = Integer.parseInt(paramsList[15]);
        this.vehicleStatus = paramsList[16];
    }
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getProdYear() {
        return prodYear;
    }

    public Double getCost() {
        return cost;
    }

    public int getMaxFuelInLiter() {
        return maxFuelInLiter;
    }

    public String getLastRefuelling() {
        return lastRefuelling;
    }

    public Integer getLastRefuellingCost() {
        return lastRefuellingCost;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaintenanceInterval() {
        return maintenanceInterval;
    }

    public String getLastMaintenance() {
        return lastMaintenance;
    }

    public String getNextMaintenance() {
        return nextMaintenance;
    }

    public Double getDoneDistance() {
        return doneDistance;
    }

    public Double getAvgConsumption() {
        return avgConsumption;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setMaxFuelInLiter(int maxFuelInLiter) {
        this.maxFuelInLiter = maxFuelInLiter;
    }

    public void setLastRefuelling(String lastRefuelling) {
        this.lastRefuelling = lastRefuelling;
    }

    public void setLastRefuellingCost(Integer lastRefuellingCost) {
        this.lastRefuellingCost = lastRefuellingCost;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMaintenanceInterval(int maintenanceInterval) {
        this.maintenanceInterval = maintenanceInterval;
    }

    public void setLastMaintenance(String lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public void setNextMaintenance(String nextMaintenance) {
        this.nextMaintenance = nextMaintenance;
    }

    public void setDoneDistance(Double doneDistance) {
        this.doneDistance = doneDistance;
    }

    public void setAvgConsumption(Double avgConsumption) {
        this.avgConsumption = avgConsumption;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public void setAllFields(String[] paramsList) {
        this.licensePlate = paramsList[0];
        this.make = paramsList[1];
        this.model = paramsList[2];
        this.prodYear = Integer.parseInt(paramsList[3]);
        this.cost = Double.parseDouble(paramsList[4]);
        this.maxFuelInLiter = Integer.parseInt(paramsList[5]);
        this.lastRefuelling = paramsList[6];
        this.lastRefuellingCost = Integer.parseInt(paramsList[7]);
        this.capacity = Integer.parseInt(paramsList[8]);
        this.maintenanceInterval = Integer.parseInt(paramsList[9]);
        this.lastMaintenance = paramsList[10];
        this.nextMaintenance = paramsList[11];
        this.doneDistance = Double.parseDouble(paramsList[12]);
        this.avgConsumption = Double.parseDouble(paramsList[13]);
        this.driverId = Integer.parseInt(paramsList[14]);
        this.shipmentId = Integer.parseInt(paramsList[15]);
        this.vehicleStatus = paramsList[16];
    }
}