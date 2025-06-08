/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasLobby;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import CodigoPoligenio.Professor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*----------------------CLASSE PRINCIPAL DA TELA DE CADASTRO-----------------*/
public class TelaCadastrar extends JFrame {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    private JPanel painelCadastrar;
    private static String idProfessor;
    
    /*----------------------CONSTRUTOR DA TELA DE CADASTRO-------------------*/
    public TelaCadastrar(String idProfessor) {
        /*----------------------CONFIGURAÇÕES DA JANELA-------------------*/
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*----------------------CONFIGURA O LAYOUT DE CARTÕES-------------*/
        painelCadastrar = new JPanel();
        this.idProfessor = idProfessor;
        
        try {
            /*----------------------INSTANCIAÇÃO DO PAINEL----------------*/
            PanelCadastrar telaCadastrarPanel = new PanelCadastrar();
            setContentPane(telaCadastrarPanel);

        } catch (IOException e) {
            /*----------------------TRATAMENTO DE EXCEÇÕES-------------------*/
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*----------------------MÉTODO MAIN PARA EXECUTAR A TELA----------------*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCadastrar tela = new TelaCadastrar(idProfessor);
            tela.setVisible(true);
        });
    }
    
    /*----------------------CLASSE INTERNA: PAINEL DE CADASTRO---------------*/
    public static class PanelCadastrar extends JPanel {

        /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
        private BufferedImage imagemDeFundoCadastrar;
        private BufferedImage imagemNomeCadastrar;
        private BufferedImage imagemRaCadastrar;
        private BufferedImage imagemEmailCadastrar;
        private BufferedImage imagemSenhaCadastrar;
        private BufferedImage imagemConfirmarSenha;
        private BufferedImage imagemSerieCadastro;
        private BufferedImage imagemTurmaCadastro;
        private BufferedImage imagemCadastrar;
        private BufferedImage imagemVoltarCadastrar;
        
        private JTextField campoTextoNome;
        private JTextField campoTextoRA;
        private JTextField campoTextoEmail;
        private JPasswordField campoTextoSenha;
        private JPasswordField campoTextoConfirmSenha;
        private JTextField campoTextoSerie;
        private JTextField campoTextoTurma;
        private JButton botaoCadastrar;
        private JButton botaoVoltarCadastrar;
               
        /*----------------------CONSTRUTOR DO PAINEL DE CADASTRO-------------*/
        public PanelCadastrar() throws IOException {
            setLayout(new GridBagLayout());

            /*----------------------CARREGAMENTO DAS IMAGENS------------------*/
            imagemDeFundoCadastrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/telaCadastrar.png"));
            
            imagemNomeCadastrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/nomeCadastrar.png"));
            
            imagemRaCadastrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/raCadastrar.png"));
            
            imagemEmailCadastrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/emailCadastrar.png"));
            
            imagemSenhaCadastrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/senhaCadastrar.png"));
            
            imagemConfirmarSenha = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/confirmarSenhaCadastro.png"));
            
            imagemSerieCadastro = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/serieCadastro.png"));
            
            imagemTurmaCadastro = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/turmaCadastrar.png"));
            
            imagemCadastrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/cadastrar.png"));
            
            imagemVoltarCadastrar = ImageIO.read(getClass().getResource
        ("/ImagensTelaCadastrar/voltarLoginCadastrar.png"));
            
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
                    int larguraNomeCadastrar = (int) 
                            (imagemNomeCadastrar.getWidth() * 0.7 * escala);
                    int alturaNomeCadastrar = (int) 
                            (imagemNomeCadastrar.getHeight() * 0.7 * escala);
                    
                    int larguraRaCadastrar = (int) 
                            (imagemRaCadastrar.getWidth() * 0.7 * escala);
                    int alturaRaCadastrar = (int) 
                            (imagemRaCadastrar.getHeight() * 0.7 * escala);
                    
                    int larguraEmailCadastrar = (int) 
                            (imagemEmailCadastrar.getWidth() * 0.7 * escala);
                    int alturaEmailCadastrar = (int) 
                            (imagemEmailCadastrar.getHeight() * 0.7 * escala);
                    
                    int larguraSenhaCadastrar = (int) 
                            (imagemSenhaCadastrar.getWidth() * 0.7 * escala);
                    int alturaSenhaCadastrar = (int) 
                            (imagemSenhaCadastrar.getHeight() * 0.7 * escala);
                    
                    int larguraConfirmSenha = (int) 
                            (imagemConfirmarSenha.getWidth() * 0.7 * escala);
                    int alturaConfirmSenha = (int) 
                            (imagemConfirmarSenha.getHeight() * 0.7 * escala);
                    
                    int larguraSerieCadastrar = (int) 
                            (imagemSerieCadastro.getWidth() * 0.7 * escala);
                    int alturaSerieCadastrar = (int) 
                            (imagemSerieCadastro.getHeight() * 0.7 * escala);
                    
                    int larguraTurmaCadastrar = (int) 
                            (imagemTurmaCadastro.getWidth() * 0.7 * escala);
                    int alturaTurmaCadastrar = (int) 
                            (imagemTurmaCadastro.getHeight() * 0.7 * escala);
                    
                    int larguraCadastrar = (int) 
                            (imagemCadastrar.getWidth() * 0.7 * escala);
                    int alturaCadastrar = (int) 
                            (imagemCadastrar.getHeight() * 0.7 * escala);
                    
                    int larguraVoltarCadastrar = (int) 
                            (imagemVoltarCadastrar.getWidth() * 0.2 * escala);
                    int alturaVoltarCadastrar = (int) 
                            (imagemVoltarCadastrar.getHeight() * 0.2 * escala);
                    
                    /*----------------------POSICIONAMENTO DOS ELEMENTOS---------*/
                    int xNCad = centroX - (larguraNomeCadastrar / 2);
                    int yNCad = (int) (h * 0.60) - 460;
                    
                    int xRaCad = centroX - (larguraNomeCadastrar / 2);
                    int yRaCad = yNCad + 
                            alturaNomeCadastrar + 
                            (int)(20 * escala);
                    
                    int xEmailCad = centroX - (larguraNomeCadastrar / 2);
                    int yEmailCad = yRaCad + 
                            alturaRaCadastrar + 
                            (int)(20 * escala);
                    
                    int xPassCad = centroX - (larguraNomeCadastrar / 2);
                    int yPassCad = yEmailCad + 
                            alturaEmailCadastrar + 
                            (int)(20 * escala);
                    
                    int xPassConf = centroX - (larguraNomeCadastrar / 2);
                    int yPassConf = yPassCad + 
                            alturaSenhaCadastrar + 
                            (int)(20 * escala);
                    
                    int xSerie = centroX - (larguraNomeCadastrar / 2);
                    int ySerie = yPassConf + 
                            alturaConfirmSenha + 
                            (int)(20 * escala);
                    
                    int xTurma = centroX + (larguraNomeCadastrar / 14);
                    int yTurma = yPassConf + 
                            alturaConfirmSenha + 
                            (int)(20 * escala);
                    
                    int xCadastro = centroX - (larguraCadastrar / 2);
                    int yCadastro = yTurma + 
                            alturaTurmaCadastrar + 
                            (int)(100 * escala);
                    
                    int xVoltarCadastro = centroX - 
                            (larguraVoltarCadastrar / 2);
                    int yVoltarCadastro = yCadastro + 
                            alturaCadastrar + 
                            (int)(70 * escala);
                    
                    
                    /*----------------------CONFIGURAÇÃO DOS CAMPOS E BOTÕES-----*/
                    campoTextoNome.setBounds(xNCad + (int)(95 * escala), 
                            yNCad + (int)(6 * escala), 
                            (int)(350 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoRA.setBounds(xRaCad + (int)(64 * escala), 
                            yRaCad + (int)(6 * escala),
                            (int)(350 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoEmail.setBounds(xEmailCad + (int)(99 * escala), 
                            yEmailCad + (int)(27 * escala) - 21, 
                            (int)(350 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoSenha.setBounds(xPassCad + (int)(99 * escala),
                            yPassCad + (int)(6 * escala),
                            (int)(350 * escala),
                            (int)(50 * escala));
                    
                    campoTextoConfirmSenha.setBounds(xPassConf + 
                            (int)(205 * escala),
                            yPassConf + (int)(6 * escala),
                            (int)(350 * escala),
                            (int)(50 * escala));
                    
                    campoTextoSerie.setBounds(xSerie + (int)(99 * escala), 
                            ySerie + (int)(5 * escala), 
                            (int)(50 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoTurma.setBounds(xTurma + (int)(112 * escala),
                            yTurma + (int)(5 * escala),
                            (int)(50 * escala), 
                            (int)(50 * escala));
                    
                    botaoCadastrar.setBounds(xCadastro, 
                            yCadastro,
                            larguraCadastrar,
                            alturaCadastrar);
                    
                    botaoVoltarCadastrar.setBounds(xVoltarCadastro, 
                            yVoltarCadastro, 
                            larguraVoltarCadastrar,
                            alturaVoltarCadastrar);
                    
                    /*----------------------DESENHO DOS ELEMENTOS----------------*/
                    g2d.drawImage(imagemNomeCadastrar, xNCad,
                            yNCad, 
                            larguraNomeCadastrar,
                            alturaNomeCadastrar, this);
                    
                    g2d.drawImage(imagemRaCadastrar, xRaCad, 
                            yRaCad, 
                            larguraRaCadastrar, alturaRaCadastrar, this);
                    
                    g2d.drawImage(imagemEmailCadastrar, xEmailCad, 
                            yEmailCad, 
                            larguraEmailCadastrar, 
                            alturaEmailCadastrar, this);
                    
                    g2d.drawImage(imagemSenhaCadastrar, xPassCad,
                            yPassCad, 
                            larguraSenhaCadastrar,
                            alturaSenhaCadastrar, this);
                    
                    g2d.drawImage(imagemConfirmarSenha, xPassConf, 
                            yPassConf, 
                            larguraConfirmSenha, 
                            alturaConfirmSenha, this);
                    
                    g2d.drawImage(imagemSerieCadastro, xSerie, 
                            ySerie, 
                            larguraSerieCadastrar,
                            alturaSerieCadastrar, this);
                    
                    g2d.drawImage(imagemTurmaCadastro, xTurma, 
                            yTurma,
                            larguraTurmaCadastrar, 
                            alturaTurmaCadastrar, this);
                    
                    g2d.drawImage(imagemCadastrar, xCadastro, 
                            yCadastro, 
                            larguraCadastrar,
                            alturaCadastrar, this);
                    
                    g2d.drawImage(imagemVoltarCadastrar, xVoltarCadastro, 
                            yVoltarCadastro,
                            larguraVoltarCadastrar,
                            alturaVoltarCadastrar, this);
                    
                }
            };
            /*----------------------CONFIGURAÇÃO DO PAINEL DE CONTEÚDO-------*/
            painelConteudo.setOpaque(false);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO NOME---------------*/
            campoTextoNome = new JTextField();
            campoTextoNome.setBorder(null);
            campoTextoNome.setOpaque(false);
            campoTextoNome.setForeground(Color.BLACK);
            campoTextoNome.setFont(new Font("Jockey One",
                    Font.BOLD, 24));
            painelConteudo.add(campoTextoNome);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO RA-----------------*/
            campoTextoRA = new JTextField();
            campoTextoRA.setBorder(null);
            campoTextoRA.setOpaque(false);
            campoTextoRA.setForeground(Color.BLACK);
            campoTextoRA.setFont(new Font("Jockey One", 
                    Font.BOLD, 24));
            painelConteudo.add(campoTextoRA);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO EMAIL--------------*/
            campoTextoEmail = new JTextField();
            campoTextoEmail.setBorder(null);
            campoTextoEmail.setOpaque(false);
            campoTextoEmail.setForeground(Color.BLACK);
            campoTextoEmail.setFont(new Font("Jockey One", 
                    Font.BOLD, 24));
            painelConteudo.add(campoTextoEmail);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO SENHA--------------*/
            campoTextoSenha = new JPasswordField();
            campoTextoSenha.setBorder(null);
            campoTextoSenha.setOpaque(false);
            campoTextoSenha.setForeground(Color.BLACK);
            campoTextoSenha.setFont(new Font("Jockey One", 
                    Font.BOLD, 24));
            painelConteudo.add(campoTextoSenha);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO CONFIRMAR SENHA----*/
            campoTextoConfirmSenha = new JPasswordField();
            campoTextoConfirmSenha.setBorder(null);
            campoTextoConfirmSenha.setOpaque(false);
            campoTextoConfirmSenha.setForeground(Color.BLACK);
            campoTextoConfirmSenha.setFont(new Font("Jockey One", 
                    Font.BOLD, 24));
            painelConteudo.add(campoTextoConfirmSenha);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO SÉRIE--------------*/
            campoTextoSerie = new JTextField();
            campoTextoSerie.setBorder(null);
            campoTextoSerie.setOpaque(false);
            campoTextoSerie.setForeground(Color.BLACK);
            campoTextoSerie.setFont(new Font("Jockey One", 
                    Font.BOLD, 24));
            painelConteudo.add(campoTextoSerie);
            
            /*----------------------CONFIGURAÇÃO DO CAMPO TURMA--------------*/
            campoTextoTurma = new JTextField();
            campoTextoTurma.setBorder(null);
            campoTextoTurma.setOpaque(false);
            campoTextoTurma.setForeground(Color.BLACK);
            campoTextoTurma.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoTurma);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO CADASTRAR----------*/
            botaoCadastrar = new JButton();
            botaoCadastrar.setBorderPainted(false);
            botaoCadastrar.setContentAreaFilled(false);
            botaoCadastrar.setFocusPainted(false);
            botaoCadastrar.setOpaque(false);
            botaoCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*----------------------OBTÉM DADOS DIGITADOS------------*/
                    String nome = campoTextoNome.getText();
                    String ra = campoTextoRA.getText();
                    String email = campoTextoEmail.getText();
                    String senha = new String(campoTextoSenha.getPassword());
                    String confirmSenha = 
                            new String(campoTextoConfirmSenha.getPassword());
                    String serie = campoTextoSerie.getText();
                    String turma = campoTextoTurma.getText();

                    /*----------------------VERIFICA COINCIDÊNCIA DAS SENHAS--*/
                    if(!senha.equals(confirmSenha)) {
                        JOptionPane.showMessageDialog(null, 
                                "As senhas não coincidem!");
                        return;
                    }
                    
                    /*----------------------INSTANCIA O PROFESSOR------------*/
                    Professor professor = new Professor("", 
                            idProfessor, 
                            "", 
                            "", 
                            "");
                    /*----------------------CADASTRA O JOGADOR---------------*/
                    boolean sucesso = professor.cadastrarJogador(nome, 
                            ra, 
                            email, 
                            senha,
                            serie, 
                            turma);

                    if(sucesso) {
                        /*----------------------SUCESSO NO CADASTRO----------*/
                        JOptionPane.showMessageDialog(null, 
                                "Aluno cadastrado com sucesso!");
                    } else {
                        /*----------------------ERRO NO CADASTRO-------------*/
                        JOptionPane.showMessageDialog(null, 
                                "Erro ao cadastrar aluno.");
                    }
                }
            });
            painelConteudo.add(botaoCadastrar);
            
            /*----------------------CONFIGURAÇÃO DO BOTÃO VOLTAR-------------*/
            botaoVoltarCadastrar = new JButton();
            botaoVoltarCadastrar.setBorderPainted(false);
            botaoVoltarCadastrar.setContentAreaFilled(false);
            botaoVoltarCadastrar.setFocusPainted(false);
            botaoVoltarCadastrar.setOpaque(false);
            botaoVoltarCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltarCadastrar.addActionListener(e -> {
                /*----------------------ABRE TELA DO LOBBY PROFESSOR-----*/
                TelaLobbyProfessor lobbyProfessor = 
                        new TelaLobbyProfessor(idProfessor);
                lobbyProfessor.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                                    (PanelCadastrar.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    } 
            });
            painelConteudo.add(botaoVoltarCadastrar);
            
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
            if (imagemDeFundoCadastrar != null) {
                g2d.drawImage(imagemDeFundoCadastrar, 
                        0,
                        0, 
                        w,
                        h, this);
            }
        }
    }
}