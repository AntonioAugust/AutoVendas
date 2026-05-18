package locadoraDeCarros;

public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String marca, String modelo,String placa, String cor, int anoFabricacao, int quantidadePortas) {
        super(marca, modelo, placa, cor, anoFabricacao);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Portas: %d", quantidadePortas);
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}
