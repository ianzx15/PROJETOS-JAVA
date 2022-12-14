package documin;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class DocumentoTeste {
	/**
	 * Não entendi o elemento texto, não possui nenhuma propriedade?
	 * é possível so passar um valor nulo para não ter representacao?
	 * 
	 * 
	 * Como é possível criar um método abstrato na super classe qual a necessidade de uma interface?
	 */
	
	
	//FAZER MAIS TESTES NULOS


	//Título nulo
	@Test
	public void cadastraDoc55() {
		try {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento(null, 2);
			fail("Título nulo");
		} catch (NullPointerException erro) {}
		}
	
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
	
	//Conta elementos de um documento com dois elementos
	@Test
	public void contaElementos2() {
			DocumentoController doc = new DocumentoController();
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
	
	//Testando a criação do elemento texto
	@Test
	public void criaTexto1() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarTexto("batata", "legume", 3);
		assertEquals(1, doc.criarTexto("batata", "detentor dos meios de produção", 1 ));
		
	}
	
	//Testando a criação do elemento título
	@Test
	public void criaTitulo1() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarTitulo("batata", "legume", 3, 1, false);
		assertEquals(1, doc.criarTitulo("batata", "detentor dos meios de produção", 1 , 2, false));
		
	}
	
	//Testando a criação do elemento lista
	@Test
	public void criaLista1() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarLista("batata", "legume", 3, "/", "-");
		assertEquals(1, doc.criarLista("batata", "detentor dos meios de produção", 1 , "*", "$"));
		
	}
	
	//Testando a criação do elemento termos
	@Test
	public void criaTermos1() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarLista("batata", "legume", 3, "/", "TAMANHO");
		assertEquals(1, doc.criarLista("batata", "detentor dos meios de produção", 1 , "*", "NENHUM"));
		
	}
	
	//Testando a criação de elementos de todos os tipos em um único documento
	@Test
	public void criaTodosElementos() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarLista("batata", "legume", 3, "/", "TAMANHO");
		doc.criarTexto("batata", "A receita pede pelo menos...", 1);
		doc.criarTitulo("batata", "Início", 0, 0, false);
		doc.criarTermos("batata", "receitas práticas", 2, "/", "NENHUMA");
		assertEquals(4, doc.criarLista("batata", "detentor dos meios de produção", 1 , "*", "NENHUM"));
		
	}
	
	
	//Pegando representação completa de texto
	@Test
	public void representacaoCompleta1() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarTexto("batata", "legume", 3);
		assertEquals("legume", doc.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de título linkavel
	@Test
	public void representacaoCompleta2() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals("1. titulo1 titulo2--\n"
				+ "1-TITULO1TITULO2", doc.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de título não linkavel
	@Test
	public void representacaoCompleta3() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarTitulo("batata", "titulo1", 2, 1, false);
		assertEquals("1. titulo1", doc.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de lista
	@Test
	public void representacaoCompleta4() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarLista("batata", "a/b/c", 2, "/", "$");
		assertEquals("-a\n"
				+ "-b\n"
				+ "-c\n", doc.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de termos
	@Test
	public void representacaoCompleta5() {
		DocumentoController doc = new DocumentoController();
		doc.criarDocumento("batata", 2);
		doc.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		assertEquals("Total termos: 3\n"
				+ "- legume, verdura, cereal", doc.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	
	
}
