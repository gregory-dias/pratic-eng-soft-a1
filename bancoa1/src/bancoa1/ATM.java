package bancoa1;
import java.util.Scanner;

public class ATM {
    private BancoController controller;

    public ATM(BancoController ctrl) {
        this.controller = ctrl;
    }

    public void abrirConta() {
        System.out.println("Abrindo conta...");
        System.out.println("Digite o nome do cliente:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        Pessoa cliente = new Pessoa(nome);
        controller.abrirConta(cliente);
    }
    
    public BancoController getController() {
        return controller;
    }
}
