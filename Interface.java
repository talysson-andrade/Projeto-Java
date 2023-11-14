import java.util.Scanner;


public class Interface {
    private Estoque estoque;
    private ItensCadastrados itensCadastrados;
    private ProdutosCadastrados produtosCadastrados;

    public Interface(){
        this.estoque = new Estoque();
        this.itensCadastrados = new ItensCadastrados();
        this.produtosCadastrados = new ProdutosCadastrados();

    }

    public void exibirMenu(){
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Cadastrar Item");
        System.out.println("3. Adicionar Item ao Estoque");
        System.out.println("4. Retirar Item do Estoque");
        System.out.println("5. Procurar Item no Estoque");
        System.out.println("6. Contar Capacidade de Produão de um Produto");
        System.out.println("7. Relacionar Item ao Produto");
        System.out.println("0. Sair");
    }

    public void realizarOperacao(int escolha){
        Scanner scan = new Scanner(System.in);

        switch (escolha){
            case 1:
            cadastrarProduto(scan);
            break;
            case 2:
            cadastrarItem(scan);
            break;
            case 3:
            adicionarItemAoEstoque(scan);
            break;
            case 4:
            retirarItemDoEstoque(scan);
            break;
            case 5:
            procurarItemNoEstoque(scan);
            break;
            case 6:
            contarCapacidadeProducao(scan);
            break;
            case 7:
            relacionarItemAoProduto(scan);
            break;
            case 0:
            System.out.println("Saindo do sistema...");
            System.exit(0);
            default:
            System.out.println("Opção Inválida. Tente novamente.");
        }
        
    }

    
    private void cadastrarProduto(Scanner scan){
        System.out.println("Digite o código do produto: ");
        String codigoProduto = scan.nextLine();

        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scan.nextLine();

        Produto produto = new Produto(codigoProduto, nomeProduto);
        produtosCadastrados.adicionarProduto(produto);

        System.out.println(produto.getNome() + " " + "Cadastrado com o código: " + produto.getCodigo());
    }

    private void cadastrarItem(Scanner scan){
        System.out.println("Digite o nome do item: ");
        String nomeItem = scan.nextLine();
        System.out.println("Digite a descrição do item: ");
        String descricaoItem = scan.nextLine();

        Item item = new Item(nomeItem, descricaoItem);
        itensCadastrados.adicionarItem(item);

        System.out.println(item.getNome()+ " " +"cadastrado com o código: " + item.getCodigo());

    }

    private void adicionarItemAoEstoque(Scanner scan){
        System.out.println("Digite o código do item:");
        String codigoItem = scan.nextLine();

        Item item = itensCadastrados.encotrarItemPorCodigo(codigoItem);

        
        System.out.println("Digite a quantidade a ser adicionada ao estoque: ");
        int quantidade = scan.nextInt();
        scan.nextLine();

        estoque.adicionarItemAoEstoque(item, quantidade);
        System.out.println(estoque.quantidadeItemNoEstoque(item) +" "+ item.getNome()+ " adicionados ao estoque");
        
        
    }
    private void retirarItemDoEstoque(Scanner scan){
        System.out.println("Digite o código do item:");
        String codigoItem = scan.nextLine();
        Item item = itensCadastrados.encotrarItemPorCodigo(codigoItem);
        System.out.println("Digite a quantidade a ser retirada do estoque:");
        int quantidade = scan.nextInt();
        estoque.retirarItemDoEstoque(item, quantidade);       
    }
    private void procurarItemNoEstoque(Scanner scan){
        System.out.println("Digite o código do item:");
        String codigoItem = scan.nextLine();

        Item item = itensCadastrados.encotrarItemPorCodigo(codigoItem);
        if(item != null){
            System.out.println(item.getCodigo() + " " + item.getNome() + " " + estoque.quantidadeItemNoEstoque(item));
        }
        else{
            System.out.println("Item não encontrado no estoque");
        }
    }
    private void contarCapacidadeProducao(Scanner scan){
        
    }

    private void relacionarItemAoProduto(Scanner scan){
        System.out.println("Digite o código do Produto:");
        String codigoProduto = scan.nextLine();

        Produto produto = produtosCadastrados.encotrarProdutoPorCodigo(codigoProduto);

        if(produto != null){
            System.out.println("Digite o código do Item:");
            String codigoItem = scan.nextLine();

            Item item = itensCadastrados.encotrarItemPorCodigo(codigoItem);
            if( item != null){
                System.out.println("Insira a quantidade do Item:");
                int quantidade = scan.nextInt();
                produto.adicionarItem(item, quantidade);
            }else{
                System.out.println("Item não encontrado.");
            }
        } else{
            System.out.println("Produto não encontrado.");
        }
        
    }

    
}
