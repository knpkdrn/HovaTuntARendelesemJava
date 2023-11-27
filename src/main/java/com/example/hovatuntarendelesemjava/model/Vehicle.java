package com.example.hovatuntarendelesemjava.model;

import com.example.hovatuntarendelesemjava.model.base.HTARJModelBase;

import java.util.regex.*;

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
        setLicensePlate(paramsList[0]);
        setMake(paramsList[1]);
        setModel(paramsList[2]);
        setProdYear(Integer.parseInt(paramsList[3]));
        setCost(Double.parseDouble(paramsList[4]));
        setMaxFuelInLiter(Integer.parseInt(paramsList[5]));
        setLastRefuelling(paramsList[6]);
        setLastRefuellingCost(Integer.parseInt(paramsList[7]));
        setCapacity(Integer.parseInt(paramsList[8]));
        setMaintenanceInterval(Integer.parseInt(paramsList[9]));
        setLastMaintenance(paramsList[10]);
        setNextMaintenance(paramsList[11]);
        setDoneDistance(Double.parseDouble(paramsList[12]));
        setAvgConsumption(Double.parseDouble(paramsList[13]));
        setDriverId(Integer.parseInt(paramsList[14]));
        setShipmentId(Integer.parseInt(paramsList[15]));
        setVehicleStatus(paramsList[16]);
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
        if (checkDateFormat(lastRefuelling)){
            this.lastRefuelling = lastRefuelling;
        }
        else throw new IllegalArgumentException("The value passed in field 'Last Refuelling' is not a date or is not in the correct format (yyyy-mm-dd)");
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
        if (checkDateFormat(lastMaintenance)){
            this.lastMaintenance = lastMaintenance;
        }
        else throw new IllegalArgumentException("The value in field 'Last Maintenance' is not a date or is not in the correct format (yyyy-mm-dd)");
    }

    public void setNextMaintenance(String nextMaintenance) {
        if (checkDateFormat(nextMaintenance)){
            this.nextMaintenance = nextMaintenance;
        }
        else throw new IllegalArgumentException("The value in field 'Next Maintenance' is not a date or is not in the correct format (yyyy-mm-dd)");
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
        if (checkVehicleStatus(vehicleStatus)){
            this.vehicleStatus = vehicleStatus;
        }
        else throw new IllegalArgumentException("The value in field 'Vehicle Status' is not 'on route', 'idle' or 'active'. Please choose from one of these parameters");
    }

    @Override
    public void setAllFields(String[] paramsList) {
        setLicensePlate(paramsList[0]);
        setMake(paramsList[1]);
        setModel(paramsList[2]);
        setProdYear(Integer.parseInt(paramsList[3]));
        setCost(Double.parseDouble(paramsList[4]));
        setMaxFuelInLiter(Integer.parseInt(paramsList[5]));
        setLastRefuelling(paramsList[6]);
        setLastRefuellingCost(Integer.parseInt(paramsList[7]));
        setCapacity(Integer.parseInt(paramsList[8]));
        setMaintenanceInterval(Integer.parseInt(paramsList[9]));
        setLastMaintenance(paramsList[10]);
        setNextMaintenance(paramsList[11]);
        setDoneDistance(Double.parseDouble(paramsList[12]));
        setAvgConsumption(Double.parseDouble(paramsList[13]));
        setDriverId(Integer.parseInt(paramsList[14]));
        setShipmentId(Integer.parseInt(paramsList[15]));
        setVehicleStatus(paramsList[16]);
    }
    private boolean checkDateFormat(String value){
        Pattern datePattern = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        Matcher matcher = datePattern.matcher(value);
        return matcher.matches();
    }
    private boolean checkVehicleStatus(String value){
        return value.matches("on route|idle|active");
    }
}