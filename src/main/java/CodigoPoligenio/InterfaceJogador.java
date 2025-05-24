package CodigoPoligenio;

public interface InterfaceJogador {
    void jogar();
    void consultarPontuacao();
    boolean fazerLogin(String RA, String Senha);
    void escolherAlternativa();
    void solicitarDesistencia();
    void responderAlternativa();
}
