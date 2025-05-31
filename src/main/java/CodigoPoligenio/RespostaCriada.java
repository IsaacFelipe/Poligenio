/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import java.util.List;

/*----------------------CLASSE PARA GERENCIAMENTO DE RESPOSTAS CRIADAS-------*/
public class RespostaCriada {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private int idResposta;
    private int idPerguntaCriada;
    private List<String> enunciadoResposta;

    /*----------------------MÉTODO PARA OBTER ID DA RESPOSTA-------------*/
    public int getIdResposta() {
        return idResposta;
    }

    /*----------------------MÉTODO PARA DEFINIR ID DA RESPOSTA-----------*/
    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    /*----------------------MÉTODO PARA OBTER ID DA PERGUNTA CRIADA------*/
    public int getIdPerguntaCriada() {
        return idPerguntaCriada;
    }

    /*----------------------MÉTODO PARA DEFINIR ID DA PERGUNTA CRIADA----*/
    public void setIdPerguntaCriada(int idPerguntaCriada) {
        this.idPerguntaCriada = idPerguntaCriada;
    }

    /*----------------------MÉTODO PARA OBTER ENUNCIADO DA RESPOSTA------*/
    public List<String> getEnunciadoResposta() {
        return enunciadoResposta;
    }

    /*----------------------MÉTODO PARA DEFINIR ENUNCIADO DA RESPOSTA----*/
    public void setEnunciadoResposta(List<String> enunciadoResposta) {
        this.enunciadoResposta = enunciadoResposta;
    }

    /*----------------------MÉTODO PARA CONFERIR RESPOSTA---------------*/
    public void conferirResposta() {
    }
}