package com.example.hovatuntarendelesemjava;

import com.example.hovatuntarendelesemjava.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.regex.*;

import java.io.IOException;
import java.lang.reflect.Field;

public class MainViewController extends Parent {
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

    ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();
    ObservableList<Driver> driverList = FXCollections.observableArrayList();
    ObservableList<Shipment> shipmentList = FXCollections.observableArrayList();
    ObservableList<Customer> customerList = FXCollections.observableArrayList();
    private TableView<Vehicle> vehicleTableView;
    private TableView<Driver> driverTableView;
    private TableView<Shipment> shipmentTableView;
    private TableView<Customer> customerTableView;
    private static MainViewController instance;

    public static MainViewController getInstance() {
        return instance;
    }

    public ObservableList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public ObservableList<Driver> getDriverList() {
        return driverList;
    }

    public ObservableList<Shipment> getShipmentList() {
        return shipmentList;
    }

    public ObservableList<Customer> getCustomerList() {
        return customerList;
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
        shipmentTableView = createTableView(shipmentList, Shipment.class);
        customerTableView = createTableView(customerList, Customer.class);
        itemsGridPane.getChildren().add(vehicleTableView);

        instance = this;
    }

    @FXML
    private void onAddButtonClicked() throws IOException {
        if (vehiclesButton.isSelected()) openNewWindow(Vehicle.class);
        if (driversButton.isSelected()) openNewWindow(Driver.class);
        if (customersButton.isSelected()) openNewWindow(Customer.class);
        if (shipmentButton.isSelected()) openNewWindow(Shipment.class);
    }

    @FXML
    private void onRemoveButtonClicked() {
        if (vehiclesButton.isSelected() && !vehicleList.isEmpty()) {
            vehicleList.remove(vehicleTableView.getSelectionModel().getSelectedIndex());
            vehicleTableView.getSelectionModel().clearSelection();
        } else if (driversButton.isSelected() && !driverList.isEmpty()) {
            driverList.remove(driverTableView.getSelectionModel().getSelectedIndex());
            driverTableView.getSelectionModel().clearSelection();
        } else if (customersButton.isSelected() && !customerList.isEmpty()) {
            customerList.remove(customerTableView.getSelectionModel().getSelectedIndex());
            customerTableView.getSelectionModel().clearSelection();
        } else if (shipmentButton.isSelected() && !shipmentList.isEmpty()) {
            shipmentList.remove(shipmentTableView.getSelectionModel().getSelectedIndex());
            shipmentTableView.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void onRefreshButtonClicked() throws IOException {
        if (vehiclesButton.isSelected() && !vehicleList.isEmpty())
            openNewWindow(vehicleList.get(vehicleTableView.getSelectionModel().getSelectedIndex()));
        if (driversButton.isSelected() && !driverList.isEmpty())
            openNewWindow(driverList.get(driverTableView.getSelectionModel().getSelectedIndex()));
        if (customersButton.isSelected() && !customerList.isEmpty())
            openNewWindow(customerList.get(customerTableView.getSelectionModel().getSelectedIndex()));
        if (shipmentButton.isSelected() && !shipmentList.isEmpty())
            openNewWindow(shipmentList.get(shipmentTableView.getSelectionModel().getSelectedIndex()));
    }

    public void refreshTable() {
        if (vehiclesButton.isSelected()) {
            vehicleTableView.refresh();
        } else if (driversButton.isSelected()) {
            driverTableView.refresh();
        } else if (shipmentButton.isSelected()) {
            shipmentTableView.refresh();
        } else if (customersButton.isSelected()) {
            customerTableView.refresh();
        }
    }

    @FXML
    private void onVehiclesButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(vehicleTableView);
    }

    @FXML
    private void onDriversButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(driverTableView);
    }

    @FXML
    private void onShipmentButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(shipmentTableView);
    }

    @FXML
    private void onCustomersButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(customerTableView);
    }

    private <T> TableView<T> createTableView(ObservableList<T> obsList, Class<T> model) {
        TableView<T> tableView = new TableView<>(obsList);
        tableView.setItems(obsList);

        tableView.setRowFactory(tv -> {
            TableRow<T> row = new TableRow<>();
            row.getStyleClass().add("table-row");
            return row;
        });

        tableView.setPrefWidth(20);
        GridPane.setRowIndex(tableView, 0);
        GridPane.setHgrow(tableView, Priority.ALWAYS);
        tableView.getStyleClass().add("items-view");
        tableView.setId("itemsView");

        for (Field f : model.getDeclaredFields()) {
            String pName = f.getName();
            TableColumn<T, String> tableColumn = new TableColumn<>(pName);
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(pName));
            tableView.getColumns().add(tableColumn);
        }

        return tableView;
    }


    private void openNewWindow(Class objClass) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addPopup-view.fxml"));

        Parent newWindowRoot = loader.load();

        Stage newWindowStage = new Stage();
        newWindowStage.setTitle("New Window");
        newWindowStage.setScene(new Scene(newWindowRoot));

        // Set the AddPopupController instance in the FXMLLoader
        AddPopupController popupController = loader.getController();
        // Pass any necessary data to the AddPopupController if needed
        popupController.setObjClass(objClass);

        newWindowStage.show();
    }

    private void openNewWindow(HTARJModelBase editableObject) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addPopup-view.fxml"));

        Parent newWindowRoot = loader.load();

        Stage newWindowStage = new Stage();
        newWindowStage.setTitle("New Window");
        newWindowStage.setScene(new Scene(newWindowRoot));

        // Set the AddPopupController instance in the FXMLLoader
        AddPopupController popupController = loader.getController();
        // Pass any necessary data to the AddPopupController if needed
        popupController.setEditableObject(editableObject);

        newWindowStage.show();
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
