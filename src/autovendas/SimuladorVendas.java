package autovendas;

import java.time.LocalDate;

public class SimuladorVendas {

    private final ControleClientes controleClientes;
    private final ControleEstoque controleEstoque;
    private final ControleVendas controleVendas;

    public SimuladorVendas() {
        this.controleClientes = new ControleClientes();
        this.controleEstoque = new ControleEstoque();
        this.controleVendas = new ControleVendas(controleEstoque);
    }

    /**
     * Coordena o fluxo completo da demonstração do sistema.
     */
    public void executarDemonstracao() {
        carregarDadosIniciais();
        processarVendasCenario();
        mostrarResumoSimulacao();
    }

    private void carregarDadosIniciais() {
        // Cadastro de Clientes
        controleClientes.addCliente("João Turing", "123.456.789-00", "Rua A, 123", LocalDate.of(1995, 5, 20), 500000);
        controleClientes.addCliente("Maria Grace", "987.654.321-11", "Av. Central, 50", LocalDate.of(1988, 11, 10), 150000);

        // Criação de Veículos
        Veiculo corolla = new Carro("Toyota", "Corolla", "ABC-1234", "Prata", 2004, 4);
        Veiculo cb500 = new Moto("Honda", "CB 500", "XYZ-5678", "Vermelho", 2006, 500);

        // Carga no Estoque
        controleEstoque.addEstoque(corolla, 120000);
        controleEstoque.addEstoque(cb500, 90000);
    }

    private void processarVendasCenario() {
        tentarRealizarVenda(controleClientes.buscarPorId(1), controleEstoque.buscarPorId(1), new Pix());
        tentarRealizarVenda(controleClientes.buscarPorId(2), controleEstoque.buscarPorId(2), new CartaoCredito(3));
    }

    private void tentarRealizarVenda(Cliente cliente, ItemEstoque item, FormaPagamento formaPagamento) {
        try {
            controleVendas.adicionarVenda(cliente, item, formaPagamento);
            System.out.println("Venda do veículo " + item.getVeiculo().getModelo() +
                    " para " + cliente.getNomeCompleto() + " realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao realizar venda: " + e.getMessage());
        }
    }

    private void mostrarResumoSimulacao() {
        System.out.println("\n--- Histórico de Vendas ---");
        controleVendas.verVenda(1);
        controleVendas.verVenda(2);

        Cliente joao = controleClientes.buscarPorId(1);
        Cliente maria = controleClientes.buscarPorId(2);

        System.out.println("\n--- Saldo Clientes ---");
        if (joao != null) {
            System.out.println(joao.getNomeCompleto() + " saldo: R$ " + String.format("%.2f", joao.getCarteira().getDinheiro()));
        }
        if (maria != null) {
            System.out.println(maria.getNomeCompleto() + " saldo: R$ " + String.format("%.2f", maria.getCarteira().getDinheiro()));
        }
    }
}
