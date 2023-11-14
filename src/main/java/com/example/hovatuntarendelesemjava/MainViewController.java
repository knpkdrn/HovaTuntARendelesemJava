package com.example.hovatuntarendelesemjava;

import com.example.hovatuntarendelesemjava.model.Customer;
import com.example.hovatuntarendelesemjava.model.Driver;
import com.example.hovatuntarendelesemjava.model.Shipment;
import com.example.hovatuntarendelesemjava.model.Vehicle;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;

public class MainViewController extends Parent {

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
    ObservableList<Shipment> shipmentList = FXCollections.observableArrayList();
    ObservableList<Customer> customerList = FXCollections.observableArrayList();
    private TableView<Vehicle> vehicleTableView;
    private TableView<Driver> driverTableView;
    private TableView<Shipment> shipmentTableView;
    private TableView<Customer> customerTableView;

    private static MainViewController instance;

    public MainViewController() {

    }

    public static MainViewController getInstance() {
        return instance;
    }
    public RadioButton getVehiclesButton() {
        return vehiclesButton;
    }
    public ObservableList<Vehicle> getVehicleList() {
        return vehicleList;
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

    private void openNewWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addPopup-view.fxml"));


        Parent newWindowRoot = loader.load();

        Stage newWindowStage = new Stage();
        newWindowStage.setTitle("New Window");
        newWindowStage.setScene(new Scene(newWindowRoot));

        // Set the AddPopupController instance in the FXMLLoader
        AddPopupController popupController = loader.getController();
        // Pass any necessary data to the AddPopupController if needed

        newWindowStage.show();
    }

    @FXML
    private void onAddButtonClicked() throws IOException {
        openNewWindow();
    }

    @FXML
    private void onRemoveButtonClicked() {
        if (vehiclesButton.isSelected()) {
            vehicleList.remove(vehicleList.size() - 1);
        } else if (driversButton.isSelected()) {
            driverList.remove(driverList.size() - 1);
        }
    }

    @FXML
    private void onRefreshButtonClicked() {
        itemsGridPane.getChildren().remove(1);

        if (vehiclesButton.isSelected()) {
            vehicleTableView = createTableView(vehicleList, Vehicle.class);
            itemsGridPane.getChildren().add(vehicleTableView);
        } else if (driversButton.isSelected()) {
            driverTableView = createTableView(driverList, Driver.class);
            itemsGridPane.getChildren().add(driverTableView);
        } else if (shipmentButton.isSelected()) {
            shipmentTableView = createTableView(shipmentList, Shipment.class);
            itemsGridPane.getChildren().add(shipmentTableView);
        } else if (customersButton.isSelected()) {
            customerTableView = createTableView(customerList, Customer.class);
            itemsGridPane.getChildren().add(customerTableView);
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
            row.setStyle("-fx-font-size: 30px;");
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

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
