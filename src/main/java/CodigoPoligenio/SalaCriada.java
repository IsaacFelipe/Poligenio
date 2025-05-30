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

    public void adicionarPergunta(String pergunta, 
            String alternativa1, 
            String alternativa2, 
            String alternativa3, 
            String alternativa4,
            Integer idSerie,
            Integer idSala,
            String materia
            ) throws Exception {
    
        String sqlPergunta = "INSERT INTO perguntascriadas (texto_pergunta, "
                + "Serie_id_Serie, "
                + "sala_id_sala, materia) VALUES (?, ?, ?, ?, ?)";
        
        String sqlAlternativas = "INSERT INTO alternativascriadas (respostaCriada, id_Pergunta, alternativaA, alternativaB, alternativaC, alternativaD) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.obterConexao()) {

            // Desativa o auto-commit para fazer a transação
            conn.setAutoCommit(false);

            // 1. Inserir a pergunta
            try (PreparedStatement stmtPergunta = conn.prepareStatement
                    (sqlPergunta, 
                    Statement.RETURN_GENERATED_KEYS)) {
                
                stmtPergunta.setString(1, pergunta);
                stmtPergunta.setInt(2, idSerie);
                stmtPergunta.setInt(3, idSala);
                stmtPergunta.setString(4, materia);

                int rowsInserted = stmtPergunta.executeUpdate();

                if (rowsInserted == 0) {
                    conn.rollback();
                    throw new SQLException("Erro ao inserir a pergunta.");
                }

                try (ResultSet generatedKeys = stmtPergunta.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idPergunta = generatedKeys.getInt(1);

                        try (PreparedStatement stmtAlternativas = conn.prepareStatement(sqlAlternativas)) {
                            stmtAlternativas.setInt(1, idPergunta);
                            stmtAlternativas.setString(2, alternativa1);
                            stmtAlternativas.setString(3, alternativa2);
                            stmtAlternativas.setString(4, alternativa3);
                            stmtAlternativas.setString(5, alternativa4);

                            int rowsAlt = stmtAlternativas.executeUpdate();

                            if (rowsAlt == 0) {
                                conn.rollback();
                                throw new SQLException("Erro ao inserir as alternativas.");
                            }
                        }
                    } else {
                        conn.rollback();
                        throw new SQLException("Falha ao obter o ID da pergunta.");
                    }
                }
            }

            // Se tudo der certo, confirma a transação
            conn.commit();
            System.out.println("Pergunta e alternativas inseridas com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
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
