import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class ProdutosCadastrados implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Produto> listaDeProdutos = new ArrayList<>();

    public static void adicionarProduto(Produto produto){
        listaDeProdutos.add(produto);
    }

    public static List<Produto> obterListaDeProdutos(){
        return listaDeProdutos;
    }

    public static Produto encontrarProdutoPorCodigo(String codigo){
         
        for(Produto produto : listaDeProdutos ){
            if (produto.getCodigo().equals(codigo)){
                return produto;
            }
        }
        return null;
    }

    public void listarProdutosCadastrados(){
        System.out.println("Produtos Cadastrados: ");
        System.out.format(" Código      Nome                           %n");
        for(Produto produto : listaDeProdutos){
            System.out.format(" %-8s    %-30s %n",produto.getCodigo(), produto.getNome());
        }
    }
}
