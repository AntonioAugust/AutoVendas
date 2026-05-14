package locadoraDeCarros;

public class itemEstoque implements Calculavel{
    private int idItem;
    private Veiculo veiculo;
    private double preco;
    private double taxaEmpresa = 0.10;

    public itemEstoque(Veiculo veiculo, double preco, int idItem){
        this.veiculo = veiculo;
        this.preco = preco;
        this.idItem = idItem;
    }


    @Override
    public double calcularValorFinal(){
        return this.preco + (this.preco * taxaEmpresa);
    }

    public int getIdItem(){
        return this.idItem;
    }
    public Veiculo getVeiculo(){
        return this.veiculo;
    }
    public double getPreco(){
        return this.preco;
    }

}
