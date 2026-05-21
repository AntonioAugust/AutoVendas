package autovendas;

import java.time.LocalDate;
import java.util.Scanner;

public class SimuladorVendas {

    private final ControleClientes controleClientes;
    private final ControleEstoque controleEstoque;
    private final ControleVendas controleVendas;

    public SimuladorVendas() {
        this.controleClientes = new ControleClientes();
        this.controleEstoque = new ControleEstoque();
        this.controleVendas = new ControleVendas(controleEstoque);
    }

    private void cadastrarClienteManual() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=========================================");
        System.out.println("   Bem-vindo ao simulador AutoVendas!   ");
        System.out.print("Gostaria de cadastrar o seu nome (S/N):");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            String nome = "";

            while (true) {
                System.out.print("\nPara começar, como você se chama? \n> ");
                nome = scanner.nextLine();
                if (nome.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
                    break;
                } else {
                    System.out.println("Nome inválido! Por favor, digite apenas letras.");
                }
            }

            double saldo = 0;

            while (true) {
                System.out.print("Prazer, " + nome + "! qual será o seu saldo inicial para investir num veículo hoje? \n> R$ ");
                String entradaSaldo = scanner.nextLine().replace(",", ".");

                try {
                    saldo = Double.parseDouble(entradaSaldo);
                    if (saldo >= 0) {
                        break;
                    } else {
                        System.out.println("O saldo não pode ser negativo. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido! Por favor, digite apenas números.");
                }
            }

            String cpf = "000.000.000-00";
            String endereco = "Endereço Padrão";
            LocalDate dataNascimento = LocalDate.of(2000, 1, 1);

            System.out.print("Quer aproveitar para preencher o resto dos seus dados de cadastro? (S/N): ");
            String preencherResto = scanner.nextLine();

            if (preencherResto.equalsIgnoreCase("s")) {

                while (true) {
                    System.out.print("Qual é o seu CPF? \n> ");
                    cpf = scanner.nextLine();

                    if (cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
                        break;
                    } else {
                        System.out.println("Formato inválido! Por favor, digite apenas números usando os pontos e o traço.");
                    }
                }

                System.out.print("Onde você mora? \n> ");
                endereco = scanner.nextLine();

                while (true) {
                    try {
                        System.out.print("Em que ano você nasceu? \n> ");
                        int ano = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Em qual mês? \n> ");
                        int mes = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("E qual o dia do nascimento? \n> ");
                        int dia = Integer.parseInt(scanner.nextLine().trim());

                        dataNascimento = LocalDate.of(ano, mes, dia);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Opa, parece que você digitou letras ou algo diferente de números. Vamos tentar de novo!");
                    } catch (Exception e) {
                        System.out.println("Essa data não existe no calendário! Verifique o mês e o dia e tente novamente.");
                    }
                }
            }

            controleClientes.addCliente(nome, cpf, endereco, dataNascimento, saldo);

            System.out.println("\nTudo certo, " + nome + "! Seu perfil foi criado e sua carteira já está carregada.");
            System.out.println("Vamos ver como o sistema processa os seus dados na nossa demonstração...");
        } else {
            System.out.println("\nSem problemas! Vamos seguir a demonstração usando apenas os nossos clientes de teste.");
        }
        System.out.println("-----------------------------------------\n");
    }

    public void executarDemonstracao() {
        carregarDadosIniciais();
        cadastrarClienteManual();
        processarVendasCenario();
        mostrarResumoSimulacao();
    }

    private void carregarDadosIniciais() {
        controleClientes.addCliente("João Turing", "123.456.789-00", "Rua A, 123", LocalDate.of(1995, 5, 20), 500000);
        controleClientes.addCliente("Maria Grace", "987.654.321-11", "Av. Central, 50", LocalDate.of(1988, 11, 10), 150000);

        Veiculo corolla = new Carro("Toyota", "Corolla", "ABC-1234", "Prata", 2004, 4, Carro.TipoCombustivel.flex);
        Veiculo cb500 = new Moto("Honda", "CB 500", "XYZ-5678", "Vermelho", 2006, 500);

        // Novo veículo adicionado para a compra do cliente manual
        Veiculo civic = new Carro("Honda", "Civic", "DEF-9012", "Preto", 2010, 4, Carro.TipoCombustivel.gasolina);

        controleEstoque.addEstoque(corolla, 120000);
        controleEstoque.addEstoque(cb500, 90000);
        controleEstoque.addEstoque(civic, 80000);
    }

    private void processarVendasCenario() {
        tentarRealizarVenda(controleClientes.buscarPorId(1), controleEstoque.buscarPorId(1), new Pix());
        tentarRealizarVenda(controleClientes.buscarPorId(2), controleEstoque.buscarPorId(2), new CartaoCredito(3));

        // esse clienfe so existe se for cadastrado manualmente
        Cliente clienteManual = controleClientes.buscarPorId(3);
        if (clienteManual != null) {

            FormaPagamento descontoBoasVindas = new FormaPagamento() {
                {
                    setNome("Desconto Especial Boas-Vindas (15% OFF)");
                }
                @Override
                public double aplicarTaxa(double valor) {
                    return valor * 0.85; // Aplica 15% de desconto
                }
            };

            System.out.println("\nProcessando a compra exclusiva do seu perfil...");
            tentarRealizarVenda(clienteManual, controleEstoque.buscarPorId(3), descontoBoasVindas);
        }
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

        // Exibe o recibo da venda manual, se existir
        if (controleClientes.buscarPorId(3) != null) {
            controleVendas.verVenda(3);
        }

        Cliente joao = controleClientes.buscarPorId(1);
        Cliente maria = controleClientes.buscarPorId(2);
        Cliente manual = controleClientes.buscarPorId(3);

        System.out.println("\n--- Saldo Clientes ---");
        if (joao != null) {
            System.out.println(joao.getNomeCompleto() + " saldo: R$ " + String.format("%.2f", joao.getCarteira().getDinheiro()));
        }
        if (maria != null) {
            System.out.println(maria.getNomeCompleto() + " saldo: R$ " + String.format("%.2f", maria.getCarteira().getDinheiro()));
        }
        if (manual != null) {
            System.out.println(manual.getNomeCompleto() + " saldo: R$ " + String.format("%.2f", manual.getCarteira().getDinheiro()));
        }
    }
}