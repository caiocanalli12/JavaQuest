package br.edu.ifsp.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonReader {
    public static Map<String, List<Questao>> readQuestions(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        // Lê o JSON como um Map<String, List<Questao>>
        Map<String, List<Questao>> questionsMap = mapper.readValue(
            Paths.get(filePath).toFile(), 
            new TypeReference<Map<String, List<Questao>>>() {}
        );

        // Adiciona a dificuldade a cada questão baseada na chave do JSON
        for (Map.Entry<String, List<Questao>> entry : questionsMap.entrySet()) {
            String dificuldade = entry.getKey(); // "f", "m" ou "d"
            for (Questao questao : entry.getValue()) {
                questao.setDificuldade(dificuldade); // Define a dificuldade
            }
        }

        return questionsMap;
    }
}