package com.example.hovatuntarendelesemjava;

import com.example.hovatuntarendelesemjava.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.*;

public class LoginViewController {
    @FXML
    public TextField userIdField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Button logInButton;
    private static LoginViewController instance;
    public static LoginViewController getInstance() {
        return instance;
    }

    @FXML
    void initialize(){
        instance = this;
    }

    @FXML
    private void onLogInButtonClicked() throws IOException {
        // Check if the text fields are empty
        if(!Objects.equals(userIdField.getText(), "") && !Objects.equals(passwordField.getText(), "")) {
            if (validateEmail(userIdField.getText())){
                User user = new User(new String[]{userIdField.getText(), passwordField.getText(), "true"});
                openMainWindow(user);
            }
            else {
                new Alert(Alert.AlertType.WARNING, "Enter a valid email address!").show();
            }
        }
        else {
            new Alert(Alert.AlertType.WARNING, "Don't leave email and password fields empty!").show();
        }
    }
    private void openMainWindow(User user) throws IOException {
        // Create stage, scene, root node etc.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Hová Tűnt A Rendelésem Java?");

        // Set user for the app
        MainViewController mainViewController = fxmlLoader.getController();
        mainViewController.setUser(user);
        logInButton.getScene().getWindow().hide();
        stage.show();
    }
    private boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("^[a-z0-9]+@[a-z]+\\.[a-z]+");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
