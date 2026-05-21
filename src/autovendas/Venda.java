package autovendas;

import java.time.LocalDate;

public class Venda implements Calculavel{
    private final int idVenda;
    private final LocalDate data;
    private final double valorFinal;
    private final FormaPagamento formaPagamento;
    private final ItemEstoque itemVendido;

    // Snapshots (Strings que não mudam mais)
    private  final String snapshotVeiculo;
    private final String snapshotCliente;

    public Venda(int idVenda, Cliente cliente, FormaPagamento formaPagamento, ItemEstoque itemVendido) {
        if (cliente == null || formaPagamento == null || itemVendido == null) {
            throw new IllegalArgumentException("A venda não pode ser iniciada com dados nulos");
        }

        this.idVenda = idVenda;
        this.formaPagamento = formaPagamento;
        this.data = LocalDate.now();
        this.itemVendido = itemVendido;
        this.valorFinal = calcularValorFinal();
        this.snapshotVeiculo = String.format(
                """
                ID Item: %d
                Veículo: %s
                Preço: %.2f
                """,
                itemVendido.getIdItem(),
                itemVendido.getVeiculo().toString(),
                itemVendido.getPreco()
        );

        this.snapshotCliente = String.format("ID: %d | Nome: %s | CPF: %s",
                cliente.getIdCliente(),
                cliente.getNomeCompleto(),
                cliente.getCpf());
    }

    @Override
    public double calcularValorFinal(){
        return formaPagamento.aplicarTaxa(itemVendido.calcularValorFinal());
    }
    // classe interna privada que só existe na venda
    private class Recibo {
        public String formatar() {
            return "--- RECIBO DE VENDA #" + idVenda + " ---" +
                    "\nData: " + data +
                    "\nCliente: " + snapshotCliente +
                    "\nVeículo: " + snapshotVeiculo +
                    "\nValor Pago: R$ " + String.format("%.2f", valorFinal) +
                    "\nForma de Pagamento: " + formaPagamento.getNome() +
                    "\n----------------------------";
        }
    }

    @Override
    public String toString() {
        Recibo recibo = new Recibo();
        return recibo.formatar();
    }

    public int getIdVenda() {
        return idVenda;
    }

    public LocalDate getDate() {
        return data;
    }

}
