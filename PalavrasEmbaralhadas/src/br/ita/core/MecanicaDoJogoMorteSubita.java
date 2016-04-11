package br.ita.core;


import br.ita.factory.FabricaEmbaralhadores;

public class MecanicaDoJogoMorteSubita extends MecanicaDoJogo {

	private boolean errou = false;
	
	public MecanicaDoJogoMorteSubita(){
		FabricaEmbaralhadores fabricaEmb = new FabricaEmbaralhadores();
		embaralhador = fabricaEmb.getEmbaralhador();

	}
	
	@Override
	public boolean fimDeJogo() {
		return this.errou;
	}


	@Override
	public boolean validarPalavra(String palavra) {
		boolean acertou = this.palavra.equals(palavra.toUpperCase());
		if(acertou){
			somarPontos(calcularPontosDaPalavra(palavra));
		} else {
			this.errou = true;
		}
		return acertou;
	}


}
