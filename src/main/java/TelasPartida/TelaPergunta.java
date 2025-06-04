/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasPartida;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE PERGUNTA-----------------*/
public class TelaPergunta extends JFrame {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel painelPergunta;
    private static String idProfessor;

    /*----------------------CONSTRUTOR DA TELA DE PERGUNTA-------------------*/
    public TelaPergunta(String idProfessor) {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        painelPergunta = new JPanel(cardLayout);

        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelPergunta panelPergunta = new PanelPergunta();
            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(panelPergunta);

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
            TelaPergunta tela = new TelaPergunta(idProfessor);
            tela.setVisible(true);
        });
    }

    /*----------------------CLASSE INTERNA: PAINEL DE PERGUNTA---------------*/
    public static class PanelPergunta extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemFundoPergunta;
        private BufferedImage imagemBotaoAlternativaA;
        private BufferedImage imagemBotaoAlternativaB;
        private BufferedImage imagemBotaoAlternativaC;
        private BufferedImage imagemBotaoAlternativaD;
        private BufferedImage imagemBoxPontuacaoErro;
        private BufferedImage imagemBoxPontuacaoAcerto;
        private BufferedImage imagemBotaoAjuda;
        
        private JButton botaoAlternativaA;
        private JButton botaoAlternativaB;
        private JButton botaoAlternativaC;
        private JButton botaoAlternativaD;
        private JButton botaoAjuda;
        
        private JTextField campoTextoAcerto;
        private JTextField campoTextoErro;
        
        /*----------------------CONSTRUTOR DO PAINEL DE PERGUNTA-------------*/
         public PanelPergunta() throws IOException {
            setLayout(new GridBagLayout());
            
            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemFundoPergunta = ImageIO.read
        (getClass().getResource("/ImagensTelaPergunta/telaPergunta.png"));
            
            imagemBotaoAlternativaA = ImageIO.read
        (getClass().getResource("/ImagensTelaPergunta/botaoAlternativa.png"));
            
            imagemBotaoAlternativaB = ImageIO.read
        (getClass().getResource("/ImagensTelaPergunta/botaoAlternativa.png"));
            
            imagemBotaoAlternativaC = ImageIO.read
        (getClass().getResource("/ImagensTelaPergunta/botaoAlternativa.png"));
            
            imagemBotaoAlternativaD = ImageIO.read
        (getClass().getResource("/ImagensTelaPergunta/botaoAlternativa.png"));
            
            imagemBoxPontuacaoErro = ImageIO.read
        (getClass().getResource("/ImagensTelaPergunta/boxPontuacao.png"));
            
            imagemBoxPontuacaoAcerto = ImageIO.read
        (getClass().getResource("/ImagensTelaPergunta/boxPontuacao.png"));
            
            imagemBotaoAjuda = ImageIO.read
        (getClass().getResource("/ImagensTelaPergunta/botaoAjuda.png"));
            
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
                    int larguraBotAltA = (int) 
                            (imagemBotaoAlternativaA.getWidth() * 0.7 * escala);
                    int alturaBotAltA = (int) 
                            (imagemBotaoAlternativaA.getHeight() * 0.7 * escala);
                    
                    int larguraBotAltB = (int) 
                            (imagemBotaoAlternativaB.getWidth() * 0.7 * escala);
                    int alturaBotAltB = (int) 
                            (imagemBotaoAlternativaB.getHeight() * 0.7 * escala);
                    
                    int larguraBotAltC = (int) 
                            (imagemBotaoAlternativaC.getWidth() * 0.7 * escala);
                    int alturaBotAltC = (int) 
                            (imagemBotaoAlternativaC.getHeight() * 0.7 * escala);
                    
                    int larguraBotAltD = (int) 
                            (imagemBotaoAlternativaD.getWidth() * 0.7 * escala);
                    int alturaBotAltD = (int) 
                            (imagemBotaoAlternativaD.getHeight() * 0.7 * escala);
                    
                    int larguraBoxAcerto = (int) 
                            (imagemBoxPontuacaoAcerto.getWidth() * 0.2 * escala);
                    int alturaBoxAcerto = (int) 
                            (imagemBoxPontuacaoAcerto.getHeight() * 0.2 * escala);
                    
                    int larguraBoxErro = (int) 
                            (imagemBoxPontuacaoErro.getWidth() * 0.2 * escala);
                    int alturaBoxErro = (int) 
                            (imagemBoxPontuacaoErro.getHeight() * 0.2 * escala);
                    
                    int larguraBotAjuda = (int) 
                            (imagemBotaoAjuda.getWidth() * 0.2 * escala);
                    int alturaBotAjuda = (int) 
                            (imagemBotaoAjuda.getHeight() * 0.2 * escala);
                    
                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
                    int xAltA = centroX - (larguraBotAltA / 2) - 480;
                    int yAltA = (int) (h * 0.45) + 80;
                    
                    int xAltB = centroX - (larguraBotAltB / 2);
                    int yAltB = yAltA;
                    
                    int xAltC = centroX - (larguraBotAltC / 2) - 480;
                    int yAltC = yAltA + alturaBotAltA + (int) (30 * escala);
                    
                    int xAltD = centroX - (larguraBotAltD / 2);
                    int yAltD = yAltB + alturaBotAltB + (int)(30 * escala);
                    
                    int xAcerto = centroX - (larguraBoxAcerto / 2) - 500;
                    int yAcerto = yAltD + alturaBotAltD + (int)(10 * escala);
                    
                    int xErro = centroX - (larguraBoxErro / 2) - 250;
                    int yErro = yAltD + alturaBotAltD + (int)(10 * escala);
                    
                    int xAjuda = centroX - (larguraBotAjuda / 2);
                    int yAjuda = yAltD + alturaBotAltD + (int)(10 * escala);
                    
                    /*----------------------CONFIGURAÇÃO DOS BOTÕES--------------*/
                    botaoAlternativaA.setBounds(xAltA, 
                            yAltA, 
                            larguraBotAltA,
                            alturaBotAltA);
                    
                    botaoAlternativaB.setBounds(xAltB,
                            yAltB, 
                            larguraBotAltB, 
                            alturaBotAltB);
                    
                    botaoAlternativaC.setBounds(xAltC, 
                            yAltC, 
                            larguraBotAltC,
                            alturaBotAltC);
                    
                    botaoAlternativaD.setBounds(xAltD, 
                            yAltD, 
                            larguraBotAltD, 
                            alturaBotAltD);
                    
                    botaoAjuda.setBounds(xAjuda, 
                            yAjuda, 
                            larguraBotAjuda, 
                            alturaBotAjuda);
                    
                    /*----------------------CONFIGURAÇÃO DOS CAMPOS DE TEXTO-----*/
                    campoTextoAcerto.setBounds(xAcerto + (int)(77 * escala) - 12, 
                            yAcerto + (int)(27 * escala) - 15, 
                            (int)(150 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoErro.setBounds(xErro + (int)(77 * escala), 
                            yErro + (int)(27 * escala) - 15, 
                            (int)(150 * escala), 
                            (int)(50 * escala));
                    
                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemBotaoAlternativaA, 
                            xAltA, 
                            yAltA, 
                            larguraBotAltA, 
                            alturaBotAltA, this);
                    
                    g2d.drawImage(imagemBotaoAlternativaB, 
                            xAltB, 
                            yAltB, 
                            larguraBotAltB, 
                            alturaBotAltB, this);
                    
                    g2d.drawImage(imagemBotaoAlternativaC, 
                            xAltC, 
                            yAltC, 
                            larguraBotAltC, 
                            alturaBotAltC, this);
                    
                    g2d.drawImage(imagemBotaoAlternativaD, 
                            xAltD, 
                            yAltD, 
                            larguraBotAltD, 
                            alturaBotAltD, this);
                    
                    g2d.drawImage(imagemBoxPontuacaoAcerto, 
                            xAcerto, 
                            yAcerto, 
                            larguraBoxAcerto, 
                            alturaBoxAcerto, this);
                    
                    g2d.drawImage(imagemBoxPontuacaoErro, 
                            xErro, 
                            yErro, 
                            larguraBoxErro, 
                            alturaBoxErro, this);
                    
                    g2d.drawImage(imagemBotaoAjuda, 
                            xAjuda, 
                            yAjuda, 
                            larguraBotAjuda, 
                            alturaBotAjuda, this);
                    
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO ALTERNATIVA A------*/
            botaoAlternativaA = new JButton();
            botaoAlternativaA.setBorderPainted(false);
            botaoAlternativaA.setContentAreaFilled(false);
            botaoAlternativaA.setFocusPainted(false);
            botaoAlternativaA.setOpaque(false);
            botaoAlternativaA.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAlternativaA);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO ALTERNATIVA B------*/
            botaoAlternativaB = new JButton();
            botaoAlternativaB.setBorderPainted(false);
            botaoAlternativaB.setContentAreaFilled(false);
            botaoAlternativaB.setFocusPainted(false);
            botaoAlternativaB.setOpaque(false);
            botaoAlternativaB.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAlternativaB);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO ALTERNATIVA C------*/
            botaoAlternativaC = new JButton();
            botaoAlternativaC.setBorderPainted(false);
            botaoAlternativaC.setContentAreaFilled(false);
            botaoAlternativaC.setFocusPainted(false);
            botaoAlternativaC.setOpaque(false);
            botaoAlternativaC.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAlternativaC);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO ALTERNATIVA D------*/
            botaoAlternativaD = new JButton();
            botaoAlternativaD.setBorderPainted(false);
            botaoAlternativaD.setContentAreaFilled(false);
            botaoAlternativaD.setFocusPainted(false);
            botaoAlternativaD.setOpaque(false);
            botaoAlternativaD.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAlternativaD);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO AJUDA--------------*/
            botaoAjuda = new JButton();
            botaoAjuda.setBorderPainted(false);
            botaoAjuda.setContentAreaFilled(false);
            botaoAjuda.setFocusPainted(false);
            botaoAjuda.setOpaque(false);
            botaoAjuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAjuda);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO TEXTO ACERTO-------*/
            campoTextoAcerto = new JTextField();
            campoTextoAcerto.setBorder(null);
            campoTextoAcerto.setOpaque(false);
            campoTextoAcerto.setForeground(Color.BLACK);
            campoTextoAcerto.setFont(new Font("Jockey One", Font.BOLD, 30));
            campoTextoAcerto.setText("2 milhões");
            campoTextoAcerto.setEditable(false);
            campoTextoAcerto.setFocusable(false);
            painelConteudo.add(campoTextoAcerto);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO TEXTO ERRO---------*/
            campoTextoErro = new JTextField();
            campoTextoErro.setBorder(null);
            campoTextoErro.setOpaque(false);
            campoTextoErro.setForeground(Color.BLACK);
            campoTextoErro.setFont(new Font("Jockey One", Font.BOLD, 30));
            campoTextoErro.setText("500 mil");
            campoTextoErro.setEditable(false);
            campoTextoErro.setFocusable(false);
            painelConteudo.add(campoTextoErro);
            
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
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            
            /*----------------------DESENHO DA IMAGEM DE FUNDO---------------*/
            if (imagemFundoPergunta != null) {
                g2d.drawImage(imagemFundoPergunta, 0, 0, w, h, this);
            }
        } 
    }
}