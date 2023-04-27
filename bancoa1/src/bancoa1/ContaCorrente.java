package bancoa1;

public class ContaCorrente {
    private double saldo;
    private int numero;
    private Pessoa cliente;

    public ContaCorrente(int numero, Pessoa cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        } else {
            System.out.println("Valor inválido para depósito.");
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        } else if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
