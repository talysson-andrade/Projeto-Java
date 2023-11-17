import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Serializable;

public class Estoque implements Serializable{
    private static final long serialVersionUID = 1L;
    private Map<String, Integer> quantidadeItens;

    public Estoque(){
        this.quantidadeItens = new HashMap<>();
    }



    public void adicionarItemAoEstoque(Item item, int quantidade){
        if(item != null){
        String codigoItem = item.getCodigo();
        quantidadeItens.put(codigoItem, quantidadeItemNoEstoque(item)+ quantidade); 
        /*Recupera a quantidade atual de itens associada ao código do item
        Adiciona a quantidade fornecida como argumento a essa quantidade
        Atualiza o mapa quantidadeItens com o novo valor calculado  */   
        }else{
            System.out.println("Item não encontrado. Realize o cadastro.");
        }    
    }

    public void retirarItemDoEstoque(Item item, int quantidade){
       
        if(item != null && quantidadeItens.containsKey(item.getCodigo())){
            
            String codigoItem = item.getCodigo();
            int quantidadeAtual = quantidadeItemNoEstoque(item);
            if(quantidadeAtual >= quantidade){
                quantidadeItens.put(codigoItem, quantidadeAtual - quantidade);
                System.out.println(quantidade + " " + item.getNome() +" retirado(s) do estoque com sucesso!");
                System.out.println("Quantidade restante no estoque: "+ quantidadeItens.get(codigoItem));

            }else{
                System.out.println("Quantidade insuficiente no estoque.");
            }
        }else{
            System.out.println("Item não encontrado no estoque");
        }
                    
    }

    public int quantidadeItemNoEstoque(Item item){
       String codigoItem = item.getCodigo();
        return quantidadeItens.getOrDefault(codigoItem, 0);
    }

    public int contarCapacidadeProducao(Produto produto){
        for(Map.Entry<Item, Integer> entry : produto.getMapaDeItens().entrySet()){ //Percorre todos os Itens do Produto
            /*Verifica se todos os itens necessários para o produto estão presentes no estoque */
            Item item = entry.getKey();
            int quantidadeNecessaria = entry.getValue();

            if(!quantidadeItens.containsKey(item.getCodigo())  || quantidadeItens.get(item.getCodigo())< quantidadeNecessaria){
                //Se algum item não está presente ou se a quantidade é insuficiente, a capacidade é 0
                return 0;
            }
        }
        int capacidadeProducao = Integer.MAX_VALUE; // coloca um valor alto

        for(Map.Entry<Item, Integer> entry : produto.getMapaDeItens().entrySet()){ //Percorre todos os Itens do Produto
            Item item = entry.getKey();
            int quantidadeNecessaria = entry.getValue();
            int quantidadeDisponivel = quantidadeItens.get(item.getCodigo());
            
            int capacidadeItem = quantidadeDisponivel / quantidadeNecessaria;
            capacidadeProducao = Math.min(capacidadeProducao, capacidadeItem); // Compara os dois valores e retorna o menor
        }
        return capacidadeProducao;
    }
}