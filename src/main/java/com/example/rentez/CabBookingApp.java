package com.example.rentez;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class CabBookingApp extends Application {

    private Label resultLabel = new Label();
    private TextField userInputField = new TextField();
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        Label titleLabel = new Label("Book Your Cabs");
        titleLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        userInputField.setPromptText("Search");
        Button viewAvailabilityButton = new Button("Click to View");
        viewAvailabilityButton.setOnAction(e -> fetchDataAsync(userInputField.getText()));

        Label instructionLabel = new Label("Click to see the availability");

        VBox root = new VBox(10, titleLabel, new HBox(userInputField, viewAvailabilityButton), instructionLabel, resultLabel);
        root.setMinSize(335, 600);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Available Cabs");
        primaryStage.show();
    }

    private void showCabList(ArrayList<Cab> cabList) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cab-list.fxml"));
        Scene scene = new Scene(root);
        VBox pane = (VBox) scene.lookup("#cablist");

        for (Cab cab : cabList) {
            Parent boxRoot = FXMLLoader.load(getClass().getResource("cab-location.fxml"));
            Scene boxScene = new Scene(boxRoot);
            TextField location = (TextField) boxScene.lookup("#location");
            TextField latitude = (TextField) boxScene.lookup("#latitude");
            TextField longitude = (TextField) boxScene.lookup("#longitude");
            TextField district = (TextField) boxScene.lookup("#district");

            location.setText(cab.city);
            latitude.setText(cab.country);
            longitude.setText(cab.type);
            district.setText(cab.name);
            pane.getChildren().add(boxRoot);
        }

        stage.setScene(scene);
        stage.show();
    }

    private void fetchDataAsync(String userInput) {
        Service<String> fetchDataService = new Service<>() {
            @Override
            protected Task<String> createTask() {
                return new Task<>() {
                    @Override
                    protected String call() throws Exception {
                        String query = userInput.replace(" ", "%20");

                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create("https://booking-com15.p.rapidapi.com/api/v1/cars/searchDestination?query=" + query))
                                .header("X-RapidAPI-Key", "45633bc6f2mshec495acb5cfa7e6p1b0f03jsn6cacddfd871e")
                                .header("X-RapidAPI-Host", "booking-com15.p.rapidapi.com")
                                .method("GET", HttpRequest.BodyPublishers.noBody())
                                .build();

                        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                        return response.body();
                    }
                };
            }
        };

        fetchDataService.setOnSucceeded(event -> {
            String result = fetchDataService.getValue();

            Platform.runLater(() -> {
                resultLabel.setText("Result:\n" + result);

                Gson gson = new Gson();
                CabDetails details = gson.fromJson(result, CabDetails.class);
                System.out.println(details.status);
                System.out.println(details.message);

                if (details.status) {
                    try {
                        showCabList(details.data);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    resultLabel.setText("Error: " + details.message);
                }
            });
        });

        fetchDataService.setOnFailed(event -> {
            Throwable exception = fetchDataService.getException();
            exception.printStackTrace();

            Platform.runLater(() -> resultLabel.setText("Error fetching data. Check your internet connectivity"));
        });

        fetchDataService.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
