    package com.example.rentez;

    import javafx.event.ActionEvent;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.util.Objects;

    public class CabList {

        public void openActivity(ActionEvent actionEvent) throws IOException {
            Stage stage = (Stage) (((Button) actionEvent.getSource()).getScene().getWindow());
            Parent serviceView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("activity.fxml")));
            Scene scene = new Scene(serviceView);
            stage.setTitle("Activity");
            stage.setScene(scene);
        }
    }
