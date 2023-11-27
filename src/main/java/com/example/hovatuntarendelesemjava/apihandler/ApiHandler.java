package com.example.hovatuntarendelesemjava.apihandler;

import com.example.hovatuntarendelesemjava.model.Customer;
import com.example.hovatuntarendelesemjava.model.Driver;
import com.example.hovatuntarendelesemjava.model.Shipment;
import com.example.hovatuntarendelesemjava.model.Vehicle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ApiHandler {

    private static HttpRequest request;
    private static final String uriBase = "https://63d5-84-3-207-209.ngrok.io";

    public static void sendPostRequest(Object object){
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();
        String json;


        if(object instanceof Vehicle vehicle) {
            json = gson.toJson(vehicle);
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

        } else if (object instanceof Driver driver) {
            json = gson.toJson(driver);
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
        } else if (object instanceof Shipment shipment) {
            json = gson.toJson(shipment);
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/shipments"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
        }


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        response.thenApply(HttpResponse::body).thenAccept(System.out::println).join();


    }

    public static void sendGetByIdRequest(Object object){
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();
        String json = gson.toJson(object);

        if(object instanceof Vehicle vehicle) {

            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles/licensePlate/" + vehicle.getLicensePlate()))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

        }else if (object instanceof Driver driver) {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers/driverId/" + driver.getDriverID()))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else if (object instanceof Customer customer){

            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/customers/customerId/" + customer.getCustomerId()))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else if (object instanceof Shipment shipment){
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/shipments/shipmentId/" + shipment.getShipmentId()))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else { }


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        response.thenApply(HttpResponse::body).thenAccept(System.out::println).join();

    }

    public static <T> List<T> sendGetAllRequest(Class type) throws ExecutionException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();

        if(type == Vehicle.class) {

            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles/getAll"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

        }else if (type == Driver.class) {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers/getAll"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else if (type == Customer.class){

            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/customers/getAll"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else if (type == Shipment.class){
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/shipments/getAll"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else {
            return null;
        }


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.get().body();
        List<T> resultList = new ArrayList<>();
        if(type == Vehicle.class) {
            TypeToken<List<Vehicle>> token = new TypeToken<>() {};
            resultList = gson.fromJson(responseBody, token.getType());
        }else if (type == Driver.class) {
            TypeToken<List<Driver>> token = new TypeToken<>() {};
            resultList = gson.fromJson(responseBody, token.getType());
        } else if (type == Shipment.class){
            TypeToken<List<Shipment>> token = new TypeToken<>() {};
            resultList = gson.fromJson(responseBody, token.getType());
        } else {
            TypeToken<List<Customer>> token = new TypeToken<>(){};
            resultList = gson.fromJson(responseBody, token.getType());
        }

        return resultList;
    }

    public static void sendDeleteRequest(Object object){
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();
        String json = gson.toJson(object);

        if(object instanceof Vehicle vehicle) {

            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles/licensePlate/" + vehicle.getLicensePlate()))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();

        } else if (object instanceof Driver driver) {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers/driverID/" + driver.getDriverID()))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else if (object instanceof Customer customer){

            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/customers/customerId/" + customer.getCustomerId()))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else if (object instanceof Shipment shipment){
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/shipments/shipmentId/" + shipment.getShipmentId()))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else { }


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        response.thenApply(HttpResponse::body).thenAccept(System.out::println).join();
    }

    public static void sendDeleteAllRequest(Object object){
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();
        String json = gson.toJson(object);

        if(object instanceof Vehicle vehicle) {

            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles/deleteAll"))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();

        } else if (object instanceof Driver driver) {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers/deleteAll"))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else if (object instanceof Customer customer){

            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/customers/deleteAll"))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else if (object instanceof Shipment shipment){
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/shipments/deleteAll/"))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else { }


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        response.thenApply(HttpResponse::body).thenAccept(System.out::println).join();
    }
}
