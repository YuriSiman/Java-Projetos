package codigos;

import java.util.Scanner;

public class RetirandoEspacos {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		String nome;
		
		System.out.println("Informe um nome completo com espaços entre as palavras:");
		nome = leia.nextLine();
		
		System.out.println(primeiraLetra(eliminarEspacosLaterais(eliminarEspacosInternos(nome))));
		
	}
	public static String primeiraLetra(String nome) {
		nome = (char)(nome.charAt(0)-32)+nome.substring(1);
		return nome;
	}
	public static String eliminarEspacosLaterais(String nome) {
		return nome.trim();	
	}
	public static String eliminarEspacosInternos(String nome) {
		String letra = "";
		int aux = 0;
		for (int i = 0; i < nome.length(); i++) {
			if(!String.valueOf(nome.charAt(i)).equals(" ")) {
				letra += String.valueOf(nome.charAt(i));
				aux = 1;
			}else {
				if(aux > 0) {
					letra += " ";
				}
				aux = 0;
			}
		}
		return letra;
	}
}
