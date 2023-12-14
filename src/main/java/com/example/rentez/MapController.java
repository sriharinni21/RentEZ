package com.example.rentez;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.javascript.object.GoogleMap;
import com.dlsc.gmapsfx.javascript.object.LatLong;
import com.dlsc.gmapsfx.javascript.object.MapOptions;
import com.dlsc.gmapsfx.javascript.object.MapTypeIdEnum;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class MapController implements Initializable {

    @FXML
    private TextField latitudeInput;

    @FXML
    private TextField longitudeInput;

    @FXML
    private GoogleMapView googleMapView;

    private GoogleMap map;

    private DecimalFormat formatter = new DecimalFormat("###.00000");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        googleMapView.addMapInitializedListener(() -> configureMap());
    }

    protected void configureMap() {
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoom(9);
        googleMapView = new GoogleMapView("AIzaSyAho6pQe0NlNrshqJSvYB8yEkAEF4ryycM");
        map = googleMapView.createMap(mapOptions, false);

        AnchorPane.setTopAnchor(googleMapView, 21.0);
        AnchorPane.setLeftAnchor(googleMapView, 14.0);
        AnchorPane.setRightAnchor(googleMapView, 14.0);
        AnchorPane.setBottomAnchor(googleMapView, 14.0);
        ((AnchorPane) googleMapView.getParent()).getChildren().add(googleMapView);

    }

    @FXML
    protected void setLocation() {
        try {
            double latitude = Double.parseDouble(latitudeInput.getText());
            double longitude = Double.parseDouble(longitudeInput.getText());

            updateMapLocation(latitude, longitude);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.");
        }
    }

    private void updateMapLocation(double latitude, double longitude) {
        LatLong userLocation = new LatLong(latitude, longitude);
        map.setCenter(userLocation);
        latitudeInput.setText(formatter.format(latitude));
        longitudeInput.setText(formatter.format(longitude));
    }
}

