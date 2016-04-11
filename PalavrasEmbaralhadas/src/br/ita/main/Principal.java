package br.ita.main;

import java.io.IOException;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Other;

import br.ita.core.EmbaralhadorAleatorio;
import br.ita.core.EmbaralhadorReverso;
import br.ita.core.MecanicaDoJogo;
import br.ita.core.TipoDeJogo;
import br.ita.factory.FabricaMecanicaDoJogo;
import br.ita.util.BancoDePalavras;

public class Principal {

	public static void main(String[] args) {
		
		cabecalho();
		
		MecanicaDoJogo mecanicaDeJogo = null;
		FabricaMecanicaDoJogo fabricaMecanica = new FabricaMecanicaDoJogo();
		int tipo = menuTipoDeJogo();
		boolean opcaoInvalida = true;
		
		while(opcaoInvalida){
			switch(tipo){
				case 1:
					mecanicaDeJogo = fabricaMecanica.getMecanicaDoJogo(TipoDeJogo.MORTE_SUBITA);
					opcaoInvalida = false;
					break;
				case 2:
					mecanicaDeJogo = fabricaMecanica.getMecanicaDoJogo(TipoDeJogo.DEZ_PALAVRAS);
					opcaoInvalida = false;
					break;
				default:
					System.out.println("Opção inválida! Tente novamente!");
					tipo = escolherTipoDeJogo();
					break;
			}
		}
		
		while(!mecanicaDeJogo.fimDeJogo()){
			menuAdivinharPalavra();
			try {
				System.out.println(mecanicaDeJogo.getPalavra());
				System.out.println();
				System.out.println("A palavra embaralhada é: ");
				Scanner in = new Scanner(System.in);
				mecanicaDeJogo.validarPalavra(in.nextLine());
	
			} catch (IOException ioe) {
				System.out.println("Error ao gerar palavra aleatória! Verifique a conexão com a internet!");
			}
		}
		
		System.out.println();
		System.out.println("TOTAL DE PONTOS: " + mecanicaDeJogo.getTotalDePontos());
		
		

	}

	private static void menuAdivinharPalavra() {
		System.out.println("##################################");
		System.out.println();
		System.out.println("Tente adivinhar a palavra abaixo: ");
		System.out.println();
	}

	private static int menuTipoDeJogo() {
		System.out.println();
		System.out.println("Escolha o tipo de Jogo: ");
		System.out.println("1- Morte Súbita");
		System.out.println("2- Dez Palavras");
		return escolherTipoDeJogo();
	}

	private static int escolherTipoDeJogo() {
		System.out.println();
		System.out.println();
		System.out.print("Digite o número desejado: ");
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}

	private static void cabecalho() {
		System.out.println("##################################");
		System.out.println("# JOGO DAS PALAVRAS EMBARALHADAS #");
		System.out.println("##################################");
		System.out.println();
	}
	
}
