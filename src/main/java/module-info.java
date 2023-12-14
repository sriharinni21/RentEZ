module com.example.rentez {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires mysql.connector.j;
    requires com.dlsc.gmapsfx;
    requires java.net.http;
    requires org.json;
    requires javafx.web;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;

    opens com.example.rentez to javafx.fxml;
    exports com.example.rentez;
}