package codigos;

public class ListaTelefoneBiblioteca {
	public static boolean consistirHora(String hora) {
		int HH = Integer.parseInt(hora.substring(0, 2)); 
		int MM = Integer.parseInt(hora.substring(3, 5));
	if((HH >= 0 && HH <= 23) && (MM >= 0 && MM <= 59)) {
		return true;
	}else {
		System.out.println("O horário informado está incorreto!");
		return false;
	}
		
	}
	public static boolean consistirHoraFinalSendoMaior(String horaInicial, String horaFinal) {
		
		int horaInicialInt = Integer.parseInt(horaInicial.substring(0, 2)+Integer.parseInt(horaInicial.substring(3, 5)));
		int horaFinalInt = Integer.parseInt(horaFinal.substring(0, 2)+Integer.parseInt(horaFinal.substring(3, 5)));
		
		if(horaInicialInt > horaFinalInt) {
			System.out.println("O horário final deve ser maior que o horário inicial!");
			return false;
		}else {
			return true;
		}
		
	}
	public static float totalContaTelefonica(String horaInicial, String horaFinal) {
		float valorLigacao = 0, custo = 0;
		
		int horaInicialInt = Integer.parseInt(horaInicial.substring(0, 2)+Integer.parseInt(horaInicial.substring(3, 5)));
		int horaFinalInt = Integer.parseInt(horaFinal.substring(0, 2)+Integer.parseInt(horaFinal.substring(3, 5)));
		
		if(horaInicialInt >= 0 && horaInicialInt <= 559) {
			custo = 0.10f;
		}else if(horaInicialInt >= 600 && horaInicialInt <= 759) {
			custo = 0.15f;
		}else if(horaInicialInt >= 800 && horaInicialInt <= 1759) {
			custo = 0.20f;
		}else if(horaInicialInt >= 1800 && horaInicialInt <= 2359) {
			custo = 0.25f;
		}
		valorLigacao = custo*horaFinalInt;
		return valorLigacao;
	}
}
