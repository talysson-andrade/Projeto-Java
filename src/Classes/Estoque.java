package Classes;

public class Estoque {

    public void AdicionarItem(Item item, int quantidade){

        ItemEstoque novoItem = new ItemEstoque(item,quantidade);
        //Adicionar ao Banco de Dados


    }

    public void RemoverItem(Item item, int quantidade){
        //Remover do Banco de Dados
    }
}
