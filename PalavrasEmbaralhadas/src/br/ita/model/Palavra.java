package br.ita.model;

public class Palavra {

	private String nome;
	private boolean lida;
	
	public Palavra(String nome) {
		super();
		this.nome = nome;
		this.lida = false;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public boolean foiLida(){
		if(this.lida){
			return true;
		} else {
			return false;
		}
	}
	
	public void descartar(){
		this.lida = true;
	}
	
}
