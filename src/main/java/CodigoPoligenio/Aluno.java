package CodigoPoligenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Definindo classe Aluno, herdando métodos de AbstractPessoa e implementando
a interfaceJogador para separar apenas os métodos e atributos que vão ser 
utilizados por essa classe em específico*/
public class Aluno extends AbstractPessoa implements InterfaceJogador {
    
    //Definindo variável local
    private String serie;
    
    /*Get e Set definidos para os métodos da variável local*/

    public String getSerie(){
        return serie;
    }
    public void setSerie(String serie){
        this.serie = serie;
    }
    public Aluno(String nome, String senha) {
        super(nome, null, null, senha);
    }
    
    
    /*MÉTODO CONSTRUTOR herdando parâmetros da Super Classe para que não
    necessite atribui-las novamente*/ 
    public Aluno(String nome, String id, String email, String serie, String senha){
        super(nome, null, null, senha);/*Chamando construtor da Super Classe para
        inicializar corretamente os seus atributos exclusivos*/
        this.serie = serie;
    }
    
    public void entrarEmPartida(){
        
    }
    
    public void inserirCodigoPartida(){
        
    }
    public void inserirCodigoEmail(){
        
    }
    /*Métodos herdados da Super classe e definidas apenas as de uso exclusivo
    desta classe pela interfaceJogador*/
    @Override
    public void autenticarUsuario() {
        System.out.println("Email = " + getEmail() + " \nId = " + getId() + 
        " \nNome = " + getNome() + " \nSerie = " + getSerie());
    }

    @Override
    public void jogar() {
        System.out.println("O aluno " + getNome() + " está jogando!");
    }

    @Override
    public void consultarPontuacao() {
        
    }

    @Override
    public boolean fazerLogin(String nome, String Senha) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoBD.obterConexao();
            String sql = "SELECT * FROM jogador WHERE nome_jogador = ? AND senha = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, Senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Login bem-sucedido
                this.nome = rs.getString("nome_jogador");
                this.senha = Senha;
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

    @Override
    public void escolherAlternativa() {
    
    }

    @Override
    public void solicitarDesistencia() {
    
    }

    @Override
    public void responderAlternativa() {
    
    }
}
