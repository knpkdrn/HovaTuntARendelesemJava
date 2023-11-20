// AddPopupController.java
package com.example.hovatuntarendelesemjava;

import com.example.hovatuntarendelesemjava.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class AddPopupController {
    private Class objClass;
    private HTARJModelBase editableObject;
    private ArrayList<TextField> textFieldList = new ArrayList<>();

    @FXML
    private VBox fieldsVBox;

    @FXML
    void initialize() {
        Platform.runLater(
                () -> {
                    if (editableObject == null) {
                        //DEBUG MESSAGE
                        System.out.println("ADDING");
                        textFieldList.clear();
                        for (Field f : objClass.getDeclaredFields()) {
                            TextField textField = new TextField();
                            textField.setPromptText(f.getName());
                            fieldsVBox.getChildren().add(textField);
                            textFieldList.add(textField);
                        }
                    } else {
                        //DEBUG MESSAGE
                        System.out.println("EDITING");
                        textFieldList.clear();
                        for (Field f : editableObject.getClass().getDeclaredFields()) {
                            TextField textField = new TextField();
                            textField.setPromptText(f.getName());
                            String getterName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                            try {
                                Method getter = editableObject.getClass().getDeclaredMethod(getterName);
                                textField.setText(getter.invoke(editableObject).toString());
                            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException nsme) {
                                System.out.println(nsme.getMessage());
                            }

                            fieldsVBox.getChildren().add(textField);
                            textFieldList.add(textField);
                        }
                    }
                }
        );
    }

    // Add more fields for other attributes
    public void setObjClass(Class objClass) {
        this.objClass = objClass;
        editableObject = null;
    }

    public void setEditableObject(HTARJModelBase object) {
        editableObject = object;
        objClass = null;
    }

    @FXML
    private void onSaveButtonClicked() {
        // Retrieve data from TextFields and save it to the corresponding TableView
        String[] paramsList = new String[textFieldList.size()];
        int i = 0;
        for (TextField tf : textFieldList) {
            paramsList[i] = tf.getText();
            ++i;
        }

        if (objClass == Vehicle.class) {
            MainViewController.getInstance().getVehicleList().add(
                    new Vehicle(paramsList)
                    // Create a new Vehicle object with data from TextFields
            );
        } else if (objClass == Driver.class) {
            MainViewController.getInstance().getDriverList().add(
                    new Driver(paramsList)
                    // Create a new Vehicle object with data from TextFields
            );
        } else if (objClass == Shipment.class) {
            MainViewController.getInstance().getShipmentList().add(
                    new Shipment(paramsList)
                    // Create a new Vehicle object with data from TextFields
            );
        } else if (objClass == Customer.class) {
            MainViewController.getInstance().getCustomerList().add(
                    new Customer(paramsList)
                    // Create a new Vehicle object with data from TextFields
            );
        } else {
            editableObject.setAllFields(paramsList);
        }

        fieldsVBox.getScene().getWindow().hide();
        MainViewController.getInstance().refreshTable();
    }
}