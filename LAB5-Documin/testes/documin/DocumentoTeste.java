package documin;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DocumentoTeste {
	
	
	//Título em branco
	@Test
	void construtorDocumento1() {
		try {
			Documento doc = new Documento("", 1);
			fail("Título inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
	
	//Tamanho inválido
	@Test
	void construtorDocumento2() {
		try {
			Documento doc = new Documento("batata", 0);
			fail("Tamanho inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Tamanho inválido");
		}
	}
	
	//Documento sem limite de tamanho
	@Test
	void construtorDocumento3() {
			Documento doc = new Documento("batata");
			 assertEquals("\nTítulo: batata" + "\nTamanho: 0\n", doc.toString() );
	}
	
	

}
