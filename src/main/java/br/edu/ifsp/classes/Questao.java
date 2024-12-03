package br.edu.ifsp.classes;

public class Questao {
    private char dificuldade;
    private String pergunta;
    private String alternativa1;
    private String alternativa2;
    private String alternativa3;
    private String alternativa4;
    private String correta;

    public Questao(char dificuldade, String pergunta, String alternativa1, String alternativa2, String alternativa3, String alternativa4, String correta) {
        this.dificuldade = dificuldade;
        this.pergunta = pergunta;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
        this.correta = correta;
    }
    
    
}
