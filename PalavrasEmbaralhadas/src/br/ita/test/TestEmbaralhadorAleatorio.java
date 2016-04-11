package br.ita.test;

import org.junit.Test;
import static org.junit.Assert.*;

import br.ita.core.Embaralhador;
import br.ita.core.EmbaralhadorAleatorio;

public class TestEmbaralhadorAleatorio {

	@Test
	public void testDiferenteDoOriginal() {
		Embaralhador embaralhador = new EmbaralhadorAleatorio();
		assertNotEquals("matheus",embaralhador.embaralhar("matheus"));
	}

}
