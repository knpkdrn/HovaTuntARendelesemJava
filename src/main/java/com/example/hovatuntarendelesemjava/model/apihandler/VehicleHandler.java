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
        /*HttpClient httpClient = HttpClient.newHttpClient();
        Vehicle vehicle = new Vehicle();


        Gson gson = new Gson();
        String json = gson.toJson(vehicle);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/api/vehicles/licensePlate/AAA000"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        response.thenApply(HttpResponse::body).thenAccept(System.out::println).join();*/

    }
}
