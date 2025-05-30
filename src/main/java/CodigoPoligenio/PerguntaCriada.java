package CodigoPoligenio;

public class PerguntaCriada {
    private int dificuldade;
    private char alternativa;
    private String enunciado;
    private boolean respostaCorreta;
    private int pontuacao;
    private Materia materia;

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public char getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(char alternativa) {
        this.alternativa = alternativa;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public boolean isRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(boolean respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void verificarResposta() {
    }
}
