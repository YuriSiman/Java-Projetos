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
		System.out.println("Hor�rio Inicial:");
		horaInicial = leia.next();

				}while(!ListaTelefoneBiblioteca.consistirHora(horaInicial));
		
				do {
		System.out.println("Hora Final:");
		horaFinal = leia.next();
		
				}while(!ListaTelefoneBiblioteca.consistirHora(horaFinal));
			}while(!ListaTelefoneBiblioteca.consistirHoraFinalSendoMaior(horaInicial, horaFinal));
		
		System.out.println("Custo: "+df.format(ListaTelefoneBiblioteca.totalContaTelefonica(horaInicial, horaFinal)));
		
		somaCusto += ListaTelefoneBiblioteca.totalContaTelefonica(horaInicial, horaFinal);
		
		System.out.println("Deseja Continuar?  [Sim] -- [N�o]");
		if(leia.next().equalsIgnoreCase("N�o")) {
			break;
		}
		}while(true);
		System.out.println("Voc� Saiu!");
		System.out.println("Total da Conta Telef�nica: "+df.format(somaCusto));
	}
}
