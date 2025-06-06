/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasPartida;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE ESPERA PROFESSOR----------*/
public class TelaEsperaProfessor extends JFrame {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel painelEspera;
    private static String idProfessor;
    private static String codigoSala;
    
    /*----------------------CONFIGURA O LAYOUT DE NAVEGAÇÃO------------------*/
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
        this.painelEspera = painelPrincipal;
    }
    
    /*----------------------CONSTRUTOR DA TELA DE ESPERA PROFESSOR-----------*/
    public TelaEsperaProfessor(String idProfessor, String codigoSala) {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;
        this.codigoSala = codigoSala;

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        painelEspera = new JPanel(cardLayout);
        
        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelEspera telaEsperaPanel = new PanelEspera();
            painelEspera.add(telaEsperaPanel, "TelaEsperaProfessor");
            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(painelEspera);
            cardLayout.show(painelEspera, "TelaEsperaProfessor");

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
            TelaEsperaProfessor tela = new TelaEsperaProfessor(idProfessor,
                                                                codigoSala);
            tela.setVisible(true);
        });
    }
    
    /*----------------------CLASSE INTERNA: PAINEL DE ESPERA-----------------*/
    public static class PanelEspera extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundoEspera;
        private BufferedImage imagemBotaoId;
        private BufferedImage imagemBotaoDesconectar;
        private BufferedImage imagemBotaoIniciar;
        
        private JButton botaoIdSala;
        private JButton botaoDesconectar;
        private JButton botaoIniciar;
        
        
        /*----------------------CONSTRUTOR DO PAINEL DE ESPERA---------------*/
        public PanelEspera() throws IOException {
            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundoEspera = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaProfessor/telaEsperaProfessor.png"));
            
            imagemBotaoId = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaProfessor/botaoIdSala.png"));
            
            imagemBotaoDesconectar = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaProfessor/botaoDesconectar.png"));
            
            imagemBotaoIniciar = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaProfessor/botaoIniciar.png"));
            
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
                    
                    int larguraIdSala = (int) 
                            (imagemBotaoId.getWidth() * 0.7 * escala);
                    int alturaIdSala = (int) 
                            (imagemBotaoId.getHeight() * 0.7 * escala);
                    
                    int larguraDesconectar = (int) 
                            (imagemBotaoDesconectar.getWidth() * 0.2 * escala);
                    int alturaDesconectar = (int) 
                            (imagemBotaoDesconectar.getHeight() * 0.2 * escala);
                    
                    int larguraIniciar = (int) 
                            (imagemBotaoIniciar.getWidth() * 0.2 * escala);
                    int alturaIniciar = (int) 
                            (imagemBotaoIniciar.getHeight() * 0.2 * escala);
                    
                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
                    int xId = centroX - (larguraIdSala / 2) - 390;
                    int yId = (int) (h * 0.45) - 250;
                    
                    int xDesc = centroX - (larguraDesconectar / 2) + 390;
                    int yDesc = (int) (h * 0.45) - 250;
                    
                    int xIniciar = centroX - (larguraIniciar / 2) + 375;
                    int yIniciar = yDesc - alturaDesconectar - (int)(10 * escala);
                    
                    /*----------------------CONFIGURAÇÃO DOS BOTÕES--------------*/
                    botaoIdSala.setBounds(xId, 
                            yId, 
                            larguraIdSala, 
                            alturaIdSala);
                    
                    botaoDesconectar.setBounds(xDesc, 
                            yDesc, 
                            larguraDesconectar, 
                            alturaDesconectar);
                    
                    botaoIniciar.setBounds(xIniciar, 
                            yIniciar, 
                            larguraIniciar, 
                            alturaIniciar);
                    
                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemBotaoId, 
                            xId, 
                            yId, 
                            larguraIdSala, 
                            alturaIdSala, this);
                    
                    g2d.drawImage(imagemBotaoDesconectar, 
                            xDesc, 
                            yDesc, 
                            larguraDesconectar, 
                            alturaDesconectar, this);
                    
                    g2d.drawImage(imagemBotaoIniciar, 
                            xIniciar, 
                            yIniciar, 
                            larguraIniciar, 
                            alturaIniciar, this);
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO ID SALA------------*/
            botaoIdSala = new JButton();
            botaoIdSala.setBorderPainted(false);
            botaoIdSala.setContentAreaFilled(false);
            botaoIdSala.setFocusPainted(false);
            botaoIdSala.setOpaque(false);
            botaoIdSala.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoIdSala.addActionListener(e -> {
                TelaAcesso criarSala = 
                                new TelaAcesso(idProfessor, codigoSala);
                        criarSala.setVisible(true);
                        Window janela = SwingUtilities.getWindowAncestor
                                        (PanelEspera.this);
                        if (janela instanceof JFrame) {
                            janela.dispose();
                        }
            });
            painelConteudo.add(botaoIdSala);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO DESCONECTAR--------*/
            botaoDesconectar = new JButton();
            botaoDesconectar.setBorderPainted(false);
            botaoDesconectar.setContentAreaFilled(false);
            botaoDesconectar.setFocusPainted(false);
            botaoDesconectar.setOpaque(false);
            botaoDesconectar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoDesconectar);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO INICIAR------------*/
            botaoIniciar = new JButton();
            botaoIniciar.setBorderPainted(false);
            botaoIniciar.setContentAreaFilled(false);
            botaoIniciar.setFocusPainted(false);
            botaoIniciar.setOpaque(false);
            botaoIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            painelConteudo.add(botaoIniciar);
            
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
            if (imagemDeFundoEspera != null) {
                g2d.drawImage(imagemDeFundoEspera, 0, 0, w, h, this);
            }
        }  
    }
}