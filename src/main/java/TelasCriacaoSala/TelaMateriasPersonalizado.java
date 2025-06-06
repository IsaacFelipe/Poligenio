/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package TelasCriacaoSala;

/*-----------------BIBLIOTECAS E CLASSES QUE SERÃO UTILIZADAS-----------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;

/*-----------------------CRIAÇÃO DA CLASSE E VARIÁVEIS------------------------*/
public class TelaMateriasPersonalizado extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelMateriaPersonalizado;
    private static String textoNomeQuiz;
    private static String idProfessor;
    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
    }

    public TelaMateriasPersonalizado(String textoNomeQuiz,String idProfessor) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.textoNomeQuiz = textoNomeQuiz;
        this.idProfessor = idProfessor;

        cardLayout = new CardLayout();
        painelMateriaPersonalizado = new JPanel(cardLayout);

        try {
            PanelMateriaPersonalizada panelMateriaPersonalizada = 
                    new PanelMateriaPersonalizada();
            
            painelMateriaPersonalizado.add(panelMateriaPersonalizada, 
                    "TelaMateriasPersonalizado");
            
            add(painelMateriaPersonalizado);

        } 
        catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " 
                    + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaMateriasPersonalizado tela = 
                    new TelaMateriasPersonalizado(textoNomeQuiz, idProfessor);
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
        
        private BufferedImage imagemGeografiaSelecionado;
        private BufferedImage imagemHistoriaSelecionado;
        private BufferedImage imagemMatematicaSelecionado;
        private BufferedImage imagemInglesSelecionado;
        private BufferedImage imagemPortuguesSelecionado;
        private BufferedImage imagemFisicaSelecionado;
        private BufferedImage imagemQuimicaSelecionado;
        private BufferedImage imagemBiologiaSelecionado;
        
        private JLabel labelGeografiaSelecionado;
        private JLabel labelHistoriaSelecionado;
        private JLabel labelMatematicaSelecionado;
        private JLabel labelInglesSelecionado;
        private JLabel labelPortuguesSelecionado;
        private JLabel labelFisicaSelecionado;
        private JLabel labelQuimicaSelecionado;
        private JLabel labelBiologiaSelecionado;
        
        private String materiaAtivada = null;
        private JButton botaoSelecionado = null;
        
        private JButton botaoGeografiaMP;
        private JButton botaoHistoriaMP;
        private JButton botaoInglesMP;
        private JButton botaoQuimicaMP;
        private JButton botaoPortuguesMP;
        private JButton botaoMatematicaMP;
        private JButton botaoFisicaMP;
        private JButton botaoBiologiaMP;
        private JButton botaoSelecionarMP;
        
        private String materiaSelecionada;
        private boolean materias = false;
        private String idMateria;

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
            
            imagemGeografiaSelecionado = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoGeografiaSelect.png"));
            
            imagemHistoriaSelecionado = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoHistoriaSelect.png"));
            
            imagemMatematicaSelecionado = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoMatematicaSelect.png"));
            
            imagemInglesSelecionado = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoInglesSelect.png"));
            
            imagemPortuguesSelecionado = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoPortuguesSelect.png"));
            
            imagemFisicaSelecionado = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoFisicaSelect.png"));
            
            imagemQuimicaSelecionado = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoQuimicaSelect.png"));
            
            imagemBiologiaSelecionado = ImageIO.read(getClass().getResource
            ("/ImagensTelaMateriasPersonalizado/botaoBiologiaSelect.png"));  
            
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
/*-------------------------DIMENSÃO DOS ELEMENTOS NA TELA---------------------*/

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
                    
/*--------------------POSICIONAMENTO DOS ELEMENTOS NA TELA--------------------*/

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
                    int yBSel = (int) (h * 0.45) + 375;

/*-------------------CRIAÇÃO DOS ELEMENTOS COM BASE NA POSIÇÃO----------------*/

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


/*---------------------------DESENHANDO IMAGENS NA TELA-----------------------*/

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
            
            labelGeografiaSelecionado = new JLabel
                (new ImageIcon(imagemGeografiaSelecionado));
            labelGeografiaSelecionado.setVisible(false);
            labelGeografiaSelecionado.setBounds(0, 0,
                    imagemGeografiaSelecionado.getWidth(), 
                    imagemGeografiaSelecionado.getHeight());
            painelConteudo.add(labelGeografiaSelecionado);
            
            labelHistoriaSelecionado = new JLabel
                (new ImageIcon(imagemHistoriaSelecionado));
            labelHistoriaSelecionado.setVisible(false);
            labelHistoriaSelecionado.setBounds(0, 0,
                    imagemHistoriaSelecionado.getWidth(), 
                    imagemHistoriaSelecionado.getHeight());
            painelConteudo.add(labelHistoriaSelecionado);
            
            labelMatematicaSelecionado = new JLabel
                (new ImageIcon(imagemMatematicaSelecionado));
            labelMatematicaSelecionado.setVisible(false);
            labelMatematicaSelecionado.setBounds(0, 0,
                    imagemMatematicaSelecionado.getWidth(), 
                    imagemMatematicaSelecionado.getHeight());
            painelConteudo.add(labelMatematicaSelecionado);
            
            labelInglesSelecionado = new JLabel
                (new ImageIcon(imagemInglesSelecionado));
            labelInglesSelecionado.setVisible(false);
            labelInglesSelecionado.setBounds(0, 0,
                    imagemInglesSelecionado.getWidth(), 
                    imagemInglesSelecionado.getHeight());
            painelConteudo.add(labelInglesSelecionado);
            
            labelPortuguesSelecionado = new JLabel
                (new ImageIcon(imagemPortuguesSelecionado));
            labelPortuguesSelecionado.setVisible(false);
            labelPortuguesSelecionado.setBounds(0, 0,
                    imagemPortuguesSelecionado.getWidth(), 
                    imagemPortuguesSelecionado.getHeight());
            painelConteudo.add(labelPortuguesSelecionado);
            
            labelFisicaSelecionado = new JLabel
                (new ImageIcon(imagemFisicaSelecionado));
            labelFisicaSelecionado.setVisible(false);
            labelFisicaSelecionado.setBounds(0, 0,
                    imagemFisicaSelecionado.getWidth(), 
                    imagemFisicaSelecionado.getHeight());
            painelConteudo.add(labelFisicaSelecionado);
            
            labelQuimicaSelecionado = new JLabel
                (new ImageIcon(imagemQuimicaSelecionado));
            labelQuimicaSelecionado.setVisible(false);
            labelQuimicaSelecionado.setBounds(0, 0,
                    imagemQuimicaSelecionado.getWidth(), 
                    imagemQuimicaSelecionado.getHeight());
            painelConteudo.add(labelQuimicaSelecionado);
            
            labelBiologiaSelecionado = new JLabel
                (new ImageIcon(imagemBiologiaSelecionado));
            labelBiologiaSelecionado.setVisible(false);
            labelBiologiaSelecionado.setBounds(0, 0,
                    imagemBiologiaSelecionado.getWidth(), 
                    imagemBiologiaSelecionado.getHeight());
            painelConteudo.add(labelBiologiaSelecionado);
            
            botaoGeografiaMP = new JButton();
            botaoGeografiaMP.setBorderPainted(false);
            botaoGeografiaMP.setContentAreaFilled(false);
            botaoGeografiaMP.setFocusPainted(false);
            botaoGeografiaMP.setOpaque(false);
            botaoGeografiaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoGeografiaMP.addActionListener(e -> {
                materiaSelecionada = "Geografia";
                SelecionarBotao("geografia");
                idMateria = "7";
            });
            painelConteudo.add(botaoGeografiaMP);
            
            botaoHistoriaMP = new JButton();
            botaoHistoriaMP.setBorderPainted(false);
            botaoHistoriaMP.setContentAreaFilled(false);
            botaoHistoriaMP.setFocusPainted(false);
            botaoHistoriaMP.setOpaque(false);
            botaoHistoriaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoHistoriaMP.addActionListener(e -> {
                materiaSelecionada = "História";
                SelecionarBotao("história");
                idMateria = "6";
            });
            painelConteudo.add(botaoHistoriaMP);
            
            botaoInglesMP = new JButton();
            botaoInglesMP.setBorderPainted(false);
            botaoInglesMP.setContentAreaFilled(false);
            botaoInglesMP.setFocusPainted(false);
            botaoInglesMP.setOpaque(false);
            botaoInglesMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoInglesMP.addActionListener(e -> {
                materiaSelecionada = "Inglês";
                SelecionarBotao("inglês");
                idMateria = "5";
            });
            painelConteudo.add(botaoInglesMP);
            
            botaoQuimicaMP = new JButton();
            botaoQuimicaMP.setBorderPainted(false);
            botaoQuimicaMP.setContentAreaFilled(false);
            botaoQuimicaMP.setFocusPainted(false);
            botaoQuimicaMP.setOpaque(false);
            botaoQuimicaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoQuimicaMP.addActionListener(e -> {
                materiaSelecionada = "Química";
                SelecionarBotao("química");
                idMateria = "8";
            });
            painelConteudo.add(botaoQuimicaMP);
            
            botaoPortuguesMP = new JButton();
            botaoPortuguesMP.setBorderPainted(false);
            botaoPortuguesMP.setContentAreaFilled(false);
            botaoPortuguesMP.setFocusPainted(false);
            botaoPortuguesMP.setOpaque(false);
            botaoPortuguesMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoPortuguesMP.addActionListener(e -> {
                materiaSelecionada = "Português";
                SelecionarBotao("português");
                idMateria = "1";
            });
            painelConteudo.add(botaoPortuguesMP);
            
            botaoMatematicaMP = new JButton();
            botaoMatematicaMP.setBorderPainted(false);
            botaoMatematicaMP.setContentAreaFilled(false);
            botaoMatematicaMP.setFocusPainted(false);
            botaoMatematicaMP.setOpaque(false);
            botaoMatematicaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoMatematicaMP.addActionListener(e -> {
                materiaSelecionada = "Matemática";
                SelecionarBotao("matemática");
                idMateria = "2";
            });
            painelConteudo.add(botaoMatematicaMP);
            
            botaoFisicaMP = new JButton();
            botaoFisicaMP.setBorderPainted(false);
            botaoFisicaMP.setContentAreaFilled(false);
            botaoFisicaMP.setFocusPainted(false);
            botaoFisicaMP.setOpaque(false);
            botaoFisicaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoFisicaMP.addActionListener(e -> {
                materiaSelecionada = "Física";
                SelecionarBotao("física");
                idMateria = "4";
            });
            painelConteudo.add(botaoFisicaMP);
            
            botaoBiologiaMP = new JButton();
            botaoBiologiaMP.setBorderPainted(false);
            botaoBiologiaMP.setContentAreaFilled(false);
            botaoBiologiaMP.setFocusPainted(false);
            botaoBiologiaMP.setOpaque(false);
            botaoBiologiaMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoBiologiaMP.addActionListener(e -> {
                materiaSelecionada = "Biologia";
                SelecionarBotao("biologia");
                idMateria = "3";
            });
            painelConteudo.add(botaoBiologiaMP);
            
            botaoSelecionarMP = new JButton();
            botaoSelecionarMP.setBorderPainted(false);
            botaoSelecionarMP.setContentAreaFilled(false);
            botaoSelecionarMP.setFocusPainted(false);
            botaoSelecionarMP.setOpaque(false);
            botaoSelecionarMP.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoSelecionarMP.addActionListener(e -> {
                if (materiaSelecionada == null){
                    JOptionPane.showMessageDialog(this, "Por favor, selecione "
                            + "uma matéria antes de continuar.");
                }
                
                TelaQuestPersonalizado materias = 
                        new TelaQuestPersonalizado(textoNomeQuiz, 
                                idProfessor, 
                                idMateria);
                
                materias.setMateriaSelecionada(materiaSelecionada);
                materias.setVisible(true);
                Window janela = SwingUtilities.getWindowAncestor
                                (PanelMateriaPersonalizada.this);
                    if (janela instanceof JFrame) {
                        janela.dispose();
                }    
                
            });
            painelConteudo.add(botaoSelecionarMP);
            
            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }
        
        private void SelecionarBotao(String tipo) {
            materiaAtivada = tipo;
            switch (tipo) {
                case "geografia":
                    if (botaoSelecionado != botaoGeografiaMP) {
                        int x = botaoGeografiaMP.getX() 
                                + (botaoGeografiaMP.getWidth()
                                - imagemGeografiaSelecionado.getWidth()) / 2;
                        
                        int y = botaoGeografiaMP.getY() 
                                + (botaoGeografiaMP.getHeight()
                                - imagemGeografiaSelecionado.getHeight()) / 2;
                        labelGeografiaSelecionado.setBounds(x, 
                                y,
                                imagemGeografiaSelecionado.getWidth(), 
                                imagemGeografiaSelecionado.getHeight());
                        
                        labelGeografiaSelecionado.setVisible(true);
                        labelHistoriaSelecionado.setVisible(false);
                        labelMatematicaSelecionado.setVisible(false);
                        labelInglesSelecionado.setVisible(false);
                        labelPortuguesSelecionado.setVisible(false);
                        labelFisicaSelecionado.setVisible(false);
                        labelQuimicaSelecionado.setVisible(false);
                        labelBiologiaSelecionado.setVisible(false);
                        labelGeografiaSelecionado.repaint();
                        
                        botaoSelecionado = botaoGeografiaMP;
                    }
                    break;
                    
                case "história":
                    if (botaoSelecionado != botaoHistoriaMP) {
                        int x = botaoHistoriaMP.getX() 
                                + (botaoHistoriaMP.getWidth()
                                - imagemHistoriaSelecionado.getWidth()) / 2;
                        
                        int y = botaoHistoriaMP.getY() 
                                + (botaoHistoriaMP.getHeight()
                                - imagemHistoriaSelecionado.getHeight()) / 2;
                        
                        labelHistoriaSelecionado.setBounds(x, 
                                y,
                                imagemHistoriaSelecionado.getWidth(), 
                                imagemHistoriaSelecionado.getHeight());
                        
                        labelHistoriaSelecionado.setVisible(true);
                        labelGeografiaSelecionado.setVisible(false);
                        labelMatematicaSelecionado.setVisible(false);
                        labelInglesSelecionado.setVisible(false);
                        labelPortuguesSelecionado.setVisible(false);
                        labelFisicaSelecionado.setVisible(false);
                        labelQuimicaSelecionado.setVisible(false);
                        labelBiologiaSelecionado.setVisible(false);
                        labelHistoriaSelecionado.repaint();
                        
                        botaoSelecionado = botaoHistoriaMP;
                    }
                    break;
                
                case "matemática":
                    if (botaoSelecionado != botaoMatematicaMP) {
                        int x = botaoMatematicaMP.getX() 
                                + (botaoMatematicaMP.getWidth()
                                - imagemHistoriaSelecionado.getWidth()) / 2;
                        
                        int y = botaoMatematicaMP.getY() 
                                + (botaoMatematicaMP.getHeight()
                                - imagemHistoriaSelecionado.getHeight()) / 2;
                        
                        labelMatematicaSelecionado.setBounds(x, 
                                y,
                                imagemHistoriaSelecionado.getWidth(), 
                                imagemHistoriaSelecionado.getHeight());
                        
                        labelMatematicaSelecionado.setVisible(true);
                        labelGeografiaSelecionado.setVisible(false);
                        labelHistoriaSelecionado.setVisible(false);
                        labelInglesSelecionado.setVisible(false);
                        labelPortuguesSelecionado.setVisible(false);
                        labelFisicaSelecionado.setVisible(false);
                        labelQuimicaSelecionado.setVisible(false);
                        labelBiologiaSelecionado.setVisible(false);
                        labelMatematicaSelecionado.repaint();
                        
                        botaoSelecionado = botaoMatematicaMP;
                    }
                    break;
                    
                case "inglês":
                    if (botaoSelecionado != botaoInglesMP) {
                        int x = botaoInglesMP.getX() 
                                + (botaoInglesMP.getWidth()
                                - imagemInglesSelecionado.getWidth()) / 2;
                        
                        int y = botaoInglesMP.getY() 
                                + (botaoInglesMP.getHeight()
                                - imagemInglesSelecionado.getHeight()) / 2;
                        
                        labelInglesSelecionado.setBounds(x, 
                                y,
                                imagemInglesSelecionado.getWidth(), 
                                imagemInglesSelecionado.getHeight());
                        
                        labelInglesSelecionado.setVisible(true);
                        labelGeografiaSelecionado.setVisible(false);
                        labelHistoriaSelecionado.setVisible(false);
                        labelMatematicaSelecionado.setVisible(false);
                        labelPortuguesSelecionado.setVisible(false);
                        labelFisicaSelecionado.setVisible(false);
                        labelQuimicaSelecionado.setVisible(false);
                        labelBiologiaSelecionado.setVisible(false);
                        labelInglesSelecionado.repaint();
                        
                        botaoSelecionado = botaoInglesMP;
                    }
                    break;
                    
                case "português":
                    if (botaoSelecionado != botaoPortuguesMP) {
                        int x = botaoPortuguesMP.getX() 
                                + (botaoPortuguesMP.getWidth()
                                - imagemPortuguesSelecionado.getWidth()) / 2;
                        
                        int y = botaoPortuguesMP.getY() 
                                + (botaoPortuguesMP.getHeight()
                                - imagemPortuguesSelecionado.getHeight()) / 2;
                        
                        labelPortuguesSelecionado.setBounds(x, 
                                y,
                                imagemPortuguesSelecionado.getWidth(), 
                                imagemPortuguesSelecionado.getHeight());
                        
                        labelPortuguesSelecionado.setVisible(true);
                        labelGeografiaSelecionado.setVisible(false);
                        labelHistoriaSelecionado.setVisible(false);
                        labelMatematicaSelecionado.setVisible(false);
                        labelInglesSelecionado.setVisible(false);
                        labelFisicaSelecionado.setVisible(false);
                        labelQuimicaSelecionado.setVisible(false);
                        labelBiologiaSelecionado.setVisible(false);
                        labelPortuguesSelecionado.repaint();
                        
                        botaoSelecionado = botaoPortuguesMP;
                    }
                    break; 
                    
                case "física":
                    if (botaoSelecionado != botaoFisicaMP) {
                        int x = botaoFisicaMP.getX() 
                                + (botaoFisicaMP.getWidth()
                                - imagemFisicaSelecionado.getWidth()) / 2;
                        
                        int y = botaoFisicaMP.getY() 
                                + (botaoFisicaMP.getHeight()
                                - imagemFisicaSelecionado.getHeight()) / 2;
                        
                        labelFisicaSelecionado.setBounds(x, 
                                y,
                                imagemFisicaSelecionado.getWidth(), 
                                imagemFisicaSelecionado.getHeight());
                        
                        labelFisicaSelecionado.setVisible(true);
                        labelGeografiaSelecionado.setVisible(false);
                        labelHistoriaSelecionado.setVisible(false);
                        labelMatematicaSelecionado.setVisible(false);
                        labelInglesSelecionado.setVisible(false);
                        labelPortuguesSelecionado.setVisible(false);
                        labelQuimicaSelecionado.setVisible(false);
                        labelBiologiaSelecionado.setVisible(false);
                        labelFisicaSelecionado.repaint();
                        
                        botaoSelecionado = botaoFisicaMP;
                    }
                    break;  
                    
                case "química":
                    if (botaoSelecionado != botaoQuimicaMP) {
                        int x = botaoQuimicaMP.getX() 
                                + (botaoQuimicaMP.getWidth()
                                - imagemQuimicaSelecionado.getWidth()) / 2;
                        
                        int y = botaoQuimicaMP.getY() 
                                + (botaoQuimicaMP.getHeight()
                                - imagemQuimicaSelecionado.getHeight()) / 2;
                        
                        labelQuimicaSelecionado.setBounds(x, 
                                y,
                                imagemQuimicaSelecionado.getWidth(), 
                                imagemQuimicaSelecionado.getHeight());
                        
                        labelQuimicaSelecionado.setVisible(true);
                        labelGeografiaSelecionado.setVisible(false);
                        labelHistoriaSelecionado.setVisible(false);
                        labelMatematicaSelecionado.setVisible(false);
                        labelInglesSelecionado.setVisible(false);
                        labelPortuguesSelecionado.setVisible(false);
                        labelFisicaSelecionado.setVisible(false);
                        labelBiologiaSelecionado.setVisible(false);
                        labelQuimicaSelecionado.repaint();
                        
                        botaoSelecionado = botaoQuimicaMP;
                    }
                    break;
                    
                case "biologia":
                    if (botaoSelecionado != botaoBiologiaMP) {
                        int x = botaoBiologiaMP.getX() 
                                + (botaoBiologiaMP.getWidth()
                                - imagemBiologiaSelecionado.getWidth()) / 2;
                        
                        int y = botaoBiologiaMP.getY() 
                                + (botaoBiologiaMP.getHeight()
                                - imagemBiologiaSelecionado.getHeight()) / 2;
                        
                        labelBiologiaSelecionado.setBounds(x, 
                                y,
                                imagemBiologiaSelecionado.getWidth(), 
                                imagemBiologiaSelecionado.getHeight());
                        
                        labelBiologiaSelecionado.setVisible(true);
                        labelGeografiaSelecionado.setVisible(false);
                        labelHistoriaSelecionado.setVisible(false);
                        labelMatematicaSelecionado.setVisible(false);
                        labelInglesSelecionado.setVisible(false);
                        labelPortuguesSelecionado.setVisible(false);
                        labelFisicaSelecionado.setVisible(false);
                        labelQuimicaSelecionado.setVisible(false);
                        labelBiologiaSelecionado.repaint();
                        
                        botaoSelecionado = botaoBiologiaMP;
                    }
                break;
                
            }
            this.revalidate();
            this.repaint();
        }

/*-------------MELHOR QUALIDADE DE RENDERIZAÇÃO DA IMAGEM DE FUNDO------------*/
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

/*------------VERIFICAÇÃO DE EXISTÊNCIA DA IMAGEM ANTES DE DESENHAR-----------*/

            if (imagemDeFundoMaterias != null) {
                g2d.drawImage(imagemDeFundoMaterias, 0, 
                        0,
                        w,
                        h, this);
            }
        }
    }
}
