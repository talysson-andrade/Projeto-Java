import java.io.Serializable;

public class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String descricao;
    private String nome;

    public Item(String nome, String descricao){
        this.codigo = gerarCodigo();
        this.descricao = descricao;
        this.nome = nome;
    }

    private String gerarCodigo(){
        int codigo = 1;
        while(ItensCadastrados.encontrarItemPorCodigo(String.format("%03d", codigo)) != null){
            ++codigo;
        }
        return String.format("%03d", codigo);
    }

    public String getCodigo(){
        return codigo;
    }
    public String getDescricao(){
        return descricao;
    }
    public String getNome(){
        return nome;
    }
}