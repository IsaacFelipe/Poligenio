package TelasPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaEsperaProfessor extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelEspera;
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
        this.painelEspera = painelPrincipal;
    }
    
    public TelaEsperaProfessor() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelEspera = new JPanel(cardLayout);
        
        try {
            PanelEspera telaEsperaPanel = new PanelEspera();
            painelEspera.add(telaEsperaPanel, "TelaEsperaProfessor");
            add(painelEspera);
            cardLayout.show(painelEspera, "TelaEsperaProfessor");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaEsperaProfessor tela = new TelaEsperaProfessor();
            tela.setVisible(true);
        });
    }
    
    public static class PanelEspera extends JPanel {

        private BufferedImage imagemDeFundoEspera;
        private BufferedImage imagemBotaoId;
        private BufferedImage imagemBotaoDesconectar;
        private BufferedImage imagemBotaoIniciar;
        
        private JButton botaoIdSala;
        private JButton botaoDesconectar;
        private JButton botaoIniciar;
        
        public PanelEspera() throws IOException {
            setLayout(new GridBagLayout());

            imagemDeFundoEspera = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaProfessor/telaEsperaProfessor.png"));
            
            imagemBotaoId = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaProfessor/botaoIdSala.png"));
            
            imagemBotaoDesconectar = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaProfessor/botaoDesconectar.png"));
            
            imagemBotaoIniciar = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaProfessor/botaoIniciar.png"));
            
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
                    
                    int xId = centroX - (larguraIdSala / 2) - 390;
                    int yId = (int) (h * 0.45) - 250;
                    
                    int xDesc = centroX - (larguraDesconectar / 2) + 390;
                    int yDesc = (int) (h * 0.45) - 250;
                    
                    int xIniciar = centroX - (larguraIniciar / 2) + 375;
                    int yIniciar = yDesc - alturaDesconectar - (int)(10 * escala);
                    
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
            painelConteudo.setOpaque(false);
            
            botaoIdSala = new JButton();
            botaoIdSala.setBorderPainted(false);
            botaoIdSala.setContentAreaFilled(false);
            botaoIdSala.setFocusPainted(false);
            botaoIdSala.setOpaque(false);
            botaoIdSala.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoIdSala);
            
            botaoDesconectar = new JButton();
            botaoDesconectar.setBorderPainted(false);
            botaoDesconectar.setContentAreaFilled(false);
            botaoDesconectar.setFocusPainted(false);
            botaoDesconectar.setOpaque(false);
            botaoDesconectar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoDesconectar);
            
            botaoIniciar = new JButton();
            botaoIniciar.setBorderPainted(false);
            botaoIniciar.setContentAreaFilled(false);
            botaoIniciar.setFocusPainted(false);
            botaoIniciar.setOpaque(false);
            botaoIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoIniciar);
            
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
            
            if (imagemDeFundoEspera != null) {
                g2d.drawImage(imagemDeFundoEspera, 0, 0, w, h, this);
            }
        }  
    }
}
