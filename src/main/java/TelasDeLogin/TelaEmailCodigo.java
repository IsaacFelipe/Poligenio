package TelasDeLogin;

import CodigoPoligenio.Sistema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;

public class TelaEmailCodigo extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelEmailCodigo;
    private static String destinatario;

    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }

    public TelaEmailCodigo(String destinatario) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        painelEmailCodigo = new JPanel(cardLayout);
        Sistema sistema = Sistema.getInstance();
        this.destinatario = destinatario;

       try {

        PanelEmailCodigo telaEmailCodigoPanel = new PanelEmailCodigo(painelEmailCodigo, sistema);
        painelEmailCodigo.add(telaEmailCodigoPanel, "TelaEmailCodigo");
        add(painelEmailCodigo);
        cardLayout.show(painelEmailCodigo, "TelaEmailCodigo");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaEmailCodigo telaCodigo = new TelaEmailCodigo(destinatario);
            telaCodigo.setVisible(true);
        });
    }

    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelEmailCodigo, nomeTela);
    }

    public static class PanelEmailCodigo extends JPanel {

        private BufferedImage imagemDeFundoEmailCodigo;
        private BufferedImage imagemInputEmailCodigo;
        private BufferedImage imagemBotaoEnviarEmail;
        private BufferedImage imagemBotaoVoltarEmail;

        private JTextField campoTextoEmailCodigo;
        private JButton botaoValidarCodigo;
        private JButton botaoVoltarEmail;

        private final JPanel container;
        private final Sistema sistema;
        
        public PanelEmailCodigo(JPanel container, Sistema sistema) throws IOException {
            this.container = container;
            this.sistema = sistema;

            setLayout(new GridBagLayout());

            imagemDeFundoEmailCodigo = ImageIO.read(getClass().getResource("/ImagensTelaEmailCodigo/telaEmailCodigo.png"));
            imagemInputEmailCodigo = ImageIO.read(getClass().getResource("/ImagensTelaEmailCodigo/inputEmailCodigo.png"));
            imagemBotaoEnviarEmail = ImageIO.read(getClass().getResource("/ImagensTelaEmailCodigo/botaoEnviarEmail.png"));
            imagemBotaoVoltarEmail = ImageIO.read(getClass().getResource("/ImagensTelaEmailCodigo/botaoVoltarEmail.png"));

            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;

                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

                    int centroX = w / 2;

                    double escala = 1.0;

                    int larguraInputCodigo = (int) (imagemInputEmailCodigo.getWidth() * 0.7 * escala);
                    int alturaInputCodigo = (int) (imagemInputEmailCodigo.getHeight() * 0.7 * escala);
                    int larguraEnviarCodigo = (int) (imagemBotaoEnviarEmail.getWidth() * 0.7 * escala);
                    int alturaEnviarCodigo = (int) (imagemBotaoEnviarEmail.getHeight() * 0.7 * escala);
                    int larguraVoltarCodigo = (int) (imagemBotaoVoltarEmail.getWidth() * 0.7 * escala);
                    int alturaVoltarCodigo = (int) (imagemBotaoVoltarEmail.getHeight() * 0.7 * escala);

                    int xCodigo = centroX - (larguraInputCodigo / 2);
                    int yCodigo = (int) (h * 0.45) + 150;
                    int xEnviar = centroX - (larguraEnviarCodigo / 2);
                    int yEnviar = yCodigo + alturaInputCodigo + (int) (50 * escala);
                    int xVoltar = centroX - (larguraVoltarCodigo / 2);
                    int yVoltar = yEnviar + alturaEnviarCodigo + (int) (50 * escala);

                    botaoValidarCodigo.setBounds(xEnviar, yEnviar, larguraEnviarCodigo, alturaEnviarCodigo);
                    botaoVoltarEmail.setBounds(xVoltar, yVoltar, larguraVoltarCodigo, alturaVoltarCodigo);
                    campoTextoEmailCodigo.setBounds(
                            xCodigo + (int) (77 * escala) + 30,
                            yCodigo + (int) (27 * escala) - 22,
                            (int) (360 * escala),
                            (int) (50 * escala)
                    );

                    g2d.drawImage(imagemInputEmailCodigo, xCodigo, yCodigo, larguraInputCodigo, alturaInputCodigo, this);
                    g2d.drawImage(imagemBotaoEnviarEmail, xEnviar, yEnviar, larguraEnviarCodigo, alturaEnviarCodigo, this);
                    g2d.drawImage(imagemBotaoVoltarEmail, xVoltar, yVoltar, larguraVoltarCodigo, alturaVoltarCodigo, this);
                }
            };
            painelConteudo.setOpaque(false);

            botaoValidarCodigo = new JButton();
            botaoValidarCodigo.setBorderPainted(false);
            botaoValidarCodigo.setContentAreaFilled(false);
            botaoValidarCodigo.setFocusPainted(false);
            botaoValidarCodigo.setOpaque(false);
            botaoValidarCodigo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoValidarCodigo.addActionListener(e -> {
                String codigoDigitado = campoTextoEmailCodigo.getText().trim().toUpperCase();
                
                try {
                    boolean codigoValido = sistema.verificarCodigo(destinatario, codigoDigitado);

                    if (codigoValido) {
                        TelaNovaSenha tela = new TelaNovaSenha(destinatario);
                        tela.setVisible(true);
                        Window janela = SwingUtilities.getWindowAncestor(PanelEmailCodigo.this);
                            if (janela instanceof JFrame) {
                                janela.dispose();
                            }
                            
                        campoTextoEmailCodigo.setText("");
                    } else {
                        System.out.println("email: '" + destinatario + "'");
                        JOptionPane.showMessageDialog(this, "Código incorreto. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erro ao validar código: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });
            painelConteudo.add(botaoValidarCodigo);

            botaoVoltarEmail = new JButton();
            botaoVoltarEmail.setBorderPainted(false);
            botaoVoltarEmail.setContentAreaFilled(false);
            botaoVoltarEmail.setFocusPainted(false);
            botaoVoltarEmail.setOpaque(false);
            botaoVoltarEmail.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltarEmail.addActionListener(e -> {
                TelaInicial tela = new TelaInicial(destinatario, "", sistema);
                tela.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor(PanelEmailCodigo.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                    }
            });
            painelConteudo.add(botaoVoltarEmail);

            campoTextoEmailCodigo = new JTextField();
            campoTextoEmailCodigo.setBorder(null);
            campoTextoEmailCodigo.setOpaque(false);
            campoTextoEmailCodigo.setForeground(Color.BLACK);
            campoTextoEmailCodigo.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoEmailCodigo);

            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            if (imagemDeFundoEmailCodigo != null) {
                g2d.drawImage(imagemDeFundoEmailCodigo, 0, 0, w, h, this);
            }
        }
    }
}