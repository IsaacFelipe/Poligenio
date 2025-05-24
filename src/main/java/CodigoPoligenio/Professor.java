package CodigoPoligenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Definindo classe Professor, herdando métodos de AbstractPessoa e implementando
a interfaceAdministrador para separar apenas os métodos e atributos que vão ser 
utilizados por essa classe em específico*/
public class Professor extends AbstractPessoa implements InterfaceAdministrador {
    
    //Definindo variável local
    private String especialidade;
    
    /*Get e Set definidos para os métodos da variável local*/
    public String getEspecialidade(){
        return especialidade;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
    public Professor(String nome, String senha) {
        super(nome, null, null, senha);
    }
    
    /*MÉTODO CONSTRUTOR herdando parâmetros da Super Classe para que não
    necessite atribui-las novamente*/ 
    public Professor(String nome, String id, String email, String especialidade, String senha) {
        super(nome, null, null, senha); /*Chamando construtor da Super Classe para
        inicializar corretamente os seus atributos exclusivos*/
        this.especialidade = especialidade;
    }
    
    /*Métodos herdados da Super classe e definidas apenas as de uso exclusivo
    desta classe pela interfaceAdministrador*/
    @Override
    public void autenticarUsuario() {
        System.out.println("Email = " + getEmail() + " \nId = " + getId() + 
        " \nNome = " + getNome() + " \nEspecialidade = " + getEspecialidade());
    }

    @Override
    public void cadastrarJogador() {
    
    }

    @Override
    public void criarSala() {
    
    }

    @Override
    public void consultarRanking() {
    
    }

    @Override
    public void iniciarPartida() {
    
    }

    @Override
    public boolean fazerLogin(String nome, String Senha) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoBD.obterConexao();
            String sql = "SELECT * FROM administrador WHERE nome_administrador = ? AND senha = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, Senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Login bem-sucedido
                this.nome = rs.getString("nome_administrador");
                this.senha = Senha;
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
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
    public void solicitarRanking() {
    
    }

    @Override
    public void gerenciarDica() {
    
    }

    @Override
    public void gerenciarQuestao() {
    
    }

    @Override
    public void encerrarPartida() {
    
    }

}