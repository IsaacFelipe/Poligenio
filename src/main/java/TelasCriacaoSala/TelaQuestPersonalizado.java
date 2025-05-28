package TelasCriacaoSala;

import CodigoPoligenio.Professor;
import CodigoPoligenio.Sistema;
import TelasCriacaoSala.TelaMateriasPersonalizado.PanelMateriaPersonalizada;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaQuestPersonalizado extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelQuestPersonalizada;
    private static String materiaSelecionada;
    private static String textoNomeQuiz;
    private static String materia;
    private static String idProfessor;
    private static JTextField campoTextoNomeMateria;
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }

    public TelaQuestPersonalizado(String textoNomeQuiz, String idProfessor) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.textoNomeQuiz = textoNomeQuiz;
        this.idProfessor = idProfessor;

        cardLayout = new CardLayout();
        painelQuestPersonalizada = new JPanel(cardLayout);

        try {
            PanelQuestPersonalizada panelQuestPersonalizada = new 
                    PanelQuestPersonalizada(painelQuestPersonalizada);
            
            painelQuestPersonalizada.add(panelQuestPersonalizada, 
                    "TelaQuestPersonalizado");
            
            add(painelQuestPersonalizada);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaQuestPersonalizado tela = 
                    new TelaQuestPersonalizado(textoNomeQuiz, idProfessor);
            tela.setVisible(true);
        });
    }
    
    public void setMateriaSelecionada(String materia) {
        this.materiaSelecionada = materia;
        campoTextoNomeMateria.setText(materia);
    }
    
    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelQuestPersonalizada, nomeTela);
    }

    public static class PanelQuestPersonalizada extends JPanel {

        private BufferedImage imagemDeFundoQuestPersonalizado;
        private BufferedImage imagemNomeQuiz;
        private BufferedImage imagemBoxMateria;
        private BufferedImage imagemBotaoCriarQuest;
        private BufferedImage imagemBotaoVoltarQuest;        
        private BufferedImage imagemBotaoDicasOff;
        private BufferedImage imagemBotaoDicasOn;
        
        private String dicaSelecionada = null;
        
        private JLabel labelDicasOn;

        private final JPanel container;

        private JButton botaoCriar;
        private JButton botaoVoltar;
        private JButton botaoBoxMaterias;
        private JButton botaoDicasOff;
        private JTextField campoTextoNomeQuest;
        
        private boolean dicaAtivada = false;

        public PanelQuestPersonalizada(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            imagemDeFundoQuestPersonalizado = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPersonalizado/telaQuestaoPersonalizada.png"));
            
            imagemNomeQuiz = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPersonalizado/boxNomeQuiz.png"));
            
            imagemBoxMateria = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPersonalizado/boxMaterias.png"));
            
            imagemBotaoCriarQuest = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPersonalizado/botaoCriarQuest.png"));
            
            imagemBotaoVoltarQuest = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPersonalizado/botaoVoltarQuest.png"));
            
            imagemBotaoDicasOn = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPersonalizado/botaoDicasAtivado.png"));
            
            imagemBotaoDicasOff = ImageIO.read(getClass().getResource
            ("/ImagensTelaQuestPersonalizado/botaoDicasDesativado.png"));

            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

                    int centroX = w / 2;

/*-------------------------Dimensão dos elementos da tela---------------------*/

                    double escala = 1.0;
                    
                    int larguraNomeQuiz = (int) 
                            (imagemNomeQuiz.getWidth() * 0.7 * escala);
                    int alturaNomeQuiz = (int) 
                            (imagemNomeQuiz.getHeight() * 0.7 * escala);
                    
                    int larguraBoxMateria = (int) 
                            (imagemBoxMateria.getWidth() * 0.7 * escala);
                    int alturaBoxMateria = (int) 
                            (imagemBoxMateria.getHeight() * 0.7 * escala);
                    
                    int larguraCriarQuest = (int) 
                            (imagemBotaoCriarQuest.getWidth() * 0.7 * escala);
                    int alturaCriarQuest = (int) 
                            (imagemBotaoCriarQuest.getHeight() * 0.7 * escala);
                    
                    int larguraVoltarQuest = (int) 
                            (imagemBotaoVoltarQuest.getWidth() * 0.7 * escala);
                    int alturaVoltarQuest = (int) 
                            (imagemBotaoVoltarQuest.getHeight() * 0.7 * escala);
                    
                    int larguraBotDicaOff = (int) 
                            (imagemBotaoDicasOff.getWidth() * 0.7 * escala);
                    int alturaBotDicaOff = (int) 
                            (imagemBotaoDicasOff.getHeight() * 0.7 * escala);

/*--------------------Posicionamento dos elementos na tela--------------------*/

                    int xNQuiz = centroX - (larguraNomeQuiz / 3) + 60;
                    int yNQuiz = (int) (h * 0.45) - 195;
                    
                    int xBoxMat = centroX - (larguraBoxMateria / 3) + 60;
                    int yBoxMat = yNQuiz + alturaNomeQuiz + (int)(40 * escala);
                    
                    int xCriar = centroX - (larguraCriarQuest / 2) - 320;
                    int yCriar = (int) (h * 0.45) + 340;
                    
                    int xVoltar = centroX - (larguraVoltarQuest / 2) + 300;
                    int yVoltar = (int) (h * 0.45) + 340;
                    
                    int xDicaOff = centroX - (larguraBotDicaOff / 2);
                    int yDicaOff = (int) (h * 0.45) + 140;

/*-------------------Criação dos elementos com base na posição----------------*/

                    botaoCriar.setBounds(xCriar, 
                            yCriar, 
                            larguraCriarQuest, 
                            alturaCriarQuest);
                    
                    botaoVoltar.setBounds(xVoltar,
                            yVoltar, 
                            larguraVoltarQuest, 
                            alturaVoltarQuest);
                    
                    botaoBoxMaterias.setBounds(xBoxMat,
                            yBoxMat, 
                            larguraBoxMateria, 
                            alturaBoxMateria);
                    
                    botaoDicasOff.setBounds(xDicaOff,
                            yDicaOff,
                            larguraBotDicaOff, 
                            alturaBotDicaOff);
                    
                    campoTextoNomeQuest.setBounds(xNQuiz + (int)(75 * escala), 
                            yNQuiz + (int)(16 * escala), 
                            (int)(680 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoNomeMateria.setBounds(xBoxMat + (int)(320 * escala), 
                            yBoxMat + (int)(16 * escala), 
                            (int)(200 * escala), 
                            (int)(50 * escala));
                    
/*---------------------------Desenhando Imagens na tela-----------------------*/

                    g2d.drawImage(imagemNomeQuiz, 
                            xNQuiz, 
                            yNQuiz, 
                            larguraNomeQuiz, 
                            alturaNomeQuiz, this);
                    
                    g2d.drawImage(imagemBoxMateria, 
                            xBoxMat, 
                            yBoxMat, 
                            larguraBoxMateria, 
                            alturaBoxMateria, this);
                    
                    g2d.drawImage(imagemBotaoCriarQuest, 
                            xCriar, 
                            yCriar, 
                            larguraCriarQuest, 
                            alturaCriarQuest, this);
                    
                    g2d.drawImage(imagemBotaoVoltarQuest, 
                            xVoltar,
                            yVoltar, 
                            larguraVoltarQuest,
                            alturaVoltarQuest, this);
                    
                    g2d.drawImage(imagemBotaoDicasOff, 
                            xDicaOff,
                            yDicaOff,
                            larguraBotDicaOff, 
                            alturaBotDicaOff, this);
                }
            };
            painelConteudo.setOpaque(false);
            
            labelDicasOn = new JLabel
                (new ImageIcon(imagemBotaoDicasOn));
            labelDicasOn.setVisible(false);
            labelDicasOn.setBounds(0, 0,
                    imagemBotaoDicasOn.getWidth(), 
                    imagemBotaoDicasOn.getHeight());
            painelConteudo.add(labelDicasOn);
            
            campoTextoNomeQuest = new JTextField();
            campoTextoNomeQuest.setBorder(null);
            campoTextoNomeQuest.setOpaque(false);
            campoTextoNomeQuest.setForeground(Color.BLACK);
            campoTextoNomeQuest.setFont(new Font("Jockey One", Font.BOLD, 32));
            campoTextoNomeQuest.setHorizontalAlignment(JTextField.CENTER);
            campoTextoNomeQuest.setText(textoNomeQuiz);
            painelConteudo.add(campoTextoNomeQuest);
            
            campoTextoNomeMateria = new JTextField();
            campoTextoNomeMateria.setBorder(null);
            campoTextoNomeMateria.setOpaque(false);
            campoTextoNomeMateria.setForeground(Color.BLACK);
            campoTextoNomeMateria.setFont(new Font("Jockey One", Font.BOLD, 32));
            campoTextoNomeMateria.setHorizontalAlignment(JTextField.CENTER);
            campoTextoNomeMateria.setEditable(false);
            campoTextoNomeMateria.setFocusable(false);
            painelConteudo.add(campoTextoNomeMateria);
            
            botaoCriar = new JButton();
            botaoCriar.setBorderPainted(false);
            botaoCriar.setContentAreaFilled(false);
            botaoCriar.setFocusPainted(false);
            botaoCriar.setOpaque(false);
            botaoCriar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCriar.addActionListener((ActionEvent e) -> {                
/*-----------------Instanciando classes para obter seus métodos---------------*/               
                Professor professor = new Professor("", "");
                Sistema sistema = Sistema.getInstance();
                
 /*-----Atribuindo à variáveis os valores devolvido pelos métodos chamados----*/               
                String codigoSala = sistema.gerarCodigoSala();
                String materiaSala = campoTextoNomeMateria.getText();
                
/*---------------------Chamando o método da classe Professor------------------*/               
                professor.criarSala(idProfessor, codigoSala);
                
/*--------------------Instanciando nova tela para ser aberta------------------*/                
                TelaAdicionarPergunta addPergunta =
                        new TelaAdicionarPergunta(materiaSala);
                addPergunta.setVisible(true);
                
/*----------------------------Fechar janela atual-----------------------------*/                
                Window janela = SwingUtilities.getWindowAncestor
                                        (PanelQuestPersonalizada.this);
                if (janela instanceof JFrame) {
                    janela.dispose();                     
                }
            });
            painelConteudo.add(botaoCriar);
            
            botaoBoxMaterias = new JButton();
            botaoBoxMaterias.setBorderPainted(false);
            botaoBoxMaterias.setContentAreaFilled(false);
            botaoBoxMaterias.setFocusPainted(false);
            botaoBoxMaterias.setOpaque(false);
            botaoBoxMaterias.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoBoxMaterias.addActionListener((ActionEvent e) -> {
                String textoNomeQuiz = campoTextoNomeQuest.getText();
                TelaMateriasPersonalizado materias = 
                    new TelaMateriasPersonalizado(textoNomeQuiz, idProfessor);
                materias.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                                        (PanelQuestPersonalizada.this);
                if (janela instanceof JFrame) {
                    janela.dispose();                     
                }
            });
            painelConteudo.add(botaoBoxMaterias);
            
            botaoDicasOff = new JButton();
            botaoDicasOff.setBorderPainted(false);
            botaoDicasOff.setContentAreaFilled(false);
            botaoDicasOff.setFocusPainted(false);
            botaoDicasOff.setOpaque(false);
            botaoDicasOff.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoDicasOff.addActionListener((ActionEvent e) -> {
                SelecionarBotao("dicaOn");
            });
            painelConteudo.add(botaoDicasOff);
            
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener((ActionEvent e) -> {
                TelaCriarSala criarSala = new TelaCriarSala("");
                criarSala.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                                        (PanelQuestPersonalizada.this);
                if (janela instanceof JFrame) {
                    janela.dispose();                     
                }
            });
            painelConteudo.add(botaoVoltar);

            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

        private void SelecionarBotao(String tipo) {
            dicaSelecionada = tipo;

            if ("dicaOn".equals(tipo)) {
                dicaAtivada = !dicaAtivada;

                int w = getWidth();
                int h = getHeight();

                int centroX = w / 2;
                double escala = 1.0;

                int larguraBotDicaOff = 
                        (int) (imagemBotaoDicasOff.getWidth() * 0.7 * escala);
                int alturaBotDicaOff = 
                        (int) (imagemBotaoDicasOff.getHeight() * 0.7 * escala);

                int xDicaOff = centroX - (larguraBotDicaOff / 2);
                int yDicaOff = (int) (h * 0.45) + 140;

                Image imagemEscalada = imagemBotaoDicasOn.getScaledInstance(
                    larguraBotDicaOff, alturaBotDicaOff, Image.SCALE_SMOOTH);
                labelDicasOn.setIcon(new ImageIcon(imagemEscalada));

                labelDicasOn.setBounds(xDicaOff, 
                        yDicaOff, 
                        larguraBotDicaOff, 
                        alturaBotDicaOff);

                labelDicasOn.setVisible(dicaAtivada);
                labelDicasOn.repaint();
            }
        }
        
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

            // Melhor qualidade de renderização
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

            if (imagemDeFundoQuestPersonalizado != null) {
                g2d.drawImage(imagemDeFundoQuestPersonalizado, 
                        0, 
                        0, 
                        w, 
                        h, this);
            }
        }
    }
}