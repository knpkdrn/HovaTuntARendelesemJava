package com.example.hovatuntarendelesemjava.model;

import com.example.hovatuntarendelesemjava.model.base.HTARJModelBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shipment implements HTARJModelBase {
    private int shipmentId;
    private int customerId;
    private String startTime;
    private String endTime;
    private String origin;
    private String destination;
    private String shipmentStatus;
    public Shipment(String[] paramsList){
        setShipmentId(Integer.parseInt(paramsList[0]));
        setCustomerId(Integer.parseInt(paramsList[1]));
        setStartTime(paramsList[2]);
        setEndTime(paramsList[3]);
        setOrigin(paramsList[4]);
        setDestination(paramsList[5]);
        setShipmentStatus(paramsList[6]);
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
        if (checkDateFormat(startTime)){
            this.startTime = startTime;
        }
        else throw new IllegalArgumentException("The value in field 'Start Time' is not a date or is not in the correct format (yyyy-mm-dd)");
    }
    public void setEndTime(String endTime) {
        if (checkDateFormat(endTime)){
            this.endTime = endTime;
        }
        else throw new IllegalArgumentException("The value in field 'Start Time' is not a date or is not in the correct format (yyyy-mm-dd)");
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setShipmentStatus(String shipmentStatus) {
        if (checkShipmentStatus(shipmentStatus)){
            this.shipmentStatus = shipmentStatus;
        }
        else throw new IllegalArgumentException("The value in field 'Vehicle Status' is not 'in system', 'scheduled', 'enroute', 'completed', 'canceled'. Please choose from one of these parameters");
    }

    @Override
    public void setAllFields(String[] paramsList) {
        setShipmentId(Integer.parseInt(paramsList[0]));
        setCustomerId(Integer.parseInt(paramsList[1]));
        setStartTime(paramsList[2]);
        setEndTime(paramsList[3]);
        setOrigin(paramsList[4]);
        setDestination(paramsList[5]);
        setShipmentStatus(paramsList[6]);
    }
    private boolean checkDateFormat(String value){
        Pattern datePattern = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        Matcher matcher = datePattern.matcher(value);
        return matcher.matches();
    }
    private boolean checkShipmentStatus(String value){
        return value.matches("in system|scheduled|enroute|completed|canceled");
    }
}
