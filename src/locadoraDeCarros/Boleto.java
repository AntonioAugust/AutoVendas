package locadoraDeCarros;

public class Boleto extends FormaPagamento{

    private double desconto = 0.97;

    public Boleto(){
        setNome("Boleto");
    }

    @Override
    public double aplicarTaxa(double valor){

        return valor * this.desconto;
    }

    public void setDesconto(double desconto){
        this.desconto = desconto;
    }
}
