/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------IMPORTAÇÕES NECESSÁRIAS-------------------------------*/
import java.sql.Connection;
import java.sql.DriverManager;

/*-------CLASSE PARA GERENCIAMENTO DE CONEXÃO COM BANCO DE DADOS--------------*/
public class ConexaoBD {
    
/*----------------------DECLARAÇÃO DE VARIÁVEIS-------------------------------*/
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "poligenio";
    private static String usuario = "root";
    private static String senha = "imtdb";
    
/*------------MÉTODO PARA OBTER CONEXÃO COM O BANCO DE DADOS------------------*/
    public static Connection obterConexao() throws Exception{
        String url = "jdbc:mysql://" + host + ":" + porta + "/" + db 
                + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
        return DriverManager.getConnection(url, usuario, senha);
    }  
}