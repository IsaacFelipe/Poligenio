/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasLobby;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import CodigoPoligenio.Sistema;
import TelasCriacaoSala.TelaCriarSala;
import TelasCriacaoSala.TelaCriarSala.PanelCriarSala;
import TelasDeLogin.TelaInicial;
import TelasLobby.TelaCadastrar.PanelCadastrar;
import TelasLobby.TelaConfiguracao.PanelConfiguracao;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE LOBBY PROFESSOR----------*/
public class TelaLobbyProfessor extends JFrame {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel painelLobbyProfessor;
    private static String idProfessor;
    
    /*----------------------CONFIGURA O LAYOUT DE NAVEGAÇÃO------------------*/
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }
    
    /*----------------------CONSTRUTOR DA TELA DE LOBBY PROFESSOR------------*/
    public TelaLobbyProfessor(String idProfessor){
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        painelLobbyProfessor = new JPanel(cardLayout);
        this.idProfessor = idProfessor;
        /*----------------------INSTANCIA O SISTEMA----------------------*/
        Sistema sistema = Sistema.getInstance();
        
        try {
            /*----------------------INSTANCIAÇÃO DOS PAINÉIS----------------*/
            PanelCadastrar telaCadastrarPanel = 
                    new PanelCadastrar(painelLobbyProfessor);
            PanelLobbyProfessor telaLobbyProfPanel = 
                    new PanelLobbyProfessor(painelLobbyProfessor);
            PanelCriarSala telaCriarSalaPanel = 
                    new PanelCriarSala(painelLobbyProfessor);
            TelaInicial telaInicial = 
                    new TelaInicial("", "", sistema);
            PanelConfiguracao telaConfigPanel = new PanelConfiguracao
                    (cardLayout, 
                    painelLobbyProfessor, 
                    painelLobbyProfessor, 
                    telaInicial, 
                    sistema);
            
            painelLobbyProfessor.add(telaLobbyProfPanel, "TelaLobbyProfessor");
            painelLobbyProfessor.add(telaCriarSalaPanel, "TelaCriarSala");
            painelLobbyProfessor.add(telaConfigPanel, "TelaConfiguracao");
            painelLobbyProfessor.add(telaCadastrarPanel, "TelaCadastrar");
            
            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(painelLobbyProfessor);
            cardLayout.show(painelLobbyProfessor, "TelaLobbyProfessor");

        } catch (IOException e) {
            /*----------------------TRATAMENTO DE EXCEÇÕES-------------------*/
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*----------------------MOSTRA TELA ESPECÍFICA NO CARD LAYOUT------------*/
    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelLobbyProfessor, nomeTela);
    }

    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLobbyProfessor telaLobbyProfessor = 
                    new TelaLobbyProfessor(idProfessor);
            telaLobbyProfessor.setVisible(true);
        });
    }
    
    /*----------------------CLASSE INTERNA: PAINEL DE LOBBY PROFESSOR--------*/
    public static class PanelLobbyProfessor extends JPanel {
        
        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundoLobbyProfessor;
        private BufferedImage imagemBotaoCriarSala;
        private BufferedImage imagemBotaoConfig;
        private BufferedImage imagemBotaoQuestionarios;
        private BufferedImage imagemBotaoCadastrar;
        
        private JButton botaoCriarSala;
        private JButton botaoConfig;
        private JButton botaoQuestionarios;
        private JButton botaoCadastrar;
        
        private final JPanel container;
        
        /*----------------------CONSTRUTOR DO PAINEL DE LOBBY PROFESSOR------*/
        public PanelLobbyProfessor(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());
            
            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundoLobbyProfessor = ImageIO.read(getClass().getResource
        ("/ImagensTelaLobbyProfessor/telaLobbyProfessor.png"));
            
            imagemBotaoCriarSala = ImageIO.read(getClass().getResource
        ("/ImagensTelaLobbyProfessor/botaoCriarSala.png"));
            
            imagemBotaoConfig = ImageIO.read(getClass().getResource
        ("/ImagensTelaLobbyProfessor/botaoConfig.png"));
            
            imagemBotaoQuestionarios = ImageIO.read(getClass().getResource
        ("/ImagensTelaLobbyProfessor/botaoQuestionarios.png"));
            
            imagemBotaoCadastrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaLobbyProfessor/botaoCadastrar.png"));
            
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
                    int larguraBotCriar = (int) 
                            (imagemBotaoCriarSala.getWidth() * 0.7 * escala);
                    int alturaBotCriar = (int) 
                            (imagemBotaoCriarSala.getHeight() * 0.7 * escala);
                    
                    int larguraBotConfig = (int) 
                            (imagemBotaoConfig.getWidth() * 0.7 * escala);
                    int alturaBotConfig = (int) 
                            (imagemBotaoConfig.getHeight() * 0.7 * escala);
                    
                    int larguraBotQuest = (int) 
                            (imagemBotaoQuestionarios.getWidth() * 0.7 * escala);
                    int alturaBotQuest = (int) 
                            (imagemBotaoQuestionarios.getHeight() * 0.7 * escala);
                    
                    int larguraBotCadast = (int) 
                            (imagemBotaoQuestionarios.getWidth() * 0.7 * escala);
                    int alturaBotCadast = (int) 
                            (imagemBotaoQuestionarios.getHeight() * 0.7 * escala);
                    
                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
                    int xJogar = centroX - (larguraBotCriar / 2) - 330;
                    int yJogar = (int) (h * 0.45) - 30; // 45% da altura da tela
                    
                    int xConfig = centroX - (larguraBotConfig / 2) - 330;
                    int yConfig = yJogar + alturaBotCriar + (int)(10 * escala); 
                    
                    int xQuest = centroX - (larguraBotQuest / 2) - 330;
                    int yQuest = yConfig + alturaBotConfig + (int)(10 * escala);
                    
                    int xCadas = centroX - (larguraBotCadast / 2) - 330;
                    int yCadas = yQuest + alturaBotQuest + (int)(10 * escala);
                    
                    /*----------------------CONFIGURAÇÃO DOS BOTÕES--------------*/
                    botaoCriarSala.setBounds(xJogar, 
                            yJogar,
                            larguraBotCriar, 
                            alturaBotCriar);
                    
                    botaoConfig.setBounds(xConfig, 
                            yConfig, 
                            larguraBotConfig, 
                            alturaBotConfig);
                    
                    botaoQuestionarios.setBounds(xQuest, 
                            yQuest,
                            larguraBotQuest,
                            alturaBotQuest);
                    
                    botaoCadastrar.setBounds(xCadas,
                            yCadas,
                            larguraBotCadast, 
                            alturaBotCadast);                    
                                        
                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemBotaoCriarSala, 
                            xJogar, 
                            yJogar, 
                            larguraBotCriar, 
                            alturaBotCriar, this);
                    
                    g2d.drawImage(imagemBotaoConfig, 
                            xConfig,
                            yConfig,
                            larguraBotConfig,
                            alturaBotConfig, this);
                    
                    g2d.drawImage(imagemBotaoQuestionarios,
                            xQuest,
                            yQuest, 
                            larguraBotQuest,
                            alturaBotQuest, this);
                    
                    g2d.drawImage(imagemBotaoCadastrar, 
                            xCadas, 
                            yCadas, 
                            larguraBotCadast, 
                            alturaBotCadast, this);
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO CRIAR SALA---------*/
            botaoCriarSala = new JButton();
            botaoCriarSala.setBorderPainted(false);
            botaoCriarSala.setContentAreaFilled(false);
            botaoCriarSala.setFocusPainted(false);
            botaoCriarSala.setOpaque(false);
            botaoCriarSala.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCriarSala.addActionListener(e -> {
                /*----------------------ABRE TELA DE CRIAR SALA--------------*/
                TelaCriarSala criarSala = new TelaCriarSala(idProfessor);
                criarSala.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                            (PanelLobbyProfessor.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                } 
            });
            painelConteudo.add(botaoCriarSala);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO CONFIGURAÇÃO-------*/
            botaoConfig = new JButton();
            botaoConfig.setBorderPainted(false);
            botaoConfig.setContentAreaFilled(false);
            botaoConfig.setFocusPainted(false);
            botaoConfig.setOpaque(false);
            botaoConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoConfig.addActionListener(e -> {
                /*----------------------NAVEGA PARA TELA DE CONFIGURAÇÃO-----*/
                ControleLobby.setOrigem(ControleLobby.Origem.LOBBY_PROFESSOR);
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "TelaConfiguracao");
            });
            painelConteudo.add(botaoConfig);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO QUESTIONÁRIOS------*/
            botaoQuestionarios = new JButton();
            botaoQuestionarios.setBorderPainted(false);
            botaoQuestionarios.setContentAreaFilled(false);
            botaoQuestionarios.setFocusPainted(false);
            botaoQuestionarios.setOpaque(false);
            botaoQuestionarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoQuestionarios.addActionListener(e -> {
                /*----------------------ABRE TELA DE QUESTIONÁRIOS-----------*/
                TelaQuestionario questionario = new TelaQuestionario();
                questionario.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                            (PanelLobbyProfessor.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                } 
            });
            painelConteudo.add(botaoQuestionarios);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO CADASTRAR----------*/
            botaoCadastrar = new JButton();
            botaoCadastrar.setBorderPainted(false);
            botaoCadastrar.setContentAreaFilled(false);
            botaoCadastrar.setFocusPainted(false);
            botaoCadastrar.setOpaque(false);
            botaoCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCadastrar.addActionListener(e -> {
                /*----------------------ABRE TELA DE CADASTRO----------------*/
                TelaCadastrar cadastrar = new TelaCadastrar(idProfessor);
                cadastrar.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                            (PanelLobbyProfessor.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                } 
            });
            painelConteudo.add(botaoCadastrar);
            
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
            if (imagemDeFundoLobbyProfessor != null) {
                g2d.drawImage(imagemDeFundoLobbyProfessor, 0, 0, w, h, this);
            }
        }
    }
}