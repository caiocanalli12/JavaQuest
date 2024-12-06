package br.edu.ifsp.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import br.edu.ifsp.classes.Questao;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonReader {
    public static Map<String, List<Questao>> readQuestions(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get(filePath).toFile(), new TypeReference<>() {});
    }
}