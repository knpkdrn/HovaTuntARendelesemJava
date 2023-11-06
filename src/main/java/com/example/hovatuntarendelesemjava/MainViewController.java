package com.example.hovatuntarendelesemjava;

import com.example.hovatuntarendelesemjava.model.Driver;
import com.example.hovatuntarendelesemjava.model.Vehicle;
import com.example.hovatuntarendelesemjava.model.apihandler.VehicleHandler;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.FXCollections.*;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainViewController {

    @FXML
    private ScrollPane clientScrollPane;
    @FXML
    private RadioButton vehiclesButton;
    @FXML
    private RadioButton driversButton;
    @FXML
    private RadioButton shipmentButton;
    @FXML
    private RadioButton customersButton;
    @FXML
    private GridPane itemsGridPane;


    public MainViewController() {

    }

    @FXML
    void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();

        vehiclesButton.setToggleGroup(toggleGroup);
        vehiclesButton.getStyleClass().remove("radio-button");
        vehiclesButton.getStyleClass().add("toggle-button");
        vehiclesButton.setSelected(true);

        driversButton.setToggleGroup(toggleGroup);
        driversButton.getStyleClass().remove("radio-button");
        driversButton.getStyleClass().add("toggle-button");

        shipmentButton.setToggleGroup(toggleGroup);
        shipmentButton.getStyleClass().remove("radio-button");
        shipmentButton.getStyleClass().add("toggle-button");

        customersButton.setToggleGroup(toggleGroup);
        customersButton.getStyleClass().remove("radio-button");
        customersButton.getStyleClass().add("toggle-button");


    }

    @FXML
    private void onAddButtonClicked() {
        VehicleHandler.sendPostRequest();
    }

    @FXML
    private void onVehiclesButtonClicked() {

    }
}
