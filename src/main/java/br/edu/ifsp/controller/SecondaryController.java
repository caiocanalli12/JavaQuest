package br.edu.ifsp.controller;

import java.io.IOException;

import br.edu.ifsp.app.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToTertiary() throws IOException {
        App.setRoot("tertiary");
    }
}