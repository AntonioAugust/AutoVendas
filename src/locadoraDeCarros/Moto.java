package locadoraDeCarros;

import java.time.LocalDate;

/**
 * Classe que representa uma moto dentro do estoque.
 * Assim como o carro, a moto tambem herda da classe Veiculo.
 */
public class Moto extends Veiculo {
    private final int cilindradas; // final, pois as cilindradas não é alterada

    /**
     * Construtor da classe Moto.
     *
     * @param marca marca da moto
     * @param modelo modelo da moto
     * @param anoFabricacao ano de fabricacao da moto
     * @param placa placa da moto
     * @param precoBase valor base da moto
     * @param cor cor da moto
     * @param cilindradas quantidade de cilindradas da moto
     */
    public Moto(String marca, String modelo, LocalDate anoFabricacao, String placa, double precoBase, String cor, int cilindradas) {
        super(marca, modelo, placa, cor, anoFabricacao, precoBase);
        this.cilindradas = cilindradas;
    }

    /**
     * Retorna o tipo do veículo.
     * Implementa o metodo abstrato da classe Veiculo para identificar o objeto como uma Moto.
     *
     * @return tipo do veículo
     */
    @Override
    public String getTipo(){
        return "Moto";
    }

    /**
     * Retorna uma representação em String da moto.
     * Complementa a representação da classe mãe com a informação específica de cilindradas.
     *
     * @return dados formatados da moto
     */
    @Override
    public String toString() {
        // Usamos o super.toString() para pegar a parte comum e adicionamos o específico
        return super.toString() + String.format(" | Cilindradas: %dcc", cilindradas);
    }

    /**
     * Retorna a quantidade de cilindradas da moto.
     *
     * @return quantidade de cilindradas
     */
    public int getCilindradas() {
        return cilindradas;
    }
}