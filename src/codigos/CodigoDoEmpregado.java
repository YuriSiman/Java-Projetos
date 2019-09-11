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
			System.out.println("Informe o n�mero de pe�as fabricadas:");
			numPecas = leia.nextInt();
		}while(!qtdPecas(numPecas));
		
		do {
			System.out.println("Informe o c�digo do empregado:");
			codigo = leia.next();
		}while(!codigoEmpregado(nome, codigo));
		System.out.println("Sal�rio do empregado: "+df.format(calcSalario(numPecas)));
		
		System.out.println("Deseja Continuar?  [Sim] -- [N�o]");
			if(leia.next().equalsIgnoreCase("N�o")) {
				break;
			}
			leia.nextLine();
		}
		System.out.println("Voc� Saiu!");
		
	}
	public static boolean nomeEmpregado(String nome) {
		if(nome.length()<2) {
			System.out.println("O nome do empregado deve conter no m�nimo 2 caracteres!");
			return false;
		}
		return true;	
	}
	public static boolean qtdPecas(int numPecas) {
		if(numPecas < 1) {
			System.out.println("O n�mero de pe�as deve ser maior que 0!");
			return false;
		}
		return true;
	}
	public static boolean codigoEmpregado(String nome, String codigo) {
		if(codigo.length()!=5) {
			System.out.println("O c�digo deve ser formado por 5 caracteres!");
			return false;
		}else {
			if(!(codigo.substring(0, 2).equalsIgnoreCase(nome.substring(0, 2)))) {
				System.out.println("Os dois primeiros caracteres devem ser iguais �s duas primeiras letras do nome do empregado!");
				return false;
			}else {
				String codigoValidacao = codigo.substring(2);
				try {
					int codigoValidacao2 = Integer.parseInt(codigoValidacao);
				} catch (NumberFormatException e) {
					System.out.println("Os tr�s �ltimos caracteres do c�digo devem ser n�meros!");
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
