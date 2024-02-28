package gerenciaBanco;
import java.util.Scanner;

public class BancoApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Banco banco = new Banco();
		boolean continuar = true;
		
		System.out.println("\u001B[36mBem-Vindo ao Banco!!!\u001B[0m");
		
		while (continuar) {
			exibirMenu();
			int escolha = scanner.nextInt();
			scanner.nextLine(); //Limpar o buffer
			
			switch (escolha ) {
			    case 1:
			    	banco.informarDados(scanner);
			    	break;
			    case 2:
			    	banco.consultarSaldo();
			    	break;
			    case 3:
			    	banco.depositar(scanner);
			    	break;
			    case 4:
			    	banco.sacar(scanner);
			    	break;
			    case 5:
			    	continuar = false;
			    	break;
			    default:
			    	System.out.println("\u001B[31mEscolha invalida!!!\u001B[0m");
			    
			}
		}
		
		System.out.println("\u001B[36mObrigado por ultilizar nossos serviços bancários. Até logo!\u001B[0m");	
	}
	public static void exibirMenu() {
		System.out.println("Escolha uma opção:");
		System.out.println("\u001B[33m1. Informar dados pessoais\u001B[0m");
		System.out.println("\u001B[33m2. Consultar saldo\u001B[0m");
		System.out.println("\u001B[33m3. Realizar depósito\u001B[0m");
		System.out.println("\u001B[33m4. Realizar saque\u001B[0m");
		System.out.println("\u001B[33m5. Encerrar\u001B[0m");
	}
}
class Banco {
	private String nome;
	private String sobrenome;
	private String cpf;
	private double saldo;
	
	public void informarDados(Scanner scanner) {
		System.out.println("Informe seu nome: ");
		this.nome = scanner.nextLine();
		System.out.println("Informe seu sobrenome: ");
		this.sobrenome = scanner.nextLine();
		System.out.println("Informe seu CPF: ");
		this.cpf = scanner.nextLine();
		System.out.println("\u001B[32mDados informados com sucesso!\u001B[0m");	
	}
	
	public void consultarSaldo() {
		System.out.println("\u001B[32mSaldo atual: R$" + this.saldo + "\u001B[0m");	
	}
	
	public void depositar(Scanner scanner) {
		System.out.println("Informe o valor a ser depositado:");
		double valor = scanner.nextDouble();
		this.saldo += valor;
		System.out.println("\u001B[32mDepósito realizado com sucesso!!!\u001B[0m");	
	}
	
	public void sacar(Scanner scanner) {
		System.out.println("Informe o valor a ser sacado: ");
		double valor = scanner.nextDouble();
		if (valor > this.saldo) {
			System.out.println("\u001B[31mSaldo insuficiente!\u001B[0m");
		} else {
			this.saldo -= valor;
			System.out.println("\u001B[32mSaque realizado com sucesso!!!\u001B[0m");	
		}
	}
}