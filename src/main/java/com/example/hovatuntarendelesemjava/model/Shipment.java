package com.example.hovatuntarendelesemjava.model;

public class Shipment implements HTARJModelBase {
    private int shipmentId;
    private int customerId;
    private String startTime;
    private String endTime;
    private String origin;
    private String destination;
    private String shipmentStatus;
    public Shipment(String[] paramsList){
        this.shipmentId = Integer.parseInt(paramsList[0]);
        this.customerId = Integer.parseInt(paramsList[1]);
        this.startTime = paramsList[2];
        this.endTime = paramsList[3];
        this.origin = paramsList[4];
        this.destination = paramsList[5];
        this.shipmentStatus = paramsList[6];
    }

    public int getShipmentId() {
        return shipmentId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public String getOrigin() {
        return origin;
    }
    public String getDestination() {
        return destination;
    }
    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    @Override
    public void setAllFields(String[] paramsList) {
        this.shipmentId = Integer.parseInt(paramsList[0]);
        this.customerId = Integer.parseInt(paramsList[1]);
        this.startTime = paramsList[2];
        this.endTime = paramsList[3];
        this.origin = paramsList[4];
        this.destination = paramsList[5];
        this.shipmentStatus = paramsList[6];
    }
}
