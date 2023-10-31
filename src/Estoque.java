
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Estoque {
    private static final String URL = "jdbc:derby:/caminho/para/seu/banco/de/dados";
    private static final String USUARIO = "seuUsuario";
    private static final String SENHA = "suaSenha";

    public void cadastrarItemEstoque(String nomeProduto, int quantidade) {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            String sql = "INSERT INTO estoque (nome_produto, quantidade) VALUES (?, ?)";
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nomeProduto);
            preparedStatement.setInt(2, quantidade);
            preparedStatement.executeUpdate();
            System.out.println("Item de estoque cadastrado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar item de estoque: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        estoque.cadastrarItemEstoque("Produto A", 100);

        // Você pode chamar o método "cadastrarItemEstoque" com diferentes produtos e quantidades.
    }
}
