/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasLobby;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE CÓDIGO-------------------*/
public class TelaCodigo extends JFrame {

    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel painelCodigo;
    
    /*----------------------CONFIGURA O LAYOUT DE NAVEGAÇÃO------------------*/
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }

    /*----------------------CONSTRUTOR DA TELA DE CÓDIGO--------------------*/
    public TelaCodigo() {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        painelCodigo = new JPanel(cardLayout);

        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelCodigo telaCodigoPanel = new PanelCodigo(painelCodigo);
            
            painelCodigo.add(telaCodigoPanel, "TelaCodigo");
            
            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(painelCodigo);
            cardLayout.show(painelCodigo, "TelaCodigo");

        } catch (IOException e) {
            /*----------------------TRATAMENTO DE EXCEÇÕES-------------------*/
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                    "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*----------------------MOSTRA TELA ESPECÍFICA NO CARD LAYOUT------------*/
    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelCodigo, nomeTela);
    }

    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCodigo tela = new TelaCodigo();
            tela.setVisible(true);
        });
    }

    /*----------------------CLASSE INTERNA: PAINEL DE CÓDIGO-----------------*/
    public static class PanelCodigo extends JPanel {
        
        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private int xInput, yInput, larguraInputCod, alturaInputCod;

        private BufferedImage imagemDeFundoCodigo;
        private BufferedImage imagemBotaoEntrarCodigo;
        private BufferedImage imagemBotaoVoltarCodigo;
        private BufferedImage imagemInputCodigo;

        private JButton botaoEntrarCod;
        private JButton botaoVoltarCod;
        private JTextField campoTextoCodigo;
        
        private final JPanel container;

        /*----------------------CONSTRUTOR DO PAINEL DE CÓDIGO---------------*/
        public PanelCodigo(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundoCodigo = ImageIO.read
    (getClass().getResource("/ImagensTelaCodigo/telaCodigo.png"));
            
            imagemBotaoEntrarCodigo = ImageIO.read
    (getClass().getResource("/ImagensTelaCodigo/botaoEntrarCodigo.png"));
            
            imagemBotaoVoltarCodigo = ImageIO.read
    (getClass().getResource("/ImagensTelaCodigo/botaoVoltarCodigo.png"));
            
            imagemInputCodigo = ImageIO.read
    (getClass().getResource("/ImagensTelaCodigo/inputCodigo.png"));

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
                    int larguraEntarCod = (int) 
                            (imagemBotaoEntrarCodigo.getWidth() * 0.7 * escala);
                    int alturaEntrarCod = (int) 
                            (imagemBotaoEntrarCodigo.getHeight() * 0.7 * escala);
                    
                    int larguraBotVoltCod = (int) 
                            (imagemBotaoVoltarCodigo.getWidth() * 0.7 * escala);
                    int alturaBotVoltCod = (int) 
                            (imagemBotaoVoltarCodigo.getHeight() * 0.7 * escala);
                    
                    larguraInputCod = (int) 
                            (imagemInputCodigo.getWidth() * 0.7 * escala);
                    alturaInputCod = (int) 
                            (imagemInputCodigo.getHeight() * 0.7 * escala);

                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
                    xInput = centroX - (larguraInputCod/2) - 15;
                    yInput = (int) (h * 0.45) - 40;
                    
                    int xEntrar = centroX - (larguraEntarCod / 2) - 15;
                    int yEntrar = yInput + alturaInputCod + (int)(35 * escala); 
                    int xVolt = centroX - (larguraBotVoltCod / 2) - 15;
                    int yVolt = yEntrar + alturaEntrarCod + (int)(5 * escala); 

                    /*----------------------CONFIGURAÇÃO DOS BOTÕES E CAMPO------*/
                    botaoEntrarCod.setBounds(xEntrar, 
                            yEntrar, 
                            larguraEntarCod, 
                            alturaEntrarCod);
                    
                    botaoVoltarCod.setBounds(xVolt, 
                            yVolt, 
                            larguraBotVoltCod, 
                            alturaBotVoltCod);
                    
                    campoTextoCodigo.setBounds(xInput + 
                            (int)(77 * escala) + 200
                            , yInput + (int)(27 * escala) - 3, 
                            (int)(400 * escala), 
                            (int)(50 * escala));

                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemBotaoEntrarCodigo, 
                            xEntrar, 
                            yEntrar, 
                            larguraEntarCod, 
                            alturaEntrarCod, this);
                    
                    g2d.drawImage(imagemBotaoVoltarCodigo, 
                            xVolt, 
                            yVolt, 
                            larguraBotVoltCod, 
                            alturaBotVoltCod, this);
                    
                    g2d.drawImage(imagemInputCodigo, 
                            xInput, 
                            yInput, 
                            larguraInputCod, 
                            alturaInputCod, this);
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);

            /*----------------------CONFIGURAÇÃO DO BOTÃO ENTRAR-------------*/
            botaoEntrarCod = new JButton();
            botaoEntrarCod.setBorderPainted(false);
            botaoEntrarCod.setContentAreaFilled(false);
            botaoEntrarCod.setFocusPainted(false);
            botaoEntrarCod.setOpaque(false);
            botaoEntrarCod.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoEntrarCod);

            /*----------------------CONFIGURAÇÃO DO BOTÃO VOLTAR-------------*/
            botaoVoltarCod = new JButton();
            botaoVoltarCod.setBorderPainted(false);
            botaoVoltarCod.setContentAreaFilled(false);
            botaoVoltarCod.setFocusPainted(false);
            botaoVoltarCod.setOpaque(false);
            botaoVoltarCod.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltarCod.addActionListener(e -> {
                /*----------------------ABRE TELA DO LOBBY ALUNO---------*/
                TelaLobbyAluno criarSala = new TelaLobbyAluno();
                criarSala.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                            (PanelCodigo.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                } 
            });
            painelConteudo.add(botaoVoltarCod);

            /*----------------------CONFIGURAÇÃO DO CAMPO CÓDIGO-------------*/
            campoTextoCodigo = new JTextField();
            campoTextoCodigo.setBorder(null);
            campoTextoCodigo.setOpaque(false);
            campoTextoCodigo.setForeground(Color.BLACK);
            campoTextoCodigo.setFont(new Font("Jockey One", Font.BOLD, 30));
            painelConteudo.add(campoTextoCodigo);
            
            /*----------------------CONFIGURAÇÃO DO EVENTO DE CLIQUE---------*/
            painelConteudo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Rectangle areaInput = new Rectangle(xInput, yInput, larguraInputCod, alturaInputCod);
                    if (areaInput.contains(e.getPoint())) {
                        campoTextoCodigo.requestFocusInWindow();
                    }
                }       
            });
                    
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
            if (imagemDeFundoCodigo != null) {
                g2d.drawImage(imagemDeFundoCodigo, 0, 0, w, h, this);
            }
        }
    }
}