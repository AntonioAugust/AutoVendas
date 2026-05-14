package locadoraDeCarros;

/**
 * Interface usada para indicar que um objeto pode ser locado no sistema.
 * No nosso caso, os veiculos podem ser locados.
 */
public interface Locavel {

    /**
     * Define a disponibilidade do veículo para locação.
     *
     * @param disponivel true se o veículo está disponível, false caso contrário
     */
    void setDisponivel(boolean disponivel);

    /**
     * Verifica se o veículo está disponível para locação.
     *
     * @return true se o veículo está disponível, false caso contrário
     */
    boolean isDisponivel();
}