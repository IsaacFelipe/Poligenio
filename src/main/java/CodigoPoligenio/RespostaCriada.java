package CodigoPoligenio;

import java.util.List;

public class RespostaCriada {

    private int idResposta;
    private int idPerguntaCriada;
    private List<String> enunciadoResposta;

    public int getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    public int getIdPerguntaCriada() {
        return idPerguntaCriada;
    }

    public void setIdPerguntaCriada(int idPerguntaCriada) {
        this.idPerguntaCriada = idPerguntaCriada;
    }

    public List<String> getEnunciadoResposta() {
        return enunciadoResposta;
    }

    public void setEnunciadoResposta(List<String> enunciadoResposta) {
        this.enunciadoResposta = enunciadoResposta;
    }

    public void conferirResposta() {
    }
}
