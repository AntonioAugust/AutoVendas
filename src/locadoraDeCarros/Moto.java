package locadoraDeCarros;

import java.time.LocalDate;


public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, LocalDate anoFabricacao, String placa, double precoBase, String cor, int cilindradas) {
        super(marca, modelo, placa, cor, anoFabricacao);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularValorFinal() {
        return getPreco() + (getPreco()* 0.03);
    }

    @Override
    public String getTipo(){
        return "Moto";
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
