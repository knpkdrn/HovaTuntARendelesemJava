package com.example.hovatuntarendelesemjava.model.apihandler;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import com.example.hovatuntarendelesemjava.model.Vehicle;
import com.google.gson.Gson;

public class VehicleHandler {
    public static void sendPostRequest(){
        HttpClient httpClient = HttpClient.newHttpClient();
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate("AAA000");
        vehicle.setMake("toyoda");
        vehicle.setModel("alygo");
        vehicle.setProdYear(1848);
        vehicle.setCost(4.0);
        vehicle.setMaxFuelInLiter(400);
        vehicle.setLastRefuelling("2002-01-24");
        vehicle.setLastRefuellingCost(36);
        vehicle.setCapacity(3425);
        vehicle.setMaintenanceInterval(43);
        vehicle.setLastMaintenance("2002-01-24");
        vehicle.setNextMaintenance("2002-01-24");
        vehicle.setDoneDistance(324.0);
        vehicle.setAvgConsumption(32.0);
        vehicle.setDriverId(4);
        vehicle.setShipmentId(52);
        vehicle.setVehicleStatus("active");


        Gson gson = new Gson();
        String json = gson.toJson(vehicle);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ecbb-84-3-207-209.ngrok.io/api/vehicles"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        response.thenApply(HttpResponse::body).thenAccept(System.out::println).join();
    }
}
