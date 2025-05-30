package TelasPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaAcesso extends JFrame{
    
    private CardLayout cardLayout;
    private JPanel painelAcesso;
   
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }

    public TelaAcesso() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardLayout = new CardLayout();
        painelAcesso = new JPanel(cardLayout);

        try {
           PanelAcesso panelRank = new PanelAcesso();
           painelAcesso.add(panelRank, "TelaAcesso");
           add(painelAcesso);
           cardLayout.show(painelAcesso, "TelaAcesso");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaAcesso tela = new TelaAcesso();
            tela.setVisible(true);
        });
    }
    public static class PanelAcesso extends JPanel {

        private BufferedImage imagemFundoAcesso;
        private BufferedImage imagemBotaoVoltar;
        
        private JButton botaoVoltar;
        
         public PanelAcesso() throws IOException {
            setLayout(new GridBagLayout());
            
            imagemFundoAcesso = ImageIO.read(getClass().getResource
        ("/ImagensTelaAcesso/telaAcesso.png"));
            
            imagemBotaoVoltar = ImageIO.read(getClass().getResource
        ("/ImagensTelaAcesso/botaoVoltar.png"));
            
         JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

                    // Centro da tela
                    int centroX = w / 2;

                    // Dimensões dos elementos
                    double escala = 1.0; // Defina a escala conforme necessário
                    
                    int larguraBotVoltar = (int) 
                            (imagemBotaoVoltar.getWidth() * 0.7 * escala);
                    int alturaBotVoltar = (int) 
                            (imagemBotaoVoltar.getHeight() * 0.7 * escala);
                    
                    int xVoltar = centroX - (larguraBotVoltar / 2);
                    int yVoltar = (int) (h * 0.45) + 300; // 45% da altura da tela
                    
                    botaoVoltar.setBounds(xVoltar, 
                            yVoltar, 
                            larguraBotVoltar, 
                            alturaBotVoltar);
                    
                    g2d.drawImage(imagemBotaoVoltar, 
                            xVoltar, 
                            yVoltar, 
                            larguraBotVoltar, 
                            alturaBotVoltar, this);
                }
            };
            painelConteudo.setOpaque(false);

            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoVoltar);

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
            
            if (imagemFundoAcesso != null) {
                g2d.drawImage(imagemFundoAcesso, 0, 0, w, h, this);
            }
        } 
    }
}