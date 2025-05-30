package TelasPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaPergunta extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelPergunta;

    public TelaPergunta() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelPergunta = new JPanel(cardLayout);

        try {
            PanelPergunta panelPergunta = new PanelPergunta(); // Cria o painel
            add(panelPergunta); // Adiciona o painel diretamente ao JFrame

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPergunta tela = new TelaPergunta();
            tela.setVisible(true);
        });
    }

    public static class PanelPergunta extends JPanel {

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
        
         public PanelPergunta() throws IOException {
            setLayout(new GridBagLayout());
            
            imagemFundoPergunta = ImageIO.read(getClass().getResource("/ImagensTelaPergunta/telaPergunta.png"));
            imagemBotaoAlternativaA = ImageIO.read(getClass().getResource("/ImagensTelaPergunta/botaoAlternativa.png"));
            imagemBotaoAlternativaB = ImageIO.read(getClass().getResource("/ImagensTelaPergunta/botaoAlternativa.png"));
            imagemBotaoAlternativaC = ImageIO.read(getClass().getResource("/ImagensTelaPergunta/botaoAlternativa.png"));
            imagemBotaoAlternativaD = ImageIO.read(getClass().getResource("/ImagensTelaPergunta/botaoAlternativa.png"));
            imagemBoxPontuacaoErro = ImageIO.read(getClass().getResource("/ImagensTelaPergunta/boxPontuacao.png"));
            imagemBoxPontuacaoAcerto = ImageIO.read(getClass().getResource("/ImagensTelaPergunta/boxPontuacao.png"));
            imagemBotaoAjuda = ImageIO.read(getClass().getResource("/ImagensTelaPergunta/botaoAjuda.png"));
            
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

                    // Centro da tela
                    int centroX = w / 2;

                    // Dimensões dos elementos
                    double escala = 1.0; // Defina a escala conforme necessário
                    int larguraBotAltA = (int) (imagemBotaoAlternativaA.getWidth() * 0.7 * escala);
                    int alturaBotAltA = (int) (imagemBotaoAlternativaA.getHeight() * 0.7 * escala);
                    int larguraBotAltB = (int) (imagemBotaoAlternativaB.getWidth() * 0.7 * escala);
                    int alturaBotAltB = (int) (imagemBotaoAlternativaB.getHeight() * 0.7 * escala);
                    int larguraBotAltC = (int) (imagemBotaoAlternativaC.getWidth() * 0.7 * escala);
                    int alturaBotAltC = (int) (imagemBotaoAlternativaC.getHeight() * 0.7 * escala);
                    int larguraBotAltD = (int) (imagemBotaoAlternativaD.getWidth() * 0.7 * escala);
                    int alturaBotAltD = (int) (imagemBotaoAlternativaD.getHeight() * 0.7 * escala);
                    int larguraBoxAcerto = (int) (imagemBoxPontuacaoAcerto.getWidth() * 0.2 * escala);
                    int alturaBoxAcerto = (int) (imagemBoxPontuacaoAcerto.getHeight() * 0.2 * escala);
                    int larguraBoxErro = (int) (imagemBoxPontuacaoErro.getWidth() * 0.2 * escala);
                    int alturaBoxErro = (int) (imagemBoxPontuacaoErro.getHeight() * 0.2 * escala);
                    int larguraBotAjuda = (int) (imagemBotaoAjuda.getWidth() * 0.2 * escala);
                    int alturaBotAjuda = (int) (imagemBotaoAjuda.getHeight() * 0.2 * escala);
                    
                    int xAltA = centroX - (larguraBotAltA / 2) - 480;
                    int yAltA = (int) (h * 0.45) + 80; // 45% da altura da tela
                    int xAltB = centroX - (larguraBotAltB / 2);
                    int yAltB = yAltA; // 45% da altura da tela
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
                    
                    botaoAlternativaA.setBounds(xAltA, yAltA, larguraBotAltA, alturaBotAltA);
                    botaoAlternativaB.setBounds(xAltB, yAltB, larguraBotAltB, alturaBotAltB);
                    botaoAlternativaC.setBounds(xAltC, yAltC, larguraBotAltC, alturaBotAltC);
                    botaoAlternativaD.setBounds(xAltD, yAltD, larguraBotAltD, alturaBotAltD);
                    botaoAjuda.setBounds(xAjuda, yAjuda, larguraBotAjuda, alturaBotAjuda);
                    
                    campoTextoAcerto.setBounds(xAcerto + (int)(77 * escala) - 12, 
                            yAcerto + (int)(27 * escala) - 15, 
                            (int)(150 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoErro.setBounds(xErro + (int)(77 * escala), 
                            yErro + (int)(27 * escala) - 15, 
                            (int)(150 * escala), 
                            (int)(50 * escala));
                    
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
            painelConteudo.setOpaque(false);
            
            botaoAlternativaA = new JButton();
            botaoAlternativaA.setBorderPainted(false);
            botaoAlternativaA.setContentAreaFilled(false);
            botaoAlternativaA.setFocusPainted(false);
            botaoAlternativaA.setOpaque(false);
            botaoAlternativaA.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAlternativaA);
            
            botaoAlternativaB = new JButton();
            botaoAlternativaB.setBorderPainted(false);
            botaoAlternativaB.setContentAreaFilled(false);
            botaoAlternativaB.setFocusPainted(false);
            botaoAlternativaB.setOpaque(false);
            botaoAlternativaB.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAlternativaB);
            
            botaoAlternativaC = new JButton();
            botaoAlternativaC.setBorderPainted(false);
            botaoAlternativaC.setContentAreaFilled(false);
            botaoAlternativaC.setFocusPainted(false);
            botaoAlternativaC.setOpaque(false);
            botaoAlternativaC.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAlternativaC);
            
            botaoAlternativaD = new JButton();
            botaoAlternativaD.setBorderPainted(false);
            botaoAlternativaD.setContentAreaFilled(false);
            botaoAlternativaD.setFocusPainted(false);
            botaoAlternativaD.setOpaque(false);
            botaoAlternativaD.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAlternativaD);
            
            botaoAjuda = new JButton();
            botaoAjuda.setBorderPainted(false);
            botaoAjuda.setContentAreaFilled(false);
            botaoAjuda.setFocusPainted(false);
            botaoAjuda.setOpaque(false);
            botaoAjuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAjuda);
            
            campoTextoAcerto = new JTextField();
            campoTextoAcerto.setBorder(null);
            campoTextoAcerto.setOpaque(false);
            campoTextoAcerto.setForeground(Color.BLACK);
            campoTextoAcerto.setFont(new Font("Jockey One", Font.BOLD, 30));
            campoTextoAcerto.setText("2 milhões");
            campoTextoAcerto.setEditable(false);
            campoTextoAcerto.setFocusable(false);
            painelConteudo.add(campoTextoAcerto);
            
            campoTextoErro = new JTextField();
            campoTextoErro.setBorder(null);
            campoTextoErro.setOpaque(false);
            campoTextoErro.setForeground(Color.BLACK);
            campoTextoErro.setFont(new Font("Jockey One", Font.BOLD, 30));
            campoTextoErro.setText("500 mil");
            campoTextoErro.setEditable(false);
            campoTextoErro.setFocusable(false);
            painelConteudo.add(campoTextoErro);
            
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

            // Melhor qualidade de renderização
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            
            if (imagemFundoPergunta != null) {
                g2d.drawImage(imagemFundoPergunta, 0, 0, w, h, this);
            }
        } 
    }
}
