/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import java.util.List;

/*----------------------CLASSE PARA GERENCIAMENTO DE RESPOSTAS GENÉRICAS-----*/
public class RespostaGenerica {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private int idResposta;
    private List<String> enunciadoResposta;
    private int idPerguntaGenerica;

    /*----------------------MÉTODO PARA OBTER ID DA RESPOSTA-------------*/
    public int getIdResposta() {
        return idResposta;
    }

    /*----------------------MÉTODO PARA DEFINIR ID DA RESPOSTA-----------*/
    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    /*----------------------MÉTODO PARA OBTER ENUNCIADO DA RESPOSTA------*/
    public List<String> getEnunciadoResposta() {
        return enunciadoResposta;
    }

    /*----------------------MÉTODO PARA DEFINIR ENUNCIADO DA RESPOSTA----*/
    public void setEnunciadoResposta(List<String> enunciadoResposta) {
        this.enunciadoResposta = enunciadoResposta;
    }

    /*----------------------MÉTODO PARA OBTER ID DA PERGUNTA GENÉRICA----*/
    public int getIdPerguntaGenerica() {
        return idPerguntaGenerica;
    }

    /*----------------------MÉTODO PARA DEFINIR ID DA PERGUNTA GENÉRICA--*/
    public void setIdPerguntaGenerica(int idPerguntaGenerica) {
        this.idPerguntaGenerica = idPerguntaGenerica;
    }

    /*----------------------MÉTODO PARA CONFERIR RESPOSTA---------------*/
    public void conferirResposta() {
    }
}