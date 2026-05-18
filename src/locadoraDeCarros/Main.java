package locadoraDeCarros;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        controleClientes clientes =
                new controleClientes();

        controleEstoque estoque =
                new controleEstoque();

        ControleVendas vendas =
                new ControleVendas(estoque);


        cadastrarClientes(clientes);

        cadastrarVeiculos(estoque);

        realizarVenda(clientes.buscarPorId(1), estoque.buscarPorId(1), new Pix(), vendas);

        realizarVenda(clientes.buscarPorId(2), estoque.buscarPorId(2), new CartaoCredito(3), vendas);

        mostrarResumo(clientes, vendas);

    }
    // =========================

    private static void cadastrarClientes(
            controleClientes clientes) {

        clientes.addCliente(
                "Fulano de Tal",
                "123.456.789-00",
                "Rua A, 123",
                LocalDate.of(1995, 5, 20),
                500000
        );

        clientes.addCliente(
                "Ciclana Souza",
                "987.654.321-11",
                "Av. Central, 50",
                LocalDate.of(1988, 11, 10),
                150000
        );
    }

    // =========================

    private static void cadastrarVeiculos(
            controleEstoque estoque) {

        Veiculo corolla =
                new Carro(
                        "Toyota",
                        "Corolla",
                        "ABC-1234",
                        "Prata",
                        2004,
                        4
                );

        Veiculo cb500 =
                new Moto(
                        "Honda",
                        "CB 500",
                        "XYZ-5678",
                        "Vermelho",
                        2006,
                        500
                );

        estoque.addEstoque(corolla, 120000);

        estoque.addEstoque(cb500, 90000);
    }

    // =========================

    private static void realizarVenda(
            Cliente cliente,
            itemEstoque item,
            FormaPagamento formaPagamento,
            ControleVendas vendas) {

        try {

            vendas.adicionarVenda(
                    cliente,
                    item,
                    formaPagamento
            );

            System.out.println(
                    "Venda realizada com sucesso!"
            );

        } catch (Exception e) {

            System.out.println(
                    "Erro ao realizar venda: "
                            + e.getMessage()
            );
        }
    }

    // =========================

    private static void mostrarResumo(
            controleClientes clientes,
            ControleVendas vendas) {

        System.out.println(
                "\n--- Histórico de Vendas ---"
        );

        vendas.verVenda(1);
        vendas.verVenda(2);

        Cliente fulano =
                clientes.buscarPorId(1);

        Cliente ciclana =
                clientes.buscarPorId(2);

        System.out.println(
                "\n--- Saldo Clientes ---"
        );

        System.out.println(
                fulano.getNomeCompleto()
                        + " saldo: R$ "
                        + fulano.getCarteira().getDinheiro()
        );

        System.out.println(
                ciclana.getNomeCompleto()
                        + " saldo: R$ "
                        + ciclana.getCarteira().getDinheiro()
        );
    }
}