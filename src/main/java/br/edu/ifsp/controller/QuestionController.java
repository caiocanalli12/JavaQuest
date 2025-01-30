package br.edu.ifsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.edu.ifsp.app.Main;
import br.edu.ifsp.classes.JsonReader;
import br.edu.ifsp.classes.Questao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class QuestionController implements Initializable {

    @FXML
    private Label pergunta;

    @FXML
    private Button botaoR1;

    @FXML
    private Button botaoR2;

    @FXML
    private Button botaoR3;

    @FXML
    private Button botaoR4;

    @FXML
    private Button proximaPergunta;

    private List<Questao> perguntasSelecionadas = new ArrayList<>();
    private int perguntaAtualIndex = 0;
    public int pontuacao = 0;

    @FXML
    private void switchToRanking() {
        try {
            RankingController rankingController = Main.setRoot("ranking");
            rankingController.setPontuacao(pontuacao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void proximaPergunta() {
        perguntaAtualIndex++;
        if (perguntaAtualIndex < perguntasSelecionadas.size()) {
            carregarPergunta(perguntasSelecionadas.get(perguntaAtualIndex));
            habilitarBotoesResposta(); // Reabilita os botões de resposta para a próxima pergunta
        } else {
            System.out.println("Fim do jogo! Pontuação total: " + pontuacao);
            switchToRanking();
        }
        proximaPergunta.setDisable(true);
    }

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        String filePath = "src/main/resources/perguntas.json";

        try {
            Map<String, List<Questao>> questionsMap = JsonReader.readQuestions(filePath);

            List<Questao> faceis = questionsMap.get("f");
            List<Questao> medias = questionsMap.get("m");
            List<Questao> dificeis = questionsMap.get("d");

            Collections.shuffle(faceis);
            Collections.shuffle(medias);
            Collections.shuffle(dificeis);

            perguntasSelecionadas.addAll(faceis.subList(0, Math.min(5, faceis.size())));
            perguntasSelecionadas.addAll(medias.subList(0, Math.min(3, medias.size())));
            perguntasSelecionadas.addAll(dificeis.subList(0, Math.min(2, dificeis.size())));

            Collections.shuffle(perguntasSelecionadas);

            carregarPergunta(perguntasSelecionadas.get(perguntaAtualIndex));
            proximaPergunta.setDisable(true);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }

    private void carregarPergunta(Questao questao) {
        pergunta.setText(questao.getPergunta());
        botaoR1.setText(questao.getAlternativas().get(0));
        botaoR2.setText(questao.getAlternativas().get(1));
        botaoR3.setText(questao.getAlternativas().get(2));
        botaoR4.setText(questao.getAlternativas().get(3));

        botaoR1.setTextFill(javafx.scene.paint.Color.BLACK);
        botaoR2.setTextFill(javafx.scene.paint.Color.BLACK);
        botaoR3.setTextFill(javafx.scene.paint.Color.BLACK);
        botaoR4.setTextFill(javafx.scene.paint.Color.BLACK);
    }

    @FXML
    private void checarResposta(javafx.event.ActionEvent event) {
        Button botaoSelecionado = (Button) event.getSource();
        verificarResposta(botaoSelecionado, perguntasSelecionadas.get(perguntaAtualIndex));
        desabilitarBotoesResposta(); // Desabilita os botões de resposta após a seleção
    }

    private void verificarResposta(Button botaoSelecionado, Questao questao) {
        botaoR1.setTextFill(javafx.scene.paint.Color.BLACK);
        botaoR2.setTextFill(javafx.scene.paint.Color.BLACK);
        botaoR3.setTextFill(javafx.scene.paint.Color.BLACK);
        botaoR4.setTextFill(javafx.scene.paint.Color.BLACK);

        if (botaoSelecionado.getText().equals(questao.getCorreta())) {
            botaoSelecionado.setTextFill(javafx.scene.paint.Color.GREEN);
            
            if (questao.getDificuldade().equals("f")) {
                pontuacao += 1;
            } else if (questao.getDificuldade().equals("m")) {
                pontuacao += 2;
            } else if (questao.getDificuldade().equals("d")) {
                pontuacao += 3;
            }

        } else {
            botaoSelecionado.setTextFill(javafx.scene.paint.Color.RED);

            if (botaoR1.getText().equals(questao.getCorreta())) {
                botaoR1.setTextFill(javafx.scene.paint.Color.GREEN);
            } else if (botaoR2.getText().equals(questao.getCorreta())) {
                botaoR2.setTextFill(javafx.scene.paint.Color.GREEN);
            } else if (botaoR3.getText().equals(questao.getCorreta())) {
                botaoR3.setTextFill(javafx.scene.paint.Color.GREEN);
            } else if (botaoR4.getText().equals(questao.getCorreta())) {
                botaoR4.setTextFill(javafx.scene.paint.Color.GREEN);
            }
        }
        
        proximaPergunta.setDisable(false);
    }

    private void desabilitarBotoesResposta() {
        botaoR1.setDisable(true);
        botaoR2.setDisable(true);
        botaoR3.setDisable(true);
        botaoR4.setDisable(true);
    }

    private void habilitarBotoesResposta() {
        botaoR1.setDisable(false);
        botaoR2.setDisable(false);
        botaoR3.setDisable(false);
        botaoR4.setDisable(false);
    }
}