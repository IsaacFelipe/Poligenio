/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasDeLogin;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import CodigoPoligenio.Sistema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE NOVA SENHA---------------*/
public class TelaNovaSenha extends JFrame {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private CardLayout cardLayout;
    private JPanel TelaNovaSenha;
    private static String destinatario;
    
    /*----------------------CONFIGURA O LAYOUT DE NAVEGAÇÃO------------------*/
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }
    
    /*----------------------CONSTRUTOR DA TELA DE NOVA SENHA-----------------*/
    public TelaNovaSenha(String destinatario){
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        cardLayout = new CardLayout();
        TelaNovaSenha = new JPanel(cardLayout);
        /*----------------------INSTANCIA O SISTEMA----------------------*/
        Sistema sistema = Sistema.getInstance();
        this.destinatario = destinatario;

        
        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelNovaSenha telaNovaSenhaPanel = new PanelNovaSenha(TelaNovaSenha);
            TelaNovaSenha.add(telaNovaSenhaPanel, "TelaNovaSenha");
            /*----------------------CONFIGURAÇÃO DO PAINEL INICIAL-----------*/
            add(TelaNovaSenha);
            cardLayout.show(TelaNovaSenha, "TelaNovaSenha");

        } catch (IOException e) {
            /*----------------------TRATAMENTO DE EXCEÇÕES-------------------*/
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaNovaSenha telaNovaSenha = new TelaNovaSenha(destinatario);
            telaNovaSenha.setVisible(true);
        });
    }
    
    /*----------------------MOSTRA TELA ESPECÍFICA NO CARD LAYOUT------------*/
    public void mostrarTela(String nomeTela) {
            cardLayout.show(TelaNovaSenha, nomeTela);
    }
    
    /*----------------------CLASSE INTERNA: PAINEL DE NOVA SENHA-------------*/
    public static class PanelNovaSenha extends JPanel {
        
        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundoNovaSenha;
        private BufferedImage imagemInputNovaSenha;
        private BufferedImage imagemInputConfirmarSenha;
        private BufferedImage imagemBotaoEnviarNovaSenha;
        private BufferedImage imagemBotaoVoltarLogin;
        
        private JPasswordField campoNovaSenha;
        private JPasswordField campoConfirmarSenha;
        
        private JButton botaoEnviar;
        private JButton botaoVoltarLogin;
        
        private final JPanel container;
        
        /*----------------------CONSTRUTOR DO PAINEL DE NOVA SENHA-----------*/
        public PanelNovaSenha(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());
            
            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundoNovaSenha = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/telaNovaSenha.png"));
            imagemInputNovaSenha = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/inputNovaSenha.png"));
            imagemInputConfirmarSenha = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/inputConfirmarSenha.png"));
            imagemBotaoEnviarNovaSenha = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/botaoEnviarNS.png"));
            imagemBotaoVoltarLogin = ImageIO.read(getClass().getResource("/ImagensTelaNovaSenha/botaoVoltarLogin.png"));
            
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
                    double escala = 1.0; // Defina a escala conforme necessário
                    int larguraInputNS = (int) (imagemInputNovaSenha.getWidth() * 0.7 * escala);
                    int alturaInputNS = (int) (imagemInputNovaSenha.getHeight() * 0.7 * escala);
                    int larguraInputConfirmar = (int) (imagemInputConfirmarSenha.getWidth() * 0.7 * escala);
                    int alturaInputConfirmar = (int) (imagemInputConfirmarSenha.getHeight() * 0.7 * escala);
                    int larguraBotaoEnviar = (int) (imagemBotaoEnviarNovaSenha.getWidth() * 0.7 * escala);
                    int alturaBotaoEnviar = (int) (imagemBotaoEnviarNovaSenha.getHeight() * 0.7 * escala);
                    int larguraBotaoVoltar = (int) (imagemBotaoVoltarLogin.getWidth() * 0.7 * escala);
                    int alturaBotaoVoltar = (int) (imagemBotaoVoltarLogin.getHeight() * 0.7 * escala);
                    
                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
                    int xNovaSenha = centroX - (larguraInputNS / 2);
                    int yNovaSenha = (int) (h * 0.45) + 50; // 45% da altura da tela
                    int xConfirmSenha = centroX - (larguraInputConfirmar / 2);
                    int yConfirmSenha = yNovaSenha + alturaInputNS + (int)(20 * escala);
                    int xBotaoEnviar = centroX - (larguraBotaoEnviar / 2);
                    int yBotaoEnviar = yConfirmSenha + alturaInputConfirmar + (int)(60 * escala);
                    int xBotaoVoltar = centroX - (larguraBotaoVoltar / 2);
                    int yBotaoVoltar = yBotaoEnviar + alturaBotaoVoltar + (int)(90 * escala);
                    
                    /*----------------------CONFIGURAÇÃO DOS CAMPOS E BOTÕES-----*/
                    campoNovaSenha.setBounds(xNovaSenha + (int)(77 * escala) + 80, 
                            yNovaSenha + (int)(27 * escala) - 22, 
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
                    campoConfirmarSenha.setBounds(xConfirmSenha + (int)(77 * escala) + 185, 
                            yConfirmSenha + (int)(27 * escala) - 22, 
                            (int)(200 * escala), 
                            (int)(50 * escala));
                    
                    botaoEnviar.setBounds(xBotaoEnviar, yBotaoEnviar, larguraBotaoEnviar, alturaBotaoEnviar);
                    botaoVoltarLogin.setBounds(xBotaoVoltar, yBotaoVoltar, larguraBotaoVoltar, alturaBotaoVoltar);
                    
                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemInputNovaSenha, xNovaSenha, yNovaSenha, larguraInputNS, alturaInputNS, this);
                    
                    g2d.drawImage(imagemBotaoVoltarLogin, 
                            xBotaoVoltar, 
                            yBotaoVoltar, 
                            larguraBotaoVoltar, 
                            alturaBotaoVoltar, this);
                    
                    g2d.drawImage(imagemBotaoEnviarNovaSenha, 
                            xBotaoEnviar, 
                            yBotaoEnviar, 
                            larguraBotaoEnviar, 
                            alturaBotaoEnviar, this);
                    
                    g2d.drawImage(imagemInputConfirmarSenha, 
                            xConfirmSenha, 
                            yConfirmSenha, 
                            larguraInputConfirmar, 
                            alturaInputConfirmar, this);
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO NOVA SENHA---------*/
            campoNovaSenha = new JPasswordField();
            campoNovaSenha.setBorder(null);
            campoNovaSenha.setOpaque(false);
            campoNovaSenha.setForeground(Color.BLACK);
            campoNovaSenha.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoNovaSenha);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO CONFIRMAR SENHA----*/
            campoConfirmarSenha = new JPasswordField();
            campoConfirmarSenha.setBorder(null);
            campoConfirmarSenha.setOpaque(false);
            campoConfirmarSenha.setForeground(Color.BLACK);
            campoConfirmarSenha.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoConfirmarSenha);
            
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
                    /*----------------------OBTÉM SENHAS DIGITADAS------------*/
                    String novaSenha = new String(campoNovaSenha.getPassword());
                    String confirmarSenha = new String(campoConfirmarSenha.getPassword());

                    /*----------------------VERIFICA COINCIDÊNCIA DAS SENHAS--*/
                    if (!novaSenha.equals(confirmarSenha)) {
                        JOptionPane.showMessageDialog(null, "As senhas não coincidem.");
                        return;
                    }

                    /*----------------------INSTANCIA O SISTEMA---------------*/
                    Sistema sistema = Sistema.getInstance();
                    try {
                        /*----------------------ATUALIZA A SENHA---------------*/
                        boolean sucesso = sistema.novaSenha(destinatario, novaSenha);

                        if (sucesso) {
                            /*----------------------SUCESSO NA ATUALIZAÇÃO-----*/
                            JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso.");
                            TelaInicial tec = new TelaInicial(destinatario, novaSenha, sistema);
                            tec.setVisible(true);

                            Window janela = SwingUtilities.getWindowAncestor(PanelNovaSenha.this);
                            if (janela instanceof JFrame) {
                                janela.dispose();
                            }
                            campoNovaSenha.setText("");
                            campoConfirmarSenha.setText("");
                        } else {
                            /*----------------------ERRO NA ATUALIZAÇÃO-------*/
                            JOptionPane.showMessageDialog(null, "Erro ao atualizar a senha. Verifique o e-mail.");
                        }
                    } catch (Exception ex) {
                        /*----------------------TRATAMENTO DE EXCEÇÕES-----*/
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar a senha: " + ex.getMessage());
                    }
                }
            });
            painelConteudo.add(botaoEnviar);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO VOLTAR-------------*/
            botaoVoltarLogin = new JButton();
            botaoVoltarLogin.setBorderPainted(false);
            botaoVoltarLogin.setContentAreaFilled(false);
            botaoVoltarLogin.setFocusPainted(false);
            botaoVoltarLogin.setOpaque(false);
            botaoVoltarLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltarLogin.addActionListener(e -> {
                /*----------------------INSTANCIA O SISTEMA---------------*/
                Sistema sistema = Sistema.getInstance();
                /*----------------------ABRE TELA INICIAL-----------------*/
                TelaInicial tec = new TelaInicial(destinatario, "", sistema);
                tec.setVisible(true);

                Window janela = SwingUtilities.getWindowAncestor(PanelNovaSenha.this);
                if (janela instanceof JFrame) {
                    janela.dispose();
                }
                campoConfirmarSenha.setText("");
                campoNovaSenha.setText("");
            });
            painelConteudo.add(botaoVoltarLogin);
            
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
            if (imagemDeFundoNovaSenha != null) {
                g2d.drawImage(imagemDeFundoNovaSenha, 0, 0, w, h, this);
            }
        }
    }  
}