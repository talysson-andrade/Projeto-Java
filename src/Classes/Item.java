package Classes;

public class Item {
    private String nome;
    private String desc;

    public Item() {
    }

    public Item(String nome, String desc){
        this.desc = desc;
        this.nome = nome;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
