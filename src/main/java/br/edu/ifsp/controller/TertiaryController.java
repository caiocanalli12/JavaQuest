package br.edu.ifsp.controller;

import java.io.IOException;

import br.edu.ifsp.app.App;
import javafx.fxml.FXML;

public class TertiaryController {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
