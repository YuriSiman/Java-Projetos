package codigos;

import java.text.DecimalFormat;

public class ContaNoBancoBiblioteca {
	DecimalFormat df = new DecimalFormat("R$ #,###.##");
	
	public int numConta;
	protected String tipo;
	private String dono;
	private float saldo, depositarValor, sacarValor;
	private boolean status;
	
	
	public ContaNoBancoBiblioteca() {
		this.setStatus(false);
		this.setSaldo(0);
	}
	
	public void estadoAtual() {
		System.out.println("----------------------------------------------------");
		System.out.println("Conta: "+this.getNumConta()+"\nTipo: "+this.getTipo()+"\nDono: "+this.getDono()+"\nSaldo: "+this.getSaldo()+"\nStatus: "+this.getStatus());
	}
	
	public void abrirConta(String tipo) {
		this.tipo = tipo;
		this.setTipo(this.tipo);
		if(this.tipo.equalsIgnoreCase("CC")) {
			this.setStatus(true);
			this.setSaldo(50);
			System.out.println("Conta "+this.getNumConta()+" aberta com sucesso!");
		}else if(this.tipo.equalsIgnoreCase("CP")){
			this.setStatus(true);
			this.setSaldo(150);
			System.out.println("Conta "+this.getNumConta()+" aberta com sucesso!");
		}else {
			this.setStatus(false);
			System.out.println("Não é possível fazer essa operação! Verifique o tipo de conta informado.");
		}
	}

	public void fecharConta() {
		if(this.getSaldo() == 0) {
			this.setStatus(false);
			System.out.println("Conta "+this.getNumConta()+" fechada com sucesso!");
		}else if(this.getSaldo() > 0){
			this.setStatus(true);
			System.out.println("Não é possível fazer essa operação! Existe saldo em sua conta.");
		}
	}
	
	public void depositar(float depositarValor) {
		this.depositarValor = depositarValor;
		if(this.getStatus() == true) {
			this.setSaldo(this.getSaldo()+this.depositarValor);
			System.out.println("Valor Depositádo: "+df.format(this.depositarValor)+"\nSaldo Atual: "+df.format(this.getSaldo()));
		}else {
			System.out.println("Não é possível fazer essa operação! Verifique se você possui uma conta aberta.");
		}
	}
	
	public void sacar(float sacarValor) {
		this.sacarValor = sacarValor;
		if(this.getStatus() == true && this.getSaldo() > 0 && this.sacarValor <= this.getSaldo()) {
			this.setSaldo(this.getSaldo() - this.sacarValor);
			System.out.println("Valor Sacado: "+df.format(this.sacarValor)+"\nSaldo Atual: "+df.format(this.saldo));
		}else {
			System.out.println("Não é possível fazer essa operação! Valor a sacar é maior que o saldo atual.");
		}
	}
	
	public void pagarMensalidade() {
		if(this.getTipo().equalsIgnoreCase("CC")) {
			this.setSaldo(getSaldo()-12);
		}else if(this.getTipo().equalsIgnoreCase("CP")) {
			this.setSaldo(getSaldo()-20);
		}else {
			System.out.println("Não é possível fazer essa operação! Verifique o tipo de conta informado.");
		}
	}
	
	public int getNumConta() {
		return numConta;
	}
	
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDono() {
		return dono;
	}
	
	public void setDono(String dono) {
		this.dono = dono;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
