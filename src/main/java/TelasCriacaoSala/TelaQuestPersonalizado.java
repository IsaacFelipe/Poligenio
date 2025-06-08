/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
package TelasCriacaoSala;

import CodigoPoligenio.Professor;
import CodigoPoligenio.Sistema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE QUESTÕES PERSONALIZADAS----*/
public class TelaQuestPersonalizado extends JFrame {

    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private JPanel painelQuestPersonalizada;
    private static String materiaSelecionada;
    private static String textoNomeQuiz;
    private static String materia;
    private static String idProfessor;
    private static String idMateria;
    private static JTextField campoTextoNomeMateria;

    /*----------------------CONSTRUTOR DA TELA DE QUESTÕES PERSONALIZADAS------*/
    public TelaQuestPersonalizado(String textoNomeQuiz, 
            String idProfessor, 
            String idMateria) {
        
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.textoNomeQuiz = textoNomeQuiz;
        this.idProfessor = idProfessor;
        this.idMateria = idMateria;

        painelQuestPersonalizada = new JPanel();

        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelQuestPersonalizada questPersonalizada = new 
                    PanelQuestPersonalizada();
            setContentPane(questPersonalizada);
            
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaQuestPersonalizado tela = 
                    new TelaQuestPersonalizado(textoNomeQuiz, 
                            idProfessor, idMateria);
            tela.setVisible(true);
        });
    }

    /*----------------------DEFINE A MATÉRIA SELECIONADA---------------------*/
    public void setMateriaSelecionada(String materia) {
        this.materiaSelecionada = materia;
        campoTextoNomeMateria.setText(materia);
    }


    /*----------------------CLASSE INTERNA: PAINEL DE QUESTÕES PERSONALIZADAS--*/
    public static class PanelQuestPersonalizada extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundoQuestPersonalizado;
        private BufferedImage imagemNomeQuiz;
        private BufferedImage imagemBoxMateria;
        private BufferedImage imagemBotaoCriarQuest;
        private BufferedImage imagemBotaoVoltarQuest;        
        private BufferedImage imagemBotaoDicasOff;
        private BufferedImage imagemBotaoDicasOn;
        
        private String dicaSelecionada = null;
        
        private JLabel labelDicasOn;

        private JButton botaoCriar;
        private JButton botaoVoltar;
        private JButton botaoBoxMaterias;
        private JButton botaoDicasOff;
        
        private JTextField campoTextoNomeQuest;
        
        private boolean dicaAtivada = false;

        /*----------------------CONSTRUTOR DO PAINEL DE QUESTÕES PERSONALIZADAS--*/
        public PanelQuestPersonalizada() throws IOException {
            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
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

                    /*-------------------------DIMENSÃO DOS ELEMENTOS DA TELA---------------------*/
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

                    /*--------------------POSICIONAMENTO DOS ELEMENTOS NA TELA--------------------*/
                    int xNQuiz = centroX - (larguraNomeQuiz / 3) + 60;
                    int yNQuiz = (int) (h * 0.45) - 195;
                    
                    int xBoxMat = centroX - (larguraBoxMateria / 3) + 60;
                    int yBoxMat = yNQuiz + alturaNomeQuiz + (int)(40 * escala);
                    
                    int xCriar = centroX - (larguraCriarQuest / 2) - 320;
                    int yCriar = (int) (h * 0.45) + 345;
                    
                    int xVoltar = centroX - (larguraVoltarQuest / 2) + 300;
                    int yVoltar = (int) (h * 0.45) + 345;
                    
                    int xDicaOff = centroX - (larguraBotDicaOff / 2);
                    int yDicaOff = (int) (h * 0.45) + 140;

                    /*-------------------CRIAÇÃO DOS ELEMENTOS COM BASE NA POSIÇÃO----------------*/
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
                    
                    campoTextoNomeQuest.setBounds(xNQuiz + 
                            (int)(75 * escala), 
                            yNQuiz + (int)(16 * escala), 
                            (int)(680 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoNomeMateria.setBounds(xBoxMat + 
                            (int)(320 * escala), 
                            yBoxMat + (int)(16 * escala), 
                            (int)(200 * escala), 
                            (int)(50 * escala));
                    
                    /*---------------------------DESENHANDO IMAGENS NA TELA-----------------------*/
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

            /*----------------------CONFIGURAÇÃO DO LABEL DE DICAS ATIVADAS-------*/
            labelDicasOn = new JLabel
                (new ImageIcon(imagemBotaoDicasOn));
            labelDicasOn.setVisible(false);
            labelDicasOn.setBounds(0, 0,
                    imagemBotaoDicasOn.getWidth(), 
                    imagemBotaoDicasOn.getHeight());
            painelConteudo.add(labelDicasOn);

            /*----------------------CONFIGURAÇÃO DO CAMPO NOME DO QUIZ------------*/
            campoTextoNomeQuest = new JTextField();
            campoTextoNomeQuest.setBorder(null);
            campoTextoNomeQuest.setOpaque(false);
            campoTextoNomeQuest.setForeground(Color.BLACK);
            campoTextoNomeQuest.setFont(new Font("Jockey One", Font.BOLD, 32));
            campoTextoNomeQuest.setHorizontalAlignment(JTextField.CENTER);
            campoTextoNomeQuest.setText(textoNomeQuiz);
            painelConteudo.add(campoTextoNomeQuest);

            /*----------------------CONFIGURAÇÃO DO CAMPO NOME DA MATÉRIA---------*/
            campoTextoNomeMateria = new JTextField();
            campoTextoNomeMateria.setBorder(null);
            campoTextoNomeMateria.setOpaque(false);
            campoTextoNomeMateria.setForeground(Color.BLACK);
            campoTextoNomeMateria.setFont(new Font("Jockey One", Font.BOLD, 32));
            campoTextoNomeMateria.setHorizontalAlignment(JTextField.CENTER);
            campoTextoNomeMateria.setEditable(false);
            campoTextoNomeMateria.setFocusable(false);
            painelConteudo.add(campoTextoNomeMateria);

            /*----------------------CONFIGURAÇÃO DO BOTÃO CRIAR-------------------*/
            botaoCriar = new JButton();
            botaoCriar.setBorderPainted(false);
            botaoCriar.setContentAreaFilled(false);
            botaoCriar.setFocusPainted(false);
            botaoCriar.setOpaque(false);
            botaoCriar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCriar.addActionListener((ActionEvent e) -> {                
                /*-----------------INSTANCIANDO CLASSES PARA OBTER SEUS MÉTODOS---------------*/               
                Professor professor = new Professor("", "");
                Sistema sistema = Sistema.getInstance();
                
                /*-----ATRIBUINDO À VARIÁVEIS OS VALORES DEVOLVIDOS PELOS MÉTODOS CHAMADOS----*/               
                String codigoSala = sistema.gerarCodigoSala();
                String materiaSala = campoTextoNomeMateria.getText();
                
                /*---------------------CHAMANDO O MÉTODO DA CLASSE PROFESSOR------------------*/               
                professor.criarSala(idProfessor, codigoSala);
                
                /*--------------------INSTANCIANDO NOVA TELA PARA SER ABERTA------------------*/                
                TelaAdicionarPergunta addPergunta =
                        new TelaAdicionarPergunta(materiaSala, 
                                idMateria, 
                                idProfessor,
                                codigoSala);
                
                addPergunta.setVisible(true);
                
                /*----------------------------FECHAR JANELA ATUAL-----------------------------*/                
                Window janela = SwingUtilities.getWindowAncestor
                                        (PanelQuestPersonalizada.this);
                if (janela instanceof JFrame) {
                    janela.dispose();                     
                }
            });
            painelConteudo.add(botaoCriar);

            /*----------------------CONFIGURAÇÃO DO BOTÃO BOX MATÉRIAS------------*/
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

            /*----------------------CONFIGURAÇÃO DO BOTÃO DICAS DESATIVADAS-------*/
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

            /*----------------------CONFIGURAÇÃO DO BOTÃO VOLTAR------------------*/
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener((ActionEvent e) -> {
                TelaCriarSala criarSala = new TelaCriarSala(idProfessor);
                criarSala.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                                        (PanelQuestPersonalizada.this);
                if (janela instanceof JFrame) {
                    janela.dispose();                     
                }
            });
            painelConteudo.add(botaoVoltar);

            /*----------------------CONFIGURAÇÃO DO LAYOUT--------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

        /*----------------------SELEÇÃO DE BOTÃO DE DICAS---------------------*/
        private void SelecionarBotao(String tipo) {
            dicaSelecionada = tipo;

            if ("dicaOn".equals(tipo)) {
                /*----------------------ALTERNAR ESTADO DAS DICAS-------------*/
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

                /*----------------------CONFIGURA IMAGEM ESCALADA-------------*/
                Image imagemEscalada = imagemBotaoDicasOn.getScaledInstance(
                    larguraBotDicaOff, alturaBotDicaOff, Image.SCALE_SMOOTH);
                labelDicasOn.setIcon(new ImageIcon(imagemEscalada));

                /*----------------------POSICIONA E ATUALIZA LABEL------------*/
                labelDicasOn.setBounds(xDicaOff, 
                        yDicaOff, 
                        larguraBotDicaOff, 
                        alturaBotDicaOff);

                labelDicasOn.setVisible(dicaAtivada);
                labelDicasOn.repaint();
            }
        }

        /*----------------------PINTURA DO FUNDO DO PAINEL-------------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

            /*----------------------CONFIGURAÇÃO DE RENDERIZAÇÃO-------------*/
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

            /*----------------------DESENHO DA IMAGEM DE FUNDO---------------*/
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