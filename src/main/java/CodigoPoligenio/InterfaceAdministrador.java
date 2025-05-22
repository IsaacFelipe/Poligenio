package CodigoPoligenio;
public interface InterfaceAdministrador {
    boolean fazerLogin(String RA, String Senha);
    void cadastrarJogador();
    void criarSala();
    void solicitarRanking();
    void consultarRanking();
    void iniciarPartida();
    void gerenciarDica();
    void gerenciarQuestao();
    void encerrarPartida();
}
