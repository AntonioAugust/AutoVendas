package locadoraDeCarros;
import java.time.LocalDate;


public abstract class Veiculo implements Comercializavel {
    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private LocalDate anoFabricacao;


    public Veiculo(String marca, String modelo, String placa, String cor, LocalDate anoFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
    }


    @Override
    public String toString() {
        return String.format("| Marca: %s | Modelo: %s | Placa: %s | Cor: %s",
                marca, modelo, placa, cor);
    }


    @Override
    public abstract double calcularValorFinal();

    public abstract String getTipo();


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

}