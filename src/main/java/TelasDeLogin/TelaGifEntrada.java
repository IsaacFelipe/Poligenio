/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasDeLogin;

/*-------------------------IMPORTAÇÕES NECESSÁRIAS----------------------------*/
import CodigoPoligenio.Sistema;
import TelasLobby.TelaLobbyAluno;
import TelasLobby.TelaLobbyProfessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/*--------------------CLASSE PRINCIPAL DA TELA DE ENTRADA---------------------*/
public class TelaGifEntrada extends JFrame {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
    private JPanel painelGif;
    private String idProfessor;
    private String tipoUsuario;
    private Sistema sistema = Sistema.getInstance();

/*-----------------------CONSTRUTOR DA TELA DE ENTRADA------------------------*/
    public TelaGifEntrada(String idProfessor, String tipoUsuario) {
        
/*--------------------------CONFIGURAÇÕES DA JANELA---------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;
        this.tipoUsuario = tipoUsuario;

/*---------------------INSTANCIANDO O PAINEL DA CLASSE------------------------*/
        painelGif = new JPanel();

        try {
            PanelGif panelGif = new PanelGif(tipoUsuario, idProfessor);
            setContentPane(panelGif);
            
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

/*--------------------MÉTODO MAIN PARA EXECUTAR A TELA-----------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaGifEntrada tela = new TelaGifEntrada("", "");
            tela.setVisible(true);
        });
    }

/*-----------------------CLASSE INTERNA: PAINEL DE GIF------------------------*/
    public class PanelGif extends JPanel {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
        private JLabel labelGif;
        private String tipoUsuario;
        private String idProfessor;

/*-----------------------CONSTRUTOR DO PAINEL DE GIF--------------------------*/
        public PanelGif(String tipoUsuario, String idProfessor) 
                throws IOException {
            this.tipoUsuario = tipoUsuario;
            this.idProfessor = idProfessor;

/*--------------------------CONFIGURAÇÃO DO LAYOUT----------------------------*/
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;

/*------------------------CARREGAMENTO DAS IMAGENS----------------------------*/
            ImageIcon gifIcon = new ImageIcon(getClass().getResource
                    ("/ImagensTelaGifEntrada/gifEntrada.gif"));
            
            Image scaledImage = gifIcon.getImage().getScaledInstance
                    (1620, 880, Image.SCALE_DEFAULT);
            gifIcon = new ImageIcon(scaledImage);

/*--------------------------PARADA DA MÚSICA----------------------------------*/
            sistema.pararMusica();

/*--------------------------CONFIGURAÇÃO DO LABEL-----------------------------*/
            labelGif = new JLabel(gifIcon, SwingConstants.CENTER);
            labelGif.setHorizontalAlignment(SwingConstants.CENTER);
            labelGif.setVerticalAlignment(SwingConstants.CENTER);
            add(labelGif, gbc);

/*--------------------------CONFIGURAÇÃO DO TIMER-----------------------------*/
            int duracaoGif = 22000;
            javax.swing.Timer timer = 
                    new javax.swing.Timer(duracaoGif, (ActionEvent e) -> {
                        
/*---------------------------TRANSICAO PARA LOBBY-----------------------------*/
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

/*----------------------------FECHAMENTO DA JANELA----------------------------*/
                        Window janela = SwingUtilities.getWindowAncestor
                                (PanelGif.this);
                        if (janela instanceof JFrame) {
                            janela.dispose();
                        }
                    });

            timer.setRepeats(false);
            timer.start();
        }
    }
}