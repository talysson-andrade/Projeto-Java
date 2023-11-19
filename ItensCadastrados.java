import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class ItensCadastrados implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Item> listaDeItens = new ArrayList<>();

    public static void adicionarItem(Item item){
        listaDeItens.add(item);
    }

    public static List<Item> obterListaDeItens(){
        return listaDeItens;
    }

    public static Item encontrarItemPorCodigo(String codigo){
         
        for(Item item : listaDeItens ){
            if (item.getCodigo().equals(codigo)){
                return item;
            }
        }
        return null;
    }

    public void listarItensCadastrados(){
        System.out.println("Itens Cadastrados: ");
        System.out.format(" Cód    Nome                                         %n");
        for (Item item: listaDeItens
             ) {
            System.out.format(" %-3s    %-45s %n",item.getCodigo(), item.getNome());
        }
    }

}
