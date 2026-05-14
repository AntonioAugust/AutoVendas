package locadoraDeCarros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControleClientes {

    private List<Cliente> ControleClientes;

    private int proximoId;

    public ControleClientes(){
        ControleClientes = new ArrayList<>();
        proximoId = 0;
    }

    public void addCliente(String nomeCompleto, String cpf, String endereco, LocalDate nascimentoData, double dinheiroIncial){
        proximoId++;
        ControleClientes.add(new Cliente(nomeCompleto, cpf, endereco, nascimentoData, proximoId, dinheiroIncial));
        System.out.println("✓ Cliente " + proximoId + " cadastrado com sucesso");
    }

    public void removerCliente(int idCliente) {
        for (Cliente v : ControleClientes) {
            if (ControleClientes.isEmpty()) return;
            if (v.getIdCliente() == idCliente) {
                System.out.println(v);
                ControleClientes.remove(v);
                return;
            }
        }
    }

    public Cliente getCliente(int id) {
        for (Cliente c : ControleClientes) {
            if (c.getIdCliente() == id) return c;
        }
        return null;
    }

    public void verCliente(int idCliente){
        for(Cliente v : ControleClientes){
            if(v.getIdCliente() == idCliente){
                System.out.println(v);
                return;
            }
        }
    }

    public void verCliente(LocalDate date){
        for(Cliente v : ControleClientes){
            if(date.isEqual(v.getNascimentoData())){
                System.out.println(v);
            }
        }
    }

}