package br.edu.ifsp.controller;

import java.io.IOException;

import br.edu.ifsp.app.Main;
import javafx.fxml.FXML;

public class LogInController {

    @FXML
    private void switchToQuestion() throws IOException {
        Main.setRoot("question");
    }

}