
import java.util.Scanner;

public class Interface {


    public void Menu(){
        System.out.println("Digite a opção desejada: ");
        System.out.println("1. Cadastrar Item ");
        System.out.println("2. Cadastrar Produto: ");
        System.out.println("3. Adicionar Item ao Estoque ");
        System.out.println("4. Retirar Item do Estoque ");
        System.out.println("5. Procurar Item no Estoque");
        System.out.println("6. Capacidade de Produção");
        

        int resposta = InputUsuario();

        if(resposta == 5){
            ProcurarEstoqueText();
        }
        else if (resposta == 1) {
            CadastrarItem();
        }
        else if(resposta == 2){

            CadastrarProduto();
        } else if (resposta == 3) {

        }

    }

    public void ProcurarEstoqueText(){
        System.out.println("1. Procurar Item no Estoque por Código");
        System.out.println("2. Procurar Item no Estoque por Nome");
    }

    public int InputUsuario(){
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    public String InputUsuarioTexto(){
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public void CadastrarItem(){
        System.out.println("Insira o nome do item: ");
        String nome = InputUsuarioTexto();
        System.out.println("Insira uma descrição para o item: ");
        String desc = InputUsuarioTexto();
        Item item = new Item(nome, desc);

        System.out.println("Item cadastrado com sucesso");
    }

    public void CadastrarProduto(){
        System.out.println("Insira o nome do produto: ");
        String nome = InputUsuarioTexto();
        System.out.println("Insira uma descrição para o produto: ");
        String desc = InputUsuarioTexto();
        Produto produto = new Produto(nome, desc);

        System.out.println("Produto cadastrado com sucesso");
    }



}
