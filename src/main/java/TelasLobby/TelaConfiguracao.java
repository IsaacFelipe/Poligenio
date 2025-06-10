/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasLobby;

/*------------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import CodigoPoligenio.Sistema;
import TelasDeLogin.TelaInicial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*--------------------CLASSE PRINCIPAL DA TELA DE CONFIGURAÇÃO----------------*/
public class TelaConfiguracao extends JFrame {
    
/*---------------------------DECLARAÇÃO DE VARIÁVEIS--------------------------*/
    private JPanel painelConfiguracao;
    private static String idProfessor;
    
/*----------------------CONSTRUTOR DA TELA DE CONFIGURAÇÃO--------------------*/
    public TelaConfiguracao(String idProfessor) {
        
/*---------------------------CONFIGURAÇÕES DA JANELA--------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelConfiguracao = new JPanel();
        this.idProfessor = idProfessor;
        
/*----------------------------INSTANCIA O SISTEMA-----------------------------*/
        Sistema sistema = Sistema.getInstance();
        
        try {
            
/*---------------------------INSTANCIAÇÃO DO PAINEL---------------------------*/
            PanelConfiguracao telaConfigPanel = 
                    new PanelConfiguracao(painelConfiguracao, 
                            sistema);
            setContentPane(telaConfigPanel);
            
        } 
        
/*---------------------------TRATAMENTO DE EXCEÇÕES---------------------------*/
        catch (IOException e) {           
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                    "Erro ao inicializar a tela: " 
                        + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
/*-----------------------MÉTODO MAIN PARA EXECUTAR A TELA---------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaConfiguracao tela = new TelaConfiguracao(idProfessor);
            tela.setVisible(true);
        });
    }
    
/*-------------------CLASSE INTERNA: PAINEL DE CONFIGURAÇÃO-------------------*/
    public static class PanelConfiguracao extends JPanel {

/*-------------------------DECLARAÇÃO DE VARIÁVEIS----------------------------*/
        private BufferedImage imagemDeFundoConfiguracao;
        private BufferedImage imagemBotaoAudioOn;
        private BufferedImage imagemBotaoAudioOff;
        private BufferedImage imagemBotaoSairConfig;
        private BufferedImage imagemBotaoDesconectar;
        
        private JButton botaoAudioOn;
        private JButton botaoAudioOff;
        private JButton botaoSair;
        private JButton botaoDesconectar;
        
        private final JPanel painelPrincipal;
        private final boolean musicaTocando = true;
        private final Sistema sistema;
        
/*----------------------CONSTRUTOR DO PAINEL DE CONFIGURAÇÃO------------------*/
        public PanelConfiguracao( 
                JPanel painelPrincipal, 
                Sistema sistema) throws IOException {
            
            this.sistema = sistema;
            this.painelPrincipal = painelPrincipal;
            setLayout(new GridBagLayout());

/*--------------------------CARREGAMENTO DAS IMAGENS--------------------------*/
            imagemDeFundoConfiguracao = ImageIO.read(getClass().getResource
        ("/ImagensTelaConfiguracao/telaConfiguracao.png"));
            
            imagemBotaoAudioOn = ImageIO.read(getClass().getResource
        ("/ImagensTelaConfiguracao/botaoMusicaOn.png"));
            
            imagemBotaoAudioOff = ImageIO.read(getClass().getResource
        ("/ImagensTelaConfiguracao/botaoMusicaOff.png"));
            
            imagemBotaoSairConfig = ImageIO.read(getClass().getResource
        ("/ImagensTelaConfiguracao/botaoSairConfig.png"));
            
            imagemBotaoDesconectar = ImageIO.read(getClass().getResource
        ("/ImagensTelaConfiguracao/botaoDesconectar.png"));
            
/*------------------------CRIAÇÃO DO PAINEL DE CONTEÚDO-----------------------*/
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

/*-----------------------------CONFIGURAÇÃO GRÁFICA---------------------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

/*---------------------------CALCULA O CENTRO DA TELA-------------------------*/
                    int centroX = w / 2;

/*---------------------------DIMENSÕES DOS ELEMENTOS--------------------------*/
                    double escala = 1.0; //Definição de escala
                    
                    int larguraAudioOn = (int) 
                            (imagemBotaoAudioOn.getWidth() * 0.7 * escala);
                    int alturaAudioOn = (int) 
                            (imagemBotaoAudioOn.getHeight() * 0.7 * escala);
                    
                    int larguraAudioOff = (int) 
                            (imagemBotaoAudioOff.getWidth() * 0.7 * escala);
                    int alturaAudioOff = (int) 
                            (imagemBotaoAudioOff.getHeight() * 0.7 * escala);
                    
                    int larguraSair = (int) 
                            (imagemBotaoSairConfig.getWidth() * 0.7 * escala);
                    int alturaSair = (int) 
                            (imagemBotaoSairConfig.getHeight() * 0.7 * escala);
                    
                    int larguraDesconectar = (int) 
                            (imagemBotaoDesconectar.getWidth() * 0.7 * escala);
                    int alturaDesconectar = (int) 
                            (imagemBotaoDesconectar.getHeight() * 0.7 * escala);
                    
/*------------------------POSICIONAMENTO DOS ELEMENTOS------------------------*/
                    int xAudioON = centroX - (larguraAudioOn / 2) - 90;
                    int yAudioON = (int) (h * 0.45);
                    
                    int xAudioOFF = centroX - (alturaAudioOff / 2) + 90;
                    int yAudioOFF = (int) (h * 0.45) - 7;
                    
                    int xSair = centroX - (larguraSair / 2) - 150;
                    int ySair = yAudioOFF 
                            + alturaAudioOff 
                            + (int)(170 * escala);
                    
                    int xDescon = centroX - (larguraDesconectar / 2) + 150;
                    int yDescon = yAudioON + alturaAudioOn + (int)(176 * escala);
                    
                    /*----------------------CONFIGURAÇÃO DOS BOTÕES--------------*/
                    botaoAudioOn.setBounds(xAudioON, 
                            yAudioON, 
                            larguraAudioOn, 
                            alturaAudioOn);
                    
                    botaoAudioOff.setBounds(xAudioOFF, 
                            yAudioOFF, 
                            larguraAudioOff, 
                            alturaAudioOff);
                    
                    botaoSair.setBounds(xSair, 
                            ySair, 
                            larguraSair, 
                            alturaSair);
                    
                    botaoDesconectar.setBounds(xDescon,
                            yDescon, 
                            larguraDesconectar, 
                            alturaDesconectar);
                    
                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemBotaoAudioOff, 
                            xAudioOFF, 
                            yAudioOFF, 
                            larguraAudioOff, 
                            alturaAudioOff, this);
                    
                    g2d.drawImage(imagemBotaoAudioOn, 
                            xAudioON, 
                            yAudioON,
                            larguraAudioOn, 
                            alturaAudioOn, this);
                    
                    g2d.drawImage(imagemBotaoSairConfig,
                            xSair,
                            ySair, 
                            larguraSair,
                            alturaSair, this);
                    
                    g2d.drawImage(imagemBotaoDesconectar,
                            xDescon,
                            yDescon, 
                            larguraDesconectar,
                            alturaDesconectar, this);
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO ÁUDIO ON-----------*/
            botaoAudioOn = new JButton();
            botaoAudioOn.setBorderPainted(false);
            botaoAudioOn.setContentAreaFilled(false);
            botaoAudioOn.setFocusPainted(false);
            botaoAudioOn.setOpaque(false);
            botaoAudioOn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAudioOn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*----------------------INICIA A MÚSICA------------------*/
                    sistema.tocarMusica();
                    repaint();
                }
            });
            painelConteudo.add(botaoAudioOn);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO ÁUDIO OFF----------*/
            botaoAudioOff = new JButton();
            botaoAudioOff.setBorderPainted(false);
            botaoAudioOff.setContentAreaFilled(false);
            botaoAudioOff.setFocusPainted(false);
            botaoAudioOff.setOpaque(false);
            botaoAudioOff.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAudioOff.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*----------------------PARA A MÚSICA--------------------*/
                    sistema.pararMusica();
                    repaint();
                }
            });
            painelConteudo.add(botaoAudioOff);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO DESCONECTAR--------*/
            botaoDesconectar = new JButton();
            botaoDesconectar.setBorderPainted(false);
            botaoDesconectar.setContentAreaFilled(false);
            botaoDesconectar.setFocusPainted(false);
            botaoDesconectar.setOpaque(false);
            botaoDesconectar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoDesconectar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*----------------------ABRE TELA INICIAL----------------*/
                    TelaInicial inicial = new TelaInicial("", "", sistema);
                    inicial.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                        (PanelConfiguracao.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    } 
                }
            });
            painelConteudo.add(botaoDesconectar);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO SAIR---------------*/
            botaoSair = new JButton();
            botaoSair.setBorderPainted(false);
            botaoSair.setContentAreaFilled(false);
            botaoSair.setFocusPainted(false);
            botaoSair.setOpaque(false);
            botaoSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoSair.addActionListener(e -> {
                /*----------------------NAVEGA PARA TELA DE ORIGEM-----------*/
                switch (ControleLobby.getOrigem()) {
                    case LOBBY_PROFESSOR:
                        TelaLobbyProfessor lobbyProfessor = 
                                new TelaLobbyProfessor(idProfessor);
                        lobbyProfessor.setVisible(true);
                        
                        Window janelaProf = SwingUtilities.getWindowAncestor
                                            (PanelConfiguracao.this);
                        if (janelaProf instanceof JFrame) {
                            janelaProf.dispose();
                        }
                        break;
                    case LOBBY_ALUNO:
                        TelaLobbyAluno lobbyAluno = new TelaLobbyAluno();
                        lobbyAluno.setVisible(true);
                        
                        Window janelaAluno = SwingUtilities.getWindowAncestor
                                            (PanelConfiguracao.this);
                        if (janelaAluno instanceof JFrame) {
                            janelaAluno.dispose();
                        }
                        break;
                }
            });
            painelConteudo.add(botaoSair);
            
            /*----------------------CONFIGURAÇÃO DO LAYOUT--------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
            
        }
        
        /*----------------------PINTURA DO FUNDO DO PAINEL-------------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

            /*----------------------CONFIGURAÇÃO DE RENDERIZAÇÃO-------------*/
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, 
                    RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, 
                    RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, 
                    RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, 
                    RenderingHints.VALUE_STROKE_PURE);
            
            /*----------------------DESENHO DA IMAGEM DE FUNDO---------------*/
            if (imagemDeFundoConfiguracao != null) {
                g2d.drawImage(imagemDeFundoConfiguracao, 0, 0, w, h, this);
            }
        }
    }
}