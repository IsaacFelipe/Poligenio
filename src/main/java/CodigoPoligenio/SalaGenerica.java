/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public class QuestaoDAO {
        public List<Questao> buscarQuestoesPorMateriaESerie(int idSerie, String materia) throws Exception {

            String sql = "SELECT p.id_perguntasRandom, p.texto_pergunta, p.Serie_id_Serie, p.sala_id_sala, p.materia, " +
                         "a.alternativaA, a.alternativaB, a.alternativaC, a.alternativaD, a.resposta " +
                         "FROM perguntasrandom p " +
                         "JOIN alternativasrandom a ON p.id_perguntasRandom = a.id_perguntasRandom " +
                         "WHERE p.Serie_id_Serie = ? AND p.materia = ?";

            List<Questao> questoes = new ArrayList<>();

            try (Connection conn = ConexaoBD.obterConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, idSerie);
                stmt.setString(2, materia);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Questao q = new Questao(
                            rs.getInt("id_perguntasRandom"),
                            rs.getString("texto_pergunta"),
                            rs.getInt("Serie_id_Serie"),
                            rs.getInt("sala_id_sala"),
                            rs.getString("materia"),
                            rs.getString("alternativaA"),
                            rs.getString("alternativaB"),
                            rs.getString("alternativaC"),
                            rs.getString("alternativaD"),
                            rs.getInt("resposta")
                        );
                        questoes.add(q);
                    }
                }

            } catch (SQLException e) {
                System.err.println("Erro ao buscar questões: " + e.getMessage());
                e.printStackTrace();
            }

            Collections.shuffle(questoes); // embaralhar para tornar aleatório
            return questoes;
        }
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