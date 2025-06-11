/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

import TelasPartida.TelaPergunta;
import TelasPartida.TelaPergunta.PanelPergunta;
import TelasPartida.TelaRankAluno;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*----------------------CLASSE PARA GERENCIAMENTO DE PERGUNTAS CRIADAS-------*/
public class PerguntaCriada {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private int dificuldade;
    private char alternativa;
    private String enunciado;
    private String respostaCorreta;
    private int pontuacao;
    private Materia materia;
    private String id;
    private static HashSet<String> questoesUtilizadas = new HashSet<>();
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public PerguntaCriada(String id, String respostaCorreta) {
        this.id = id;
        this.respostaCorreta = respostaCorreta;
    }

    /*----------------------MÉTODO PARA OBTER DIFICULDADE----------------*/
    public int getDificuldade() {
        return dificuldade;
    }

    /*----------------------MÉTODO PARA DEFINIR DIFICULDADE--------------*/
    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    /*----------------------MÉTODO PARA OBTER ALTERNATIVA---------------*/
    public char getAlternativa() {
        return alternativa;
    }

    /*----------------------MÉTODO PARA DEFINIR ALTERNATIVA-------------*/
    public void setAlternativa(char alternativa) {
        this.alternativa = alternativa;
    }

    /*----------------------MÉTODO PARA OBTER ENUNCIADO-----------------*/
    public String getEnunciado() {
        return enunciado;
    }

    /*----------------------MÉTODO PARA DEFINIR ENUNCIADO---------------*/
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /*----------------------MÉTODO PARA VERIFICAR RESPOSTA CORRETA------*/
    public String isRespostaCorreta() {
        return respostaCorreta;
    }

    /*----------------------MÉTODO PARA DEFINIR RESPOSTA CORRETA--------*/
    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    /*----------------------MÉTODO PARA OBTER PONTUAÇÃO-----------------*/
    public int getPontuacao() {
        return pontuacao;
    }

    /*----------------------MÉTODO PARA DEFINIR PONTUAÇÃO---------------*/
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    /*----------------------MÉTODO PARA OBTER MATÉRIA-------------------*/
    public Materia getMateria() {
        return materia;
    }

    /*----------------------MÉTODO PARA DEFINIR MATÉRIA-----------------*/
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /*----------------------MÉTODO PARA VERIFICAR RESPOSTA--------------*/
    public void verificarResposta(String alternativaSelecionada, JFrame parentFrame) throws Exception {
        try (Connection conn = ConexaoBD.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT respostaCriada, alternativaA, alternativaB, alternativaC, alternativaD " +
                 "FROM alternativascriadas WHERE id_Pergunta = ?")) {
            stmt.setString(1, this.id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String alternativaCorretaBD = "";
                    switch (rs.getInt("respostaCriada")) {
                        case 1:
                            alternativaCorretaBD = rs.getString("alternativaA").trim();
                            break;
                        case 2:
                            alternativaCorretaBD = rs.getString("alternativaB").trim();
                            break;
                        case 3:
                            alternativaCorretaBD = rs.getString("alternativaC").trim();
                            break;
                        case 4:
                            alternativaCorretaBD = rs.getString("alternativaD").trim();
                            break;
                        default:
                            throw new Exception("Valor inválido para respostaCriada: " + rs.getInt("respostaCriada"));
                    }

                    String alternativaSelecionadaTexto = "";
                    alternativaSelecionada = alternativaSelecionada != null ? alternativaSelecionada.trim().toUpperCase() : "";
                    switch (alternativaSelecionada) {
                        case "A":
                            alternativaSelecionadaTexto = rs.getString("alternativaA").trim();
                            break;
                        case "B":
                            alternativaSelecionadaTexto = rs.getString("alternativaB").trim();
                            break;
                        case "C":
                            alternativaSelecionadaTexto = rs.getString("alternativaC").trim();
                            break;
                        case "D":
                            alternativaSelecionadaTexto = rs.getString("alternativaD").trim();
                            break;
                        default:
                            throw new Exception("Opção selecionada inválida: " + alternativaSelecionada);
                    }

                    System.out.println("Alternativa selecionada: '" + alternativaSelecionadaTexto + "'");
                    System.out.println("Alternativa correta do BD: '" + alternativaCorretaBD + "'");

                    if (alternativaSelecionadaTexto.equalsIgnoreCase(alternativaCorretaBD)) {
                        JOptionPane.showMessageDialog(null, "Resposta CORRETA!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Resposta incorreta!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pergunta não encontrada no banco de dados.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco de dados: " + e.getMessage());
            throw e;
        }
    }
    
    private String getAlternativaTextoFromUI(String alternativa) {
        switch (alternativa) {
            case "A":
                return TelaPergunta.campoTextoAltA.getText().trim();
            case "B":
                return TelaPergunta.campoTextoAltB.getText().trim();
            case "C":
                return TelaPergunta.campoTextoAltC.getText().trim();
            case "D":
                return TelaPergunta.campoTextoAltD.getText().trim();
            default:
                return "";
        }
    }
    
    public static void carregarNovaQuestao(PanelPergunta panel, String idProfessor) throws Exception {
        int totalPerguntas = getTotalPerguntasDisponiveis();
        if (questoesUtilizadas.size() >= totalPerguntas) {
            JOptionPane.showMessageDialog(null, "Questionário Finalizado");
            TelaRankAluno rankAluno = new TelaRankAluno("aluno",idProfessor);
            Window window = SwingUtilities.getWindowAncestor(panel);
            if (window instanceof JFrame) {
                window.dispose();
            }
            rankAluno.setVisible(true);
            return;
        }
        
        Map<String, String> perguntaComAlternativas;
        String id;
        do {
            perguntaComAlternativas = SalaCriada.exibirPerguntaComAlternativas();
            id = perguntaComAlternativas.get("id");
        } while (questoesUtilizadas.contains(id));

        questoesUtilizadas.add(id);
        String pergunta = perguntaComAlternativas.get("pergunta");
        String altA = perguntaComAlternativas.get("A");
        String altB = perguntaComAlternativas.get("B");
        String altC = perguntaComAlternativas.get("C");
        String altD = perguntaComAlternativas.get("D");
        String correta = perguntaComAlternativas.get("correta");

        panel.getCampoPergunta().setText(pergunta);
        panel.getCampoTextoAltA().setText(altA);
        panel.getCampoTextoAltB().setText(altB);
        panel.getCampoTextoAltC().setText(altC);
        panel.getCampoTextoAltD().setText(altD);

        switch (correta) {
            case "A":
                panel.respostaCorreta = TelaPergunta.botaoAlternativaA;
                break;
            case "B":
                panel.respostaCorreta = TelaPergunta.botaoAlternativaB;
                break;
            case "C":
                panel.respostaCorreta = TelaPergunta.botaoAlternativaC;
                break;
            case "D":
                panel.respostaCorreta = TelaPergunta.botaoAlternativaD;
                break;
            default:
                panel.respostaCorreta = TelaPergunta.botaoAlternativaA;
                break;
        }

        TelaPergunta.botaoAlternativaA.setVisible(true);
        TelaPergunta.botaoAlternativaB.setVisible(true);
        TelaPergunta.botaoAlternativaC.setVisible(true);
        TelaPergunta.botaoAlternativaD.setVisible(true);
        panel.getCampoTextoAltA().setVisible(true);
        panel.getCampoTextoAltB().setVisible(true);
        panel.getCampoTextoAltC().setVisible(true);
        panel.getCampoTextoAltD().setVisible(true);
        panel.getLabelAltASelecionado().setVisible(false);
        panel.getLabelAltBSelecionado().setVisible(false);
        panel.getLabelAltCSelecionado().setVisible(false);
        panel.getLabelAltDSelecionado().setVisible(false);
        panel.setAlternativaAtivada(null);
        panel.setBotaoSelecionado(null);

        panel.repaint();
    }
    
    public static void limparEInserirQuest(PanelPergunta panel, String idProfessor) throws Exception {
        panel.getCampoPergunta().setText("");
        panel.getCampoTextoAltA().setText("");
        panel.getCampoTextoAltB().setText("");
        panel.getCampoTextoAltC().setText("");
        panel.getCampoTextoAltD().setText("");
        panel.getLabelAltASelecionado().setVisible(false);
        panel.getLabelAltBSelecionado().setVisible(false);
        panel.getLabelAltCSelecionado().setVisible(false);
        panel.getLabelAltDSelecionado().setVisible(false);
        panel.setAlternativaAtivada(null);
        panel.setBotaoSelecionado(null);

        carregarNovaQuestao(panel, idProfessor);
    }
    
    private static int getTotalPerguntasDisponiveis() throws Exception {
        try (Connection conn = ConexaoBD.obterConexao();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS total FROM alternativascriadas");
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("total");
            }
            return 0;
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao contar perguntas: " + e.getMessage());
            throw e;
        }
    }
}