/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasDeLogin;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import CodigoPoligenio.Sistema;

/*----------------------CLASSE PRINCIPAL DA TELA DE RECUPERAÇÃO DE SENHA-----*/
public class TelaRecuperarSenha extends JFrame {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel painelRecuperarSenha;
    
    /*----------------------CONFIGURA O LAYOUT DE NAVEGAÇÃO------------------*/
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
        this.painelRecuperarSenha = painelPrincipal;
    }
    
    /*----------------------CONSTRUTOR DA TELA DE RECUPERAÇÃO DE SENHA-------*/
    public TelaRecuperarSenha() {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        painelRecuperarSenha = new JPanel(cardLayout);

        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelRecuperarSenha telaInicioPanel = new PanelRecuperarSenha(painelRecuperarSenha);
            painelRecuperarSenha.add(telaInicioPanel, "TelaRecuperarSenha");
            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(painelRecuperarSenha);
            cardLayout.show(painelRecuperarSenha, "TelaRecuperarSenha");

        } catch (IOException e) {
            /*----------------------TRATAMENTO DE EXCEÇÕES-------------------*/
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaRecuperarSenha tela = new TelaRecuperarSenha();
            tela.setVisible(true);
        });
    }
    
    /*----------------------MOSTRA TELA ESPECÍFICA NO CARD LAYOUT------------*/
    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelRecuperarSenha, nomeTela);
    }
    
    /*----------------------CLASSE INTERNA: PAINEL DE RECUPERAÇÃO DE SENHA---*/
    public static class PanelRecuperarSenha extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundoRecSenha;
        private BufferedImage imagemInputEmail;
        private BufferedImage imagemBotãoEnviar;
        private BufferedImage imagemBotãoVoltarLog;
        private BufferedImage imagemBotaoSair;
        
        private JTextField campoEmail;
        private JButton botaoEnviar;
        private JButton botaoVoltar;
        private JButton botaoSair;
        
        private final JPanel container;
        private String emailUsuario;
         
        /*----------------------CONSTRUTOR DO PAINEL DE RECUPERAÇÃO DE SENHA-*/
        public PanelRecuperarSenha(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundoRecSenha = ImageIO.read(getClass().getResource("/ImagensTelaRecuperarSenha/telaRecuperarSenha.png"));
            imagemInputEmail = ImageIO.read(getClass().getResource("/ImagensTelaRecuperarSenha/caixaEmailRec.png"));
            imagemBotãoEnviar = ImageIO.read(getClass().getResource("/ImagensTelaRecuperarSenha/botãoEnviarRec.png"));
            imagemBotãoVoltarLog = ImageIO.read(getClass().getResource("/ImagensTelaRecuperarSenha/botãoVoltaLog.png"));
            imagemBotaoSair = ImageIO.read(getClass().getResource("/ImagensTelaRecuperarSenha/botaoSairJogo.png"));
            
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

                    /*----------------------CALCULA O CENTRO DA TELA------------*/
                    int centroX = w / 2;

                    /*----------------------DIMENSÕES DOS ELEMENTOS--------------*/
                    double escala = 0.4; // Defina a escala conforme necessário
                    int larguraInputEmail = (int) (imagemInputEmail.getWidth() * 0.5 * escala);
                    int alturaInputEmail = (int) (imagemInputEmail.getHeight() * 0.5 * escala);
                    int larguraBotaoEnviar = (int) (imagemBotãoEnviar.getWidth() * 0.5 * escala);
                    int alturaBotaoEnviar = (int) (imagemBotãoEnviar.getHeight() * 0.5 * escala);
                    int larguraBotaoVoltar = (int) (imagemBotãoVoltarLog.getWidth() * 0.5 * escala);
                    int alturaBotaoVoltar = (int) (imagemBotãoVoltarLog.getHeight() * 0.5 * escala);
                    int larguraSair = (int) (imagemBotaoSair.getWidth() * 1.75 * escala);
                    int alturaSair = (int) (imagemBotaoSair.getHeight() * 1.75 * escala);

                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
                    int xEmail = centroX - (larguraInputEmail / 2);
                    int yEmail = (int) (h * 0.60) + 10; // Posição vertical do campo email
                    
                    int xBotaoEnviar = centroX - (larguraBotaoEnviar / 2);
                    int yBotaoEnviar = yEmail + alturaInputEmail + 50; // 40px abaixo do email
                    
                    int xBotaoVoltar = centroX - (larguraBotaoVoltar / 2);
                    int yBotaoVoltar = yBotaoEnviar + alturaBotaoEnviar + 30; // 20px abaixo do botão enviar
                    
                    int xSair = centroX - (larguraSair / 2) + 600;
                    int ySair = (int) (h * 0.45) - 360; // 45% da altura da tela

                    /*----------------------CONFIGURAÇÃO DOS BOTÕES E CAMPO------*/
                    campoEmail.setBounds(
                    xEmail + (int)(77 * escala) + 90, 
                    yEmail + (int)(27 * escala) - 76, 
                    (int)(1000 * escala), 
                    (int)(500 * escala)
                );
                
                    botaoEnviar.setBounds(xBotaoEnviar, yBotaoEnviar, larguraBotaoEnviar, alturaBotaoEnviar);
                    botaoVoltar.setBounds(xBotaoVoltar, yBotaoVoltar, larguraBotaoVoltar, alturaBotaoVoltar);
                    botaoSair.setBounds(xSair, ySair, larguraSair, alturaSair);

                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemInputEmail, xEmail, yEmail, larguraInputEmail, alturaInputEmail, this);
                    g2d.drawImage(imagemBotãoEnviar, xBotaoEnviar, yBotaoEnviar, larguraBotaoEnviar, alturaBotaoEnviar, this);
                    g2d.drawImage(imagemBotaoSair, xSair, ySair, larguraSair, alturaSair, this);
                    g2d.drawImage(imagemBotãoVoltarLog, xBotaoVoltar, yBotaoVoltar, larguraBotaoVoltar, alturaBotaoVoltar, this);
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO EMAIL--------------*/
            campoEmail = new JTextField();
            campoEmail.setBorder(null);
            campoEmail.setOpaque(false);
            campoEmail.setForeground(Color.BLACK);
            campoEmail.setFont(new Font("Jockey One", Font.BOLD, 30));
            painelConteudo.add(campoEmail);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO ENVIAR-------------*/
            botaoEnviar = new JButton();
            botaoEnviar.setBorderPainted(false);
            botaoEnviar.setContentAreaFilled(false);
            botaoEnviar.setFocusPainted(false);
            botaoEnviar.setOpaque(false);
            botaoEnviar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoEnviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*----------------------OBTÉM O EMAIL DIGITADO------------*/
                    String destinatario = campoEmail.getText();
                    
                    /*----------------------INSTANCIA O SISTEMA---------------*/
                    CodigoPoligenio.Sistema email = Sistema.getInstance();
                    try {
                        /*----------------------VALIDA OS DADOS---------------*/
                        boolean enviado = email.validarDados(destinatario);
                        if (enviado) {
                            /*----------------------ABRE TELA DE CÓDIGO-------*/
                            TelaEmailCodigo tec = new TelaEmailCodigo(destinatario);
                            tec.setVisible(true);
                            
                            /*----------------------FECHA A JANELA ATUAL------*/
                            Window janela = SwingUtilities.getWindowAncestor(PanelRecuperarSenha.this);
                            if (janela instanceof JFrame) {
                                janela.dispose();
                            }          
                            campoEmail.setText("");
                        } else {
                            /*----------------------MOSTRA ERRO DE EMAIL------*/
                            JOptionPane.showMessageDialog(null, "E-mail não encontrado no sistema.");
                        }
                    } catch (Exception ex) {
                        /*----------------------TRATAMENTO DE EXCEÇÕES-----*/
                        JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + ex.getMessage());
                    } 
                }
            });
            painelConteudo.add(botaoEnviar);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO VOLTAR-------------*/
            botaoVoltar = new JButton();
            botaoVoltar.setBorderPainted(false);
            botaoVoltar.setContentAreaFilled(false);
            botaoVoltar.setFocusPainted(false);
            botaoVoltar.setOpaque(false);
            botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltar.addActionListener(e -> {
                /*----------------------NAVEGA PARA TELA INICIAL----------*/
                CardLayout cl = (CardLayout) container.getLayout();
                cl.show(container, "TelaInicial");
                campoEmail.setText("");
            });
            painelConteudo.add(botaoVoltar);
            
            /*----------------------CONFIGURAÇÃO DO LAYOUT--------------------*/
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
            
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
                    ((JFrame) janela).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    janela.dispose(); // Fecha a janela
                }
            });
            painelConteudo.add(botaoSair);
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
            if (imagemDeFundoRecSenha != null) {
                g2d.drawImage(imagemDeFundoRecSenha, 0, 0, w, h, this);
            }
        }
    }
}