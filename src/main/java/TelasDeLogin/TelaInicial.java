/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasDeLogin;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import CodigoPoligenio.Aluno;
import CodigoPoligenio.Professor;
import CodigoPoligenio.Sistema;
import TelasCriacaoSala.TelaQuestPersonalizado.PanelQuestPersonalizada;
import TelasCriacaoSala.TelaQuestPadrao.PanelQuestPadrao;
import TelasCriacaoSala.TelaCriarSala.PanelCriarSala;
import TelasLobby.TelaConfiguracao.PanelConfiguracao;
import TelasLobby.TelaCodigo.PanelCodigo;
import TelasLobby.TelaCadastrar.PanelCadastrar;
import TelasDeLogin.TelaRecuperarSenha.PanelRecuperarSenha;
import TelasLobby.TelaLobbyAluno.PanelLobbyAluno;
import TelasLobby.TelaLobbyProfessor.PanelLobbyProfessor;
import TelasDeLogin.TelaEmailCodigo.PanelEmailCodigo;
import TelasLobby.TelaLobbyAluno;
import TelasLobby.TelaLobbyProfessor;

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

    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel painelInicial;
    private Sistema sistema;
    private static String idProfessor;
    
    /*----------------------CONSTRUTOR DA TELA INICIAL----------------------*/
    public TelaInicial(String destinatario, String novaSenha, Sistema sistema) {
        
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        this.sistema = sistema;

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        painelInicial = new JPanel(cardLayout);
        painelInicial.setName("painelInicial");
        String email = "";
        
        try {
            /*----------------------INSTANCIAÇÃO DOS PAINÉIS----------------*/
            PanelInicial panelInicial = 
                    new PanelInicial(painelInicial);
            PanelRecuperarSenha panelRecuperarSenha = 
                    new PanelRecuperarSenha(painelInicial);
            PanelCadastrar panelCadastrar = 
                    new PanelCadastrar(painelInicial);
            PanelLobbyAluno telaLobbyAlunoPanel = 
                    new PanelLobbyAluno(painelInicial);
            PanelLobbyProfessor telaLobbyProfPanel = 
                    new PanelLobbyProfessor(painelInicial);
            PanelEmailCodigo telaEmailCodigoPanel = 
                    new PanelEmailCodigo(painelInicial, sistema);
            PanelCadastrar telaInicioPanel = 
                    new PanelCadastrar(painelInicial);
            PanelQuestPadrao painelQuestPadraoTela = 
                    new PanelQuestPadrao(painelInicial);

            
            /*----------------------ADICIONA PAINÉIS AO LAYOUT-------------*/
            painelInicial.add(panelInicial, "TelaInicial");
            painelInicial.add(panelRecuperarSenha, "TelaRecuperarSenha");
            painelInicial.add(panelCadastrar, "TelaCadastrar");
            painelInicial.add(telaLobbyAlunoPanel, "TelaLobbyAluno");
            painelInicial.add(telaLobbyProfPanel, "TelaLobbyProfessor");
            painelInicial.add(telaInicioPanel, "TelaCadastrar");
            painelInicial.add(painelQuestPadraoTela, "TelaQuestPadrao");

            painelInicial.add(new PanelCriarSala(painelInicial), 
                    "TelaCriarSala");
            
            painelInicial.add(new PanelConfiguracao(cardLayout, 
                    painelInicial, 
                    painelInicial, 
                    this, 
                    sistema), 
                    "TelaConfiguracao");
            
            /*----------------------ADICIONANDO OS PAINÉIS COM REFERÊNCIA AO INICIAL-------------*/
            painelInicial.add(new PanelCodigo(painelInicial), 
                    "TelaCodigo");
            
            painelInicial.add(new PanelQuestPersonalizada(painelInicial), 
                    "TelaQuestPersonalizado");
            
            painelInicial.add(new PanelQuestPadrao(painelInicial), 
                    "TelaQuestPadrao");
            
            painelInicial.add(new PanelEmailCodigo(painelInicial, sistema), 
                    "TelaEmailCodigo");
            
            painelInicial.add(new PanelCadastrar(painelInicial), 
                    "TelaCadastrar");
            
            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(painelInicial);
            cardLayout.show(painelInicial, "TelaInicial");

        } catch (IOException e) {
            /*----------------------TRATAMENTO DE EXCEÇÕES-------------------*/
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*----------------------MOSTRA TELA ESPECÍFICA NO CARD LAYOUT------------*/
    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelInicial, nomeTela);
    }

    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            /*----------------------INSTANCIA E EXECUTA O SISTEMA------------*/
            Sistema sistema = Sistema.getInstance();
            sistema.tocarMusica();
            TelaInicial tela = new TelaInicial("", "", sistema);
            tela.setVisible(true);
        });
    }

    /*----------------------RETORNA O PAINEL PRINCIPAL----------------------*/
    public JPanel getPainelPrincipal() {
        return painelInicial;
    }

    /*----------------------CLASSE INTERNA: PAINEL INICIAL-------------------*/
    public static class PanelInicial extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundo;
        private BufferedImage imagemBotaoEntrar;
        private BufferedImage imagemInputRA;
        private BufferedImage imagemInputSenha;
        private BufferedImage imagemEsqSenha;
        private BufferedImage imagemBotaoSair;

        private JButton botaoEntrar;
        private JButton botaoEsqSenha;
        private JButton botaoSair;
        private JTextField campoTextoRA;
        private JPasswordField campoTextoSenha;
        
        private JButton botaoSelecionado = null;
        
        private TelaInicial Inicial;
        private final JPanel container;
        
        /*----------------------CONSTRUTOR DO PAINEL INICIAL-----------------*/
        public PanelInicial(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundo = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/telaLogin.png"));
            
            imagemBotaoEntrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/botaoEntrarLogin.png"));
            
            imagemInputRA = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/inputBoxRA.png"));
            
            imagemInputSenha = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/inputBoxSenha.png"));
            
            imagemEsqSenha = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/forgotPassword.png"));
            
            imagemBotaoSair = ImageIO.read(getClass().getResource
        ("/ImagensTelaInicial/botaoSairJogo.png"));
            

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

                    /*----------------------CALCULA O CENTRO DA TELA------------*/
                    int centroX = w / 2;

                    /*----------------------DIMENSÕES DOS ELEMENTOS--------------*/
                    double escala = 1.0; // Defina a escala conforme necessário
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

                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
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

                    /*----------------------CONFIGURAÇÃO DOS BOTÕES E CAMPOS-----*/
                    campoTextoRA.setBounds(xRA + (int)(77 * escala) - 5, 
                            yRA + (int)(27 * escala) - 8, 
                            (int)(400 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoSenha.setBounds(xSenha + (int)(115 * escala) - 5, 
                            ySenha + (int)(27 * escala) - 8, 
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
                    
                    
                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
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
            
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);

            /*----------------------CONFIGURAÇÃO DO CAMPO RA-----------------*/
            campoTextoRA = new JTextField();
            campoTextoRA.setBorder(null);
            campoTextoRA.setOpaque(false);
            campoTextoRA.setForeground(Color.BLACK);
            campoTextoRA.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoRA);

            /*----------------------CONFIGURAÇÃO DO CAMPO SENHA--------------*/
            campoTextoSenha = new JPasswordField();
            campoTextoSenha.setBorder(null);
            campoTextoSenha.setOpaque(false);
            campoTextoSenha.setForeground(Color.BLACK);
            campoTextoSenha.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoSenha);

            /*----------------------CONFIGURAÇÃO DO BOTÃO ENTRAR-------------*/
            botaoEntrar = new JButton();
            botaoEntrar.setBorderPainted(false);
            botaoEntrar.setContentAreaFilled(false);
            botaoEntrar.setFocusPainted(false);
            botaoEntrar.setOpaque(false);
            botaoEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoEntrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*----------------------OBTÉM DADOS DIGITADOS------------*/
                    String nome = campoTextoRA.getText();
                    String Senha = new String(campoTextoSenha.getPassword());
                    
                    Professor professor = new Professor(nome, Senha);
                    Aluno aluno = new Aluno(nome, Senha);
                    
                    
                    if (aluno.fazerLogin(nome, Senha)) {
                        /*----------------------LOGIN DO ALUNO----------------*/
                        Sistema.getInstance().notificarCadastro(aluno);
                        
                        TelaGifEntrada lobby = 
                                new TelaGifEntrada(idProfessor, "aluno");
                        lobby.setVisible(true);
                        
                        Window janela = SwingUtilities.getWindowAncestor
                                (PanelInicial.this);
                        if (janela instanceof JFrame) {
                            janela.dispose();
                        } 
                        campoTextoRA.setText("");
                        campoTextoSenha.setText("");
                    } 
                    else if(professor.fazerLogin(nome, Senha)) {
                        /*----------------------LOGIN DO PROFESSOR------------*/
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
                        campoTextoRA.setText("");
                        campoTextoSenha.setText("");
                    }
                    else {
                        /*----------------------MOSTRA ERRO DE LOGIN----------*/
                        JOptionPane.showMessageDialog(null, 
                                "RA ou Senha incorretos!", 
                                "Erro de Login", 
                                JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            });
            painelConteudo.add(botaoEntrar);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO ESQUECI SENHA------*/
            botaoEsqSenha = new JButton();
            botaoEsqSenha.setBorderPainted(false);
            botaoEsqSenha.setContentAreaFilled(false);
            botaoEsqSenha.setFocusPainted(false);
            botaoEsqSenha.setOpaque(false);
            botaoEsqSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoEsqSenha.addActionListener(e -> {
                /*----------------------NAVEGA PARA TELA DE RECUPERAÇÃO---*/
                CardLayout cl = (CardLayout) container.getLayout();
                cl.show(container, "TelaRecuperarSenha");
            });
            painelConteudo.add(botaoEsqSenha);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO SAIR---------------*/
            botaoSair = new JButton();
            botaoSair.setBorderPainted(false);
            botaoSair.setContentAreaFilled(false);
            botaoSair.setFocusPainted(false);
            botaoSair.setOpaque(false);
            botaoSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoSair.addActionListener(e -> {
                /*----------------------FECHA A APLICAÇÃO-----------------*/
                Window janela = SwingUtilities.getWindowAncestor(this);
                if (janela instanceof JFrame) {
                    ((JFrame) janela).setDefaultCloseOperation
                                    (JFrame.EXIT_ON_CLOSE);
                    janela.dispose();
                }
            });
            painelConteudo.add(botaoSair);

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