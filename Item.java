import java.io.Serializable;

public class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    private static int contadorItens = 1;
    private String codigo;
    private String descricao;
    private String nome;

    public Item(String nome, String decricao){
        this.codigo = gerarCodigo();
        this.descricao = descricao;
        this.nome = nome;
    }

    private String gerarCodigo(){
        return String.format("%03d", contadorItens++);        
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