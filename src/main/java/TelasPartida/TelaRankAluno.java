/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasPartida;

/*-------------------------IMPORTAÇÕES NECESSÁRIAS----------------------------*/
import TelasLobby.TelaLobbyAluno;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import TelasLobby.TelaLobbyProfessor;

/*--------------------CLASSE PRINCIPAL DA TELA DE RANK------------------------*/
public class TelaRankAluno extends JFrame {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
    private JPanel painelPrincipal;
    private static String logado;
    private static String idProfessor;
    
/*-----------------------CONSTRUTOR DA TELA DE RANK---------------------------*/
    public TelaRankAluno(String logado, String idProfessor) {
        
/*--------------------------CONFIGURAÇÕES DA JANELA---------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.logado = logado;
        this.idProfessor = idProfessor;

/*---------------------INSTANCIANDO O PAINEL DA CLASSE------------------------*/
        painelPrincipal = new JPanel();

        try {
            PanelRankAluno panelRank = new PanelRankAluno(logado);
            setContentPane(panelRank);
        } catch (IOException e) {           
            JOptionPane.showMessageDialog(this, "Erro: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

/*--------------------MÉTODO MAIN PARA EXECUTAR A TELA------------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaRankAluno rankAluno = new TelaRankAluno(logado, idProfessor);
            rankAluno.setVisible(true);
        });
    }

/*---------------------CLASSE INTERNA: PAINEL DE RANK-------------------------*/
    public static class PanelRankAluno extends JPanel {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
        private BufferedImage imagemFundoTelaRank;
        private BufferedImage imagemBotaoRetornar;
        private JButton botaoRetornar;
        private String logado;

/*---------------------CONSTRUTOR DO PAINEL DE RANK---------------------------*/
        public PanelRankAluno(String logado) throws IOException {
            this.logado = logado;
            setLayout(new GridBagLayout());
 
/*------------------------CARREGAMENTO DAS IMAGENS----------------------------*/
            imagemFundoTelaRank = ImageIO.read(getClass().getResource
                    ("/ImagensTelaRankAluno/telaRankAluno.jpg"));
            imagemBotaoRetornar = ImageIO.read(getClass().getResource
                    ("/ImagensTelaRankAluno/botaoRetonarRankAluno.png"));

/*-----------------------CRIAÇÃO DO PAINEL DE CONTEÚDO------------------------*/
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    
/*--------------------------CONFIGURAÇÃO GRÁFICA------------------------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    
                    int w = getWidth();
                    int h = getHeight();

/*--------------------------CALCULA O CENTRO DA TELA--------------------------*/
                    int centroX = w / 2;

/*------------------------DIMENSÕES DOS ELEMENTOS-----------------------------*/
                    double escala = 1.0;
                    int larguraBotaoRetornar = (int)
                            (imagemBotaoRetornar.getWidth() * 0.7 * escala);
                    int alturaBotaoRetornar = (int) 
                            (imagemBotaoRetornar.getHeight() * 0.7 * escala);
                    
/*----------------------POSICIONAMENTO DOS ELEMENTOS--------------------------*/
                    int xRetornar = centroX - (larguraBotaoRetornar / 2) + 450;
                    int yRetornar = (int) (h * 0.45) + 350;

/*------------------------CONFIGURAÇÃO DOS BOTÕES-----------------------------*/
                    botaoRetornar.setBounds(xRetornar,
                            yRetornar, 
                            larguraBotaoRetornar,
                            alturaBotaoRetornar);
                    
/*------------------------DESENHO DOS ELEMENTOS NA TELA-----------------------*/
                    g2d.drawImage(imagemBotaoRetornar, 
                            xRetornar,
                            yRetornar, 
                            larguraBotaoRetornar, 
                            alturaBotaoRetornar, this);
                }
            };
            
/*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO--------------------*/
            painelConteudo.setOpaque(false);

/*--------------------------CONFIGURAÇÃO DO BOTÃO RETORNAR--------------------*/
            botaoRetornar = new JButton();
            botaoRetornar.setContentAreaFilled(false);
            botaoRetornar.setBorderPainted(false);
            botaoRetornar.setFocusPainted(false);
            botaoRetornar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoRetornar.addActionListener(e -> {
                SwingUtilities.getWindowAncestor(this).dispose();
                
/*--------------------------NAVEGACAO PARA TELA DE LOBBY----------------------*/
                if ("professor".equals(logado)) {
                    TelaLobbyProfessor telaLobby = 
                            new TelaLobbyProfessor(idProfessor);
                    telaLobby.setVisible(true);
                } else if ("aluno".equals(logado)) {
                    TelaLobbyAluno telaLobby = new TelaLobbyAluno();
                    telaLobby.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Tipo de usuário inválido!", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });

            painelConteudo.add(botaoRetornar);

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
            if (imagemFundoTelaRank != null) {
                g.drawImage(imagemFundoTelaRank, 0, 0, w, h, this);
            }
        }
    }
}