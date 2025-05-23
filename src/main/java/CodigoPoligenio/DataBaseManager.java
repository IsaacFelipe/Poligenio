package CodigoPoligenio;

import java.sql.*;

public class DataBaseManager {

    public static Connection conectar() throws Exception {
        return ConexaoBD.obterConexao();
    }

    public static void desconectar(Connection conn) throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public static ResultSet executarQuery(String sql, Object... parametros) throws Exception {
        Connection conn = conectar();
        PreparedStatement ps = conn.prepareStatement(sql);

        for (int i = 0; i < parametros.length; i++) {
            ps.setObject(i + 1, parametros[i]);
        }

        return ps.executeQuery(); // lembre-se: quem chamar precisa fechar isso depois!
    }

    public static int executarUpdate(String sql, Object... parametros) throws Exception {
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < parametros.length; i++) {
                ps.setObject(i + 1, parametros[i]);
            }

            return ps.executeUpdate();
        }
    }
}
