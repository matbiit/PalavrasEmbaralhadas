package br.ita.core;

import java.io.IOException;

import br.ita.util.BancoDePalavras;

public abstract class MecanicaDoJogo {
	
	protected Embaralhador embaralhador;
	protected String palavra;
	protected int totalPontos = 0;

	public abstract boolean fimDeJogo();

	public String getPalavra() throws IOException{
		this.palavra = BancoDePalavras.getPalavraAleatoria();
		return embaralhador.embaralhar(this.palavra);
	}
	
	public abstract boolean validarPalavra(String palavra);
	
	public int calcularPontosDaPalavra(String palavra){
		return palavra.length()-1;
	}
	
	public void somarPontos(int pontos){
		this.totalPontos += pontos;
	}
	
	public int getTotalDePontos(){
		return this.totalPontos;
	}
}
