package codigos;

import java.util.Scanner;

public class LTP2Utils {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		float valor;
		
		System.out.println("Digite um valor:");
		valor = leia.nextFloat();
		
		System.out.println(LTP2UtilsBiblioteca.formatacaoReal(valor));
		System.out.println(LTP2UtilsBiblioteca.formatacaoDolar(valor));
		System.out.println(LTP2UtilsBiblioteca.formatacaoPercentual(valor));
	}
}

