/*-------------------------IMPORTAÇÕES NECESSÁRIAS----------------------------*/
package TelasPartida;

import CodigoPoligenio.Sistema;
import TelasLobby.TelaLobbyAluno;
import TelasLobby.TelaLobbyProfessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaGifContagem extends JFrame {
    Sistema sistema = Sistema.getInstance();
    
/*---------------------------DECLARAÇÃO DE VARIÁVEIS--------------------------*/
    private JPanel painelGif;
    private static String idProfessor;
    private static String origem;
    private static String tipoSala;
    
/*--------------------------CONSTRUTOR DA TELA DE ACESSO----------------------*/
    public TelaGifContagem(String idProfessor, String origem, String tipoSala) {
/*---------------------------CONFIGURAÇÕES DA JANELA--------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;
        this.origem = origem;
        this.tipoSala = tipoSala;

        painelGif = new JPanel();     

        try {
/*-------------------------INSTANCIAÇÃO DO PAINEL-----------------------------*/
            PanelGif panelGif = new PanelGif(idProfessor);
            setContentPane(panelGif);

        } catch (IOException e) {
/*--------------------------TRATAMENTO DE EXCEÇÕES----------------------------*/
            e.printStackTrace();
            JOptionPane.showMessageDialog
        (this, "Erro ao inicializar a tela: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

/*-----------------------MÉTODO MAIN PARA EXECUTAR A TELA---------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Exemplo com parâmetros para teste
            TelaGifContagem tela = 
                    new TelaGifContagem(idProfessor, origem, tipoSala);
            tela.setVisible(true);
        });
    }

/*-----------------------CLASSE INTERNA: PAINEL DE ACESSO---------------------*/
    public class PanelGif extends JPanel {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
        private JLabel labelGif;
        private String idProfessor;
        private javax.swing.Timer timer;

/*----------------------CONSTRUTOR DO PAINEL DE ACESSO------------------------*/
        public PanelGif(String idProfessor) throws IOException {
            this.idProfessor = idProfessor;

            setLayout(new BorderLayout());

/*----------------------CRIAR JLayeredPane PARA CAMADAS-----------------------*/
            JLayeredPane layeredPane = new JLayeredPane();

/*--------------------------CARREGAMENTO DAS IMAGENS--------------------------*/
            java.net.URL gifUrl = 
                    getClass().getResource
        ("/ImagensTelaGifContagem/gifContagem.gif");

            ImageIcon gifIcon = new ImageIcon(gifUrl);
            
            Image scaledImage = 
                    gifIcon.getImage().getScaledInstance(1620, 880,
                            Image.SCALE_DEFAULT);
            gifIcon = new ImageIcon(scaledImage);

            sistema.pararMusica();

            labelGif = new JLabel(gifIcon, SwingConstants.CENTER);
            labelGif.setHorizontalAlignment(SwingConstants.CENTER);
            labelGif.setVerticalAlignment(SwingConstants.CENTER);
            labelGif.setBounds(0, 0, getWidth(), getHeight());

/*------------------------------BOTÃO INVISÍVEL-------------------------------*/
            JButton skipButton = new JButton();
            skipButton.setOpaque(false);
            skipButton.setContentAreaFilled(false);
            skipButton.setBorderPainted(false);
            skipButton.setFocusPainted(false);
            skipButton.setBounds(0, 0, getWidth(), getHeight());

/*-------------------------ADICIONAR AO JLayeredPane--------------------------*/
            layeredPane.add(labelGif, JLayeredPane.DEFAULT_LAYER);
            layeredPane.add(skipButton, JLayeredPane.PALETTE_LAYER);

            add(layeredPane, BorderLayout.CENTER);

/*--------------------------AJUSTAR TAMANHO COM RESIZE------------------------*/
            addComponentListener(new java.awt.event.ComponentAdapter() 
            {
                public void componentResized(java.awt.event.ComponentEvent evt) 
                {
                    labelGif.setBounds(0, 0, getWidth(), getHeight());
                    skipButton.setBounds(0, 0, getWidth(), getHeight());
                }
            });

            int duracaoGif = 15700;

            timer = new javax.swing.Timer(duracaoGif, (ActionEvent e) -> {
                try {
                    mudarTela();
                } catch (Exception ex) {
                    Logger.getLogger(TelaGifContagem.class.getName()
                    ).log(Level.SEVERE, null, ex);
                }
            });

            skipButton.addActionListener((ActionEvent e) -> {
                timer.stop();
                try {
                    mudarTela();
                } catch (Exception ex) {
                    Logger.getLogger(TelaGifContagem.class.getName()
                    ).log(Level.SEVERE, null, ex);
                }
            });

            timer.setRepeats(false);
            timer.start();
        }

/*-------------------------MÉTODO PARA TRANSIÇÃO------------------------------*/
        private void mudarTela() throws Exception {
            if ("aluno".equals(TelaGifContagem.this.origem)) {
                TelaPergunta pergunta = new TelaPergunta(idProfessor, tipoSala);
                pergunta.setVisible(true);
                
                Window window = SwingUtilities.getWindowAncestor(this);
                if (window instanceof JFrame) {
                    window.dispose();
                }
            } else if ("professor".equals(TelaGifContagem.this.origem)) {
                TelaGifPartidaEmAndamento partidaAndamento = 
                        new TelaGifPartidaEmAndamento(idProfessor);
                partidaAndamento.setVisible(true);
                
                Window window = SwingUtilities.getWindowAncestor(this);
                if (window instanceof JFrame) {
                    window.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Origem inválida: " 
                        + TelaGifContagem.origem, 
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
            fecharJanela();
        }

/*------------------------MÉTODO PARA FECHAR JANELA---------------------------*/
        private void fecharJanela() {
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window instanceof JFrame) {
                window.dispose();
            }
        }
    }
}