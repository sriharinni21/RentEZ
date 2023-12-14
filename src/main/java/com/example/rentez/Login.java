package com.example.rentez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        primaryStage.setTitle("Rentez");
        primaryStage.setScene(new Scene(root, 335, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

