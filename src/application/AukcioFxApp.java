package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AukcioFxApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/aukcio-pane.fxml"));
        Pane pane = fxmlLoader.load();

        Scene scene = new Scene(pane, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Aukciós tételek");
        stage.show();
    }
}
