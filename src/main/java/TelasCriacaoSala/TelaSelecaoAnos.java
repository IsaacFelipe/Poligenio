/*-------------------------IMPORTACOES NECESSARIAS----------------------------*/
package TelasCriacaoSala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*---------------CLASSE PRINCIPAL DA TELA DE SELECAO DE ANOS------------------*/
public class TelaSelecaoAnos extends JFrame {
    
/*--------------------------DECLARACAO DE VARIAVEIS---------------------------*/
    private JPanel painelSelecaoAnos;
    private static String materia;
    private static String idProfessor;

/*-------------------CONSTRUTOR DA TELA DE SELECAO DE ANOS--------------------*/
    public TelaSelecaoAnos(String materia, String idProfessor) {
        
/*--------------------------CONFIGURACOES DA JANELA---------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.materia = materia;
        this.idProfessor = idProfessor;

        painelSelecaoAnos = new JPanel();

        try {
            
/*------------------------INSTANCIACAO DO PAINEL------------------------------*/
            PanelSelecaoAnos selecaoAnos = new PanelSelecaoAnos();
            setContentPane(selecaoAnos);
            
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

/*--------------------METODO MAIN PARA EXECUTAR A TELA------------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaSelecaoAnos tela = new TelaSelecaoAnos(materia, idProfessor);
            tela.setVisible(true);
        });
    }

/*-----------------CLASSE INTERNA: PAINEL DE SELECAO DE ANOS------------------*/
    public static class PanelSelecaoAnos extends JPanel {

/*--------------------------DECLARACAO DE VARIAVEIS---------------------------*/
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

/*-----------------CONSTRUTOR DO PAINEL DE SELECAO DE ANOS--------------------*/
        public PanelSelecaoAnos() throws IOException {
            setLayout(new GridBagLayout());

/*------------------------CARREGAMENTO DAS IMAGENS----------------------------*/
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

/*-----------------------CRIACAO DO PAINEL DE CONTEUDO------------------------*/
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

/*--------------------------CONFIGURACAO GRAFICA------------------------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

/*----------------------------CENTRO DA TELA----------------------------------*/
                    int centroX = w / 2;

/*------------------------DIMENSOES DOS ELEMENTOS-----------------------------*/
                    double escala = 1.0;
                    
                    int larguraSextoESetimo = (int) 
                            (imagemBotaoSextoESetimo.getWidth() * 
                            0.7 * escala);
                    int alturaSextoESetimo = (int) 
                            (imagemBotaoSextoESetimo.getHeight() * 
                            0.7 * escala);
                    
                    int larguraOitavoENono = (int) 
                            (imagemBotaoOitavoENono.getWidth() * 
                            0.7 * escala);
                    int alturaOitavoENono = (int) 
                            (imagemBotaoOitavoENono.getHeight() * 
                            0.7 * escala);
                    
                    int larguraEnsinoMedio = (int) 
                            (imagemBotaoEnsinoMedio.getWidth() * 
                            0.7 * escala);
                    int alturaEnsinoMedio = (int) 
                            (imagemBotaoEnsinoMedio.getHeight() * 
                            0.7 * escala);
                    
                    int larguraSelecionar = (int) 
                            (imagemBotaoSelecionar.getWidth() * 
                            0.7 * escala);
                    int alturaSelecionar = (int) 
                            (imagemBotaoSelecionar.getHeight() * 
                            0.7 * escala);
                    
                    int larguraVoltar = (int) 
                            (imagemBotaoVoltar.getWidth() * 
                            0.7 * escala);
                    int alturaVoltar = (int) 
                            (imagemBotaoVoltar.getHeight() * 
                            0.7 * escala);

/*----------------------POSICIONAMENTO DOS ELEMENTOS--------------------------*/
                    int xSexSet = centroX - (larguraSextoESetimo / 2) - 18;
                    int ySexSet = (int) (h * 0.45) - 130;
                    
                    int xOitNono = centroX - (larguraOitavoENono / 2) - 18;
                    int yOitNono = ySexSet + 
                            alturaOitavoENono + 
                            (int)(20 * escala);
                    
                    int xEnsMed = centroX - (larguraEnsinoMedio / 2) - 18;
                    int yEnsMed = yOitNono + 
                            alturaOitavoENono + 
                            (int)(20 * escala);
                    
                    int xSelec = centroX - (larguraSelecionar / 2) - 310;
                    int ySelec = yEnsMed + 
                            alturaEnsinoMedio + 
                            (int)(85 * escala);
                    
                    int xVoltar = centroX - (larguraVoltar / 2) + 300;
                    int yVoltar = yEnsMed + 
                            alturaEnsinoMedio + 
                            (int)(85 * escala);

/*------------------------CONFIGURACAO DOS BOTOES-----------------------------*/
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

/*------------------------DESENHO DOS ELEMENTOS-------------------------------*/
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

/*----------------------CONFIGURACAO DOS LABELS DE SELECAO--------------------*/
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

/*--------------------CONFIGURACAO DO BOTAO SEXTO E SETIMO--------------------*/
            botaoSextoESetimo = new JButton();
            botaoSextoESetimo.setBorderPainted(false);
            botaoSextoESetimo.setContentAreaFilled(false);
            botaoSextoESetimo.setFocusPainted(false);
            botaoSextoESetimo.setOpaque(false);
            botaoSextoESetimo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoSextoESetimo.addActionListener((ActionEvent e) -> {
                SelecionarBotao("Sexto e Setimo");
                serieSelecionadaText = "6° e 7°";
            });
            painelConteudo.add(botaoSextoESetimo);

/*--------------------CONFIGURACAO DO BOTAO OITAVO E NONO---------------------*/
            botaoOitavoENono = new JButton();
            botaoOitavoENono.setBorderPainted(false);
            botaoOitavoENono.setContentAreaFilled(false);
            botaoOitavoENono.setFocusPainted(false);
            botaoOitavoENono.setOpaque(false);
            botaoOitavoENono.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoOitavoENono.addActionListener((ActionEvent e) -> {
                SelecionarBotao("Oitavo e Nono");
                serieSelecionadaText = "8° e 9°";
            });
            painelConteudo.add(botaoOitavoENono);

/*--------------------CONFIGURACAO DO BOTAO ENSINO MEDIO----------------------*/
            botaoEnsinoMedio = new JButton();
            botaoEnsinoMedio.setBorderPainted(false);
            botaoEnsinoMedio.setContentAreaFilled(false);
            botaoEnsinoMedio.setFocusPainted(false);
            botaoEnsinoMedio.setOpaque(false);
            botaoEnsinoMedio.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoEnsinoMedio.addActionListener((ActionEvent e) -> {
                SelecionarBotao("Ensino Medio");
                serieSelecionadaText = "Ensino Medio";
            });
            painelConteudo.add(botaoEnsinoMedio);

/*--------------------CONFIGURACAO DO BOTAO SELECIONAR------------------------*/
            botaoSelecionar = new JButton();
            botaoSelecionar.setBorderPainted(false);
            botaoSelecionar.setContentAreaFilled(false);
            botaoSelecionar.setFocusPainted(false);
            botaoSelecionar.setOpaque(false);
            botaoSelecionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoSelecionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
/*------------------ABRE TELA DE CRIACAO DE QUESTOES PADRAO-------------------*/
                    TelaQuestPadraoCriacao questPadraoCriacao = 
                            new TelaQuestPadraoCriacao(materia, 
                                    serieSelecionadaText, idProfessor);
                    questPadraoCriacao.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                (PanelSelecaoAnos.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }                     
                }
            });
            painelConteudo.add(botaoSelecionar);

/*----------------------CONFIGURACAO DO BOTAO VOLTAR--------------------------*/
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
/*----------------------ABRE TELA DE QUESTOES PADRAO--------------------------*/
                    TelaQuestPadrao questPadrao = 
                            new TelaQuestPadrao(idProfessor);
                    questPadrao.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                (PanelSelecaoAnos.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }                     
                }
            });
            painelConteudo.add(botaoVoltar);

/*--------------------------CONFIGURACAO DO LAYOUT----------------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

/*----------------------METODO PARA SELECIONAR BOTAO--------------------------*/
        private void SelecionarBotao(String tipo) {
            serie = tipo;
            switch (tipo) {
                case "Sexto e Setimo":
                    if (botaoSelecionado != botaoSextoESetimo) {
                        
/*------------------CONFIGURACAO SELECAO SEXTO E SETIMO-----------------------*/
                        int x = botaoSextoESetimo.getX() + 
                                (botaoSextoESetimo.getWidth()
                                - imagemBotaoSextoESetimoSel.getWidth()) / 2;
                        
                        int y = botaoSextoESetimo.getY() + 
                                (botaoSextoESetimo.getHeight()
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
                        
/*------------------CONFIGURACAO SELECAO OITAVO E NONO------------------------*/
                        int x = botaoOitavoENono.getX() + 
                                (botaoOitavoENono.getWidth()
                                - imagemBotaoOitavoENonoSel.getWidth()) / 2;
                        int y = botaoOitavoENono.getY() + 
                                (botaoOitavoENono.getHeight()
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
                    
                case "Ensino Medio":
                    if (botaoSelecionado != botaoEnsinoMedio) {
                        
/*------------------CONFIGURACAO SELECAO ENSINO MEDIO-------------------------*/
                        int x = botaoEnsinoMedio.getX() + 
                                (botaoEnsinoMedio.getWidth()
                                - imagemBotaoEnsinoMedioSel.getWidth()) / 2;
                        
                        int y = botaoEnsinoMedio.getY() + 
                                (botaoEnsinoMedio.getHeight()
                                - imagemBotaoEnsinoMedioSel.getHeight()) / 2;
                        
                        labelEnsinoMedioSelect.setBounds(x, 
                                y,
                                imagemBotaoEnsinoMedioSel.getWidth(),
                                imagemBotaoEnsinoMedioSel.getHeight());
                        
                        labelEnsinoMedioSelect.setVisible(true);
                        labelSexESetSelect.setVisible(false);
                        labelOitavoENonoSelect.setVisible(false);
                        
                        labelEnsinoMedioSelect.repaint();
                        botaoSelecionado = botaoEnsinoMedio;
                    }
                    break;        
            }
        }

/*------------------------PINTURA DO FUNDO DO PAINEL--------------------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

/*------------------------CONFIGURACAO DE RENDERIZACAO------------------------*/
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

/*------------------------DESENHO DA IMAGEM DE FUNDO--------------------------*/
            if (imagemDeFundoSelecaoAnos != null) {
                g2d.drawImage(imagemDeFundoSelecaoAnos, 
                        0, 
                        0, 
                        w, 
                        h, this);
            }
        }  
    }
}