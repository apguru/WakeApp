package com.example.wakeapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultController {
    @FXML private Label hours_answer;

    @FXML
    public void ResultController() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resultView.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setOpacity(1);
        stage.setTitle("WakeApp Resultat");
        stage.setScene(new Scene(root,700, 800));
        stage.show();

        System.out.println(hours_answer);
    }

    public void setHours(String text) {
        hours_answer.setText(text);
    }
}
