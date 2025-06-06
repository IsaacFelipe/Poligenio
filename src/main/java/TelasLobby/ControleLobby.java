/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasLobby;

/*----------------------CLASSE PRINCIPAL DE CONTROLE DO LOBBY-----------------*/
public class ControleLobby {
    
    /*----------------------ENUMERAÇÃO PARA ORIGEM DO LOBBY-------------------*/
    public enum Origem {
        LOBBY_PROFESSOR,
        LOBBY_ALUNO
    }

    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private static Origem origemAtual;

    /*----------------------MÉTODO PARA DEFINIR A ORIGEM------------------*/
    public static void setOrigem(Origem origem) {
        origemAtual = origem;
    }

    /*----------------------MÉTODO PARA OBTER A ORIGEM-------------------*/
    public static Origem getOrigem() {
        return origemAtual;
    }
}