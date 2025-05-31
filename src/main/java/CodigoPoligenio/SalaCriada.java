/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*----------------------CLASSE PARA GERENCIAMENTO DE SALA CRIADA-------------*/
public class SalaCriada {
    
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

    /*----------------------CONSTRUTOR DA CLASSE SALA CRIADA-------------*/
    public SalaCriada(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    /*----------------------MÉTODO PARA ADICIONAR PERGUNTA---------------*/
    public void adicionarPergunta(Integer idDificuldade, 
            String idMateria, 
            String pergunta) throws Exception {
        try{
            Connection conexao = ConexaoBD.obterConexao();
            String sql = "INSERT INTO perguntascriadas(id_Dificuldade, "
                + "id_Matéria, "
                + "texto_pergunta) VALUES (?, ?, ?)";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idDificuldade);
            stmt.setString(2, idMateria);
            stmt.setString(3, pergunta);
            int rowsInserted = stmt.executeUpdate();          
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*----------------------MÉTODO PARA ATUALIZAR PERGUNTA--------------*/
    public void atualizarPergunta() {
        
    }

    /*----------------------MÉTODO PARA EXCLUIR PERGUNTA---------------*/
    public void excluirPergunta() {
        
    }

    /*----------------------MÉTODO PARA LER PERGUNTA-------------------*/
    public void lerPergunta() {
        
    }

    /*----------------------MÉTODO PARA EXIBIR ALTERNATIVAS------------*/
    public void exibirAlternativas() {
        
    }

    /*----------------------MÉTODO PARA EXIBIR PERGUNTA---------------*/
    public void exibirPergunta() {
        
    }

    /*----------------------MÉTODO PARA ADICIONAR ALTERNATIVA---------*/
    public void adicionarAlternativa() {
       
    }

    /*----------------------MÉTODO PARA CRIAR PERGUNTA----------------*/
    public void criarPergunta() {
    }

    /*----------------------MÉTODO PARA CRIAR ALTERNATIVA-------------*/
    public void criarAlternativa() {
    }
}