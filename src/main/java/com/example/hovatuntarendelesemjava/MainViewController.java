package com.example.hovatuntarendelesemjava;

import com.example.hovatuntarendelesemjava.model.Driver;
import com.example.hovatuntarendelesemjava.model.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import java.lang.reflect.Field;

public class MainViewController {

    @FXML
    private Button settingsButton;
    @FXML
    private Button logOutButton;
    @FXML
    private HBox clientHeader;
    @FXML
    private RadioButton vehiclesButton;
    @FXML
    private RadioButton driversButton;
    @FXML
    private RadioButton shipmentButton;
    @FXML
    private RadioButton customersButton;
    @FXML
    private ScrollPane clientScrollPane;
    @FXML
    private GridPane itemsGridPane;
    @FXML
    private HBox itemsHeader;
    @FXML
    private TableView itemsView;

    ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();
    ObservableList<Driver> driverList = FXCollections.observableArrayList();
    private TableView<Vehicle> vehicleTableView;
    private TableView<Driver> driverTableView;
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

        vehicleTableView = createTableView(vehicleList, Vehicle.class);
        driverTableView = createTableView(driverList, Driver.class);
        itemsGridPane.getChildren().add(vehicleTableView);


    }

    @FXML
    private void onAddButtonClicked() {
        //VehicleHandler.sendPostRequest();
        if (vehiclesButton.isSelected()){
            vehicleList.add(new Vehicle());
        }
        else if (driversButton.isSelected()){
            driverList.add(new Driver());
        }

    }
    @FXML
    private void onRemoveButtonClicked() {
        if (vehiclesButton.isSelected()){
            vehicleList.remove(vehicleList.size()-1);
        }
        else if (driversButton.isSelected()){
            driverList.remove(driverList.size()-1);
        }
    }
    @FXML
    private void onRefreshButtonClicked() {
    }
    @FXML
    private void onVehiclesButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(vehicleTableView);
        System.out.println(itemsGridPane.getChildren().toString());
    }
    @FXML
    private void onDriversButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(driverTableView);
        System.out.println(itemsGridPane.getChildren().toString());
    }
    @FXML
    private void onShipmentButtonClicked() {

    }
    @FXML
    private void onCustomersButtonClicked() {

    }

    private <T> TableView<T> createTableView(ObservableList<T> obsList, Class<T> model){
        TableView<T> tableView = new TableView<>(obsList);
        tableView.setItems(obsList);
        GridPane.setRowIndex(tableView, 0);
        GridPane.setHgrow(tableView, Priority.ALWAYS);
        tableView.getStyleClass().add("items-view");
        tableView.setId("itemsView");

        for(Field f : model.getDeclaredFields()){
            String pName = f.getName();
            TableColumn<T, String> tableColumn = new TableColumn<>(pName);
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(pName));
            tableView.getColumns().add(tableColumn);
        }
        return tableView;
    }
}