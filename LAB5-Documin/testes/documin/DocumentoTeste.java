package documin;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoTeste {
	
	
	
	//Título em branco
	@Test
	public void cadastraDoc1() {
		try {
			Documento doc = new Documento("", 1);
			fail("Título inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
	
	//Tamanho inválido
	@Test
	public void cadastraDoc2() {
		try {
			Documento doc = new Documento("batata", 0);
			fail("Tamanho inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Tamanho inválido");
		}
	}
	
	//Documento sem limite de tamanho
	@Test
	public void cadastraDoc3() {
			Documento doc = new Documento("batata");
			 assertEquals("\nTítulo: batata" + "\nTamanho: 0\n", doc.toString() );
	}
	
	//Documento com limite de tamanho
	@Test
	public void cadastraDoc4() {
			Documento doc = new Documento("batata", 1);
			 assertEquals("\nTítulo: batata" + "\nTamanho: 1\n", doc.toString() );
	}
	
	
	
	//Cadastra documento sem tamanho 
	@Test
	public void cadastraDoc() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata");
		assertEquals("", doc.toString());
	}
	

}
