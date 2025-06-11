/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-------------------------------*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*----------------------CLASSE ALUNO QUE HERDA DE ABSTRACTPESSOA--------------*/
public class Aluno extends AbstractPessoa implements InterfaceJogador {
    
/*----------------------DECLARAÇÃO DE VARIÁVEIS-------------------------------*/
    private String serie;
    
/*----------------------MÉTODOS GET E SET PARA SÉRIE--------------------------*/
    public String getSerie(){
        return serie;
    }
    
    public void setSerie(String serie){
        this.serie = serie;
    }
    
/*----------------------CONSTRUTOR SIMPLES DA CLASSE ALUNO--------------------*/
    public Aluno(String nome, String senha) {
        super(nome, null, null, senha);
    }
    
/*----------------------CONSTRUTOR COMPLETO DA CLASSE ALUNO-------------------*/
    public Aluno(String nome, String id, String email, 
            String serie, String senha){
        super(nome, null, null, senha);
        this.serie = serie;
    }
    
/*----------------------MÉTODO PARA AUTENTICAR USUÁRIO------------------------*/
    @Override
    public void autenticarUsuario() {
        System.out.println("Email = " + getEmail() + " \nId = " + getId() + 
        " \nNome = " + getNome() + " \nSerie = " + getSerie());
    }

/*----------------------MÉTODO PARA INICIAR JOGO------------------------------*/
    @Override
    public void jogar() {
        System.out.println("O aluno " + getNome() + " está jogando!");
    }

/*----------------------MÉTODO PARA CONSULTAR PONTUAÇÃO-----------------------*/
    @Override
    public void consultarPontuacao() {
        
    }

/*----------------------MÉTODO PARA REALIZAR LOGIN----------------------------*/
    @Override
    public boolean fazerLogin(String nome, String Senha) {
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement updateStmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoBD.obterConexao();
            String sql = "SELECT * FROM jogador WHERE nome_jogador = ? "
                    + "AND senha = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, Senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                this.nome = rs.getString("nome_jogador");
                this.senha = Senha;
                int jogadorId = rs.getInt("id_jogador");
                
                String updateSql = "UPDATE jogador SET logado = 1 "
                        + "WHERE id_jogador = ?";
                updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setInt(1, jogadorId);
                updateStmt.executeUpdate();
                
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

/*----------------------MÉTODO PARA ESCOLHER ALTERNATIVA----------------------*/
    @Override
    public void escolherAlternativa() {
    
    }

/*--------------------------MÉTODO PARA SOLICITAR DESISTÊNCIA-----------------*/
    @Override
    public void solicitarDesistencia() {
    
    }

/*----------------------MÉTODO PARA RESPONDER ALTERNATIVA---------------------*/
    @Override
    public void responderAlternativa() {
    
    }
}