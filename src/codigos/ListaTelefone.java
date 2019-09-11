package codigos;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ListaTelefone {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$ #,#00.00");
		
		String horaInicial = null, horaFinal = null;
		float somaCusto = 0;
		
		do {
			do {
				do {
		System.out.println("Insira as horas no formato HH:mm");
		System.out.println("Horário Inicial:");
		horaInicial = leia.next();

				}while(!ListaTelefoneBiblioteca.consistirHora(horaInicial));
		
				do {
		System.out.println("Hora Final:");
		horaFinal = leia.next();
		
				}while(!ListaTelefoneBiblioteca.consistirHora(horaFinal));
			}while(!ListaTelefoneBiblioteca.consistirHoraFinalSendoMaior(horaInicial, horaFinal));
		
		System.out.println("Custo: "+df.format(ListaTelefoneBiblioteca.totalContaTelefonica(horaInicial, horaFinal)));
		
		somaCusto += ListaTelefoneBiblioteca.totalContaTelefonica(horaInicial, horaFinal);
		
		System.out.println("Deseja Continuar?  [Sim] -- [Não]");
		if(leia.next().equalsIgnoreCase("Não")) {
			break;
		}
		}while(true);
		System.out.println("Você Saiu!");
		System.out.println("Total da Conta Telefônica: "+df.format(somaCusto));
	}
}
