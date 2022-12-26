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
		fac.criarDocumento("batata");
	}

	//Título nulo
	@Test
	 void cadastraDoc6() {
		try {
			fac.criarDocumento(null, 2);
			fail("Título nulo");
		} catch (NullPointerException erro) {}
		}
	
	//Título vazio
	@Test
	 void cadastraDoc1() {
		try {
			fac.criarDocumento("", 2);
			fail("Título inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
	
	//Tamanho inválido
	@Test
	 void cadastraDoc2() {
		try {
			fac.criarDocumento("batata2", 0);
			fail("Tamanho inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Tamanho inválido");
		}
	}
	
	//Cadastra documento sem tamanho definido
	@Test
	 void cadastraDoc3() {
		assertTrue(fac.criarDocumento("batata2"));
	}
	
	//Documento com limite de tamanho
	@Test
	 void cadastraDoc4() {
			 assertTrue(fac.criarDocumento("batata1", 1));
	}
	
	//Dois documentos com mesmo título
	@Test
	 void cadastraDoc5() {
			fac.criarDocumento("legume");
			assertFalse(fac.criarDocumento("legume"));
	}

	//Título em branco
	@Test
	 void cadastraDoc7() {
		try {
			fac.criarDocumento("  ", 2);
			fail("Título inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
	
	//Exibe um documento
	@Test
	 void exibeDocumento1() {
			fac.criarDocumento("legume", 3);
			fac.criarTitulo("legume", "teste", 2, 3, false);
			fac.criarTexto("legume", "valor", 1);
			assertEquals(2, fac.exibirDocumento("legume").length);
	}
	
	//Exibe um documento com titulo vazio
	@Test
	 void exibeDocumento2() {
		try {
			fac.criarDocumento("legume", 3);
			fac.criarTitulo("legume", "teste", 2, 3, false);
			fac.criarTexto("legume", "valor", 1);
			fac.exibirDocumento("  ");
			fail("Título inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
	
	//Exibe um documento com titulo nulo
	@Test
	 void exibeDocumento3() {
		try {
			fac.criarDocumento("legume", 3);
			fac.criarTitulo("legume", "teste", 2, 3, false);
			fac.criarTexto("legume", "valor", 1);
			fac.exibirDocumento(null);
			fail("Título nulo");
		} catch (NullPointerException erro) {
			assertEquals(erro.getMessage(), "Título nulo");
		}
	}
	
	
	//Remove um documento
	@Test
	 void removeDocumento1() {
			fac.removerDocumento("batata");
			assertTrue(fac.criarDocumento("batata", 1));
	}
	
	//Remove um documento que não existe
	@Test
	 void removeDocumento2() {
		try {
			fac.criarDocumento("batata", 1);
			fac.removerDocumento("cenoura");
			fail("Argumento inválido");
		} catch (NoSuchElementException erro) {}
	}
	
	//Remove documento com título em branco
	@Test
	 void removeDocumento3() {
		try {
			fac.removerDocumento("  ");
			fail("Título inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
	
	//Remove documento nulo
	@Test
	 void removeDocumento4() {
		try {
			fac.removerDocumento(null);
			fail("Título nulo");
		} catch (NullPointerException erro) {
			assertEquals(erro.getMessage(), "Título nulo");
		}
	}
	
	
	//Conta elementos de um documento sem elementos
	@Test
	 void contaElementos1() {
			assertEquals(0, fac.contarElementos("batata"));
	}
	
	
	//Conta elementos de um documento 
	@Test
	 void contaElementos2() {
			fac.criarDocumento("batata", 3);
			fac.criarTexto("batata", "A receita pede pelo menos...", 1);
			fac.criarTexto("batata", "dessa vez usaremos apenas...", 2);
			fac.criarTermos("batata", "receitas/práticas", 2, "/", "NENHUMA");
			assertEquals(3, fac.contarElementos("batata"));
	}
	
	//Conta elementos de um documento que não existe
	@Test
	 void contaElementos3() {
		try {
			fac.contarElementos("beterraba");
			fail("Argumento inválido");
		} catch (NoSuchElementException erro) {}
	}
	
	//Contando elementos de um documento nulo
	@Test
	 void contaElementos4() {
		try {
			fac.contarElementos(null);
			fail("Título nulo");
		} catch (NullPointerException erro) {
			assertEquals(erro.getMessage(), "Título nulo");
		}
	}
	
	//Contando elementos de um documento com título em branco
	@Test
	 void contaElementos5() {
		try {
			fac.contarElementos("   ");
			fail("Título inválido");
		} catch (IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}	
	
	
	//Testando a criação do elemento texto
	@Test
	void criaTexto1() {
		assertEquals(0, fac.criarTexto("batata", "detentor dos meios de produção", 1 ));
		
	}
	
	//Testando a criação do elemento título
	@Test
	 void criaTitulo1() {
		assertEquals(0, fac.criarTitulo("batata", "detentor dos meios de produção", 1 , 2, false));
		
	}
	
	//Testando a criação do elemento lista
	@Test
	 void criaLista1() {
		assertEquals(0, fac.criarLista("batata", "detentor dos meios de produção", 1 , "*", "$"));
	}
	
	//Testando a criação do elemento Atalho
	@Test
	void criaAtalho1() {
		fac.criarDocumento("legume", 2);
		fac.criarTexto("batata", "aaaaa", 2);
		assertEquals(1, fac.criarAtalho("batata", "legume"));
	}
	
	//Testando a criação do elemento atalho de um elemento que já é atalho
	@Test
	void criaAtalho2() {
		fac.criarDocumento("legume", 2);
		fac.criarDocumento("verdura", 1);
		assertEquals(0, fac.criarAtalho("batata", "legume"));
		try{
			assertEquals(0, fac.criarAtalho("legume", "batata"));
			fail ("Elemento é um atalho");
		} catch (IllegalStateException erro) {}

	}
	
	//Testando a criação do elemento atalho de um elemento que possui um atalho
		@Test
		void criaAtalho3() {
			fac.criarDocumento("legume", 2);
			fac.criarDocumento("verdura", 1);
			assertEquals(0, fac.criarAtalho("batata", "legume"));
			try {
				assertEquals(0, fac.criarAtalho("verdura", "batata"));
				fail("Elemento já possui um atalho");
			} catch (IllegalStateException erro) {}
		}

	//Testando a criação de elementos de mesmo tipo
	@Test
	 void criaMesmoTipo() {
		fac.criarTexto("batata", "A receita pede pelo menos...", 1);
		fac.criarTexto("batata", "dessa vez usaremos apenas...", 2);
		fac.criarTermos("batata", "receitas/práticas", 2, "/", "NENHUMA");
		assertEquals("dessa vez usaremos apenas...\n", fac.pegarRepresentacaoResumida("batata", 1));
	}
	
	
	//Pegando representação completa de texto
	@Test
	 void representacaoCompleta1() {
		fac.criarTexto("batata", "legume", 3);
		assertEquals("legume\n", fac.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de título linkavel
	@Test
	 void representacaoCompleta2() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals("1. titulo1 titulo2--\n"
				+ "1-TITULO1TITULO2\n", fac.pegarRepresentacaoCompleta("batata", 0));
		
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
	
	//Pegando representação completa de termos sem ordenação
	@Test
	 void representacaoCompleta5() {
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		assertEquals("Total termos: 3\n"
				+ "- legume, verdura, cereal\n", fac.pegarRepresentacaoCompleta("batata", 0));
		
	}
	
	//Pegando representação completa de termos por tamanho
	@Test
	 void representacaoCompleta6() {
		fac.criarTermos("batata", "detentor/dos/meios/de produção", 1 , "/", "TAMANHO");
		assertEquals("Total termos: 5\n"
				+ "- de, dos, meios, detentor, produção\n", fac.pegarRepresentacaoCompleta("batata", 0));
		
	}
		
	//Pegando representação completa de termos por ordem alfabetica
	@Test
	 void representacaoCompleta7() {
		fac.criarTermos("batata", "detentor/dos/meios/de/produção", 1 , "/", "ALFABÉTICA");
		assertEquals("Total termos: 5\n"
				+ "- de, detentor, dos, meios, produção\n", fac.pegarRepresentacaoCompleta("batata", 0));
	}
	
	
	//Pegando representação resumida de lista
	@Test
	 void representacaoResumida1() {
		fac.criarLista("batata", "a/b/c", 2, "/", "$");
		assertEquals("a, b, c\n", fac.pegarRepresentacaoResumida("batata", 0));
		
	}
	
	//Pegando representação resumida de termos sem ordenação
	@Test
	 void representacaoResumida2() {
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		assertEquals("legume / verdura / cereal\n", fac.pegarRepresentacaoResumida("batata", 0));
	}
	
	//Pegando representação resumida de texto
	@Test
	 void representacaoResumida3() {
		fac.criarTexto("batata", "legume", 3);
		assertEquals("legume\n", fac.pegarRepresentacaoResumida("batata", 0));
		
	}
	
	//Pegando representação completa de título linkavel
	@Test
	 void representacaoResumida4() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals("1. titulo1 titulo2\n", fac.pegarRepresentacaoResumida("batata", 0));
		
	}
	
	//Pegando representação resumida de termos por tamanho
	@Test
	 void representacaoResumida5() {
		fac.criarTermos("batata", "legume/verdura/carne", 1, "/", "TAMANHO");
		assertEquals("carne / legume / verdura\n", fac.pegarRepresentacaoResumida("batata", 0));
	}
	
	//Pegando representação resumida de termos por ordem alfabetica
	@Test
	 void representacaoResumida6() {
		fac.criarTermos("batata", "legume/batata/carne", 1, "/", "ALFABÉTICA");
		assertEquals("batata / carne / legume\n", fac.pegarRepresentacaoResumida("batata", 0));
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
		assertEquals("1. titulo1 titulo2\n" ,fac.pegarRepresentacaoResumida("batata", 1));
		assertEquals("legume\n", fac.pegarRepresentacaoResumida("batata", 0));
	}
	
	//Movendo elemento para baixo
	@Test
	 void moverAbaixo1() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.moverParaBaixo("batata", 1);
		assertEquals("legume\n" ,fac.pegarRepresentacaoResumida("batata", 0));
		assertEquals("1. titulo1 titulo2\n", fac.pegarRepresentacaoResumida("batata", 1));
	}
	
	
	
	
	
	//Gerando visao completa de um documento
	@Test
	 void criarVisao1() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals(0, fac.criarVisaoCompleta("batata"));
		assertEquals(1, fac.criarVisaoResumida("batata"));
	}
	
	//Gerando visao resumida de um documento
	@Test
	 void criarVisao2() {
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals(0, fac.criarVisaoResumida("batata"));
	}
	
	//Gerando visao prioritária de um documento
	@Test
	void criarVisao3() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals(0, fac.criarVisaoPrioritaria("batata",2));
	}
	//Gerando visao dos títulos de um documento
	@Test
	void criarVisao4() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals(0, fac.criarVisaoTitulo("batata"));
	}
	
	//Gerando mais de uma visão de documento
	@Test
	void criarVisao5() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		assertEquals(0, fac.criarVisaoTitulo("batata"));
		assertEquals(1, fac.criarVisaoCompleta("batata"));
		assertEquals(2, fac.criarVisaoPrioritaria("batata", 1));
		assertEquals(3, fac.criarVisaoResumida("batata"));
	}
	
	//Gerando visão do titulo de um documento nulo
	@Test
	void criarVisao6() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		
		try{
			fac.criarVisaoTitulo(null);
			fail("Título nulo");
		} catch(NullPointerException erro) {
			assertEquals(erro.getMessage(), "Título nulo");
		}
	}
	
	//Gerando visão do título de um documento com nome em branco
	@Test
	void criarVisao7() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		try{
			fac.criarVisaoTitulo("  ");
			fail("Título inválido");
		} catch(IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
	
	//Gerando visão completa de um documento nulo
	@Test
	void criarVisao8() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		
		try{
			fac.criarVisaoCompleta(null);
			fail("Título nulo");
		} catch(NullPointerException erro) {
			assertEquals(erro.getMessage(), "Título nulo");
		}
	}
	
	//Gerando visão completa de um documento com nome em branco
	@Test
	void criarVisao9() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		try{
			fac.criarVisaoCompleta("  ");
			fail("Título inválido");
		} catch(IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
		
		
	//Gerando visão resumida de um documento nulo
	@Test
	void criarVisao10() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		
		try{
			fac.criarVisaoResumida(null);
			fail("Título nulo");
		} catch(NullPointerException erro) {
			assertEquals(erro.getMessage(), "Título nulo");
		}
	}
	
	//Gerando visão resumida de um documento com nome em branco
	@Test
	void criarVisao11() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		try{
			fac.criarVisaoResumida("  ");
			fail("Título inválido");
		} catch(IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}

	//Gerando visão prioritária de um documento nulo
	@Test
	void criarVisao12() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		
		try{
			fac.criarVisaoPrioritaria(null, 2);
			fail("Título nulo");
		} catch(NullPointerException erro) {
			assertEquals(erro.getMessage(), "Título nulo");
		}
	}
	
	//Gerando visão prioritária de um documento com nome em branco
	@Test
	void criarVisao13() {
		fac.criarTitulo("batata", "alface cenoura", 2, 1, true);
		fac.criarTexto("batata", "legume", 3);
		fac.criarTermos("batata", "legume/verdura/cereal", 1, "/", "NENHUM");
		fac.criarTitulo("batata", "titulo1 titulo2", 2, 1, true);
		try{
			fac.criarVisaoPrioritaria("  ", 3);
			fail("Título inválido");
		} catch(IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
		
	//Removendo elemento 
	@Test
	 void removeElemento1() {
		fac.criarTexto("batata", "A receita pede pelo menos...", 1);
		fac.criarTexto("batata", "dessa vez usaremos apenas...", 2);
		fac.criarTermos("batata", "receitas/práticas", 2, "/", "NENHUMA");
		fac.apagarElemento("batata", 1);
		assertEquals("receitas / práticas\n", fac.pegarRepresentacaoResumida("batata", 1));
	}
	
	//Removendo elemento de documento nulo
	@Test
	 void removeElemento2() {
	 try{ 
		 fac.criarTexto("batata", "A receita pede pelo menos...", 1);
		fac.criarTexto("batata", "dessa vez usaremos apenas...", 2);
		fac.criarTermos("batata", "receitas/práticas", 2, "/", "NENHUMA");
		fac.apagarElemento(null, 1);
		fail("Título nulo");
		} catch(NullPointerException erro) {
			assertEquals(erro.getMessage(), "Título nulo");
		}
	}
		
	//Removendo elemento de documento com título de espaços em branco
	@Test
	 void removeElemento3() {
	 try{ 
		 fac.criarTexto("batata", "A receita pede pelo menos...", 1);
		fac.criarTexto("batata", "dessa vez usaremos apenas...", 2);
		fac.criarTermos("batata", "receitas/práticas", 2, "/", "NENHUMA");
		fac.apagarElemento("  ", 1);
		fail("Título inválido");
		} catch(IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
	}
		
	//Removendo elemento de documento vazio
	@Test
	 void removeElemento4() {
	 try{ 
		 fac.criarTexto("batata", "A receita pede pelo menos...", 1);
		fac.criarTexto("batata", "dessa vez usaremos apenas...", 2);
		fac.criarTermos("batata", "receitas/práticas", 2, "/", "NENHUMA");
		fac.apagarElemento("", 1);
		fail("Título inválido");
		} catch(IllegalArgumentException erro) {
			assertEquals(erro.getMessage(), "Título inválido");
		}
		}
		
	//Exibindo representação completa de um atalho
	@Test
	void exibeAtalho1() {
		fac.criarDocumento("legume", 2);
		fac.criarLista("legume", "abacaxi/uva", 5, "/", "-");
		fac.criarTexto("legume", "texto", 4);
		fac.criarTexto("legume", "teste", 2);
		fac.criarAtalho("batata", "legume");
		assertEquals("-abacaxi\n"
				+ "-uva\n"
				+ "texto\n",fac.pegarRepresentacaoCompleta("batata", 0));
	}
	//Exibindo representação resumida de um atalho
	@Test
	void exibeAtalho2() {
		fac.criarDocumento("legume", 2);
		fac.criarLista("legume", "abacaxi/uva", 5, "/", "-");
		fac.criarTexto("legume", "texto", 4);
		fac.criarTexto("legume", "teste", 2);
		fac.criarAtalho("batata", "legume");
		assertEquals("abacaxi, uva\n"
				+ "texto\n", fac.pegarRepresentacaoResumida("batata", 0));
	}

}
