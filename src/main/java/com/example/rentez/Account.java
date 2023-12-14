package com.example.rentez;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Account extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("account.fxml")));


        Scene scene = new Scene(root, 335, 600);
        primaryStage.setTitle("Account");
        primaryStage.setScene(scene);


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void openService(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("services.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("Service");
        stage.setScene(scene);

    }
    public void openActivity(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("activity.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("Activity");
        stage.setScene(scene);
    }

    public void openHome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("userDashboard.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("Home");
        stage.setScene(scene);

    }

    public void goback(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("RentEz");
        stage.setScene(scene);
    }
}
