import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconection {
    private static final String URL = "jdbc:derby:/caminho/para/seu/banco/de/dados";
    private static final String USUARIO = "seuUsuario";
    private static final String SENHA = "suaSenha";

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão bem-sucedida com o banco de dados Derby.");
            return conexao;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados Derby: " + e.getMessage());
            return null;
        }
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão com o banco de dados Derby fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Connection conexao = conectar();

        // Você pode usar a conexão para executar consultas SQL aqui

        fecharConexao(conexao);
    }
}