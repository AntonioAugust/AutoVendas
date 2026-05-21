package autovendas;

public class Carro extends Veiculo {

    public enum TipoCombustivel {
        gasolina, alcool, flex, diesel, eletrico
    }
    private int quantidadePortas;

    private TipoCombustivel combustivel;

    public Carro(String marca, String modelo, String placa, String cor, int anoFabricacao, int quantidadePortas, TipoCombustivel combustivel) {
        super(marca, modelo, placa, cor, anoFabricacao);
        this.quantidadePortas = quantidadePortas;
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Portas: %d | Combustivel: %s", quantidadePortas, combustivel);
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
    public TipoCombustivel getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(TipoCombustivel combustivel) {
        this.combustivel = combustivel;
    }
}
