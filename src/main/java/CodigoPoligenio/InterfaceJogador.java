/*----------------------PACOTE QUE PERTENCE A INTERFACE--------------------------*/
package CodigoPoligenio;

/*----------------------INTERFACE PARA DEFINIÇÃO DE MÉTODOS DO JOGADOR-----------------*/
public interface InterfaceJogador {
    
    /*----------------------MÉTODO PARA INICIAR JOGO--------------------------*/
    void jogar();
    
    /*----------------------MÉTODO PARA CONSULTAR PONTUAÇÃO------------------*/
    void consultarPontuacao();
    
    /*----------------------MÉTODO PARA REALIZAR LOGIN-----------------------*/
    boolean fazerLogin(String nome, String Senha);
    
    /*----------------------MÉTODO PARA ESCOLHER ALTERNATIVA----------------*/
    void escolherAlternativa();
    
    /*----------------------MÉTODO PARA SOLICITAR DESISTÊNCIA---------------*/
    void solicitarDesistencia();
    
    /*----------------------MÉTODO PARA RESPONDER ALTERNATIVA--------------*/
    void responderAlternativa();
}