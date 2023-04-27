package bancoa1;
import java.util.ArrayList;
import java.util.List;

public class BancoController {
    private int proximoNumeroConta = 1;
    private List<ContaCorrente> contas = new ArrayList<>();

    public void abrirConta(Pessoa cliente) {
        ContaCorrente conta = new ContaCorrente(proximoNumeroConta++, cliente);
        contas.add(conta);
        System.out.println("Conta aberta para " + cliente.getNome() + " com número " + conta.getNumero());
    }

    public ContaCorrente buscarConta(int numeroConta) {
        for (ContaCorrente conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
