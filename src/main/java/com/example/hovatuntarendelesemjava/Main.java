package com.example.hovatuntarendelesemjava;

import com.example.hovatuntarendelesemjava.UserData.UserData;
import com.example.hovatuntarendelesemjava.model.Vehicle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hová Tűnt A Rendelésem Java?");
        stage.setScene(scene);
        //stage.setMaximized(true);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        UserData.newInstance();
        launch();
    }
}