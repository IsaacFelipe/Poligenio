package TelasCriacaoSala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaAdicionarPergunta extends JFrame {
private CardLayout cardLayout;
    private JPanel painelAdicionarPergunta;
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
        this.painelAdicionarPergunta = painelPrincipal;
    }
    
    public TelaAdicionarPergunta() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelAdicionarPergunta = new JPanel(cardLayout);

        try {
            PanelAdicionarPerguntas telaQuestionarioPanel = new PanelAdicionarPerguntas(painelAdicionarPergunta);
            painelAdicionarPergunta.add(telaQuestionarioPanel, "TelaAdicionarPergunta");
            add(painelAdicionarPergunta);
            cardLayout.show(painelAdicionarPergunta, "TelaAdicionarPergunta");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaAdicionarPergunta tela = new TelaAdicionarPergunta();
            tela.setVisible(true);
        });
    }
    public static class PanelAdicionarPerguntas extends JPanel {

        private BufferedImage imagemDeFundoAdicionarPerguntas;
        private BufferedImage imagemBotaoNovaQuestao;
        private BufferedImage imagemBoxMostrarMateria;
        private BufferedImage imagemBotaoCriarQuestionario;
        private BufferedImage imagemBotaoDifFacil;
        private BufferedImage imagemBotaoDifMedio;
        private BufferedImage imagemBotaoDifDificil;
                
        private JButton botaoNovaQuestao;
        private JButton botaoCriarQuestionario;
        private JButton botaoDifFacil;
        private JButton botaoDifMedio;
        private JButton botaoDifDificil;  
        
        private JTextField campoMostrarMateria;
        
        private final JPanel container;
        
        
        public PanelAdicionarPerguntas(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            imagemDeFundoAdicionarPerguntas = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/telaAdicionarPergunta.png"));
            imagemBotaoNovaQuestao = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoNovaQuestao.png"));
            imagemBotaoCriarQuestionario = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoCriarQuestionario.png"));
            imagemBoxMostrarMateria = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/boxMostrarMateria.png"));
            imagemBotaoDifFacil= ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoDifFacil.png"));
            imagemBotaoDifMedio= ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoDifMedio.png"));
            imagemBotaoDifDificil= ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoDifDificil.png"));
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
                    int larguraBotNewQuest = (int) (imagemBotaoNovaQuestao.getWidth() * 0.7 * escala);
                    int alturaBotNewQuest = (int) (imagemBotaoNovaQuestao.getHeight() * 0.7 * escala);
                    int larguraBotCQuest = (int) (imagemBotaoCriarQuestionario.getWidth() * 0.7 * escala);
                    int alturaBotCQuest = (int) (imagemBotaoCriarQuestionario.getHeight() * 0.7 * escala);
                    int larguraBoxMat = (int) (imagemBoxMostrarMateria.getWidth() * 0.7 * escala);
                    int alturaBoxMat = (int) (imagemBoxMostrarMateria.getHeight() * 0.7 * escala);
                    int larguraBotFacil = (int) (imagemBotaoDifFacil.getWidth() * 0.7 * escala);
                    int alturaBotFacil = (int) (imagemBotaoDifFacil.getHeight() * 0.7 * escala);
                    int larguraBotMedio = (int) (imagemBotaoDifMedio.getWidth() * 0.7 * escala);
                    int alturaBotMedio = (int) (imagemBotaoDifMedio.getHeight() * 0.7 * escala);
                    int larguraBotDificil = (int) (imagemBotaoDifDificil.getWidth() * 0.7 * escala);
                    int alturaBotDificil = (int) (imagemBotaoDifDificil.getHeight() * 0.7 * escala);
                    
                    int xNovaQuest = centroX - (larguraBotNewQuest / 2) - 240;
                    int yNovaQuest = (int) (h * 0.45) + 340; // 45% da altura da tela
                    int xCriarQuest = centroX - (larguraBotCQuest / 2) + 240;
                    int yCriarQuest = (int) (h * 0.45) + 340; // 45% da altura da tela
                    int xBoxMat = centroX - (larguraBoxMat / 2) + 320;
                    int yBoxMat = (int) (h * 0.45) - 300; // 45% da altura da tela
                    int xBotFac = (centroX - (larguraBotMedio / 2) - 20);
                    int yBotFac = (int) (h * 0.45) - 85; // 45% da altura da tela
                    int xBotMed = (centroX - (larguraBotMedio / 2) + 250);
                    int yBotMed = (int) (h * 0.45) - 85;
                    int xBotDif = (centroX - (larguraBotMedio / 2) + 520);
                    int yBotDif = (int) (h * 0.45) - 85;
                    
                    botaoNovaQuestao.setBounds(xNovaQuest, yNovaQuest, larguraBotNewQuest, alturaBotNewQuest);
                    botaoCriarQuestionario.setBounds(xCriarQuest, yCriarQuest, larguraBotCQuest, alturaBotCQuest);
                    botaoDifFacil.setBounds(xBotFac + 40, yBotFac, larguraBotFacil - 80, alturaBotFacil);
                    botaoDifMedio.setBounds(xBotMed + 40, yBotMed, larguraBotMedio - 80, alturaBotMedio);
                    botaoDifDificil.setBounds(xBotDif + 40, yBotDif, larguraBotDificil - 80, alturaBotDificil);
                    
                    campoMostrarMateria.setBounds(xBoxMat + (int)(77 * escala) + 5, 
                            yBoxMat + (int)(27 * escala) - 26, 
                            (int)(200 * escala), 
                            (int)(50 * escala));
                    
                    g2d.drawImage(imagemBotaoNovaQuestao, 
                            xNovaQuest, 
                            yNovaQuest, 
                            larguraBotNewQuest, 
                            alturaBotNewQuest, this);
                    
                    g2d.drawImage(imagemBotaoCriarQuestionario, 
                            xCriarQuest, 
                            yCriarQuest, 
                            larguraBotCQuest, 
                            alturaBotCQuest, this);
                    
                    g2d.drawImage(imagemBoxMostrarMateria, 
                            xBoxMat, 
                            yBoxMat, 
                            larguraBoxMat, 
                            alturaBoxMat, this);
                    
                    g2d.drawImage(imagemBotaoDifFacil, 
                            xBotFac, 
                            yBotFac, 
                            larguraBotFacil, 
                            alturaBotFacil, this);
                    
                    g2d.drawImage(imagemBotaoDifMedio, 
                            xBotMed, 
                            yBotMed, 
                            larguraBotMedio, 
                            alturaBotMedio, this);
                    
                    g2d.drawImage(imagemBotaoDifDificil, 
                            xBotDif, 
                            yBotDif, 
                            larguraBotDificil, 
                            alturaBotDificil, this);
                }
            };
            painelConteudo.setOpaque(false);
            setLayout(new BorderLayout());
            
            botaoNovaQuestao = new JButton();
            botaoNovaQuestao.setBorderPainted(false);
            botaoNovaQuestao.setContentAreaFilled(false);
            botaoNovaQuestao.setFocusPainted(false);
            botaoNovaQuestao.setOpaque(false);
            botaoNovaQuestao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoNovaQuestao);
            
            botaoCriarQuestionario = new JButton();
            botaoCriarQuestionario.setBorderPainted(false);
            botaoCriarQuestionario.setContentAreaFilled(false);
            botaoCriarQuestionario.setFocusPainted(false);
            botaoCriarQuestionario.setOpaque(false);
            botaoCriarQuestionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoCriarQuestionario);
            
            botaoDifFacil = new JButton();
            botaoDifFacil.setBorderPainted(false);
            botaoDifFacil.setContentAreaFilled(false);
            botaoDifFacil.setFocusPainted(false);
            botaoDifFacil.setOpaque(false);
            botaoDifFacil.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoDifFacil);
            
            botaoDifMedio = new JButton();
            botaoDifMedio.setBorderPainted(false);
            botaoDifMedio.setContentAreaFilled(false);
            botaoDifMedio.setFocusPainted(false);
            botaoDifMedio.setOpaque(false);
            botaoDifMedio.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoDifMedio);
            
            botaoDifDificil = new JButton();
            botaoDifDificil.setBorderPainted(false);
            botaoDifDificil.setContentAreaFilled(false);
            botaoDifDificil.setFocusPainted(false);
            botaoDifDificil.setOpaque(false);
            botaoDifDificil.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoDifDificil);
            
            campoMostrarMateria = new JTextField();
            campoMostrarMateria.setBorder(null);
            campoMostrarMateria.setOpaque(false);
            campoMostrarMateria.setForeground(Color.BLACK);
            campoMostrarMateria.setFont(new Font("Jockey One", Font.BOLD, 40));
            campoMostrarMateria.setText("");
            campoMostrarMateria.setEditable(true);
            campoMostrarMateria.setFocusable(true);
            painelConteudo.add(campoMostrarMateria);
            
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
            
            if (imagemDeFundoAdicionarPerguntas != null) {
                g2d.drawImage(imagemDeFundoAdicionarPerguntas, 0, 0, w, h, this);
            }
        }
    }

}