import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";
        
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem-sucedida!");
            // Você pode usar 'conexao' para executar consultas e interagir com o banco de dados.
        } catch (SQLException e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    }
}