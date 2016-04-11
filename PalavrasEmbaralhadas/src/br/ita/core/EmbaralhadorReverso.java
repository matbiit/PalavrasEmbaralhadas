package br.ita.core;

public class EmbaralhadorReverso implements Embaralhador {

	@Override
	public String embaralhar(String palavraAntiga) {
		StringBuilder sb = new StringBuilder(palavraAntiga);
		return sb.reverse().toString();
	}

}
