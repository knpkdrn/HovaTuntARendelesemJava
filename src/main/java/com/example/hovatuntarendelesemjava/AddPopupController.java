// AddPopupController.java
package com.example.hovatuntarendelesemjava;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.example.hovatuntarendelesemjava.MainViewController;
import com.example.hovatuntarendelesemjava.model.Customer;
import com.example.hovatuntarendelesemjava.model.Driver;
import com.example.hovatuntarendelesemjava.model.Shipment;
import com.example.hovatuntarendelesemjava.model.Vehicle;


public class AddPopupController {

    @FXML
    private TextField attribute1Field;

    @FXML
    private TextField attribute2Field;

    // Add more fields for other attributes

    @FXML
    private void onSaveButtonClicked() {
        // Retrieve data from TextFields and save it to the corresponding TableView
        if (MainViewController.getInstance().getVehiclesButton().isSelected()) {
            MainViewController.getInstance().getVehicleList().add(
                    new Vehicle()
                    // Create a new Vehicle object with data from TextFields
            );
        }
        // Add similar logic for other TableViews

        // Close the popup window
        attribute1Field.getScene().getWindow().hide();
    }
}
