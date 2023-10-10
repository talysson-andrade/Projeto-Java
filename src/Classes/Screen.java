package Classes;
import java.util.Scanner;

public class Screen {

    public void Menu(){
        System.out.println("Digite a opção desejada: ");
        System.out.println("1. Cadastrar Item ");
        System.out.println("2. Cadastrar Produto: ");
        System.out.println("3. Adicionar Item ao Estoque ");
        System.out.println("4. Retirar Item do Estoque ");
        System.out.println("5. Procurar Item no Estoque");

        int resposta = InputUsuario();

        if(resposta == 5){
            ProcurarEstoqueText();
        }
        else if (resposta == 1) {
            CadastrarItem();
        }

    }

    public void ProcurarEstoqueText(){
        System.out.println("1. Procurar Item no Estoque por Código");
        System.out.println("2. Procurar Item no Estoque por Nome");
    }

    public int InputUsuario(){
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        return input;
    }
    public String InputUsuarioTexto(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        return input;
    }

    public void CadastrarItem(){
        System.out.println("Insira o nome do item: ");
        String nome = InputUsuarioTexto();
        Item item = new Item(nome, "fdfsd");

        System.out.println("nome do item: "+ item.getNome());
    }
}
