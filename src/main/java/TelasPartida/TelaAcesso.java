/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasPartida;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE ACESSO--------------------*/
public class TelaAcesso extends JFrame{
    
/*---------------------------DECLARAÇÃO DE VARIÁVEIS--------------------------*/
    private JPanel painelAcesso;
    private static String idProfessor;
    private static String codigoSala;

/*----------------------CONSTRUTOR DA TELA DE ACESSO--------------------------*/
    public TelaAcesso(String idProfessor, String codigoSala) {
        
/*------------------------CONFIGURAÇÕES DA JANELA-----------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;
        this.codigoSala = codigoSala;
        
/*--------------------------INSTANCIAÇÃO DO PAINEL----------------------------*/        
        painelAcesso = new JPanel();

        try {

           PanelAcesso panelRank = new PanelAcesso();
           setContentPane(panelRank);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

/*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaAcesso tela = new TelaAcesso(idProfessor, codigoSala);
            tela.setVisible(true);
        });
    }
    
/*----------------------CLASSE INTERNA: PAINEL DE ACESSO----------------------*/
    public static class PanelAcesso extends JPanel {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
        private BufferedImage imagemFundoAcesso;
        private BufferedImage imagemBotaoVoltar;
        
        private JButton botaoVoltar;
        
        private JTextField campoTextoCodigo;
        
/*-----------------------CONSTRUTOR DO PAINEL DE ACESSO-----------------------*/
        public PanelAcesso() throws IOException {
            setLayout(new GridBagLayout());
            
/*--------------------------CARREGAMENTO DAS IMAGENS--------------------------*/
            imagemFundoAcesso = ImageIO.read(getClass().getResource
                ("/ImagensTelaAcesso/telaAcesso.png"));
            
            imagemBotaoVoltar = ImageIO.read(getClass().getResource
                ("/ImagensTelaAcesso/botaoVoltar.png"));
            
/*-----------------------CRIAÇÃO DO PAINEL DE CONTEÚDO------------------------*/
         JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

/*----------------------------CONFIGURAÇÃO GRÁFICA----------------------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

                    int centroX = w / 2;

/*---------------------------DIMENSÕES DOS ELEMENTOS--------------------------*/
                    double escala = 1.0;
                    
                    int larguraBotVoltar = (int) 
                            (imagemBotaoVoltar.getWidth() * 0.7 * escala);
                    int alturaBotVoltar = (int) 
                            (imagemBotaoVoltar.getHeight() * 0.7 * escala);
                    
/*------------------------POSICIONAMENTO DOS ELEMENTOS------------------------*/
                    int xVoltar = centroX - (larguraBotVoltar / 2);
                    int yVoltar = (int) (h * 0.45) + 300;
                    
/*---------------------------CONFIGURAÇÃO DOS BOTÕES--------------------------*/
                    botaoVoltar.setBounds(xVoltar, 
                            yVoltar, 
                            larguraBotVoltar, 
                            alturaBotVoltar);
                    
                    campoTextoCodigo.setBounds(xVoltar + 
                            (int)(480 * escala), 
                            yVoltar + (int)(-280 * escala),
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
/*----------------------------DESENHO DOS ELEMENTOS---------------------------*/
                    g2d.drawImage(imagemBotaoVoltar, 
                            xVoltar, 
                            yVoltar, 
                            larguraBotVoltar, 
                            alturaBotVoltar, this);
                }
            };
         
/*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO--------------------*/
            painelConteudo.setOpaque(false);

/*-------------------------CONFIGURAÇÃO DO BOTÃO VOLTAR-----------------------*/
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener(e -> {
                TelaEsperaProfessor tela = new TelaEsperaProfessor(idProfessor,
                                                                codigoSala);
                tela.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                                    (PanelAcesso.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                }
            });
            painelConteudo.add(botaoVoltar);
            
            campoTextoCodigo = new JTextField();
            campoTextoCodigo.setBorder(null);
            campoTextoCodigo.setOpaque(false);
            campoTextoCodigo.setForeground(Color.WHITE);
            campoTextoCodigo.setFont(new Font("Koulen", Font.BOLD, 64));
            campoTextoCodigo.setText(codigoSala);
            campoTextoCodigo.setEditable(false);
            campoTextoCodigo.setFocusable(false);
            painelConteudo.add(campoTextoCodigo);

/*--------------------------CONFIGURAÇÃO DO LAYOUT----------------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }
        
/*------------------------PINTURA DO FUNDO DO PAINEL--------------------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

/*-----------------------CONFIGURAÇÃO DE RENDERIZAÇÃO-------------------------*/
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
            
/*-------------------------DESENHO DA IMAGEM DE FUNDO-------------------------*/
            if (imagemFundoAcesso != null) {
                g2d.drawImage(imagemFundoAcesso, 
                        0,
                        0, 
                        w, 
                        h, this);
            }
        } 
    }
}