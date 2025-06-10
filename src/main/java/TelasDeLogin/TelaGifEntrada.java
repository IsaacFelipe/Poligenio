package TelasDeLogin;

import CodigoPoligenio.Sistema;
import TelasLobby.TelaLobbyAluno;
import TelasLobby.TelaLobbyProfessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class TelaGifEntrada extends JFrame {
    Sistema sistema = Sistema.getInstance();
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private JPanel painelGif;
    private String idProfessor;
    private String tipoUsuario;

    /*----------------------CONSTRUTOR DA TELA DE ACESSO---------------------*/
    public TelaGifEntrada(String idProfessor, String tipoUsuario) {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;
        this.tipoUsuario = tipoUsuario;

        painelGif = new JPanel();     

        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelGif panelGif = new PanelGif(tipoUsuario, idProfessor);
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
            TelaGifEntrada tela = new TelaGifEntrada("", "");
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
        public PanelGif(String tipoUsuario, String idProfessor) throws IOException {
            this.tipoUsuario = tipoUsuario;
            this.idProfessor = idProfessor;

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            ImageIcon gifIcon = new ImageIcon(getClass().getResource
                    ("/ImagensTelaGifEntrada/gifEntrada.gif"));
            
            Image scaledImage = gifIcon.getImage().getScaledInstance(1620, 880, Image.SCALE_DEFAULT);
            gifIcon = new ImageIcon(scaledImage);
            
            sistema.pararMusica();

            labelGif = new JLabel(gifIcon, SwingConstants.CENTER);
            labelGif.setHorizontalAlignment(SwingConstants.CENTER);
            labelGif.setVerticalAlignment(SwingConstants.CENTER);

            add(labelGif, gbc);

            int duracaoGif = 22000;

            javax.swing.Timer timer = 
                    new javax.swing.Timer(duracaoGif, (ActionEvent e) -> {
                        if (tipoUsuario.equalsIgnoreCase("professor")) {
                            TelaLobbyProfessor lobbyProfessor = 
                                    new TelaLobbyProfessor(idProfessor);
                            lobbyProfessor.setVisible(true);
                            sistema.tocarMusica();   
                        } 
                        else if (tipoUsuario.equalsIgnoreCase("aluno")) {
                            TelaLobbyAluno lobbyAluno = new TelaLobbyAluno();
                            lobbyAluno.setVisible(true);
                            sistema.tocarMusica();
                        }

                        Window janela = SwingUtilities.getWindowAncestor(PanelGif.this);
                        if (janela instanceof JFrame) {
                            janela.dispose();
                        }
                    });

            timer.setRepeats(false);
            timer.start();
        }
    }
}