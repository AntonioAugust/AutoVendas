package locadoraDeCarros;

import java.util.ArrayList;
import java.util.List;

public class ControleEstoque {
    private List<Veiculo> ControleEstoque;
    private int proximoId;

    public ControleEstoque(){
        ControleEstoque = new ArrayList<>();
        proximoId = 0;
    }

    public void addVeiculo(Veiculo veiculo){
        proximoId++;
        veiculo.setIdVeiculo(proximoId);
        ControleEstoque.add(veiculo);
        System.out.println("✓ " + veiculo.getTipo() + " adicionado ao estoque - ID: " + veiculo.getIdVeiculo() + " | Disponível: " + veiculo.isDisponivel());
    }

    public Veiculo removerVeiculo(int idVeiculo) {
        for (Veiculo v : ControleEstoque) {
            if (ControleEstoque.isEmpty()) return null;
            if (v.getIdVeiculo() == idVeiculo) {
                //System.out.println(v);
                ControleEstoque.remove(v);
                return v;
            }
        }
        return null;
    }


}