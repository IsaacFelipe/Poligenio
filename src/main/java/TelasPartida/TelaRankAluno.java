/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasPartida;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE RANK ALUNO---------------*/
public class TelaRankAluno extends JFrame {

    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel painelPrincipal;
    private static String idProfessor;

    /*----------------------CONSTRUTOR DA TELA DE RANK ALUNO-----------------*/
    public TelaRankAluno(String idProfessor) {
        
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelRankAluno panelRank = new PanelRankAluno();
            painelPrincipal.add(panelRank, "TelaRankAluno");
            
            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(painelPrincipal);
            cardLayout.show(painelPrincipal, "TelaRankAluno");

        } 
        /*----------------------TRATAMENTO DE EXCEÇÕES-------------------*/
        catch (IOException e) {           
            JOptionPane.showMessageDialog(this, "Erro: " 
                    + e.getMessage(), 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaRankAluno tela = new TelaRankAluno(idProfessor);
            tela.setVisible(true);
        });
    }

    /*----------------------CLASSE INTERNA: PAINEL DE RANK ALUNO-------------*/
    public static class PanelRankAluno extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemFundoTelaRank;
        private BufferedImage imagemBotaoRetornar;
        
        private JButton botaoRetornar;

        /*----------------------CONSTRUTOR DO PAINEL DE RANK ALUNO-----------*/
        public PanelRankAluno() throws IOException {
            setLayout(new GridBagLayout());
 
            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemFundoTelaRank = ImageIO.read
        (getClass().getResource("/ImagensTelaRankAluno/telaRankAluno.jpg"));
            
            imagemBotaoRetornar = ImageIO.read
        (getClass().getResource
        ("/ImagensTelaRankAluno/botaoRetonarRankAluno.png"));

            /*----------------------CRIAÇÃO DO PAINEL DE CONTEÚDO-------------*/
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    /*----------------------CONFIGURAÇÃO GRÁFICA----------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    
                    int w = getWidth();
                    int h = getHeight();

                    /*----------------------CALCULA O CENTRO DA TELA------------*/
                    int centroX = w / 2;

                    /*----------------------DIMENSÕES DOS ELEMENTOS--------------*/
                    double escala = 1.0; // Defina a escala conforme necessário
                    int larguraBotaoRetornar = (int) 
                            (imagemBotaoRetornar.getWidth() * 0.7 * escala);
                    int alturaBotaoRetornar = (int) 
                            (imagemBotaoRetornar.getHeight() * 0.7 * escala);
                    
                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
                    int xRetornar = centroX - (larguraBotaoRetornar / 2) + 550;
                    int yRetornar = (int) (h * 0.45) + 450;

                    /*----------------------CONFIGURAÇÃO DOS BOTÕES--------------*/
                    botaoRetornar.setBounds(xRetornar,
                            yRetornar,
                            larguraBotaoRetornar,
                            alturaBotaoRetornar);
                    
                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemBotaoRetornar, 
                            xRetornar, 
                            yRetornar, 
                            larguraBotaoRetornar, 
                            alturaBotaoRetornar, this);
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);

            /*----------------------CONFIGURAÇÃO DO BOTÃO RETORNAR-----------*/
            botaoRetornar = new JButton();
            botaoRetornar.setContentAreaFilled(false);
            botaoRetornar.setBorderPainted(false);
            botaoRetornar.setFocusPainted(false);
            botaoRetornar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoRetornar);

            /*----------------------CONFIGURAÇÃO DO LAYOUT--------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

        /*----------------------PINTURA DO FUNDO DO PAINEL-------------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            /*----------------------DESENHO DA IMAGEM DE FUNDO---------------*/
            if (imagemFundoTelaRank != null) {
                g.drawImage(imagemFundoTelaRank, 
                        0, 
                        0, 
                        getWidth(), 
                        getHeight(), this);
            }
        }
    }
}