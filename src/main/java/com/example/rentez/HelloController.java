package com.example.rentez;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {


    public Pane startPane;


    public void getStarted(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)(((Button)actionEvent.getSource()).getScene().getWindow());

        Parent loginView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));

        Scene scene = new Scene(loginView);
        stage.setTitle("RentEz");
        stage.setScene(scene);
    }
}