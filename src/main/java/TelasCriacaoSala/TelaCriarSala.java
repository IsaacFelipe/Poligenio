/*-------------------------IMPORTAÇÕES NECESSÁRIAS----------------------------*/
package TelasCriacaoSala;

import TelasCriacaoSala.TelaQuestPadrao.PanelQuestPadrao;
import TelasCriacaoSala.TelaQuestPersonalizado.PanelQuestPersonalizada;
import TelasLobby.TelaLobbyProfessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE CRIAÇÃO DE SALA---------*/
public class TelaCriarSala extends JFrame {

    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel painelCriarSala;
    private static String idProfessor;
    
    /*----------------------CONFIGURA O LAYOUT DE NAVEGAÇÃO------------------*/
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }

    /*----------------------CONSTRUTOR DA TELA DE CRIAÇÃO DE SALA------------*/
    public TelaCriarSala(String idProfessor) {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        painelCriarSala = new JPanel(cardLayout);

        try {
            /*----------------------INSTANCIAÇÃO DOS PAINÉIS----------------*/
            PanelCriarSala telaCriarSala = 
                    new PanelCriarSala(painelCriarSala);
            
            PanelQuestPadrao painelQuestPadrao = 
                    new PanelQuestPadrao(painelCriarSala);
            
            PanelQuestPersonalizada panelQuestPersonalizada = 
                    new PanelQuestPersonalizada(painelCriarSala);

            /*----------------------ADICIONANDO PAINÉIS AO LAYOUT------------*/
            painelCriarSala.add(telaCriarSala, "TelaCriarSala");
            
            painelCriarSala.add(panelQuestPersonalizada, 
                    "TelaQuestPersonalizado");
            
            painelCriarSala.add(painelQuestPadrao, "TelaQuestPadrao");
            
            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(painelCriarSala);
            cardLayout.show(painelCriarSala, "TelaCriarSala");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*----------------------ALTERA A TELA VISÍVEL NO CARDLAYOUT-------------*/
    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelCriarSala, nomeTela);
    }

    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCriarSala tela = new TelaCriarSala(idProfessor);
            tela.setVisible(true);
        });
    }

    /*----------------------CLASSE INTERNA: PAINEL DE CRIAÇÃO DE SALA--------*/
    public static class PanelCriarSala extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundoCriarSala;
        private BufferedImage imagemBotaoQuestPadr;
        private BufferedImage imagemBotaoQuestPers;
        private BufferedImage imagemBotaoCriar;
        private BufferedImage imagemBotaoVoltar;
        private BufferedImage imagemQuestPadrSelecionado;
        private BufferedImage imagemQuestPersSelecionado;

        private JLabel labelPadrSelecionado;
        private JLabel labelPersSelecionado;

        private JButton botaoSelecionado = null;
        private JButton botaoQuestPadr;
        private JButton botaoQuestPers;
        private JButton botaoCriar;
        private JButton botaoVoltar;

        private TelaCriarSala CriarSala;
        private final JPanel container;
        
        private String tipoSelecionado = null;

        /*----------------------CONSTRUTOR DO PAINEL DE CRIAÇÃO DE SALA------*/
        public PanelCriarSala(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundoCriarSala = ImageIO.read
        (getClass().getResource("/ImagensTelaCriarSala/telaSelecaoSala.png"));
            
            imagemBotaoQuestPadr = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaCriarSala/questionarioPadrao.png"));
            
            imagemBotaoQuestPers = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaCriarSala/questionarioPersonalizado.png"));
            
            imagemBotaoCriar = ImageIO.read
        (getClass().getResource("/ImagensTelaCriarSala/botaoCriarCS.png"));
            
            imagemBotaoVoltar = ImageIO.read
        (getClass().getResource("/ImagensTelaCriarSala/botaoVoltarCS.png"));
            
            imagemQuestPadrSelecionado = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaCriarSala/questPdrSelecionado.png"));
            
            imagemQuestPersSelecionado = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaCriarSala/questPersSelecionado.png"));

            /*----------------------CRIAÇÃO DO PAINEL DE CONTEÚDO-------------*/
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    /*----------------------CONFIGURAÇÃO GRÁFICA----------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();
                    int centroX = w / 2;

                    /*----------------------DIMENSIONAMENTO E POSICIONAMENTO----*/
                    double escala = 1.0;
                    int larguraQPdr = (int)
                            (imagemBotaoQuestPadr.getWidth() * 0.7 * escala);
                    int alturaQPdr = (int)
                            (imagemBotaoQuestPadr.getHeight() * 0.7 * escala);
                    
                    int larguraQPers = (int) 
                            (imagemBotaoQuestPers.getWidth() * 0.7 * escala);
                    int alturaQPers = (int) 
                            (imagemBotaoQuestPers.getHeight() * 0.7 * escala);
                    
                    int larguraBCriar = (int) 
                            (imagemBotaoCriar.getWidth() * 0.7 * escala);
                    int alturaBCriar = (int) 
                            (imagemBotaoCriar.getHeight() * 0.7 * escala);
                    
                    int larguraBVoltar = (int) 
                            (imagemBotaoVoltar.getWidth() * 0.7 * escala);
                    int alturaBVoltar = (int) 
                            (imagemBotaoVoltar.getHeight() * 0.7 * escala);

                    /*----------------------COORDENADAS DOS ELEMENTOS-----------*/
                    int xQPdr = centroX - (larguraQPdr / 2);
                    int yQPdr = (int) (h * 0.45) - 37;
                    
                    int xQPers = centroX - (larguraQPdr / 2);
                    int yQPers = yQPdr + alturaQPdr + (int)(20 * escala);
                    
                    int xBCriar = centroX - (larguraBCriar / 2) - 250;
                    int yBCriar = yQPers + alturaQPers + (int)(140 * escala);
                    
                    int xBVoltar = centroX - (larguraBVoltar / 2) + 250;
                    int yBVoltar = yQPers + alturaQPers + (int)(140 * escala);

                    /*----------------------POSICIONAMENTO DOS BOTÕES------------*/
                    botaoQuestPadr.setBounds(xQPdr, 
                            yQPdr, 
                            larguraQPdr, 
                            alturaQPdr);
                    
                    botaoQuestPers.setBounds(xQPers,
                            yQPers,
                            larguraQPers, 
                            alturaQPers);
                    
                    botaoCriar.setBounds(xBCriar,
                            yBCriar,
                            larguraBCriar, 
                            alturaBCriar);
                    
                    botaoVoltar.setBounds(xBVoltar,
                            yBVoltar,
                            larguraBVoltar,
                            alturaBVoltar);

                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemBotaoQuestPadr, 
                            xQPdr, 
                            yQPdr, 
                            larguraQPdr,
                            alturaQPdr, this);
                    
                    g2d.drawImage(imagemBotaoQuestPers, 
                            xQPers, 
                            yQPers, 
                            larguraQPers,
                            alturaQPers, this);
                    
                    g2d.drawImage(imagemBotaoCriar, 
                            xBCriar, 
                            yBCriar,
                            larguraBCriar,
                            alturaBCriar, this);
                    
                    g2d.drawImage(imagemBotaoVoltar,
                            xBVoltar,
                            yBVoltar, 
                            larguraBVoltar,
                            alturaBVoltar, this);
                }
            };
            painelConteudo.setOpaque(false);

/*---------------------CONFIGURAÇÃO DOS LABELS DE SELEÇÃO---------------------*/
            labelPadrSelecionado = 
                    new JLabel(new ImageIcon(imagemQuestPadrSelecionado));
            labelPadrSelecionado.setVisible(false);
            labelPadrSelecionado.setBounds(0, 
                    0, 
                    imagemQuestPadrSelecionado.getWidth(), 
                    imagemQuestPadrSelecionado.getHeight());
            painelConteudo.add(labelPadrSelecionado);

            labelPersSelecionado = 
                    new JLabel(new ImageIcon(imagemQuestPersSelecionado));
            labelPersSelecionado.setVisible(false);
            labelPersSelecionado.setBounds(0, 
                    0, 
                    imagemQuestPersSelecionado.getWidth(),
                    imagemQuestPersSelecionado.getHeight());
            painelConteudo.add(labelPersSelecionado);

/*------------------CONFIGURAÇÃO DO BOTÃO QUESTIONÁRIO PADRÃO-----------------*/
            botaoQuestPadr = new JButton();
            botaoQuestPadr.setBorderPainted(false);
            botaoQuestPadr.setContentAreaFilled(false);
            botaoQuestPadr.setFocusPainted(false);
            botaoQuestPadr.setOpaque(false);
            botaoQuestPadr.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoQuestPadr.addActionListener(e -> 
                    SelecionarBotao("padrao"));
            painelConteudo.add(botaoQuestPadr);

/*----------------CONFIGURAÇÃO DO BOTÃO QUESTIONÁRIO PERSONALIZADO------------*/
            botaoQuestPers = new JButton();
            botaoQuestPers.setBorderPainted(false);
            botaoQuestPers.setContentAreaFilled(false);
            botaoQuestPers.setFocusPainted(false);
            botaoQuestPers.setOpaque(false);
            botaoQuestPers.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoQuestPers.addActionListener(e -> 
                    SelecionarBotao("personalizado"));
            painelConteudo.add(botaoQuestPers);

/*-------------------------CONFIGURAÇÃO DO BOTÃO CRIAR------------------------*/
            botaoCriar = new JButton();
            botaoCriar.setBorderPainted(false);
            botaoCriar.setContentAreaFilled(false);
            botaoCriar.setFocusPainted(false);
            botaoCriar.setOpaque(false);
            botaoCriar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCriar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ("personalizado".equals(tipoSelecionado)) {
                        TelaQuestPersonalizado questPersona = 
                                new TelaQuestPersonalizado("", idProfessor, "");
                        questPersona.setVisible(true);
                        Window janela = SwingUtilities.getWindowAncestor
                                            (PanelCriarSala.this);
                        if (janela instanceof JFrame) {
                            janela.dispose();
                        }
                        labelPadrSelecionado.setVisible(false);
                        labelPersSelecionado.setVisible(false);
                        botaoSelecionado = null;
                        tipoSelecionado = null;
                    } else if ("padrao".equals(tipoSelecionado)) {
                        TelaQuestPadrao questPadrao = 
                                new TelaQuestPadrao(idProfessor);
                        
                        questPadrao.setVisible(true);
                        
                        Window janela = SwingUtilities.getWindowAncestor
                                            (PanelCriarSala.this);
                        
                        if (janela instanceof JFrame) {
                            janela.dispose();
                            
                        }
                        labelPadrSelecionado.setVisible(false);
                        labelPersSelecionado.setVisible(false);
                        botaoSelecionado = null;
                        tipoSelecionado = null;
                    }
                }
            });
            painelConteudo.add(botaoCriar);

/*------------------------CONFIGURAÇÃO DO BOTÃO VOLTAR------------------------*/
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TelaLobbyProfessor lobbyProfessor = 
                            new TelaLobbyProfessor(idProfessor);
                    lobbyProfessor.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                        (PanelCriarSala.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }
                }
            });
            painelConteudo.add(botaoVoltar);

/*---------------------------CONFIGURAÇÃO DO LAYOUT---------------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

/*-------------------SELEÇÃO DE BOTÃO DE TIPO DE QUESTIONÁRIO-----------------*/
        private void SelecionarBotao(String tipo) {
            tipoSelecionado = tipo;
            switch (tipo) {
                case "padrao":
                    if (botaoSelecionado != botaoQuestPadr) {
                        int x = botaoQuestPadr.getX() + 
                                (botaoQuestPadr.getWidth() - 
                                imagemQuestPadrSelecionado.getWidth()) / 2;
                        
                        int y = botaoQuestPadr.getY() + 
                                (botaoQuestPadr.getHeight() - 
                                imagemQuestPadrSelecionado.getHeight()) / 2;
                        
                        labelPadrSelecionado.setBounds(x, 
                                y,
                                imagemQuestPadrSelecionado.getWidth(), 
                                imagemQuestPadrSelecionado.getHeight());
                        
                        labelPadrSelecionado.setVisible(true);
                        labelPersSelecionado.setVisible(false);
                        labelPadrSelecionado.repaint();
                        botaoSelecionado = botaoQuestPadr;
                    }
                    break;

                case "personalizado":
                    if (botaoSelecionado != botaoQuestPers) {
                        int x = botaoQuestPers.getX() + 
                                (botaoQuestPers.getWidth() - 
                                imagemQuestPersSelecionado.getWidth()) / 2;
                        
                        int y = botaoQuestPers.getY() + 
                                (botaoQuestPers.getHeight() - 
                                imagemQuestPersSelecionado.getHeight()) / 2;
                        
                        labelPersSelecionado.setBounds(x, 
                                y, 
                                imagemQuestPersSelecionado.getWidth(), 
                                imagemQuestPersSelecionado.getHeight());
                        
                        labelPersSelecionado.setVisible(true);
                        labelPadrSelecionado.setVisible(false);
                        labelPersSelecionado.repaint();
                        botaoSelecionado = botaoQuestPers;
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

/*-------------------------PINTURA DO FUNDO DO PAINEL-------------------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();

/*------------------------CONFIGURAÇÃO DE RENDERIZAÇÃO------------------------*/
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
            if (imagemDeFundoCriarSala != null) {
                g2d.drawImage(imagemDeFundoCriarSala, 0, 
                        0, 
                        w, 
                        h, this);
            }
        }
    }
}