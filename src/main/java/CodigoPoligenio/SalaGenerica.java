/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------CLASSE PARA GERENCIAMENTO DE SALA GENÉRICA-----------*/
public class SalaGenerica {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private TipoSala tipoSala;
    
    /*----------------------MÉTODO PARA OBTER TIPO DE SALA---------------*/
    public TipoSala getTipoSala() {
        return tipoSala;
    }

    /*----------------------MÉTODO PARA DEFINIR TIPO DE SALA-------------*/
    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }
    
    /*----------------------CONSTRUTOR DA CLASSE SALA GENÉRICA-----------*/
    public SalaGenerica(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }
    
    /*----------------------MÉTODO PARA ADICIONAR PERGUNTA GENÉRICA------*/
    public void adicionarPerguntaGenerica() {
    
    }

    /*----------------------MÉTODO PARA EXIBIR ALTERNATIVA GENÉRICA------*/
    public void exibirAlternativaGenerica() {
        
    }

    /*----------------------MÉTODO PARA EXIBIR PERGUNTA-----------------*/
    public void exibirPergunta() {
        
    }

    /*----------------------MÉTODO PARA ADICIONAR ALTERNATIVAS GENÉRICAS-*/
    public void adicionarAlternativasGenericas() {
        
    }

    /*----------------------MÉTODO PARA SORTEAR QUESTÃO-----------------*/
    public void sortearQuestao() {
        
    }
}