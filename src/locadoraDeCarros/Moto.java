package locadoraDeCarros;


public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, String placa, String cor, int anoFabricacao, int cilindradas) {
        super(marca, modelo, placa, cor, anoFabricacao);
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        // Usamos o super.toString() para pegar a parte comum e adicionamos o específico
        return super.toString() + String.format(" | Cilindradas: %dcc", cilindradas);
    }

    public int getCilindradas() {
        return cilindradas;
    }
}
