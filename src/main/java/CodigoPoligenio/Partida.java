package CodigoPoligenio;

import java.util.List;

public class Partida {
    
    private Integer capacidadeMaxima;
    private List<String> jogadores;
    private char codigo;
    private Boolean partidaIniciada;
    private Integer pontuacaoAtual;
    private Integer pontuacaoFinal;

    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public List<String> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<String> jogadores) {
        this.jogadores = jogadores;
    }

    public char getCodigo() {
        return codigo;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    public Boolean getPartidaIniciada() {
        return partidaIniciada;
    }

    public void setPartidaIniciada(Boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }

    public Integer getPontuacaoAtual() {
        return pontuacaoAtual;
    }

    public void setPontuacaoAtual(Integer pontuacaoAtual) {
        this.pontuacaoAtual = pontuacaoAtual;
    }

    public Integer getPontuacaoFinal() {
        return pontuacaoFinal;
    }

    public void setPontuacaoFinal(Integer pontuacaoFinal) {
        this.pontuacaoFinal = pontuacaoFinal;
    }

    public Partida(Integer capacidadeMaxima, List<String> jogadores, char codigo, Boolean partidaIniciada, Integer pontuacaoAtual, Integer pontuacaoFinal) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.jogadores = jogadores;
        this.codigo = codigo;
        this.partidaIniciada = partidaIniciada;
        this.pontuacaoAtual = pontuacaoAtual;
        this.pontuacaoFinal = pontuacaoFinal;
    }
    
    public void iniciarPartida(){
        
    }
    
    public void encerrarPartida(){
        
    }
    
    public void aplicaPontuacao(){
        
        
    }
    
    public void habilitarDicas(){
        
    }
    
    public void verificarQuantidadeJogadores(){
        
    }
    
    public void removerJogador(){
        
    }
    
    public void partidaConcluida(){
    
    }
    
    public void proximaPergunta(){
        
    }
    
    public void encerrarQuestionario(){
        

    }
}
