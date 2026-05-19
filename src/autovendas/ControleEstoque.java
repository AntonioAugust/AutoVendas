package autovendas;

import java.util.ArrayList;
import java.util.List;

public class ControleEstoque {
    private List<ItemEstoque> controleEstoque;
    private int proximoId;

    public ControleEstoque(){
        controleEstoque = new ArrayList<>();
        proximoId = 0;
    }

    public void addEstoque(Veiculo veiculo, double preco){
        proximoId++;
        controleEstoque.add(new ItemEstoque(veiculo, preco, proximoId));
    }

    public ItemEstoque removerEstoque(int itemId) {
        ItemEstoque itemRemover = null;
        for (ItemEstoque v : controleEstoque){
            if (v.getIdItem() == itemId){
                itemRemover = v;
                break;
            }
        }
        if (itemRemover != null){
            controleEstoque.remove(itemRemover);
        }
        return itemRemover;
    }

    public ItemEstoque buscarPorId(int id){

        for(ItemEstoque item : controleEstoque){
            if(item.getIdItem() == id){
                return item;
            }
        }
        return null;
    }
}
