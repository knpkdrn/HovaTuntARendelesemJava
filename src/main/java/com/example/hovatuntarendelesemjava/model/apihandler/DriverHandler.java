package com.example.hovatuntarendelesemjava.model.apihandler;

import com.example.hovatuntarendelesemjava.Main;
import com.example.hovatuntarendelesemjava.MainViewController;
import com.example.hovatuntarendelesemjava.model.Driver;

public class DriverHandler {
    private static Driver driver;

    public static Driver getDriver() {
        return driver;
    }

    public static void setDriver(Driver driver) {
        DriverHandler.driver = driver;
    }

    public static void sendPostRequest(Driver driver) {
        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                System.out.println(i);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            MainViewController.getInstance().getDriverList().add(driver);
        }).start();
    }
}
