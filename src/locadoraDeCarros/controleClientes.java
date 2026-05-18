package locadoraDeCarros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class controleClientes {

    private List<Cliente> controleClientes;

    private int proximoId;

    public controleClientes(){
        controleClientes = new ArrayList<>();
        proximoId = 0;
    }

    public void addCliente(String nomeCompleto, String cpf, String endereco, LocalDate nascimentoData, double dinheiroInicial){
        proximoId++;
        controleClientes.add(new Cliente(nomeCompleto, cpf, endereco, nascimentoData, proximoId, dinheiroInicial));
    }

    public void removerCliente(int idCliente) {
        for (Cliente v : controleClientes) {
            if (controleClientes.isEmpty()) return;
            if (v.getIdCliente() == idCliente) {
                System.out.println(v);
                controleClientes.remove(v);
                return;
            }
        }
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : controleClientes) {
            if (c.getIdCliente() == id) return c;
        }
        return null;
    }


    public void verCliente(int idCliente){
        for(Cliente v : controleClientes){
            if(v.getIdCliente() == idCliente){
                System.out.println(v);
                return;
            }
        }
    }

    public void verCliente(LocalDate date){
        for(Cliente v : controleClientes){
            if(date.isEqual(v.getNascimentoData())){
                System.out.println(v);
            }
        }
    }


}
