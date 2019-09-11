package codigos;

import java.util.Scanner;

public class ValidacaoCPF {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		String cpf;
		
		do {
			do {
		System.out.println("Digite um CPF:");
		cpf = leia.next();
			}while(!validacaoDosDigitos(cpf));
		
		System.out.println("Primeiro D�gito Verificador: "+primeiroDigitoVerificador(cpf)+"\nSegundo D�gito Verificador: "+segundoDigitoVerificador(cpf)+"\n"+validacaoDoCPF(cpf));
		System.out.println("Deseja Continuar?  [SIM] --  [N�O]");
		}while(leia.next().equalsIgnoreCase("Sim"));
		System.out.println("Voc� saiu!");
		leia.close();
	}
	public static boolean validacaoDosDigitos(String cpf) {
		if(cpf.length()!=11) {
			System.out.println("Digite 11 d�gitos!");
			return false;
		}else {
			if(cpf.equalsIgnoreCase("00000000000")||cpf.equalsIgnoreCase("11111111111")) {
				System.out.println("CPF Inv�lido!");
				return false;
			}else {
				try {
					long x = Long.parseLong(cpf);
				} catch (NumberFormatException e) {
					System.out.println("CPF Inv�lido! Digite apenas n�meros!");
					return false;
				}
			}
		}
		return true;
	}
	public static int primeiroDigitoVerificador(String cpf) {
		int soma = 0, dvf;
		for (int i = 0, peso = 10; i < 9; i++, peso--) {
			soma += (cpf.charAt(i)-48)*peso;
		}
		if(soma%11<2) {
			dvf = 0;
		}else {
			dvf = 11-(soma%11);
		}
		return dvf;
	}
	public static int segundoDigitoVerificador(String cpf) {
		int soma = 0,dvf;
		for (int i = 0, peso = 11; i < 10; i++, peso--) {
			soma += (cpf.charAt(i)-48)*peso;
		}
		if(soma%11<2) {
			dvf = 0;
		}else {
			dvf = 11-(soma%11);
		}
		return dvf;
	}
	public static String validacaoDoCPF(String cpf) {
		if((cpf.charAt(9)-48) == primeiroDigitoVerificador(cpf)&&(cpf.charAt(10)-48) == segundoDigitoVerificador(cpf)) {
			return "CPF V�lido!";
		}else {
			return "CPF Inv�lido!";
		}
	}
}
