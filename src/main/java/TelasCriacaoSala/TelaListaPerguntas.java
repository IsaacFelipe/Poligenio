/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
package TelasCriacaoSala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*---------------------CLASSE PRINCIPAL DA TELA DE LISTAGEM DE PERGUNTAS----*/
public class TelaListaPerguntas extends JFrame {

    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel painelListaPerguntas;
    private static String idProfessor;

    /*----------------------CONSTRUTOR DA TELA DE LISTAGEM DE PERGUNTAS------*/
    public TelaListaPerguntas(String idProfessor) {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        painelListaPerguntas = new JPanel(cardLayout);
        this.idProfessor = idProfessor;

        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelListaPerguntas telaListaPerguntas = new PanelListaPerguntas();

            /*----------------------ADICIONANDO PAINEL AO LAYOUT-------------*/
            painelListaPerguntas.add(telaListaPerguntas, "TelaListaPerguntas");

            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(painelListaPerguntas);
            cardLayout.show(painelListaPerguntas, "TelaListaPerguntas");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaListaPerguntas tela = new TelaListaPerguntas(idProfessor);
            tela.setVisible(true);
        });
    }

    /*----------------------CLASSE INTERNA: PAINEL DE LISTAGEM DE PERGUNTAS--*/
    public static class PanelListaPerguntas extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundoListaPerguntas;
        private BufferedImage imagemBoxQuest;
        private BufferedImage imagemBotaoFacil;
        private BufferedImage imagemBotaoMedio;
        private BufferedImage imagemBotaoDificil;
        private BufferedImage imagemBotaoDificuldade;
        private BufferedImage imagemBotaoEditarPergunta;
        private BufferedImage imagemBotaoVoltar;

        private boolean mostrarImagemBotaoFacil = false;
        private boolean mostrarImagemBotaoMedio = true;
        private boolean mostrarImagemBotaoDificil = false;

        private JTextField campoTextoPergunta;
        private JTextField campoTextoNumeroPergunta;

        private JButton botaoEditarPergunta;
        private JButton botaoVoltar;

        /*----------------------CONSTRUTOR DO PAINEL DE LISTAGEM DE PERGUNTAS--*/
        public PanelListaPerguntas() throws IOException {
            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundoListaPerguntas = ImageIO.read(getClass().getResource("/ImagensTelaListaPerguntas/telaListaPerguntas.png"));
            imagemBoxQuest = ImageIO.read(getClass().getResource("/ImagensTelaListaPerguntas/boxPerguntaEditar.png"));
            imagemBotaoFacil = ImageIO.read(getClass().getResource("/ImagensTelaListaPerguntas/botaoFacil.png"));
            imagemBotaoMedio = ImageIO.read(getClass().getResource("/ImagensTelaListaPerguntas/botaoMedio.png"));
            imagemBotaoDificil = ImageIO.read(getClass().getResource("/ImagensTelaListaPerguntas/botaoDificil.png"));
            imagemBotaoDificuldade = ImageIO.read(getClass().getResource("/ImagensTelaListaPerguntas/botaoDificuldade.png"));
            imagemBotaoEditarPergunta = ImageIO.read(getClass().getResource("/ImagensTelaListaPerguntas/botaoEditarPergunta.png"));
            imagemBotaoVoltar = ImageIO.read(getClass().getResource("/ImagensTelaListaPerguntas/botaoVoltar.png"));

            /*----------------------CRIAÇÃO DO PAINEL DE CONTEÚDO-------------*/
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    /*----------------------CONFIGURAÇÃO GRÁFICA----------------*/
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();
                    int centroX = w / 2;

                    /*----------------------DIMENSIONAMENTO E POSICIONAMENTO----*/
                    double escala = 1.0;
                    int larguraBoxQuest = (int) (imagemBoxQuest.getWidth() * 0.7 * escala);
                    int alturaBoxQuest = (int) (imagemBoxQuest.getHeight() * 0.7 * escala);
                    int larguraBotFacil = (int) (imagemBotaoFacil.getWidth() * 0.7 * escala);
                    int alturaBotFacil = (int) (imagemBotaoFacil.getHeight() * 0.7 * escala);
                    int larguraBotMedio = (int) (imagemBotaoMedio.getWidth() * 0.7 * escala);
                    int alturaBotMedio = (int) (imagemBotaoMedio.getHeight() * 0.7 * escala);
                    int larguraBotDificil = (int) (imagemBotaoDificil.getWidth() * 0.7 * escala);
                    int alturaBotDificil = (int) (imagemBotaoDificil.getHeight() * 0.7 * escala);
                    int larguraBotDif = (int) (imagemBotaoDificuldade.getWidth() * 0.7 * escala);
                    int alturaBotDif = (int) (imagemBotaoDificuldade.getHeight() * 0.7 * escala);
                    int larguraBotEditar = (int) (imagemBotaoEditarPergunta.getWidth() * 0.7 * escala);
                    int alturaBotEditar = (int) (imagemBotaoEditarPergunta.getHeight() * 0.7 * escala);
                    int larguraBotVoltar = (int) (imagemBotaoVoltar.getWidth() * 0.7 * escala);
                    int alturaBotVoltar = (int) (imagemBotaoVoltar.getHeight() * 0.7 * escala);

                    /*----------------------COORDENADAS DOS ELEMENTOS-----------*/
                    int xBoxQuest = centroX - (larguraBoxQuest / 2);
                    int yBoxQuest = (int) (h * 0.45) - 230;
                    int xFacil = centroX - (larguraBotFacil / 2) + 270;
                    int yFacil = (int) (h * 0.45) - 142;
                    int xMedio = centroX - (larguraBotMedio / 2) + 270;
                    int yMedio = (int) (h * 0.45) - 142;
                    int xDificil = centroX - (larguraBotDificil / 2) + 270;
                    int yDificil = (int) (h * 0.45) - 142;
                    int xVoltar = centroX - (larguraBotVoltar / 2) - 490;
                    int yVoltar = (int) (h * 0.45) + 410;
                    int xDif = centroX - (larguraBotDif / 2) + 50;
                    int yDif = yFacil + alturaBotFacil + (int)(-68 * escala);
                    int xEditar = centroX - (larguraBotEditar / 2) + 490;
                    int yEditar = yFacil + alturaBotFacil + (int)(-68 * escala);

                    /*----------------------POSICIONAMENTO DOS CAMPOS------------*/
                    botaoVoltar.setBounds(xVoltar, yVoltar, larguraBotVoltar, alturaBotVoltar);
                    botaoEditarPergunta.setBounds(xEditar, yEditar, larguraBotEditar, alturaBotEditar);
                    campoTextoPergunta.setBounds(xBoxQuest + (int)(82 * escala), yBoxQuest + (int)(1 * escala), (int)(250 * escala), (int)(50 * escala));
                    campoTextoNumeroPergunta.setBounds(xBoxQuest - (int)(50 * escala), yBoxQuest - (int)(53 * escala), (int)(250 * escala), (int)(50 * escala));

                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemBotaoEditarPergunta, xEditar, yEditar, larguraBotEditar, alturaBotEditar, this);
                    g2d.drawImage(imagemBoxQuest, xBoxQuest, yBoxQuest, larguraBoxQuest, alturaBoxQuest, this);
                    if (mostrarImagemBotaoFacil) {
                        g2d.drawImage(imagemBotaoFacil, xFacil, yFacil + 7, larguraBotFacil, alturaBotFacil, this);
                    }
                    if (mostrarImagemBotaoMedio) {
                        g2d.drawImage(imagemBotaoMedio, xMedio, yMedio + 7, larguraBotMedio, alturaBotMedio, this);
                    }
                    if (mostrarImagemBotaoDificil) {
                        g2d.drawImage(imagemBotaoDificil, xDificil, yDificil + 7, larguraBotDificil, alturaBotDificil, this);
                    }
                    g2d.drawImage(imagemBotaoVoltar, xVoltar, yVoltar, larguraBotVoltar, alturaBotVoltar, this);
                    g2d.drawImage(imagemBotaoDificuldade, xDif, yDif, larguraBotDif, alturaBotDif, this);
                }
            };
            painelConteudo.setOpaque(false);

            /*----------------------CONFIGURAÇÃO DO BOTÃO VOLTAR--------------*/
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener(e -> {
                TelaCriarSala criarSala = new TelaCriarSala(idProfessor);
                criarSala.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor(PanelListaPerguntas.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                }
            });
            painelConteudo.add(botaoVoltar);

            /*----------------------CONFIGURAÇÃO DO BOTÃO EDITAR PERGUNTA-----*/
            botaoEditarPergunta = new JButton();
            botaoEditarPergunta.setBorderPainted(false);
            botaoEditarPergunta.setContentAreaFilled(false);
            botaoEditarPergunta.setFocusPainted(false);
            botaoEditarPergunta.setOpaque(false);
            botaoEditarPergunta.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoEditarPergunta.addActionListener(e -> {
                TelaEditarPergunta editarPergunta = new TelaEditarPergunta(idProfessor);
                editarPergunta.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor(PanelListaPerguntas.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                }
            });
            painelConteudo.add(botaoEditarPergunta);

            /*----------------------CONFIGURAÇÃO DO CAMPO TEXTO PERGUNTA-------*/
            campoTextoPergunta = new JTextField();
            campoTextoPergunta.setBorder(null);
            campoTextoPergunta.setOpaque(false);
            campoTextoPergunta.setForeground(Color.BLACK);
            campoTextoPergunta.setFont(new Font("Jockey One", Font.BOLD, 35));
            campoTextoPergunta.setEditable(false);
            campoTextoPergunta.setFocusable(false);
            painelConteudo.add(campoTextoPergunta);

            /*----------------------CONFIGURAÇÃO DO CAMPO NÚMERO DA PERGUNTA---*/
            campoTextoNumeroPergunta = new JTextField();
            campoTextoNumeroPergunta.setBorder(null);
            campoTextoNumeroPergunta.setOpaque(false);
            campoTextoNumeroPergunta.setForeground(Color.BLACK);
            campoTextoNumeroPergunta.setFont(new Font("Jockey One", Font.BOLD, 35));
            campoTextoNumeroPergunta.setText("Pergunta: 14");
            campoTextoNumeroPergunta.setEditable(false);
            campoTextoNumeroPergunta.setFocusable(false);
            painelConteudo.add(campoTextoNumeroPergunta);

            /*----------------------CONFIGURAÇÃO DO LAYOUT--------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

        /*----------------------PINTURA DO FUNDO DO PAINEL-------------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();

            /*----------------------CONFIGURAÇÃO DE RENDERIZAÇÃO-------------*/
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

            /*----------------------DESENHO DA IMAGEM DE FUNDO---------------*/
            if (imagemDeFundoListaPerguntas != null) {
                g2d.drawImage(imagemDeFundoListaPerguntas, 0, 0, w, h, this);
            }
        }
    }
}