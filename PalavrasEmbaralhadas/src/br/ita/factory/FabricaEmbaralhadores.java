package br.ita.factory;

import java.util.ArrayList;
import java.util.Random;

import br.ita.core.Embaralhador;
import br.ita.core.EmbaralhadorAleatorio;
import br.ita.core.EmbaralhadorReverso;

public class FabricaEmbaralhadores {

	private ArrayList<Embaralhador> embaralhadores = new ArrayList<Embaralhador>();
	
	public Embaralhador getEmbaralhador(){
		embaralhadores.add(new EmbaralhadorAleatorio());
		embaralhadores.add(new EmbaralhadorReverso());
		Random r = new Random();
		return embaralhadores.get(r.nextInt(embaralhadores.size()));
	} 
	
}
