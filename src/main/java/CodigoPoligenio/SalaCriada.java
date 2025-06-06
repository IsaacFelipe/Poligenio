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