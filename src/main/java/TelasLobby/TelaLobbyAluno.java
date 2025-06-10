/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasLobby;

/*------------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import CodigoPoligenio.Sistema;
import TelasDeLogin.TelaInicial;
import TelasLobby.TelaCodigo.PanelCodigo;
import TelasLobby.TelaConfiguracao.PanelConfiguracao;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*------------------CLASSE PRINCIPAL DA TELA DE LOBBY ALUNO-------------------*/
public class TelaLobbyAluno extends JFrame {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
    private JPanel painelLobbyAluno;

/*----------------------CONSTRUTOR DA TELA DE LOBBY ALUNO---------------------*/
    public TelaLobbyAluno(){
/*----------------------------CONFIGURAÇÕES DA JANELA-------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelLobbyAluno = new JPanel();
        /*----------------------INSTANCIA O SISTEMA----------------------*/
        Sistema sistema = Sistema.getInstance();

        try {
            /*----------------------INSTANCIAÇÃO DOS PAINÉIS----------------*/
            PanelLobbyAluno telaLobbyAlunoPanel = 
                    new PanelLobbyAluno();
            setContentPane(telaLobbyAlunoPanel);

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
            TelaLobbyAluno telaPrincipal = new TelaLobbyAluno();
            telaPrincipal.setVisible(true);
        });
    }

    /*----------------------CLASSE INTERNA: PAINEL DE LOBBY ALUNO------------*/
    public static class PanelLobbyAluno extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundoLobbyAluno;
        private BufferedImage imagemBotaoJogar;
        private BufferedImage imagemBotaoConfig;
        private BufferedImage imagemBoxCash;

        private JButton botaoJogar;
        private JButton botaoConfig;
        private JTextField campoCash;

        /*----------------------CONSTRUTOR DO PAINEL DE LOBBY ALUNO----------*/
        public PanelLobbyAluno() throws IOException {
            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundoLobbyAluno = ImageIO.read
        (getClass().getResource("/ImagensTelaLobbyAluno/telaLobbyAluno.png"));
            
            imagemBotaoJogar = ImageIO.read
        (getClass().getResource("/ImagensTelaLobbyAluno/botaoJogar.png"));
            
            imagemBotaoConfig = ImageIO.read
        (getClass().getResource("/ImagensTelaLobbyAluno/botaoConfig.png"));
            
            imagemBoxCash = ImageIO.read
        (getClass().getResource("/ImagensTelaLobbyAluno/boxCash.png"));

            /*----------------------CRIAÇÃO DO PAINEL DE CONTEÚDO-------------*/
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    /*----------------------CONFIGURAÇÃO GRÁFICA----------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

                    /*----------------------CALCULA O CENTRO DA TELA------------*/
                    int centroX = w / 2;

                    /*----------------------DIMENSÕES DOS ELEMENTOS--------------*/
                    double escala = 1.0; // Defina a escala conforme necessário
                    int larguraBotJogar = (int) 
                            (imagemBotaoJogar.getWidth() * 0.7 * escala);
                    int alturaBotJogar = (int) 
                            (imagemBotaoJogar.getHeight() * 0.7 * escala);
                    
                    int larguraBotConfig = (int) 
                            (imagemBotaoConfig.getWidth() * 0.7 * escala);
                    int alturaBotConfig = (int) 
                            (imagemBotaoConfig.getHeight() * 0.7 * escala);
                    
                    int larguraBoxCash = (int) 
                            (imagemBoxCash.getWidth() * 0.7 * escala);
                    int alturaBoxCash = (int) 
                            (imagemBoxCash.getHeight() * 0.7 * escala);

                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
                    int xJogar = centroX - (larguraBotJogar / 2) - 320;
                    int yJogar = (int) (h * 0.45) + 20;
                    
                    int xConfig = centroX - (larguraBotJogar / 2) - 320;
                    int yConfig = yJogar + alturaBotJogar + (int)(20 * escala);
                    
                    int xCash = centroX + (larguraBotJogar / 3);
                    int yCash = yConfig + alturaBotConfig + (int)(20 * escala);

                    /*----------------------CONFIGURAÇÃO DOS BOTÕES E CAMPO------*/
                    botaoJogar.setBounds(xJogar, 
                            yJogar, 
                            larguraBotJogar,
                            alturaBotJogar);
                    
                    botaoConfig.setBounds(xConfig,
                            yConfig, 
                            larguraBotConfig, 
                            alturaBotConfig);
                    
                    campoCash.setBounds(xCash + (int)(77 * escala) + 140, 
                            yCash + (int)(27 * escala) - 18, 
                            (int)(400 * escala), 
                            (int)(50 * escala));

                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemBotaoJogar,
                            xJogar,
                            yJogar, 
                            larguraBotJogar,
                            alturaBotJogar, this);
                    
                    g2d.drawImage(imagemBotaoConfig,
                            xConfig, 
                            yConfig, 
                            larguraBotConfig, 
                            alturaBotConfig, this);
                    
                    g2d.drawImage(imagemBoxCash,
                            xCash,
                            yCash, 
                            larguraBoxCash, 
                            alturaBoxCash, this);
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);

            /*----------------------CONFIGURAÇÃO DO BOTÃO JOGAR--------------*/
            botaoJogar = new JButton();
            botaoJogar.setBorderPainted(false);
            botaoJogar.setContentAreaFilled(false);
            botaoJogar.setFocusPainted(false);
            botaoJogar.setOpaque(false);
            botaoJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoJogar.addActionListener(e -> {
                /*----------------------ABRE TELA DE CÓDIGO------------------*/
                TelaCodigo criarSala;
                try {
                    criarSala = new TelaCodigo();
                    criarSala.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaLobbyAluno.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                
                Window janela = SwingUtilities.getWindowAncestor
                            (PanelLobbyAluno.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                } 
            });
            painelConteudo.add(botaoJogar);

            /*----------------------CONFIGURAÇÃO DO BOTÃO CONFIGURAÇÃO-------*/
            botaoConfig = new JButton();
            botaoConfig.setBorderPainted(false);
            botaoConfig.setContentAreaFilled(false);
            botaoConfig.setFocusPainted(false);
            botaoConfig.setOpaque(false);
            botaoConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoConfig.addActionListener(e -> {
                /*----------------------NAVEGA PARA TELA DE CONFIGURAÇÃO-----*/
                ControleLobby.setOrigem(ControleLobby.Origem.LOBBY_ALUNO);
                TelaConfiguracao configuracao = 
                                new TelaConfiguracao("");
                        configuracao.setVisible(true);
                        
                        Window janela = SwingUtilities.getWindowAncestor
                                (PanelLobbyAluno.this);
                        if (janela instanceof JFrame) {
                            janela.dispose();
                        } 
            });
            painelConteudo.add(botaoConfig);

            /*----------------------CONFIGURAÇÃO DO CAMPO CASH---------------*/
            campoCash = new JTextField();
            campoCash.setBorder(null);
            campoCash.setOpaque(false);
            campoCash.setForeground(Color.BLACK);
            campoCash.setFont(new Font("Jockey One", Font.BOLD, 40));
            campoCash.setText("1.000");
            campoCash.setEditable(false);
            campoCash.setFocusable(false);
            painelConteudo.add(campoCash);

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
            if (imagemDeFundoLobbyAluno != null) {
                g2d.drawImage(imagemDeFundoLobbyAluno, 
                        0, 
                        0,
                        w, 
                        h, this);
            }
        }
    }
}