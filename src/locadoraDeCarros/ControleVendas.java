package locadoraDeCarros;
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

    public void adicionarVenda(Cliente cliente, Veiculo veiculo, String formaPagamento){

        Veiculo veiculoRemov = estoque.removerVeiculo(veiculo.getIdVeiculo());
        if (veiculoRemov == null) {
            System.out.println("ERRO: Veículo com ID " + veiculo.getIdVeiculo() + " não encontrado no estoque!");
            return;
        }

        double valorVenda = veiculo.getPreco();

        if(cliente.getCarteira().getDinheiro() < valorVenda){
            System.out.println("ERRO: Saldo insuficiente! Saldo: " + cliente.getCarteira().getDinheiro() + " | Necessário: " + valorVenda);

            //Se não tem dinheiro devolvemos o carro para o estoque
            estoque.addVeiculo(veiculoRemov);
            return;
        }

        double saldoAntes = cliente.getCarteira().getDinheiro();
        cliente.getCarteira().remover(valorVenda);

        Venda novaVenda = new Venda(proximoId++, cliente, veiculo, formaPagamento);
        listaVendas.add(novaVenda);

        // Exibir detalhes da venda
        System.out.println("\n--- VENDA #" + novaVenda.getIdVenda() + " ---");
        System.out.println("Cliente: " + cliente.getNomeCompleto());
        System.out.println("Veículo: " + veiculo.getMarca() + " " + veiculo.getModelo());
        System.out.println("Valor: R$ " + String.format("%.2f", valorVenda));
        System.out.println("Saldo antes: R$ " + String.format("%.2f", saldoAntes));
        System.out.println("Saldo após: R$ " + String.format("%.2f", cliente.getCarteira().getDinheiro()));
        System.out.println("✓ Venda realizada com sucesso!");
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