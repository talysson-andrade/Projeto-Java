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
            FileOutputStream f = new FileOutputStream(new File("estoque.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(estoque);

            o.close();

        }catch(IOException e){
            System.out.println("Erro ao salvar os dados" + e.getMessage());
        }
    }
    public static void salvarItens(ItensCadastrados itens, String arquivo){
        try{
            FileOutputStream f = new FileOutputStream(new File("itens.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            for(Item item : itens.obterListaDeItens() ){

                o.writeObject(item);
            }


            o.close();

        }catch(IOException e){
            System.out.println("Erro ao salvar os dados" + e.getMessage());
        }
    }
    public static void salvarProdutos(ProdutosCadastrados produtos, String arquivo){
        try{
            FileOutputStream f = new FileOutputStream(new File("produtos.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(produtos);

            o.close();
            f.close();

        }catch(IOException e){
            System.out.println("Erro ao salvar os dados" + e.getMessage());
        }
    }

    public static Estoque carregarEstoque(String arquivo){
        try {
            FileInputStream fi = new FileInputStream(new File("estoque.txt"));

            ObjectInputStream oi = new ObjectInputStream(fi);

            Estoque estoque = (Estoque) oi.readObject();


            oi.close();
            fi.close();
            return estoque;
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch(IOException e){
        System.out.println("Erro ao salvar os dados" + e.getMessage());
        return null;
        }
    }

    public static ItensCadastrados carregarItens(String arquivo){
        try {
            FileInputStream fi = new FileInputStream(new File("itens.txt"));

            ObjectInputStream oi = new ObjectInputStream(fi);

            ItensCadastrados itens= new ItensCadastrados();



            Item item = (Item) oi.readObject();
            itens.adicionarItem(item);


            return itens;
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch(IOException e){
            System.out.println("Erro ao salvar os dados" + e.getMessage());
            return null;
        }
    }
    public static ProdutosCadastrados carregarProdutos(String arquivo){
        try {
            FileInputStream fi = new FileInputStream(new File("produtos.txt"));

            ObjectInputStream oi = new ObjectInputStream(fi);

            ProdutosCadastrados produtos = (ProdutosCadastrados) oi.readObject();

            oi.close();
            fi.close();
            return produtos;
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch(IOException e){
            System.out.println("Erro ao salvar os dados" + e.getMessage());
            return null;
        }
    }
}
