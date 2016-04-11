package br.ita.factory;

import br.ita.core.MecanicaDoJogo;
import br.ita.core.MecanicaDoJogoDezPalavras;
import br.ita.core.MecanicaDoJogoMorteSubita;
import br.ita.core.TipoDeJogo;

public class FabricaMecanicaDoJogo {

	public MecanicaDoJogo getMecanicaDoJogo(TipoDeJogo tipo){
		if(tipo == TipoDeJogo.MORTE_SUBITA){
			return new MecanicaDoJogoMorteSubita();
		} else {
			return new MecanicaDoJogoDezPalavras();
		}
	}
	
}
