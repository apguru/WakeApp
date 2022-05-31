package com.example.wakeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IndexController {

    @FXML private TextField standort;
    @FXML private TextField zielort;
    @FXML private TextField ankunftszeit;

    @FXML
    private void handleButtonBerechnen(ActionEvent event) {
        System.out.println("Standort:" + standort.getText());
        System.out.println("Zielort:" + zielort.getText());
        System.out.println("Ankuftszeit:" + ankunftszeit.getText());
    }


}