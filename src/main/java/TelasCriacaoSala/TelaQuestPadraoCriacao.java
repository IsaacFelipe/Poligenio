package TelasCriacaoSala;

import CodigoPoligenio.Professor;
import CodigoPoligenio.Sistema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaQuestPadraoCriacao extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelQuestPadraoCriacao;
    private static String materiaSelecionada;
    private static String serieSelecionadaText;
    private static String materia;
    private static String serie;
    private static String idProfessor;
    private static JTextField campoTextoNomeMateria;
    private static JTextField campoTextoSerie;
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }

    public TelaQuestPadraoCriacao(String materia, String serieSelecionadaText) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.materia = materia;
        this.serie = serieSelecionadaText;

        cardLayout = new CardLayout();
        painelQuestPadraoCriacao = new JPanel(cardLayout);

        try {
            PanelQuestPadraoCriacao panelQuestPersonalizada = new 
                    PanelQuestPadraoCriacao(painelQuestPadraoCriacao);
            
            painelQuestPadraoCriacao.add(panelQuestPersonalizada, 
                    "TelaQuestPadraoCriacao");
            
            add(painelQuestPadraoCriacao);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaQuestPadraoCriacao tela = 
                    new TelaQuestPadraoCriacao(materia, serieSelecionadaText);
            tela.setVisible(true);
        });
    }
    
    public void setMateriaSelecionada(String materia) {
        this.materiaSelecionada = materia;
        campoTextoNomeMateria.setText(materia);
    }
    
    public void setSerieSelecionada(String serieSelecionadaText) {
        this.serie = serieSelecionadaText;
        campoTextoSerie.setText(serieSelecionadaText);
    }
    
    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelQuestPadraoCriacao, nomeTela);
    }

    public static class PanelQuestPadraoCriacao extends JPanel {

        private BufferedImage imagemDeFundoQuestPadraoCriacao;
        private BufferedImage imagemNomeQuiz;
        private BufferedImage imagemBoxMateria;
        private BufferedImage imagemBoxSerie;
        private BufferedImage imagemBotaoCriarQuest;
        private BufferedImage imagemBotaoVoltarQuest;        
        private BufferedImage imagemBotaoDicasOff;
        private BufferedImage imagemBotaoDicasOn;
        
        private JButton botaoDica = null;
        private String dicaSelecionada = null;
        
        private JLabel labelDicasOn;

        private final JPanel container;

        private JButton botaoCriar;
        private JButton botaoVoltar;
        private JButton botaoBoxMaterias;
        private JButton botaoDicasOff;
        private JTextField campoTextoNomeQuest;
        private JTextField campoTextoSerie;
        
        private boolean dicaAtivada = false;

        public PanelQuestPadraoCriacao(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            imagemDeFundoQuestPadraoCriacao = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPadraoCriacao/telaQuestPadraoCriacao.png"));
            
            imagemNomeQuiz = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPadraoCriacao/boxNomeQuiz.png"));
            
            imagemBoxMateria = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPadraoCriacao/boxNomeQuiz.png"));
            
            imagemBoxSerie = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPadraoCriacao/boxNomeQuiz.png"));
            
            imagemBotaoCriarQuest = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPadraoCriacao/botaoCriarQuest.png"));
            
            imagemBotaoVoltarQuest = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPadraoCriacao/botaoVoltarQuest.png"));
            
            imagemBotaoDicasOn = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPadraoCriacao/botaoDicasAtivado.png"));
            
            imagemBotaoDicasOff = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPadraoCriacao/botaoDicasDesativado.png"));

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

                    int centroX = w / 2;

/*-------------------------Dimensão dos elementos da tela---------------------*/

                    double escala = 1.0;
                    
                    int larguraNomeQuiz = (int) 
                            (imagemNomeQuiz.getWidth() * 0.7 * escala);
                    int alturaNomeQuiz = (int) 
                            (imagemNomeQuiz.getHeight() * 0.7 * escala);
                    
                    int larguraBoxMateria = (int) 
                            (imagemBoxMateria.getWidth() * 0.7 * escala);
                    int alturaBoxMateria = (int) 
                            (imagemBoxMateria.getHeight() * 0.7 * escala);
                    
                    int larguraBoxSerie = (int) 
                            (imagemBoxSerie.getWidth() * 0.7 * escala);
                    int alturaBoxSerie = (int) 
                            (imagemBoxSerie.getHeight() * 0.7 * escala);
                    
                    int larguraCriarQuest = (int) 
                            (imagemBotaoCriarQuest.getWidth() * 0.7 * escala);
                    int alturaCriarQuest = (int) 
                            (imagemBotaoCriarQuest.getHeight() * 0.7 * escala);
                    
                    int larguraVoltarQuest = (int) 
                            (imagemBotaoVoltarQuest.getWidth() * 0.7 * escala);
                    int alturaVoltarQuest = (int) 
                            (imagemBotaoVoltarQuest.getHeight() * 0.7 * escala);
                    
                    int larguraBotDicaOff = (int) 
                            (imagemBotaoDicasOff.getWidth() * 0.7 * escala);
                    int alturaBotDicaOff = (int) 
                            (imagemBotaoDicasOff.getHeight() * 0.7 * escala);

/*--------------------Posicionamento dos elementos na tela--------------------*/

                    int xNQuiz = centroX - (larguraNomeQuiz / 3) + 60;
                    int yNQuiz = (int) (h * 0.45) - 210;
                    
                    int xBoxMat = centroX - (larguraBoxMateria / 3) + 60;
                    int yBoxMat = yNQuiz + alturaNomeQuiz + (int)(40 * escala);
                    
                    int xBoxSerie = centroX - (larguraBoxMateria / 3) + 60;
                    int yBoxSerie = yBoxMat + alturaBoxMateria + (int)(32 * escala);
                    
                    int xCriar = centroX - (larguraCriarQuest / 2) - 320;
                    int yCriar = (int) (h * 0.45) + 340;
                    
                    int xVoltar = centroX - (larguraVoltarQuest / 2) + 300;
                    int yVoltar = (int) (h * 0.45) + 340;
                    
                    int xDicaOff = centroX - (larguraBotDicaOff / 2);
                    int yDicaOff = (int) (h * 0.45) + 215;

/*-------------------Criação dos elementos com base na posição----------------*/

                    botaoCriar.setBounds(xCriar, 
                            yCriar, 
                            larguraCriarQuest, 
                            alturaCriarQuest);
                    
                    botaoVoltar.setBounds(xVoltar,
                            yVoltar, 
                            larguraVoltarQuest, 
                            alturaVoltarQuest);
                    
                    botaoBoxMaterias.setBounds(xBoxMat,
                            yBoxMat, 
                            larguraBoxMateria, 
                            alturaBoxMateria);
                    
                    botaoDicasOff.setBounds(xDicaOff,
                            yDicaOff,
                            larguraBotDicaOff, 
                            alturaBotDicaOff);
                    
                    campoTextoNomeQuest.setBounds(xNQuiz + (int)(75 * escala), 
                            yNQuiz + (int)(16 * escala), 
                            (int)(680 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoNomeMateria.setBounds(xBoxMat + (int)(320 * escala), 
                            yBoxMat + (int)(16 * escala), 
                            (int)(200 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoSerie.setBounds(xBoxSerie + (int)(300 * escala), 
                            yBoxSerie + (int)(16 * escala), 
                            (int)(250 * escala), 
                            (int)(50 * escala));
                    
/*---------------------------Desenhando Imagens na tela-----------------------*/

                    g2d.drawImage(imagemNomeQuiz, 
                            xNQuiz, 
                            yNQuiz, 
                            larguraNomeQuiz, 
                            alturaNomeQuiz, this);
                    
                    g2d.drawImage(imagemBoxMateria, 
                            xBoxMat, 
                            yBoxMat, 
                            larguraBoxMateria, 
                            alturaBoxMateria, this);
                    
                    g2d.drawImage(imagemBoxSerie, 
                            xBoxSerie, 
                            yBoxSerie, 
                            larguraBoxSerie, 
                            alturaBoxSerie, this);
                    
                    g2d.drawImage(imagemBotaoCriarQuest, 
                            xCriar, 
                            yCriar, 
                            larguraCriarQuest, 
                            alturaCriarQuest, this);
                    
                    g2d.drawImage(imagemBotaoVoltarQuest, 
                            xVoltar,
                            yVoltar, 
                            larguraVoltarQuest,
                            alturaVoltarQuest, this);
                    
                    g2d.drawImage(imagemBotaoDicasOff, 
                            xDicaOff,
                            yDicaOff,
                            larguraBotDicaOff, 
                            alturaBotDicaOff, this);
                }
            };
            painelConteudo.setOpaque(false);
            
            labelDicasOn = new JLabel
                (new ImageIcon(imagemBotaoDicasOn));
            labelDicasOn.setVisible(false);
            labelDicasOn.setBounds(0, 0,
                    imagemBotaoDicasOn.getWidth(), 
                    imagemBotaoDicasOn.getHeight());
            painelConteudo.add(labelDicasOn);
            
            campoTextoNomeQuest = new JTextField();
            campoTextoNomeQuest.setBorder(null);
            campoTextoNomeQuest.setOpaque(false);
            campoTextoNomeQuest.setForeground(Color.BLACK);
            campoTextoNomeQuest.setFont(new Font("Jockey One", Font.BOLD, 32));
            campoTextoNomeQuest.setHorizontalAlignment(JTextField.CENTER);
            painelConteudo.add(campoTextoNomeQuest);
            
            campoTextoSerie = new JTextField();
            campoTextoSerie.setBorder(null);
            campoTextoSerie.setOpaque(false);
            campoTextoSerie.setForeground(Color.BLACK);
            campoTextoSerie.setFont(new Font("Jockey One", Font.BOLD, 32));
            campoTextoSerie.setHorizontalAlignment(JTextField.CENTER);
            campoTextoSerie.setEditable(false);
            campoTextoSerie.setFocusable(false);
            campoTextoSerie.setText(serie);
            painelConteudo.add(campoTextoSerie);
            
            campoTextoNomeMateria = new JTextField();
            campoTextoNomeMateria.setBorder(null);
            campoTextoNomeMateria.setOpaque(false);
            campoTextoNomeMateria.setForeground(Color.BLACK);
            campoTextoNomeMateria.setFont(new Font("Jockey One", Font.BOLD, 32));
            campoTextoNomeMateria.setHorizontalAlignment(JTextField.CENTER);
            campoTextoNomeMateria.setEditable(false);
            campoTextoNomeMateria.setFocusable(false);
            campoTextoNomeMateria.setText(materia);
            painelConteudo.add(campoTextoNomeMateria);
            
            botaoCriar = new JButton();
            botaoCriar.setBorderPainted(false);
            botaoCriar.setContentAreaFilled(false);
            botaoCriar.setFocusPainted(false);
            botaoCriar.setOpaque(false);
            botaoCriar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoCriar);
            
            botaoBoxMaterias = new JButton();
            botaoBoxMaterias.setBorderPainted(false);
            botaoBoxMaterias.setContentAreaFilled(false);
            botaoBoxMaterias.setFocusPainted(false);
            botaoBoxMaterias.setOpaque(false);
            botaoBoxMaterias.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoBoxMaterias);
            
            botaoDicasOff = new JButton();
            botaoDicasOff.setBorderPainted(false);
            botaoDicasOff.setContentAreaFilled(false);
            botaoDicasOff.setFocusPainted(false);
            botaoDicasOff.setOpaque(false);
            botaoDicasOff.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoDicasOff.addActionListener((ActionEvent e) -> {
                SelecionarBotao("dicaOn");
            });
            painelConteudo.add(botaoDicasOff);
            
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

        private void SelecionarBotao(String tipo) {
            dicaSelecionada = tipo;

            if ("dicaOn".equals(tipo)) {
                dicaAtivada = !dicaAtivada;

                int w = getWidth();
                int h = getHeight();

                int centroX = w / 2;
                double escala = 1.0;

                int larguraBotDicaOff = 
                        (int) (imagemBotaoDicasOff.getWidth() * 0.7 * escala);
                int alturaBotDicaOff = 
                        (int) (imagemBotaoDicasOff.getHeight() * 0.7 * escala);

                int xDicaOff = centroX - (larguraBotDicaOff / 2);
                int yDicaOff = (int) (h * 0.45) + 215;

                Image imagemEscalada = imagemBotaoDicasOn.getScaledInstance(
                    larguraBotDicaOff, alturaBotDicaOff, Image.SCALE_SMOOTH);
                labelDicasOn.setIcon(new ImageIcon(imagemEscalada));

                labelDicasOn.setBounds(xDicaOff, 
                        yDicaOff, 
                        larguraBotDicaOff, 
                        alturaBotDicaOff);

                labelDicasOn.setVisible(dicaAtivada);
                labelDicasOn.repaint();
            }
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

            if (imagemDeFundoQuestPadraoCriacao != null) {
                g2d.drawImage(imagemDeFundoQuestPadraoCriacao, 
                        0, 
                        0, 
                        w, 
                        h, this);
            }
        }
    }
}