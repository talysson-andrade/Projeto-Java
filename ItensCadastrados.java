import java.util.ArrayList;
import java.util.List;

public class ItensCadastrados {
    private static List<Item> listaDeItens = new ArrayList<>();

    public static void adicionarItem(Item item){
        listaDeItens.add(item);
    }

    public static List<Item> obterListaDeItens(){
        return listaDeItens;
    }

    public Item encotrarItemPorCodigo(String codigo){
         
        for(Item item : listaDeItens ){
            if (item.getCodigo().equals(codigo)){
                return item;
            }
        }
        return null;
    }
}
