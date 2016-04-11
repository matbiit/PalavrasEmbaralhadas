package br.ita.core;


import br.ita.factory.FabricaEmbaralhadores;

public class MecanicaDoJogoDezPalavras extends MecanicaDoJogo {

	
	private int quantidadePalavras = 0;
	
	public MecanicaDoJogoDezPalavras(){
		FabricaEmbaralhadores fabricaEmb = new FabricaEmbaralhadores();
		embaralhador = fabricaEmb.getEmbaralhador();

	}
	
	@Override
	public boolean fimDeJogo() {
		return this.quantidadePalavras == 10 ? true : false;
	}


	@Override
	public boolean validarPalavra(String palavra) {
		boolean acertou = this.palavra.equals(palavra.toUpperCase());
		if(acertou){
			somarPontos(calcularPontosDaPalavra(palavra));
		}
		this.quantidadePalavras++;
		return acertou;
	}


}
