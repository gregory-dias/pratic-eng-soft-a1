package bancoa1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(new BancoController());
        boolean executando = true;
        Map<Integer, ContaCorrente> contas = new HashMap<>();
        LocalDateTime dataHoraAtual = LocalDateTime.now();

        System.out.println("<<Bem-vindo ao BuNank>>");
        System.out.println("\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Olá, eu me chamo é R2D2 e sou assiste virtual da BuNank!!!");
        System.out.println("("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Eu irei lhe ajudar nas suas operações bancárias!! Vamos lá?!! :D");

        while (executando) {
        	System.out.println("\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Digite a opção desejada:");
            System.out.println("\n[1] Abrir conta");
            System.out.println("[2] Depositar");
            System.out.println("[3] Sacar");
            System.out.println("[4] Saldo");
            System.out.println("[5] Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    atm.abrirConta();
                    break;
                case 2:
                    System.out.println("Digite o número da conta:");
                    int numConta = scanner.nextInt();
                    ContaCorrente contaDeposito = atm.getController().buscarConta(numConta);
                    if (contaDeposito == null) {
                    	System.out.println("\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Poxa... :("
                    			+ "\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Infelizmente, não foi possível concluir o deposito, pois não localizei a conta informada."
                    			+ "\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Por favor, tente novamente. "
                    			+ "Mas caso precise, você também pode abrir sua conta com a gente! :D");
                        break;
                    }
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDeposito = scanner.nextDouble();
                    if (contaDeposito.depositar(valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso!");
                    }
                    break;

                case 3:
                    System.out.println("Digite o número da conta:");
                    int numContaSaque = scanner.nextInt();
                    ContaCorrente contaSaque = atm.getController().buscarConta(numContaSaque);
                    if (contaSaque == null) {
                    	System.out.println("\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Mas que $%$#@@... >:("
                    			+ "\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Infelizmente, não foi possível concluir o saque, pois não localizei a conta informada."
                    			+ "\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Por favor, tente novamente. "
                    			+ "Mas caso precise, você também pode abrir sua conta com a gente! :D");
                    	break;
                    }
                    System.out.println("Digite o valor a ser sacado:");
                    double valorSaque = scanner.nextDouble();
                    if (contaSaque.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;

                case 4:
                    System.out.println("Digite o número da conta:");
                    int numContaSaldo = scanner.nextInt();
                    ContaCorrente contaSaldo = atm.getController().buscarConta(numContaSaldo);
                    if (contaSaldo == null) {
                    	System.out.println("\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Será que programaram esse sistema certo? (._. )'"
                    			+ "\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Infelizmente, não localizei a conta informada."
                    			+ "\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: Por favor, tente novamente. "
                    			+ "Mas caso precise, você também pode abrir sua conta com a gente! :D");
                    	break;
                    }
                    System.out.println("Saldo: R$" + contaSaldo.getSaldo());
                    break;
                case 5:
                    executando = false;
                    break;
                default:
                    System.out.println("\n("+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+") [R2D2]: É de 1 à 5, jovem... (-.- )");
                    break;
            }
        }
    }
}
