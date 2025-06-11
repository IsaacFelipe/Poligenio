/*----------------------IMPORTAÇÕES NECESSÁRIAS-------------------------------*/
package TelasPartida;

import CodigoPoligenio.Sistema;
import TelasLobby.TelaLobbyAluno;
import TelasLobby.TelaLobbyProfessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class TelaGifPartidaEncerrada extends JFrame {
    Sistema sistema = Sistema.getInstance();
    
/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
    private JPanel painelGif;
    private String idProfessor;
    private String tipoUsuario;

/*----------------------CONSTRUTOR DA TELA DE ACESSO--------------------------*/
    public TelaGifPartidaEncerrada(String idProfessor, String tipoUsuario) {
/*------------------------CONFIGURAÇÕES DA JANELA-----------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;
        this.tipoUsuario = tipoUsuario;

        painelGif = new JPanel();     

        try {
/*--------------------------INSTANCIAÇÃO DO PAINEL----------------------------*/
            PanelGif panelGif = new PanelGif(tipoUsuario, idProfessor);
            setContentPane(panelGif);

        } catch (IOException e) {
/*--------------------------TRATAMENTO DE EXCEÇÕES----------------------------*/
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: "
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

/*---------------------MÉTODO MAIN PARA EXECUTAR A TELA-----------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Exemplo com parâmetros para teste
            TelaGifPartidaEncerrada tela = 
                    new TelaGifPartidaEncerrada("prof123", "professor");
            tela.setVisible(true);
        });
    }

/*-----------------------CLASSE INTERNA: PAINEL DE ACESSO---------------------*/
    public class PanelGif extends JPanel {

/*-------------------------DECLARAÇÃO DE VARIÁVEIS----------------------------*/
        private JLabel labelGif;
        private String tipoUsuario;
        private String idProfessor;
        private javax.swing.Timer timer;

/*----------------------CONSTRUTOR DO PAINEL DE ACESSO------------------------*/
        public PanelGif(String tipoUsuario, String idProfessor) 
                throws IOException {
            this.tipoUsuario = tipoUsuario;
            this.idProfessor = idProfessor;

            setLayout(new BorderLayout());

/*----------------------CRIAR JLayeredPane PARA CAMADAS-----------------------*/
            JLayeredPane layeredPane = new JLayeredPane();

/*-------------------------CARREGAMENTO DAS IMAGENS---------------------------*/
            java.net.URL gifUrl = getClass().getResource
        ("/ImagensTelaGifPartidaEncerrada/gifPartidaEncerrada.gif");

            ImageIcon gifIcon = new ImageIcon(gifUrl);
            
            Image scaledImage = gifIcon.getImage().getScaledInstance
        (1620, 880, Image.SCALE_DEFAULT);
            gifIcon = new ImageIcon(scaledImage);

            sistema.pararMusica();

            labelGif = new JLabel(gifIcon, SwingConstants.CENTER);
            labelGif.setHorizontalAlignment(SwingConstants.CENTER);
            labelGif.setVerticalAlignment(SwingConstants.CENTER);
            labelGif.setBounds(0, 0, getWidth(), getHeight());

/*----------------------------BOTÃO INVISÍVEL---------------------------------*/
            JButton skipButton = new JButton();
            skipButton.setOpaque(false);
            skipButton.setContentAreaFilled(false);
            skipButton.setBorderPainted(false);
            skipButton.setFocusPainted(false);
            skipButton.setBounds(0, 0, getWidth(), getHeight());

/*------------------------ADICIONAR AO JLayeredPane---------------------------*/
            layeredPane.add(labelGif, JLayeredPane.DEFAULT_LAYER);
            layeredPane.add(skipButton, JLayeredPane.PALETTE_LAYER);

            add(layeredPane, BorderLayout.CENTER);

/*-----------------------AJUSTAR TAMANHO COM RESIZE---------------------------*/
            addComponentListener(new java.awt.event.ComponentAdapter()
            {
                public void componentResized(java.awt.event.ComponentEvent evt)
                {
                    labelGif.setBounds(0, 0, getWidth(), getHeight());
                    skipButton.setBounds(0, 0, getWidth(), getHeight());
                }
            });

            int duracaoGif = 22000;

            timer = new javax.swing.Timer(duracaoGif, (ActionEvent e) -> {
                transitionToNextScreen();
            });

            skipButton.addActionListener((ActionEvent e) -> {
                timer.stop(); // Para o timer para evitar transição dupla
                transitionToNextScreen();
            });

            timer.setRepeats(false);
            timer.start();
        }

/*--------------------------MÉTODO PARA TRANSIÇÃO-----------------------------*/
        private void transitionToNextScreen() {
            TelaRankAluno rankAluno = 
                    new TelaRankAluno("professor",idProfessor);
            rankAluno.setVisible(true);
            sistema.tocarMusica();
            fecharJanela();
        }

/*-------------------------MÉTODO PARA FECHAR JANELA--------------------------*/
        private void fecharJanela() {
            Window janela = SwingUtilities.getWindowAncestor(this);
            if (janela instanceof JFrame) {
                janela.dispose();
            }
        }
    }
}