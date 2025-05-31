/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import java.util.List;

/*----------------------CLASSE PARA GERENCIAMENTO DE PARTIDA-----------------*/
public class Partida {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private Integer capacidadeMaxima;
    private List<String> jogadores;
    private char codigo;
    private Boolean partidaIniciada;
    private Integer pontuacaoAtual;
    private Integer pontuacaoFinal;

    /*----------------------MÉTODO PARA OBTER CAPACIDADE MÁXIMA----------*/
    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /*----------------------MÉTODO PARA DEFINIR CAPACIDADE MÁXIMA--------*/
    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /*----------------------MÉTODO PARA OBTER LISTA DE JOGADORES---------*/
    public List<String> getJogadores() {
        return jogadores;
    }

    /*----------------------MÉTODO PARA DEFINIR LISTA DE JOGADORES-------*/
    public void setJogadores(List<String> jogadores) {
        this.jogadores = jogadores;
    }

    /*----------------------MÉTODO PARA OBTER CÓDIGO DA PARTIDA---------*/
    public char getCodigo() {
        return codigo;
    }

    /*----------------------MÉTODO PARA DEFINIR CÓDIGO DA PARTIDA-------*/
    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    /*----------------------MÉTODO PARA OBTER STATUS DA PARTIDA---------*/
    public Boolean getPartidaIniciada() {
        return partidaIniciada;
    }

    /*----------------------MÉTODO PARA DEFINIR STATUS DA PARTIDA-------*/
    public void setPartidaIniciada(Boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }

    /*----------------------MÉTODO PARA OBTER PONTUAÇÃO ATUAL-----------*/
    public Integer getPontuacaoAtual() {
        return pontuacaoAtual;
    }

    /*----------------------MÉTODO PARA DEFINIR PONTUAÇÃO ATUAL---------*/
    public void setPontuacaoAtual(Integer pontuacaoAtual) {
        this.pontuacaoAtual = pontuacaoAtual;
    }

    /*----------------------MÉTODO PARA OBTER PONTUAÇÃO FINAL-----------*/
    public Integer getPontuacaoFinal() {
        return pontuacaoFinal;
    }

    /*----------------------MÉTODO PARA DEFINIR PONTUAÇÃO FINAL---------*/
    public void setPontuacaoFinal(Integer pontuacaoFinal) {
        this.pontuacaoFinal = pontuacaoFinal;
    }

    /*----------------------CONSTRUTOR DA CLASSE PARTIDA----------------*/
    public Partida(Integer capacidadeMaxima, List<String> jogadores, char codigo, Boolean partidaIniciada, Integer pontuacaoAtual, Integer pontuacaoFinal) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.jogadores = jogadores;
        this.codigo = codigo;
        this.partidaIniciada = partidaIniciada;
        this.pontuacaoAtual = pontuacaoAtual;
        this.pontuacaoFinal = pontuacaoFinal;
    }
    
    /*----------------------MÉTODO PARA INICIAR PARTIDA-----------------*/
    public void iniciarPartida(){
        
    }
    
    /*----------------------MÉTODO PARA ENCERRAR PARTIDA---------------*/
    public void encerrarPartida(){
        
    }
    
    /*----------------------MÉTODO PARA APLICAR PONTUAÇÃO--------------*/
    public void aplicaPontuacao(){
        
    }
    
    /*----------------------MÉTODO PARA HABILITAR DICAS---------------*/
    public void habilitarDicas(){
        
    }
    
    /*----------------------MÉTODO PARA VERIFICAR QUANTIDADE DE JOGADORES---*/
    public void verificarQuantidadeJogadores(){
        
    }
    
    /*----------------------MÉTODO PARA REMOVER JOGADOR---------------*/
    public void removerJogador(){
        
    }
    
    /*----------------------MÉTODO PARA VERIFICAR CONCLUSÃO DA PARTIDA---*/
    public void partidaConcluida(){
    
    }
    
    /*----------------------MÉTODO PARA AVANÇAR PARA PRÓXIMA PERGUNTA---*/
    public void proximaPergunta(){
        
    }
    
    /*----------------------MÉTODO PARA ENCERRAR QUESTIONÁRIO----------*/
    public void encerrarQuestionario(){
        
    }
}