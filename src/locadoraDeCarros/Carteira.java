package locadoraDeCarros;

/**
 * Classe que representa a carteira do cliente.
 * Ela armazena o dinheiro disponivel para realizar operacoes no sistema.
 */
public class Carteira {
    private double dinheiro;


    public Carteira(double dinheiroInicial){
        this.dinheiro = dinheiroInicial;
    }


    public void depositar(double quantidade){
        if(quantidade > 0) {
            this.dinheiro += quantidade;
        }
        else{
            System.out.println("Quantidade inválida para deposito");
        }
    }
    /**
     * Remove dinheiro da carteira.
     *
     * @param quantidade valor que sera removido da carteira
     */
    public void remover(double quantidade){
        if((this.dinheiro - quantidade) >= 0){
            this.dinheiro -= quantidade;
        }
        else{
            System.out.println("Você não tem dinheiro o suficiente para essa operação");
        }
    }

    /**
     * Retorna a quantidade de dinheiro disponivel.
     *
     * @return saldo atual da carteira
     */
    public double getDinheiro(){
        return this.dinheiro;
    }
}