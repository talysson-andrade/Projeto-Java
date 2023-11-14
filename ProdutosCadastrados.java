import java.util.ArrayList;
import java.util.List;

public class ProdutosCadastrados {
    private static List<Produto> listaDeProdutos = new ArrayList<>();

    public static void adicionarProduto(Produto produto){
        listaDeProdutos.add(produto);
    }

    public static List<Produto> obterListaDeProdutos(){
        return listaDeProdutos;
    }

    public Produto encotrarProdutoPorCodigo(String codigo){
         
        for(Produto produto : listaDeProdutos ){
            if (produto.getCodigo().equals(codigo)){
                return produto;
            }
        }
        return null;
    }
}
