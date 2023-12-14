package com.example.rentez;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UserDashboard extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UserDashboard.fxml")));


        Scene scene = new Scene(root, 335, 600);
        primaryStage.setTitle("User Dashboard");
        primaryStage.setScene(scene);


        primaryStage.show();
    }


    public void openService(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("services.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("Service");
        stage.setScene(scene);

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void openActivity(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("activity.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("Activity");
        stage.setScene(scene);
    }

    public void openAccount(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("account.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("Account");
        stage.setScene(scene);
    }

    public void onRental(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
