import java.io.*;
public class SalvarCarregar {

    public static void salvarObjeto(Object object, String arquivo){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oos.writeObject(object);           
        }catch (IOException e) {
            System.err.println("Erro ao salvar dados: "+ e.getMessage());
        }                
    }

    public static Object carregarObjeto(String arquivo){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))){
            Object object = ois.readObject();
            System.out.println("Dados carregados com sucesso");
            return object;
        }catch(IOException | ClassNotFoundException e){
            System.err.println("Erro ao carregar os dados: "+ e.getMessage());
            return null;
        }
    }
}
