package autovendas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControleVendas {
    private int proximoId;
    private List<Venda> listaVendas;
    private ControleEstoque estoque;

    public ControleVendas(ControleEstoque estoque){
        listaVendas = new ArrayList<>();
        this.estoque = estoque;
        proximoId = 1;
    }

    public void adicionarVenda(Cliente cliente, ItemEstoque item, FormaPagamento formaPagamento){

        ItemEstoque itemEncontrado = estoque.buscarPorId(item.getIdItem());
        if(itemEncontrado == null){
            throw new IllegalArgumentException("Item não encontrado no estoque");
        }

        Venda novaVenda = new Venda(proximoId, cliente, formaPagamento, item);

        double valorVenda = novaVenda.calcularValorFinal();

        if(cliente.getCarteira().getDinheiro() < valorVenda){
            throw new IllegalStateException("Saldo insuficiente");
        }
        estoque.removerEstoque(item.getIdItem());

        cliente.getCarteira().remover(valorVenda);

        listaVendas.add(novaVenda);
        proximoId++;
    }


    public void verVenda(int idVenda){
        for(Venda v : listaVendas){
            if(v.getIdVenda() == idVenda){
                System.out.println(v);
                return;
            }
        }
    }
    //sobrecarga de funcao
    public void verVenda(LocalDate date){
        for(Venda v : listaVendas){
            if(date.isEqual(v.getDate())){
                System.out.println(v);

            }
        }
    }
}
