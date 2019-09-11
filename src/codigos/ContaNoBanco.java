package codigos;

public class ContaNoBanco {
	public static void main(String[] args) {
		ContaNoBancoBiblioteca p1 = new ContaNoBancoBiblioteca();
		
		p1.setNumConta(100125);
		p1.setDono("Yuri");
		p1.abrirConta("CP");
		p1.depositar(500);
		p1.sacar(650);
		p1.fecharConta();
		
		ContaNoBancoBiblioteca p2 = new ContaNoBancoBiblioteca();
		
		p2.setNumConta(100126);
		p2.setDono("Marialidia");
		p2.abrirConta("CC");
		p2.depositar(300);
		p2.sacar(100);
		
		
		p1.estadoAtual();
		p2.estadoAtual();
	}
}
