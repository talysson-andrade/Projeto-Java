import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nome;
    private String descricao;
    private Map<Item, Integer> itens;

    public Produto(String codigo, String nome, String descricao){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.itens = new HashMap<>();
    }

    public String getCodigo(){
        return codigo;
    }
    public String getNome(){
        return nome;
    }
    public String getDescricao(){return descricao;}
    public Map<Item, Integer> getMapaDeItens(){
        return itens;
    }

    
    public void adicionarItem(Item item, int quantidade){
        itens.put(item, itens.getOrDefault(item, 0)+ quantidade);
    }
    public void retirarItem(Item item, int quantidade){
        if(itens.containsKey(item)){
            int quantidadeAtual = itens.get(item);

            if(quantidadeAtual >= quantidade){
                itens.put(item, quantidadeAtual - quantidade);
                System.out.println("Item retirado com sucesso.");
                System.out.println("Quantidade restante no produto: "+ itens.get(item));
            }else{
                System.out.println("Quantidade insuficiente.");
            }
        } else{
            System.out.println("Item não encontrado.");
        }
    }

    public void listarItens(){
        System.out.format(" Cód    Nome                                          Un %n");
        for(Map.Entry<Item, Integer> entry : itens.entrySet()){ //Percorre todos os Itens do Produto
            Item item = entry.getKey();
            int quantidade = entry.getValue();
            System.out.format(" %-3s    %-45s %-2d %n",item.getCodigo(),item.getNome(),quantidade);

             }
    }
}
