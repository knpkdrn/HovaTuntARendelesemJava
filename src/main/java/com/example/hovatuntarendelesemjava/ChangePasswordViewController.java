package com.example.hovatuntarendelesemjava;

import com.example.hovatuntarendelesemjava.UserData.UserData;
import com.example.hovatuntarendelesemjava.apihandler.ApiHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChangePasswordViewController {

    public PasswordField passwordField;
    public PasswordField repeatField;
    public Button okButton;
    public String email;
    public String password;

    public void onOkButtonClicked() throws IOException {
        if (Objects.equals(passwordField.getText(), repeatField.getText())) {
            if (ApiHandler.sendNewPasswordRequest(email, passwordField.getText())){
                openMainWindow();
            }
            else if (ApiHandler.sendNewPasswordRequest(email, passwordField.getText()) == null){
                new Alert(Alert.AlertType.ERROR, "Something went wrong", ButtonType.OK).show();
                // Show the login window
                Stage loginVw = new Stage();
                loginVw.setScene(LoginViewController.getInstance().logInButton.getScene());
                LoginViewController.getInstance().passwordField.setText("");
                LoginViewController.getInstance().userIdField.setText("");
                closeThisWindow();
                loginVw.show();
            }
            else {
                new Alert(Alert.AlertType.WARNING, "Password is not correct!", ButtonType.OK).show();
                passwordField.setText("");
                repeatField.setText("");
            }
        }
        else new Alert(Alert.AlertType.WARNING, "Passwords do not match!").show();
    }
    private void openMainWindow() throws IOException {
        // Create stage, scene, root node etc.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Hová Tűnt A Rendelésem Java?");

        // Set user for the app
        MainViewController mainViewController = fxmlLoader.getController();
        closeThisWindow();
        stage.show();
    }
    private void closeThisWindow(){
        okButton.getScene().getWindow().hide();
    }
}
