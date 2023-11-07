package com.example.hovatuntarendelesemjava.model;

public class Vehicle {

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

    public Vehicle() {
        setLicensePlate("AAA000");
        setMake("toyoda");
        setModel("alygo");
        setProdYear(1848);
        setCost(4.0);
        setMaxFuelInLiter(400);
        setLastRefuelling("2002-01-24");
        setLastRefuellingCost(36);
        setCapacity(3425);
        setMaintenanceInterval(43);
        setLastMaintenance("2002-01-24");
        setNextMaintenance("2002-01-24");
        setDoneDistance(324.0);
        setAvgConsumption(32.0);
        setDriverId(4);
        setShipmentId(52);
        setVehicleStatus("active");
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
}