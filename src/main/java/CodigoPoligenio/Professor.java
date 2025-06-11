/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-------------------------------*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*----------------------CLASSE PROFESSOR QUE HERDA DE ABSTRACTPESSOA----------*/
public class Professor extends AbstractPessoa implements InterfaceAdministrador
{
    
/*----------------------DECLARAÇÃO DE VARIÁVEIS-------------------------------*/
    private String especialidade;
    
/*----------------------MÉTODOS GET E SET PARA ESPECIALIDADE------------------*/
    public String getEspecialidade(){
        return especialidade;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
/*----------------------CONSTRUTOR SIMPLES DA CLASSE PROFESSOR----------------*/
    public Professor(String nome, String senha) {
        super(nome, null, null, senha);
    }
    
/*----------------------CONSTRUTOR COMPLETO DA CLASSE PROFESSOR---------------*/
    public Professor(String nome, String id, String email, 
            String especialidade, String senha) {
        super(nome, id, email, senha);
        this.especialidade = especialidade;
    }
    
/*----------------------MÉTODO PARA AUTENTICAR USUÁRIO------------------------*/
    @Override
    public void autenticarUsuario() {
        System.out.println("Email = " + getEmail() + " \nId = " + getId() + 
        " \nNome = " + getNome() + " \nEspecialidade = " + getEspecialidade());
    }

/*----------------------MÉTODO PARA CADASTRAR JOGADOR-------------------------*/
    @Override
    public boolean cadastrarJogador(String nome, 
            String raAluno, String email, 
            String senha, String serieAluno, 
            String turmaAluno) {

        String idAdministrador = this.getId();
        try {
                Connection conexao = ConexaoBD.obterConexao();
                String sql = "INSERT INTO jogador (nome_jogador, "
                        + "serie_jogador, "
                        + "email_jogador, "
                        + "Administrador_id_administrador, "
                        + "senha, "
                        + "ra) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, serieAluno);
                stmt.setString(3, email);
                stmt.setString(4, idAdministrador);
                stmt.setString(5, senha);
                stmt.setString(6, raAluno);

                int linhasAfetadas = stmt.executeUpdate();
                stmt.close();
                conexao.close();

                return linhasAfetadas > 0;

            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
        } catch (Exception ex) {
            Logger.getLogger(Professor.class.getName()).log
                            (Level.SEVERE, null, ex);
        }
        return false;
    }

/*----------------------MÉTODO PARA CRIAR SALA--------------------------------*/
    @Override
    public void criarSala(String idProfessor, String codigoSala) {
        System.out.print(idProfessor);
        System.out.print(codigoSala);
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConexaoBD.obterConexao();

            String sql = "INSERT INTO sala (código_sala, id_administrador) "
                    + "VALUES (?, ?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, codigoSala);
            stmt.setString(2, idProfessor);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Sala criada com sucesso! Código: " 
                        + codigoSala);
            } else {
                System.out.println("Falha ao criar sala.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, 
                    null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

/*----------------------MÉTODO PARA CONSULTAR RANKING-------------------------*/
    @Override
    public void consultarRanking() {
    
    }

/*----------------------MÉTODO PARA INICIAR PARTIDA---------------------------*/
    @Override
    public void iniciarPartida() {
    
    }

/*----------------------MÉTODO PARA REALIZAR LOGIN----------------------------*/
    @Override
    public boolean fazerLogin(String nome, String Senha) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoBD.obterConexao();
            String sql = "SELECT * FROM administrador "
                    + "WHERE nome_administrador = ? "
                    + "AND senha = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, Senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                this.nome = rs.getString("nome_administrador");
                this.id = rs.getString("id_administrador");
                this.senha = Senha;
                
                Sistema.getInstance().notificarCadastro(this);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Professor.class.getName()).log
        (Level.SEVERE, null, ex);
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

/*----------------------MÉTODO PARA SOLICITAR RANKING-------------------------*/
    @Override
    public void solicitarRanking() {
    
    }

/*----------------------MÉTODO PARA GERENCIAR DICA----------------------------*/
    @Override
    public void gerenciarDica() {
    
    }

/*----------------------MÉTODO PARA GERENCIAR QUESTÃO-------------------------*/
    @Override
    public void gerenciarQuestao() {
    
    }

/*----------------------MÉTODO PARA ENCERRAR PARTIDA--------------------------*/
    @Override
    public void encerrarPartida() {
    
    }
}