/*------------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
package TelasCriacaoSala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE EDIÇÃO DE PERGUNTA--------*/
public class TelaEditarPergunta extends JFrame {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
    private JPanel painelEditarPergunta;
    private static String idProfessor;
    
/*----------------------CONSTRUTOR DA TELA DE EDIÇÃO DE PERGUNTA--------------*/
    public TelaEditarPergunta(String idProfessor) {
/*------------------------CONFIGURAÇÕES DA JANELA-----------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelEditarPergunta = new JPanel();
        this.idProfessor = idProfessor;

        try {
/*--------------------------INSTANCIAÇÃO DO PAINEL----------------------------*/
            PanelEditarPergunta editarQuestionario = 
                    new PanelEditarPergunta();
            setContentPane(editarQuestionario);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
/*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaEditarPergunta tela = new TelaEditarPergunta(idProfessor);
            tela.setVisible(true);
        });
    }
    
/*--------------CLASSE INTERNA: PAINEL DE EDIÇÃO DE PERGUNTAS-----------------*/
    public static class PanelEditarPergunta extends JPanel {

/*-------------------------DECLARAÇÃO DE VARIÁVEIS----------------------------*/
        private BufferedImage imagemDeFundoEditarPerguntas;
        private BufferedImage imagemBoxMaterias;
        private BufferedImage imagemBoxPergunta;
        private BufferedImage imagemTextoAlternativa1;
        private BufferedImage imagemTextoAlternativa3;
        private BufferedImage imagemTextoAlternativa2;
        private BufferedImage imagemTextoAlternativa4;
        private BufferedImage imagemBotaoDifFacil;
        private BufferedImage imagemBotaoDifMedio;
        private BufferedImage imagemBotaoDifDificil;
        private BufferedImage imagemBotaoVoltar;
        private BufferedImage imagemBotaoApagarPergunta;
        private BufferedImage imagemBotaoSalvar;
        
        private BufferedImage imagemFacilSelecionado;
        private BufferedImage imagemMedioSelecionado;
        private BufferedImage imagemDificilSelecionado;
        
        private JButton botaoDifFacil;
        private JButton botaoDifMedio;
        private JButton botaoDifDificil;
        private JButton botaoVoltar;
        private JButton botaoSalvar;
        private JButton botaoApagarPergunta;
        
        private JButton botaoSelecionado = null;
        
        private JLabel labelFacil;
        private JLabel labelMedio;
        private JLabel labelDificil;
        
        private JTextField campoTextoMateria;
        private JTextField campoTextoPergunta;
        private JTextField campoTextoAlternativa1;
        private JTextField campoTextoAlternativa3;
        private JTextField campoTextoAlternativa2;
        private JTextField campoTextoAlternativa4;
        
        private String dificuldadeSelecionado = null;
        
/*---------------CONSTRUTOR DO PAINEL DE EDIÇÃO DE PERGUNTAS------------------*/
        public PanelEditarPergunta() throws IOException {
            setLayout(new GridBagLayout());

/*------------------------CARREGAMENTO DAS IMAGENS----------------------------*/
            imagemDeFundoEditarPerguntas = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/telaEditarPergunta.png"));
            
            imagemBoxMaterias = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/boxMateria.png"));
            
            imagemBoxPergunta = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/boxPergunta.png"));
            
            imagemTextoAlternativa1 = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/boxAlternativa.png"));
            
            imagemTextoAlternativa3 = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/boxAlternativa.png"));
            
            imagemTextoAlternativa2 = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/boxAlternativa.png"));
            
            imagemTextoAlternativa4 = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/boxAlternativa.png")); 
            
            imagemBotaoDifFacil = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/botaoDifFacil.png"));
            
            imagemBotaoDifMedio = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/botaoDifMedio.png"));
            
            imagemBotaoDifDificil = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/botaoDifDificil.png"));
            
            imagemFacilSelecionado = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/botaoDifFacilSelect.png"));
            
            imagemMedioSelecionado = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/botaoDifMedioSelect.png"));
            
            imagemDificilSelecionado = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/botaoDifDificilSelect.png"));
            
            imagemBotaoVoltar = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/botaoVoltar.png"));
            
            imagemBotaoApagarPergunta = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/botaoApagarPergunta.png"));
            
            imagemBotaoSalvar = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaEditarPergunta/botaoSalvar.png"));
            
/*-----------------------CRIAÇÃO DO PAINEL DE CONTEÚDO------------------------*/
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

/*-------------------------CONFIGURAÇÃO GRÁFICA-------------------------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();
                    int centroX = w / 2;

/*-----------------------DIMENSIONAMENTO E POSICIONAMENTO---------------------*/
                    double escala = 1.0;
                    int larguraBoxMateria = (int) 
                            (imagemBoxMaterias.getWidth() * 0.7 * escala);
                    int alturaBoxMateria = (int)
                            (imagemBoxMaterias.getHeight() * 0.7 * escala);
                    
                    int larguraBoxPergunta = (int)
                            (imagemBoxPergunta.getWidth() * 0.7 * escala);
                    int alturaBoxPergunta = (int)
                            (imagemBoxPergunta.getHeight() * 0.7 * escala);
                    
                    int larguraBoxAlternativa1 = (int)
                            (imagemTextoAlternativa1.getWidth() * 
                            0.7 * escala);
                    int alturaBoxAlternativa1 = (int)
                            (imagemTextoAlternativa1.getHeight() * 
                            0.7 * escala);
                    
                    int larguraBoxAlternativa3 = (int) 
                            (imagemTextoAlternativa3.getWidth() * 
                            0.7 * escala);
                    int alturaBoxAlternativa3 = (int)
                            (imagemTextoAlternativa3.getHeight() * 
                            0.7 * escala);
                    
                    int larguraBoxAlternativa2 = (int)
                            (imagemTextoAlternativa2.getWidth() * 
                            0.7 * escala);
                    int alturaBoxAlternativa2 = (int)
                            (imagemTextoAlternativa2.getHeight() * 
                            0.7 * escala);
                    
                    int larguraBoxAlternativa4 = (int)
                            (imagemTextoAlternativa4.getWidth() * 
                            0.7 * escala);
                    int alturaBoxAlternativa4 = (int)
                            (imagemTextoAlternativa4.getHeight() * 
                            0.7 * escala);
                    
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
                    
                    int larguraBotVoltar = (int) 
                            (imagemBotaoVoltar.getWidth() * 0.7 * escala);
                    int alturaBotVoltar = (int)
                            (imagemBotaoVoltar.getHeight() * 0.7 * escala);
                    
                    int larguraBotApagarQuest = (int) 
                            (imagemBotaoApagarPergunta.getWidth() * 
                            0.7 * escala);
                    int alturaBotApagarQuest = (int)
                            (imagemBotaoApagarPergunta.getHeight() * 
                            0.7 * escala);
                    
                    int larguraBotSalvar = (int)
                            (imagemBotaoSalvar.getWidth() * 0.7 * escala);
                    int alturaBotSalvar = (int) 
                            (imagemBotaoSalvar.getHeight() * 0.7 * escala);

/*----------------------COORDENADAS DOS ELEMENTOS-----------------------------*/
                    int xBoxMateria = centroX - (larguraBoxMateria / 2) + 300;
                    int yBoxMateria = (int) (h * 0.45) - 320;
                    
                    int xBoxPer = centroX - (larguraBoxPergunta / 2);
                    int yBoxPer = (int) (h * 0.45) - 170;
                    
                    int xBoxAlt1 = centroX - (larguraBoxAlternativa1 / 2) - 400;
                    int yBoxAlt1 = (int) (h * 0.45) + 40;
                    
                    int xBoxAlt3 = centroX - (larguraBoxAlternativa3 / 2) - 400;
                    int yBoxAlt3 = yBoxAlt1 + alturaBoxAlternativa1 + 
                            (int)(90 * escala);
                    
                    int xBoxAlt2 = centroX - (larguraBoxAlternativa2 / 2) + 345;
                    int yBoxAlt2 = yBoxAlt1;
                    
                    int xBoxAlt4 = centroX - (larguraBoxAlternativa4 / 2) + 345;
                    int yBoxAlt4 = yBoxAlt3;
                    
                    int xBotFac = (centroX - (larguraBotMedio / 2) - 20);
                    int yBotFac = (int) (h * 0.45) - 90;
                    
                    int xBotMed = (centroX - (larguraBotMedio / 2) + 250);
                    int yBotMed = (int) (h * 0.45) - 90;
                    
                    int xBotDif = (centroX - (larguraBotMedio / 2) + 520);
                    int yBotDif = (int) (h * 0.45) - 90;
                    
                    int xVoltar = centroX - (larguraBotVoltar / 2) + 365;
                    int yVoltar = (int) (h * 0.45) + 400;
                    
                    int xApagar = centroX - (larguraBotApagarQuest / 2) - 20;
                    int yApagar = yVoltar;
                    
                    int xSalvar = centroX - (larguraBotApagarQuest / 2) - 365;
                    int ySalvar = yApagar;

/*------------------------POSICIONAMENTO DOS CAMPOS---------------------------*/
                    botaoDifFacil.setBounds
        (xBotFac + 40, yBotFac, larguraBotFacil - 80, alturaBotFacil);
                    botaoDifMedio.setBounds
        (xBotMed + 40, yBotMed, larguraBotMedio - 80, alturaBotMedio);
                    botaoDifDificil.setBounds
        (xBotDif + 40, yBotDif, larguraBotDificil - 80, alturaBotDificil);
                    botaoVoltar.setBounds
        (xVoltar, yVoltar, larguraBotVoltar, alturaBotVoltar);
                    botaoApagarPergunta.setBounds
        (xApagar, yApagar, larguraBotApagarQuest, alturaBotApagarQuest);
                    botaoSalvar.setBounds
        (xSalvar, ySalvar, larguraBotSalvar, alturaBotSalvar);
                    campoTextoMateria.setBounds
        (xBoxMateria + (int)(70 * escala), yBoxMateria - 
                (int)(escala), (int)(200 * escala), (int)(50 * escala));
                    campoTextoPergunta.setBounds
        (xBoxPer + (int)(82 * escala), yBoxPer + 
                (int)(1 * escala), (int)(900 * escala), (int)(50 * escala));
                    campoTextoAlternativa1.setBounds
        (xBoxAlt1 + (int)(82 * escala), yBoxAlt1 + 
                (int)(1 * escala), (int)(300 * escala), (int)(50 * escala));
                    campoTextoAlternativa3.setBounds
        (xBoxAlt3 + (int)(82 * escala), yBoxAlt3 + 
                (int)(1 * escala), (int)(300 * escala), (int)(50 * escala));
                    campoTextoAlternativa2.setBounds
        (xBoxAlt2 + (int)(82 * escala), yBoxAlt2 + 
                (int)(1 * escala), (int)(300 * escala), (int)(50 * escala));
                    campoTextoAlternativa4.setBounds
        (xBoxAlt4 + (int)(82 * escala), yBoxAlt4 + 
                (int)(1 * escala), (int)(300 * escala), (int)(50 * escala));

/*--------------------------DESENHO DOS ELEMENTOS-----------------------------*/
                    g2d.drawImage
        (imagemBoxMaterias, xBoxMateria, yBoxMateria, 
                larguraBoxMateria, alturaBoxMateria, this);
                    g2d.drawImage
        (imagemBoxPergunta, xBoxPer, yBoxPer, 
                larguraBoxPergunta, alturaBoxPergunta, this);
                    g2d.drawImage
        (imagemTextoAlternativa1, xBoxAlt1, yBoxAlt1, 
                larguraBoxAlternativa1, alturaBoxAlternativa1, this);
                    g2d.drawImage
        (imagemTextoAlternativa3, xBoxAlt3, yBoxAlt3, 
                larguraBoxAlternativa3, alturaBoxAlternativa3, this);
                    g2d.drawImage
        (imagemTextoAlternativa2, xBoxAlt2, yBoxAlt2, 
                larguraBoxAlternativa2, alturaBoxAlternativa2, this);
                    g2d.drawImage
        (imagemTextoAlternativa4, xBoxAlt4, yBoxAlt4, 
                larguraBoxAlternativa4, alturaBoxAlternativa4, this);
                    g2d.drawImage
        (imagemBotaoDifFacil, xBotFac, yBotFac, 
                larguraBotFacil, alturaBotFacil, this);
                    g2d.drawImage
        (imagemBotaoDifMedio, xBotMed, yBotMed, 
                larguraBotMedio, alturaBotMedio, this);
                    g2d.drawImage
        (imagemBotaoDifDificil, xBotDif, yBotDif, 
                larguraBotDificil, alturaBotDificil, this);
                    g2d.drawImage
        (imagemBotaoVoltar, xVoltar, yVoltar, 
                larguraBotVoltar, alturaBotVoltar, this);
                    g2d.drawImage
        (imagemBotaoApagarPergunta, xApagar, yApagar, 
                larguraBotApagarQuest, alturaBotApagarQuest, this);
                    g2d.drawImage
        (imagemBotaoSalvar, xSalvar, ySalvar, 
                larguraBotSalvar, alturaBotSalvar, this);
                }
            };
            painelConteudo.setOpaque(false);
            
/*----------------------CONFIGURAÇÃO DO LAYOUT--------------------------------*/
            setLayout(new BorderLayout());
            
/*----------------------CONFIGURAÇÃO DOS LABELS DE SELEÇÃO--------------------*/
            labelFacil = new JLabel(new ImageIcon(imagemFacilSelecionado));
            labelFacil.setVisible(false);
            labelFacil.setBounds
        (0, 0, imagemFacilSelecionado.getWidth(),
                imagemFacilSelecionado.getHeight());
            painelConteudo.add(labelFacil);
            
            labelMedio = new JLabel(new ImageIcon(imagemMedioSelecionado));
            labelMedio.setVisible(false);
            labelMedio.setBounds
        (0, 0, imagemMedioSelecionado.getWidth(), 
                imagemMedioSelecionado.getHeight());
            painelConteudo.add(labelMedio);
            
            labelDificil = new JLabel(new ImageIcon(imagemDificilSelecionado));
            labelDificil.setVisible(false);
            labelDificil.setBounds
        (0, 0, imagemDificilSelecionado.getWidth(), 
                imagemDificilSelecionado.getHeight());
            painelConteudo.add(labelDificil);
            
/*----------------------CONFIGURAÇÃO DO BOTÃO DIFICULDADE FÁCIL---------------*/
            botaoDifFacil = new JButton();
            botaoDifFacil.setBorderPainted(false);
            botaoDifFacil.setContentAreaFilled(false);
            botaoDifFacil.setFocusPainted(false);
            botaoDifFacil.setOpaque(false);
            botaoDifFacil.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoDifFacil.addActionListener(e -> SelecionarBotao("facil"));
            painelConteudo.add(botaoDifFacil);
            
/*----------------------CONFIGURAÇÃO DO BOTÃO DIFICULDADE MÉDIO---------------*/
            botaoDifMedio = new JButton();
            botaoDifMedio.setBorderPainted(false);
            botaoDifMedio.setContentAreaFilled(false);
            botaoDifMedio.setFocusPainted(false);
            botaoDifMedio.setOpaque(false);
            botaoDifMedio.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoDifMedio.addActionListener(e -> SelecionarBotao("medio"));
            painelConteudo.add(botaoDifMedio);
            
/*----------------------CONFIGURAÇÃO DO BOTÃO DIFICULDADE DIFÍCIL-------------*/
            botaoDifDificil = new JButton();
            botaoDifDificil.setBorderPainted(false);
            botaoDifDificil.setContentAreaFilled(false);
            botaoDifDificil.setFocusPainted(false);
            botaoDifDificil.setOpaque(false);
            botaoDifDificil.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoDifDificil.addActionListener(e -> SelecionarBotao("dificil"));
            painelConteudo.add(botaoDifDificil);
            
/*----------------------CONFIGURAÇÃO DO BOTÃO APAGAR PERGUNTA-----------------*/
            botaoApagarPergunta = new JButton();
            botaoApagarPergunta.setBorderPainted(false);
            botaoApagarPergunta.setContentAreaFilled(false);
            botaoApagarPergunta.setFocusPainted(false);
            botaoApagarPergunta.setOpaque(false);
            botaoApagarPergunta.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoApagarPergunta);
            
/*----------------------CONFIGURAÇÃO DO BOTÃO SALVAR--------------------------*/
            botaoSalvar = new JButton();
            botaoSalvar.setBorderPainted(false);
            botaoSalvar.setContentAreaFilled(false);
            botaoSalvar.setFocusPainted(false);
            botaoSalvar.setOpaque(false);
            botaoSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoSalvar);
            
/*------------------------CONFIGURAÇÃO DO BOTÃO VOLTAR------------------------*/
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener(e -> {
                TelaListaPerguntas listaPerguntas = 
                        new TelaListaPerguntas(idProfessor);
                
                listaPerguntas.setVisible(true);
                
                Window janela = SwingUtilities.getWindowAncestor
                                    (PanelEditarPergunta.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                }
            });
            painelConteudo.add(botaoVoltar);
            
/*----------------------CONFIGURAÇÃO DO CAMPO TEXTO MATÉRIA-------------------*/
            campoTextoMateria = new JTextField();
            campoTextoMateria.setBorder(null);
            campoTextoMateria.setOpaque(false);
            campoTextoMateria.setForeground(Color.BLACK);
            campoTextoMateria.setFont(new Font("Jockey One", Font.BOLD, 32));
            campoTextoMateria.setHorizontalAlignment(JTextField.CENTER);
            campoTextoMateria.setText("Português");
            campoTextoMateria.setEditable(false);
            campoTextoMateria.setFocusable(false);
            painelConteudo.add(campoTextoMateria);
            
/*----------------------CONFIGURAÇÃO DO CAMPO TEXTO PERGUNTA------------------*/
            campoTextoPergunta = new JTextField();
            campoTextoPergunta.setBorder(null);
            campoTextoPergunta.setOpaque(false);
            campoTextoPergunta.setForeground(Color.BLACK);
            campoTextoPergunta.setFont(new Font
        ("Jockey One", Font.BOLD, 32));
            painelConteudo.add(campoTextoPergunta);
            
/*----------------------CONFIGURAÇÃO DO CAMPO ALTERNATIVA 1-------------------*/
            campoTextoAlternativa1 = new JTextField();
            campoTextoAlternativa1.setBorder(null);
            campoTextoAlternativa1.setOpaque(false);
            campoTextoAlternativa1.setForeground(Color.BLACK);
            campoTextoAlternativa1.setFont(new Font
        ("Jockey One", Font.BOLD, 35));
            painelConteudo.add(campoTextoAlternativa1);
            
/*----------------------CONFIGURAÇÃO DO CAMPO ALTERNATIVA 3-------------------*/
            campoTextoAlternativa3 = new JTextField();
            campoTextoAlternativa3.setBorder(null);
            campoTextoAlternativa3.setOpaque(false);
            campoTextoAlternativa3.setForeground(Color.BLACK);
            campoTextoAlternativa3.setFont(new Font
        ("Jockey One", Font.BOLD, 35));
            painelConteudo.add(campoTextoAlternativa3);
            
/*----------------------CONFIGURAÇÃO DO CAMPO ALTERNATIVA 2-------------------*/
            campoTextoAlternativa2 = new JTextField();
            campoTextoAlternativa2.setBorder(null);
            campoTextoAlternativa2.setOpaque(false);
            campoTextoAlternativa2.setForeground(Color.BLACK);
            campoTextoAlternativa2.setFont(new Font
        ("Jockey One", Font.BOLD, 35));
            painelConteudo.add(campoTextoAlternativa2);
            
/*---------------------CONFIGURAÇÃO DO CAMPO ALTERNATIVA 4--------------------*/
            campoTextoAlternativa4 = new JTextField();
            campoTextoAlternativa4.setBorder(null);
            campoTextoAlternativa4.setOpaque(false);
            campoTextoAlternativa4.setForeground(Color.BLACK);
            campoTextoAlternativa4.setFont(new Font("Jockey One", Font.BOLD, 35));
            painelConteudo.add(campoTextoAlternativa4);
            
/*-----------------------ADICIONA O PAINEL DE CONTEÚDO------------------------*/
            add(painelConteudo, BorderLayout.CENTER);
        }
        
/*-----------------------SELEÇÃO DE BOTÃO DE DIFICULDADE----------------------*/
        private void SelecionarBotao(String tipo) {
            dificuldadeSelecionado = tipo;
            
            labelFacil.setVisible(false);
            labelMedio.setVisible(false);
            labelDificil.setVisible(false);
            
            switch (tipo) {
                case "facil":
                    if (botaoSelecionado != botaoDifFacil) {
                        int x = botaoDifFacil.getX() + 
                                (botaoDifFacil.getWidth() - 
                                imagemFacilSelecionado.getWidth()) / 2;
                        int y = botaoDifFacil.getY() + 
                                (botaoDifFacil.getHeight() - 
                                imagemFacilSelecionado.getHeight()) / 2;
                        labelFacil.setBounds(x, y, 
                                imagemFacilSelecionado.getWidth(), 
                                imagemFacilSelecionado.getHeight());
                        labelFacil.setVisible(true);
                        labelFacil.repaint();
                        botaoSelecionado = botaoDifFacil;
                    }
                    break;

                case "medio":
                    if (botaoSelecionado != botaoDifMedio) {
                        int x = botaoDifMedio.getX() + 
                                (botaoDifMedio.getWidth() - 
                                imagemMedioSelecionado.getWidth()) / 2;
                        int y = botaoDifMedio.getY() + 
                                (botaoDifMedio.getHeight() - 
                                imagemMedioSelecionado.getHeight()) / 2;
                        labelMedio.setBounds(x, y, 
                                imagemMedioSelecionado.getWidth(), 
                                imagemMedioSelecionado.getHeight());
                        labelMedio.setVisible(true);
                        labelMedio.repaint();
                        botaoSelecionado = botaoDifMedio;
                    }
                    break;
                    
                case "dificil":
                    if (botaoSelecionado != botaoDifDificil) {
                        int x = botaoDifDificil.getX() + 
                                (botaoDifDificil.getWidth() - 
                                imagemDificilSelecionado.getWidth()) / 2;
                        int y = botaoDifDificil.getY() + 
                                (botaoDifDificil.getHeight() - 
                                imagemDificilSelecionado.getHeight()) / 2;
                        labelDificil.setBounds(x, y, 
                                imagemDificilSelecionado.getWidth(), 
                                imagemDificilSelecionado.getHeight());
                        labelDificil.setVisible(true);
                        labelDificil.repaint();
                        botaoSelecionado = botaoDifDificil;
                    }
                    break;
                default:
                    if (botaoSelecionado == null) {
                        JOptionPane.showMessageDialog(this, 
                                "Escolha um tipo de questionário ", 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
            }
        }
        
/*----------------------PINTURA DO FUNDO DO PAINEL----------------------------*/
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
            if (imagemDeFundoEditarPerguntas != null) {
                g2d.drawImage(imagemDeFundoEditarPerguntas,
                        0,
                        0, 
                        w,
                        h, this);
            }
        }
    }
}