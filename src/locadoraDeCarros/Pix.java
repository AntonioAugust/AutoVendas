package locadoraDeCarros;

public class Pix extends FormaPagamento{
    private double taxa = 0.95;

    @Override
    public double aplicarTaxa(double valor){
        return valor * this.taxa;
    }

    public void setTaxa(double taxa){
        this.taxa = taxa;
    }

}
