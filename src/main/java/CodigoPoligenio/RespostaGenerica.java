package CodigoPoligenio;

import java.util.List;

public class RespostaGenerica {

    private int idResposta;
    private List<String> enunciadoResposta;
    private int idPerguntaGenerica;

    public int getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    public List<String> getEnunciadoResposta() {
        return enunciadoResposta;
    }

    public void setEnunciadoResposta(List<String> enunciadoResposta) {
        this.enunciadoResposta = enunciadoResposta;
    }

    public int getIdPerguntaGenerica() {
        return idPerguntaGenerica;
    }

    public void setIdPerguntaGenerica(int idPerguntaGenerica) {
        this.idPerguntaGenerica = idPerguntaGenerica;
    }

    public void conferirResposta() {
    }
}
