package documin;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class DocumentoTeste {
	
	
	
	//Título em branco
	@Test
	public void cadastraDoc1() {
		try {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("", 2);
			fail("Título inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
	
	//Tamanho inválido
	@Test
	public void cadastraDoc2() {
		try {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata", 0);
			fail("Tamanho inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Tamanho inválido");
		}
	}
	
	//Cadastra documento sem tamanho definido
	@Test
	public void cadastraDoc3() {
		DocumentoController doc = new DocumentoController();
		assertTrue(doc.criarDocumento("batata"));
	}
	
	//Documento com limite de tamanho
	@Test
	public void cadastraDoc4() {
			DocumentoController doc = new DocumentoController();
			 assertTrue(doc.criarDocumento("batata", 1));
	}
	
	//Dois documentos com mesmo título
	@Test
	public void cadastraDoc5() {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata", 1);
			assertFalse(doc.criarDocumento("batata", 1));
	}

	//Remove um documento
	@Test
	public void removeDocumento1() {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata", 1);
			doc.removeDocumento("batata");
			assertTrue(doc.criarDocumento("batata", 1));
	}
	
	//Remove um documento que não existe
	@Test
	public void removeDocumento2() {
		try {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata", 1);
			doc.removeDocumento("cenoura");
			fail("Argumento inválido");
		} catch (NoSuchElementException erro) {}
	}
	
	
	//Conta elementos de um documento sem elementos
	@Test
	public void contaElementos1() {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata");
			assertEquals(0, doc.numElementos("batata"));
	}
	
	//Conta elementos de um documento sem elementos
	@Test
	public void contaElementos2() {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata", 2);
			assertEquals(2, doc.numElementos("batata"));
	}
	
	//Conta elementos de um documento que não existe
	@Test
	public void contaElementos3() {
		try {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata");
			doc.numElementos("beterraba");
			fail("Argumento inválido");
		} catch (NoSuchElementException erro) {}
	}
	
	
}
