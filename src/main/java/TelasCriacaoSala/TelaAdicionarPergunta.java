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
        private static String materiaSala;
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
        this.painelAdicionarPergunta = painelPrincipal;
    }
    
    public TelaAdicionarPergunta(String materiaSala) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.materiaSala = materiaSala;

        cardLayout = new CardLayout();
        painelAdicionarPergunta = new JPanel(cardLayout);

        try {
            PanelAdicionarPerguntas telaQuestionarioPanel = 
                    new PanelAdicionarPerguntas();
            
            painelAdicionarPergunta.add(telaQuestionarioPanel, 
                    "TelaAdicionarPergunta");
            
            add(painelAdicionarPergunta);
            
            cardLayout.show(painelAdicionarPergunta, "TelaAdicionarPergunta");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaAdicionarPergunta tela = new TelaAdicionarPergunta(materiaSala);
            tela.setVisible(true);
        });
    }
    public static class PanelAdicionarPerguntas extends JPanel {

        private BufferedImage imagemDeFundoAdicionarPerguntas;
        private BufferedImage imagemBotaoNovaQuestao;
        private BufferedImage imagemBoxMostrarMateria;
        private BufferedImage imagemBotaoCriarQuestionario;
        private BufferedImage imagemBotaoVoltar;
        private BufferedImage imagemBotaoDifFacil;
        private BufferedImage imagemBotaoDifMedio;
        private BufferedImage imagemBotaoDifDificil;
        private BufferedImage imagemTextoPergunta;
        private BufferedImage imagemTextoAlternativa1;
        private BufferedImage imagemTextoAlternativa3;
        private BufferedImage imagemTextoAlternativa2;
        private BufferedImage imagemTextoAlternativa4;
                
        private JButton botaoNovaQuestao;
        private JButton botaoCriarQuestionario;
        private JButton botaoDifFacil;
        private JButton botaoDifMedio;
        private JButton botaoDifDificil;
        private JButton botaoVoltar;
        
        private JTextField campoMostrarMateria;
        private JTextField campoTextoPergunta;
        private JTextField campoTextoAlternativa1;
        private JTextField campoTextoAlternativa3;
        private JTextField campoTextoAlternativa2;
        private JTextField campoTextoAlternativa4;
        
        public PanelAdicionarPerguntas() throws IOException {

            setLayout(new GridBagLayout());

            imagemDeFundoAdicionarPerguntas = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/telaAdicionarPergunta.png"));
            
            imagemBotaoNovaQuestao = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoNovaQuestao.png"));
            
            imagemBotaoCriarQuestionario = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoCriarQuestionario.png"));
            
            imagemBoxMostrarMateria = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/boxMostrarMateria.png"));
            
            imagemBotaoDifFacil = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoDifFacil.png"));
            
            imagemBotaoDifMedio = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoDifMedio.png"));
            
            imagemBotaoDifDificil = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoDifDificil.png"));
            
            imagemTextoPergunta = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/boxTextoPergunta.png"));
            
            imagemTextoAlternativa1 = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/boxAlternativa.png"));
            
            imagemTextoAlternativa3 = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/boxAlternativa.png"));
            
            imagemTextoAlternativa2 = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/boxAlternativa.png"));
            
            imagemTextoAlternativa4 = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/boxAlternativa.png"));
            
            imagemBotaoVoltar = ImageIO.read(getClass().getResource
                ("/ImagensTelaAdicionarPergunta/botaoVoltarAP.png"));
            
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
                    double escala = 1.0;
                    int larguraBotNewQuest = (int) 
                            (imagemBotaoNovaQuestao.getWidth() * 0.7 * escala);
                    int alturaBotNewQuest = (int) 
                            (imagemBotaoNovaQuestao.getHeight() * 0.7 * escala);
                    
                    int larguraBotCQuest = (int) 
                    (imagemBotaoCriarQuestionario.getWidth() * 0.7 * escala);
                    int alturaBotCQuest = (int) 
                    (imagemBotaoCriarQuestionario.getHeight() * 0.7 * escala);
                    
                    int larguraBoxMat = (int) 
                        (imagemBoxMostrarMateria.getWidth() * 0.7 * escala);
                    int alturaBoxMat = (int) 
                        (imagemBoxMostrarMateria.getHeight() * 0.7 * escala);
                    
                    int larguraBotFacil = (int) 
                            (imagemBotaoDifFacil.getWidth() * 0.7 * escala);
                    int alturaBotFacil = (int) 
                            (imagemBotaoDifFacil.getHeight() * 0.7 * escala);
                    
                    int larguraBotMedio = (int) 
                            (imagemBotaoDifMedio.getWidth() * 0.7 * escala);
                    int alturaBotMedio = (int) 
                            (imagemBotaoDifMedio.getHeight() * 0.7 * escala);
                    
                    int larguraBotDificil = (int) 
                            (imagemBotaoDifDificil.getWidth() * 0.7 * escala);
                    int alturaBotDificil = (int) 
                            (imagemBotaoDifDificil.getHeight() * 0.7 * escala);
                    
                    int larguraBoxPergunta = (int) 
                            (imagemTextoPergunta.getWidth() * 0.7 * escala);
                    int alturaBoxPergunta = (int) 
                            (imagemTextoPergunta.getHeight() * 0.7 * escala);
                    
                    int larguraBoxAlternativa1 = (int) 
                        (imagemTextoAlternativa1.getWidth() * 0.7 * escala);
                    int alturaBoxAlternativa1 = (int) 
                        (imagemTextoAlternativa1.getHeight() * 0.7 * escala);
                    
                    int larguraBoxAlternativa3 = (int) 
                        (imagemTextoAlternativa3.getWidth() * 0.7 * escala);
                    int alturaBoxAlternativa3 = (int) 
                        (imagemTextoAlternativa3.getHeight() * 0.7 * escala);
                    
                    int larguraBoxAlternativa2 = (int) 
                        (imagemTextoAlternativa2.getWidth() * 0.7 * escala);
                    int alturaBoxAlternativa2 = (int) 
                        (imagemTextoAlternativa2.getHeight() * 0.7 * escala);
                    
                    int larguraBoxAlternativa4 = (int) 
                        (imagemTextoAlternativa4.getWidth() * 0.7 * escala);
                    int alturaBoxAlternativa4 = (int) 
                        (imagemTextoAlternativa4.getHeight() * 0.7 * escala);
                    
                    int larguraBotVoltar = (int) 
                        (imagemBotaoVoltar.getWidth() * 0.7 * escala);
                    int alturaBotVoltar = (int) 
                        (imagemBotaoVoltar.getHeight() * 0.7 * escala);
                    
                    int xNovaQuest = centroX - (larguraBotNewQuest / 2) - 400;
                    int yNovaQuest = (int) (h * 0.45) + 340;
                    
                    int xCriarQuest = centroX - (larguraBotCQuest / 2) - 20;
                    int yCriarQuest = yNovaQuest;
                    
                    int xVoltar = centroX - (larguraBotVoltar / 2) + 365;
                    int yVoltar = yCriarQuest;
                    
                    int xBoxMat = centroX - (larguraBoxMat / 2) + 320;
                    int yBoxMat = (int) (h * 0.45) - 300;
                    
                    int xBotFac = (centroX - (larguraBotMedio / 2) - 20);
                    int yBotFac = (int) (h * 0.45) - 85;
                    
                    int xBotMed = (centroX - (larguraBotMedio / 2) + 250);
                    int yBotMed = (int) (h * 0.45) - 85;
                    
                    int xBotDif = (centroX - (larguraBotMedio / 2) + 520);
                    int yBotDif = (int) (h * 0.45) - 85;
                    
                    int xBoxPer = centroX - (larguraBoxPergunta / 2);
                    int yBoxPer = (int) (h * 0.45) - 170;
                    
                    int xBoxAlt1 = centroX - (larguraBoxAlternativa1 / 2) - 330;
                    int yBoxAlt1 = (int) (h * 0.45) + 40;
                    
                    int xBoxAlt3 = centroX - (larguraBoxAlternativa3 / 2) - 330;
                    int yBoxAlt3 = yBoxAlt1 + alturaBoxAlternativa1 
                            + (int)(60 * escala);
                    
                    int xBoxAlt2 = centroX - (larguraBoxAlternativa2 / 2) + 345;
                    int yBoxAlt2 = yBoxAlt1;
                    
                    int xBoxAlt4 = centroX - (larguraBoxAlternativa4 / 2) + 345;
                    int yBoxAlt4 = yBoxAlt3;
                    
                    botaoNovaQuestao.setBounds(xNovaQuest, 
                            yNovaQuest, 
                            larguraBotNewQuest, 
                            alturaBotNewQuest);
                    
                    botaoCriarQuestionario.setBounds(xCriarQuest, 
                            yCriarQuest, 
                            larguraBotCQuest, 
                            alturaBotCQuest);
                    
                    botaoDifFacil.setBounds(xBotFac + 40, 
                            yBotFac, 
                            larguraBotFacil - 80, 
                            alturaBotFacil);
                    
                    botaoDifMedio.setBounds(xBotMed + 40,
                            yBotMed, 
                            larguraBotMedio - 80, 
                            alturaBotMedio);
                    
                    botaoDifDificil.setBounds(xBotDif + 40, 
                            yBotDif, 
                            larguraBotDificil - 80,
                            alturaBotDificil);
                    
                    botaoVoltar.setBounds(xVoltar, 
                            yVoltar, 
                            larguraBotVoltar,
                            alturaBotVoltar);
                    
                    campoMostrarMateria.setBounds(xBoxMat + (int)(82 * escala), 
                            yBoxMat + (int)(1 * escala), 
                            (int)(250 * escala), 
                            (int)(50 * escala));
                                        
                    campoTextoPergunta.setBounds(xBoxPer + (int)(82 * escala), 
                            yBoxPer + (int)(1 * escala), 
                            (int)(900 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoAlternativa1.setBounds(xBoxAlt1 + 
                            (int)(82 * escala), 
                            yBoxAlt1 + 
                            (int)(1 * escala), 
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoAlternativa3.setBounds(xBoxAlt3 + 
                            (int)(82 * escala), 
                            yBoxAlt3 + 
                            (int)(1 * escala), 
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoAlternativa2.setBounds(xBoxAlt2 + 
                            (int)(82 * escala), 
                            yBoxAlt2 + 
                            (int)(1 * escala), 
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoAlternativa4.setBounds(xBoxAlt4 + 
                            (int)(82 * escala), 
                            yBoxAlt4 + 
                            (int)(1 * escala), 
                            (int)(300 * escala), 
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
                    
                    g2d.drawImage(imagemTextoPergunta, 
                            xBoxPer, 
                            yBoxPer, 
                            larguraBoxPergunta, 
                            alturaBoxPergunta, this);
                    
                    g2d.drawImage(imagemTextoAlternativa1, 
                            xBoxAlt1, 
                            yBoxAlt1, 
                            larguraBoxAlternativa1, 
                            alturaBoxAlternativa1, this);
                    
                    g2d.drawImage(imagemTextoAlternativa3, 
                            xBoxAlt3, 
                            yBoxAlt3, 
                            larguraBoxAlternativa3, 
                            alturaBoxAlternativa3, this);
                    
                    g2d.drawImage(imagemTextoAlternativa2, 
                            xBoxAlt2, 
                            yBoxAlt2, 
                            larguraBoxAlternativa2, 
                            alturaBoxAlternativa2, this);
                    
                    g2d.drawImage(imagemTextoAlternativa4, 
                            xBoxAlt4, 
                            yBoxAlt4, 
                            larguraBoxAlternativa4, 
                            alturaBoxAlternativa4, this);
                    
                    g2d.drawImage(imagemBotaoVoltar, 
                            xVoltar, 
                            yVoltar, 
                            larguraBotVoltar,
                            alturaBotVoltar, this);
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
            
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoVoltar);
            
            campoMostrarMateria = new JTextField();
            campoMostrarMateria.setBorder(null);
            campoMostrarMateria.setOpaque(false);
            campoMostrarMateria.setForeground(Color.BLACK);
            campoMostrarMateria.setFont(new Font("Jockey One", Font.BOLD, 35));
            campoMostrarMateria.setText(materiaSala);
            campoMostrarMateria.setEditable(false);
            campoMostrarMateria.setFocusable(false);
            painelConteudo.add(campoMostrarMateria);
            
            campoTextoPergunta = new JTextField();
            campoTextoPergunta.setBorder(null);
            campoTextoPergunta.setOpaque(false);
            campoTextoPergunta.setForeground(Color.BLACK);
            campoTextoPergunta.setFont(new Font("Jockey One", Font.BOLD, 35));
            painelConteudo.add(campoTextoPergunta);
            
            campoTextoAlternativa1 = new JTextField();
            campoTextoAlternativa1.setBorder(null);
            campoTextoAlternativa1.setOpaque(false);
            campoTextoAlternativa1.setForeground(Color.BLACK);
            campoTextoAlternativa1.setFont(new Font("Jockey One", Font.BOLD, 35));
            painelConteudo.add(campoTextoAlternativa1);
            
            campoTextoAlternativa3 = new JTextField();
            campoTextoAlternativa3.setBorder(null);
            campoTextoAlternativa3.setOpaque(false);
            campoTextoAlternativa3.setForeground(Color.BLACK);
            campoTextoAlternativa3.setFont(new Font("Jockey One", Font.BOLD, 35));
            painelConteudo.add(campoTextoAlternativa3);
            
            campoTextoAlternativa2 = new JTextField();
            campoTextoAlternativa2.setBorder(null);
            campoTextoAlternativa2.setOpaque(false);
            campoTextoAlternativa2.setForeground(Color.BLACK);
            campoTextoAlternativa2.setFont(new Font("Jockey One", Font.BOLD, 35));
            painelConteudo.add(campoTextoAlternativa2);
            
            campoTextoAlternativa4 = new JTextField();
            campoTextoAlternativa4.setBorder(null);
            campoTextoAlternativa4.setOpaque(false);
            campoTextoAlternativa4.setForeground(Color.BLACK);
            campoTextoAlternativa4.setFont(new Font("Jockey One", Font.BOLD, 35));
            painelConteudo.add(campoTextoAlternativa4);
            
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
            
            if (imagemDeFundoAdicionarPerguntas != null) {
                g2d.drawImage(imagemDeFundoAdicionarPerguntas, 
                        0, 
                        0, 
                        w, 
                        h, this);
            }
        }
    }
}