package com.example.rentez;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Activity extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("activity.fxml")));

        Scene scene = new Scene(root, 335, 600);
        primaryStage.setTitle("Activity");
        primaryStage.setScene(scene);

        primaryStage.show();
        displayUserDetails();
    }

    private void displayUserDetails() {
        String sql = "SELECT * FROM rentalhistory WHERE `Booking id` = '0912202301'";

        try (Connection connect = database.connectDB();
             Statement statement = connect.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            String bookingId = resultSet.getString("Booking id");
            String droploc = resultSet.getString("Drop Location");
            String cost = resultSet.getString("Total cost");
            System.out.println("Booking ID: " + bookingId);
            System.out.println("Destination: " + droploc);
            System.out.println("Price: " + cost);


        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void openHome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("userDashboard.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("Home");
        stage.setScene(scene);

    }
    public void openService(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("services.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("Service");
        stage.setScene(scene);

    }
    public void openAccount(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
        Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("account.fxml")));
        Scene scene = new Scene(serviceView);
        stage.setTitle("Account");
        stage.setScene(scene);
    }
}

