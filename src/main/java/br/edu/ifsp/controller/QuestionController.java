package br.edu.ifsp.controller;

import java.io.IOException;

import br.edu.ifsp.app.Main;
import javafx.fxml.FXML;

public class QuestionController {
    @FXML
    private void switchToRanking() throws IOException {
        Main.setRoot("ranking");
    }
}
