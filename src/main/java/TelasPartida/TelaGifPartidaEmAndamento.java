package TelasPartida;

import CodigoPoligenio.Sistema;
import TelasLobby.TelaLobbyAluno;
import TelasLobby.TelaLobbyProfessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class TelaGifPartidaEmAndamento extends JFrame {
    Sistema sistema = Sistema.getInstance();
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private JPanel painelGif;
    private String idProfessor;
    private String tipoUsuario;

    /*----------------------CONSTRUTOR DA TELA DE ACESSO---------------------*/
    public TelaGifPartidaEmAndamento(String idProfessor) {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;
        this.tipoUsuario = "professor"; // Assumindo professor, ajustar se necessário

        painelGif = new JPanel();     

        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelGif panelGif = new PanelGif(idProfessor, tipoUsuario);
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
            TelaGifPartidaEmAndamento tela = new TelaGifPartidaEmAndamento("prof123");
            tela.setVisible(true);
        });
    }

    /*-----------------------CLASSE INTERNA: PAINEL DE ACESSO---------------------*/
    public class PanelGif extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private JLabel labelGif;
        private String tipoUsuario;
        private String idProfessor;
        private javax.swing.Timer timer;

        /*----------------------CONSTRUTOR DO PAINEL DE ACESSO---------------*/
        public PanelGif(String idProfessor, String tipoUsuario) throws IOException {
            this.idProfessor = idProfessor;
            this.tipoUsuario = tipoUsuario;

            setLayout(new BorderLayout());

            /*----------------------CRIAR JLayeredPane PARA CAMADAS------------------*/
            JLayeredPane layeredPane = new JLayeredPane();

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            java.net.URL gifUrl = getClass().getResource("/ImagensTelaGifPartidaEmAndamento/gifPartidaEmAndamento.gif");
            if (gifUrl == null) {
                throw new IOException("GIF file not found at /ImagensTelaGifPartidaEmAndamento/gifPartidaEmAndamento.gif");
            }
            ImageIcon gifIcon = new ImageIcon(gifUrl);
            
            Image scaledImage = gifIcon.getImage().getScaledInstance(1620, 880, Image.SCALE_DEFAULT);
            gifIcon = new ImageIcon(scaledImage);

            sistema.pararMusica();

            labelGif = new JLabel(gifIcon, SwingConstants.CENTER);
            labelGif.setHorizontalAlignment(SwingConstants.CENTER);
            labelGif.setVerticalAlignment(SwingConstants.CENTER);
            labelGif.setBounds(0, 0, getWidth(), getHeight());

            /*----------------------BOTÃO INVISÍVEL----------------------*/
            JButton skipButton = new JButton();
            skipButton.setOpaque(false);
            skipButton.setContentAreaFilled(false);
            skipButton.setBorderPainted(false);
            skipButton.setFocusPainted(false);
            skipButton.setBounds(0, 0, getWidth(), getHeight());

            /*----------------------ADICIONAR AO JLayeredPane------------------*/
            layeredPane.add(labelGif, JLayeredPane.DEFAULT_LAYER); // GIF na camada inferior
            layeredPane.add(skipButton, JLayeredPane.PALETTE_LAYER); // Botão na camada superior

            add(layeredPane, BorderLayout.CENTER);

            /*----------------------AJUSTAR TAMANHO COM RESIZE------------------*/
            addComponentListener(new java.awt.event.ComponentAdapter() {
                public void componentResized(java.awt.event.ComponentEvent evt) {
                    labelGif.setBounds(0, 0, getWidth(), getHeight());
                    skipButton.setBounds(0, 0, getWidth(), getHeight());
                }
            });

            int duracaoGif = 17400;

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

        /*----------------------MÉTODO PARA TRANSIÇÃO----------------------*/
        private void transitionToNextScreen() {
            TelaGifPartidaEncerrada gifPartidaEncerrada = new TelaGifPartidaEncerrada(idProfessor, tipoUsuario);
            gifPartidaEncerrada.setVisible(true);
            fecharJanela();
        }

        /*----------------------MÉTODO PARA FECHAR JANELA----------------------*/
        private void fecharJanela() {
            Window janela = SwingUtilities.getWindowAncestor(this);
            if (janela instanceof JFrame) {
                janela.dispose();
            }
        }
    }
}