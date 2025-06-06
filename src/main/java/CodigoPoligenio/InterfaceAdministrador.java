/*----------------------PACOTE QUE PERTENCE A INTERFACE--------------------------*/
package CodigoPoligenio;

/*----------------------INTERFACE PARA DEFINIÇÃO DE MÉTODOS DO ADMINISTRADOR-----------------*/
public interface InterfaceAdministrador {
    
    /*----------------------MÉTODO PARA REALIZAR LOGIN--------------------------*/
    boolean fazerLogin(String RA, String Senha);
    
    /*----------------------MÉTODO PARA CADASTRAR JOGADOR-----------------------*/
    boolean cadastrarJogador(String nome,
            String raAluno,
            String email,
            String senha,
            String serieAluno,
            String turmaAluno);
    
    /*----------------------MÉTODO PARA CRIAR SALA-----------------------------*/
    void criarSala(String idProfessor, String codigoSala);
    
    /*----------------------MÉTODO PARA SOLICITAR RANKING----------------------*/
    void solicitarRanking();
    
    /*----------------------MÉTODO PARA CONSULTAR RANKING---------------------*/
    void consultarRanking();
    
    /*----------------------MÉTODO PARA INICIAR PARTIDA-----------------------*/
    void iniciarPartida();
    
    /*----------------------MÉTODO PARA GERENCIAR DICA------------------------*/
    void gerenciarDica();
    
    /*----------------------MÉTODO PARA GERENCIAR QUESTÃO--------------------*/
    void gerenciarQuestao();
    
    /*----------------------MÉTODO PARA ENCERRAR PARTIDA---------------------*/
    void encerrarPartida();
}