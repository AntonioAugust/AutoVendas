package locadoraDeCarros;

public abstract class FormaPagamento {
    private String nomeFormaPagamento;

    public abstract double aplicarTaxa(double valor);

    public String getNome(){
        return nomeFormaPagamento;
    }
    public void setNome(String nome){
        this.nomeFormaPagamento = nome;
    }

    @Override
    public String toString(){
        return nomeFormaPagamento;
    }
}
