package br.edu.ifsp.app;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;                                       
import javafx.stage.Stage;                                       

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        String path = "/br/edu/ifsp/fxml/"+ fxml + ".fxml";
        System.out.println(path);
        URL archive = App.class.getResource(path);
        System.out.println(archive);
        FXMLLoader fxmlLoader = new FXMLLoader(archive);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}