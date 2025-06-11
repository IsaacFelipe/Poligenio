/*-------------------PACOTE QUE PERTENCE A INTERFACE--------------------------*/
package CodigoPoligenio;

/*-------------INTERFACE PARA DEFINIÇÃO DE MÉTODOS DO JOGADOR-----------------*/
public interface InterfaceJogador {
    
/*----------------------MÉTODO PARA REALIZAR LOGIN----------------------------*/
    boolean fazerLogin(String nome, String Senha);
    
/*--------------------------MÉTODO PARA SOLICITAR DESISTÊNCIA-----------------*/
    void solicitarDesistencia();
    
}