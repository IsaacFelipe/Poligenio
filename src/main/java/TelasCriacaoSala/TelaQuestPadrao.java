/*----------------------IMPORTAÇÕES NECESSÁRIAS-------------------------------*/
package TelasCriacaoSala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE QUESTÕES PADRÃO-----------*/
public class TelaQuestPadrao extends JFrame {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
    private JPanel painelQuestPadrao;
    private static String materia;
    private static String idProfessor;

/*-------------------CONSTRUTOR DA TELA DE QUESTÕES PADRÃO--------------------*/
    public TelaQuestPadrao(String idProfessor) {
/*-------------------------CONFIGURAÇÕES DA JANELA----------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelQuestPadrao = new JPanel();
        this.idProfessor = idProfessor;

        try {
/*--------------------------INSTANCIAÇÃO DO PAINEL----------------------------*/
            PanelQuestPadrao questPadrao = new PanelQuestPadrao();
            setContentPane(questPadrao);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

/*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaQuestPadrao tela = new TelaQuestPadrao(idProfessor);
            tela.setVisible(true);
        });
    }

/*----------------------CLASSE INTERNA: PAINEL DE QUESTÕES PADRÃO-------------*/
    public static class PanelQuestPadrao extends JPanel {

/*-----------------------DECLARAÇÃO DE VARIÁVEIS------------------------------*/
        private BufferedImage imagemDeFundoQuestPadrao;
        private BufferedImage imagemMatematicaPadrao;
        private BufferedImage imagemPortuguesPadrao;
        private BufferedImage imagemHistoriaPadrao;
        private BufferedImage imagemGeografiaPadrao;
        private BufferedImage imagemCienciasPadrao;
        private BufferedImage imagemBotaoCriar;
        private BufferedImage imagemBotaoVoltar;

        private BufferedImage imagemGeografiaSelecionado;
        private BufferedImage imagemHistoriaSelecionado;
        private BufferedImage imagemMatematicaSelecionado;
        private BufferedImage imagemCienciasSelecionado;
        private BufferedImage imagemPortuguesSelecionado;

        private JLabel labelGeografiaSelecionado;
        private JLabel labelHistoriaSelecionado;
        private JLabel labelMatematicaSelecionado;
        private JLabel labelCienciasSelecionado;
        private JLabel labelPortuguesSelecionado;

        private String materiaAtivada = null;
        private JButton botaoSelecionado = null;

        private String materia;

        private JButton botaoMatematica;
        private JButton botaoPortugues;
        private JButton botaoHistoria;
        private JButton botaoGeografia;
        private JButton botaoCiencias;
        private JButton botaoCriar;
        private JButton botaoVoltar;

        private boolean materias = false;

/*----------------------CONSTRUTOR DO PAINEL DE QUESTÕES PADRÃO---------------*/
        public PanelQuestPadrao() throws IOException {
            setLayout(new GridBagLayout());

/*-----------------------CARREGAMENTO DAS IMAGENS-----------------------------*/
            imagemDeFundoQuestPadrao = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/telaQuestPadrao.png"));
            
            imagemMatematicaPadrao = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/matematicaPadrao.png"));
            
            imagemPortuguesPadrao = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/portuguesPadrao.png"));
            
            imagemHistoriaPadrao = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/historiaPadrao.png"));
            
            imagemGeografiaPadrao = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/geografiaPadrao.png"));
            
            imagemCienciasPadrao = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/cienciasPadrao.png"));
            
            imagemBotaoCriar = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/botaoCriarQuestPadrao.png"));
            
            imagemBotaoVoltar = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/botaoVoltarQuestPadrao.png"));
            
            imagemGeografiaSelecionado = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/botaoGeografiaSelect.png"));
            
            imagemHistoriaSelecionado = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/botaoHistoriaSelect.png"));
            
            imagemMatematicaSelecionado = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/botaoMatematicaSelect.png"));
            
            imagemCienciasSelecionado = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/botaoCienciasSelect.png"));
            
            imagemPortuguesSelecionado = ImageIO.read(getClass().getResource
        ("/ImagensQuestPadrao/botaoPortuguesSelect.png"));

/*----------------------CRIAÇÃO DO PAINEL DE CONTEÚDO-------------------------*/
            JPanel painelConteudo = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

/*--------------------------CONFIGURAÇÃO GRÁFICA------------------------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();
                    int centroX = w / 2;

/*----------------------DIMENSIONAMENTO E POSICIONAMENTO----------------------*/
                    double escala = 1.0;
                    int larguraMatematicaPadrao = (int) 
                            (imagemMatematicaPadrao.getWidth() * 0.7 * escala);
                    int alturaMatematicaPadrao = (int) 
                            (imagemMatematicaPadrao.getHeight() * 0.7 * escala);
                    
                    int larguraPortuguesPadrao = (int) 
                            (imagemPortuguesPadrao.getWidth() * 0.7 * escala);
                    int alturaPortuguesPadrao = (int) 
                            (imagemPortuguesPadrao.getHeight() * 0.7 * escala);
                    
                    int larguraHistoriaPadrao = (int)
                            (imagemHistoriaPadrao.getWidth() * 0.7 * escala);
                    int alturaHistoriaPadrao = (int) 
                            (imagemHistoriaPadrao.getHeight() * 0.7 * escala);
                    
                    int larguraGeografiaPadrao = (int)
                            (imagemGeografiaPadrao.getWidth() * 0.7 * escala);
                    int alturaGeografiaPadrao = (int)
                            (imagemGeografiaPadrao.getHeight() * 0.7 * escala);
                    
                    int larguraCienciasPadrao = (int) 
                            (imagemCienciasPadrao.getWidth() * 0.7 * escala);
                    int alturaCienciasPadrao = (int) 
                            (imagemCienciasPadrao.getHeight() * 0.7 * escala);
                    
                    int larguraCriarPadrao = (int) 
                            (imagemBotaoCriar.getWidth() * 0.7 * escala);
                    int alturaCriarPadrao = (int)
                            (imagemBotaoCriar.getHeight() * 0.7 * escala);
                    
                    int larguraVoltarPadrao = (int) 
                            (imagemBotaoVoltar.getWidth() * 0.7 * escala);
                    int alturaVoltarPadrao = (int) 
                            (imagemBotaoVoltar.getHeight() * 0.7 * escala);

/*------------------------COORDENADAS DOS ELEMENTOS---------------------------*/
                    int xMat = centroX - (larguraMatematicaPadrao / 2) - 300;
                    int yMat = (int) (h * 0.60) - 240;
                    
                    int xPort = centroX - (larguraMatematicaPadrao / 2) - 300;
                    int yPort = yMat + 
                            alturaMatematicaPadrao + 
                            (int)(10 * escala);
                    
                    int xHist = centroX - (larguraMatematicaPadrao / 2) + 280;
                    int yHist = (int) (h * 0.60) - 240;
                    
                    int xGeo = centroX - (larguraMatematicaPadrao / 2) + 280;
                    int yGeo = yHist + 
                            alturaHistoriaPadrao + 
                            (int)(10 * escala);
                    
                    int xCie = centroX - (larguraCienciasPadrao / 2) - 15;
                    int yCie = (int) (h * 0.45) + 130;
                    
                    int xCriar = centroX - (larguraCriarPadrao / 2) - 280;
                    int yCriar = yCie + 
                            alturaCienciasPadrao + 
                            (int)(95 * escala);
                    
                    int xVoltar = centroX - (larguraCriarPadrao / 2) + 265;
                    int yVoltar = yCie + 
                            alturaCienciasPadrao + 
                            (int)(95 * escala);

/*------------------------POSICIONAMENTO DOS CAMPOS---------------------------*/
                    botaoMatematica.setBounds(xMat, 
                            yMat, 
                            larguraMatematicaPadrao,
                            alturaMatematicaPadrao);
                    
                    botaoPortugues.setBounds(xPort,
                            yPort,
                            larguraPortuguesPadrao,
                            alturaPortuguesPadrao);
                    
                    botaoHistoria.setBounds(xHist,
                            yHist, 
                            larguraHistoriaPadrao,
                            alturaHistoriaPadrao);
                    
                    botaoGeografia.setBounds(xGeo,
                            yGeo, 
                            larguraGeografiaPadrao,
                            alturaGeografiaPadrao);
                    
                    botaoCiencias.setBounds(xCie, 
                            yCie,
                            larguraCienciasPadrao,
                            alturaCienciasPadrao);
                    botaoCriar.setBounds(xCriar,
                            yCriar,
                            larguraCriarPadrao, 
                            alturaCriarPadrao);
                    
                    botaoVoltar.setBounds(xVoltar,
                            yVoltar
                            , larguraVoltarPadrao,
                            alturaVoltarPadrao);

/*------------------------DESENHO DOS ELEMENTOS-------------------------------*/
                    g2d.drawImage(imagemMatematicaPadrao, 
                            xMat, 
                            yMat, 
                            larguraMatematicaPadrao,
                            alturaMatematicaPadrao, this);
                    
                    g2d.drawImage(imagemPortuguesPadrao, 
                            xPort,
                            yPort, 
                            larguraPortuguesPadrao, 
                            alturaPortuguesPadrao, this);
                    
                    g2d.drawImage(imagemHistoriaPadrao, 
                            xHist, 
                            yHist, 
                            larguraHistoriaPadrao,
                            alturaHistoriaPadrao, this);
                    
                    g2d.drawImage(imagemGeografiaPadrao, 
                            xGeo, 
                            yGeo, 
                            larguraGeografiaPadrao,
                            alturaGeografiaPadrao, this);
                    
                    g2d.drawImage(imagemCienciasPadrao,
                            xCie,
                            yCie, 
                            larguraCienciasPadrao,
                            alturaCienciasPadrao, this);
                    
                    g2d.drawImage(imagemBotaoCriar,
                            xCriar,
                            yCriar, 
                            larguraCriarPadrao,
                            alturaCriarPadrao, this);
                    
                    g2d.drawImage(imagemBotaoVoltar, 
                            xVoltar, 
                            yVoltar, 
                            larguraVoltarPadrao, 
                            alturaVoltarPadrao, this);
                }
            };
            painelConteudo.setOpaque(false);
            painelConteudo.setLayout(null);

/*--------------------CONFIGURAÇÃO DOS LABELS DE SELEÇÃO----------------------*/
            labelGeografiaSelecionado = 
                    new JLabel(new ImageIcon(imagemGeografiaSelecionado));
            labelGeografiaSelecionado.setVisible(false);
            labelGeografiaSelecionado.setBounds(0, 
                    0, 
                    imagemGeografiaSelecionado.getWidth(),
                    imagemGeografiaSelecionado.getHeight());
            painelConteudo.add(labelGeografiaSelecionado);

            labelHistoriaSelecionado = 
                    new JLabel(new ImageIcon(imagemHistoriaSelecionado));
            labelHistoriaSelecionado.setVisible(false);
            labelHistoriaSelecionado.setBounds(0, 
                    0, 
                    imagemHistoriaSelecionado.getWidth(), 
                    imagemHistoriaSelecionado.getHeight());
            painelConteudo.add(labelHistoriaSelecionado);

            labelMatematicaSelecionado =
                    new JLabel(new ImageIcon(imagemMatematicaSelecionado));
            labelMatematicaSelecionado.setVisible(false);
            labelMatematicaSelecionado.setBounds(0,
                    0,
                    imagemMatematicaSelecionado.getWidth(), 
                    imagemMatematicaSelecionado.getHeight());
            painelConteudo.add(labelMatematicaSelecionado);

            labelCienciasSelecionado = 
                    new JLabel(new ImageIcon(imagemCienciasSelecionado));
            labelCienciasSelecionado.setVisible(false);
            labelCienciasSelecionado.setBounds(0,
                    0, 
                    imagemCienciasSelecionado.getWidth(),
                    imagemCienciasSelecionado.getHeight());
            painelConteudo.add(labelCienciasSelecionado);

            labelPortuguesSelecionado = 
                    new JLabel(new ImageIcon(imagemPortuguesSelecionado));
            labelPortuguesSelecionado.setVisible(false);
            labelPortuguesSelecionado.setBounds(0, 
                    0,
                    imagemPortuguesSelecionado.getWidth(),
                    imagemPortuguesSelecionado.getHeight());
            painelConteudo.add(labelPortuguesSelecionado);

/*----------------------CONFIGURAÇÃO DO BOTÃO MATEMÁTICA----------------------*/
            botaoMatematica = new JButton();
            botaoMatematica.setBorderPainted(false);
            botaoMatematica.setContentAreaFilled(false);
            botaoMatematica.setFocusPainted(false);
            botaoMatematica.setOpaque(false);
            botaoMatematica.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoMatematica.addActionListener((ActionEvent e) -> {
                SelecionarBotao("matemática");
                materia = "Matemática";
            });
            painelConteudo.add(botaoMatematica);

/*-----------------------CONFIGURAÇÃO DO BOTÃO PORTUGUÊS----------------------*/
            botaoPortugues = new JButton();
            botaoPortugues.setBorderPainted(false);
            botaoPortugues.setContentAreaFilled(false);
            botaoPortugues.setFocusPainted(false);
            botaoPortugues.setOpaque(false);
            botaoPortugues.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoPortugues.addActionListener((ActionEvent e) -> {
                SelecionarBotao("português");
                materia = "Português";
            });
            painelConteudo.add(botaoPortugues);

/*----------------------CONFIGURAÇÃO DO BOTÃO HISTÓRIA------------------------*/
            botaoHistoria = new JButton();
            botaoHistoria.setBorderPainted(false);
            botaoHistoria.setContentAreaFilled(false);
            botaoHistoria.setFocusPainted(false);
            botaoHistoria.setOpaque(false);
            botaoHistoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoHistoria.addActionListener((ActionEvent e) -> {
                SelecionarBotao("história");
                materia = "História";
            });
            painelConteudo.add(botaoHistoria);

/*------------------------CONFIGURAÇÃO DO BOTÃO GEOGRAFIA---------------------*/
            botaoGeografia = new JButton();
            botaoGeografia.setBorderPainted(false);
            botaoGeografia.setContentAreaFilled(false);
            botaoGeografia.setFocusPainted(false);
            botaoGeografia.setOpaque(false);
            botaoGeografia.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoGeografia.addActionListener((ActionEvent e) -> {
                SelecionarBotao("geografia");
                materia = "Geografia";
            });
            painelConteudo.add(botaoGeografia);

/*-----------------------CONFIGURAÇÃO DO BOTÃO CIÊNCIAS-----------------------*/
            botaoCiencias = new JButton();
            botaoCiencias.setBorderPainted(false);
            botaoCiencias.setContentAreaFilled(false);
            botaoCiencias.setFocusPainted(false);
            botaoCiencias.setOpaque(false);
            botaoCiencias.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCiencias.addActionListener((ActionEvent e) -> {
                SelecionarBotao("ciências");
                materia = "Ciências";
            });
            painelConteudo.add(botaoCiencias);

/*-----------------------CONFIGURAÇÃO DO BOTÃO CRIAR--------------------------*/
            botaoCriar = new JButton();
            botaoCriar.setBorderPainted(false);
            botaoCriar.setContentAreaFilled(false);
            botaoCriar.setFocusPainted(false);
            botaoCriar.setOpaque(false);
            botaoCriar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCriar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String materiaEscolhida = materia;
                    TelaSelecaoAnos questPadraoCriacao = 
                            new TelaSelecaoAnos(materia, idProfessor);
                    questPadraoCriacao.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                        (PanelQuestPadrao.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }
                }
            });
            painelConteudo.add(botaoCriar);

/*-----------------------CONFIGURAÇÃO DO BOTÃO VOLTAR-------------------------*/
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TelaCriarSala lobbyProfessor = 
                            new TelaCriarSala(idProfessor);
                    lobbyProfessor.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                        (PanelQuestPadrao.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }
                }
            });
            painelConteudo.add(botaoVoltar);

/*-------------------------CONFIGURAÇÃO DO LAYOUT-----------------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

/*-----------------------SELEÇÃO DE BOTÃO DE MATÉRIA--------------------------*/
        private void SelecionarBotao(String tipo) {
            materiaAtivada = tipo;

/*---------------------CONFIGURA VISIBILIDADE DOS LABELS----------------------*/
            labelGeografiaSelecionado.setVisible(false);
            labelHistoriaSelecionado.setVisible(false);
            labelMatematicaSelecionado.setVisible(false);
            labelCienciasSelecionado.setVisible(false);
            labelPortuguesSelecionado.setVisible(false);

            switch (tipo) {
                case "geografia":
                    if (botaoSelecionado != botaoGeografia) {
                        int x = botaoGeografia.getX() + 
                                (botaoGeografia.getWidth() - 
                                imagemGeografiaSelecionado.getWidth()) / 2;
                        
                        int y = botaoGeografia.getY() + 
                                (botaoGeografia.getHeight() - 
                                imagemGeografiaSelecionado.getHeight()) / 2;
                        
                        labelGeografiaSelecionado.setBounds(x, 
                                y, 
                                imagemGeografiaSelecionado.getWidth(), 
                                imagemGeografiaSelecionado.getHeight());
                        
                        labelGeografiaSelecionado.setVisible(true);
                        
                        labelGeografiaSelecionado.repaint();
                        botaoSelecionado = botaoGeografia;
                    }
                    break;

                case "história":
                    if (botaoSelecionado != botaoHistoria) {
                        int x = botaoHistoria.getX() + 
                                (botaoHistoria.getWidth() - 
                                imagemHistoriaSelecionado.getWidth()) / 2;
                        
                        int y = botaoHistoria.getY() + 
                                (botaoHistoria.getHeight() - 
                                imagemHistoriaSelecionado.getHeight()) / 2;
                        
                        labelHistoriaSelecionado.setBounds(x,
                                y,
                                imagemHistoriaSelecionado.getWidth(), 
                                imagemHistoriaSelecionado.getHeight());
                        
                        labelHistoriaSelecionado.setVisible(true);
                        
                        labelHistoriaSelecionado.repaint();
                        botaoSelecionado = botaoHistoria;
                    }
                    break;

                case "matemática":
                    if (botaoSelecionado != botaoMatematica) {
                        int x = botaoMatematica.getX() + 
                                (botaoMatematica.getWidth() -
                                imagemMatematicaSelecionado.getWidth()) / 2;
                        
                        int y = botaoMatematica.getY() + 
                                (botaoMatematica.getHeight() - 
                                imagemMatematicaSelecionado.getHeight()) / 2;
                        
                        labelMatematicaSelecionado.setBounds(x,
                                y,
                                imagemMatematicaSelecionado.getWidth(), 
                                imagemMatematicaSelecionado.getHeight());
                        
                        labelMatematicaSelecionado.setVisible(true);
                        
                        labelMatematicaSelecionado.repaint();
                        botaoSelecionado = botaoMatematica;
                    }
                    break;

                case "ciências":
                    if (botaoSelecionado != botaoCiencias) {
                        int x = botaoCiencias.getX() + 
                                (botaoCiencias.getWidth() -
                                imagemCienciasSelecionado.getWidth()) / 2;
                        
                        int y = botaoCiencias.getY() + 
                                (botaoCiencias.getHeight() - 
                                imagemCienciasSelecionado.getHeight()) / 2;
                        
                        labelCienciasSelecionado.setBounds(x, 
                                y, 
                                imagemCienciasSelecionado.getWidth(),
                                imagemCienciasSelecionado.getHeight());
                        
                        labelCienciasSelecionado.setVisible(true);
                        
                        labelCienciasSelecionado.repaint();
                        botaoSelecionado = botaoCiencias;
                    }
                    break;

                case "português":
                    if (botaoSelecionado != botaoPortugues) {
                        int x = botaoPortugues.getX() + 
                                (botaoPortugues.getWidth() - 
                                imagemPortuguesSelecionado.getWidth()) / 2;
                        
                        int y = botaoPortugues.getY() + 
                                (botaoPortugues.getHeight() - 
                                imagemPortuguesSelecionado.getHeight()) / 2;
                        
                        labelPortuguesSelecionado.setBounds(x, 
                                y, 
                                imagemPortuguesSelecionado.getWidth(),
                                imagemPortuguesSelecionado.getHeight());
                        
                        labelPortuguesSelecionado.setVisible(true);
                        
                        labelPortuguesSelecionado.repaint();
                        botaoSelecionado = botaoPortugues;
                    }
                    break;
            }

/*-------------------------ATUALIZA A INTERFACE-------------------------------*/
            this.revalidate();
            this.repaint();
        }

/*-----------------------PINTURA DO FUNDO DO PAINEL---------------------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();

/*----------------------CONFIGURAÇÃO DE RENDERIZAÇÃO--------------------------*/
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

/*-----------------------DESENHO DA IMAGEM DE FUNDO---------------------------*/
            if (imagemDeFundoQuestPadrao != null) {
                g2d.drawImage(imagemDeFundoQuestPadrao, 
                        0, 
                        0, 
                        w, 
                        h, this);
            }
        }
    }
}