package com.example.hovatuntarendelesemjava.apihandler;

import com.example.hovatuntarendelesemjava.model.Customer;
import com.example.hovatuntarendelesemjava.model.Driver;
import com.example.hovatuntarendelesemjava.model.Shipment;
import com.example.hovatuntarendelesemjava.model.Vehicle;
import com.example.hovatuntarendelesemjava.model.base.HTARJModelBase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class VehicleHandler {

    private static HttpRequest request;
    private static final String uriBase = "http://localhost:8081";

    public static void sendPostRequest(Object object){
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();
        String json = gson.toJson(object);

        if(object instanceof Vehicle) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

        }else if (object instanceof Driver) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
        } else {

        }


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        response.thenApply(HttpResponse::body).thenAccept(System.out::println).join();

    }

    public static void sendGetByIdRequest(Object object){
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();
        String json = gson.toJson(object);

        if(object instanceof Vehicle vehicle) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles/licensePlate/" + vehicle.getLicensePlate()))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

        }else if (object instanceof Driver driver) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers/driverId/" + driver.getDriverID()))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else if (object instanceof Customer customer){

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/customers/customerId/" + customer.getCustomerId()))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else if (object instanceof Shipment shipment){
            HttpRequest request = HttpRequest.newBuilder()
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

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles/getAll"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

        }else if (type == Driver.class) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers/getAll"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else if (type == Customer.class){

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/customers/getAll"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
        } else if (type == Shipment.class){
            HttpRequest request = HttpRequest.newBuilder()
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
            TypeToken<List<Vehicle>> token = new TypeToken<>(){};
            resultList = gson.fromJson(responseBody, token.getType());
        }else if (type == Driver.class) {
            TypeToken<List<Driver>> token = new TypeToken<>(){};
            resultList = gson.fromJson(responseBody, token.getType());
        } else if (type == Shipment.class){
            TypeToken<List<Shipment>> token = new TypeToken<>(){};
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

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles/licensePlate/" + vehicle.getLicensePlate()))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();

        } else if (object instanceof Driver driver) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers/driverID/" + driver.getDriverID()))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else if (object instanceof Customer customer){

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/customers/customerId/" + customer.getCustomerId()))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else if (object instanceof Shipment shipment){
            HttpRequest request = HttpRequest.newBuilder()
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

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/vehicles/deleteAll"))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();

        } else if (object instanceof Driver driver) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/drivers/deleteAll"))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else if (object instanceof Customer customer){

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/customers/deleteAll"))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else if (object instanceof Shipment shipment){
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase + "/api/shipments/deleteAll/"))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
        } else { }


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        response.thenApply(HttpResponse::body).thenAccept(System.out::println).join();
    }
}