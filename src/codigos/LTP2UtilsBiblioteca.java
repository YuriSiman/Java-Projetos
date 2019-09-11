package codigos;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LTP2UtilsBiblioteca {
private static Scanner leia = new Scanner(System.in);
	private static DecimalFormat real = new DecimalFormat("R$ #,##0.00");
	private static DecimalFormat dolar = new DecimalFormat("US$ #,##0.00");
	private static DecimalFormat perc = new DecimalFormat("0.00'%'");

	public static int getInt(String texto) {
		int valor = 0;
		boolean validar;
		do {
			try {
				validar = true;
				System.out.println(texto);
				valor = leia.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Voc� inseriu uma letra");
				validar = false;
				limparBuffer();
			}
		} while (!validar);

		return valor;
	}

	public static int getIntPositivo(String texto) {

		int valor;

		do {
			try {				
				valor = getInt(texto);
				if (valor < 0) {
					System.err.println("O valor informado deve ser positivo!");
				}
			} catch (InputMismatchException e) {
				System.err.println("Voc� inseriu uma letra");
				valor = -1; // Para for�ar voltar no loop
				limparBuffer();
			}
		} while (valor < 0);

		return valor;
	}
	
	public static float getFloatPositivo(String texto) {

		float valor;

		do {
			try {				
				valor = getFloat(texto);
				if (valor < 0) {
					System.err.println("O valor informado deve ser positivo!");
				}
			} catch (InputMismatchException e) {
				System.err.println("Voc� inseriu uma letra");
				valor = -1; // Para for�ar voltar no loop
				limparBuffer();
			}
		} while (valor < 0);

		return valor;
	}

	public static float getFloat(String texto) {
		float valor = 0;
		boolean validar;
		do {
			try {
				validar = true;
				System.out.println(texto);
				valor = leia.nextFloat();
			} catch (InputMismatchException e) {
				System.err.println("Voc� inseriu uma letra");
				validar = false;
				limparBuffer();
			}
		} while (!validar);

		return valor;
	}

	public static String formatacaoReal(float valor) {
		return real.format(valor);
	}

	public static String formatacaoDolar(float valor) {
		return dolar.format(valor);
	}

	public static String formatacaoPercentual(float valor) {
		return perc.format(valor);
	}

	public static void limparBuffer() {
		leia.nextLine();
	}

	public static char getChar(String texto) {
		System.out.print(texto);
		return leia.next().charAt(0);
	}

	public static char getCharUpperCase(String texto) {
		System.out.print(texto);
		return leia.next().toUpperCase().charAt(0);
	}

	public static String getString(String texto) {
		String valor = "";

		System.out.println(texto);
		valor = leia.nextLine();

		if (!valor.equals("")) {
			return valor;
		} else {
			// Para caso o buffer tiver cheio (Limpar o buffer)
			return leia.nextLine();
		}
	}

	public static char recebeSouN(String texto) {
		char opcao;
		do {
			opcao = getCharUpperCase(texto);
			if (opcao != 'S' && opcao != 'N') {
				System.out.println("Voc� deve informar S ou N");
			}
		} while (opcao != 'S' && opcao != 'N');

		return opcao;
	}
	
	public static boolean confirmarSaida() {

		if (recebeSouN("Deseja sair (S/N): ") == 'S') {
			return true;
		} else {
			return false;
		}

	}

	public static boolean validarNumeroPositivoInt(int valor) {
		return (valor >= 0) ? true : false; // Tern�rio
	}

	public static boolean validarNumeroPositivoFloat(float valor) {
		return (valor >= 0) ? true : false; // Tern�rio
	}

	public static float getFloatEntreIntervalos(String texto, float menor, float maior) {
		float valor;

		do {
			valor = getFloat(texto);
			if (valor < menor || valor > maior) {
				System.err.println("O valor deve estar entre " + menor + " e " + maior);
			}
		} while (valor < menor || valor > maior);

		return valor;
	}
	
	public static int getIntEntreIntervalos(String texto, int menor, int maior) {
		int valor;

		do {
			valor = getInt(texto);
			if (valor < menor || valor > maior) {
				System.err.println("O valor deve estar entre " + menor + " e " + maior);
			}
		} while (valor < menor || valor > maior);

		return valor;
	}

	public static String retirarEspacoInicio(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) != ' ') {
				return texto.substring(i);
			}
		}
		return texto;
	}

	public static String retirarEspacoFim(String texto) {
		for (int i = texto.length() - 1; i >= 0; i--) {
			if (texto.charAt(i) != ' ') {
				return texto.substring(0, i+1);
			}
		}
		return texto;
	}

	public static String retirarEspacosDuplicados(String texto) {
		do {
			texto = texto.replace("  ", " ");
		} while (texto.contains("  "));
		
		return texto;
	}
	
	public static String capitalize(String texto) {
		// Trocar todo o texto para minusculo
		texto = texto.toLowerCase();

		// Vari�vel Auxiliar
		String novoTexto = "";

		// Pega a primeira letra, converte na tabela ASCII
		// e depois faz o typecast para mostrar a letra novamente
		novoTexto += (char) (texto.charAt(0) - 32);

		for (int i = 1; i < texto.length(); i++) {
			if (texto.charAt(i - 1) == ' ') {
				//Se o caracter a ser convertido n�o for letra, n�o realiza a convers�o para mai�sculo
				novoTexto += (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') ? (char) (texto.charAt(i) - 32)
						: texto.charAt(i);
			} else {
				novoTexto += texto.charAt(i);
			}
		}

		return novoTexto;
	}

	public static String captalizeReservedWord(String texto) {
		String newText = capitalize(texto);
		
		newText = newText.replace(" De ", " de ");
		newText = newText.replace(" Da ", " da ");
		newText = newText.replace(" Pelo ", " pelo ");
		newText = newText.replace(" Em ", " em ");
		newText = newText.replace(" E ", " e ");
		newText = newText.replace(" Ou ", " ou ");
		newText = newText.replace(" As ", " as ");
		newText = newText.replace(" Os ", " os ");
		newText = newText.replace(" Dos ", " dos ");
		
		return newText;
	}
	
	public static boolean converterSouNParaBoolean(char c) {
		if (c == 'S' || c == 's') {
			return true;
		} else {
			return false;
		}
	}

	public static char converterBooleanParaSouN(boolean b) {
		if (b == true) {
			return 'S';
		} else {
			return 'N';
		}
	}
}
