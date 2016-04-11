package br.ita.core;

import java.util.ArrayList;
import java.util.Random;

public class EmbaralhadorAleatorio implements Embaralhador {

	@Override
	public String embaralhar(String palavraAntiga) {
		
		ArrayList<Integer> numerosUsados = new ArrayList<Integer>();
		
		Random r = new Random();
		int numero;
		int cont = 0;
		StringBuilder palavra = new StringBuilder(palavraAntiga);
		StringBuilder palavraNova = new StringBuilder(palavraAntiga);
		
		while(cont < palavra.length()){
			
			do{
				numero = r.nextInt(palavra.length());
			} while(numerosUsados.contains(numero));
			numerosUsados.add(numero);
			palavraNova.setCharAt(cont++, palavra.charAt(numero));
		}
		
		return palavraNova.toString();
	}

}
