package TelasPartida;

import CodigoPoligenio.Sistema;
import TelasLobby.TelaLobbyAluno;
import TelasLobby.TelaLobbyProfessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class TelaGifContagem extends JFrame {
    Sistema sistema = Sistema.getInstance();
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private JPanel painelGif;
    private static String idProfessor;
    private static String origem;

    /*----------------------CONSTRUTOR DA TELA DE ACESSO---------------------*/
    public TelaGifContagem(String idProfessor, String origem) {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;
        this.origem = origem;

        painelGif = new JPanel();     

        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelGif panelGif = new PanelGif(idProfessor);
            setContentPane(panelGif);

        } catch (IOException e) {
            /*----------------------TRATAMENTO DE EXCEÇÕES-------------------*/
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: "
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Passe parâmetros fictícios ou reais
            TelaGifContagem tela = new TelaGifContagem(idProfessor, origem);
            tela.setVisible(true);
        });
    }

/*-----------------------CLASSE INTERNA: PAINEL DE ACESSO---------------------*/
    public class PanelGif extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private JLabel labelGif;
        private String tipoUsuario;
        private String idProfessor;

        /*----------------------CONSTRUTOR DO PAINEL DE ACESSO---------------*/
        public PanelGif(String idProfessor) throws IOException {
            this.idProfessor = idProfessor;

            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            ImageIcon gifIcon = new ImageIcon(getClass().getResource
                    ("/ImagensTelaGifContagem/gifContagem.gif"));
            
            sistema.pararMusica();

            labelGif = new JLabel(gifIcon);

            add(labelGif);

            int duracaoGif = 15700;

            javax.swing.Timer timer = 
                    new javax.swing.Timer(duracaoGif, (ActionEvent e) -> {
                     
                        if ("Aluno".equals(origem)) {
                            TelaPergunta pergunta = 
                                    new TelaPergunta(idProfessor);
                            pergunta.setVisible(true);

                            Window window = SwingUtilities.getWindowAncestor
                                                (PanelGif.this);
                            if (window instanceof JFrame) {
                                window.dispose();
                        } else if ("Professor".equals(origem)) {
                            TelaGifPartidaEmAndamento gifPartidaAndamento = 
                                    new TelaGifPartidaEmAndamento(idProfessor);
                            gifPartidaAndamento.setVisible(true);

                            Window janela = SwingUtilities.getWindowAncestor
                                                (PanelGif.this);
                                if (janela instanceof JFrame) {
                                    janela.dispose();
                                }
                            }
                        }
                    });
            timer.setRepeats(false);
            timer.start();
        }
    }
}
