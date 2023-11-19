import java.util.Scanner;

public class
        Main {
    public static void main(String[] args){
        Interface menu = new Interface();
        Scanner scanner = new Scanner(System.in);

        int escolha;
        do{
            menu.exibirMenu();
            escolha = scanner.nextInt();
            scanner.nextLine();

            menu.realizarOperacao(escolha);

        }while (escolha != 0);
    }
}
