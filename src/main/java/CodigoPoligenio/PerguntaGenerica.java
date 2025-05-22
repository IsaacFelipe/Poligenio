package CodigoPoligenio;

public class PerguntaGenerica {

    private char alternativa;
    private int idPerguntaRandom;
    private String enunciado;
    private boolean respostaCorreta;
    private int pontuacao;

    public char getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(char alternativa) {
        this.alternativa = alternativa;
    }

    public int getIdPerguntaRandom() {
        return idPerguntaRandom;
    }

    public void setIdPerguntaRandom(int idPerguntaRandom) {
        this.idPerguntaRandom = idPerguntaRandom;
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

    public void verificarResposta() {
    }
}