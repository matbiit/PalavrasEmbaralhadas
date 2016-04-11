package br.ita.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;

import br.ita.model.Palavra;

public class BancoDePalavras {

	private final static String urlString = "http://www.palavras.net/palavras-aleatorias.php?fs=10&fs2=0&Submit=Nova+palavra";
	
	private static ArrayList<Palavra> palavras;
	
	public static String getPalavraAleatoria() throws IOException{
		
		
		if(palavras == null){
			palavras = gerarPalavrasAleatorias();
		} else if(saoTodasPalavrasLidas(palavras)) {
			palavras = gerarPalavrasAleatorias();
		}
		
		Random r = new Random();
		
		int numero;
		Palavra palavra;
		do{
			numero = r.nextInt(palavras.size());
			palavra = palavras.get(numero);
		} while(palavra.foiLida());
		
		palavra.descartar();
		
		return palavra.getNome();
	}
	
	public static boolean saoTodasPalavrasLidas(ArrayList<Palavra> palavras){
		
		for (Palavra palavra: palavras) {
			if(!palavra.foiLida()){
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<Palavra> gerarPalavrasAleatorias() throws IOException{
		
		ArrayList<Palavra> palavras = new ArrayList<Palavra>();
		
		URL url = new URL(urlString);
		URLConnection conexao;
		conexao = url.openConnection();
		conexao.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		InputStream is = conexao.getInputStream();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		String retorno;
		
		while((retorno=br.readLine()) != null) {
		    sb.append(retorno);   
		}

		br.close();
		String site = sb.toString();
		String[] palavrasDoSite = site.split("<div style=\"font-size:3em; color:#6200C5;\">");
		for (String palavra : palavrasDoSite) {
			if(palavra.contains("</div><br />")){
				palavra = palavra.replaceAll("</div><br />.*", "");
				if((!palavra.contains(" "))&&(!palavra.equals(" "))){
					Palavra p = new Palavra(palavra.toUpperCase());
					palavras.add(p);
				}
			}
		}		
		return palavras; 
		
	}
	
}
