package com.mycompany.telaspoligenio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaRankAluno extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelPrincipal;

    public TelaRankAluno() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        try {
            PanelRankAluno panelRank = new PanelRankAluno();
            painelPrincipal.add(panelRank, "TelaRankAluno");
            add(painelPrincipal);
            cardLayout.show(painelPrincipal, "TelaRankAluno");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaRankAluno().setVisible(true));
    }

    public static class PanelRankAluno extends JPanel {

        private BufferedImage imagemFundoTelaRank;
        private BufferedImage imagemBotaoRetornar;
        
        private JButton botaoRetornar;

        public PanelRankAluno() throws IOException {
            setLayout(new GridBagLayout());
 
            imagemFundoTelaRank = ImageIO.read(getClass().getResource("/ImagensTelaRankAluno/telaRankAluno.jpg"));
            imagemBotaoRetornar = ImageIO.read(getClass().getResource("/ImagensTelaRankAluno/botaoRetonarRankAluno.png")); // Coloque sua imagem aqui

            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    
                    // Configurações de qualidade
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    
                    int w = getWidth();
                    int h = getHeight();

                    // Centro da tela
                    int centroX = w / 2;

                    // Dimensões dos elementos
                    double escala = 1.0; // Defina a escala conforme necessário
                    int larguraBotaoRetornar = (int) (imagemBotaoRetornar.getWidth() * 0.7 * escala);
                    int alturaBotaoRetornar = (int) (imagemBotaoRetornar.getHeight() * 0.7 * escala);
                    
                    int xRetornar = centroX - (larguraBotaoRetornar / 2) + 550;
                    int yRetornar = (int) (h * 0.45) + 450; // 45% da altura da tela

                    // Atualiza posição do botão
                    botaoRetornar.setBounds(xRetornar, yRetornar, larguraBotaoRetornar, alturaBotaoRetornar);
                    
                    // Desenha a imagem do botão
                    g2d.drawImage(imagemBotaoRetornar, 
                            xRetornar, 
                            yRetornar, 
                            larguraBotaoRetornar, 
                            alturaBotaoRetornar, this);
                }
            };
            painelConteudo.setOpaque(false);

            // Configuração do botão
            botaoRetornar = new JButton();
            botaoRetornar.setContentAreaFilled(false);
            botaoRetornar.setBorderPainted(false);
            botaoRetornar.setFocusPainted(false);
            botaoRetornar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoRetornar);

            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagemFundoTelaRank != null) {
                g.drawImage(imagemFundoTelaRank, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}