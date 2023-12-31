import java.util.Scanner;


public class Interface {
    private Estoque estoque;
    private ItensCadastrados itensCadastrados;
    private ProdutosCadastrados produtosCadastrados;

    public Interface(){
        Estoque estoque = SalvarCarregar.carregarEstoque("Dados/estoque.txt");
        ItensCadastrados itens = SalvarCarregar.carregarItens("Dados/itens.txt");
        ProdutosCadastrados produtos = SalvarCarregar.carregarProdutos("Dados/produtos.txt");

        if(estoque != null){
            this.estoque = estoque;
        }else {
            this.estoque = new Estoque();
        }
        if(itens != null){
            this.itensCadastrados = itens;
        }else {
            this.itensCadastrados = new ItensCadastrados();
        }
        if(produtos != null){
            this.produtosCadastrados = produtos;
        }else {
            this.produtosCadastrados = new ProdutosCadastrados();
        }

    }

    public void exibirMenu(){
        System.out.println();
        System.out.println("...........................................................");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Cadastrar Item");
        System.out.println("3. Adicionar Item ao Estoque");
        System.out.println("4. Retirar Item do Estoque");
        System.out.println("5. Procurar Item");
        System.out.println("6. Contar Capacidade de Produção de um Produto");
        System.out.println("7. Relacionar Item ao Produto");
        System.out.println("8. Procurar Produto");
        System.out.println("9. Listar Itens Cadastrados");
        System.out.println("10. Listar Produtos Cadastrados");
        System.out.println("11. Listar Estoque");
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
            procurarItemCadastrado(scan);
            break;
            case 6:
            contarCapacidadeProducao(scan);
            break;
            case 7:
            relacionarItemAoProduto(scan);
            break;
            case 8:
                procurarProdutoCadastrado(scan);
                break;
            case 9:
                itensCadastrados.listarItensCadastrados();
                break;
            case 10:
                produtosCadastrados.listarProdutosCadastrados();
                break;
            case 11:
                estoque.listarEstoque();
                break;
            case 0:
                SalvarCarregar.salvarEstoque(estoque, "Dados/estoque.txt");
                SalvarCarregar.salvarItens(this.itensCadastrados, "Dados/itens.txt");
                SalvarCarregar.salvarProdutos(this.produtosCadastrados, "Dados/produtos.txt");
            System.out.println("Saindo do sistema...");
            System.exit(0);
            default:
            System.out.println("Opção Inválida. Tente novamente.");
        }
        
    }

    
    private void cadastrarProduto(Scanner scan){
        System.out.println("Digite o código do produto: ");
        String codigoProduto = scan.nextLine();
        if (ProdutosCadastrados.encontrarProdutoPorCodigo(codigoProduto) == null)
        {

            System.out.print("Digite o nome do produto: ");
            String nomeProduto = scan.nextLine();

            System.out.print("Digite a descrição do produto: ");
            String descricao = scan.nextLine();

            Produto produto = new Produto(codigoProduto, nomeProduto, descricao);
            produtosCadastrados.adicionarProduto(produto);

            System.out.println(produto.getNome() + " " + "Cadastrado com o código: " + produto.getCodigo());
        }else {
            System.out.println("Já existe um produto cadastrado com este código. Tente novamente com um novo código. ");
        }
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

        Item item = itensCadastrados.encontrarItemPorCodigo(codigoItem);

        if (item != null) {
            System.out.println(item.getNome());
            System.out.println("Digite a quantidade a ser adicionada ao estoque: ");
            int quantidade = scan.nextInt();
            scan.nextLine();

            estoque.adicionarItemAoEstoque(item, quantidade);
            System.out.println(quantidade + " " + item.getNome() + " adicionados ao estoque");
            System.out.println(estoque.quantidadeItemNoEstoque(item)+" " + item.getNome()+" presentes no estoque");
        } else {
            System.out.println("Item sem cadastrado.");
        }
        
    }
    private void retirarItemDoEstoque(Scanner scan){
        System.out.println("Digite o código do item:");
        String codigoItem = scan.nextLine();
        Item item = itensCadastrados.encontrarItemPorCodigo(codigoItem);
        System.out.println(item.getNome());
        System.out.println("Digite a quantidade a ser retirada do estoque:");
        int quantidade = scan.nextInt();
        estoque.retirarItemDoEstoque(item, quantidade);       
    }
    private void procurarItemCadastrado(Scanner scan){
        System.out.println("Digite o código do item:");
        String codigoItem = scan.nextLine();

        Item item = itensCadastrados.encontrarItemPorCodigo(codigoItem);
        if(item != null){
            System.out.println("Código: "+item.getCodigo());
            System.out.println("Nome: "+item.getNome());
            System.out.println("Descrição: "+item.getDescricao());
            System.out.println("Quantidade disponível em estoque: "+ estoque.quantidadeItemNoEstoque(item));
        }
        else{
            System.out.println("Item não cadastrado.");
        }
    }
    private void contarCapacidadeProducao(Scanner scan){
        System.out.println("Digite o código do Produto:");
        String codigoProduto = scan.nextLine();

        Produto produto = produtosCadastrados.encontrarProdutoPorCodigo(codigoProduto);
        if(produto != null){
            if(!produto.getMapaDeItens().isEmpty()) {
                System.out.println("Capacidade de Produção para " + produto.getNome() + ": " + estoque.contarCapacidadeProducao(produto));
            } else{
                System.out.println("Produto sem itens relacionados.");
            }
        } else{
            System.out.println("Produto não encontrado.");
        }
        
    }

    private void relacionarItemAoProduto(Scanner scan){
        System.out.println("Digite o código do Produto:");
        String codigoProduto = scan.nextLine();

        Produto produto = produtosCadastrados.encontrarProdutoPorCodigo(codigoProduto);

        if(produto != null){
            System.out.println(produto.getNome());
            System.out.println("Digite o número de itens que irá relacionar:");
            int numero = scan.nextInt();
            scan.nextLine();
            for(int i = 0; i<numero; i++){
                System.out.println("Digite o código do Item:");
                String codigoItem = scan.nextLine();

                Item item = itensCadastrados.encontrarItemPorCodigo(codigoItem);
                if( item != null){
                    System.out.println("Insira a quantidade de " + item.getNome() +": ");
                    int quantidade = scan.nextInt();
                    scan.nextLine();
                    produto.adicionarItem(item, quantidade);
                }else{
                    System.out.println("Item não encontrado. Lembre-se de cadastrar o item antes de realizar essa operação.");
                    break;
                }
            }

        } else{
            System.out.println("Produto não encontrado.");
        }
    }
    private void procurarProdutoCadastrado(Scanner scan){
        System.out.println("Digite o código do produto:");
        String codigoProduto = scan.nextLine();

        Produto produto = produtosCadastrados.encontrarProdutoPorCodigo(codigoProduto);
        if(produto != null){
            System.out.println("Código: "+produto.getCodigo());
            System.out.println("Nome: "+produto.getNome());
            System.out.println("Descrição: "+produto.getDescricao());
            System.out.println("Itens relacionados: ");
            produto.listarItens();
        }
        else{
            System.out.println("Item não cadastrado.");
        }
    }

}
