package TelasCriacaoSala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaEditarPergunta extends JFrame {
private CardLayout cardLayout;
    private JPanel painelEditarPergunta;
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
        this.painelEditarPergunta = painelPrincipal;
    }
    
    public TelaEditarPergunta() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelEditarPergunta = new JPanel(cardLayout);

        try {
            PanelEditarPergunta telaEditQuestionarioPanel = 
                    new PanelEditarPergunta();
            
            painelEditarPergunta.add(telaEditQuestionarioPanel, 
                    "TelaEditarPergunta");
            
            add(painelEditarPergunta);
            cardLayout.show(painelEditarPergunta, "TelaEditarPergunta");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaEditarPergunta tela = new TelaEditarPergunta();
            tela.setVisible(true);
        });
    }
    public static class PanelEditarPergunta extends JPanel {

        private BufferedImage imagemDeFundoEditarPerguntas;
        private BufferedImage imagemBoxMaterias;
        
        private JTextField campoTextoMateria;
        
        public PanelEditarPergunta() throws IOException {
            setLayout(new GridBagLayout());

            imagemDeFundoEditarPerguntas = ImageIO.read(getClass().getResource
                ("/ImagensTelaEditarPergunta/telaEditarPergunta.png"));
            
            imagemBoxMaterias = ImageIO.read(getClass().getResource
                ("/ImagensTelaEditarPergunta/boxMateria.png"));
            
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
                    
                   int larguraBoxMateria = (int) 
                            (imagemBoxMaterias.getWidth() * 0.7 * escala);
                    int alturaBoxMateria = (int) 
                            (imagemBoxMaterias.getHeight() * 0.7 * escala);
                    
                    int xBoxMateria = centroX - (larguraBoxMateria / 2) + 300;
                    int yBoxMateria = (int) (h * 0.45) - 320;
                    
                    campoTextoMateria.setBounds(xBoxMateria + (int)(100 * escala), 
                            yBoxMateria + (int)(20 * escala), 
                            (int)(200 * escala), 
                            (int)(50 * escala));
                    
                    g2d.drawImage(imagemBoxMaterias, 
                            xBoxMateria, 
                            yBoxMateria, 
                            larguraBoxMateria, 
                            alturaBoxMateria, this);
                }
            };
            painelConteudo.setOpaque(false);
            setLayout(new BorderLayout());
            
            campoTextoMateria = new JTextField();
            campoTextoMateria.setBorder(null);
            campoTextoMateria.setOpaque(false);
            campoTextoMateria.setForeground(Color.BLACK);
            campoTextoMateria.setFont(new Font("Jockey One", Font.BOLD, 32));
            campoTextoMateria.setHorizontalAlignment(JTextField.CENTER);
            campoTextoMateria.setText("Matemática");
            campoTextoMateria.setEditable(false);
            campoTextoMateria.setFocusable(false);
            painelConteudo.add(campoTextoMateria);
            
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
            
            if (imagemDeFundoEditarPerguntas != null) {
                g2d.drawImage(imagemDeFundoEditarPerguntas, 0, 0, w, h, this);
            }
        }
    }

}