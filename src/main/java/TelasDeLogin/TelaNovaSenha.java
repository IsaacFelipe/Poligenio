package TelasDeLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaNovaSenha extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel TelaNovaSenha;
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }
    
    public TelaNovaSenha(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        TelaNovaSenha = new JPanel(cardLayout);
        
        try {
            PanelNovaSenha telaNovaSenhaPanel = new PanelNovaSenha(TelaNovaSenha);
            TelaNovaSenha.add(telaNovaSenhaPanel, "TelaNovaSenha");
            add(TelaNovaSenha);
            cardLayout.show(TelaNovaSenha, "TelaNovaSenha");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaNovaSenha telaNovaSenha = new TelaNovaSenha();
            telaNovaSenha.setVisible(true);
        });
    }
    
    public void mostrarTela(String nomeTela) {
            cardLayout.show(TelaNovaSenha, nomeTela);
    }
    
    public static class PanelNovaSenha extends JPanel {
        
        private BufferedImage imagemDeFundoNovaSenha;
        private BufferedImage imagemInputNovaSenha;
        private BufferedImage imagemInputConfirmarSenha;
        private BufferedImage imagemBotaoEnviarNovaSenha;
        private BufferedImage imagemBotaoVoltarLogin;
        
        private JPasswordField campoNovaSenha;
        private JPasswordField campoConfirmarSenha;
        
        private JButton botaoEnviar;
        private JButton botaoVoltarLogin;
        
        private final JPanel container;
        public PanelNovaSenha(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());
            
            imagemDeFundoNovaSenha = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/telaNovaSenha.png"));
            imagemInputNovaSenha = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/inputNovaSenha.png"));
            imagemInputConfirmarSenha = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/inputConfirmarSenha.png"));
            imagemBotaoEnviarNovaSenha = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/botaoEnviarNS.png"));
            imagemBotaoVoltarLogin = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/botaoVoltarLogin.png"));
            
            // Camada sobre o fundo
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
                    int larguraInputNS = (int) (imagemInputNovaSenha.getWidth() * 0.7 * escala);
                    int alturaInputNS = (int) (imagemInputNovaSenha.getHeight() * 0.7 * escala);
                    int larguraInputConfirmar = (int) (imagemInputConfirmarSenha.getWidth() * 0.7 * escala);
                    int alturaInputConfirmar = (int) (imagemInputConfirmarSenha.getHeight() * 0.7 * escala);
                    int larguraBotaoEnviar = (int) (imagemBotaoEnviarNovaSenha.getWidth() * 0.7 * escala);
                    int alturaBotaoEnviar = (int) (imagemBotaoEnviarNovaSenha.getHeight() * 0.7 * escala);
                    int larguraBotaoVoltar = (int) (imagemBotaoVoltarLogin.getWidth() * 0.7 * escala);
                    int alturaBotaoVoltar = (int) (imagemBotaoVoltarLogin.getHeight() * 0.7 * escala);
                    
                    int xNovaSenha = centroX - (larguraInputNS / 2);
                    int yNovaSenha = (int) (h * 0.45) + 50; // 45% da altura da tela
                    int xConfirmSenha = centroX - (larguraInputConfirmar / 2);
                    int yConfirmSenha = yNovaSenha + alturaInputNS + (int)(20 * escala);
                    int xBotaoEnviar = centroX - (larguraBotaoEnviar / 2);
                    int yBotaoEnviar = yConfirmSenha + alturaInputConfirmar + (int)(60 * escala);
                    int xBotaoVoltar = centroX - (larguraBotaoVoltar / 2);
                    int yBotaoVoltar = yBotaoEnviar + alturaBotaoVoltar + (int)(90 * escala);
                    
                    campoNovaSenha.setBounds(xNovaSenha + (int)(77 * escala) + 80, 
                            yNovaSenha + (int)(27 * escala) - 22, 
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
                    campoConfirmarSenha.setBounds(xConfirmSenha + (int)(77 * escala) + 185, 
                            yConfirmSenha + (int)(27 * escala) - 22, 
                            (int)(200 * escala), 
                            (int)(50 * escala));
                    
                    botaoEnviar.setBounds(xBotaoEnviar, yBotaoEnviar, larguraBotaoEnviar, alturaBotaoEnviar);
                    botaoVoltarLogin.setBounds(xBotaoVoltar, yBotaoVoltar, larguraBotaoVoltar, alturaBotaoVoltar);
                    
                    g2d.drawImage(imagemInputNovaSenha, xNovaSenha, yNovaSenha, larguraInputNS, alturaInputNS, this);
                    
                    g2d.drawImage(imagemBotaoVoltarLogin, 
                            xBotaoVoltar, 
                            yBotaoVoltar, 
                            larguraBotaoVoltar, 
                            alturaBotaoVoltar, this);
                    
                    g2d.drawImage(imagemBotaoEnviarNovaSenha, 
                            xBotaoEnviar, 
                            yBotaoEnviar, 
                            larguraBotaoEnviar, 
                            alturaBotaoEnviar, this);
                    
                    g2d.drawImage(imagemInputConfirmarSenha, 
                            xConfirmSenha, 
                            yConfirmSenha, 
                            larguraInputConfirmar, 
                            alturaInputConfirmar, this);
                }
            };
            painelConteudo.setOpaque(false);
            
            campoNovaSenha = new JPasswordField();
            campoNovaSenha.setBorder(null);
            campoNovaSenha.setOpaque(false);
            campoNovaSenha.setForeground(Color.BLACK);
            campoNovaSenha.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoNovaSenha);
            
            campoConfirmarSenha = new JPasswordField();
            campoConfirmarSenha.setBorder(null);
            campoConfirmarSenha.setOpaque(false);
            campoConfirmarSenha.setForeground(Color.BLACK);
            campoConfirmarSenha.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoConfirmarSenha);
            
            botaoEnviar = new JButton();
            botaoEnviar.setBorderPainted(false);
            botaoEnviar.setContentAreaFilled(false);
            botaoEnviar.setFocusPainted(false);
            botaoEnviar.setOpaque(false);
            botaoEnviar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoEnviar);
            
            botaoVoltarLogin = new JButton();
            botaoVoltarLogin.setBorderPainted(false);
            botaoVoltarLogin.setContentAreaFilled(false);
            botaoVoltarLogin.setFocusPainted(false);
            botaoVoltarLogin.setOpaque(false);
            botaoVoltarLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltarLogin.addActionListener(e -> {
                CardLayout cl = (CardLayout) container.getLayout();
                cl.show(container, "TelaRecuperarSenha");
                campoConfirmarSenha.setText("");
                campoNovaSenha.setText("");
            });
            painelConteudo.add(botaoVoltarLogin);
            
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
            
            if (imagemDeFundoNovaSenha != null) {
                g2d.drawImage(imagemDeFundoNovaSenha, 0, 0, w, h, this);
            }
        }
    }  
}
