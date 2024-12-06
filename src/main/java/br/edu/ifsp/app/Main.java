package br.edu.ifsp.app;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.edu.ifsp.classes.JsonReader;
import br.edu.ifsp.classes.Questao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;                                       
import javafx.stage.Stage;                                       

/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        String path = "/br/edu/ifsp/fxml/"+ fxml + ".fxml";
        System.out.println(path);
        URL archive = Main.class.getResource(path);
        System.out.println(archive);
        FXMLLoader fxmlLoader = new FXMLLoader(archive);
        return fxmlLoader.load();
    }

    
    public static void main(String[] args) {

        String filePath = "src/main/resources/perguntas.json";

        try {

    //exemplo de leitura do arquivo JSON
    
            Map<String, List<Questao>> questionsMap = JsonReader.readQuestions(filePath);

            // Seleciona uma categoria aleatória
            Object[] categories = questionsMap.keySet().toArray();
            String randomCategory = (String) categories[new Random().nextInt(categories.length)];

            // Seleciona uma pergunta aleatória da categoria
            List<Questao> questions = questionsMap.get(randomCategory);
            Questao randomQuestion = questions.get(new Random().nextInt(questions.size()));

            // Exibe a pergunta
            System.out.println("Pergunta: " + randomQuestion.getPergunta());
            System.out.println("Alternativas:");
            for (int i = 0; i < randomQuestion.getAlternativas().size(); i++) {
                System.out.println((i + 1) + ". " + randomQuestion.getAlternativas().get(i));
            }
            System.out.println("Resposta correta: " + randomQuestion.getCorreta());

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }

    //aqui acaba o exemplo

        launch();
    }

}