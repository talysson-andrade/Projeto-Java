

public class ItemEstoque {
    private int unidades;
    private  Item item;


    public ItemEstoque(Item item, int unidades){
        this.item = item;
        this.unidades = unidades;

    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
