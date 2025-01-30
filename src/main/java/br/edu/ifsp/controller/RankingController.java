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

    private int pontuacao;

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
        atualizarPontuacao();
    }

    private void atualizarPontuacao() {
        pontuacaoLabel.setText("Pontuação: " + pontuacao);
    }
}