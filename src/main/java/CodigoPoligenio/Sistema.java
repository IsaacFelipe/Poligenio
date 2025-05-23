package CodigoPoligenio;

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
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sistema {
    
    private final String url = "jdbc:mysql://localhost:3306/poligenio";
    private final String usuario = "root";
    private final String senha = "imtdb";
    
    public Map<String, String> codigosRecuperacao = new HashMap<>();
    
    private String emailRecuperacao;

    public void CRUD_BD() {
        
    }

    public void autenticarUsuario() {
        
    }
    
    
    public void enviarEmail(String destinatario, String codigo){
        final String remetente = "poligeniogame@gmail.com";
        final String senha = "qocz yxxd vrdb esdx";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Código de Recuperação de Senha");
            message.setText("Seu código de recuperação é: " + codigo);

            Transport.send(message);
            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Erro ao enviar e-mail.");
        }
    }
    
    public boolean validarDados(String destinatario) throws SQLException{  
        
        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
        // Verifica se o email existe
        String sql = "SELECT * FROM jogador WHERE email_jogador = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, destinatario);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String codigo = gerarCodigoEmail();
                codigosRecuperacao.put(destinatario, codigo);
                enviarEmail(destinatario, codigo);
                return true;           
            } 
        }
        return false;
    }

    public void carregarRanking() {
        
    }

    public void iniciarPartida() {
        
    }

    public void notificarCadastro() {
        
    }

    public void verificarUsuarioLogado() {
        
    }

    public void solicitarCodigoPartida() {
        
    }

    public void inserirJogador() {
        
    }

    public void gerarRanking() {
        
    }

    public void armazenarPontuacao() {
        
    }

    public void mostrarRanking() {
        
    }

    public void calcularPontuacao() {
        
    }

    public void removerJogador() {
        
    }
    
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
    
    public boolean validarCodigo(String email, String codigo) throws SQLException {
        Connection conn = DriverManager.getConnection(url, usuario, senha);
        String sql = "SELECT * FROM RecuperacaoSenha WHERE email_usuario = ? AND codigo = ? AND expiracao > NOW()";
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
    
    public String gerarEArmazenarCodigo(String email) throws SQLException {
        String codigo = gerarCodigoEmail();      
        salvarCodigo(email, codigo);
        return codigo;
    }

    public void salvarCodigo(String email, String codigo) throws SQLException {
        Connection conn = DriverManager.getConnection(url, usuario, senha);
        String sql = "INSERT INTO RecuperacaoSenha (email_usuario, codigo, expiracao) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, codigo);
        stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis() + 15 * 60 * 1000)); // expira em 15 min
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void removerCodigo(String email) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "DELETE FROM RecuperacaoSenha WHERE email_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
            stmt.close();
        }
    }
}
