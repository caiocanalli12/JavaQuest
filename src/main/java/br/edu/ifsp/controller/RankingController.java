package br.edu.ifsp.controller;

import java.io.IOException;

import br.edu.ifsp.app.App;
import javafx.fxml.FXML;

public class RankingController {
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }
    
}