package autovendas;

public class Pix extends FormaPagamento{
    private double desconto = 0.95;

    public Pix(){
        setNome("Pix");
    }

    @Override
    public double aplicarTaxa(double valor){
        return valor * this.desconto;
    }

    public void setDesconto(double desconto){
        if (desconto <= 0 || desconto > 1){
            throw new IllegalArgumentException("Desconto invalido. O desconto do Pix deve ser um fator entre 0.01 e 1.0");
        }
        this.desconto = desconto;
    }

}
