/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------CLASSE PARA GERENCIAMENTO DE PERGUNTAS CRIADAS-------*/
public class PerguntaCriada {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private int dificuldade;
    private char alternativa;
    private String enunciado;
    private boolean respostaCorreta;
    private int pontuacao;
    private Materia materia;

    /*----------------------MÉTODO PARA OBTER DIFICULDADE----------------*/
    public int getDificuldade() {
        return dificuldade;
    }

    /*----------------------MÉTODO PARA DEFINIR DIFICULDADE--------------*/
    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    /*----------------------MÉTODO PARA OBTER ALTERNATIVA---------------*/
    public char getAlternativa() {
        return alternativa;
    }

    /*----------------------MÉTODO PARA DEFINIR ALTERNATIVA-------------*/
    public void setAlternativa(char alternativa) {
        this.alternativa = alternativa;
    }

    /*----------------------MÉTODO PARA OBTER ENUNCIADO-----------------*/
    public String getEnunciado() {
        return enunciado;
    }

    /*----------------------MÉTODO PARA DEFINIR ENUNCIADO---------------*/
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /*----------------------MÉTODO PARA VERIFICAR RESPOSTA CORRETA------*/
    public boolean isRespostaCorreta() {
        return respostaCorreta;
    }

    /*----------------------MÉTODO PARA DEFINIR RESPOSTA CORRETA--------*/
    public void setRespostaCorreta(boolean respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    /*----------------------MÉTODO PARA OBTER PONTUAÇÃO-----------------*/
    public int getPontuacao() {
        return pontuacao;
    }

    /*----------------------MÉTODO PARA DEFINIR PONTUAÇÃO---------------*/
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    /*----------------------MÉTODO PARA OBTER MATÉRIA-------------------*/
    public Materia getMateria() {
        return materia;
    }

    /*----------------------MÉTODO PARA DEFINIR MATÉRIA-----------------*/
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /*----------------------MÉTODO PARA VERIFICAR RESPOSTA--------------*/
    public void verificarResposta() {
    }
}