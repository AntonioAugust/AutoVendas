package locadoraDeCarros;

import java.time.LocalDate;

/**
 * Classe que representa um carro dentro do estoque.
 * Ela herda da classe Veiculo, então ja possui placa, marca, modelo,
 * ano, valor base e disponibilidade. Alem disso, o carro possui uma
 * informacao propria: a quantidade de portas.
 */
public class Carro extends Veiculo {
    private int quantidadePortas;

    /**
     * Construtor da classe Carro.
     *
     * @param marca marca do carro
     * @param modelo modelo do carro
     * @param anoFabricacao ano de fabricacao do carro
     * @param placa placa do carro
     * @param cor cor do carro
     * @param quantidadePortas quantidade de portas do carro
     * @param precoBase valor base do carro
     */
    public Carro(String marca, String modelo, LocalDate anoFabricacao, String placa, String cor, int quantidadePortas, double precoBase) {
        super(marca, modelo, placa, cor, anoFabricacao, precoBase);
        this.quantidadePortas = quantidadePortas;
    }

    /**
     * Retorna o tipo do veículo.
     * Implementa o método abstrato da classe Veiculo para identificar o objeto como um Carro.
     *
     * @return tipo do veículo
     */
    @Override
    public String getTipo(){
        return "Carro";
    }

    /**
     * Retorna uma representação em String do carro.
     * Complementa a representação da classe mãe com a informação específica de portas.
     *
     * @return dados formatados do carro
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" | Portas: %d", quantidadePortas);
    }

    /**
     * Retorna a quantidade de portas do carro.
     *
     * @return quantidade de portas
     */
    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    /**
     * Define a quantidade de portas do carro.
     *
     * @param quantidadePortas quantidade de portas do carro
     */
    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}