
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class SalvarCarregar {

    public static void salvarEstoque(Estoque estoque, String arquivo){
        try{
            FileOutputStream f = new FileOutputStream(new File("Dados/estoque.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(estoque);

            o.close();

        }catch(IOException e){

        }
    }
    public static void salvarItens(ItensCadastrados itens, String arquivo){
        try{
            FileOutputStream f = new FileOutputStream(new File("Dados/itens.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            for(Item item : itens.obterListaDeItens() ){

                o.writeObject(item);
            }


            o.close();

        }catch(IOException e){

        }
    }
    public static void salvarProdutos(ProdutosCadastrados produtos, String arquivo){
        try{
            FileOutputStream f = new FileOutputStream(new File("Dados/produtos.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            for(Produto produto : produtos.obterListaDeProdutos() ){

                o.writeObject(produto);
            }


            o.close();

        }catch(IOException e){

        }
    }

    public static Estoque carregarEstoque(String arquivo){
        try {
            FileInputStream fi = new FileInputStream(new File("Dados/estoque.txt"));

            ObjectInputStream oi = new ObjectInputStream(fi);

            Estoque estoque = (Estoque) oi.readObject();


            oi.close();
            fi.close();
            return estoque;
        }catch (FileNotFoundException e) {

            return null;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch(IOException e){

        return null;
        }
    }

    public static ItensCadastrados carregarItens(String arquivo){
        try {
            FileInputStream fi = new FileInputStream(new File("Dados/itens.txt"));

            ObjectInputStream oi = new ObjectInputStream(fi);

            ItensCadastrados itens= new ItensCadastrados();

            Item  item = (Item) oi.readObject();
            itens.adicionarItem(item);
            while(item != null) {
                item = (Item) oi.readObject();
                itens.adicionarItem(item);
            }
            oi.close();
            return itens;
        }catch (FileNotFoundException e) {

            return null;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch(IOException e){

            return null;
        }
    }
    public static ProdutosCadastrados carregarProdutos(String arquivo){
        try {
            FileInputStream fi = new FileInputStream(new File("Dados/produtos.txt"));

            ObjectInputStream oi = new ObjectInputStream(fi);

            ProdutosCadastrados produtos= new ProdutosCadastrados();

            Produto produto = (Produto) oi.readObject();
            produtos.adicionarProduto(produto);
            while(produto != null) {
                produto = (Produto) oi.readObject();
                produtos.adicionarProduto(produto);
            }
            oi.close();
            return produtos;
        }catch (FileNotFoundException e) {

            return null;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch(IOException e){

            return null;
        }
    }
}
