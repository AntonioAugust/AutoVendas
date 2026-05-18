package locadoraDeCarros;

public class CartaoCredito extends FormaPagamento{
    private int parcelas;
    private double juros = 0.5;

    public CartaoCredito(int parcelas){
        if(parcelas > 12 || parcelas < 1){
            throw new IllegalArgumentException("Numero de parcelas inválido");
        }
        setNome("Cartão de Crédito");
        this.parcelas = parcelas;
    }

    @Override
    public double aplicarTaxa(double valor){
        double taxaJuros = (parcelas * juros) / 100;
        return valor * (1 + taxaJuros);
    }
}
