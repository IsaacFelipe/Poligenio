/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------CLASSE PARA GERENCIAMENTO DE PERGUNTAS GENÉRICAS------*/
public class PerguntaGenerica {
    
/*----------------------DECLARAÇÃO DE VARIÁVEIS-------------------------------*/
    private char alternativa;
    private int idPerguntaRandom;
    private String enunciado;
    private boolean respostaCorreta;
    private int pontuacao;

/*----------------------MÉTODO PARA OBTER ALTERNATIVA-------------------------*/
    public char getAlternativa() {
        return alternativa;
    }

/*----------------------MÉTODO PARA DEFINIR ALTERNATIVA-----------------------*/
    public void setAlternativa(char alternativa) {
        this.alternativa = alternativa;
    }

/*----------------------MÉTODO PARA OBTER ID DA PERGUNTA----------------------*/
    public int getIdPerguntaRandom() {
        return idPerguntaRandom;
    }

/*----------------------MÉTODO PARA DEFINIR ID DA PERGUNTA--------------------*/
    public void setIdPerguntaRandom(int idPerguntaRandom) {
        this.idPerguntaRandom = idPerguntaRandom;
    }

/*----------------------MÉTODO PARA OBTER ENUNCIADO---------------------------*/
    public String getEnunciado() {
        return enunciado;
    }

/*----------------------MÉTODO PARA DEFINIR ENUNCIADO-------------------------*/
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

/*----------------------MÉTODO PARA VERIFICAR RESPOSTA CORRETA----------------*/
    public boolean isRespostaCorreta() {
        return respostaCorreta;
    }

/*----------------------MÉTODO PARA DEFINIR RESPOSTA CORRETA------------------*/
    public void setRespostaCorreta(boolean respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

/*----------------------MÉTODO PARA OBTER PONTUAÇÃO---------------------------*/
    public int getPontuacao() {
        return pontuacao;
    }

/*----------------------MÉTODO PARA DEFINIR PONTUAÇÃO-------------------------*/
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

/*----------------------MÉTODO PARA VERIFICAR RESPOSTA------------------------*/
    public void verificarResposta() {
    }
}