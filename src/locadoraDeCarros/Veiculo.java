package locadoraDeCarros;

import java.time.LocalDate;

/**
 * Classe abstrata que representa a base de um veículo no sistema.
 * Ela define os atributos e comportamentos comuns a todos os veículos.
 */
public abstract class Veiculo implements Locavel {
    private int idVeiculo;
    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private LocalDate anoFabricacao;
    private double precoBase;
    private boolean disponivel;

    /**
     * Construtor da classe Veiculo.
     *
     * @param marca marca do veículo
     * @param modelo modelo do veículo
     * @param placa placa do veículo
     * @param cor cor do veículo
     * @param anoFabricacao data de fabricação do veículo
     * @param precoBase valor base do veículo
     */
    public Veiculo(String marca, String modelo, String placa, String cor, LocalDate anoFabricacao, double precoBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.precoBase = precoBase;
        this.disponivel = true;
    }

    /**
     * Método abstrato que retorna o tipo do veículo.
     * Deve ser implementado pelas subclasses para identificar o tipo específico (Ex: Carro, Moto).
     *
     * @return tipo do veículo
     */
    public abstract String getTipo();

    /**
     * Retorna uma representação em String do veículo.
     * Utiliza o polimorfismo através do método getTipo().
     *
     * @return dados formatados do veículo
     */
    @Override
    public String toString() {
        return String.format("ID: %d | [%s] %s %s | Placa: %s | Cor: %s | Preço: R$ %.2f",
                idVeiculo, getTipo(), marca, modelo, placa, cor, precoBase);
    }

    /**
     * Define a disponibilidade do veículo para locação.
     * Implementa o método da interface Locavel.
     *
     * @param disponivel true se o veículo está disponível, false caso contrário
     */
    @Override
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Verifica se o veículo está disponível para locação.
     * Implementa o método da interface Locavel.
     *
     * @return true se o veículo está disponível, false caso contrário
     */
    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    public double getPreco() {
        return precoBase;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAnoFabricacao(LocalDate anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public void setPreco(double precoBase) {
        this.precoBase = precoBase; //permite alterar o preco do veiculo apos ter sido criado
    }
}