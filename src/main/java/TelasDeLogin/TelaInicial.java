/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasDeLogin;

/*-------------------------IMPORTAÇÕES NECESSÁRIAS----------------------------*/
import CodigoPoligenio.Aluno;
import CodigoPoligenio.Professor;
import CodigoPoligenio.Sistema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA INICIAL----------------------*/
public class TelaInicial extends JFrame {

/*--------------------------DECLARAÇÃO DE VARIÁVEIS---------------------------*/
    private JPanel painelInicial;
    private Sistema sistema;
    private static String idProfessor;
    
/*-------------------------CONSTRUTOR DA TELA INICIAL-------------------------*/
    public TelaInicial(String destinatario, String novaSenha, Sistema sistema) {
        
/*--------------------------CONFIGURAÇÕES DA JANELA---------------------------*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        this.sistema = sistema;

/*------------------------INSTANCIANDO O PAINEL DA CLASSE---------------------*/
        painelInicial = new JPanel();
        String email = "";
        
        try {
            PanelInicial panelInicial = new PanelInicial();
            setContentPane(panelInicial);
            
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

/*-----------------------MÉTODO MAIN PARA EXECUTAR A TELA---------------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Sistema sistema = Sistema.getInstance();
            //sistema.tocarMusica();
            TelaInicial tela = new TelaInicial("", "", sistema);
            tela.setVisible(true);
        });
    }

/*-----------------------CLASSE INTERNA: PAINEL INICIAL-----------------------*/
    public static class PanelInicial extends JPanel {

/*---------------------------DECLARAÇÃO DE VARIÁVEIS--------------------------*/
        private BufferedImage imagemDeFundo;
        private BufferedImage imagemBotaoEntrar;
        private BufferedImage imagemInputRA;
        private BufferedImage imagemInputSenha;
        private BufferedImage imagemEsqSenha;
        private BufferedImage imagemBotaoSair;

        private JButton botaoEntrar;
        private JButton botaoEsqSenha;
        private JButton botaoSair;
        private JTextField campoTextoLogin;
        private JPasswordField campoTextoSenha;
        
        private JButton botaoSelecionado = null;
        
        private TelaInicial Inicial;
        
/*-------------------------CONSTRUTOR DO PAINEL INICIAL-----------------------*/
        public PanelInicial() throws IOException {
            setLayout(new GridBagLayout());

/*--------------------------CARREGAMENTO DAS IMAGENS--------------------------*/
            imagemDeFundo = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/telaLogin.png"));
            
            imagemBotaoEntrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/botaoEntrarLogin.png"));
            
            imagemInputRA = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/inputBoxLogin.png"));
            
            imagemInputSenha = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/inputBoxSenha.png"));
            
            imagemEsqSenha = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/forgotPassword.png"));
            
            imagemBotaoSair = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/botaoSairJogo.png"));
            

/*------------------------CRIAÇÃO DO PAINEL DE CONTEÚDO-----------------------*/
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
                    int larguraInput = (int) 
                            (imagemInputRA.getWidth() * 0.7 * escala);
                    int alturaInput = (int) 
                            (imagemInputRA.getHeight() * 0.7 * escala);
                    
                    int larguraBotao = (int) 
                            (imagemBotaoEntrar.getWidth() * 0.7 * escala);
                    int alturaBotao = (int) 
                            (imagemBotaoEntrar.getHeight() * 0.7 * escala);
                    
                    int larguraEsqSenha = (int) 
                            (imagemEsqSenha.getWidth() * 0.7 * escala);
                    int alturaEsqSenha = (int) 
                            (imagemEsqSenha.getHeight() * 0.7 * escala);
                    
                    int larguraSair = (int) 
                            (imagemBotaoSair.getWidth() * 0.7 * escala);
                    int alturaSair = (int) 
                            (imagemBotaoSair.getHeight() * 0.7 * escala);

/*------------------------POSICIONAMENTO DOS ELEMENTOS------------------------*/
                    int xRA = centroX - (larguraInput / 2);
                    int yRA = (int) (h * 0.45) - 30;
                    
                    int xSenha = centroX - (larguraInput / 2);
                    int ySenha = yRA + alturaInput + (int)(20 * escala);
                    
                    int xBotao = centroX - (larguraBotao / 2) - 3;
                    int yBotao = ySenha + alturaInput + (int)(40 * escala);
                    
                    int xEsqSenha = centroX - (larguraBotao / 2);
                    int yEsqSenha = yBotao + alturaBotao + (int)(50 * escala);
                    
                    int xSair = centroX - (larguraSair / 2) + 600;
                    int ySair = (int) (h * 0.45) - 360;

/*----------------------CONFIGURAÇÃO DOS BOTÕES E CAMPOS----------------------*/
                    campoTextoLogin.setBounds(xRA + (int)(95 * escala), 
                            yRA + (int)(19 * escala), 
                            (int)(400 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoSenha.setBounds(xSenha + (int)(110 * escala), 
                            ySenha + (int)(19 * escala), 
                            (int)(400 * escala), 
                            (int)(50 * escala));
                    
                    botaoEntrar.setBounds(xBotao, 
                            yBotao, 
                            larguraBotao, 
                            alturaBotao);
                    
                    botaoEsqSenha.setBounds(xEsqSenha, 
                            yEsqSenha, 
                            larguraEsqSenha, 
                            alturaEsqSenha);
                    
                    botaoSair.setBounds(xSair,
                            ySair, 
                            larguraSair, 
                            alturaSair);
                    
                    
/*-----------------------DESENHO DOS ELEMENTOS NA TELA------------------------*/
                    g2d.drawImage(imagemInputRA, 
                            xRA, 
                            yRA, 
                            larguraInput, 
                            alturaInput, this);
                    
                    g2d.drawImage(imagemInputSenha, 
                            xSenha, 
                            ySenha, 
                            larguraInput, 
                            alturaInput, this);
                    
                    g2d.drawImage(imagemBotaoEntrar, 
                            xBotao, 
                            yBotao, 
                            larguraBotao, 
                            alturaBotao, this);
                    
                    g2d.drawImage(imagemEsqSenha, 
                            xEsqSenha, 
                            yEsqSenha, 
                            larguraEsqSenha, 
                            alturaEsqSenha, this);
                    
                    g2d.drawImage(imagemBotaoSair, 
                            xSair, 
                            ySair, 
                            larguraSair, 
                            alturaSair, this);
                }
            };
            
/*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO--------------------*/
            painelConteudo.setOpaque(false);

 /*--------------------------CONFIGURAÇÃO DO CAMPO RA-------------------------*/
            campoTextoLogin = new JTextField();
            campoTextoLogin.setBorder(null);
            campoTextoLogin.setOpaque(false);
            campoTextoLogin.setForeground(Color.BLACK);
            campoTextoLogin.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoLogin);

/*--------------------------CONFIGURAÇÃO DO CAMPO SENHA-----------------------*/
            campoTextoSenha = new JPasswordField();
            campoTextoSenha.setBorder(null);
            campoTextoSenha.setOpaque(false);
            campoTextoSenha.setForeground(Color.BLACK);
            campoTextoSenha.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoSenha);

/*--------------------------CONFIGURAÇÃO DO BOTÃO ENTRAR----------------------*/
            botaoEntrar = new JButton();
            botaoEntrar.setBorderPainted(false);
            botaoEntrar.setContentAreaFilled(false);
            botaoEntrar.setFocusPainted(false);
            botaoEntrar.setOpaque(false);
            botaoEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoEntrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nome = campoTextoLogin.getText();
                    String Senha = new String(campoTextoSenha.getPassword());
                    
                    Professor professor = new Professor(nome, Senha);
                    Aluno aluno = new Aluno(nome, Senha);
                    
                    
                    if (aluno.fazerLogin(nome, Senha)) {
                        
/*------------------------------LOGIN DO ALUNO--------------------------------*/
                        Sistema.getInstance().notificarCadastro(aluno);
                        
                        TelaGifEntrada lobby = 
                                new TelaGifEntrada(idProfessor, "aluno");
                        lobby.setVisible(true);
                        
                        Window janela = SwingUtilities.getWindowAncestor
                                (PanelInicial.this);
                        if (janela instanceof JFrame) {
                            janela.dispose();
                        } 
                        campoTextoLogin.setText("");
                        campoTextoSenha.setText("");
                    } 
                    else if(professor.fazerLogin(nome, Senha)) {
                        
/*-----------------------------LOGIN DO PROFESSOR-----------------------------*/
                        String idProfessor = professor.getId();
                        Sistema.getInstance().notificarCadastro(professor);
                        
                        TelaGifEntrada lobby = 
                                new TelaGifEntrada(idProfessor, "professor");
                        lobby.setVisible(true);
                        
                        Window janela = SwingUtilities.getWindowAncestor
                                (PanelInicial.this);
                        
                        if (janela instanceof JFrame) {
                            janela.dispose();
                        } 
                        campoTextoLogin.setText("");
                        campoTextoSenha.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, 
                                "RA ou Senha incorretos!", 
                                "Erro de Login", 
                                JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            });
            painelConteudo.add(botaoEntrar);
            
/*---------------------CONFIGURAÇÃO DO BOTÃO ESQUECI SENHA--------------------*/
            botaoEsqSenha = new JButton();
            botaoEsqSenha.setBorderPainted(false);
            botaoEsqSenha.setContentAreaFilled(false);
            botaoEsqSenha.setFocusPainted(false);
            botaoEsqSenha.setOpaque(false);
            botaoEsqSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoEsqSenha.addActionListener(e -> {
                TelaRecuperarSenha recuperarSenha = new TelaRecuperarSenha();
                recuperarSenha.setVisible(true);
                
                Window janela = SwingUtilities.getWindowAncestor
                                (PanelInicial.this);
                            if (janela instanceof JFrame) {
                                janela.dispose();
                            }   
            });
            painelConteudo.add(botaoEsqSenha);
            
/*-------------------------CONFIGURAÇÃO DO BOTÃO SAIR-------------------------*/
            botaoSair = new JButton();
            botaoSair.setBorderPainted(false);
            botaoSair.setContentAreaFilled(false);
            botaoSair.setFocusPainted(false);
            botaoSair.setOpaque(false);
            botaoSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoSair.addActionListener(e -> {
                Window janela = SwingUtilities.getWindowAncestor(this);
                if (janela instanceof JFrame) {
                    ((JFrame) janela).setDefaultCloseOperation
                                    (JFrame.EXIT_ON_CLOSE);
                    janela.dispose();
                }
            });
            painelConteudo.add(botaoSair);

/*---------------------------CONFIGURAÇÃO DO LAYOUT---------------------------*/
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
            
/*--------------------------DESENHO DA IMAGEM DE FUNDO------------------------*/
            if (imagemDeFundo != null) {
                g2d.drawImage(imagemDeFundo, 
                        0, 
                        0, 
                        w, 
                        h, (ImageObserver) this);
            }
        }
    }
}