/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/*----------------------CLASSE PARA GERENCIAMENTO DE SALA CRIADA-------------*/
public class SalaCriada {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private TipoSala tipoSala;
    private String idMateria;
    
    /*----------------------MÉTODO PARA OBTER TIPO DE SALA---------------*/
    public TipoSala getTipoSala() {
        return tipoSala;
    }

    /*----------------------MÉTODO PARA DEFINIR TIPO DE SALA-------------*/
    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    /*----------------------CONSTRUTOR DA CLASSE SALA CRIADA-------------*/
    public SalaCriada(TipoSala tipoSala, String idMateria) {
        this.tipoSala = tipoSala;
        this.idMateria = idMateria;
    }

    /*----------------------MÉTODO PARA ADICIONAR PERGUNTA---------------*/
    public int adicionarPergunta(Integer idDificuldade, 
                              String idMateria, 
                              String pergunta) throws Exception {
        Connection conexao = null;
        PreparedStatement stmtPergunta = null;
        int idPergunta = -1;

        try {
            conexao = ConexaoBD.obterConexao();

            String sqlPergunta = "INSERT INTO perguntascriadas(id_Dificuldade, "
                    + "id_Matéria, "
                    + "texto_pergunta) "
                    + "VALUES (?, ?, ?)";
            stmtPergunta = conexao.prepareStatement(sqlPergunta, 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            stmtPergunta.setInt(1, idDificuldade);
            stmtPergunta.setString(2, idMateria);
            stmtPergunta.setString(3, pergunta);

            int rowsInserted = stmtPergunta.executeUpdate();

            if (rowsInserted > 0) {
                java.sql.ResultSet generatedKeys = 
                        stmtPergunta.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idPergunta = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao adicionar pergunta: " 
                    + ex.getMessage());
        } finally {
            if (stmtPergunta != null) stmtPergunta.close();
            if (conexao != null) conexao.close();
        }

        return idPergunta;
    }

    /*----------------------MÉTODO PARA ATUALIZAR PERGUNTA--------------*/
    public void atualizarPergunta() {
        
    }

    /*----------------------MÉTODO PARA EXCLUIR PERGUNTA---------------*/
    public void excluirPergunta() {
        
    }

    /*----------------------MÉTODO PARA EXIBIR ALTERNATIVAS------------*/
    public static Map<String, String> exibirPerguntaComAlternativas() 
            throws Exception {
        Map<String, String> dados = new HashMap<>();
         
        String sql = """
            SELECT p.id_Pergunta AS id_pergunta, p.texto_pergunta,
                   a.alternativaA, a.alternativaB, 
                   a.alternativaC, a.alternativaD, a.respostaCriada
            FROM perguntascriadas p
            INNER JOIN alternativascriadas a ON p.id_Pergunta = a.id_pergunta
            ORDER BY RAND()
            LIMIT 1;
        """;

        try (Connection conn = ConexaoBD.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                dados.put("id", rs.getString("id_pergunta")); // <-- usa o alias aqui
                dados.put("pergunta", rs.getString("texto_pergunta"));
                dados.put("A", rs.getString("alternativaA"));
                dados.put("B", rs.getString("alternativaB"));
                dados.put("C", rs.getString("alternativaC"));
                dados.put("D", rs.getString("alternativaD"));

                int correta = rs.getInt("respostaCriada");
                String letraCorreta = switch (correta) {
                    case 1 -> "A";
                    case 2 -> "B";
                    case 3 -> "C";
                    case 4 -> "D";
                    default -> null;
                };

                if (letraCorreta != null) {
                    dados.put("correta", letraCorreta);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dados;
    }
 
/*------------------------MÉTODO PARA CONTAR AS PERGUNTAS---------------------*/    
    public int contarPerguntas() throws Exception {
        Connection conexao = null;
        PreparedStatement stmt = null;
        int totalPerguntas = 0;

        try {
            conexao = ConexaoBD.obterConexao();
            String sql = "SELECT COUNT(*) AS total FROM perguntascriadas "
                    + "WHERE id_Matéria = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, idMateria);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalPerguntas = rs.getInt("total");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Erro ao contar perguntas: " 
                    + ex.getMessage());
        } finally {
            if (stmt != null) stmt.close();
            if (conexao != null) conexao.close();
        }

        return totalPerguntas;
    }

    /*----------------------MÉTODO PARA ADICIONAR ALTERNATIVA---------*/
    public void adicionarAlternativa(int idPergunta, 
                                     String alternativaA, 
                                     String alternativaB, 
                                     String alternativaC, 
                                     String alternativaD, 
                                     int respostaCorreta) throws Exception {
        Connection conexao = null;
        PreparedStatement stmtAlternativa = null;

        try {
            conexao = ConexaoBD.obterConexao();

            String sqlAlternativa = "INSERT INTO alternativascriadas "
                                  + "( respostaCriada, "
                    + "id_Pergunta, "
                    + "alternativaA, "
                    + "alternativaB, "
                    + "alternativaC, "
                    + "alternativaD) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            stmtAlternativa = conexao.prepareStatement(sqlAlternativa);

            stmtAlternativa.setInt(1, respostaCorreta);
            stmtAlternativa.setInt(2, idPergunta);
            stmtAlternativa.setString(3, alternativaA);
            stmtAlternativa.setString(4, alternativaB);
            stmtAlternativa.setString(5, alternativaC);
            stmtAlternativa.setString(6, alternativaD);

            stmtAlternativa.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao adicionar alternativas: " 
                    + ex.getMessage());
        } finally {
            if (stmtAlternativa != null) stmtAlternativa.close();
            if (conexao != null) conexao.close();
        }
    }
}