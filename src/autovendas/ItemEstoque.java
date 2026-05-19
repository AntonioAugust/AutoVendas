package autovendas;

public class ItemEstoque implements Calculavel{
    private int idItem;
    private Veiculo veiculo;
    private double preco;
    private double taxaEmpresa = 0.10;

    public ItemEstoque(Veiculo veiculo, double preco, int idItem){
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

    public void setTaxaEmpresa(double taxaEmpresa) {
        if (taxaEmpresa < 0){
            throw new IllegalArgumentException("A taxa de empresa não pode sernegativa");
        }
        this.taxaEmpresa = taxaEmpresa;
    }
}
