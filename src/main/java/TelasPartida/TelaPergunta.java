package TelasPartida;

import CodigoPoligenio.PerguntaCriada;
import CodigoPoligenio.SalaCriada;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPergunta extends JFrame {
    
    private JPanel painelPergunta;
    private static String idProfessor;
    private static String tipoSala;
    
    public static JTextField campoTextoAltA;
    public static JTextField campoTextoAltB;
    public static JTextField campoTextoAltC;
    public static JTextField campoTextoAltD;
    
    public static JButton botaoAlternativaA;
    public static JButton botaoAlternativaB;
    public static JButton botaoAlternativaC;
    public static JButton botaoAlternativaD;
    public static JButton botaoConfirmar;
    
    private static JLabel labelAltASelecionado;
    private static JLabel labelAltBSelecionado;
    private static JLabel labelAltCSelecionado;
    private static JLabel labelAltDSelecionado;

    public TelaPergunta(String idProfessor, String tipoSala) throws Exception {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.idProfessor = idProfessor;
        this.tipoSala = tipoSala;

        try {
            painelPergunta = new PanelPergunta(this, 0);
            add(painelPergunta);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPergunta tela;
            try {
                tela = new TelaPergunta(idProfessor, tipoSala);
                tela.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(TelaPergunta.class.getName()).log
        (Level.SEVERE, null, ex);
            }
            
        });
    }

    public static class PanelPergunta extends JPanel {
        private BufferedImage imagemFundoPergunta;
        private BufferedImage imagemBotaoAlternativaA;
        private BufferedImage imagemBotaoAlternativaB;
        private BufferedImage imagemBotaoAlternativaC;
        private BufferedImage imagemBotaoAlternativaD;
        private BufferedImage imagemBoxPontuacaoErro;
        private BufferedImage imagemBoxPontuacaoAcerto;
        private BufferedImage imagemBotaoAjuda;
        private BufferedImage imagemBotaoConfirmar;
        
        private BufferedImage imagemAltASelecionado;
        private BufferedImage imagemAltBSelecionado;
        private BufferedImage imagemAltCSelecionado;
        private BufferedImage imagemAltDSelecionado;
        
        public String alternativaAtivada = null;
        public JButton botaoSelecionado = null;
        private String alternativaSelecionada;
        private boolean alternativas = false;
        
        private boolean duplaChanceUsada = false;

        private static JButton botaoAjuda;
        
        private JTextField campoTextoAcerto;
        private JTextField campoTextoErro;
        public JTextField campoPergunta;
        
        private JFrame parentFrame;
        private Random random = new Random();
        public JButton respostaCorreta;
        
        public boolean isDuplaChanceUsada() { 
            return duplaChanceUsada; 
        }
        
        public void setDuplaChanceUsada(boolean duplaChanceUsada) { 
            this.duplaChanceUsada = duplaChanceUsada; 
        }

        public PanelPergunta(JFrame parentFrame, int indiceRespostaCorreta)
                throws IOException, Exception {
            this.parentFrame = parentFrame;
            setLayout(new GridBagLayout());
            

            imagemFundoPergunta = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/telaPergunta.png"));
            
            imagemBotaoAlternativaA = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/botaoAlternativa.png"));
            
            imagemBotaoAlternativaB = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/botaoAlternativa.png"));
            
            imagemBotaoAlternativaC = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/botaoAlternativa.png"));
            
            imagemBotaoAlternativaD = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/botaoAlternativa.png"));
            
            imagemBoxPontuacaoErro = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/boxPontuacao.png"));
            
            imagemBoxPontuacaoAcerto = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/boxPontuacao.png"));
            
            imagemBotaoAjuda = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/botaoAjuda.png"));
            
            imagemAltASelecionado = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/alternativaSelecionada.png"));
            
            imagemAltBSelecionado = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/alternativaSelecionada.png"));
            
            imagemAltCSelecionado = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/alternativaSelecionada.png"));
            
            imagemAltDSelecionado = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/alternativaSelecionada.png"));
            
            imagemBotaoConfirmar = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/botaoConfirmar.png"));
            
            
            botaoAlternativaA = new JButton();
            botaoAlternativaB = new JButton();
            botaoAlternativaC = new JButton();
            botaoAlternativaD = new JButton();
            botaoConfirmar = new JButton();
            
            Map<String, String> perguntaComAlternativas = 
                    SalaCriada.exibirPerguntaComAlternativas();
            
            String correta = perguntaComAlternativas.get("correta");
            switch (correta) {
                case "A":
                    respostaCorreta = botaoAlternativaA;
                    break;
                case "B":
                    respostaCorreta = botaoAlternativaB;
                    break;
                case "C":
                    respostaCorreta = botaoAlternativaC;
                    break;
                case "D":
                    respostaCorreta = botaoAlternativaD;
                    break;
                default:
                    respostaCorreta = botaoAlternativaA; // Fallback
                    break;
            }
            
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
                    double escala = 1.0;
                    int larguraBotAltA = (int)
                            (imagemBotaoAlternativaA.getWidth() * 0.7 * escala);
                    int alturaBotAltA = (int)
                            (imagemBotaoAlternativaA.getHeight() * 0.7 * escala);
                    
                    int larguraBotAltB = (int)
                            (imagemBotaoAlternativaB.getWidth() * 0.7 * escala);
                    int alturaBotAltB = (int)
                            (imagemBotaoAlternativaB.getHeight() * 0.7 * escala);
                    
                    int larguraBotAltC = (int)
                            (imagemBotaoAlternativaC.getWidth() * 0.7 * escala);
                    int alturaBotAltC = (int)
                            (imagemBotaoAlternativaC.getHeight() * 0.7 * escala);
                    
                    int larguraBotAltD = (int)
                            (imagemBotaoAlternativaD.getWidth() * 0.7 * escala);
                    int alturaBotAltD = (int)
                            (imagemBotaoAlternativaD.getHeight() * 0.7 * escala);
                    
                    int larguraBoxAcerto = (int)
                            (imagemBoxPontuacaoAcerto.getWidth() * 0.2 * escala);
                    int alturaBoxAcerto = (int)
                            (imagemBoxPontuacaoAcerto.getHeight() * 0.2 * escala);
                    
                    int larguraBoxErro = (int)
                            (imagemBoxPontuacaoErro.getWidth() * 0.2 * escala);
                    int alturaBoxErro = (int)
                            (imagemBoxPontuacaoErro.getHeight() * 0.2 * escala);
                    
                    int larguraBotAjuda = (int)
                            (imagemBotaoAjuda.getWidth() * 0.2 * escala);
                    int alturaBotAjuda = (int)
                            (imagemBotaoAjuda.getHeight() * 0.2 * escala);
                    
                    int larguraBotConfirmar = (int)
                            (imagemBotaoConfirmar.getWidth() * 0.7 * escala);
                    int alturaBotConfirmar = (int)
                            (imagemBotaoConfirmar.getHeight() * 0.7 * escala);
                    
                    int xAltA = centroX - (larguraBotAltA / 2) - 480;
                    int yAltA = (int)(h * 0.45) + 80;
                    
                    int xAltB = centroX - (larguraBotAltB / 2);
                    int yAltB = yAltA;
                    
                    int xAltC = centroX - (larguraBotAltC / 2) - 480;
                    int yAltC = yAltA + alturaBotAltA + (int)(30 * escala);
                    
                    int xAltD = centroX - (larguraBotAltD / 2);
                    int yAltD = yAltB + alturaBotAltB + (int)(30 * escala);
                    
                    int xAcerto = centroX - (larguraBoxAcerto / 2) - 500;
                    int yAcerto = yAltD + alturaBotAltD + (int)(10 * escala);
                    
                    int xErro = centroX - (larguraBoxErro / 2) - 250;
                    int yErro = yAltD + alturaBotAltD + (int)(10 * escala);
                    
                    int xAjuda = centroX - (larguraBotAjuda / 2);
                    int yAjuda = yAltD + alturaBotAltD + (int)(10 * escala);
                    
                    int xConfirm = centroX - (larguraBotAjuda / 2) + 450;
                    int yConfirm = yAjuda + (int)(10 * escala);
                    
                    botaoAlternativaA.setBounds(xAltA,
                            yAltA, 
                            larguraBotAltA, 
                            alturaBotAltA);
                    
                    botaoAlternativaB.setBounds(xAltB, 
                            yAltB,
                            larguraBotAltB, 
                            alturaBotAltB);
                    
                    botaoAlternativaC.setBounds(xAltC, 
                            yAltC, 
                            larguraBotAltC, 
                            alturaBotAltC);
                    
                    botaoAlternativaD.setBounds(xAltD,
                            yAltD, 
                            larguraBotAltD,
                            alturaBotAltD);
                    
                    botaoAjuda.setBounds(xAjuda,
                            yAjuda, 
                            larguraBotAjuda, 
                            alturaBotAjuda);
                    
                    botaoConfirmar.setBounds(xConfirm,
                            yConfirm, 
                            larguraBotConfirmar, 
                            alturaBotConfirmar);
                    
                    campoPergunta.setBounds(centroX - (int)(400 * escala),
                            (int)(100 * escala), 
                            (int)(1500 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoAcerto.setBounds(xAcerto + (int)(77 * escala) - 12,
                            yAcerto + (int)(27 * escala) - 15, 
                            (int)(150 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoErro.setBounds(xErro + (int)(77 * escala), 
                            yErro + (int)(27 * escala) - 15,
                            (int)(150 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoAltA.setBounds(xAltA + (int)(77 * escala), 
                            yAltA + (int)(15 * escala), 
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoAltB.setBounds(xAltB + (int)(77 * escala), 
                            yAltB + (int)(15 * escala), 
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoAltC.setBounds(xAltC + (int)(77 * escala), 
                            yAltC + (int)(15 * escala), 
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
                    campoTextoAltD.setBounds(xAltD + (int)(77 * escala), 
                            yAltD + (int)(15 * escala), 
                            (int)(300 * escala), 
                            (int)(50 * escala));
                    
                    if (botaoAlternativaA.isVisible()) {
                        g2d.drawImage(imagemBotaoAlternativaA, 
                                xAltA,
                                yAltA, 
                                larguraBotAltA, 
                                alturaBotAltA, this);
                    }
                    
                    if (botaoAlternativaB.isVisible()) {
                        g2d.drawImage(imagemBotaoAlternativaB, 
                                xAltB, 
                                yAltB, 
                                larguraBotAltB,
                                alturaBotAltB, this);
                    }
                    
                    if (botaoAlternativaC.isVisible()) {
                        g2d.drawImage(imagemBotaoAlternativaC,
                                xAltC,
                                yAltC,
                                larguraBotAltC, 
                                alturaBotAltC, this);
                    }
                    
                    if (botaoAlternativaD.isVisible()) {
                        g2d.drawImage(imagemBotaoAlternativaD, 
                                xAltD,
                                yAltD, 
                                larguraBotAltD,
                                alturaBotAltD, this);
                    }
                    
                    g2d.drawImage(imagemBoxPontuacaoAcerto,
                            xAcerto,
                            yAcerto,
                            larguraBoxAcerto, 
                            alturaBoxAcerto, this);
                    
                    g2d.drawImage(imagemBoxPontuacaoErro, 
                            xErro,
                            yErro, 
                            larguraBoxErro,
                            alturaBoxErro, this);
                    
                    g2d.drawImage(imagemBotaoAjuda,
                            xAjuda,
                            yAjuda, 
                            larguraBotAjuda, 
                            alturaBotAjuda, this);
                    
                    g2d.drawImage(imagemBotaoConfirmar,
                            xConfirm,
                            yConfirm, 
                            larguraBotConfirmar, 
                            alturaBotConfirmar, this);
                }
            };
            painelConteudo.setOpaque(false);
            
            String pergunta = perguntaComAlternativas.get("pergunta");
            String altA = perguntaComAlternativas.get("A");
            String altB = perguntaComAlternativas.get("B");
            String altC = perguntaComAlternativas.get("C");
            String altD = perguntaComAlternativas.get("D");
            String id = perguntaComAlternativas.get("id");
            String corretaAlternativa = perguntaComAlternativas.get("correta");
            
            PerguntaCriada perguntaAtual = new PerguntaCriada(id, corretaAlternativa);
            
            botaoAlternativaA.setBorderPainted(false);
            botaoAlternativaA.setContentAreaFilled(false);
            botaoAlternativaA.setFocusPainted(false);
            botaoAlternativaA.setOpaque(false);
            botaoAlternativaA.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAlternativaA.addActionListener(e -> {
                SelecionarBotao("alternativa A");
            });
            painelConteudo.add(botaoAlternativaA);
            
            botaoAlternativaB.setBorderPainted(false);
            botaoAlternativaB.setContentAreaFilled(false);
            botaoAlternativaB.setFocusPainted(false);
            botaoAlternativaB.setOpaque(false);
            botaoAlternativaB.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAlternativaB.addActionListener(e -> {
                SelecionarBotao("alternativa B");
            });
            painelConteudo.add(botaoAlternativaB);
            
            botaoAlternativaC.setBorderPainted(false);
            botaoAlternativaC.setContentAreaFilled(false);
            botaoAlternativaC.setFocusPainted(false);
            botaoAlternativaC.setOpaque(false);
            botaoAlternativaC.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAlternativaC.addActionListener(e -> {
                SelecionarBotao("alternativa C");
            });
            painelConteudo.add(botaoAlternativaC);
            
            botaoAlternativaD.setBorderPainted(false);
            botaoAlternativaD.setContentAreaFilled(false);
            botaoAlternativaD.setFocusPainted(false);
            botaoAlternativaD.setOpaque(false);
            botaoAlternativaD.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAlternativaD.addActionListener(e -> {
                SelecionarBotao("alternativa D");
            });
            painelConteudo.add(botaoAlternativaD);
            
            botaoAjuda = new JButton();
            botaoAjuda.setBorderPainted(false);
            botaoAjuda.setContentAreaFilled(false);
            botaoAjuda.setFocusPainted(false);
            botaoAjuda.setOpaque(false);
            botaoAjuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAjuda.addActionListener(e -> {
                try {
                    JDialog dialogAjuda = new JDialog(parentFrame, true);
                    PanelAjuda panelAjuda = new PanelAjuda(dialogAjuda, this);
                    dialogAjuda.add(panelAjuda);
                    dialogAjuda.setUndecorated(true);
                    dialogAjuda.setBackground(new Color(0, 0, 0, 0));
                    dialogAjuda.pack();
                    dialogAjuda.setLocationRelativeTo(parentFrame);
                    dialogAjuda.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(parentFrame, 
                            "Erro ao abrir a tela de ajuda: " + ex.getMessage(), 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });
            painelConteudo.add(botaoAjuda);
            
            botaoConfirmar.setBorderPainted(false);
            botaoConfirmar.setContentAreaFilled(false);
            botaoConfirmar.setFocusPainted(false);
            botaoConfirmar.setOpaque(false);
            botaoConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoConfirmar.addActionListener(e -> {
                if (alternativaAtivada == null) {
                    JOptionPane.showMessageDialog(parentFrame, 
                            "Por favor, selecione uma alternativa!", 
                            "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String alternativaSelecionada = null;
                switch (alternativaAtivada) {
                    case "alternativa A":
                        alternativaSelecionada = "A";
                        break;
                    case "alternativa B":
                        alternativaSelecionada = "B";
                        break;
                    case "alternativa C":
                        alternativaSelecionada = "C";
                        break;
                    case "alternativa D":
                        alternativaSelecionada = "D";
                        break;
                }

                try {
                    perguntaAtual.verificarResposta(alternativaSelecionada, 
                            parentFrame);
                    PerguntaCriada.limparEInserirQuest(this, idProfessor);
                } catch (Exception ex) {
                    Logger.getLogger(TelaPergunta.class.getName()).log
                                        (Level.SEVERE, null, ex);
                }
            });
            painelConteudo.add(botaoConfirmar);
            
            campoTextoAcerto = new JTextField();
            campoTextoAcerto.setBorder(null);
            campoTextoAcerto.setOpaque(false);
            campoTextoAcerto.setForeground(Color.BLACK);
            campoTextoAcerto.setFont(new Font("Jockey One", Font.BOLD, 30));
            campoTextoAcerto.setText("2 milhões");
            campoTextoAcerto.setEditable(false);
            campoTextoAcerto.setFocusable(false);
            painelConteudo.add(campoTextoAcerto);
            
            campoPergunta = new JTextField();
            campoPergunta.setBorder(null);
            campoPergunta.setOpaque(false);
            campoPergunta.setForeground(Color.BLACK);
            campoPergunta.setFont(new Font("Jockey One", Font.BOLD, 30));
            campoPergunta.setText(pergunta);
            campoPergunta.setEditable(false);
            campoPergunta.setFocusable(false);
            painelConteudo.add(campoPergunta);
            
            campoTextoErro = new JTextField();
            campoTextoErro.setBorder(null);
            campoTextoErro.setOpaque(false);
            campoTextoErro.setForeground(Color.BLACK);
            campoTextoErro.setFont(new Font("Jockey One", Font.BOLD, 30));
            campoTextoErro.setText("500 mil");
            campoTextoErro.setEditable(false);
            campoTextoErro.setFocusable(false);
            painelConteudo.add(campoTextoErro);
            
            campoTextoAltA = new JTextField();
            campoTextoAltA.setBorder(null);
            campoTextoAltA.setOpaque(false);
            campoTextoAltA.setForeground(Color.BLACK);
            campoTextoAltA.setFont(new Font("Jockey One", Font.BOLD, 40));
            campoTextoAltA.setText(altA);
            campoTextoAltA.setEditable(false);
            campoTextoAltA.setFocusable(false);
            painelConteudo.add(campoTextoAltA);
            
            campoTextoAltB = new JTextField();
            campoTextoAltB.setBorder(null);
            campoTextoAltB.setOpaque(false);
            campoTextoAltB.setForeground(Color.BLACK);
            campoTextoAltB.setFont(new Font("Jockey One", Font.BOLD, 40));
            campoTextoAltB.setText(altB);
            campoTextoAltB.setEditable(false);
            campoTextoAltB.setFocusable(false);
            painelConteudo.add(campoTextoAltB);
            
            campoTextoAltC = new JTextField();
            campoTextoAltC.setBorder(null);
            campoTextoAltC.setOpaque(false);
            campoTextoAltC.setForeground(Color.BLACK);
            campoTextoAltC.setFont(new Font("Jockey One", Font.BOLD, 40));
            campoTextoAltC.setText(altC);
            campoTextoAltC.setEditable(false);
            campoTextoAltC.setFocusable(false);
            painelConteudo.add(campoTextoAltC);
            
            campoTextoAltD = new JTextField();
            campoTextoAltD.setBorder(null);
            campoTextoAltD.setOpaque(false);
            campoTextoAltD.setForeground(Color.BLACK);
            campoTextoAltD.setFont(new Font("Jockey One", Font.BOLD, 40));
            campoTextoAltD.setText(altD);
            campoTextoAltD.setEditable(false);
            campoTextoAltD.setFocusable(false);
            painelConteudo.add(campoTextoAltD);
            
            labelAltASelecionado = new JLabel
                (new ImageIcon(imagemAltASelecionado));
            labelAltASelecionado.setVisible(false);
            labelAltASelecionado.setBounds(0, 0,
                    imagemAltASelecionado.getWidth(), 
                    imagemAltASelecionado.getHeight());
            painelConteudo.add(labelAltASelecionado);
            
            labelAltBSelecionado = new JLabel
                (new ImageIcon(imagemAltBSelecionado));
            labelAltBSelecionado.setVisible(false);
            labelAltBSelecionado.setBounds(0, 0,
                    imagemAltBSelecionado.getWidth(), 
                    imagemAltBSelecionado.getHeight());
            painelConteudo.add(labelAltBSelecionado);
            
            labelAltCSelecionado = new JLabel
                (new ImageIcon(imagemAltCSelecionado));
            labelAltCSelecionado.setVisible(false);
            labelAltCSelecionado.setBounds(0, 0,
                    imagemAltCSelecionado.getWidth(), 
                    imagemAltCSelecionado.getHeight());
            painelConteudo.add(labelAltCSelecionado);
            
            labelAltDSelecionado = new JLabel
                (new ImageIcon(imagemAltDSelecionado));
            labelAltDSelecionado.setVisible(false);
            labelAltDSelecionado.setBounds(0, 0,
                    imagemAltDSelecionado.getWidth(), 
                    imagemAltDSelecionado.getHeight());
            painelConteudo.add(labelAltDSelecionado);
            
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }
        
        public JTextField getCampoPergunta() { return campoPergunta; }
        public JTextField getCampoTextoAltA() { return campoTextoAltA; }
        public JTextField getCampoTextoAltB() { return campoTextoAltB; }
        public JTextField getCampoTextoAltC() { return campoTextoAltC; }
        public JTextField getCampoTextoAltD() { return campoTextoAltD; }
        public JLabel getLabelAltASelecionado() { return labelAltASelecionado; }
        public JLabel getLabelAltBSelecionado() { return labelAltBSelecionado; }
        public JLabel getLabelAltCSelecionado() { return labelAltCSelecionado; }
        public JLabel getLabelAltDSelecionado() { return labelAltDSelecionado; }
        public String getAlternativaAtivada() { return alternativaAtivada; }
        public void setAlternativaAtivada(String alternativaAtivada) { this.alternativaAtivada = alternativaAtivada; }
        public JButton getBotaoSelecionado() { return botaoSelecionado; }
        public void setBotaoSelecionado(JButton botaoSelecionado) { this.botaoSelecionado = botaoSelecionado; }
        public JButton getRespostaCorreta() { return respostaCorreta; }
        
        private void SelecionarBotao(String alternativa) {
            alternativaAtivada = alternativa;
            switch (alternativa) {
                case "alternativa A":
                    if (botaoSelecionado != botaoAlternativaA) {
                        int x = botaoAlternativaA.getX() 
                                + (botaoAlternativaA.getWidth()
                                - imagemAltASelecionado.getWidth()) / 2;
                        
                        int y = botaoAlternativaA.getY() 
                                + (botaoAlternativaA.getHeight()
                                - imagemAltASelecionado.getHeight()) / 2;
                        labelAltASelecionado.setBounds(x, 
                                y,
                                imagemAltASelecionado.getWidth(), 
                                imagemAltASelecionado.getHeight());
                        
                        labelAltASelecionado.setVisible(true);
                        labelAltBSelecionado.setVisible(false);
                        labelAltCSelecionado.setVisible(false);
                        labelAltDSelecionado.setVisible(false);
                        labelAltASelecionado.repaint();
                        
                        botaoSelecionado = botaoAlternativaA;
                    }
                    break;
                case "alternativa B":
                    if (botaoSelecionado != botaoAlternativaB) {
                        int x = botaoAlternativaB.getX() 
                                + (botaoAlternativaB.getWidth()
                                - imagemAltBSelecionado.getWidth()) / 2;
                        
                        int y = botaoAlternativaB.getY() 
                                + (botaoAlternativaB.getHeight()
                                - imagemAltBSelecionado.getHeight()) / 2;
                        labelAltBSelecionado.setBounds(x, 
                                y,
                                imagemAltBSelecionado.getWidth(), 
                                imagemAltBSelecionado.getHeight());
                        
                        labelAltBSelecionado.setVisible(true);
                        labelAltASelecionado.setVisible(false);
                        labelAltCSelecionado.setVisible(false);
                        labelAltDSelecionado.setVisible(false);
                        labelAltBSelecionado.repaint();
                        
                        botaoSelecionado = botaoAlternativaB;
                    }
                    break;
                case "alternativa C":
                    if (botaoSelecionado != botaoAlternativaC) {
                        int x = botaoAlternativaC.getX() 
                                + (botaoAlternativaC.getWidth()
                                - imagemAltCSelecionado.getWidth()) / 2;
                        
                        int y = botaoAlternativaC.getY() 
                                + (botaoAlternativaC.getHeight()
                                - imagemAltCSelecionado.getHeight()) / 2;
                        labelAltCSelecionado.setBounds(x, 
                                y,
                                imagemAltCSelecionado.getWidth(), 
                                imagemAltCSelecionado.getHeight());
                        
                        labelAltCSelecionado.setVisible(true);
                        labelAltASelecionado.setVisible(false);
                        labelAltBSelecionado.setVisible(false);
                        labelAltDSelecionado.setVisible(false);
                        labelAltCSelecionado.repaint();
                        
                        botaoSelecionado = botaoAlternativaC;
                    }
                    break;
                case "alternativa D":
                    if (botaoSelecionado != botaoAlternativaD) {
                        int x = botaoAlternativaD.getX() 
                                + (botaoAlternativaD.getWidth()
                                - imagemAltDSelecionado.getWidth()) / 2;
                        
                        int y = botaoAlternativaD.getY() 
                                + (botaoAlternativaD.getHeight()
                                - imagemAltDSelecionado.getHeight()) / 2;
                        labelAltDSelecionado.setBounds(x, 
                                y,
                                imagemAltDSelecionado.getWidth(), 
                                imagemAltDSelecionado.getHeight());
                        
                        labelAltDSelecionado.setVisible(true);
                        labelAltASelecionado.setVisible(false);
                        labelAltBSelecionado.setVisible(false);
                        labelAltCSelecionado.setVisible(false);
                        labelAltDSelecionado.repaint();
                        
                        botaoSelecionado = botaoAlternativaD;
                    }
                    break;       
            }
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
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
            
            if (imagemFundoPergunta != null) {
                g2d.drawImage(imagemFundoPergunta, 
                        0, 0, getWidth(), getHeight(), this);
            }
        } 
    }

    public static class PanelAjuda extends JPanel {
        private BufferedImage imagemFundoAjuda;
        private BufferedImage imagemBotaoAjuda1;
        private BufferedImage imagemBotaoAjuda2;
        private BufferedImage imagemBotaoAjuda3;
        
        private JButton botaoAjuda1;
        private JButton botaoAjuda2;
        private JButton botaoAjuda3;
        
        private JDialog parentDialog;
        private PanelPergunta parentPanel;
        
        public PanelAjuda(JDialog parentDialog, PanelPergunta parentPanel) 
                throws IOException {
            this.parentDialog = parentDialog;
            this.parentPanel = parentPanel;
            setLayout(null);
            setOpaque(false);
            setBackground(new Color(0, 0, 0, 0));
            
            imagemFundoAjuda = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/telaAjuda.png"));
            
            imagemBotaoAjuda1 = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/elimineDuasRespostas.png"));
            
            imagemBotaoAjuda2 = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/duplaChance.png"));
            
            imagemBotaoAjuda3 = ImageIO.read(getClass().getResource
        ("/ImagensTelaPergunta/botaoFecharAjuda.png"));
            
            double escala = 1.0;
            int larguraFundoAjuda = (int)
                    (imagemFundoAjuda.getWidth() * 1 * escala);
            int alturaFundoAjuda = (int)
                    (imagemFundoAjuda.getHeight() * 1 * escala);
            
            setPreferredSize(new Dimension(larguraFundoAjuda, alturaFundoAjuda));
            
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
                    int centroY = h / 2;

                    int larguraBotAjuda1 = (int)
                            (imagemBotaoAjuda1.getWidth() * 0.2 * escala);
                    int alturaBotAjuda1 = (int)
                            (imagemBotaoAjuda1.getHeight() * 0.2 * escala);
                    
                    int larguraBotAjuda2 = (int)
                            (imagemBotaoAjuda2.getWidth() * 0.2 * escala);
                    int alturaBotAjuda2 = (int)
                            (imagemBotaoAjuda2.getHeight() * 0.2 * escala);
                    
                    int larguraBotAjuda3 = (int)
                            (imagemBotaoAjuda3.getWidth() * 0.15 * escala);
                    int alturaBotAjuda3 = (int)
                            (imagemBotaoAjuda3.getHeight() * 0.15 * escala);
                    
                    int xFundo = 0;
                    int yFundo = 0;
                    int xBotAjuda1 = centroX - (larguraBotAjuda1 / 2);
                    int yBotAjuda1 = centroY - (alturaBotAjuda1 / 2) - (int)(75 * escala);
                    
                    int xBotAjuda2 = centroX - (larguraBotAjuda2 / 2);
                    int yBotAjuda2 = centroY - (alturaBotAjuda2 / 2) - (int)(-100 * escala);
                    
                    int xBotAjuda3 = centroX - (larguraBotAjuda3 / 2) + 450;
                    int yBotAjuda3 = centroY - (alturaBotAjuda3 / 2) + (int)(-250 * escala);
                    
                    botaoAjuda1.setBounds(xBotAjuda1,
                            yBotAjuda1,
                            larguraBotAjuda1,
                            alturaBotAjuda1);
                    
                    botaoAjuda2.setBounds(xBotAjuda2,
                            yBotAjuda2, 
                            larguraBotAjuda2, 
                            alturaBotAjuda2);
                    
                    botaoAjuda3.setBounds(xBotAjuda3,
                            yBotAjuda3, 
                            larguraBotAjuda3, 
                            alturaBotAjuda3);
                    
                    g2d.drawImage(imagemFundoAjuda, xFundo, yFundo, larguraFundoAjuda, alturaFundoAjuda, this);
                    g2d.drawImage(imagemBotaoAjuda1, xBotAjuda1, yBotAjuda1, larguraBotAjuda1, alturaBotAjuda1, this);
                    g2d.drawImage(imagemBotaoAjuda2, xBotAjuda2, yBotAjuda2, larguraBotAjuda2, alturaBotAjuda2, this);
                    g2d.drawImage(imagemBotaoAjuda3, xBotAjuda3, yBotAjuda3, larguraBotAjuda3, alturaBotAjuda3, this);
                }
            };
            painelConteudo.setOpaque(false);
            painelConteudo.setBounds(0, 0, larguraFundoAjuda, alturaFundoAjuda);
            
            botaoAjuda1 = new JButton();
            botaoAjuda1.setBorderPainted(false);
            botaoAjuda1.setContentAreaFilled(false);
            botaoAjuda1.setFocusPainted(false);
            botaoAjuda1.setOpaque(false);
            botaoAjuda1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAjuda1.addActionListener(e -> {
                ArrayList<JButton> buttons = new ArrayList<>();
                buttons.add(botaoAlternativaA);
                buttons.add(botaoAlternativaB);
                buttons.add(botaoAlternativaC);
                buttons.add(botaoAlternativaD);

                buttons.removeIf(button -> !button.isVisible());
                
                ArrayList<JComponent> textos = new ArrayList<>();
                textos.add(campoTextoAltA);
                textos.add(campoTextoAltB);
                textos.add(campoTextoAltC);
                textos.add(campoTextoAltD);

                if (parentPanel.respostaCorreta != null && buttons.contains
                        (parentPanel.respostaCorreta)) {
                    buttons.remove(parentPanel.respostaCorreta);
                }

                if (buttons.size() >= 2) {
                    java.util.Collections.shuffle(buttons, parentPanel.random);

                    for (int i = 0; i < 2; i++) {
                        JButton btn = buttons.get(i);
                        btn.setVisible(false);

                        int idx = -1;
                        if (btn == botaoAlternativaA) idx = 0;
                        else if (btn == botaoAlternativaB) idx = 1;
                        else if (btn == botaoAlternativaC) idx = 2;
                        else if (btn == botaoAlternativaD) idx = 3;

                        if (idx != -1) {
                            textos.get(idx).setVisible(false);

                        switch (idx) {
                            case 0: labelAltASelecionado.setVisible(false); 
                            break;
                            case 1: labelAltBSelecionado.setVisible(false);
                            break;
                            case 2: labelAltCSelecionado.setVisible(false); 
                            break;
                            case 3: labelAltDSelecionado.setVisible(false); 
                            break;
                        }
                        }
                    }
                    parentPanel.repaint();
                } else {
                    JOptionPane.showMessageDialog(parentDialog, 
                        "Não há alternativas suficientes para eliminar!", 
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                }

                parentDialog.dispose();
            });
            painelConteudo.add(botaoAjuda1);
            
            botaoAjuda2 = new JButton();
            botaoAjuda2.setBorderPainted(false);
            botaoAjuda2.setContentAreaFilled(false);
            botaoAjuda2.setFocusPainted(false);
            botaoAjuda2.setOpaque(false);
            botaoAjuda2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAjuda2.addActionListener(e -> {
                if (parentPanel.isDuplaChanceUsada()) {
                JOptionPane.showMessageDialog(parentDialog, 
                    "A dupla chance já foi utilizada nesta questão!", 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    TelaPergunta.botaoAlternativaA.setVisible(true);
                    TelaPergunta.botaoAlternativaB.setVisible(true);
                    TelaPergunta.botaoAlternativaC.setVisible(true);
                    TelaPergunta.botaoAlternativaD.setVisible(true);
                    parentPanel.getCampoTextoAltA().setVisible(true);
                    parentPanel.getCampoTextoAltB().setVisible(true);
                    parentPanel.getCampoTextoAltC().setVisible(true);
                    parentPanel.getCampoTextoAltD().setVisible(true);
                    parentPanel.getLabelAltASelecionado().setVisible(false);
                    parentPanel.getLabelAltBSelecionado().setVisible(false);
                    parentPanel.getLabelAltCSelecionado().setVisible(false);
                    parentPanel.getLabelAltDSelecionado().setVisible(false);
                    parentPanel.setAlternativaAtivada(null);
                    parentPanel.setBotaoSelecionado(null);

                    parentPanel.setDuplaChanceUsada(true);

                    parentPanel.repaint();
                }
                parentDialog.dispose();
            });
            painelConteudo.add(botaoAjuda2);
            
            botaoAjuda3 = new JButton();
            botaoAjuda3.setBorderPainted(false);
            botaoAjuda3.setContentAreaFilled(false);
            botaoAjuda3.setFocusPainted(false);
            botaoAjuda3.setOpaque(false);
            botaoAjuda3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoAjuda3.addActionListener(e -> {
                parentDialog.dispose();
            });
            painelConteudo.add(botaoAjuda3);
            
            add(painelConteudo);
        }
    }
}