package CodigoPoligenio;
public interface InterfaceAdministrador {
    
    boolean fazerLogin(String RA, String Senha);
    boolean cadastrarJogador(String nome,
            String raAluno,
            String email,
            String senha,
            String serieAluno,
            String turmaAluno);
    void criarSala();
    void solicitarRanking();
    void consultarRanking();
    void iniciarPartida();
    void gerenciarDica();
    void gerenciarQuestao();
    void encerrarPartida();
    
}
