package com.example.wakeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IndexController {

    @FXML public TextField startLocation;
    @FXML public TextField destinationLocation;
    @FXML public TextField arrivalTime;

    @FXML
    private void handleButtonBerechnen(ActionEvent event) {
        System.out.println("Standort:" + startLocation.getText());
        System.out.println("Zielort:" + destinationLocation.getText());
        System.out.println("Ankuftszeit:" + arrivalTime.getText());
    }


}