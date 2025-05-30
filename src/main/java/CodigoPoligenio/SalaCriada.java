package CodigoPoligenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalaCriada {
    
    private TipoSala tipoSala;
    
    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public SalaCriada(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }
        //
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

    public void atualizarPergunta() {
        
    }

    public void excluirPergunta() {
        
    }

    public void lerPergunta() {
        
    }

    public void exibirAlternativas() {
        
    }

    public void exibirPergunta() {
        
    }

    public void adicionarAlternativa() {
       
    }

    public void criarPergunta() {
    }

    public void criarAlternativa() {
    }
}
