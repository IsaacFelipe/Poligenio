/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasPartida;

/*------------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import CodigoPoligenio.Sistema;
import TelasLobby.TelaLobbyAluno;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*--------------------CLASSE PRINCIPAL DA TELA DE CÓDIGO----------------------*/
public class TelaEsperaAluno extends JFrame {

/*-------------------------DECLARAÇÃO DE VARIÁVEIS----------------------------*/
    private JPanel painelEsperaAluno;
    private static String origem;
    private static String tipoSala;

/*-----------------------CONSTRUTOR DA TELA DE CÓDIGO-------------------------*/
    public TelaEsperaAluno(String origem, String tipoSala){
        
/*--------------------------CONFIGURAÇÕES DA JANELA---------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.origem = origem;
        this.tipoSala = tipoSala;

        painelEsperaAluno = new JPanel();

        try {
/*---------------------------INSTANCIAÇÃO DO PAINEL---------------------------*/
            PanelEsperaAluno esperaAluno = new PanelEsperaAluno();
            setContentPane(esperaAluno);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                    "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

/*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaEsperaAluno tela = new TelaEsperaAluno(origem, tipoSala);
            tela.setVisible(true);  
        });
    }

/*-----------------------CLASSE INTERNA: PAINEL DE CÓDIGO---------------------*/
    public static class PanelEsperaAluno extends JPanel {
        
/*---------------------------DECLARAÇÃO DE VARIÁVEIS--------------------------*/
        private BufferedImage imagemDeFundoEsperaAluno;
        private BufferedImage imagemBotaoDesconectar;

        private JButton botaoDesconectar;
        private JButton botaoEntrarEscondido;
        
        private JTextField campoTextoCodigo;

/*------------------------CONSTRUTOR DO PAINEL DE CÓDIGO----------------------*/
        public PanelEsperaAluno() throws IOException{
            setLayout(new GridBagLayout());

/*---------------------------CARREGAMENTO DAS IMAGENS-------------------------*/
            imagemDeFundoEsperaAluno = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaAluno/telaFundoEsperaAluno.png"));
            imagemBotaoDesconectar = ImageIO.read(getClass().getResource
        ("/ImagensTelaEsperaAluno/botaoDesconectar.png"));

/*------------------------CRIAÇÃO DO PAINEL DE CONTEÚDO-----------------------*/
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

/*-----------------------------CONFIGURAÇÃO GRÁFICA---------------------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();
                    int centroX = w / 2;

/*----------------------------DIMENSÕES DOS ELEMENTOS-------------------------*/
/*---------------------------DE ACORDO COM UMA ESCALA-------------------------*/
                    double escala = 1.0;
                    int larguraDesconectar = (int)     
                        (imagemBotaoDesconectar.getWidth() * 0.15 * escala);
                    int alturaDesconectar = (int) 
                        (imagemBotaoDesconectar.getHeight() * 0.15 * escala);
                    int larguraEntrar = (int)     
                        (imagemBotaoDesconectar.getWidth() * 1.0 * escala);
                    int alturaEntrar = (int) 
                        (imagemBotaoDesconectar.getHeight() * 1.0 * escala);

/*---------------------POSICIONAMENTO DOS ELEMENTOS NA TELA-------------------*/
                    int xDescon = centroX - (larguraDesconectar / 2) + 550;
                    int yDescon = (int) (h * 0.05); 
                    int xEntrar = centroX - (larguraEntrar / 2);
                    int yEntrar = (int) (h * 0.45) + 400;

/*------------------------CONFIGURAÇÃO DOS BOTÕES E CAMPO---------------------*/
                    botaoDesconectar.setBounds(xDescon, 
                             yDescon, 
                             larguraDesconectar, 
                             alturaDesconectar);

                    botaoEntrarEscondido.setBounds(xEntrar, 
                            yEntrar, 
                            larguraEntrar, 
                            alturaEntrar);
                    
/*--------------------------DESENHO DOS ELEMENTOS-----------------------------*/
                    g2d.drawImage(imagemBotaoDesconectar, 
                            xDescon, 
                            yDescon, 
                            larguraDesconectar, 
                            alturaDesconectar, this);
                }
            };
/*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO--------------------*/
            painelConteudo.setOpaque(false);

/*----------------------CONFIGURAÇÃO DO BOTÃO DESCONECTAR---------------------*/
            botaoDesconectar = new JButton();
            botaoDesconectar.setBorderPainted(false);
            botaoDesconectar.setContentAreaFilled(false);
            botaoDesconectar.setFocusPainted(false);
            botaoDesconectar.setOpaque(false);
            botaoDesconectar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoDesconectar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    TelaLobbyAluno lobbyAluno = new TelaLobbyAluno();
                    lobbyAluno.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                        (painelConteudo);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }
                }
            });
            painelConteudo.add(botaoDesconectar);
            
            botaoEntrarEscondido = new JButton();
            botaoEntrarEscondido.setBorderPainted(false);
            botaoEntrarEscondido.setContentAreaFilled(false);
            botaoEntrarEscondido.setFocusPainted(false);
            botaoEntrarEscondido.setOpaque(false);
            botaoEntrarEscondido.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    TelaGifContagem gifContagem = 
                            new TelaGifContagem("", origem, tipoSala);
                    gifContagem.setVisible(true);
                    Window janela = SwingUtilities.getWindowAncestor
                                        (painelConteudo);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }
                }
            });
            painelConteudo.add(botaoEntrarEscondido);
            
/*----------------------------CONFIGURAÇÃO DO LAYOUT--------------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

/*-------------------------PINTURA DO FUNDO DO PAINEL-------------------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

/*-------------------------CONFIGURAÇÃO DE RENDERIZAÇÃO-----------------------*/
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
            if (imagemDeFundoEsperaAluno != null) {
                g2d.drawImage(imagemDeFundoEsperaAluno, 0,
                        0,
                        w,
                        h, this);
            }
        }
    }
}