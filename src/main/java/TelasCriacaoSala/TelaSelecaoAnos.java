package TelasCriacaoSala;

import TelasCriacaoSala.TelaQuestPadrao;
import TelasCriacaoSala.TelaQuestPadraoCriacao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaSelecaoAnos extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelSelecaoAnos;
    private static String materia;
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
        this.painelSelecaoAnos = painelPrincipal;
    }
    
    public TelaSelecaoAnos(String materia) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.materia = materia;
        
        cardLayout = new CardLayout();
        painelSelecaoAnos = new JPanel(cardLayout);
        
        try {
            PanelSelecaoAnos telaEsperoPanel = new PanelSelecaoAnos();
            painelSelecaoAnos.add(telaEsperoPanel, "TelaSelecaoAnos");
            add(painelSelecaoAnos);
            cardLayout.show(painelSelecaoAnos, "TelaSelecaoAnos");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaSelecaoAnos tela = new TelaSelecaoAnos(materia);
            tela.setVisible(true);
        });
    }
    
    public static class PanelSelecaoAnos extends JPanel {

        private BufferedImage imagemDeFundoSelecaoAnos;
        private BufferedImage imagemBotaoSextoESetimo;
        private BufferedImage imagemBotaoOitavoENono;
        private BufferedImage imagemBotaoEnsinoMedio;
        private BufferedImage imagemBotaoSelecionar;
        private BufferedImage imagemBotaoVoltar;
        
        private BufferedImage imagemBotaoSextoESetimoSel;
        private BufferedImage imagemBotaoOitavoENonoSel;
        private BufferedImage imagemBotaoEnsinoMedioSel;
        
        private JLabel labelSexESetSelect;
        private JLabel labelOitavoENonoSelect;
        private JLabel labelEnsinoMedioSelect;
        
        private String serieSelecionada = null;
        private boolean serieAtivada = false;
        private String serie = null;
        private String serieSelecionadaText;
        private JButton botaoSelecionado;
        
        private JButton botaoSextoESetimo;
        private JButton botaoOitavoENono;
        private JButton botaoEnsinoMedio;
        private JButton botaoSelecionar;
        private JButton botaoVoltar;
        
        public PanelSelecaoAnos() throws IOException {
            setLayout(new GridBagLayout());

            imagemDeFundoSelecaoAnos = ImageIO.read(getClass().getResource
        ("/ImagensTelaSelecaoAnos/telaSelecaoAnos.png"));
            
            imagemBotaoSextoESetimo = ImageIO.read(getClass().getResource
        ("/ImagensTelaSelecaoAnos/botaoSextoESetimo.png"));
            
            imagemBotaoOitavoENono = ImageIO.read(getClass().getResource
        ("/ImagensTelaSelecaoAnos/botaoOitavoENono.png"));
            
            imagemBotaoEnsinoMedio = ImageIO.read(getClass().getResource
        ("/ImagensTelaSelecaoAnos/botaoEnsinoMedio.png"));
            
            imagemBotaoSelecionar = ImageIO.read(getClass().getResource
        ("/ImagensTelaSelecaoAnos/botaoSelecionar.png"));
            
            imagemBotaoVoltar = ImageIO.read(getClass().getResource
        ("/ImagensTelaSelecaoAnos/botaoVoltar.png"));
            
            imagemBotaoSextoESetimoSel = ImageIO.read(getClass().getResource
        ("/ImagensTelaSelecaoAnos/botaoSextoESetimoSelect.png"));
            
            imagemBotaoOitavoENonoSel = ImageIO.read(getClass().getResource
        ("/ImagensTelaSelecaoAnos/botaoOitavoENonoSelect.png"));
                       
            imagemBotaoEnsinoMedioSel = ImageIO.read(getClass().getResource
        ("/ImagensTelaSelecaoAnos/botaoEnsinoMedioSelect.png"));
            
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
                    
                    int larguraSextoESetimo = (int) 
                            (imagemBotaoSextoESetimo.getWidth() * 0.7 * escala);
                    int alturaSextoESetimo = (int) 
                            (imagemBotaoSextoESetimo.getHeight() * 0.7 * escala);
                    
                    int larguraOitavoENono = (int) 
                            (imagemBotaoOitavoENono.getWidth() * 0.7 * escala);
                    int alturaOitavoENono = (int) 
                            (imagemBotaoOitavoENono.getHeight() * 0.7 * escala);
                    
                    int larguraEnsinoMedio = (int) 
                            (imagemBotaoEnsinoMedio.getWidth() * 0.7 * escala);
                    int alturaEnsinoMedio = (int) 
                            (imagemBotaoEnsinoMedio.getHeight() * 0.7 * escala);
                    
                    int larguraSelecionar = (int) 
                            (imagemBotaoSelecionar.getWidth() * 0.7 * escala);
                    int alturaSelecionar = (int) 
                            (imagemBotaoSelecionar.getHeight() * 0.7 * escala);
                    
                    int larguraVoltar = (int) 
                            (imagemBotaoVoltar.getWidth() * 0.7 * escala);
                    int alturaVoltar = (int) 
                            (imagemBotaoVoltar.getHeight() * 0.7 * escala);
                    
                    int xSexSet = centroX - (larguraSextoESetimo / 2) - 18;
                    int ySexSet = (int) (h * 0.45) - 130;
                    
                    int xOitNono = centroX - (larguraOitavoENono / 2) - 18;
                    int yOitNono = ySexSet + alturaOitavoENono + (int)(20 * escala);
                    
                    int xEnsMed = centroX - (larguraEnsinoMedio / 2) - 18;
                    int yEnsMed = yOitNono + alturaOitavoENono + (int)(20 * escala);
                    
                    int xSelec = centroX - (larguraSelecionar / 2) - 310;
                    int ySelec = yEnsMed + alturaEnsinoMedio + (int)(85 * escala);
                    
                    int xVoltar = centroX - (larguraVoltar / 2) + 300;
                    int yVoltar = yEnsMed + alturaEnsinoMedio + (int)(85 * escala);
                    
                    botaoSextoESetimo.setBounds(xSexSet, 
                            ySexSet, 
                            larguraSextoESetimo, 
                            alturaSextoESetimo);
                    
                    botaoOitavoENono.setBounds(xOitNono, 
                            yOitNono, 
                            larguraOitavoENono, 
                            alturaOitavoENono);
                    
                    botaoEnsinoMedio.setBounds(xEnsMed, 
                            yEnsMed, 
                            larguraEnsinoMedio, 
                            alturaEnsinoMedio);
                    
                    botaoSelecionar.setBounds(xSelec, 
                            ySelec, 
                            larguraSelecionar, 
                            alturaSelecionar);
                    
                    botaoVoltar.setBounds(xVoltar, 
                            yVoltar, 
                            larguraVoltar, 
                            alturaVoltar);
                    
                    g2d.drawImage(imagemBotaoSextoESetimo, 
                            xSexSet, 
                            ySexSet, 
                            larguraSextoESetimo, 
                            alturaSextoESetimo, this);
                    
                    g2d.drawImage(imagemBotaoOitavoENono, 
                            xOitNono, 
                            yOitNono, 
                            larguraOitavoENono, 
                            alturaOitavoENono, this);
                    
                    g2d.drawImage(imagemBotaoEnsinoMedio, 
                            xEnsMed, 
                            yEnsMed, 
                            larguraEnsinoMedio, 
                            alturaEnsinoMedio, this);
                    
                    g2d.drawImage(imagemBotaoSelecionar, 
                            xSelec, 
                            ySelec, 
                            larguraSelecionar, 
                            alturaSelecionar, this);
                    
                    g2d.drawImage(imagemBotaoVoltar, 
                            xVoltar, 
                            yVoltar, 
                            larguraVoltar, 
                            alturaVoltar, this);
                }
            };
            painelConteudo.setOpaque(false);
            
            labelSexESetSelect = new JLabel
                (new ImageIcon(imagemBotaoSextoESetimoSel));
            labelSexESetSelect.setVisible(false);
            labelSexESetSelect.setBounds(0, 0,
                    imagemBotaoSextoESetimoSel.getWidth(), 
                    imagemBotaoSextoESetimoSel.getHeight());
            painelConteudo.add(labelSexESetSelect);
            
            labelOitavoENonoSelect = new JLabel
                (new ImageIcon(imagemBotaoOitavoENonoSel));
            labelOitavoENonoSelect.setVisible(false);
            labelOitavoENonoSelect.setBounds(0, 0,
                    imagemBotaoOitavoENonoSel.getWidth(), 
                    imagemBotaoOitavoENonoSel.getHeight());
            painelConteudo.add(labelOitavoENonoSelect);
            
            labelEnsinoMedioSelect = new JLabel
                (new ImageIcon(imagemBotaoEnsinoMedioSel));
            labelEnsinoMedioSelect.setVisible(false);
            labelEnsinoMedioSelect.setBounds(0, 0,
                    imagemBotaoEnsinoMedioSel.getWidth(), 
                    imagemBotaoEnsinoMedioSel.getHeight());
            painelConteudo.add(labelEnsinoMedioSelect);            
            
            botaoSextoESetimo = new JButton();
            botaoSextoESetimo.setBorderPainted(false);
            botaoSextoESetimo.setContentAreaFilled(false);
            botaoSextoESetimo.setFocusPainted(false);
            botaoSextoESetimo.setOpaque(false);
            botaoSextoESetimo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoSextoESetimo.addActionListener((ActionEvent e) -> {
                SelecionarBotao("Sexto e Sétimo");
                serieSelecionadaText = "Sexto e Sétimo";
            });
            painelConteudo.add(botaoSextoESetimo);
            
            botaoOitavoENono = new JButton();
            botaoOitavoENono.setBorderPainted(false);
            botaoOitavoENono.setContentAreaFilled(false);
            botaoOitavoENono.setFocusPainted(false);
            botaoOitavoENono.setOpaque(false);
            botaoOitavoENono.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoOitavoENono.addActionListener((ActionEvent e) -> {
                SelecionarBotao("Oitavo e Nono");
                serieSelecionadaText = "Oitavo e Nono";
            });
            painelConteudo.add(botaoOitavoENono);
            
            botaoEnsinoMedio = new JButton();
            botaoEnsinoMedio.setBorderPainted(false);
            botaoEnsinoMedio.setContentAreaFilled(false);
            botaoEnsinoMedio.setFocusPainted(false);
            botaoEnsinoMedio.setOpaque(false);
            botaoEnsinoMedio.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoEnsinoMedio.addActionListener((ActionEvent e) -> {
                SelecionarBotao("Ensino Médio");
                serieSelecionadaText = "Ensino Médio";
            });
            painelConteudo.add(botaoEnsinoMedio);
            
            botaoSelecionar = new JButton();
            botaoSelecionar.setBorderPainted(false);
            botaoSelecionar.setContentAreaFilled(false);
            botaoSelecionar.setFocusPainted(false);
            botaoSelecionar.setOpaque(false);
            botaoSelecionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoSelecionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TelaQuestPadraoCriacao questPadraoCriacao = 
                            new TelaQuestPadraoCriacao(materia, serieSelecionadaText);
                    questPadraoCriacao.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                (PanelSelecaoAnos.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }                     
                }
            });
            painelConteudo.add(botaoSelecionar);
            
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TelaQuestPadrao questPadrao = new TelaQuestPadrao();
                    questPadrao.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                (PanelSelecaoAnos.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }                     
                }
            });
            painelConteudo.add(botaoVoltar);
            
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }
        
        private void SelecionarBotao(String tipo) {
            serie = tipo;
            switch (tipo) {
                case "Sexto e Sétimo":
                    if (botaoSelecionado != botaoSextoESetimo) {
                        int x = botaoSextoESetimo.getX() + (botaoSextoESetimo.getWidth()
                                - imagemBotaoSextoESetimoSel.getWidth()) / 2;
                        int y = botaoSextoESetimo.getY() + (botaoSextoESetimo.getHeight()
                                - imagemBotaoSextoESetimoSel.getHeight()) / 2;
                        labelSexESetSelect.setBounds(x, 
                                y,
                                imagemBotaoSextoESetimoSel.getWidth(), 
                                imagemBotaoSextoESetimoSel.getHeight());
                        labelSexESetSelect.setVisible(true);
                        labelOitavoENonoSelect.setVisible(false);
                        labelEnsinoMedioSelect.setVisible(false);
                        labelSexESetSelect.repaint();
                        botaoSelecionado = botaoSextoESetimo;
                    }
                    break;
                    
                case "Oitavo e Nono":
                    if (botaoSelecionado != botaoOitavoENono) {
                        int x = botaoOitavoENono.getX() + (botaoOitavoENono.getWidth()
                                - imagemBotaoOitavoENonoSel.getWidth()) / 2;
                        int y = botaoOitavoENono.getY() + (botaoOitavoENono.getHeight()
                                - imagemBotaoOitavoENonoSel.getHeight()) / 2;
                        labelOitavoENonoSelect.setBounds(x, 
                                y,
                                imagemBotaoOitavoENonoSel.getWidth(), 
                                imagemBotaoOitavoENonoSel.getHeight());
                        labelOitavoENonoSelect.setVisible(true);
                        labelSexESetSelect.setVisible(false);
                        labelEnsinoMedioSelect.setVisible(false);
                        labelOitavoENonoSelect.repaint();
                        botaoSelecionado = botaoOitavoENono;
                    }
                    break;   
                    
                case "Ensino Médio":
                    if (botaoSelecionado != botaoEnsinoMedio) {
                        int x = botaoEnsinoMedio.getX() + (botaoEnsinoMedio.getWidth()
                                - imagemBotaoEnsinoMedioSel.getWidth()) / 2;
                        int y = botaoEnsinoMedio.getY() + (botaoEnsinoMedio.getHeight()
                                - imagemBotaoEnsinoMedioSel.getHeight()) / 2;
                        labelEnsinoMedioSelect.setBounds(x, 
                                y,
                                imagemBotaoEnsinoMedioSel.getWidth(), 
                                imagemBotaoEnsinoMedioSel.getHeight());
                        labelEnsinoMedioSelect.setVisible(true);
                        labelSexESetSelect.setVisible(false);
                        labelOitavoENonoSelect.setVisible(false);
                        labelOitavoENonoSelect.repaint();
                        botaoSelecionado = botaoEnsinoMedio;
                    }
                    break;        
            }
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
            
            if (imagemDeFundoSelecaoAnos != null) {
                g2d.drawImage(imagemDeFundoSelecaoAnos, 0, 0, w, h, this);
            }
        }  
    }
    
}
