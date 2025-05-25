/*----------------------Pacote que pertence a classe--------------------------*/
package TelasCriacaoSala;

/*-----------------Bibliotecas e Classes que serão utilizadas-----------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;

/*-----------------------Criação da Classe e variáveis------------------------*/
public class TelaMateriasPersonalizado extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelMateriaPersonalizado;
    

    public TelaMateriasPersonalizado() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelMateriaPersonalizado = new JPanel(cardLayout);

        try {
            PanelMateriaPersonalizada panelMateriaPersonalizada = 
                    new PanelMateriaPersonalizada();
            
            painelMateriaPersonalizado.add(panelMateriaPersonalizada, 
                    "TelaMateriasPersonalizado");
            
            add(panelMateriaPersonalizada);

        } 
        catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaMateriasPersonalizado tela = new TelaMateriasPersonalizado();
            tela.setVisible(true);
        });
    }
    
    public static class PanelMateriaPersonalizada extends JPanel {

        private BufferedImage imagemDeFundoMaterias;
        private BufferedImage imagemBotaoGeografia;
        private BufferedImage imagemBotaoHistoria;
        private BufferedImage imagemBotaoIngles;
        private BufferedImage imagemBotaoQuimica;
        private BufferedImage imagemBotaoPortugues;
        private BufferedImage imagemBotaoMatematica;
        private BufferedImage imagemBotaoFisica;
        private BufferedImage imagemBotaoBiologia;
        private BufferedImage imagemBotaoSelecionar;
        
        private JButton botaoGeografiaMP;
        private JButton botaoHistoriaMP;
        private JButton botaoInglesMP;
        private JButton botaoQuimicaMP;
        private JButton botaoPortuguesMP;
        private JButton botaoMatematicaMP;
        private JButton botaoFisicaMP;
        private JButton botaoBiologiaMP;
        private JButton botaoSelecionarMP;

        public PanelMateriaPersonalizada() throws IOException {
            setLayout(new GridBagLayout());
            
            imagemDeFundoMaterias = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/telaMateriaPersonalizada.png"));
            
            imagemBotaoGeografia = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoGeografiaMP.png"));
            
            imagemBotaoHistoria = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoHistoriaMP.png"));
            
            imagemBotaoIngles = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoInglesMP.png"));
            
            imagemBotaoQuimica = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoQuimicaMP.png"));
            
            imagemBotaoPortugues = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoPortuguesMP.png"));
            
            imagemBotaoMatematica = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoMatematicaMP.png"));
            
            imagemBotaoFisica = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoFisicaMP.png"));
            
            imagemBotaoBiologia = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoBiologiaMP.png"));
            
            imagemBotaoSelecionar = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoSelecionarMP.png"));
            
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
                    
                    int larguraBotGeo = (int) 
                            (imagemBotaoGeografia.getWidth() * 0.7 * escala);
                    int alturaBotGeo = (int) 
                            (imagemBotaoGeografia.getHeight() * 0.7 * escala);
                    
                    int larguraBotHist = (int) 
                            (imagemBotaoHistoria.getWidth() * 0.7 * escala);
                    int alturaBotHist = (int) 
                            (imagemBotaoHistoria.getHeight() * 0.7 * escala);
                    
                    int larguraBotIng = (int) 
                            (imagemBotaoIngles.getWidth() * 0.7 * escala);
                    int alturaBotIng = (int) 
                            (imagemBotaoIngles.getHeight() * 0.7 * escala);
                    
                    int larguraBotQuim = (int) 
                            (imagemBotaoQuimica.getWidth() * 0.7 * escala);
                    int alturaBotQuim = (int) 
                            (imagemBotaoQuimica.getHeight() * 0.7 * escala);
                    
                    int larguraBotPort = (int) 
                            (imagemBotaoPortugues.getWidth() * 0.7 * escala);
                    int alturaBotPort = (int) 
                            (imagemBotaoPortugues.getHeight() * 0.7 * escala);
                    
                    int larguraBotMat = (int) 
                            (imagemBotaoMatematica.getWidth() * 0.7 * escala);
                    int alturaBotMat = (int) 
                            (imagemBotaoMatematica.getHeight() * 0.7 * escala);
                    
                    int larguraBotFis = (int) 
                            (imagemBotaoFisica.getWidth() * 0.7 * escala);
                    int alturaBotFis = (int) 
                            (imagemBotaoFisica.getHeight() * 0.7 * escala);
                    
                    int larguraBotBio = (int) 
                            (imagemBotaoBiologia.getWidth() * 0.7 * escala);
                    int alturaBotBio = (int) 
                            (imagemBotaoBiologia.getHeight() * 0.7 * escala);
                    
                    int larguraBotSel = (int) 
                            (imagemBotaoSelecionar.getWidth() * 0.7 * escala);
                    int alturaBotSel = (int) 
                            (imagemBotaoSelecionar.getHeight() * 0.7 * escala);
                    
/*--------------------Posicionamento dos elementos na tela--------------------*/

                    int xBGeo = centroX - (larguraBotGeo / 2) - 280;
                    int yBGeo = (int) (h * 0.45) - 150;
                    
                    int xBHist = centroX - (larguraBotHist / 2) - 280;
                    int yBHist = yBGeo + alturaBotGeo + (int)(3 * escala);
                    
                    int xBIng = centroX - (larguraBotIng / 2) - 280;
                    int yBIng = yBHist + alturaBotHist + (int)(3 * escala);
                    
                    int xBQuim = centroX - (larguraBotQuim / 2) - 280;
                    int yBQuim = yBIng + alturaBotIng + (int)(3 * escala);
                    
                    int xBPort = centroX - (larguraBotPort / 2) + 260;
                    int yBPort = (int) (h * 0.45) - 150;
                    
                    int xBMat = centroX - (larguraBotMat / 2) + 260;
                    int yBMat = yBPort + alturaBotPort + (int)(3 * escala);
                    
                    int xBFis = centroX - (larguraBotFis / 2) + 260;
                    int yBFis = yBMat + alturaBotMat + (int)(3 * escala);
                    
                    int xBBio = centroX - (larguraBotBio / 2) + 260;
                    int yBBio = yBFis + alturaBotFis + (int)(3 * escala);
                    
                    int xBSel = centroX - (larguraBotSel / 2) - 30;
                    int yBSel = (int) (h * 0.45) + 330;

/*-------------------Criação dos elementos com base na posição----------------*/

                    botaoSelecionarMP.setBounds(xBSel, 
                            yBSel, 
                            larguraBotSel, 
                            alturaBotSel);

                    botaoGeografiaMP.setBounds(xBGeo, 
                            yBGeo, 
                            larguraBotGeo, 
                            alturaBotGeo);
                    
                    botaoHistoriaMP.setBounds(xBHist, 
                            yBHist, 
                            larguraBotHist, 
                            alturaBotHist);
                    
                    botaoInglesMP.setBounds(xBIng, 
                            yBIng, 
                            larguraBotIng, 
                            alturaBotIng);
                    
                    botaoQuimicaMP.setBounds(xBQuim, 
                            yBQuim, 
                            larguraBotQuim, 
                            alturaBotQuim);
                    
                    botaoPortuguesMP.setBounds(xBPort, 
                            yBPort, 
                            larguraBotPort, 
                            alturaBotPort);
                    
                    botaoMatematicaMP.setBounds(xBMat, 
                            yBMat, 
                            larguraBotMat, 
                            alturaBotMat);
                    
                    botaoFisicaMP.setBounds(xBFis, 
                            yBFis, 
                            larguraBotFis, 
                            alturaBotFis);
                    
                    botaoBiologiaMP.setBounds(xBBio, 
                            yBBio, 
                            larguraBotBio, 
                            alturaBotBio);


/*---------------------------Desenhando Imagens na tela-----------------------*/

                    g2d.drawImage(imagemBotaoGeografia, 
                            xBGeo, 
                            yBGeo, 
                            larguraBotGeo, 
                            alturaBotGeo, this);
                    
                    g2d.drawImage(imagemBotaoHistoria, 
                            xBHist, 
                            yBHist, 
                            larguraBotHist, 
                            alturaBotHist, this);
                    
                    g2d.drawImage(imagemBotaoIngles, 
                            xBIng, 
                            yBIng, 
                            larguraBotIng, 
                            alturaBotIng, this);
                    
                    g2d.drawImage(imagemBotaoQuimica, 
                            xBQuim, 
                            yBQuim, 
                            larguraBotQuim, 
                            alturaBotQuim, this);
                    
                    g2d.drawImage(imagemBotaoPortugues, 
                            xBPort, 
                            yBPort, 
                            larguraBotPort, 
                            alturaBotPort, this);
                    
                    g2d.drawImage(imagemBotaoMatematica, 
                            xBMat, 
                            yBMat, 
                            larguraBotMat, 
                            alturaBotMat, this);
                    
                    g2d.drawImage(imagemBotaoFisica, 
                            xBFis, 
                            yBFis, 
                            larguraBotFis, 
                            alturaBotFis, this);
                    
                    g2d.drawImage(imagemBotaoBiologia, 
                            xBBio, 
                            yBBio, 
                            larguraBotBio, 
                            alturaBotBio, this);
                    
                    g2d.drawImage(imagemBotaoSelecionar, 
                            xBSel, 
                            yBSel, 
                            larguraBotSel, 
                            alturaBotSel, this);

                }
            };
            painelConteudo.setOpaque(false);
            
            botaoGeografiaMP = new JButton();
            botaoGeografiaMP.setBorderPainted(false);
            botaoGeografiaMP.setContentAreaFilled(false);
            botaoGeografiaMP.setFocusPainted(false);
            botaoGeografiaMP.setOpaque(false);
            botaoGeografiaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoGeografiaMP);
            
            botaoHistoriaMP = new JButton();
            botaoHistoriaMP.setBorderPainted(false);
            botaoHistoriaMP.setContentAreaFilled(false);
            botaoHistoriaMP.setFocusPainted(false);
            botaoHistoriaMP.setOpaque(false);
            botaoHistoriaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoHistoriaMP);
            
            botaoInglesMP = new JButton();
            botaoInglesMP.setBorderPainted(false);
            botaoInglesMP.setContentAreaFilled(false);
            botaoInglesMP.setFocusPainted(false);
            botaoInglesMP.setOpaque(false);
            botaoInglesMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoInglesMP);
            
            botaoQuimicaMP = new JButton();
            botaoQuimicaMP.setBorderPainted(false);
            botaoQuimicaMP.setContentAreaFilled(false);
            botaoQuimicaMP.setFocusPainted(false);
            botaoQuimicaMP.setOpaque(false);
            botaoQuimicaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoQuimicaMP);
            
            botaoPortuguesMP = new JButton();
            botaoPortuguesMP.setBorderPainted(false);
            botaoPortuguesMP.setContentAreaFilled(false);
            botaoPortuguesMP.setFocusPainted(false);
            botaoPortuguesMP.setOpaque(false);
            botaoPortuguesMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoPortuguesMP);
            
            botaoMatematicaMP = new JButton();
            botaoMatematicaMP.setBorderPainted(false);
            botaoMatematicaMP.setContentAreaFilled(false);
            botaoMatematicaMP.setFocusPainted(false);
            botaoMatematicaMP.setOpaque(false);
            botaoMatematicaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoMatematicaMP);
            
            botaoFisicaMP = new JButton();
            botaoFisicaMP.setBorderPainted(false);
            botaoFisicaMP.setContentAreaFilled(false);
            botaoFisicaMP.setFocusPainted(false);
            botaoFisicaMP.setOpaque(false);
            botaoFisicaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoFisicaMP);
            
            botaoBiologiaMP = new JButton();
            botaoBiologiaMP.setBorderPainted(false);
            botaoBiologiaMP.setContentAreaFilled(false);
            botaoBiologiaMP.setFocusPainted(false);
            botaoBiologiaMP.setOpaque(false);
            botaoBiologiaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoBiologiaMP);
            
            botaoSelecionarMP = new JButton();
            botaoSelecionarMP.setBorderPainted(false);
            botaoSelecionarMP.setContentAreaFilled(false);
            botaoSelecionarMP.setFocusPainted(false);
            botaoSelecionarMP.setOpaque(false);
            botaoSelecionarMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoSelecionarMP);
            
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

/*-------------Melhor qualidade de renderização da imagem de fundo------------*/
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

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

/*------------Verificação da existência da imagem antes de desenhar-----------*/

            if (imagemDeFundoMaterias != null) {
                g2d.drawImage(imagemDeFundoMaterias, 0, 0, w, h, this);
            }
        }
    }
}
