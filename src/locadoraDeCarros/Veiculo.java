package locadoraDeCarros;
import java.time.LocalDate;


public abstract class Veiculo{
    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private int anoFabricacao;


    public Veiculo(String marca, String modelo, String placa, String cor, int anoFabricacao) {
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

    public int getAnoFabricacao() {
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

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

}