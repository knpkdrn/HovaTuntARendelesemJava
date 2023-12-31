package com.example.hovatuntarendelesemjava;

import com.example.hovatuntarendelesemjava.UserData.UserData;
import com.example.hovatuntarendelesemjava.apihandler.ApiHandler;
import com.example.hovatuntarendelesemjava.model.*;
import com.example.hovatuntarendelesemjava.model.base.HTARJModelBase;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainViewController extends Parent {
    @FXML
    public Button logOutButton;
    @FXML
    public Button addItemButton;
    @FXML
    public Button removeItemButton;
    @FXML
    public Button editButton;
    @FXML
    public HBox clientHeader;
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
    void initialize() throws ExecutionException, InterruptedException {
        ToggleGroup toggleGroup = new ToggleGroup();

        vehiclesButton.setToggleGroup(toggleGroup);
        vehiclesButton.getStyleClass().remove("radio-button");
        vehiclesButton.getStyleClass().add("toggle-button");

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

        setAccessibility(UserData.getInstance().getIsAdmin());

        instance = this;

        reloadTableData();

        Platform.runLater(() -> {
            logOutButton.setText(UserData.getInstance().getUsername());
            double prefWidth = logOutButton.prefWidth(-1);
            logOutButton.setMinWidth(prefWidth);
        });
    }

    @FXML
    private void onAddButtonClicked() throws IOException {
        if (vehiclesButton.isSelected()) openNewWindow(Vehicle.class);
        if (driversButton.isSelected()) openNewWindow(Driver.class);
        if (customersButton.isSelected()) openNewWindow(Customer.class);
        if (shipmentButton.isSelected()) openNewWindow(Shipment.class);
    }

    @FXML
    private void onRemoveButtonClicked() throws ExecutionException, InterruptedException {
        if (vehiclesButton.isSelected() && !vehicleList.isEmpty()) {
            ApiHandler.sendDeleteRequest(vehicleList.get(vehicleTableView.getSelectionModel().getSelectedIndex()));
            reloadTableData();
            vehicleTableView.getSelectionModel().clearSelection();
        } else if (driversButton.isSelected() && !driverList.isEmpty()) {
            ApiHandler.sendDeleteRequest(driverList.get(driverTableView.getSelectionModel().getSelectedIndex()));
            reloadTableData();
            driverTableView.getSelectionModel().clearSelection();
        } else if (customersButton.isSelected() && !customerList.isEmpty()) {
            ApiHandler.sendDeleteRequest(customerList.get(customerTableView.getSelectionModel().getSelectedIndex()));
            reloadTableData();
            customerTableView.getSelectionModel().clearSelection();
        } else if (shipmentButton.isSelected() && !shipmentList.isEmpty()) {
            ApiHandler.sendDeleteRequest(shipmentList.get(shipmentTableView.getSelectionModel().getSelectedIndex()));
            reloadTableData();
            shipmentTableView.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void onEditButtonClicked() throws IOException {
        if (vehiclesButton.isSelected() && !vehicleList.isEmpty())
            openNewWindow(vehicleList.get(vehicleTableView.getSelectionModel().getSelectedIndex()));
        if (driversButton.isSelected() && !driverList.isEmpty())
            openNewWindow(driverList.get(driverTableView.getSelectionModel().getSelectedIndex()));
        if (customersButton.isSelected() && !customerList.isEmpty())
            openNewWindow(customerList.get(customerTableView.getSelectionModel().getSelectedIndex()));
        if (shipmentButton.isSelected() && !shipmentList.isEmpty())
            openNewWindow(shipmentList.get(shipmentTableView.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    private void onVehiclesButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(vehicleTableView);
        addItemButton.setDisable(false);
        removeItemButton.setDisable(false);
        editButton.setDisable(false);
    }

    @FXML
    private void onDriversButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(driverTableView);
        addItemButton.setDisable(false);
        removeItemButton.setDisable(false);
        editButton.setDisable(false);
    }

    @FXML
    private void onShipmentButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(shipmentTableView);
        addItemButton.setDisable(!UserData.getInstance().getIsAdmin());
        removeItemButton.setDisable(!UserData.getInstance().getIsAdmin());
        editButton.setDisable(!UserData.getInstance().getIsAdmin());
    }

    @FXML
    private void onCustomersButtonClicked() {
        itemsGridPane.getChildren().remove(1);
        itemsGridPane.getChildren().add(customerTableView);
        addItemButton.setDisable(true);
        removeItemButton.setDisable(true);
        editButton.setDisable(true);
    }
    @FXML
    public void logOutButtonOnMouseClicked() {
        UserData.newInstance();
        Stage loginVw = new Stage();
        loginVw.setScene(LoginViewController.getInstance().logInButton.getScene());
        LoginViewController.getInstance().passwordField.setText("");
        LoginViewController.getInstance().userIdField.setText("");
        this.logOutButton.getScene().getWindow().hide();
        loginVw.show();
    }
    @FXML
    public void logOutButtonOnMouseExited() {
        logOutButton.setText(UserData.getInstance().getUsername());
    }
    @FXML
    public void logOutButtonOnMouseEntered() {
        logOutButton.setText("LOG OUT");
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
            convertToColumnName(pName);
            TableColumn<T, String> tableColumn = new TableColumn<>(convertToColumnName(pName));
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(pName));
            tableView.getColumns().add(tableColumn);
        }

        return tableView;
    }

    public static String convertToColumnName(String fieldName){
        String[] words = fieldName.split("(?=\\p{Upper})");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        result.replace(0,1, result.substring(0,1).toUpperCase());
        return result.toString();
    }

    private void openNewWindow(Class<?> objClass) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addPopup-view.fxml"));

        Parent newWindowRoot = loader.load();

        Stage newWindowStage = new Stage();
        newWindowStage.setTitle("Add");
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
        newWindowStage.setTitle("Edit");
        newWindowStage.setScene(new Scene(newWindowRoot));

        // Set the AddPopupController instance in the FXMLLoader
        AddPopupController popupController = loader.getController();
        // Pass any necessary data to the AddPopupController if needed
        popupController.setEditableObject(editableObject);

        newWindowStage.show();
    }

    public void reloadTableData() throws ExecutionException, InterruptedException {
        List<Vehicle> listVehicle = ApiHandler.sendGetAllRequest(Vehicle.class);
        List<Driver> listDriver = ApiHandler.sendGetAllRequest(Driver.class);
        List<Shipment> listShipment = ApiHandler.sendGetAllRequest(Shipment.class);
        List<Customer> listCustomer = ApiHandler.sendGetAllRequest(Customer.class);

        vehicleList.clear();
        vehicleList.addAll(listVehicle);

        driverList.clear();
        driverList.addAll(listDriver);

        shipmentList.clear();
        shipmentList.addAll(listShipment);

        customerList.clear();
        customerList.addAll(listCustomer);
    }
    private void setAccessibility(Boolean isAdmin){
        if (!isAdmin) {
            itemsGridPane.getChildren().add(shipmentTableView);
            shipmentButton.setSelected(true);

            clientHeader.getChildren().remove(vehiclesButton);
            clientHeader.getChildren().remove(driversButton);
            clientHeader.getChildren().remove(customersButton);
            addItemButton.setDisable(true);
            removeItemButton.setDisable(true);
            editButton.setDisable(true);

        }
        else {
            itemsGridPane.getChildren().add(vehicleTableView);
            vehiclesButton.setSelected(true);

        }

    }
}