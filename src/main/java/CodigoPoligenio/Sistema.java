/*------------------------PACOTE QUE PERTENCE A CLASSE------------------------*/
package CodigoPoligenio;

/*------------------------IMPORTAÇÕES NECESSÁRIAS-----------------------------*/
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

/*-------------------CLASSE PARA GERENCIAMENTO DO SISTEMA---------------------*/
public class Sistema {
    
/*-------------------------DECLARAÇÃO DE VARIÁVEIS----------------------------*/
    private static Sistema instance;
    private final String url = "jdbc:mysql://localhost:3306/poligenio";
    private final String usuario = "root";
    private final String senha = "imtdb";
    public Map<String, String> codigosRecuperacao = new HashMap<>();
    private String emailRecuperacao;
    private String email;
    private String senhaUsuario;
    private Clip musicaPoligenio;
    private AbstractPessoa usuarioLogado;
    private boolean notificouCadastro = false;
    
/*----------------------CONSTRUTOR DA CLASSE SISTEMA--------------------------*/
    private Sistema() {
        try {
            String resourcePath = "/MusicaPoligenio/musicaPoligenio.wav";
            InputStream audioSrc = getClass().getResourceAsStream(resourcePath);
            if (audioSrc == null) {
                System.err.println("Erro: Não foi possível encontrar "
                        + "o recurso: " + resourcePath);
                return;
            }
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = 
                    AudioSystem.getAudioInputStream(bufferedIn);
            musicaPoligenio = AudioSystem.getClip();
            musicaPoligenio.open(audioStream);
            FloatControl gainControl = (FloatControl) musicaPoligenio.getControl
                                    (FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
/*------------------MÉTODO PARA OBTER INSTÂNCIA DO SISTEMA--------------------*/
    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }
    
/*------------------------MÉTODO PARA TOCAR MÚSICA----------------------------*/
    public void tocarMusica() {
        if (musicaPoligenio != null && !musicaPoligenio.isRunning()) {
            musicaPoligenio.loop(Clip.LOOP_CONTINUOUSLY);
            musicaPoligenio.start();
        }
    }

/*------------------------MÉTODO PARA PARAR MÚSICA----------------------------*/
    public void pararMusica() {
        if (musicaPoligenio != null && musicaPoligenio.isRunning()) {
            musicaPoligenio.stop();
        }
    }
    
/*----------------------MÉTODO PARA AUTENTICAR USUÁRIO------------------------*/
    public AbstractPessoa autenticarUsuario(String email, 
            String senhaUsuario) throws Exception {
        try {
            Connection conexao = ConexaoBD.obterConexao();
            String sqlProfessor = "SELECT id_administrador, "
                    + "nome_administrador, "
                    + "email_administrador, "
                    + "senha, especialidade "
                    + "FROM administrador"
                    + " WHERE email_administrador = ? "
                    + "AND senha = ?";
            PreparedStatement stmtProf = conexao.prepareStatement(sqlProfessor);
            stmtProf.setString(1, email);
            stmtProf.setString(2, senhaUsuario);
            ResultSet rsProf = stmtProf.executeQuery();
            if (rsProf.next()) {
                String idAdministrador = rsProf.getString("id_administrador");
                String nome = rsProf.getString("nome_administrador");
                String senha = rsProf.getString("senha");
                String especialidade = rsProf.getString("especialidade");
                rsProf.close();
                stmtProf.close();
                conexao.close();
                return new Professor(nome, idAdministrador, 
                        email, 
                        especialidade, 
                        senha);
            }
            rsProf.close();
            stmtProf.close();
            String sqlJogador = "SELECT id_aluno,"
                    + " nome_jogador, "
                    + "email_jogador, "
                    + "senha, "
                    + "serie "
                    + "FROM jogador "
                    + "WHERE email_jogador = ? "
                    + "AND senha = ?";
            PreparedStatement stmtJogador = 
                    conexao.prepareStatement(sqlJogador);
            stmtJogador.setString(1, email);
            stmtJogador.setString(2, senhaUsuario);
            ResultSet rsJogador = stmtJogador.executeQuery();
            if (rsJogador.next()) {
                String idAluno = rsJogador.getString("id_aluno");
                String nome = rsJogador.getString("nome_jogador");
                String senha = rsJogador.getString("senha");
                String serie = rsJogador.getString("serie");
                rsJogador.close();
                stmtJogador.close();
                conexao.close();
                return new Aluno(nome, idAluno, email, senha, serie);
            }
            rsJogador.close();
            stmtJogador.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
/*--------------------MÉTODO PARA AUTENTICAR CREDENCIAIS----------------------*/
    public boolean autenticar(String email, String senha) {
        this.email = email;
        this.senhaUsuario = senha;
        try {
            this.usuarioLogado = autenticarUsuario(email, senha);
            return this.usuarioLogado != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
/*------------------------MÉTODO PARA ENVIAR E-MAIL---------------------------*/
    public void enviarEmail(String destinatario, String codigo){
        final String remetente = "poligeniogame@gmail.com";
        final String senha = "qocz yxxd vrdb esdx";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, 
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO, 
                    InternetAddress.parse(destinatario));
            message.setSubject("Código de Recuperação de Senha");
            message.setText("Seu código de recuperação é: " + codigo);
            Transport.send(message);
            System.out.println("E-mail enviado com sucesso!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Erro ao enviar e-mail.");
        }
    }
    
/*---------------------MÉTODO PARA VALIDAR DADOS DO USUÁRIO-------------------*/
    public boolean validarDados(String destinatario) throws SQLException {  
        try (Connection conn = 
                DriverManager.getConnection(url, usuario, senha)) {
            String sqlAluno = "SELECT * FROM jogador WHERE email_jogador = ?";
            try (PreparedStatement stmtAluno = 
                    conn.prepareStatement(sqlAluno)) {
                stmtAluno.setString(1, destinatario);
                try (ResultSet rsAluno = stmtAluno.executeQuery()) {
                    if (rsAluno.next()) {
                        processarCodigoEmail(destinatario);
                        return true;
                    }
                }
            }
            String sqlProfessor = "SELECT * FROM administrador "
                    + "WHERE email_administrador = ?";
            try (PreparedStatement stmtProf = 
                    conn.prepareStatement(sqlProfessor)) {
                stmtProf.setString(1, destinatario);
                try (ResultSet rsProf = stmtProf.executeQuery()) {
                    if (rsProf.next()) {
                        processarCodigoEmail(destinatario);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
/*-------------------MÉTODO PARA PROCESSAR CÓDIGO DE E-MAIL-------------------*/
    private void processarCodigoEmail(String destinatario) throws SQLException {
        String codigo = gerarCodigoEmail();
        System.out.println("Código gerado para email " + 
                destinatario + 
                ": " 
                + codigo);
        
        salvarCodigo(destinatario, codigo);
        enviarEmail(destinatario, codigo);
        this.emailRecuperacao = destinatario;
    }

/*----------------------MÉTODO PARA NOTIFICAR CADASTRO------------------------*/
    public void notificarCadastro(AbstractPessoa pessoa) {
        if (notificouCadastro) return;
    
        this.usuarioLogado = pessoa;
        notificouCadastro = true;

        String tipo;
        if (pessoa instanceof Professor) {
            tipo = "Professor";
        } else if (pessoa instanceof Aluno) {
            tipo = "Aluno";
        } else {
            tipo = "Usuário";
        }

        JOptionPane.showMessageDialog(null, tipo + " " 
                + pessoa.getNome() 
                + " Logado!");    
    }

/*--------------------MÉTODO PARA VERIFICAR USUÁRIO LOGADO--------------------*/
    public boolean verificarUsuarioLogado(int idJogador) throws Exception {
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = ConexaoBD.obterConexao();

            String sql = "SELECT logado FROM jogador WHERE id_jogador = ?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, idJogador);

            rs = ps.executeQuery();

            if (rs.next()) {
                int logado = rs.getInt("logado");
                return logado == 1;
            } else {
                return false;
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, 
                "Erro ao consultar status de login no banco: " 
                        + erro.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, 
                    "Erro ao fechar conexão: " + erro.getMessage());
            }
        }
    }

/*------------------------MÉTODO PARA GERAR RANKING---------------------------*/
    public void gerarRanking() {
        
    }

/*----------------------MÉTODO PARA ARMAZENAR PONTUAÇÃO-----------------------*/
    public void armazenarPontuacao() {
        
    }

/*----------------------MÉTODO PARA CALCULAR PONTUAÇÃO------------------------*/
    public void calcularPontuacao() {
        
    }
    
/*----------------------MÉTODO PARA GERAR CÓDIGO DA SALA----------------------*/
    public String gerarCodigoSala(){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigo = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            int index = rnd.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        return codigo.toString();
    }
    
/*--------------------MÉTODO PARA GERAR CÓDIGO DE E-MAIL----------------------*/
    public String gerarCodigoEmail(){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigo = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            int index = rnd.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        return codigo.toString();
    }
    
/*------------------------MÉTODO PARA VALIDAR CÓDIGO--------------------------*/
    public boolean validarCodigo(String email, 
            String codigo) throws SQLException {
        Connection conn = DriverManager.getConnection(url, usuario, senha);
        String sql = "SELECT * FROM RecuperacaoSenha "
                + "WHERE email_usuario = ? "
                + "AND codigo = ? "
                + "AND expiracao > NOW()";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, codigo);
        ResultSet rs = stmt.executeQuery();
        boolean valido = rs.next();
        rs.close();
        stmt.close();
        conn.close();
        return valido;
    }
    
/*------------------MÉTODO PARA GERAR E ARMAZENAR CÓDIGO----------------------*/
    public String gerarEArmazenarCodigo(String email) throws SQLException {
        String codigo = gerarCodigoEmail();      
        salvarCodigo(email, codigo);
        return codigo;
    }

/*------------------------MÉTODO PARA SALVAR CÓDIGO---------------------------*/
    public void salvarCodigo(String email, String codigo) throws SQLException {
        try (Connection conn = 
                DriverManager.getConnection(url, usuario, senha)) {
            String sqlDelete = "DELETE FROM RecuperacaoSenha "
                    + "WHERE email_usuario = ?";
            try (PreparedStatement stmtDelete = 
                    conn.prepareStatement(sqlDelete)) {
                stmtDelete.setString(1, email);
                stmtDelete.executeUpdate();
            }
            String sqlInsert = "INSERT INTO RecuperacaoSenha (email_usuario, "
                    + "codigo, "
                    + "expiracao) "
                    + "VALUES (?, ?, ?)";
            try (PreparedStatement stmtInsert = 
                    conn.prepareStatement(sqlInsert)) {
                stmtInsert.setString(1, email);
                stmtInsert.setString(2, codigo);
                stmtInsert.setTimestamp(3, 
                     new Timestamp(System.currentTimeMillis() + 5 * 60 * 1000));
                stmtInsert.executeUpdate();
            }
        }
    }

/*------------------------MÉTODO PARA REMOVER CÓDIGO--------------------------*/
    public void removerCodigo(String email) throws SQLException {
        try (Connection conn = 
                DriverManager.getConnection(url, usuario, senha)) {
            String sql = "DELETE FROM RecuperacaoSenha "
                    + "WHERE email_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
            stmt.close();
        }
    }
    
/*----------------------MÉTODO PARA VERIFICAR CÓDIGO--------------------------*/
    public boolean verificarCodigo(String email_usuario, String codigoDigitado) 
            throws SQLException {
        
        try (Connection conn = 
                DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT codigo FROM RecuperacaoSenha "
                    + "WHERE email_usuario = ? "
                    + "AND UPPER(codigo) = UPPER(?) "
                    + "AND expiracao > NOW()";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email_usuario);
            stmt.setString(2, codigoDigitado);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String codigoSalvo = rs.getString("codigo");
                return codigoSalvo.equals(codigoDigitado);
            }
            rs.close();
            stmt.close();
        }
        return false;
    }

/*-----------------MÉTODO PARA OBTER E-MAIL DE RECUPERAÇÃO--------------------*/
    public String getEmailRecuperacao() {
        return emailRecuperacao;
    }

/*---------------MÉTODO PARA DEFINIR E-MAIL DE RECUPERAÇÃO--------------------*/
    public void setEmailRecuperacao(String destinatario) {
        this.emailRecuperacao = destinatario;
    }
    
/*---------------------MÉTODO PARA DEFINIR NOVA SENHA-------------------------*/
    public boolean novaSenha(String destinatario, 
            String novaSenha) throws Exception{
        
        try (Connection conn = DriverManager.getConnection(url, 
                usuario, 
                senha)) {
            
            String sqlAluno = "UPDATE jogador SET senha = ? "
                    + "WHERE email_jogador = ?";
            try (PreparedStatement stmtAluno = conn.prepareStatement(sqlAluno)){
                stmtAluno.setString(1, novaSenha);
                stmtAluno.setString(2, destinatario);
                int rowsAluno = stmtAluno.executeUpdate();
                if (rowsAluno > 0) {
                    return true;
                }
            }
            String sqlProf = "UPDATE administrador SET senha = ? "
                    + "WHERE email_administrador = ?";
            try (PreparedStatement stmtProf = conn.prepareStatement(sqlProf)) {
                stmtProf.setString(1, novaSenha);
                stmtProf.setString(2, destinatario);
                int rowsProf = stmtProf.executeUpdate();
                if (rowsProf > 0) {
                    return true;
                }
            }
        }
        return false;
    }

/*--------------------MÉTODO PARA VERIFICAR CÓDIGO DA SALA--------------------*/
    public boolean verificarCodigoSala(String codigoSala) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoBD.obterConexao();
            String sql = "SELECT * FROM sala WHERE `código_sala` = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigoSala);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}