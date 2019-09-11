package codigos;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CodigoDoEmpregado {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		
		String nome,codigo;
		int numPecas;
		
		for (int i = 0; i < 100; i++) {	
		do {
			System.out.println("Informe o nome do empregado:");
			nome = leia.nextLine();
		}while(!nomeEmpregado(nome));
		
		do {
			System.out.println("Informe o número de peças fabricadas:");
			numPecas = leia.nextInt();
		}while(!qtdPecas(numPecas));
		
		do {
			System.out.println("Informe o código do empregado:");
			codigo = leia.next();
		}while(!codigoEmpregado(nome, codigo));
		System.out.println("Salário do empregado: "+df.format(calcSalario(numPecas)));
		
		System.out.println("Deseja Continuar?  [Sim] -- [Não]");
			if(leia.next().equalsIgnoreCase("Não")) {
				break;
			}
			leia.nextLine();
		}
		System.out.println("Você Saiu!");
		
	}
	public static boolean nomeEmpregado(String nome) {
		if(nome.length()<2) {
			System.out.println("O nome do empregado deve conter no mínimo 2 caracteres!");
			return false;
		}
		return true;	
	}
	public static boolean qtdPecas(int numPecas) {
		if(numPecas < 1) {
			System.out.println("O número de peças deve ser maior que 0!");
			return false;
		}
		return true;
	}
	public static boolean codigoEmpregado(String nome, String codigo) {
		if(codigo.length()!=5) {
			System.out.println("O código deve ser formado por 5 caracteres!");
			return false;
		}else {
			if(!(codigo.substring(0, 2).equalsIgnoreCase(nome.substring(0, 2)))) {
				System.out.println("Os dois primeiros caracteres devem ser iguais às duas primeiras letras do nome do empregado!");
				return false;
			}else {
				String codigoValidacao = codigo.substring(2);
				try {
					int codigoValidacao2 = Integer.parseInt(codigoValidacao);
				} catch (NumberFormatException e) {
					System.out.println("Os três últimos caracteres do código devem ser números!");
					return false;
				}
			}
			return true;
		}
	}
	public static float calcSalario(int numPecas) {
		float salario = 0;
		if(numPecas > 0 && numPecas < 201) {
			salario = numPecas*2f;
		}else if(numPecas > 200 && numPecas < 401) {
			salario = numPecas*2.30f;
		}else if(numPecas > 400) {
			salario = numPecas*2.50f;
		}
		return salario;
	}
}	
