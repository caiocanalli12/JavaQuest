package br.edu.ifsp.controller;

import java.io.IOException;

import br.edu.ifsp.app.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RankingController {
    @FXML
    private void switchToMenu() throws IOException {
        Main.setRoot("menu");
    }
    
    @FXML
    private Label pontuacaoLabel;

    public void setPontuacao(int pontuacao) {
        pontuacaoLabel.setText("Pontuação: " + pontuacao);
    }
}