package locadoraDeCarros;

import java.time.LocalDate;

/**
 * Classe que representa um cliente do sistema.
 * Ela armazena os dados pessoais do cliente e a sua carteira.
 */
public class Cliente extends Pessoa{

    private int idCliente;
    private Carteira carteira;

    /**
     * Retorna a carteira do cliente.
     *
     * @return carteira do cliente
     */
    public Carteira getCarteira(){
        return carteira;
    }

    public int getIdCliente(){
        return idCliente;
    }

    public Cliente(String nomeCompleto, String cpf, String endereco, LocalDate nascimentoData, int idCliente, double dinheiroIncial){
        super(nomeCompleto, cpf, endereco, nascimentoData);
        this.idCliente = idCliente;
        this.carteira = new Carteira(dinheiroIncial);
    }

    @Override
    public String toString() {
        return "=== Dados do Cliente ===" +
                "\nID Cliente: " + idCliente +
                "\nNome: " + getNomeCompleto() +
                "\nCPF: " + getCpf() +
                "\nEndereço: " + getEndereco() +
                "\nDataNascimento: " + getNascimentoData() +
                "\n------------------------" +
                "\n[Carteira]" +
                "\nSaldo Atual: R$ " + String.format("%.2f", carteira.getDinheiro()) +
                "\n========================";
    }

}
