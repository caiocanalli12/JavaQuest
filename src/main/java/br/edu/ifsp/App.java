package br.edu.ifsp;

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
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        String caminho = "/br/edu/ifsp/fxml/" + fxml + ".fxml";
        URL arquivo = App.class.getResource(caminho);
        FXMLLoader fxmlLoader = new FXMLLoader(arquivo);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}