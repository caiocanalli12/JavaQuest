package br.edu.ifsp.classes;

import java.util.List;

public class Questao {
    private String pergunta;
    private List<String> alternativas;
    private String correta;

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<String> alternativas) {
        this.alternativas = alternativas;
    }

    public String getCorreta() {
        return correta;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
    }
}
