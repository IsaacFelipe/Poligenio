/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasLobby;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE QUESTIONÁRIO--------------*/
public class TelaQuestionario extends JFrame {
    
/*-------------------------DECLARAÇÃO DE VARIÁVEIS----------------------------*/
    private JPanel painelQuestionario;
    private static String idProfessor;
    
/*----------------------CONSTRUTOR DA TELA DE QUESTIONÁRIO--------------------*/
    public TelaQuestionario(String idProfessor) {
/*-------------------------CONFIGURAÇÕES DA JANELA----------------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;

        painelQuestionario = new JPanel();

        try {
/*--------------------------INSTANCIAÇÃO DO PAINEL----------------------------*/
            PanelQuestionario telaQuestionarioPanel = 
                    new PanelQuestionario();
            setContentPane(telaQuestionarioPanel);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
/*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaQuestionario tela = new TelaQuestionario(idProfessor);
            tela.setVisible(true);
        });
    }
    
/*------------------CLASSE INTERNA: PAINEL DE QUESTIONÁRIO--------------------*/
    public static class PanelQuestionario extends JPanel {

/*-----------------------DECLARAÇÃO DE VARIÁVEIS------------------------------*/
        private BufferedImage imagemDeFundoQuestionario;
        private BufferedImage imagemBotaoUsarQuestionario;
        private BufferedImage imagemBotaoEditar;
        private BufferedImage imagemBotaoVoltar;
        private BufferedImage imagemBotaoNovoQuestionario;
                
        private JButton botaoUsarQuestionario;
        private JButton botaoEditar;
        private JButton botaoVoltar;
        private JButton botaoNovoQuestionario;
        
/*--------------------CONSTRUTOR DO PAINEL DE QUESTIONÁRIO--------------------*/
        public PanelQuestionario() throws IOException {
            setLayout(new GridBagLayout());

/*-------------------------CARREGAMENTO DAS IMAGENS---------------------------*/
            imagemDeFundoQuestionario = ImageIO.read
(getClass().getResource("/ImagensTelaQuestionario/telaQuestionario.png"));
            
            imagemBotaoUsarQuestionario = ImageIO.read
(getClass().getResource("/ImagensTelaQuestionario/botaoUsarQuestionario.png"));
            
            imagemBotaoEditar = ImageIO.read(getClass().getResource
        ("/ImagensTelaQuestionario/botaoEditar.png"));
            
            imagemBotaoNovoQuestionario = ImageIO.read(getClass().getResource
        ("/ImagensTelaQuestionario/botaoNovoQuest.png"));
            
            imagemBotaoVoltar = ImageIO.read(getClass().getResource
        ("/ImagensTelaQuestionario/botaoVoltar.png"));
            
/*-----------------------CRIAÇÃO DO PAINEL DE CONTEÚDO------------------------*/
            JPanel painelConteudo = new JPanel(null) {
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

/*------------------------CALCULA O CENTRO DA TELA----------------------------*/
                    int centroX = w / 2;

/*-------------------------DIMENSÕES DOS ELEMENTOS----------------------------*/
                    double escala = 1.0;
                    
                    int larguraBotUsarQuest = (int) 
                        (imagemBotaoUsarQuestionario.getWidth() * 
                            0.7 * escala);
                    int alturaBotUsarQuest = (int) 
                        (imagemBotaoUsarQuestionario.getHeight() * 
                            0.7 * escala);
                    
                    int larguraBotEditar = (int) 
                        (imagemBotaoEditar.getWidth() * 
                            0.7 * escala);
                    int alturaBotEditar = (int) 
                        (imagemBotaoEditar.getHeight() * 
                            0.7 * escala);
                    
                    int larguraBotVoltar = (int) 
                        (imagemBotaoVoltar.getWidth() * 
                            0.7 * escala);
                    int alturaBotVoltar = (int) 
                        (imagemBotaoVoltar.getHeight() * 
                            0.7 * escala);
                    
                    int larguraBotNovoQuest = (int) 
                        (imagemBotaoNovoQuestionario.getWidth() * 
                            0.7 * escala);
                    int alturaBotNovoQuest = (int) 
                        (imagemBotaoNovoQuestionario.getHeight() * 
                            0.7 * escala);
                    
/*------------------------POSICIONAMENTO DOS ELEMENTOS------------------------*/
                    int xUsarQuest = centroX - (larguraBotUsarQuest / 2) - 340;
                    int yUsarQuest = (int) (h * 0.45) + 315;
                    
                    int xEditar = centroX - (larguraBotUsarQuest / 2) - 90;
                    int yEditar = yUsarQuest;
                    
                    int xVoltar = centroX - (larguraBotVoltar / 2) + 110;
                    int yVoltar = yUsarQuest;
                    
                    int xNovoQuest = centroX - (larguraBotUsarQuest / 2) + 340;
                    int yNovoQuest = (int) (h * 0.45) + 315;
                    
/*-------------------------CONFIGURAÇÃO DOS BOTÕES----------------------------*/
                    botaoUsarQuestionario.setBounds(xUsarQuest, 
                            yUsarQuest, 
                            larguraBotUsarQuest, 
                            alturaBotUsarQuest);
                    
                    botaoEditar.setBounds(xEditar, 
                            yEditar, 
                            larguraBotEditar, 
                            alturaBotEditar);
                    
                    botaoVoltar.setBounds(xVoltar, 
                            yVoltar, 
                            larguraBotVoltar, 
                            alturaBotVoltar);
                    
                    botaoNovoQuestionario.setBounds(xNovoQuest, 
                            yNovoQuest, 
                            larguraBotNovoQuest, 
                            alturaBotNovoQuest);
                    
/*--------------------------DESENHO DOS ELEMENTOS-----------------------------*/
                    g2d.drawImage(imagemBotaoUsarQuestionario, 
                            xUsarQuest, 
                            yUsarQuest, 
                            larguraBotUsarQuest,
                            alturaBotUsarQuest, this);
                    
                    g2d.drawImage(imagemBotaoEditar, 
                            xEditar, 
                            yEditar, 
                            larguraBotEditar, 
                            alturaBotEditar, this);
                    
                    g2d.drawImage(imagemBotaoVoltar, 
                            xVoltar, 
                            yVoltar, 
                            larguraBotVoltar, 
                            alturaBotVoltar, this);
                    
                    g2d.drawImage(imagemBotaoNovoQuestionario, 
                            xNovoQuest, 
                            yNovoQuest, 
                            larguraBotNovoQuest, 
                            alturaBotNovoQuest, this);
                }
            };
/*---------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO---------------------*/
            painelConteudo.setOpaque(false);
            
/*------------------CONFIGURAÇÃO DO BOTÃO USAR QUESTIONÁRIO-------------------*/
            botaoUsarQuestionario = new JButton();
            botaoUsarQuestionario.setBorderPainted(false);
            botaoUsarQuestionario.setContentAreaFilled(false);
            botaoUsarQuestionario.setFocusPainted(false);
            botaoUsarQuestionario.setOpaque(false);
            botaoUsarQuestionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoUsarQuestionario);
            
/*------------------------CONFIGURAÇÃO DO BOTÃO EDITAR------------------------*/
            botaoEditar = new JButton();
            botaoEditar.setBorderPainted(false);
            botaoEditar.setContentAreaFilled(false);
            botaoEditar.setFocusPainted(false);
            botaoEditar.setOpaque(false);
            botaoEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoEditar);
            
/*------------------------CONFIGURAÇÃO DO BOTÃO VOLTAR------------------------*/
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener(e -> {
                TelaLobbyProfessor lobbyProfessor = 
                        new TelaLobbyProfessor(idProfessor);
                
                lobbyProfessor.setVisible(true);
                
                Window janela = SwingUtilities.getWindowAncestor
                            (PanelQuestionario.this);
                
                if (janela instanceof JFrame) {
                    janela.dispose();
                } 
            });
            painelConteudo.add(botaoVoltar);
            
/*--------------------CONFIGURAÇÃO DO BOTÃO NOVO QUESTIONÁRIO-----------------*/
            botaoNovoQuestionario = new JButton();
            botaoNovoQuestionario.setBorderPainted(false);
            botaoNovoQuestionario.setContentAreaFilled(false);
            botaoNovoQuestionario.setFocusPainted(false);
            botaoNovoQuestionario.setOpaque(false);
            botaoNovoQuestionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoNovoQuestionario);
            
/*--------------------------CONFIGURAÇÃO DO LAYOUT----------------------------*/
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
            if (imagemDeFundoQuestionario != null) {
                g2d.drawImage(imagemDeFundoQuestionario, 
                        0, 
                        0, 
                        w, 
                        h, this);
            }
        }
    }
}