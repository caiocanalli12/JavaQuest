package br.edu.ifsp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.edu.ifsp.app.Main;
import br.edu.ifsp.classes.JsonReader;
import br.edu.ifsp.classes.Questao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class QuestionController implements Initializable{

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

    @FXML
    private void switchToRanking() throws IOException {
        Main.setRoot("ranking");
    }

    @FXML 
    private void proximaPergunta() throws IOException {
        Main.setRoot("question");
    }

    @FXML
    private void checarResposta() throws IOException {
        String filePath = "src/main/resources/perguntas.json";

        try {
            Map<String, List<Questao>> questionsMap = JsonReader.readQuestions(filePath);

            Object[] categories = questionsMap.keySet().toArray();
            String randomCategory = (String) categories[new Random().nextInt(categories.length)];

            List<Questao> questions = questionsMap.get(randomCategory);
            Questao randomQuestion = questions.get(new Random().nextInt(questions.size()));
            
            if (botaoR1.getText().equals(randomQuestion.getCorreta())) {
                botaoR1.setTextFill(javafx.scene.paint.Color.GREEN);
                botaoR2.setTextFill(javafx.scene.paint.Color.RED);
                botaoR3.setTextFill(javafx.scene.paint.Color.RED);
                botaoR4.setTextFill(javafx.scene.paint.Color.RED);
            } else if (botaoR2.getText().equals(randomQuestion.getCorreta())) {
                botaoR1.setTextFill(javafx.scene.paint.Color.RED);
                botaoR2.setTextFill(javafx.scene.paint.Color.GREEN);
                botaoR3.setTextFill(javafx.scene.paint.Color.RED);
                botaoR4.setTextFill(javafx.scene.paint.Color.RED);
            } else if (botaoR3.getText().equals(randomQuestion.getCorreta())) {
                botaoR1.setTextFill(javafx.scene.paint.Color.RED);
                botaoR2.setTextFill(javafx.scene.paint.Color.RED);
                botaoR3.setTextFill(javafx.scene.paint.Color.GREEN);
                botaoR4.setTextFill(javafx.scene.paint.Color.RED);
            }  else if (botaoR4.getText().equals(randomQuestion.getCorreta())) {
                botaoR1.setTextFill(javafx.scene.paint.Color.RED);
                botaoR2.setTextFill(javafx.scene.paint.Color.RED);
                botaoR3.setTextFill(javafx.scene.paint.Color.RED);
                botaoR4.setTextFill(javafx.scene.paint.Color.GREEN);
            }
            
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }

    }
    
    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {

        String filePath = "src/main/resources/perguntas.json";

        try {
            Map<String, List<Questao>> questionsMap = JsonReader.readQuestions(filePath);
            Object[] categories = questionsMap.keySet().toArray();
            String randomCategory = (String) categories[new Random().nextInt(categories.length)];

            List<Questao> questions = questionsMap.get(randomCategory);
            Questao randomQuestion = questions.get(new Random().nextInt(questions.size()));
            
            pergunta.setText(randomQuestion.getPergunta());
            botaoR1.setText(randomQuestion.getAlternativas().get(0));
            botaoR2.setText(randomQuestion.getAlternativas().get(1));
            botaoR3.setText(randomQuestion.getAlternativas().get(2));
            botaoR4.setText(randomQuestion.getAlternativas().get(3));

            if (botaoR1.getText().equals(randomQuestion.getCorreta())) {
                botaoR1.setTextFill(javafx.scene.paint.Color.GREEN);
                botaoR2.setTextFill(javafx.scene.paint.Color.RED);
                botaoR3.setTextFill(javafx.scene.paint.Color.RED);
                botaoR4.setTextFill(javafx.scene.paint.Color.RED);
            } else if (botaoR2.getText().equals(randomQuestion.getCorreta())) {
                botaoR1.setTextFill(javafx.scene.paint.Color.RED);
                botaoR2.setTextFill(javafx.scene.paint.Color.GREEN);
                botaoR3.setTextFill(javafx.scene.paint.Color.RED);
                botaoR4.setTextFill(javafx.scene.paint.Color.RED);
            } else if (botaoR3.getText().equals(randomQuestion.getCorreta())) {
                botaoR1.setTextFill(javafx.scene.paint.Color.RED);
                botaoR2.setTextFill(javafx.scene.paint.Color.RED);
                botaoR3.setTextFill(javafx.scene.paint.Color.GREEN);
                botaoR4.setTextFill(javafx.scene.paint.Color.RED);
            }  else if (botaoR4.getText().equals(randomQuestion.getCorreta())) {
                botaoR1.setTextFill(javafx.scene.paint.Color.RED);
                botaoR2.setTextFill(javafx.scene.paint.Color.RED);
                botaoR3.setTextFill(javafx.scene.paint.Color.RED);
                botaoR4.setTextFill(javafx.scene.paint.Color.GREEN);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }

    }
}
