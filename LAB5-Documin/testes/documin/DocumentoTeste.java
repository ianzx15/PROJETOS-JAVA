package documin;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoTeste {
	private Facade fac = new Facade();
	@BeforeEach
	void preparacao() {
		fac.criarDocumento("batata", 2);
	}
	
	//FAZER MAIS TESTES NULOS


	//Título nulo
	@Test
	 void cadastraDoc6() {
		try {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento(null, 2);
			fail("Título nulo");
		} catch (NullPointerException erro) {}
		}
	
	//Título em branco
	@Test
	 void cadastraDoc1() {
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
	 void cadastraDoc2() {
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
	 void cadastraDoc3() {
		DocumentoController doc = new DocumentoController();
		assertTrue(doc.criarDocumento("batata"));
	}
	
	//Documento com limite de tamanho
	@Test
	 void cadastraDoc4() {
			DocumentoController doc = new DocumentoController();
			 assertTrue(doc.criarDocumento("batata", 1));
	}
	
	//Dois documentos com mesmo título
	@Test
	 void cadastraDoc5() {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata", 1);
			assertFalse(doc.criarDocumento("batata", 1));
	}

	//Remove um documento
	@Test
	 void removeDocumento1() {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata", 1);
			doc.removeDocumento("batata");
			assertTrue(doc.criarDocumento("batata", 1));
	}
	
	//Remove um documento que não existe
	@Test
	 void removeDocumento2() {
		try {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata", 1);
			doc.removeDocumento("cenoura");
			fail("Argumento inválido");
		} catch (NoSuchElementException erro) {}
	}
	
	
	//Conta elementos de um documento sem elementos
	@Test
	 void contaElementos1() {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata");
			assertEquals(0, doc.numElementos("batata"));
	}
	
	//Conta elementos de um documento com dois elementos
	@Test
	 void contaElementos2() {
			DocumentoController doc = new DocumentoController();
	}
	
	//Conta elementos de um documento que não existe
	@Test
	 void contaElementos3() {
		try {
			DocumentoController doc = new DocumentoController();
			doc.criarDocumento("batata");
			doc.numElementos("beterraba");
			fail("Argumento inválido");
		} catch (NoSuchElementException erro) {}
	}
	
	//Testando a criação do elemento texto
	@Test
	void criaTexto1() {
		fac.criarTexto("batata", "legume", 3);
		assertEquals(1, fac.criarTexto("batata", "detentor dos meios de produção", 1 ));
		
	}
	
	//Testando a criação do elemento título
	@Test
	 void criaTitulo1() {
		fac.criarTitulo("batata", "legume", 3, 1, false);
		assertEquals(1, fac.criarTitulo("batata", "detentor dos meios de produção", 1 , 2, false));
		
	}
	
	//Testando a criação do elemento lista
	@Test
	 void criaLista1() {
		fac.criarLista("batata", "legume", 3, "/", "-");
		assertEquals(1, fac.criarLista("batata", "detentor dos meios de produção", 1 , "*", "$"));
		
	}
	
	//Testando a criação do elemento termos sem ordenação
	@Test
	 void criaTermos1() {
		fac.criarTermos("batata", "detentor dos meios de produção", 1 , "/", "NENHUMA");
		assertEquals("detentor / dos / meios / de / produção", fac.pegarRepresentacaoCompleta("batata", 0));
	}
	
	//Testando a criação do elemento termos ordenados por tamanho
	@Test
	 void criaTermos2() {
		fac.criarTermos("batata", "detentor dos meios de produção", 1 , "/", "TAMANHO");
		assertEquals("de / dos / meios / detentor / produção", fac.pegarRepresentacaoResumida("batata", 0));
		
	}
	
	//Testando a criação de elementos de todos os tipos em um único documento
	@Test
	 void criaTodosElementos() {
		fac.criarLista("batata", "legume", 3, "/", "TAMANHO");
		fac.criarTexto("batata", "A receita pede pelo menos...", 1);
		fac.criarTitulo("batata", "Início", 0, 0, false);
		fac.criarTermos("batata", "receitas práticas", 2, "/", "NENHUMA");
		assertEquals(4, fac.criarLista("batata", "detentor dos meios de produção", 1 , "*", "NENHUM"));
		
	}
	
	
	//Pegando representação completa de texto
	@Test
	 void representacaoCompleta1() {
		fac.criarTexto("batata", "legume", 3);
		assertEquals("legume", fac.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de título linkavel
	@Test
	 void representacaoCompleta2() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals("1. titulo1 titulo2--\n"
				+ "1-TITULO1TITULO2", fac.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de título não linkavel
	@Test
	 void representacaoCompleta3() {
		fac.criarTitulo("batata", "titulo1", 2, 1, false);
		assertEquals("1. titulo1", fac.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de lista
	@Test
	 void representacaoCompleta4() {
		fac.criarLista("batata", "a/b/c", 2, "/", "$");
		assertEquals("-a\n"
				+ "-b\n"
				+ "-c\n", fac.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de termos
	@Test
	 void representacaoCompleta5() {
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		assertEquals("Total termos: 3\n"
				+ "- legume, verdura, cereal", fac.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	
	//Pegando representação resumida de lista
	@Test
	 void representacaoResumida1() {
		Facade fac = new Facade();
		fac.criarDocumento("batata", 2);
		fac.criarLista("batata", "a/b/c", 2, "/", "$");
		assertEquals("a, b, c", fac.pegarRepresentacaoResumida("batata", 0));
		
	}
	
	//Pegando representação resumida de termos
	@Test
	 void representacaoResumida2() {
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		assertEquals("legume / verdura / cereal", fac.pegarRepresentacaoResumida("batata", 0));
		
	}
	
	//Pegando representação resumida de texto
	@Test
	 void representacaoResumida3() {
		fac.criarTexto("batata", "legume", 3);
		assertEquals("legume", fac.pegarRepresentacaoResumida("batata", 0));
		
	}
	
	//Pegando representação completa de título linkavel
	@Test
	 void representacaoResumida4() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals("1. titulo1 titulo2", fac.pegarRepresentacaoResumida("batata", 0));
		
	}
	
	//Removendo elemento 
	@Test
	 void apagarElemento1() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertTrue(fac.apagarElemento("batata", 0));
	}
	//Movendo elemento para cima
	@Test
	 void moverAcima1() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.moverParaCima("batata", 0);
		assertEquals("1. titulo1 titulo2" ,fac.pegarRepresentacaoResumida("batata", 1));
		assertEquals("legume", fac.pegarRepresentacaoResumida("batata", 0));
	}
	
	//Movendo elemento para baixo
	@Test
	 void moverAbaixo1() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.moverParaBaixo("batata", 1);
		assertEquals("legume" ,fac.pegarRepresentacaoResumida("batata", 0));
		assertEquals("1. titulo1 titulo2", fac.pegarRepresentacaoResumida("batata", 1));
	}
	
}
