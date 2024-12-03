package br.edu.ifsp.controller;

import java.io.IOException;

import br.edu.ifsp.app.App;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void switchToLogIn() throws IOException {
        App.setRoot("login");
    }
    
    @FXML
    private void switchToRanking() throws IOException {
        App.setRoot("ranking");
    }

}
