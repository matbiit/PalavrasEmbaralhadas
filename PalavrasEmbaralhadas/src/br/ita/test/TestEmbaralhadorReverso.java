package br.ita.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ita.core.Embaralhador;
import br.ita.core.EmbaralhadorReverso;

public class TestEmbaralhadorReverso {

	Embaralhador embaralhador;
	
	@Before
	public void inicializar(){
		embaralhador = new EmbaralhadorReverso();
	}
	
	@Test
	public void testReverso() {
		assertEquals("ati", embaralhador.embaralhar("ita"));
	}
	
	@Test
	public void testReversoFalho() {
		assertNotEquals("atii", embaralhador.embaralhar("ita"));
	}

}
