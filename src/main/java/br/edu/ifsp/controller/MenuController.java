package br.edu.ifsp.controller;

import java.io.IOException;

import br.edu.ifsp.app.Main;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void switchToLogIn() throws IOException {
        Main.setRoot("login");
    }
    
    @FXML
    private void switchToRanking() throws IOException {
        Main.setRoot("ranking");
    }

}
